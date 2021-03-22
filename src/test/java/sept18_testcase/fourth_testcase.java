package sept18_testcase;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import test_base.first_test_base;
//import testbase.first_testbase;

public class fourth_testcase extends first_testcase{
	
	@BeforeMethod
	public void launch() {
		System.out.println("launch is done = launch");
	}
    @Test(priority = 2)
	public void login() {
		System.out.println("login is done = login");
	}
    @Test(priority = 1)
    public void register() {
    	System.out.println("register is done = register");
    }
    @AfterMethod
    public void close() {
    	System.out.println("close is done = close");
    }
}
