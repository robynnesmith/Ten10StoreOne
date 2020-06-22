package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static junit.framework.TestCase.assertTrue;

/**
 * Created by jack.forman on 22/10/2016.
 */
public class ShoppingCartPage extends BasePage {

    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }

    public HomePage homePage = new HomePage(driver);

    private static final By ADD_TO_CART_BUTTON = By.cssSelector(".btn.btn-primary.add-to-cart");
    private static final By MODAL_CLOSE = By.cssSelector(".close");
    private static final By MODAL_BODY = By.cssSelector(".modal-body");
    private static final By CART_BUTTON = By.id("_desktop_cart");
    private static final By DELETE_FROM_CART_BUTTON = By.cssSelector(".remove-from-cart");
    private static final By NO_ITEMS_MESSAGE = By.cssSelector(".no-items");
    private static final By QUANTITY_UP_BUTTON = By.cssSelector(".material-icons.touchspin-up");
    private static final By QUANTITY_INPUT = By.cssSelector(".js-cart-line-product-quantity.form-control");
    private static final By QUANTITY_INPUT_VALUE_2 = By.cssSelector("input[value'2']");
    private static final By PRODUCT_QUANTITY_TEXT = By.cssSelector("#cart-subtotal-products span:first-child");
    private static final By PROCEED_TO_CHECKOUT_BUTTON = By.cssSelector(".checkout a");
    private static final By PERSONAL_INFORMATION_PAGE = By.id("checkout-personal-information-step");
    private static final By MODAL_PROCEED_TO_CHECKOUT_BUTTON = By.cssSelector(".cart-content-btn>a");


    public void addToCart() {
        waitAndClick(ADD_TO_CART_BUTTON);
    }

    public void navigateToBasket() {
        waitAndClick(MODAL_CLOSE);
        waitUntilInvisible(MODAL_BODY);
        waitAndClick(CART_BUTTON);
    }

    public void deleteItemFromBasket() {
        waitAndClick(DELETE_FROM_CART_BUTTON);
    }

    public void checkItemRemovedFromBasket() {
        waitUntilVisible(NO_ITEMS_MESSAGE);
        WebElement removedFromCart = driver.findElement(NO_ITEMS_MESSAGE);
        Assert.assertTrue(elementIsVisible(removedFromCart));
    }

    public void increaseQuantity() {
        waitAndClick(QUANTITY_UP_BUTTON);
    }

    public void verifyQuantityUpdated() {
        boolean textPresent = false;
        int count = 0;
        while (!textPresent && count < 20){
            String text = driver.findElement(PRODUCT_QUANTITY_TEXT).getText();
            if (text.equals("2 items")){
                textPresent = true;
            }
            count++;
        }
        WebElement quantityUpdated = driver.findElement(QUANTITY_INPUT);
        String updatedQuantity = quantityUpdated.getAttribute("value");
        Assert.assertEquals("2", updatedQuantity);
    }

    public void verifyProductCountUpdated() {
        WebElement productUpdated = driver.findElement(PRODUCT_QUANTITY_TEXT);
        String updatedProduct = productUpdated.getText();
        Assert.assertEquals("2 items", updatedProduct);
    }

    public void clickProceedToCheckout() {
        waitAndClick(PROCEED_TO_CHECKOUT_BUTTON);
    }

    public void isPersonalInformationPageDisplayed() {
        WebElement personalInformationPage = driver.findElement(PERSONAL_INFORMATION_PAGE);
        Assert.assertTrue(elementIsVisible(personalInformationPage));
    }



    public void addItemToCart() {
        homePage.itemAddedToCart();
        navigateToBasket();
        clickProceedToCheckout();
    }

    public void clickModalProceedToCheckout() {
        waitAndClick(MODAL_PROCEED_TO_CHECKOUT_BUTTON);
    }
}

