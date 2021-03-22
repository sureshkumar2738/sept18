package sept18_testcase;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class first_testcase {
	
	public static String url;
	
	@BeforeTest //Execute always once before all test
	public void inilization()
	{
    url = "http://www.google.com";
	System.out.println("inilization is done = @BeforeTest");
	}
	
	@Test //test ng annotation test case
	public void logintest() {
		
		System.out.println("login is done = @test");
	}
	
	@AfterTest //Execute always once after all test
	public void teardown()
	{
		System.out.println("browser is closed = @AfterTest");
	}
}
