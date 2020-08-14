package testcases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

public class TestCase2 {
	@Test
	public void doLogin() {
		
	
		System.out.println("login test");
	}
	
	@Test
	public void doUserReg() {
		
		
		AssertJUnit.fail("User Reg Test Failed");
	}
	
	
	
	@Test
	public void isSkip() {
		
		
		throw new SkipException("Skipping the test case");
	}
}
