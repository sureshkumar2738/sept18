package sept18_testcase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class uploadfile {

	public static WebDriver driver;
	
	public static String url = "https://www.w3schools.com/howto/howto_html_file_upload_button.asp";
	
	public static void main(String[] args) {

		WebDriverManager.firefoxdriver().setup();
		
		driver = new FirefoxDriver();
		
		driver.get(url);
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//driver.findElement(By.xpath("//input[@id='myFile']")).click();
		WebElement uploadfile = driver.findElement(By.xpath("//input[@id='myFile']"));
		uploadfile.click();
		//uploadfile.sendKeys("C:\\Users\\SURESH\\eclipse-workspace\\Downloads\\pan card.pdf");
		uploadfile.sendKeys("C:\\Users\\hp\\Downloads\\Suresh Kumar- Resume");
		
		driver.quit();
		
	}

}
