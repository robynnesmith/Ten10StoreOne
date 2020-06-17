package pageObjects;

import org.apache.http.impl.conn.DefaultRoutePlanner;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class ProductPage extends BasePage {

    public ProductPage (WebDriver driver) {
        super(driver);
    }

    private static final By ADD_TO_CART_BUTTON = By.cssSelector(".btn.btn-primary.add-to-cart");
    private static final By BLOUSE_IMAGE = By.cssSelector("img[alt = 'Blouse'");
    private static final By QUANTITY_UP_BUTTON = By.cssSelector(".material-icons.touchspin-up");
    private static final By SIZE_DROPDWON = By.cssSelector("#group_1");
    private static final By WHITE_COLOUR_OPTION = By.cssSelector("input[value = '8']");

    public void productPageDisplayed() {
        WebElement productPage = driver.findElement(ADD_TO_CART_BUTTON);
        Assert.assertTrue(elementIsVisible(productPage));
    }

    public void navigatetoProductPage() {
        waitAndClick(BLOUSE_IMAGE);
    }

    public void selectQuantity() {
        waitAndClick(QUANTITY_UP_BUTTON);
    }

    public void selectSize() {
        Select size = new Select(driver.findElement(SIZE_DROPDWON));
        size.selectByVisibleText("M");
    }

    public void selectColour() {
        WebElement chooseColour = driver.findElement(WHITE_COLOUR_OPTION);
        chooseColour.click();
    }

}
