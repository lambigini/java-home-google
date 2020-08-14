package testcases;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestIFrame {
	
public static WebDriver  driver;

public static void takeScreenShot() throws IOException {
	

	Date date = new Date();
	
	String timestampString = (date.toString().replace(":", "_").replace(" ", "_")+".jpg");
	
	File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	
	FileUtils.copyFile(screenshotFile, new File("./screenshot/" + timestampString));
}

public static void captureEleScreenshot(WebElement ele) throws IOException {
	 
	Date d = new Date();
	String filename = (d.toString().replace(":", "_").replace(" ", "_"));

	File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

	BufferedImage fullImg = ImageIO.read(screenshot);

	Point point = ele.getLocation();

	int eleWidth = ele.getSize().getWidth();
	int eleHeight = ele.getSize().getHeight();

	BufferedImage eleScreenshot = fullImg.getSubimage(point.getX(), point.getY(), eleWidth, eleHeight);
	ImageIO.write(eleScreenshot, "jpg", screenshot);

	File screenshotLocation = new File("./screenshot/" + filename);
	FileUtils.copyFile(screenshot, screenshotLocation);
}


		
		public static void main(String[] args) throws InterruptedException, IOException {
			// TODO Auto-generated method stub
			WebDriverManager.chromedriver().setup();
			  driver = new ChromeDriver();
			
			driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_submit_get");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
//	List<WebElement> framesElements1 =	driver.findElements(By.tagName("iframe"));
//			
//			System.out.println(framesElements1.size());
//
//			for (WebElement webElement : framesElements1) {
//				System.out.println(webElement.getAttribute("id"));
//			}
		
			
			driver.switchTo().frame("iframeResult");
			System.out.println("frame 2 switch succefully ");
//			driver.findElement(By.xpath("/html/body/button")).click();
			
//			((JavascriptExecutor) driver).executeScript("myFunction()");
			
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			
//			executor.executeScript("myFunction()");
			executor.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", driver.findElement(By.id("mySubmit")));
			
			takeScreenShot();
			
			
			
//			driver.switchTo().defaultContent();
//			
//	List<WebElement> framesElements =	driver.findElements(By.tagName("iframe"));
//			
//			System.out.println(framesElements.size());
//
//			for (WebElement webElement : framesElements) {
//				System.out.println(webElement.getAttribute("id"));
//			}
//	
		
			Thread.sleep(5000);
			driver.quit();

		
	}

}
