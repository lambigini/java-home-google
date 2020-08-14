package testcases;

import org.omg.CORBA.PUBLIC_MEMBER;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBrowers {
	
	public static String browser = "safari";
	public static WebDriver driver;

	public static void main(String[] args) {
		
		
		if (browser.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browser.equals("safari"))
		{
		
			driver = new SafariDriver();
		}
	
		
		driver.get("http://google.com");
		
		String titleString = driver.getTitle();
		
	System.out.println(titleString);
	System.out.println(titleString.length());
	
	driver.close();

	}
}
