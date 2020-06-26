package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertTrue;

/**
 * Created by jack.forman on 23/10/2016.
 */
public class SignInPage extends BasePage {

    private PersonalDetails pd = getPersonalDetails();
    private WebDriverWait wait = new WebDriverWait(driver, 10);

    private static final By EMAIL_ADDRESS_INPUT_BOX = By.cssSelector("input#email_create");
    private static final By CREATE_NEW_ACCOUNT_BUTTON = By.cssSelector(".no-account>a");
    private static final By INVALID_ALERT = By.cssSelector(".alert.alert-danger");
    private static final By EMAIL_INPUT = By.name("email");
    private static final By PASSWORD_INPUT = By.name("password");
    private static final By SIGN_IN_BUTTON = By.cssSelector("#login-form button[type='submit']");
    private static final By SIGN_OUT_BUTTON = By.cssSelector(".logout.hidden-sm-down");
    private static final By FORGOTTEN_PASSWORD_LINK = By.cssSelector(".forgot-password");
    private static final By SEND_RESET_LINK_BUTTON = By.cssSelector(".forgotten-password button:first-of-type");
    private static final By FORGOTTEN_EMAIL_MESSAGE_ERROR = By.cssSelector(".ps-alert-error");
    private static final By FORGOTTEN_EMAIL_MESSAGE_SUCCESS = By.cssSelector(".ps-alert-success");
    private static final By ACCOUNT_DETAILS = By.cssSelector("[id='identity-link']");
    private static final By OPTIN_BUTTON = By.name("optin");
    private static final By NEWSLETTER_BUTTON = By.name("newsletter");
    private static final By SAVE_ACCOUNT_UPDATES = By.cssSelector(".btn.btn-primary.form-control-submit.float-xs-right");
    private static final By ACCOUNT_SUCCESSFULLY_UPDATED = By.cssSelector(".alert.alert-success");
    private static final By ADDRESS_PAGE = By.cssSelector("[id='addresses-link']");
    private static final By ADD_NEW_ADDRESS = By.cssSelector("[href='http://3.11.70.191/index.php?controller=address']");
    private static final By ADDRESS_LINE_1 = By.name("address1");
    private static final By CITY = By.name("city");
    private static final By STATE = By.cssSelector("[name='id_state'][value='1']");
    private static final By POST_CODE = By.name("postcode");
    private static final By SAVE_NEW_ADDRESS = By.cssSelector(".btn.btn-primary.float-xs-right");
    private static final By ORDER_HISTORY_PAGE = By.cssSelector("[id='history-link']");
    private static final By MOST_RECENT_ORDER_BUTTON = By.cssSelector(".order:first-child");
    private static final By ADD_MESSAGE = By.name("msgText");
    private static final By SEND_MESSAGE = By.name("submitMessage");
    private static final By ACCOUNT_PREFERENCES_UPDATED = By.cssSelector("[data-alert='success']");


    public void enterCreateNewAccountEmailAddress(String emailAddress) {
        findAndType(EMAIL_ADDRESS_INPUT_BOX, emailAddress);
    }

    public void clickCreateAnAccount() {
        waitAndClick(CREATE_NEW_ACCOUNT_BUTTON);
    }

    public void alreadyRegisteredAlertPresent() {
        WebElement alertBox = driver.findElement(INVALID_ALERT);
        assertTrue(elementIsVisible(alertBox));
    }

    public void enterPasswordSignIn(String password){findAndType(PASSWORD_INPUT, password);}

    public void enterPassword() {
        findAndType(PASSWORD_INPUT, pd.getPassword());
    }

    public void enterInvalidPassword() {findAndType(PASSWORD_INPUT, pd.getInvalidPassword());}

    public void successfulSignIn() {
        waitUntilVisible(SIGN_OUT_BUTTON);
        assertTrue(elementIsVisible(driver.findElement(SIGN_OUT_BUTTON)));
    }

    public void enterSignInEmailAddress(String emailAddress) {
        findAndType(EMAIL_INPUT, emailAddress);
    }

    public void clickLogIn() {
        waitAndClick(SIGN_IN_BUTTON);
    }

