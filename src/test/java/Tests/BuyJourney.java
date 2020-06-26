package Tests;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pageObjects.HomePage;
import pageObjects.ProductPage;
import pageObjects.ShoppingCartPage;
import pageObjects.SignInPage;

import java.util.Random;

import static Tests.TestSuite.driverFactory;

/**
 * Created by jack.forman on 23/10/2016.
 */
public class BuyJourney {

    private HomePage homepage = new HomePage();
    private ShoppingCartPage basketpage = new ShoppingCartPage();
    private SignInPage signInPage = new SignInPage();
    private ProductPage productPage = new ProductPage();

    @Before
    public void individualSetUp() {
        homepage.clearCookies();
        homepage.goTo();
        homepage.maximiseBrowserWindow();
    }

    /**
     * Select Item from homepage, takes to product page
     * On homepage
     * Hover over a product's image
     * Click More Button
     * Verify product page is displayed
     */
    @Test
    public void selectItemFromHomepage() {
        homepage.hoverOverItem();
        homepage.clickMoreButton();
        productPage.productPageDisplayed();
    }


    /**
     * Add product to Cart from homepage
     * Hover over product from homepage
     * Click add to cart
     * Verify added to cart
     */
    @Test
    public void addProductToCartFromHomepage() {
        homepage.hoverOverItem();
        homepage.addItemToCart();
        homepage.addedToCart();

    }

    /**
     * Add product to cart from Product page
     * On product page
     * Select Quantity
     * Select Size
     * Select Colour (if available)
     * Click add to cart
     * Verify Added to Cart
     */
    @Test
    public void addProductToCartFromProductPage() {

        productPage.navigatetoProductPage();
        productPage.selectQuantity();
        productPage.selectSize();
        productPage.selectColour();
        basketpage.addToCart();
        homepage.addedToCart();

    }

    @Test
    public void addItemViaCatalogueSearch() {
        homepage.search("Printed dress");
        homepage.clickSearch();
        homepage.addItemToCart();
        homepage.addedToCart();

    }

    @Test
    public void addItemViaSummerDressesInMenu() {
        homepage.hoverOverCategory();
        homepage.clickSummerDresses();
        homepage.hoverAndClickQuickview();
        productPage.selectSize();
        productPage.selectQuantity();
        homepage.addToCartButton();
        homepage.addedToCart();
    }

    @Test
    public void notEnoughInStock(){
        productPage.navigatetoProductPage();
        basketpage.inputIncreaseQuantity("500");
        productPage.productAvailability();

    }

    @Test
    public void addACommentToOrders(){
        homepage.navigateToSignInPage();
        signInPage.enterSignInEmailAddress("jellybaby@gmail.com");
        signInPage.enterPasswordSignIn("sweet");
        signInPage.clickLogIn();
        basketpage.goToOrders();
        basketpage.clickOrderDetails();
        basketpage.selectProductInOrders();
        basketpage.typeMessage(" where is my order?");
        basketpage.sendMessage();
        basketpage.checkMessageSent();
    }

    @Test
    public void productAvailableWithDifferentOption(){
        productPage.navigatetoTshirtPage();
        productPage.productAvailability();


    }

    @Test
    public void ReorderingAPreviousPurchase(){
        homepage.navigateToSignInPage();
        signInPage.enterSignInEmailAddress("jellybaby@gmail.com");
        signInPage.enterPasswordSignIn("sweet");
        signInPage.clickLogIn();
        basketpage.goToOrders();
        basketpage.clickReorder();
        basketpage.countinueToShipping();
        basketpage.continueToPayment();
        basketpage.clickPaymentOption();
        basketpage.clickTermsAndAgreement();
        basketpage.confirmOrder();
        basketpage.orderConfirmationPageIsDisplayed("Your order is confirmation");
    }
    /* Navigate to 'Women'
            * Select size
* Select colour
* Select price range
* Verify that correct product is displayed
   */

    @Test
    public void testProductFiltersOnWomenPage(){
        homepage.clickWomenCategory();
        homepage.clickSizeFilter();
        homepage.clickColourFilter();
        homepage.clickPriceFilter();
        homepage.clickClearFilters();

    }
   /*
  * Navigate to news subscription at the bottom
   of the homepage
* Enter a valid email address
* Click subscribe
* Verify that success message is displayed
    */
    @Test
    public void subscribeToNewsAndSpecialSales(){
        signInPage.enterSignInEmailAddress("jellybaby2" + generateRandomDouble()+ "@gmail.com");
        homepage.clickSubscribe();
        homepage.subscribeSuccessAlert();
    }

    public static int generateRandomDouble(){
        Random random = new Random();
        return random.nextInt();
    }

    /*
 *From the homepage click on - Contact Us
(On the top left of the page)
*Enter email address
*Enter a message
*Click on - Send
*Verify message has been sent
     */

    @Test
    public void contactUsAndSendMessage(){
        homepage.clickContactUs();
        homepage.enterEmailAddress("jellybaby@gmail.com");
       basketpage.typeMessage("Hello, what products do you have?");
        homepage.sendMessage();
        homepage.messageSentSuccess();
    }

    }



