package swb.ch09unicorns.draganddrop;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import swb.framework.WebDriverRunner;

import javax.inject.Inject;

import static org.junit.Assert.assertEquals;

@RunWith(WebDriverRunner.class)
public class DragAndDropIT {

    @Inject
    private WebDriver driver;

    @Test
    public void dragAndDrop() throws Exception {
        driver.get("/drag-and-drop.html");

        new Actions(driver)
                .dragAndDrop(
                        driver.findElement(By.id("move")),
                        driver.findElement(By.id("drop"))
                ).perform();

        Thread.sleep(2000);

        assertEquals("rgba(0, 128, 0, 1)", driver.findElement(By.id("drop")).getCssValue("background-color"));
    }
}
