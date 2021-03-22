package sept18_testcase;

import org.apache.commons.codec.binary.Base64;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class fb_formfilling {
	
	public static String url = "https://www.facebook.com/";

	public static void main(String[] args) throws InterruptedException{

		WebDriverManager.chromedriver().setup();
		 
		 WebDriver driver = new ChromeDriver();
		
		 driver.get(url);
		
		driver.findElement(By.linkText("Create New Account")).click();
		
	    Thread.sleep(5000);
	    
	    driver.findElement(By.id("u_1_b")).sendKeys("suresh");
	    
	    Thread.sleep(3000);
	    
	    driver.findElement(By.id("u_1_d")).sendKeys("kumar");
	    
	    Thread.sleep(2000);
		
	    driver.findElement(By.id("u_1_g")).sendKeys("testlogin");
	    
	    Thread.sleep(2000);
	    
	    driver.findElement(By.id("password_step_input")).sendKeys(decodedString("dGVzdHBhc3N3b3Jk"));
	    
	    Thread.sleep(2000);
	    
	    String ActualpageTitle = driver.getTitle();
	    
	    System.out.println("title="+ActualpageTitle);
	    
	    String ExpectedpageTitle ="Facebook-log in or sign up";
	    
	    if(ActualpageTitle.equalsIgnoreCase(ExpectedpageTitle))
	    {
	    	System.out.println("true");
	    }else
	    {
	    	System.out.println("false");
	    }
	    
	    Select select = new Select(driver.findElement(By.id("day")));
	    select.selectByVisibleText("12");
	    
	    Select select1 = new Select(driver.findElement(By.id("month")));
	    select1.selectByVisibleText("Dec");
	    
	    Select select2 = new Select(driver.findElement(By.id("year")));
	    select2.selectByVisibleText("1993");
	    
	    Thread.sleep(5000);
	    
	    driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/div/div[2]/div/div/div[1]/form/div[1]/div[7]/span/span[2]/label")).click();
		
	    Thread.sleep(5000);
	    
	    driver.findElement(By.id("u_1_s")).click();
	    
	    Thread.sleep(5000);
	    
	    driver.quit();
		
	}
		
		public static String decodedString(String Stringpassword)
		
		{
		
		byte[] decodedString = Base64.decodeBase64(Stringpassword);
		
		return(new String(decodedString));
		
	}

}
