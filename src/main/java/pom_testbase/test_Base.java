package pom_testbase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
import pom_util.test_utility;

public class test_Base {
	
	public static WebDriver driver;
	
	public static File file;
	
	public static FileInputStream fis;
	
	public static Properties prop;
	
	public static WebDriverWait iwait;
	
	public test_Base() throws IOException {
	
	file = new File(System.getProperty("user.dir")+"\\src\\main\\java\\pom_properties\\config.properties");
	
	fis = new FileInputStream(file);
	
	prop = new Properties();
	
	prop.load(fis);

}
	
	public static void inilization() {
		
		String browsername = prop.getProperty("txt_browser");
		
		if(browsername.equalsIgnoreCase("chrome")) {
			
			WebDriverManager.chromedriver().setup();
			
			driver = new ChromeDriver();
		}
		
		else if(browsername.equalsIgnoreCase("firefox")) {
			
			WebDriverManager.firefoxdriver().setup();
			
			driver = new FirefoxDriver();
		}
		
		else if(browsername.equalsIgnoreCase("ie")) {
			
			WebDriverManager.iedriver().setup();
			
			driver = new InternetExplorerDriver();
		}
		
		else {
			
			System.out.println("selenium doesnot support this browser = "+browsername);
		}
		
		driver.get(prop.getProperty("URL"));
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(test_utility.IMPLICITWAITTIMEOUT, TimeUnit.SECONDS);
		
		driver.manage().timeouts().pageLoadTimeout(test_utility.PAGELOADTIMEOUT, TimeUnit.SECONDS);
	
	}
}
