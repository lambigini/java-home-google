package testcases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCheckBoxes {
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
		
	
		driver.get("http://www.tizag.com/htmlT/htmlcheckboxes.php");

		//driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
//		int i =1, count = 0;
//		while (isElementPresent(By.xpath("//div[4]/input["+i+"]"))) {
//			driver.findElement(By.xpath("//div[4]/input["+i+"]")).click();
//			i++;
//			count++;
//		}
//		

		WebElement block = driver.findElement(By.xpath("/html/body/table[3]/tbody/tr[1]/td[2]/table/tbody/tr/td/div[4]"));
		List<WebElement> checkBoxes =  block.findElements(By.name("sports"));
		
		for (WebElement webElement : checkBoxes) {
			webElement.click();
		}
		
		System.out.println("Total checkboxs are: " + checkBoxes.size());
	}

}
