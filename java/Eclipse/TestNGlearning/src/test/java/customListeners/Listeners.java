package customListeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class Listeners implements ITestListener{

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("Test Passed --- "+ result.getName());
		
	}

	public void onTestFailure(ITestResult result) {
		System.setProperty("org.uncommons.reportng.escape-output", "false");
		Reporter.log("<a href= \"/Users/harrisontranimac/Desktop/screen.jpg\" target=\"_blank\" > Screen shot link </a>");
		Reporter.log("<br>");
		Reporter.log("<a href= \"/Users/harrisontranimac/Desktop/screen.jpg\" target=\"_blank\" > <img height=200 width=200 src=\"/Users/harrisontranimac/Desktop/screen.jpg\" ></a>");
		System.out.println("Capturing screenshot --- " + result.getName());
		
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

}
