package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static Tests.Registration.driver;

/**
 * Created by jack.forman on 16/10/2016.
 */
abstract class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;
    private PersonalDetails pd = new PersonalDetails("Robin", "Hood", "test@sherwood.com", "ghsjdc@test.com", "LadyM", "Sherwood Forest", "Nottingham", "Minnesota", "12345", "6320864892", "Forest");


    BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 20);
    }

    void waitAndClick(By selector) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(selector));
        element.click();
    }

    boolean elementIsVisible(WebElement element) {
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            return true;
        } catch (ElementNotVisibleException e) {
            return false;
        }
    }

    void findAndType(By elementSelector, String inputString) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(elementSelector));
        element.sendKeys(inputString);
    }

    void waitUntilVisible(By selector){
        wait.until(ExpectedConditions.visibilityOfElementLocated(selector));
    }

    void waitUntilInvisible(By selector){
        wait.until(ExpectedConditions.invisibilityOfElementLocated(selector));
    }

    public PersonalDetails getPersonalDetails() {
        return pd;
    }
}
