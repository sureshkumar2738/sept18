package sept18_testcase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class internet_explorer {
	
public static String url = "https://www.google.co.in/#spf=1602668174365";
		
		public static void main(String[] args) throws InterruptedException {
			

				WebDriverManager.iedriver().setup();
				
				WebDriver driver = new InternetExplorerDriver();
				
				driver.get(url);
				
				Thread.sleep(5000);
				
				driver.quit();
			
		}
}
