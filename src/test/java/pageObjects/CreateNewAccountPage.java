package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by jack.forman on 23/10/2016.
 */
public class CreateNewAccountPage extends BasePage {

    private static final By FIRST_NAME_INPUT = By.name("firstname");
    private static final By LAST_NAME_INPUT= By.name("lastname");
    private static final By EMAIL_INPUT = By.name("email");
    private static final By PASSWORD_INPUT = By.name("password");
    private static final By BIRTHDATE_INPUT = By.name("birthday");
    private static final By SAVE_BUTTON = By.cssSelector(".form-control-submit");



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

    public void registerUserWithEmail(String emailType){
        PersonalDetails pd = getPersonalDetails();
        findAndType(FIRST_NAME_INPUT, pd.getFirstName());
        findAndType(LAST_NAME_INPUT, pd.getLastName());
        findAndType(EMAIL_INPUT, pd.getEmail(emailType));
        findAndType(PASSWORD_INPUT, pd.getPassword());
    }

    public void registerWithNumericName(String nameType){
        PersonalDetails pd = getPersonalDetails();
        findAndType(FIRST_NAME_INPUT, pd.getFirstName(nameType));
        findAndType(LAST_NAME_INPUT, pd.getLastName());
        findAndType(EMAIL_INPUT, pd.getEmail());
        findAndType(PASSWORD_INPUT, pd.getPassword());
    }

    public void registerWithNumericPassword(String passwordType){
        PersonalDetails pd = getPersonalDetails();
        findAndType(FIRST_NAME_INPUT, pd.getFirstName());
        findAndType(LAST_NAME_INPUT, pd.getLastName());
        findAndType(EMAIL_INPUT, pd.getEmail());
        findAndType(PASSWORD_INPUT, pd.getPassword(passwordType));
    }

    public void registerWithInvalidBirthdate(String birthdateType){
        PersonalDetails pd = getPersonalDetails();
        findAndType(FIRST_NAME_INPUT, pd.getFirstName());
        findAndType(LAST_NAME_INPUT, pd.getLastName());
        findAndType(EMAIL_INPUT, pd.getEmail());
        findAndType(PASSWORD_INPUT, pd.getPassword());
        findAndType(BIRTHDATE_INPUT, pd.getBirthdate(birthdateType));
    }

}
