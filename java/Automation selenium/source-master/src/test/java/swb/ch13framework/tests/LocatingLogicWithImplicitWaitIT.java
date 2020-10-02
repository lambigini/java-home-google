package swb.ch13framework.tests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import swb.tests.TestTimer;
import swb.framework.WebDriverRunner;

import javax.inject.Inject;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.junit.Assert.assertEquals;
import static org.openqa.selenium.By.linkText;

@RunWith(WebDriverRunner.class)
public class LocatingLogicWithImplicitWaitIT extends TestTimer{

    @Inject
    private WebDriver driver;

    @Test
    public void usingImplicitWait() {
        driver.manage().timeouts().implicitlyWait(5, SECONDS); // <1>
        driver.get("/location-chooser.html");
        driver.findElement(linkText("choose location")).click();
        WebElement tabMenu = driver.findElement(By.id("location"));
        tabMenu.findElement(linkText("MEXICO")).click();
        tabMenu.findElement(linkText("Cancun")).click();
        assertEquals(0, tabMenu.findElements(linkText("Cancun")).size());
        assertEquals("Cancun", driver
            .findElement(By.cssSelector(".tools-location strong"))
            .getText());
    }

    @Test(expected = NoSuchElementException.class)
    public void usingImplicitWaitButNotFound() {
        driver.manage().timeouts().implicitlyWait(5, SECONDS); // <1>
        driver.get("/location-chooser.html");
        driver.findElement(linkText("choose location")).click();
        WebElement tabMenu = driver.findElement(By.id("location"));
        tabMenu.findElement(linkText("MEXICO")).click();
        tabMenu.findElement(linkText("Cancun")).click();
        assertEquals(0, tabMenu.findElements(linkText("Cancun")).size());
        assertEquals("Cancun", driver
            .findElement(By.cssSelector(".tools-locati"))
            .getText());
    }

}
