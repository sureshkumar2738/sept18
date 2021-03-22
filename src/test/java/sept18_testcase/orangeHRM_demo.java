package sept18_testcase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class orangeHRM_demo {
	
	public static String url ="https://opensource-demo.orangehrmlive.com/index.php/auth/login";

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		driver.get(url);
		
		Thread.sleep(5000);
		
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//span[contains(text(),'My Timesheet')]")).click();
		
		Thread.sleep(5000);
		
		driver.navigate().back();
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//*[@id=\"welcome\"]")).click();
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//*[@id=\"welcome-menu\"]/ul/li[2]/a")).click();
		
		Thread.sleep(2000);
		
		driver.quit();

	}

}
