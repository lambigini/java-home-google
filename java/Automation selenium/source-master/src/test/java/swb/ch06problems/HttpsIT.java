package swb.ch06problems;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import swb.framework.WebDriverRunner;

import javax.inject.Inject;
import java.net.URI;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.StringEndsWith.endsWith;

@RunWith(WebDriverRunner.class)
public class HttpsIT {
    @Inject
    private WebDriver driver;
    @Inject
    private URI baseUri;

    @Test
    public void smokeHttps() throws Exception {
        driver.get("https://" + baseUri.getHost() + ":8443/index.html");

        assertThat(driver.findElement(By.tagName("h1")).getText(), endsWith("Index"));

    }
}
