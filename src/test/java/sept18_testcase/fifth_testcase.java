package sept18_testcase;

//import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

//import testbase.first_testbase;

public class fifth_testcase extends first_testcase {
	
	SoftAssert sft;
	@Test
	public void result() {
		String Expected_Title = "google.com";
		String Actual_Title = "gmail.com";
		System.out.println("start of test");
		
		sft = new SoftAssert();
		sft.assertEquals(Actual_Title,Expected_Title);
		sft.assertTrue(100>99);
		//Assert.fail("message");
		System.out.println("end of test");
		sft.assertAll();
	}
	
}
