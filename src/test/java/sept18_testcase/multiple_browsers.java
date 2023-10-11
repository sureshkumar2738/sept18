package sept18_testcase;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class multiple_browsers {
	
	public static WebDriver driver;
	
	public static String url ="https://www.bankofbaroda.in/";
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.firefoxdriver().setup();
		
		driver = new FirefoxDriver();
		
		driver.get(url);
		
		Thread.sleep(5000);
		
		Set<String> mywindows = driver.getWindowHandles();
		
		Iterator<String> windowid = mywindows.iterator();
		
		driver.findElement(By.xpath("//*[@id=\"exclusiveOffers\"]/div/div/ul/li[4]/a")).click();
		
		Thread.sleep(6000);
		
		mywindows = driver.getWindowHandles();
		
		windowid = mywindows.iterator();
		
		String firstwindowid = windowid.next();
		System.out.println("first windowid ="+firstwindowid);
		
		String secondwindowid = windowid.next();
		System.out.println("second windowid ="+secondwindowid);
		
		driver.switchTo().window(secondwindowid);
		
		driver.close();
		
		driver.switchTo().window(firstwindowid);
		
		Thread.sleep(5000);
		
		driver.quit();	

	}

}
