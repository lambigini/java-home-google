package testcases;


import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestDropDownMenu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.wikipedia.org/");

//		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
//		driver.findElement(By.id("searchLanguage")).sendKeys("Eesti");
		
		WebElement dropDown = driver.findElement(By.id("searchLanguage"));
		
		Select select = new Select(dropDown);
//		select.selectByVisibleText("Eesti");
		select.selectByValue("hi");
		
		List<WebElement> values = driver.findElements(By.tagName("option"));
//		System.out.println("Total value are "  + values.size());
		
//		System.out.println(values.get(7).getText());
////		System.out.println(values.get(7));
//		
//		for (int i = 0; i < values.size(); i++) {
//			System.out.println(values.get(i).getAttribute("lang"));
////			System.out.println(values.get(i));
//		}
		
		WebElement block = driver.findElement(By.xpath("//*[@id='www-wikipedia-org']/div[6]/div[3]"));
		
				

		List<WebElement> links = block.findElements(By.tagName("a"));
		System.out.println("Total link are: " + links.size());
		for (WebElement webElement : links) {
			System.out.println(webElement.getText()  +" " + webElement.getAttribute("href"));
		}
	}

}
