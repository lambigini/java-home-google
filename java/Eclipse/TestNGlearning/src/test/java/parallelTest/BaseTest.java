package parallelTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


import io.github.bonigarcia.wdm.WebDriverManager;

 
public class BaseTest {

	public WebDriver driver;
	
	public WebDriver getBrowser(String browser) {
		if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			
			driver = new ChromeDriver();
			
		
			
	
		} else if (browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			
			driver = new FirefoxDriver();
			
		
			
		
		} 
		
		return driver;
	}
	
}
