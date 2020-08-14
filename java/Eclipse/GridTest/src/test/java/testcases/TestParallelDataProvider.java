package testcases;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestParallelDataProvider {
	public WebDriver driver;
	public DesiredCapabilities cap = new DesiredCapabilities();
	
	
	@Test(dataProvider = "getData")
	public void launchBrowser( String browser, String userName) throws MalformedURLException {
		
		Date date = new Date();
		
		System.out.println(browser + " " + date.toString());
		
		
		if (browser.equals("chrome")) {
			
			
			cap.setPlatform(Platform.ANY);
			cap.setBrowserName("chrome");
			
			ChromeOptions options = new ChromeOptions();
			options.merge(cap);
		} else if (browser.equals("firefox")) {
			
			
			cap.setPlatform(Platform.ANY);
			cap.setBrowserName("firefox");
			
			FirefoxOptions options = new FirefoxOptions();
			options.merge(cap);
		}
		
		driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap);
		
		driver.get("http://gmail.com");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.id("identifierId")).sendKeys(userName);
		
		driver.quit();
	}
	
	@DataProvider(parallel = true)
	public Object[][] getData() {
		
		Object[][] data = new Object[2][2];
		
		data[0][0] = "chrome";
		data[0][1] = "lambigini87@gmail.com";
		
		data[1][0] = "firefox";
		data[1][1] = "harrisontran@outlook.com";
		
		return data;
		
	} 
}
