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

        //String host = System.getProperty("seleniumHubHost");
        //driver = new RemoteWebDriver(new URL("http://" + host + ":4444/wd/hub"), dc);

        driver = new RemoteWebDriver(new URL("http://172.20.0.3:5555/wd/hub"), dc);

        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
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