    public void unregisteredUserAlert() {
        WebElement alertBox = driver.findElement(INVALID_ALERT);
        assertTrue(elementIsVisible(alertBox));
    }

    public void forgottenPassword() {
        waitAndClick(FORGOTTEN_PASSWORD_LINK);
    }

    public void enterForgottenPasswordEmailAddress(String email) {
        findAndType(EMAIL_INPUT, email);
    }

    public void clickRetrievePassword() {
        waitAndClick(SEND_RESET_LINK_BUTTON);
    }

    public void confirmationMessage() {
        try {
            WebElement successAlertBox = driver.findElement(FORGOTTEN_EMAIL_MESSAGE_SUCCESS);
            assertTrue(elementIsVisible(successAlertBox));
        } catch (Exception e) {
            WebElement alertBox = driver.findElement(FORGOTTEN_EMAIL_MESSAGE_ERROR);
            assertTrue(elementIsVisible(alertBox));
        }
    }

    public void clickSignOut() {
        waitAndClick(SIGN_OUT_BUTTON);
    }

    public void addNewAddress(){
        waitAndClick(ADDRESS_PAGE);
        waitAndClick(ADD_NEW_ADDRESS);
        findAndType(ADDRESS_LINE_1, "10 Church");
        findAndType(CITY, "Smallville");
        waitAndClick(STATE);
        findAndType(POST_CODE, "12334");


    }

    public void saveNewAddress(){
        waitAndClick(SAVE_NEW_ADDRESS);
    }

    public void userIsSignedIn() {
        WebElement signOutButton = driver.findElement(SIGN_OUT_BUTTON);
        assertTrue(elementIsVisible(signOutButton));
    }

    public void userSignedOut() {
        waitUntilInvisible(SIGN_OUT_BUTTON);
        driver.navigate().refresh();
        WebElement signInButton = driver.findElement(SIGN_IN_BUTTON);
        assertTrue(elementIsVisible(signInButton));
    }

    public void login() {
        enterSignInEmailAddress(pd.getEmail());
        enterPassword();
        clickLogIn();
        successfulSignIn();
    }

        public void invalidLogin() {
        enterSignInEmailAddress(pd.getInvalidEmail());
        enterPassword();
        clickLogIn();
        unregisteredUserAlert();
    }
    public void invalidPasswordLogin(){
        enterSignInEmailAddress(pd.getEmail());
        enterInvalidPassword();
    }

    public void invalidPasswordLoginAlert(){
        waitAndClick(INVALID_ALERT);
    }

    public void forgottenPasswordCheck() {
        forgottenPassword();
        enterForgottenPasswordEmailAddress(pd.getEmail());
        clickRetrievePassword();
        confirmationMessage();
    }


    public void invalidNameAlert() {
        WebElement alertBox = driver.findElement(INVALID_ALERT);
        assertTrue(elementIsVisible(alertBox));
    }

    public void invalidBirthdateAlert() {
        WebElement alertBox = driver.findElement(INVALID_ALERT);
        assertTrue(elementIsVisible(alertBox));
    }

    public void updateAccountPreferences(){
        waitAndClick(ACCOUNT_DETAILS);
        enterPassword();
        WebElement offersOptin = driver.findElement(OPTIN_BUTTON);
        ((JavascriptExecutor) driver).executeScript("arguments[0].checked=true;", offersOptin);
        WebElement newsletterOptin = driver.findElement(NEWSLETTER_BUTTON);
        ((JavascriptExecutor) driver).executeScript("arguments[0].checked=true;", newsletterOptin);
        waitAndClick(SAVE_ACCOUNT_UPDATES);
    }
    public void accountPreferencesUpdated(){
        WebElement alertBox = driver.findElement(ACCOUNT_PREFERENCES_UPDATED);
        assertTrue(elementIsVisible(alertBox));
    }

    public void addMessageToExistingOrder(){
        waitAndClick(ORDER_HISTORY_PAGE);
        waitAndClick(MOST_RECENT_ORDER_BUTTON);
        findAndType(ADD_MESSAGE, "leave next door if not in");
        waitAndClick(SEND_MESSAGE);
    }

}
