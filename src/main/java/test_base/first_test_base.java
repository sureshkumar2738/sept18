package test_base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class first_test_base {

	public static WebDriver driver;
	public static File file;
	public static FileInputStream fis;
	public static Properties prop;
	
	public first_test_base() throws IOException {
		
		 file = new File(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\config.properties");
		 
		 fis = new FileInputStream(file);
		 
		 prop = new Properties();
		 
		 prop.load(fis);
		 
	}
	

	public static void inilization() {
		
		String browsername = prop.getProperty("browser");
        if(browsername.equalsIgnoreCase("firefox")) {

		WebDriverManager.firefoxdriver().setup();
		
		driver = new FirefoxDriver();
		
		driver.get(prop.getProperty("url"));
		
	}else if(browsername.equalsIgnoreCase("chrome")) {
		WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver();
		
		driver.get(prop.getProperty("url"));
		
	}else if(browsername.equalsIgnoreCase("ie")){
		 WebDriverManager.iedriver().setup();
			
			driver = new InternetExplorerDriver();
			
			driver.get(prop.getProperty("url"));
	}
	}
}
