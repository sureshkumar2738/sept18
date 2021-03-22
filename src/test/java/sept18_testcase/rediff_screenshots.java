package sept18_testcase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class rediff_screenshots {
	
	public static String url ="https://www.amazon.in/?ext_vrnc=hi&tag=googhydrabk-21&ascsubtag=_k_EAIaIQobChMInuvFosqQ7AIV0CMrCh089wPqEAAYASAAEgJ2mPD_BwE_k_&ext_vrnc=hi&gclid=EAIaIQobChMInuvFosqQ7AIV0CMrCh089wPqEAAYASAAEgJ2mPD_BwE&network=g";
	public static WebDriver driver;
	public static void main(String[] args) throws IOException {
		
		System.out.println(System.getProperty("user.dir"));
		
		try {
			WebDriverManager.firefoxdriver().setup();
			
		 driver = new FirefoxDriver();
			
			driver.get(url);
			
			Thread.sleep(3000);
			
screenshot("C:\\Users\\SURESH\\eclipse-workspace\\sept18\\src\\test\\resources\\screenshotes"+
GetCurrentTimeStamp().replace(".", "_").replace(":", "_")+".jpg");
			
			driver.quit();
		} catch (Exception e) {

			e.printStackTrace();
		}

	}
	
	public static void screenshot(String path) throws IOException
	{
		
	File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	 FileUtils.copyFile(screenshotFile, new File(path));
	 
	}
	
	public static String GetCurrentTimeStamp()
	{
		SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		Date now = new Date();
		String strdate = sdfDate.format(now);
		return strdate;
		
	}
	
}

