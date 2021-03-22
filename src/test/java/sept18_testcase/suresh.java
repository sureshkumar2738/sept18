package sept18_testcase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class suresh {

	public static WebDriver driver;
	
	public static String url = "https://qa4.phoenix.ead.metlife.com/edge/web/public/uslogin?accessType=employer";
	
	public static void main(String[] args) {
	
		WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver();
		
		driver.get(url);
		
		driver.findElement(By.xpath("//input[@id='userNameId']")).sendKeys("managerqa13@ml.com");
		
		driver.findElement(By.id("passwordId")).sendKeys("234");
		
		driver.findElement(By.xpath("//*[@id=\"phoenix_Login_0\"]/form/button")).click();

        driver.quit();
        
	}

}
