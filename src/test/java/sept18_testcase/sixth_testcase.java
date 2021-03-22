package sept18_testcase;

import org.testng.Assert;
import org.testng.annotations.Test;

//import testbase.first_testbase;

public class sixth_testcase extends first_testcase {
	
	@Test(priority = 1)
	public void register() {
		System.out.println("register is done");
	}
	
	@Test(priority = 2,dependsOnMethods = {"register"})
	public void login() {
		System.out.println("login is done");
		Assert.assertEquals("suresh", "kumar");
	}
	
	@Test(priority = 3,dependsOnMethods = {"register"})
	public void shopping() {
		System.out.println("shopping is done");
	}
	
	@Test(priority = 4,dependsOnMethods = {"login"},alwaysRun = true)
	public void payment() {
		System.out.println("payment is done");
	}
	
	@Test(priority = 5,dependsOnMethods = {"login"})
	public void checkout() {
		System.out.println("checkout is done");
	}

}
