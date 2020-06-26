package pageObjects;

import config.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by jack.forman on 16/10/2016.
 */
abstract class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;
    private PersonalDetails pd = new PersonalDetails("Robin", "Hood", "test@sherwood.com", "ghsjdc@test.com", "LadyM", "badPassword", "12/12/90", "Sherwood Forest", "Nottingham", "Minnesota", "12345", "6320864892", "Forest");


    BasePage() {
        driver = DriverFactory.getDriver();
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

    public void clearCookies() {
        driver.manage().deleteAllCookies();
    }

    public String tryTwice(By selector, String action) {
        wait.until(ExpectedConditions.presenceOfElementLocated(selector));
        WebElement element = driver.findElement(selector);
        String output = "";
        try {
            if (action.equals("click")) {
                element.click();
            } else if (action.equals("getText")) {
                output = element.getText();
            }
            return output;
        } catch (StaleElementReferenceException e) {
            if (action.equals("click")) {
                element.click();
            } else if (action.equals("getText")) {
                output = element.getText();
            }
            return output;
        }

    }


    void hoverAndClick(WebDriver driver, By elementToHover, By elementToClick) {
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(elementToHover)).click(driver.findElement(elementToClick)).build().perform();
    }

}
