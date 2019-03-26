package test.java.com.testautotog.container.test;

import io.github.cdimascio.dotenv.Dotenv;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import test.java.com.testautotog.container.test.page.Dashboard.FormPage;
import test.java.com.testautotog.container.test.utils.logging.CustomReporter;

import java.net.MalformedURLException;

/**
 * Created by user on 8/10/18.
 */
public class BaseFunctionalPositiveSuite extends BaseTestLocaly {

    private FormPage formPage;
    private Dotenv dotenv;

    //Positive test-case
    @Test(priority = 0)
    public void SendForm(){
        formPage = new FormPage(driver);
        dotenv = Dotenv.configure()
                .directory("./ENV/")
                .ignoreIfMalformed()
                .ignoreIfMissing()
                .load();
        driver.get(dotenv.get("WEB_ADDRESS"));
        CustomReporter.logAction("Browser launched and navigated to the Login page");
        formPage.inputPositiveData(dotenv.get("USER_LOGIN"), dotenv.get("USER_PASSWORD"));
    }
}
