package test.java.com.testautotog.container.test.page.Dashboard;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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

    private LoginFormPageDomElements domElements;


    public FormPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        this.utilsFunction = new UtilsFunction(driver);
        this.action = new Actions(driver);
        this.softAssert = new SoftAssert();
        this.domElements = new LoginFormPageDomElements(driver);
    }

    /**
    *Method(positive test).  User enter valid data to login/password fields and click on the "LogIn" button
    *
     * @param userLogin - login
     * @param userPassword - password
    * */
    public void inputPositiveData(String userLogin, String userPassword) {

        try {

            CustomReporter.log("User enter valid data to login/password fields and click on the submit button.");
            //Enter the value in the login field.
            utilsFunction.clearAndEnterData(domElements.getInputUserLoginField(), userLogin);
            //Enter the value in the password field.
            utilsFunction.clearAndEnterData(domElements.getInputUserPasswordField(), userPassword);

            utilsFunction.clickOnWebelement(domElements.getSubmitButton());
            CustomReporter.logAction("User successfully LogIn");
            Thread.sleep(5000); //TODO:using for debug

        } catch (UnsupportedOperationException ue) {
            ue.printStackTrace();
            System.out.println("User has some problems");
        }
        catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("Threads no sleep.");
        }
    }
}