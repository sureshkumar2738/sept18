package sept18_testcase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class chrome_driver {

		public static String url = "http://www.facebook.com";
		
		public static void main(String[] args) {
			
			try {
				WebDriverManager.chromedriver().setup();
				
				WebDriver driver = new ChromeDriver();
				
				driver.get(url);
				
				Thread.sleep(5000);
				
				driver.quit();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
}

