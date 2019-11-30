package io.github.slyatbest;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class ChromeTest {
    @Test
    public void startChromeDriverTest() throws MalformedURLException {
        Capabilities capabilities = new ChromeOptions();
        RemoteWebDriver webDriver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub/"), capabilities);
        webDriver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

        webDriver.navigate().to("http://www.google.com");
        Assert.assertEquals("Title does not match the expected", "Google", webDriver.getTitle());

        webDriver.quit();
    }
}
