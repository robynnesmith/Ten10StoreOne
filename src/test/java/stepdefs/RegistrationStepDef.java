package stepdefs;

import config.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pageObjects.CreateNewAccountPage;
import pageObjects.SignInPage;
import pageObjects.HomePage;
import pageObjects.ShoppingCartPage;
import pageObjects.ProductPage;

public class RegistrationStepDef {
    private HomePage homepage = new HomePage();
    private ShoppingCartPage basketpage = new ShoppingCartPage();
    private SignInPage signInPage = new SignInPage();
    private CreateNewAccountPage createNewAccountPage = new CreateNewAccountPage();
    private ProductPage productPage = new ProductPage();

    @Given("^the user is on the \"([^\"]*)\" page$")
    public void theUserIsOnThePage(String page) {
        homepage.goTo();
        switch (page) {
            case "homepage":
                homepage.goTo();
                break;
            case "sign in":
                homepage.navigateToSignInPage();
                break;
            case "product":
                homepage.clickMoreButton();
                break;
            default:
                throw new IllegalArgumentException("Unrecognised page provided");
        }
    }

    @When("^the user completes the registration form with an \"([^\"]*)\" email address$")
    public void theUserCompletesRegistrationFormWithAnEmailAddress(String emailType) {
        createNewAccountPage.registerUserWithEmail(emailType);
        createNewAccountPage.clickSave();
    }

    @When("^the user completes registration form with a numeric name$")
    public void theUserCompletesRegistrationWithNumericName(String nameType) {
        createNewAccountPage.registerWithNumericName(nameType);
        createNewAccountPage.clickSave();
    }

    @When("^the user completes registration form with a numeric password$")
    public void theUserCompletesRegistrationWithNumericPassword(String passwordType) {
        createNewAccountPage.registerWithNumericPassword(passwordType);
        createNewAccountPage.clickSave();
    }

    @When("^the user completes registration form with an invalid birthdate$")
    public void theUserCompletesRegistrationWithInvalidBirthdate(String birthdateType) {
        createNewAccountPage.registerWithInvalidBirthdate(birthdateType);
        createNewAccountPage.clickSave();
    }

    @Then("^the already registered alert is displayed$")
    public void the_already_registered_alert_is_displayed() {
        signInPage.unregisteredUserAlert();
    }

    @Then("^the account page is displayed$")
    public void theAccountPageIsDisplayed() {
        signInPage.userIsSignedIn();
    }

    @Then("^the invalid name alert is displayed$")
    public void the_invalid_name_alert_is_displayed() {
        signInPage.invalidNameAlert();
    }

    @Then("^the invalid birthdate alert is displayed$")
    public void invalidBirthdateIsDisplayed() {
        signInPage.invalidBirthdateAlert();
    }

}

