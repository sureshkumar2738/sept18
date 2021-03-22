package pom_testcases;

import java.io.IOException;

import org.apache.commons.compress.archivers.dump.InvalidFormatException;
import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pom_pages.homepage;
import pom_pages.loginpage;
import pom_pages.profilepage;
import pom_testbase.test_Base;
import pom_util.test_utility;

public class profilepage_testcases extends test_Base {
	
    profilepage profilepage;
	
	homepage homepage;
	
	loginpage loginpage;

	public static String SheetName = "data";
	
	public profilepage_testcases() throws IOException {
		super();
	
	}

	@BeforeMethod
	public void setup() throws IOException, InterruptedException {
		
		inilization();
		
		loginpage = new loginpage();
		
		homepage = loginpage.dologin(prop.getProperty("username"), prop.getProperty("password"));
		
		homepage = new homepage();
		
		homepage.clickOnUserName();
		
		profilepage = new profilepage();
	}
	
	@Test(priority = 7) 
	public void validateProfilePageTitletest() {
		
	String actualpagetitle = profilepage.validateProfilePageTitle();
	String ExpectedPageTitle = "Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!";
	Assert.assertEquals(actualpagetitle, ExpectedPageTitle);
	
	}
	
	@DataProvider
	public Object [][]getTestdata() throws EncryptedDocumentException, InvalidFormatException, IOException{
		
		Object [][] data = test_utility.getTestData(SheetName);
		return data;
	}

	@Test(priority = 8,dataProvider = "getTestdata")
	public void getData(String name,String phone,String pincode,String locality,String address,String city,String state) throws InterruptedException {
		
		profilepage.clickonManageAddresses();
		profilepage.clickAddnewaddress();
		profilepage.createnewaddress(name, phone, pincode, locality, address, city, state);
		
	}
	
	@AfterMethod
	public void closebrowser() {
		
		driver.quit();
	}
}

