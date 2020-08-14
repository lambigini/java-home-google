import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import javax.xml.xpath.XPath;

import org.openqa.selenium.By;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class testSample {

	@SuppressWarnings("deprecation")
	@Parameters("browser")
	@Test(dataProvider = "getData")
	public void testLogin(String username, String password, String browser) throws MalformedURLException {
//		System.setProperty("webdriver.firefox.driver", "/Users/harrisontranimac/Downloads/geckodriver");
//		DesiredCapabilities cap = DesiredCapabilities.firefox();
//		
//		
//		cap.setBrowserName("firefox");
//		cap.setPlatform(Platform.MAC);
//		
//
//		
//		WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wb/hub"),cap);
//		
//	driver.get("http://gmail.com");
//	driver.findElement(By.id("Email")).sendKeys("lambigini87@gmail.com");
//	driver.findElement(By.id("Passwd")).sendKeys("fgdfg");

//		System.setProperty("webdriver.chrome.driver", "/Users/harrisontranimac/Downloads/chromedriver");

		MutableCapabilities options = null;
		if (browser.equals("chrome")) {
			options = new ChromeOptions();
			options.setCapability(CapabilityType.PLATFORM, Platform.ANY);
			options.setCapability(CapabilityType.BROWSER_NAME, "chrome");
		} else if (browser.equals("firefox")) {
			options = new FirefoxOptions();
			options.setCapability(CapabilityType.PLATFORM, Platform.ANY);
			options.setCapability(CapabilityType.BROWSER_NAME, "firefox");
		}
		WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);
		WebDriverWait wait = new WebDriverWait(driver, 40);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get("http://gmail.com");
		driver.findElement(By.id("identifierId")).sendKeys(username);
		driver.findElement(By.xpath("//*[@id=\"identifierNext\"]/div/button/div[2]")).click();
//		driver.findElement(By.name("password")).sendKeys(password);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id=\"password\"]/div[1]/div/div[1]/input"))));
		driver.findElement(By.xpath("//*[@id=\"password\"]/div[1]/div/div[1]/input")).sendKeys(password);
		driver.quit();
	}

	@DataProvider(parallel = true )
	public Object[][] getData() {

		Object[][] data = new Object[3][3];

		// first row
		data[0][0] = "lambigini87@gmail.com";
		data[0][1] = "sdfsdf";
		data[0][2] = "firefox";

		// first row
		data[1][0] = "lambigini87@gmail.com";
		data[1][1] = "sdfsdf";
		data[1][2] = "chrome";

		// first row
		data[2][0] = "lambigini87@gmail.com";
		data[2][1] = "sdfsdf";
		data[2][2] = "chrome";
		return data;

	}
}
