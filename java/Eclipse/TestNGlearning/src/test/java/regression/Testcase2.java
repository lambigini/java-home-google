package regression;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;




import org.testng.asserts.SoftAssert;

public class Testcase2 {

	
	
	
	@Test
	public void validateTitles() {
		
		SoftAssert softAssert = new SoftAssert();
		
		System.out.println("Beginning");
		String expected_title = "Yahoo.com"; //excel
		
		String actual_titleString = "Gmail.com"; // selenium
		
		
		System.out.println("Validating title");
		softAssert.assertEquals(actual_titleString, expected_title);
//		Assert.assertTrue(false, "Element not found");
//		Assert.fail("failing the test");
		
		System.out.println("validating image");
		softAssert.assertEquals(true, false);
		
		System.out.println("validating text box presenting");
		softAssert.assertEquals(true, false, "textbox not presenting");
		
		System.out.println("Ending");
		
		softAssert.assertAll();
		
		
	}
}
