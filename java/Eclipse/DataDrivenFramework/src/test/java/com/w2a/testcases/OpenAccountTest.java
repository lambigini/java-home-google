package com.w2a.testcases;

import org.testng.annotations.Test;

import com.w2a.base.TestBase;
import com.w2a.utilities.TestUtil;





public class OpenAccountTest extends TestBase {
	
	@Test (dataProviderClass = TestUtil.class,dataProvider = "dp")
	public void openAccountTest(String customer, String currency) throws InterruptedException {
		
	}
}
