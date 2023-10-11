package sept18_testcase;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class wikipedia_multiple_dropdown {
	
public static WebDriver driver;
	
	public static String url = "https://www.wikipedia.org/";

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get(url);
		
		Thread.sleep(5000);
		
		WebElement lang = driver.findElement(By.xpath("//*[@id=\"searchLanguage\"]"));
		
		Select se = new Select(lang);
		se.selectByIndex(44);
		
		List<WebElement> dropdownoptions = lang.findElements(By.tagName("option"));
		
		System.out.println("total dropdownoptions ="+dropdownoptions.size());
		System.out.println(dropdownoptions.get(0).getText());
		
		for(int i=0;i<dropdownoptions.size();i++)
		{
			System.out.println(i+"."+dropdownoptions.get(i).getText());
		}
		Thread.sleep(8000);
		
		driver.quit();

	}

}
