package com.w2a.listeners;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.SkipException;

import com.relevantcodes.extentreports.LogStatus;
import com.w2a.base.Page;

import com.w2a.utilities.MonitoringMail;
import com.w2a.utilities.TestConfig;
import com.w2a.utilities.Utilities;


public class CustomListeners extends Page implements ITestListener {

	public String messageBody;
	
	public void onTestStart(ITestResult result) {
	test =rep.startTest(result.getName().toUpperCase());
	System.out.println(result.getName().toUpperCase() + " start");
	System.out.println(Utilities.isTestRunnable(result.getName(), excel));
		
	
	}

	public void onTestSuccess(ITestResult result) {
		
		test.log(LogStatus.PASS, result.getName().toUpperCase(), "Pass");
		rep.endTest(test);
		rep.flush();            
	}

	public void onTestFailure(ITestResult result) {
		
		System.setProperty("org.uncommons.reportng.escape-output","false");
		
		try {
			Utilities.captureScreenshot();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		test.log(LogStatus.FAIL, result.getName().toUpperCase(), "Fail");
		test.log(LogStatus.FAIL, result.getThrowable());
		test.log(LogStatus.FAIL, test.addScreenCapture(Utilities.screenshotName));
		
		
		Reporter.log("Login successfully executed");
		Reporter.log("<a target=\"_blank\" href="+Utilities.screenshotName+">Screenshot</a>");
		Reporter.log("<br>");
		Reporter.log("<a target=\"_blank\" href="+Utilities.screenshotName+"><img src="+Utilities.screenshotName+"></img></a>");
		
		rep.endTest(test);
		rep.flush();
		
	}

	public void onTestSkipped(ITestResult result) {
		
		test.log(LogStatus.SKIP, result.getName().toUpperCase() + " skip the test because RunMode is No");
		rep.endTest(test);
		rep.flush();
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		MonitoringMail mail =  new MonitoringMail();
		
		try {
			messageBody = "http://" + 	InetAddress.getLocalHost().getHostAddress() +":8080/job/DataDrivenLiveProject/Extent_20HTML_20Report/";
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {
			mail.sendMail(TestConfig.server, TestConfig.from, TestConfig.to, TestConfig.subject, messageBody);
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

}
