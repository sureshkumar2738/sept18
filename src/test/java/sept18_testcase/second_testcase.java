package sept18_testcase;

import org.testng.annotations.Test;

public class second_testcase {
	
    @Test(priority = -1)
	public void dologintest() {
		System.out.println("login is done = logintest");
	}
    
    @Test(priority = 1)
    public void register() {
    	System.out.println("register is done = register");
    }
}

