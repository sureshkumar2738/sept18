package pom_pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pom_testbase.test_Base;

public class loginpage extends test_Base {
	
	@FindBy(xpath = "//input[@class='_2zrpKA _1dBPDZ']")
	WebElement  username;
	
	@FindBy(xpath = "//input[@class='_2zrpKA _3v41xv _1dBPDZ']")
	WebElement  password;
	
	@FindBy(xpath = "//button[@class='_2AkmmA _1LctnI _7UHT_c']")
	WebElement  login;
	
	@FindBy(xpath = "//img[@class='_1e_EAo']")
	WebElement  logo;
	
	
	
	public loginpage() throws IOException {
		
		PageFactory.initElements(driver, this);
	}
	
	public String ValidatePageTitle() {
		
		return driver.getTitle();
		
	}
	
	public boolean ValidateLogo() {
		return logo.isDisplayed();
		
	}
	
	public homepage dologin(String un,String pwd) throws InterruptedException, IOException {
		
		username.click();
		Thread.sleep(2000);
		username.sendKeys(un);
		
		password.click();
		Thread.sleep(2000);
		password.sendKeys(pwd);
		
		login.click();
		Thread.sleep(5000);
		
		return new homepage();
		
		
	}

}
