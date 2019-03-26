package test.java.com.testautotog.container.test.utils.logging;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Mihayluk V.V on 3/26/19.
 */
public class UtilsFunction {

    private static WebDriverWait wait;

    public UtilsFunction(WebDriver driver) {
        this.wait = (WebDriverWait) new WebDriverWait(driver, 30).withMessage("Сould not find item.");
    }

    public void clearAndEnterData (WebElement element, String inputText) {
        this.wait.until(ExpectedConditions.visibilityOf(element));
        element.clear();
        element.sendKeys(inputText);
        CustomReporter.log("Message: " + inputText + " is entered");
    }

    public void clickOnWebelement (WebElement element) {
        this.wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
        CustomReporter.log("Message: " + element + " is pressed on.");
    }

    public void onlyClickWithoutClean(WebElement element, String inputText) {
        this.wait.until(ExpectedConditions.visibilityOf(element));
        element.sendKeys(inputText);
        CustomReporter.log("Message: " + inputText + " is entered");
    }
}
