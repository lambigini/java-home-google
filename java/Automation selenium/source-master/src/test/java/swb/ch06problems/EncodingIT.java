package swb.ch06problems;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import swb.framework.WebDriverRunner;

import javax.inject.Inject;

@RunWith(WebDriverRunner.class)
public class EncodingIT {
    @Inject
    private WebDriver driver;

    @Test
    public void tastiestSushi() throws Exception {
        driver.get("/pre-filled-form.html");

        final WebElement text = driver.findElement(By.tagName("textarea"));
        text.clear();
        text.sendKeys("おいしい寿司");
    }
}
