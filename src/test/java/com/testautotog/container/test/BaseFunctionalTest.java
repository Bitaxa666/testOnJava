package test.java.com.testautotog.container.test;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import test.java.com.testautotog.container.test.page.Dashboard.FormPage;
import test.java.com.testautotog.container.test.utils.logging.CustomReporter;

import java.net.MalformedURLException;

/**
 * Created by user on 8/10/18.
 */
public class BaseFunctionalTest extends BaseTestForHub {

    private FormPage formPage;

    @BeforeTest
    public void setUp() throws MalformedURLException {
        super.setUp();
        formPage = new FormPage(driver);
    }

    //Positive test
    @Test(priority = 0)
    public void SendForm(){
        formPage.goTo();
    }

}
