package sept18_testcase;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class wikipedia_links {
	
	public static String url ="https://www.wikipedia.org/";
	
	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get(url);
		
		Thread.sleep(3000);
		
		WebElement footer = driver.findElement(By.xpath("//body/div[7]"));
		
		List<WebElement> links = footer.findElements(By.tagName("a"));
		
		System.out.println("total number of links = "+links.size());
		
		System.out.println(links.get(0).getText());
		
		for(int i=0;i<links.size();i++) {
		
			System.out.println(i+"."+links.get(i).getText()+"."+ links.get(i).getAttribute("href"));
		}
		
		driver.quit();	

	}
}
