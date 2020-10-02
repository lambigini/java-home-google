package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestFailure extends BaseTest{
	
	@Test
	public void doLogin() {
		
		Assert.fail("Failing the login test");
		System.out.println("Capture Screenshot");
	}

}
