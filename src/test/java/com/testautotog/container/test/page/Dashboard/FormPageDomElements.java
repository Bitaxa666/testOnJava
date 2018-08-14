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
public class FormPageDomElements extends PageObject {

    /*Find elements on the page. */

    //Form page - User emailt field
    @CacheLookup
    @FindBy(css="input[type=email]")
    private WebElement inputUserEmailField;

    //Form page - Birthday date input field
    @CacheLookup
    @FindBy(css="input[type=date]")
    private WebElement inputBirthdayDateField;

    //Form page - User name input field
    @CacheLookup
    @FindBy(css=".quantumWizTextinputPaperinputInputArea input[type=text]:first-child")
    private WebElement inputUserNameField;

    //Form page - Click on user's gender
    @CacheLookup
    @FindBy(css=".exportDropDown")//1 and 5 element
    private WebElement clickGenderdropmenu;

    //Form page - Select user's gender
    @CacheLookup
    @FindBy(css=".quantumWizMenuPaperselectContent.exportContent")
    private List<WebElement> selectGenderdropmenu;

    //Form page - Select answer
    @CacheLookup
    @FindBy(css=".quantumWizTogglePapercheckboxInnerBox")
    private List<WebElement> selectAnswer;

    //Submit button
    @CacheLookup
    @FindBy(css="span.quantumWizButtonPaperbuttonLabel")
    private WebElement submitButton;

    @CacheLookup
    @FindBy(css=".freebirdFormviewerViewResponseConfirmationMessage")
    private WebElement successfulSendMessage;

    public FormPageDomElements(WebDriver driver) {
        super(driver);
    }
}
