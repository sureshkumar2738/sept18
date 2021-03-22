package sept18_testcase;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class facebook_multiple_dropdown {

	public static WebDriver driver;
	
	public static String url = "https://www.facebook.com/";
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.firefoxdriver().setup();
		
		driver = new FirefoxDriver();
		
		driver.get(url);
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//*[@id=\"u_0_2\"]")).click();
		
		Thread.sleep(2000);
		
		//WebElement month = driver.findElement(By.xpath("//*[@id=\"month\"]"));
		WebElement year = driver.findElement(By.xpath("//*[@id=\"year\"]"));
		//WebElement day = driver.findElement(By.xpath("//*[@id=\"day\"]"));
		
		Select se = new Select(year);
		se.selectByIndex(28);
		
		List<WebElement> dropdownoptions = year.findElements(By.tagName("option"));
		
		
		System.out.println("total number of options ="+dropdownoptions.size());
		System.out.println(dropdownoptions.get(0).getText());
		
		for(int i=0;i<dropdownoptions.size();i++)
		{
			System.out.println(i+"."+dropdownoptions.get(i).getText());
		}
		
		Thread.sleep(3000);
		
		driver.quit();
		
	}

}
