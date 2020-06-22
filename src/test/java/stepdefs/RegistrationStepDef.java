package stepdefs;

import config.DriverFactory;
import org.openqa.selenium.WebDriver;
import pageObjects.*;

public class RegistrationStepDef {
    private HomePage homepage = new HomePage();
    private ShoppingCartPage basketpage = new ShoppingCartPage();
    private SignInPage signInPage = new SignInPage();
    private CreateNewAccountPage createNewAccountPage = new CreateNewAccountPage();

}
