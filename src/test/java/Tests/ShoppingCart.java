package Tests;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pageObjects.*;

import static Tests.TestSuite.driverFactory;

/**
 * Created by jack.forman on 08/11/2016.
 */
public class ShoppingCart {

    private HomePage homePage = new HomePage();
    private ShoppingCartPage basketpage = new ShoppingCartPage();
    private SignInPage signInPage = new SignInPage();
    private ProductPage productPage = new ProductPage();
    private CheckoutPage checkoutPage = new CheckoutPage();


    @Before
    public void individualSetUp() {
        homePage.clearCookies();
        homePage.goTo();
    }

    /**
     * Remove item from shopping cart
     * Pre-Condition - Item must be in basket
     * Navigate to basket
     * Click Delete
     * Verify Item is removed from Basket
     * Extension - verify pricing and totals are updated to reflect accurately
     */
    @Test
    public void removeItemFromShoppingBasket() {

        homePage.itemAddedToCart();
        basketpage.navigateToBasket();
        basketpage.deleteItemFromBasket();
        basketpage.checkItemRemovedFromBasket();

    }

    /**
     * Increase quantity of product
     * Pre-Condition - Must have one item in basket
     * Navigate to basket
     * Increase quantity of product
     * Verify basket updated with correct quantity
     * Verify Product counter (Top right) is updated
     * Extension - verify pricing and totals are updated to reflect accurately
     */
    @Test
    public void increaseQuantityOfProductInBasket() {
        homePage.itemAddedToCart();
        basketpage.navigateToBasket();
        basketpage.increaseQuantity();
        basketpage.verifyQuantityUpdated();
        basketpage.verifyProductCountUpdated();

    }

    /**
     * Proceed to checkout - not signed in
     * Pre-Condition - Must have one item in basket && not be signed in
     * Navigate to basket
     * Click proceed to checkout
     * Verify sign in page displayed
     */
    @Test
    public void proceedToCheckoutNotLoggedIn() {
        homePage.itemAddedToCart();
        basketpage.navigateToBasket();
        basketpage.clickProceedToCheckout();
        basketpage.isPersonalInformationPageDisplayed();
    }

    /**
     * Proceed to checkout - signed in
     * Pre-Condition - Must have one item in basket && be signed in
     * Navigate to basket
     * Click proceed to checkout
     * Delivery Address Page is shown
     * Click proceed to checkout
     * Shipping page is shown
     * Agree to terms of service
     * Click proceed to checkout
     * Payment page is displayed
     * Click pay by bank wire
     * Confirm order
     * Order confirmation page is displayed
     */
    @Test
    public void proceedToCheckoutAndBuyLoggedIn() {
        homePage.navigateToSignInPage();
        signInPage.login();
        homePage.goTo();
        homePage.addItemToCart();
        basketpage.clickModalProceedToCheckout();
        basketpage.clickProceedToCheckout();
        checkoutPage.deliveryAddressSectionDisplayed();
        checkoutPage.clickProceedToNextSection();
        checkoutPage.shippingPageDisplayed();
        checkoutPage.enterShippingComment();
        checkoutPage.clickProceedToNextSection();
        checkoutPage.paymentPageDisplayed();
        checkoutPage.clickPayByBankWire();
        checkoutPage.agreeToTerms();
        checkoutPage.confirmOrder();
        checkoutPage.orderConfirmationDisplayed();
    }

    /**
     * Make invoice address different to delivery address
     * Must have  on item in basket and be logged in
     * Navigate to basket
     * Click proceed to checkout
     * Delivery Address Page is shown
     * Make invoice address different
     * <p>
     * Click continue button
     * Verify shipping method displayed
     **/

    @Test
    public void differentaddresforinvoice() {
        homePage.navigateToSignInPage();
        signInPage.login();
        homePage.goTo();
        homePage.hoverOverItem();
        homePage.addItemToCart();
        homePage.addedToCart();
        basketpage.navigateToBasket();
        basketpage.clickProceedToCheckout();
        checkoutPage.deliveryAddressSectionDisplayed();
        basketpage.adddifferentaddress();
// basketpage.address("g");
//   basketpage.city("j");
//basketpage.postcode("96701");
//   basketpage.state("Hawaii");
//basketpage.country("United States");
        basketpage.save();
        basketpage.verifyinvoiceaddress();
    }

    /**
     * Multiple items in shopping cart displayed correctly
     * Navigate to basket
     * Verify that all items are displayed
     * Verify that product counter and prices are correct
     **/
    @Test
    public void multipleitems() {
        homePage.navigateToSignInPage();
        signInPage.login();
        homePage.goTo();
        homePage.itemAddedToCart();
        basketpage.navigateToBasket();
        basketpage.increaseQuantity();
        basketpage.verifyQuantityUpdated();
        basketpage.verifyProductCountUpdated();

    }

    /**
     * Navigate to basket
     * Click proceed to checkout
     * Logout
     * Verify cart emptied when sign back in.
     **/
    @Test
    public void emptybasketlogout() {
        homePage.navigateToSignInPage();
        signInPage.login();
        homePage.goTo();
        homePage.hoverOverItem();
        homePage.addItemToCart();
        homePage.addedToCart();
        basketpage.navigateToBasket();
        basketpage.clickSignOut();
        basketpage.verifyemptycart("(0)");

    }
}