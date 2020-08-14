package testcases;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AssignmentPopupWindow {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver  driver = new ChromeDriver();
		
		driver.get("https://www.naukri.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		Set<String> windowIDsSet = driver.getWindowHandles();
		
		Iterator<String> iterator = windowIDsSet.iterator();
		
		while (iterator.hasNext()) {
			String id = (String) iterator.next();
			driver.switchTo().window(id);
			System.out.println(driver.getTitle());
			driver.close();
		}
	
		Thread.sleep(5000);
//		driver.quit();
	}

}
