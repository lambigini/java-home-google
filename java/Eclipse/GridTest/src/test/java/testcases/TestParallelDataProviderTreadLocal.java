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

public class TestParallelDataProviderTreadLocal {
	public ThreadLocal<WebDriver> dr = new ThreadLocal<WebDriver>();
	public WebDriver driver;
	
	public ThreadLocal<DesiredCapabilities> dc = new ThreadLocal<DesiredCapabilities>();
	public DesiredCapabilities cap ;
	
	public WebDriver getDriver() {
		return dr.get();
	}
	
	public void setWebDriver(WebDriver driver) {
		
		dr.set(driver );
	}
	
	public DesiredCapabilities getDesiredCapabilities() {
		return dc.get();
	}
	
	public void setDesiredCapabilities(DesiredCapabilities cap) {
		
		dc.set(cap );
	}
	
	
	@Test(dataProvider = "getData")
	public void launchBrowser( String browser, String userName) throws MalformedURLException {
		
		Date date = new Date();
		
		System.out.println(browser + " " + date.toString());
		
		
		if (browser.equals("chrome")) {
			cap = new DesiredCapabilities();
			setDesiredCapabilities(cap);
			
			getDesiredCapabilities().setPlatform(Platform.ANY);
			getDesiredCapabilities().setBrowserName("chrome");
			
			ChromeOptions options = new ChromeOptions();
			options.merge(getDesiredCapabilities());
			
		} else if (browser.equals("firefox")) {
			
			cap = new DesiredCapabilities();
			setDesiredCapabilities(cap);
			
			getDesiredCapabilities().setPlatform(Platform.ANY);
			getDesiredCapabilities().setBrowserName("firefox");
			
			FirefoxOptions options = new FirefoxOptions();
			options.merge(getDesiredCapabilities());
		}
		
		driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap);
		
		setWebDriver(driver);
		
		getDriver().get("http://gmail.com");
		getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		getDriver().findElement(By.id("identifierId")).sendKeys(userName);
		
		getDriver().quit();
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
