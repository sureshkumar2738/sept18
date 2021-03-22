package sept18_testcase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class downloadfile {

	public static WebDriver driver;
	
	public static String url = "http://demo.guru99.com/test/yahoo.html";
	
	public static void main(String[] args) {
	
		WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver();
		
		driver.get(url);
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		WebElement downloadfile = driver.findElement(By.id("messenger-download"));
		
		downloadfile.click();
		
		driver.quit();

	}

}
