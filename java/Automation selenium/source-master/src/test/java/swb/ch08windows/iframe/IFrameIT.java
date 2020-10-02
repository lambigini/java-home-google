package swb.ch08windows.iframe;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import swb.framework.WebDriverRunner;

import javax.inject.Inject;

import static org.junit.Assert.assertEquals;

@RunWith(WebDriverRunner.class)
public class IFrameIT {
    @Inject
    private WebDriver driver;

    @Test
    public void iFrame() throws Exception {
        driver.get("/inline-frames.html");

        driver.switchTo().frame("frame-1");

        assertEquals("Frame 1 Content", driver.findElement(By.tagName("h1")).getText());

        driver.switchTo().defaultContent();

        assertEquals("Inline Frames", driver.findElement(By.tagName("h1")).getText());
    }
}
