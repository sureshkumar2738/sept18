package sept18_testcase;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class third_testcase {
	
	@BeforeTest
	public void start() {
		System.out.println("start is done = start");
	}

	@BeforeMethod
	public void launchbrowser() {
		System.out.println("browser is open = launchbrowser");
	}
	
	@Test(priority = 2)
	public void dologin() {
		System.out.println("login is done = dologin");
	}
	
	@Test(priority = 1)
	public void doregister() {
		System.out.println("register is done = doregister");
	}
	
	@AfterMethod
	public void closebrowser() {
		System.out.println("browser is closed = closebrowser");
	}
	
	@AfterTest
	public void create() {
		System.out.println("create is done = create");
	}
}
