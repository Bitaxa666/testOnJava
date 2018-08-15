package test.java.com.testautotog.container.test.page.Dashboard;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;
import test.java.com.testautotog.container.test.page.PageObject;

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
//TODO del this methods
/*    private void clearAndEnterData (WebElement element, String inputText) {
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
*/
    /**
    *Method -  Go to the Home page.
    *
    * */
    public void goTo() {
        this.driver.get("https://docs.google.com/forms/d/e/1FAIpQLSdqT5F9_qhPDmJ4lfIH7buVkUvjf4LS9ODdqD7PYfVbfFTnpA/viewform");
        System.out.println("Browser launched and navigated to TestForm page");
    }

    public void inputPositiveData() {

        try {
            System.out.println("**User inputs correct data.**");
            //Values are entered into the 'Email' field
            //TODO now the first step is working - only for docker
            System.out.println("Step 1.0");
            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[type=email]")));
            driver.findElement(By.cssSelector("input[type=email]")).clear();
            driver.findElement(By.cssSelector("input[type=email]")).sendKeys();
            System.out.println("Message: " + "test@test.ua" + " is entered");
            Thread.sleep(1000); //using for debug

        } catch (UnsupportedOperationException ue) {
            ue.printStackTrace();
            System.out.println("User has some problems");
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("Threads no sleep.");
        }
    }
}