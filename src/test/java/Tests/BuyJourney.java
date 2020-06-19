package Tests;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pageObjects.HomePage;
import pageObjects.ProductPage;
import pageObjects.ShoppingCartPage;
import pageObjects.SignInPage;

import static Tests.TestSuite.driverFactory;

/**
 * Created by jack.forman on 23/10/2016.
 */
public class BuyJourney {

    public static WebDriver driver = driverFactory.getDriver();
    private HomePage homepage = new HomePage(driver);
    private ShoppingCartPage basketpage = new ShoppingCartPage(driver);
    private SignInPage signInPage = new SignInPage(driver);
    private ProductPage productPage = new ProductPage(driver);

    @Before
    public void individualSetUp() {
        driver.manage().deleteAllCookies();
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
    public void addItemViaSummerDressesInMenu(){
        homepage.hoverOverCategory();
        homepage.clickSummerDresses();
        homepage.hoverAndClickQuickview();
       productPage.selectSize();
       productPage.selectQuantity();
       homepage.addToCartButton();
       homepage.addedToCart();




    }

    @Test
    public void addItemViaCatalogueSearch(){
    homepage.search("Printed dress");
    homepage.clickSearch();
    homepage.addItemToCart();
    homepage.addedToCart();

    }

    @Test @Ignore
    public void continueShoppingAddSecondItem(){
        homepage.hoverOverItem();
        homepage.addItemToCart();
        productPage.clickContinueShopping();
        homepage.hoverAndContinueShopping();
    }
    /*
* Navigate to Sign In Page
* Click Orders (bottom of page)
* Click Details
* Choose Product
*Add Comment
*Verify that message was successfuly sent"
     */

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
}
