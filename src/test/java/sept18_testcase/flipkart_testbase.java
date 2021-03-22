package sept18_testcase;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import test_base.first_test_base;

public class flipkart_testbase extends first_test_base{

	public flipkart_testbase() throws IOException {
		super();
	}
		
		@BeforeMethod
		public void setup() {
			System.out.println("inilization");
		}
		
		@Test
		public void signin() {
			
			try {
				Thread.sleep(5000);
				
				driver.findElement(By.xpath(prop.getProperty("signin"))).click();
				
				Thread.sleep(5000);
				
				driver.findElement(By.xpath(prop.getProperty("username"))).sendKeys("9493977338");
				
				driver.findElement(By.xpath(prop.getProperty("password"))).sendKeys("test987");
				
				Thread.sleep(5000);
				
				driver.findElement(By.xpath(prop.getProperty("login"))).click();
				
				Thread.sleep(5000);
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		@AfterMethod
		public void close() {
			driver.quit();
		}

}
