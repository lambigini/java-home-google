package swb.ch06problems;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import swb.framework.WebDriverRunner;

import javax.inject.Inject;

import static org.hamcrest.core.StringContains.containsString;
import static org.junit.Assert.*;

@RunWith(WebDriverRunner.class)
public class ExplicitWaitIT {
    private final ExpectedCondition<WebElement> slowLoadingTextIsVisible = ExpectedConditions.visibilityOfElementLocated(By.id("theText"));
    @Inject
    private WebDriver driver;

    @Test
    public void exampleWebDriverWait() throws Exception {

        driver.get("/slow-loading-elements.html");

        driver.findElement(By.id("fadeInText")).click();

        WebDriverWait wait = new WebDriverWait(
                driver,
                3, // <1>
                100 // <2>
        );

        WebElement paraElement = wait
                .withMessage("could not find the slowly loading text") // <3>
                .until(
                        ExpectedConditions
                                .visibilityOfElementLocated(By.id("theText")) // <4>
                );

        assertEquals("Some slowly loading text.", paraElement.getText());
    }

    @Test
    public void exampleWebDriverWaitWith() throws Exception {

        driver.get("/slow-loading-elements.html");

        driver.findElement(By.id("fadeInText")).click();

        WebDriverWait wait = new WebDriverWait(driver, 1, 10);

        wait
                .until(slowLoadingTextIsVisible);
    }


    @Test
    public void exampleWebDriverWaitTimeout() throws Exception {

        driver.get("/slow-loading-elements.html");
        try {
            new WebDriverWait(driver, 1, 10)
                    .withMessage("could not find the slowly loading text")
                    .until(
                            ExpectedConditions
                                    .visibilityOfElementLocated(By.id("theText"))
                    );
            fail();
        } catch (TimeoutException expected) {
            assertThat(expected.getMessage(), containsString("could not find the slowly loading text"));
        }
    }

    @Test
    public void exampleWebDriverWaitEffectivelyLogicalAnd() throws Exception {

        driver.get("/slow-loading-elements.html");

        driver.findElement(By.id("fadeInText")).click();

        WebDriverWait wait = new WebDriverWait(
                driver,
                1, // <1>
                10 // <2>
        );

        WebElement paraElement = wait
                .withMessage("could not find the slowly loading text")
                .until(ExpectedConditions.visibilityOfElementLocated(By.id("theText")));

        wait
                .until(ExpectedConditions.textToBePresentInElement(paraElement, "Some slowly loading text."));
    }
}
