package test.java.com.testautotog.container.test;

import io.github.cdimascio.dotenv.Dotenv;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.Test;
import test.java.com.testautotog.container.test.page.Dashboard.FormPage;
import test.java.com.testautotog.container.test.page.Dashboard.LoginFormPageDomElements;
import test.java.com.testautotog.container.test.utils.logging.CustomReporter;

/**
 * Created by Mihayluk on 8/10/18.
 */
public class BaseFunctionalPositiveSuite extends BaseTestLocaly {

    private FormPage formPage;
    private Dotenv dotenv;
    private LoginFormPageDomElements domElements;

    public BaseFunctionalPositiveSuite() {
        this.dotenv = Dotenv.configure()
                .directory("./ENV/")
                .ignoreIfMalformed()
                .ignoreIfMissing()
                .load();
    }

    //TODO нужно добавить функцию logout что бы можно было прогнать все в одном классе...не хватило времени
    //TODO если запустить отдельно только его, то он тоработает
//    //Positive test-case: Test-0011.1/V-1
//    @Test(priority = 0)
//    public void SendForm(){
//        formPage = new FormPage(driver);
//        String redirectUrl = "https://autotest-prerelease.intesting.ca/";
//        driver.get(dotenv.get("WEB_ADDRESS"));
//        CustomReporter.logAction("Browser launched and navigated to the Login page");
//        formPage.checkRedirectUrl(dotenv.get("USER_LOGIN"), dotenv.get("USER_PASSWORD"), redirectUrl);
//    }
    //Positive test-case: Test-0011.2/V-1
    @Test(priority = 1)
    public void onlyValidLogin(){
        //TODO знаю что не очень, в каждом тесте вызывать FormPage, но начал делать уже так и пути назад нету:)
        formPage = new FormPage(driver);
        domElements = new LoginFormPageDomElements(driver);
        driver.get(dotenv.get("WEB_ADDRESS"));
        formPage.checkErrorFiilsOnlyLogin(dotenv.get("USER_LOGIN"), "", "Field can\'t be empty and less then 3 symbol", domElements.getUnsuccessfulPwdMessage());
    }

    //Positive test-case: Test-0011.3/V-1
    @Test(priority = 2)
    public void onlyValidPwd(){
        //TODO знаю что не очень, в каждом тесте вызывать FormPage, но начал делать уже так и пути назад нетуЖ)
        formPage = new FormPage(driver);
        domElements = new LoginFormPageDomElements(driver);
        driver.get(dotenv.get("WEB_ADDRESS"));
        formPage.checkErrorFiilsOnlyLogin("", dotenv.get("USER_PASSWORD"), "Field can\'t be empty and less then 3 symbol", domElements.getUnsuccessfulNameMessage());
    }

}
