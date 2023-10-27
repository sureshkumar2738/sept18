package sept18_testcase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class jquary_uiframe {
	
	public static String url ="https://jqueryui.com/autocomplete/";

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get(url);
		
		Thread.sleep(3000);
		
		driver.switchTo().frame(0);
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//*[@id=\"tags\"]")).sendKeys("suresh");
		
		Thread.sleep(2000);
		
		driver.switchTo().defaultContent();
		
		Thread.sleep(2000);
		
		driver.quit();
	

	}

}
