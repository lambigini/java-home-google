import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest  extends TestBase {

	
	@Test
	public void doLogin() {
		
		driver.findElement(By.xpath("//*[@id=\"identifierId1\"]")).sendKeys("lambigini87@gmail.com");
		
		driver.findElement(By.xpath("//*[@id=\"identifierNext\"]/div/button/div[2]")).click();
}
	
//	@Test
//	public void sendEmail() {
//		Assert.fail("set test to failed");
//	}
}
