package testcases;



import java.util.concurrent.TimeUnit;

import org.omg.CORBA.PUBLIC_MEMBER;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.json.StaticInitializerCoercer;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestIsElementPresent {
 public static WebDriver driver;
 
 public static Boolean isElementPresent(By by) {
	 try {
		 
	 driver.findElement(by);
	return true;
	 } catch (Throwable t) {
		// TODO: handle exception
		 return false;
	}
}
 
 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
//		
//		WebDriverManager.firefoxdriver().setup();
//		WebDriver driver = new FirefoxDriver();
		
		driver.get("https://www.wikipedia.org/");

//		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		System.out.println(isElementPresent(By.id("searchLanguage")));

	}

}
