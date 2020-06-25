package Tests;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pageObjects.HomePage;
import pageObjects.SignInPage;

import static Tests.TestSuite.driverFactory;

/**
 * Created by jack.forman on 30/10/2016.
 */
public class SignIn {

    private HomePage homepage = new HomePage();
    private SignInPage signInPage = new SignInPage();


    @Before
    public void individualSetUp() {
        homepage.clearCookies();
        homepage.goTo();
    }


    /**
     * Sign in as Registered User
     * Pre-Conditions - Must have signIn information for a registered user
     * Navigate to Sign In Page
     * Fill in Email Address
     * Fill in Password
     * Click Sign In
     * Verify My Account is Displayed
     */
    @Test
    public void signInAsRegisteredUser() {
        homepage.navigateToSignInPage();
        signInPage.login();
    }

    /**
     * Cannot sign in as unregistered customer
     * Pre-Conditions - Must have Email address and Password of unregistered customer
     * Navigate to Sign in Page
     * Fill in Email Address
     * Fill in Password
     * Click Sign in
     * Verify Error Message is Displayed
     */
    @Test
    public void signInAsUnRegisteredUser() {
        homepage.navigateToSignInPage();
        signInPage.invalidLogin();
        signInPage.unregisteredUserAlert();

    }

    /**
     * Forgotten Password
     * Pre-Conditions - Must have signIn information for a registered user
     * Navigate to Sign In Page
     * Click Forgotten Password
     * Enter E mail Address
     * Click retrieve password
     * Confirmation message displayed
     */
    @Test
    public void forgottenPassword() {

        homepage.navigateToSignInPage();
        signInPage.forgottenPasswordCheck();
    }

    @Test
    public void changeAccountPreferences() {
        homepage.navigateToSignInPage();
        signInPage.login();
        signInPage.updateAccountPreferences();
        signInPage.accountPreferencesUpdated();
    }

    /**
     * Able to sign out
     * Pre-Conditions - Must have signIn information for a registered user
     * Navigate to Sign In Page
     * Click sign out
     * Verify customer signed out
     */
    @Test
    public void signOut() {

        homepage.navigateToSignInPage();
        signInPage.login();
        signInPage.clickSignOut();
        signInPage.userSignedOut();

    }
}
