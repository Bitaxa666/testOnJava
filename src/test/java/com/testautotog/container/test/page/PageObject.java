package test.java.com.testautotog.container.test.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;

/**
 * Created by user on 7/18/18.
 */
public class PageObject {

    protected WebDriver driver;

    //Base Page class
    public PageObject(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

}
