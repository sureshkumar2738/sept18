package sept18_testcase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class rediff_firefox {
	
	public static String url = "http://www.gmail.com";
	
	public static void main(String[] args) {
		
		try {
			WebDriverManager.firefoxdriver().setup();
			
			WebDriver driver = new FirefoxDriver();
			
			driver.get(url);
			
			Thread.sleep(5000);
			
			driver.quit();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		

	}

}
