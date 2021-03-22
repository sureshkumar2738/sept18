package sept18_testcase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class flipkart {

public static WebDriver driver;
	
	public static String url ="https://www.flipkart.com/";
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver();
		
		driver.get(url);
		
		Thread.sleep(5000);
		
		WebElement Mainmenu = driver.findElement(By.xpath("//body/div[@id='container']/div[1]/div[2]/div[1]/div[1]/span[2]"));
		
		Actions act = new Actions(driver);
		act.moveToElement(Mainmenu).build().perform();
		
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//a[contains(text(),'Microwave Ovens')]")).click();
		
		Thread.sleep(5000);
		
		driver.quit();
		

	}

}
