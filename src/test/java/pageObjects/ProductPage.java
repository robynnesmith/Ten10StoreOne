package pageObjects;

import org.apache.http.impl.conn.DefaultRoutePlanner;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class ProductPage extends BasePage {

    private static final By ADD_TO_CART_BUTTON = By.cssSelector(".btn.btn-primary.add-to-cart");
    final By DRESS_IMAGE = By.cssSelector("img[alt = 'Printed Chiffon Dress']");
    final By SHIRT_IMAGE = By.cssSelector(" img[alt = 'Faded Short Sleeves T-shirt'");
    private static final By QUANTITY_UP_BUTTON = By.cssSelector(".material-icons.touchspin-up");
    private static final By SIZE_DROPDWON = By.cssSelector("#group_1");
    private static final By SIZE_MEDIUM = By.cssSelector("[title='M']");
    private static final By GREEN_COLOUR_OPTION = By.cssSelector("input[value = '15']");
    private static final By PRODUCT_AVAILABILITY = By.cssSelector("#product-availability");

    public void productPageDisplayed() {
        WebElement productPage = driver.findElement(ADD_TO_CART_BUTTON);
        Assert.assertTrue(elementIsVisible(productPage));
    }

    public void navigatetoProductPage() {
        waitAndClick(DRESS_IMAGE);
    }

    public void navigatetoTshirtPage(){waitAndClick(SHIRT_IMAGE);}

    public void selectQuantity() {
        waitAndClick(QUANTITY_UP_BUTTON);
    }

    public void selectSize() {

        wait.until(ExpectedConditions.presenceOfElementLocated(SIZE_DROPDWON));
//        waitAndClick(SIZE_DROPDWON);
//        waitAndClick(SIZE_MEDIUM);
        Select size = new Select(driver.findElement(SIZE_DROPDWON));
        size.selectByVisibleText("M");


    }

    public void selectColour() {
        this.tryTwice(GREEN_COLOUR_OPTION, "click");
    }

    public void productAvailability(){
        WebElement outOfStock = driver.findElement(PRODUCT_AVAILABILITY);
        Assert.assertTrue(elementIsVisible(outOfStock));
    }

}
