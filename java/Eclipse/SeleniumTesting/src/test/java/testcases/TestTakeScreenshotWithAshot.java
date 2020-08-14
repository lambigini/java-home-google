package testcases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class TestTakeScreenshotWithAshot {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver  driver = new ChromeDriver();
		
		driver.get("http://way2automation.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		WebElement element = driver.findElement(By.xpath("//img[@class='header-logo__img']"));
		
  Screenshot screenshot =  new AShot().shootingStrategy(ShootingStrategies.viewportPasting(2000))
		  .takeScreenshot(driver, element);
  
	ImageIO.write(screenshot.getImage(), "jpg", new File("./screenshot/ashot.jpg"));
	 

	Thread.sleep(5000);
	driver.quit();
  
	}

}
