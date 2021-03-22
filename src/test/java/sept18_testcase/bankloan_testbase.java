package sept18_testcase;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import test_base.bank_test_base;

public class bankloan_testbase extends bank_test_base {

	public bankloan_testbase() throws IOException {
		super();
		
	}
		
		@BeforeMethod
		public void startbrowser() {
			inilization();
	}
		
		@Test
		public void calculate() {
			
			try {
				
				driver.findElement(By.xpath(prop.getProperty("loan_amount"))).clear();
				driver.findElement(By.xpath(prop.getProperty("loan_amount"))).sendKeys("7000");
				
				Thread.sleep(3000);
				
		        driver.findElement(By.xpath(prop.getProperty("term_in_years"))).clear();
				driver.findElement(By.xpath(prop.getProperty("term_in_years"))).sendKeys("7");
				
				Thread.sleep(3000);
				
	            driver.findElement(By.xpath(prop.getProperty("term_in_months"))).clear();
				driver.findElement(By.xpath(prop.getProperty("term_in_months"))).sendKeys("80");
				
				Thread.sleep(4000);
				
		        driver.findElement(By.xpath(prop.getProperty("interest"))).clear();
				driver.findElement(By.xpath(prop.getProperty("interest"))).sendKeys("6.6");
				
				Thread.sleep(5000);
				
				driver.findElement(By.xpath(prop.getProperty("calculate"))).click();
				
				Thread.sleep(5000);
				
				iwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("txt_actual_amount"))));
				
				ActualMonthlyPayment = driver.findElement(By.xpath(prop.getProperty("txt_actual_amount"))).getText();
				
				System.out.println("Actual  monthly payment is --->"+ActualMonthlyPayment);
				
				ExpectedmonthlyPayment="$ 108.39";
				
				
				Assert.assertEquals(ActualMonthlyPayment, ExpectedmonthlyPayment);
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		@AfterMethod
		public void closebrowser() {
			driver.quit();
		}

}
