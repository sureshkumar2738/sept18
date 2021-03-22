package pom_testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pom_pages.homepage;
import pom_pages.loginpage;
import pom_pages.profilepage;
import pom_testbase.test_Base;

public class homepage_testcases extends test_Base{

	profilepage profilepage;
	
	homepage homepage;
	
	loginpage loginpage;
	
	public homepage_testcases() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	@BeforeMethod
	public void setup() throws InterruptedException, IOException {
		inilization();
		loginpage = new loginpage();
		homepage = new homepage();
		homepage = loginpage.dologin(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	@Test(priority = 4)
	public void homepageValidatePageTitleTest() {
		
		String actualpagetitle = homepage.ValidatePageTitle();
		Assert.assertEquals(actualpagetitle, "Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!");
	}
	
	@Test(priority = 5)
	public void homepagevalidatelogotest() {
		
		boolean flag = homepage.Validatelogo();
	}
	
	@Test(priority = 6)
	public void profilepagevalidatetitletest() {
		
		String actualtitle = homepage.getUsername();
		Assert.assertEquals(actualtitle, "suresh");
	}
	
	@AfterMethod
	public void closebrowser() {
		driver.quit();
	}
}
