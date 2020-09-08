package com.w2a.testcases;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.w2a.base.TestBase;
import com.w2a.utilities.TestUtil;





public class OpenAccountTest extends TestBase {
	
	@Test (dataProviderClass = TestUtil.class,dataProvider = "dp")
	public void openAccountTest(String customer, String currency) throws InterruptedException {
		
		if (!TestUtil.isTestRunnable("openAccountTest", excel)) {
			throw new SkipException("Skipping the test" + "openAccountTest".toUpperCase() + " as the Run mode is NO");
		}
		
		click("bmlBtn_CSS");
		click("openaccount_CSS");
		select("customer_CSS", customer);
		select("currency_CSS", currency);
		click("process_CSS");
		
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, 5);
		Alert alert =	wait.until(ExpectedConditions.alertIsPresent());
		
	
		//driver.switchTo().alert().accept();
		alert.accept();
		
		Thread.sleep(2000);

	}
}