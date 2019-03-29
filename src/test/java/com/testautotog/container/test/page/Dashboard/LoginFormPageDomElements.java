package test.java.com.testautotog.container.test.page.Dashboard;

import lombok.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import test.java.com.testautotog.container.test.page.PageObject;

import java.util.List;


/**
 * Created by user on 7/19/18.
 */

@Data @Getter @Setter
public class LoginFormPageDomElements extends PageObject {

    /**
    *Find elements on the page. https://autotest-prerelease.intesting.ca/login
     */

    //Form page - 'login' field
    @CacheLookup
    @FindBy(css="#username")
    private WebElement inputUserLoginField;

    //Form page - 'password' field
    @CacheLookup
    @FindBy(css="#password")
    private WebElement inputUserPasswordField;

    //Redirect container
    @CacheLookup
    @FindBy(css="#tile-container .tile-page")
    private WebElement userMainDashboard;

    //Submit button
    @CacheLookup
    @FindBy(css="#login-page > .btn_submit")
    private WebElement submitButton;

    //password-element error
    @CacheLookup
    @FindBy(css="#username-element > .error")
    private WebElement unsuccessfulNameMessage;

    //login-element error
    @CacheLookup
    @FindBy(css="#password-element > .error")
    private WebElement unsuccessfulPwdMessage;

    public LoginFormPageDomElements(WebDriver driver) {
        super(driver);
    }
}
