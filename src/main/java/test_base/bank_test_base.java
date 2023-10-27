package test_base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class bank_test_base {
	
	public static WebDriver driver;
	
	public static File file;
	
	public static FileInputStream fis;
	
	public static Properties prop;
	
	public static  String LoanAmt,loanYeays,Loanrate,ActualMonthlyPayment,ExpectedmonthlyPayment;

	public static WebDriverWait iwait;

	public bank_test_base() throws IOException {
		
		file = new File(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\config.properties");
		
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
		driver.manage().timeouts().implicitlyWait(testutil.IMPLICTWAITTIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(testutil.PAGELOADTIMEOUTTIME, TimeUnit.SECONDS);
		
		//iwait= new WebDriverWait(driver, 10);
	}
}
