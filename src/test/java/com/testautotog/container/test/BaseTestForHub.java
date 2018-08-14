package test.java.com.testautotog.container.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BaseTestForHub {

    protected WebDriver driver;
    
    @BeforeClass
    public void setUp() throws MalformedURLException {

        DesiredCapabilities dc = DesiredCapabilities.chrome();

        if (System.getProperty("browser").equals("firefox"))
            dc = DesiredCapabilities.firefox();

        String host = System.getProperty("seleniumHubHost");

        driver = new RemoteWebDriver(new URL("http://" + host + ":4444/wd/hub"), dc);
    }

    /**
     * Closes driver instance after test class execution.
     */
    @AfterClass
    public void tearDown() throws InterruptedException {
        if (driver != null) {
            driver.quit();
        }
    }  
}
