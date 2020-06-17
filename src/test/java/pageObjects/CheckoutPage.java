package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class CheckoutPage extends BasePage {

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    private PersonalDetails pd = getPersonalDetails();
    private static final By ADDRESS_SECTION = By.id("checkout-addresses-step");
    private static final By ADDRESS_INPUT = By.name("address1");
    private static final By CITY_INPUT = By.name("city");
    private static final By STATE_DROPDOWN = By.name("id_state");
    private static final By POSTCODE_INPUT = By.name("postcode");
    private static final By SHIPPING_METHOD_SECTION = By.id("checkout-delivery-step");
    private static final By TERMS_CHECKBOX = By.id("conditions_to_approve[terms-and-conditions]");
    private static final By PAYMENT_SECTION = By.id("checkout-payment-step");
    private static final By BANK_WIRE_RADIO_BUTTON = By.cssSelector("#payment-option-2");
    private static final By ORDER_BUTTON = By.cssSelector("#payment-confirmation button");
    private static final By ORDER_CONFIRMATION_MESSAGE = By.cssSelector("#content-hook_order_confirmation");
    private static final By CONTINUE_BUTTON = By.cssSelector(".continue.btn.btn-primary.float-xs-right");
    private static final By SHIPPING_COMMENT_INPUT = By.id("delivery_message");

    public void deliveryAddressEnterDisplayed() {

        WebElement enterAddress = driver.findElement(ADDRESS_SECTION);
        Assert.assertTrue(elementIsVisible(enterAddress));

        findAndType(ADDRESS_INPUT, pd.getAddress());
        findAndType(CITY_INPUT, pd.getCity());
        Select state = new Select(driver.findElement(STATE_DROPDOWN));
        state.selectByVisibleText(pd.getState());
        findAndType(POSTCODE_INPUT, pd.getPostcode());
    }


    public void shippingPageDisplayed() {
        WebElement shipping = driver.findElement(SHIPPING_METHOD_SECTION);
        Assert.assertTrue(elementIsVisible(shipping));

    }

    public void agreeToTerms() {
        driver.findElement(TERMS_CHECKBOX).click();
    }

    public void paymentPageDisplayed() {
        WebElement payment = driver.findElement(PAYMENT_SECTION);
        Assert.assertTrue(elementIsVisible(payment));
    }

    public void clickPayByBankWire() {
        driver.findElement(BANK_WIRE_RADIO_BUTTON).click();
    }

    public void confirmOrder() {
        waitAndClick(ORDER_BUTTON);
    }

    public void orderConfirmationDisplayed() {
        waitUntilVisible(ORDER_CONFIRMATION_MESSAGE);
    }

    public void clickProceedToNextSection() {
        boolean clickable = false;
        List<WebElement> continueButtons = driver.findElements(CONTINUE_BUTTON);
        while (!clickable) {
            for (WebElement continueButton : continueButtons) {
                try {
                    continueButton.click();
                    clickable = true;
                } catch (ElementNotInteractableException e) {

                }
            }
        }
    }

    public void deliveryAddressSectionDisplayed() {
        waitUntilVisible(ADDRESS_SECTION);
    }

    public void enterShippingComment() {
        findAndType(SHIPPING_COMMENT_INPUT, "Nothing to add");
    }
}
