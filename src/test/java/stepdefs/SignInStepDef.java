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

public class SignInStepDef {
    private HomePage homepage = new HomePage();
    private ShoppingCartPage basketpage = new ShoppingCartPage();
    private SignInPage signInPage = new SignInPage();
    private CreateNewAccountPage createNewAccountPage = new CreateNewAccountPage();

    @Given("^the user is on the \"([^\"]*)\"page$")
    public void theUserIsOnThePage(String page) {
        homepage.goTo();
        switch (page) {
            case "sign in":
                homepage.navigateToSignInPage();
                break;
            default:
                throw new IllegalArgumentException("Unrecognised page provided");
        }
    }

    @And("^navigates to the forgotten password page$")
    public void forgottenPasswordPage() {
        signInPage.forgottenPassword();
    }

    @When("^the user fills in sign in details with \"([^\"]*)\" email$")
    public void theUserCompletesSignInForm(String emailType) {
        signInPage.enterSignInEmailAddress(emailType);
        signInPage.login();
    }

    @When("^the user fills in forgotten password with an \"([^\"]*)\" email$")
    public void theUserCompletesForgottenPassword(String emailType) {
        signInPage.enterForgottenPasswordEmailAddress(emailType);
        signInPage.clickRetrievePassword();
    }

    @When("^the user selects sign out$")
    public void theUserSignsOut() {
        signInPage.clickSignOut();
    }

    @When("^the user updates account preferences")
    public void userChangesAccountSettings(String passwordType) {
        signInPage.login();
        signInPage.updateAccountPreferences();
    }

    @When("^the user signs in with invalid password$")
    public void userSignsInWithInvalidPassword(String emailAddress, String passwordType) {
        signInPage.enterSignInEmailAddress(emailAddress);
        signInPage.invalidPasswordLogin();
    }

    @When("^the user adds a new address$")
    public void userAddsNewAddressToAccount() {
        signInPage.login();
        signInPage.addNewAddress();
    }

    @When("the user adds a message to order")
    public void userAddsMessageToOrder() {
        signInPage.login();
        signInPage.addMessageToExistingOrder();
    }

    @Then("^the user is signed in$")
    public void theUserIsSignedIn() {
        signInPage.successfulSignIn();
    }

    @Then("^error message is displayed$")
    public void theUnregisteredUserAlertIsDisplayed() {
        signInPage.unregisteredUserAlert();
    }

    @Then("^the user is signed out$")
    public void theUserIsSignedOut() {
        signInPage.userSignedOut();
    }

    @And("^the users account is displayed$")
    public void theUsersAccountIsDisplayed() {
        signInPage.userIsSignedIn();
    }

    @Then("^the forgotten password result is displayed$")
    public void forgottenPasswordResultDisplayed() {
        signInPage.confirmationMessage();
    }

    @Then("^the updated account alert is displayed$")
    public void updatedAccountAlertDisplayed() {
        signInPage.accountPreferencesUpdated();
    }

    @Then("^the invalid password alert is displayed")
    public void invalidPasswordAlertDisplayed() {
        signInPage.invalidPasswordLoginAlert();
    }

    @Then("the order is updated")
    public void orderUpdated() {
        signInPage.accountPreferencesUpdated();

    }

}