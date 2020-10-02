package com.w2a.testcases;

import org.testng.annotations.AfterSuite;

import com.w2a.base.Page;

public class BaseTest {
	
	
	@AfterSuite
	public void tearDown(){
		
		Page.quit();
		
	}

}
