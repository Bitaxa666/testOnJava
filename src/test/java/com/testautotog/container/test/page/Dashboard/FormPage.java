package test.java.com.testautotog.container.test.page.Dashboard;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import test.java.com.testautotog.container.test.page.PageObject;
import test.java.com.testautotog.container.test.utils.logging.CustomReporter;
import test.java.com.testautotog.container.test.utils.logging.UtilsFunction;


/**
 * Created by Mihayluk V.V on 03/25/19.
 */
public class FormPage extends PageObject {

    private Actions action;
    private SoftAssert softAssert;
    private UtilsFunction utilsFunction;
    private String problemMessage;

    private LoginFormPageDomElements domElements;


    public FormPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        this.utilsFunction = new UtilsFunction(driver);
        this.action = new Actions(driver);
        this.softAssert = new SoftAssert();
        this.domElements = new LoginFormPageDomElements(driver);
        this.problemMessage = "User has some problems";
    }

    /**
    *Method. User enter data to login/password fields.
    *
     * @param userLogin - login
     * @param userPassword - password
    * */
    public void inputData(String userLogin, String userPassword) {

        try {

            CustomReporter.log("User enter data to login/password fields and click on the submit button.");
            //Enter the value in the login field.
            utilsFunction.clearAndEnterData(domElements.getInputUserLoginField(), userLogin);
            //Enter the value in the password field.
            utilsFunction.clearAndEnterData(domElements.getInputUserPasswordField(), userPassword);

        } catch (UnsupportedOperationException ue) {
            ue.printStackTrace();
            System.out.println(problemMessage);
        }
    }

    /**
     *Method.  User press on the "LogIn" button.
     *
     * */
    public void pressOnSubmit() {
        try {
            //Press on the submit btn.
            utilsFunction.clickOnWebelement(domElements.getSubmitButton());
            Thread.sleep(500); //TODO:using for debug

        } catch (UnsupportedOperationException ue) {
            ue.printStackTrace();
            System.out.println(problemMessage);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("Threads no sleep.");
        }
    }

    /**
     *Method. Check current URL.
     *
     * @param url - current url.
     * */
    public void checkCurentUrl( String url) {
        try {
            utilsFunction.waitWebElement(domElements.getUserMainDashboard()); //todo weit element
            String URL = driver.getCurrentUrl();
            Assert.assertEquals(URL, url);

        } catch (UnsupportedOperationException ue) {
            ue.printStackTrace();
            System.out.println(problemMessage);
        }
    }

    /**
     *Method. Check current URL.
     *
     * @param message - error message.
     * @param element - WebElement.
     * */
    public void checkErrorMessage( String message, WebElement element) {
        try {
            utilsFunction.waitWebElement(element);
            Assert.assertEquals(element.getText(), message);

        } catch (UnsupportedOperationException ue) {
            ue.printStackTrace();
            System.out.println(problemMessage);
        }
    }

    /**
     *Method(positive test).  User enter data to login/password fields and click on the "LogIn" button. Check redirect URL.
     *
     * @param userLogin - login
     * @param userPassword - password
     * @param url - current url.
     * */
    public void checkRedirectUrl(String userLogin, String userPassword, String url) {
        inputData(userLogin, userPassword);
        pressOnSubmit();
        checkCurentUrl(url);

    }

    /**
     *Method(positive test).  User enter data to login/password fields and click on the "LogIn" button. Check redirect URL.
     *
     * @param userLogin - login
     * @param userPassword - password
     * */
    public void checkErrorFiilsOnlyLogin(String userLogin, String userPassword, /*String url,*/ String message, WebElement element) {
        inputData(userLogin, userPassword);
        pressOnSubmit();
        //checkCurentUrl(url);
        checkErrorMessage(message, element);
    }
}