package sept18_testcase;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class multiple_checkboxes {
	
	public static WebDriver driver;
	
	public static String url ="http://www.tizag.com/htmlT/htmlcheckboxes.php";

	public static void main(String[] args) throws InterruptedException {
		
		
		WebDriverManager.firefoxdriver().setup();
		
		driver = new FirefoxDriver();
		
		driver.manage().window().maximize();
		
		driver.get(url);
		
		Thread.sleep(3000);
		
		List<WebElement> checkboxes = driver.findElements(By.name("sports"));
		
		System.out.println("total checkboxes ="+checkboxes.size());
		
		System.out.println(checkboxes.get(5).getAttribute("value"));
		
		for(int i=0;i<checkboxes.size();i++) {
			checkboxes.get(i).click();
		}
		
		System.out.println(checkboxes.get(0).getAttribute("checked"));
		
		Thread.sleep(6000);
		
		
		driver.quit();

	}

}
