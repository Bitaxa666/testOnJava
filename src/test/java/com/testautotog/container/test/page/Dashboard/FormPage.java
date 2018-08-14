package test.java.com.testautotog.container.test.page.Dashboard;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;
import test.java.com.testautotog.container.test.page.PageObject;
import test.java.com.testautotog.container.test.utils.logging.CustomReporter;


/**
 * Created by user on 7/17/18.
 */
public class FormPage extends PageObject {

    private WebDriver driver;
    private static WebDriverWait wait;
    private Actions action;
    private SoftAssert softAssert;

    private FormPageDomElements domElements;


    public FormPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        this.wait = (WebDriverWait) new WebDriverWait(driver, 30).withMessage("Element is not founded");
        this.action = new Actions(driver);
        this.softAssert = new SoftAssert();
        this.domElements = new FormPageDomElements(driver);
    }

    private void clearAndEnterData (WebElement element, String inputText) {
        FormPage.wait.until(ExpectedConditions.visibilityOf(element));
        element.clear();
        element.sendKeys(inputText);
        CustomReporter.log("Message: " + inputText + " is entered");
    }

    private void  clickOnWebelementFunctionality (WebElement element) {
        FormPage.wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
        CustomReporter.log("Message: " + element + " is pressed on.");
    }

    private void onlyClickWithoutClean(WebElement element, String inputText) {
        FormPage.wait.until(ExpectedConditions.visibilityOf(element));
        element.sendKeys(inputText);
        CustomReporter.log("Message: " + inputText + " is entered");
    }

    /**
    *Method -  User inputs some informations - positive test.
    *
    * */
    public void inputPositiveData(String userEmail, String birthdayDate, String name) {

        try {
            CustomReporter.log("**User inputs correct data.**");
            //Values are entered into the 'Email' field
            clearAndEnterData(domElements.getInputUserEmailField(), userEmail);

            //Values are entered into the 'BD' field
            onlyClickWithoutClean(domElements.getInputBirthdayDateField(), birthdayDate);

            //Values are entered into the 'Name' field
            clearAndEnterData(domElements.getInputUserNameField(), name);

            //Open dropdown menu
            clickOnWebelementFunctionality(domElements.getClickGenderdropmenu());
            Thread.sleep(1000); //using for debug

            //Select user's gender
            clickOnWebelementFunctionality(domElements.getSelectGenderdropmenu().get(5));

            //Select answer number 3 OR TODO add random generator for answer
            clickOnWebelementFunctionality(domElements.getSelectAnswer().get(3));

            //Send info
            clickOnWebelementFunctionality(domElements.getSubmitButton());
            Thread.sleep(5000); //using for debug

            softAssert.assertTrue(domElements.getSuccessfulSendMessage().getText().equals("Вашу відповідь було записано."));
            softAssert.assertAll();

            CustomReporter.logAction("User successfully sends info");

        } catch (UnsupportedOperationException ue) {
            ue.printStackTrace();
            System.out.println("User has some problems");
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("Threads no sleep.");
        }
    }
}