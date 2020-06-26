package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by jack.forman on 22/10/2016.
 */
public class ShoppingCartPage extends BasePage {

    public HomePage homePage = new HomePage();

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
    private static final By DIFFERENTADDRESS = By.cssSelector("[value='436'] span");
    private static final By ADDRESS = By.cssSelector("[name='address1']");
    private static final By CITY = By.cssSelector("[name='city']");
    private static final By State = By.cssSelector("[name='id_state']");
    private static final By PostCode = By.cssSelector("[name='postcode']");
    private static final By Country = By.cssSelector("[name='id_country']");
    private static final By CONTINUE = By.cssSelector(".continue");
    private static final By VERIFYINVOICEADDRESS = By.cssSelector("#invoice_addresses");
    private static final By SIGNOUT = By.cssSelector("[href*='mylogout=']");




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

    public void adddifferentaddress( String action) {
    WebElement element = driver.findElement(DIFFERENTADDRESS);

    if (action.equals("click")) {
        element.click();
    } else if (action.equals("getText")) {
       element.getText();
    }
}

    public void addItemToCart() {
        homePage.itemAddedToCart();
        navigateToBasket();
        clickProceedToCheckout();
    }
    public void address(String address1) {
        findAndType(ADDRESS, address1);
    }

    public void city(String city) {
        findAndType(CITY, city);
    }

    public void postcode(String Postcode) {
        findAndType(PostCode, Postcode);
    }
    public void state(String state) {
        Select drpsize = new Select(driver.findElement(State));
        drpsize.selectByVisibleText(state);
    }
    public void save(){
        waitAndClick(CONTINUE);
    }
    public void country(String country) {
        Select drpsize = new Select(driver.findElement(Country));
        drpsize.selectByVisibleText(country);
    }
    public void clickModalProceedToCheckout() {
        waitAndClick(MODAL_PROCEED_TO_CHECKOUT_BUTTON);
    }

    public void verifyinvoiceaddress(){
        waitAndClick(By.cssSelector("#checkout-addresses-step"));
        WebElement invoice = driver.findElement(VERIFYINVOICEADDRESS);
        Assert.assertTrue(elementIsVisible(invoice));
    }

    public void clickSignOut(){
        waitAndClick(SIGNOUT);
    }
    public void verifyemptycart(String input){
        driver.getPageSource().contains(input);
    }

}


