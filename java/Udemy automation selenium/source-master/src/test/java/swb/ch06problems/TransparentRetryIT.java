package swb.ch06problems;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import swb.framework.WebDriverRunner;

import javax.inject.Inject;

@RunWith(WebDriverRunner.class)
public class TransparentRetryIT {
    @Inject
    private WebDriver driver;

    @Test
    public void transparentRetryExample() throws Exception {

        driver.get("/login.html");

        WebElement email = driver.findElement(By.name("email"));

        driver.get("/login.html");

        try {
            email.sendKeys("foo@bar.com");
        } catch (StaleElementReferenceException ignored) {
            email = driver.findElement(By.name("email"));
            email.sendKeys("foo@bar.com");
        }
    }
}
