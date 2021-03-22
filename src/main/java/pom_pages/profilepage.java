package pom_pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import pom_testbase.test_Base;

public class profilepage extends test_Base {

	@FindBy(xpath = "//input[@name='name']")
	WebElement  name;
	
	@FindBy(xpath = "//input[@name='phone']")
	WebElement  phone;
	
	@FindBy(xpath = "//input[@name='pincode']")
	WebElement  pincode;
	
	@FindBy(xpath = "//input[@name='addressLine2']")
	WebElement  locality;
	
	@FindBy(xpath = "//textarea[@name='addressLine1']")
	WebElement  address;
	
	@FindBy(xpath = "//input[@name='city']")
	WebElement  city;
	
	@FindBy(name = "state")
	WebElement  state;
	
	public profilepage() throws IOException {
		
		PageFactory.initElements(driver, this);
	}
	
	public String validateProfilePageTitle() {
		
		return driver.getTitle().toString();
	}
	
	public void clickonManageAddresses() {
		
		WebElement manageaddress = driver.findElement(By.xpath("//div[contains(text(),'Manage Addresses')]"));
		
		manageaddress.click();
	}
	
	public void clickAddnewaddress() {
		
		WebElement newaddress = driver.findElement(By.xpath("//span[@class='aGTn1j']"));
		newaddress.click();
	}

	public void createnewaddress(String nm,String ph,String pncode,String local,String add,String cty,String stat) throws InterruptedException {
	
		name.sendKeys("nm");
		
		phone.sendKeys("ph");
		Thread.sleep(2000);
		
		pincode.sendKeys("pncode");
		
		locality.sendKeys("local");
		Thread.sleep(2000);
		
		address.sendKeys("add");
		
		city.sendKeys("cty");
		Thread.sleep(2000);
		
		Select select = new Select(state);
		select.selectByVisibleText(stat);
		
		WebElement save = driver.findElement(By.xpath("//button[@class='_2AkmmA EqjTfe eLvSG3 _7UHT_c']"));
		save.click();
	}
}
