import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;



public class TestBase {

	public static WebDriver driver;
	
	@BeforeSuite
	public void setUp() {
		//System.setProperty("webdriver.gecko.driver","/Users/harrisontranimac/Desktop/geckodriver"); // Setting system properties of FirefoxDriver"
		WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();

		

					
			driver.get("https://www.gmail.com");
			
			driver.manage().timeouts().implicitlyWait(5L, TimeUnit.SECONDS);
		
	}
	
	
	@AfterSuite
	public void tearDown() {
		driver.quit();
	}
}
