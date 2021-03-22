package pom_testcases;


import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pom_pages.homepage;
import pom_pages.loginpage;
import pom_testbase.test_Base;

public class loginpage_testcases extends test_Base {

	loginpage  loginPage;
	homepage  homePage;
	
	
	public loginpage_testcases() throws IOException {
		super();
		
	}
		@BeforeMethod
		public void setup() throws IOException {
			
			inilization();
			
			loginPage = new loginpage();
		
		}
		
		@Test(priority = 1)
		public void validatepagetitle() {
			
			String actualPageTitle = loginPage.ValidatePageTitle();
			
			Assert.assertEquals(actualPageTitle, "Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!");
			
		}
		
		@Test(priority = 2)
		public void validatelogo() {
			
			boolean flag = loginPage.ValidateLogo();
			Assert.assertTrue(flag, "logo is missing");
		}
		
		@Test(priority = 3)
		public void doLogin() throws InterruptedException, IOException {
			
			homePage = loginPage.dologin(prop.getProperty("username"), prop.getProperty("password"));
		}
		
		
		@AfterMethod
		public void teardown() {
			
			driver.quit();
		}
		
}
