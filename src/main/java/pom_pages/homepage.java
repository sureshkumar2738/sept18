package pom_pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pom_testbase.test_Base;

public class homepage  extends test_Base {
	
	@FindBy(xpath = "//div[contains(text(),'suresh')]")
	WebElement  visibleusername;
	
	@FindBy(xpath = "//div[contains(text(),'My Profile')]")
	WebElement  myprofile;
	
	@FindBy(xpath = "//img[@class='_1e_EAo']")
	WebElement  logo;

	public homepage() throws IOException {
		
		PageFactory.initElements(driver, this);
	}
	
	public String ValidatePageTitle() {
		
		return driver.getTitle();
		
	}
	
	public boolean Validatelogo() {
		
		return logo.isDisplayed();
		
	}
	
	public String getUsername() {
		
		return visibleusername.getText();
		
	}
	
	public profilepage clickOnUserName() throws InterruptedException, IOException {
		
		Actions action= new Actions(driver);
		action.moveToElement(visibleusername).build().perform();
		Thread.sleep(2000);
		myprofile.click();
		
		return new profilepage();
		
	}

}
