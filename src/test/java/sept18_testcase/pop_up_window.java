package sept18_testcase;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class pop_up_window {

	public static String url = "https://www.rediff.com/";
	
	public static void main(String[] args) throws InterruptedException {	
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		driver.get(url);
		
		driver.findElement(By.xpath("//a[@class='signin']")).click();
		
		Thread.sleep(5000);
		
		driver.findElement(By.id("login1")).sendKeys("");
		
		Thread.sleep(2000);
		
		driver.findElement(By.id("password")).sendKeys("");
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//input[@name='proceed']")).click();
		
		Thread.sleep(3000);
		
		Alert alert = driver.switchTo().alert();
		
		alert.accept();
		
		Thread.sleep(5000);
		
		driver.switchTo().defaultContent();
		
		Thread.sleep(3000);
		
		driver.quit();

	}

}
