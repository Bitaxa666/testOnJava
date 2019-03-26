package test.java.com.testautotog.container.test;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import test.java.com.testautotog.container.test.utils.logging.EventHandler;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

/**
 * Created by user on 8/14/18.
 */
public abstract class BaseTestLocaly {

    protected EventFiringWebDriver driver;

    /**
     *
     * @param browser Driver type to use in tests.
     *
     * @return New instance of {@link WebDriver} object.
     */

    private WebDriver getDriver(String browser) {
        switch (browser) {
            case "firefox":
                System.setProperty(
                        "webdriver.gecko.driver",
                        getResource("/geckodriver"));
                return new FirefoxDriver();
            case "ie":
            case "internet explorer":
                System.setProperty(
                        "webdriver.ie.driver",
                        getResource("/IEDriverServer.exe"));
                return new InternetExplorerDriver();
            case "chrome":
            default:
                String driverPath = System.getProperty("user.dir") + "/src/resources/chromedriver";
                System.setProperty(
                       // *//*"webdriver.chrome.driver",
                        //getResource("/chromedriver"));

                        //use work java directory, not resources directory.....
                        "webdriver.chrome.driver",
                        driverPath);
                return new ChromeDriver();
//                ChromeDriverManager.getInstance().setup();
//                ChromeOptions options = new ChromeOptions();
//                options.addArguments("--headless", "--lang=es", "--enable-precise-memory-info", "--no-sandbox");
//                return new ChromeDriver(options);

        }
    }
    /**
     * @param resourceName The name of the resource
     * @return Path to resource
     */
    private String getResource(String resourceName) {
        try {
            return Paths.get(BaseTestLocaly.class.getResource(resourceName).toURI()).toFile().getPath();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return resourceName;
    }
    /**
     * Prepares {@link WebDriver} instance with timeout and browser window configurations.
     *
     * Driver type is based on passed parameters to the automation project,
     * creates {@link ChromeDriver} instance by default.
     *
     */
    @Parameters({ "browsDefault" })
    @BeforeClass
    // TODO use parameters from pom.xml to pass required browser type
    public void setUp(@Optional("chrome")String browser)  throws MalformedURLException {
        driver = new EventFiringWebDriver(getDriver(browser));
        driver.register(new EventHandler());

        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    /**
     * Closes driver instance after test class execution.
     */
    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}
