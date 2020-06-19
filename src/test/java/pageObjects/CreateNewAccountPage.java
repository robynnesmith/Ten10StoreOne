package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by jack.forman on 23/10/2016.
 */
public class CreateNewAccountPage extends BasePage {

    public CreateNewAccountPage(WebDriver driver) {
        super(driver);
    }

    private static final By FIRST_NAME_INPUT = By.name("firstname");
    private static final By LAST_NAME_INPUT= By.name("lastname");
    private static final By EMAIL_INPUT = By.name("email");
    private static final By PASSWORD_INPUT = By.name("password");
    private static final By BIRTH_DATE_INPUT = By.name("birthday");
    private static final By SAVE_BUTTON = By.cssSelector(".form-control-submit");
    private static final By INVALID_ALERT = By.cssSelector(".alert.alert-danger");


    public void enterPersonalDetails() {
        PersonalDetails pd = getPersonalDetails();
        findAndType(FIRST_NAME_INPUT, pd.getFirstName());
        findAndType(LAST_NAME_INPUT, pd.getLastName());
        findAndType(EMAIL_INPUT, pd.getEmail());
        findAndType(PASSWORD_INPUT, pd.getPassword());
    }

    public void clickSave() {
        waitAndClick(SAVE_BUTTON);
    }

    public void enterNumericNamePersonalDetails(){
        PersonalDetails npd = getPersonalDetails();
        findAndType(FIRST_NAME_INPUT, "12345");
        findAndType(LAST_NAME_INPUT, npd.getLastName());
        findAndType(EMAIL_INPUT, "1234@hotmail.com");
        findAndType(PASSWORD_INPUT, npd.getPassword());
    }

    public void numericPasswordInput(){
        PersonalDetails npi = getPersonalDetails();
        findAndType(FIRST_NAME_INPUT, npi.getFirstName());
        findAndType(LAST_NAME_INPUT, npi.getLastName());
        findAndType(EMAIL_INPUT, npi.getEmail());
        findAndType(PASSWORD_INPUT, "1234567");
    }

    public void invalidBirthdateInput(){
        PersonalDetails ibi = getPersonalDetails();
        findAndType(FIRST_NAME_INPUT, ibi.getFirstName());
        findAndType(LAST_NAME_INPUT, ibi.getLastName());
        findAndType(EMAIL_INPUT, "robinredbreast@hotmail.com");
        findAndType(PASSWORD_INPUT, ibi.getPassword());
        findAndType(BIRTH_DATE_INPUT, "2019");
    }

    public void invalidNameAlert(){
        WebElement invalidNameError = driver.findElement(INVALID_ALERT);
        String invalidName = invalidNameError.getText();
        Assert.assertEquals("Invalid name", invalidName);
    }

    public void invalidBirthdateAlert(){
        WebElement invalidBirthdateError = driver.findElement(INVALID_ALERT);
        String invalidBirthdate = invalidBirthdateError.getText();
        Assert.assertEquals("Format should be 05/31/1970.", invalidBirthdate);
    }
}
