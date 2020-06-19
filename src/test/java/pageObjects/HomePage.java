package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Created by jack.forman on 22/10/2016.
 */
public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    private static String URL = "http://3.11.70.191/index.php";
    private Actions actions = new Actions(driver);

    private static final By SIGN_IN_BUTTON = By.cssSelector("#_desktop_user_info a");
    private static final By DRESS_IMAGE = By.cssSelector("img[alt = 'Printed Chiffon Dress']");
    private static final By QUICK_VIEW_LINK = By.cssSelector(".quick-view");
    private static final By FIRST_PRODUCT_IMAGE = By.cssSelector("div.products > article:last-child img");
    private static final By FIRST_PRODUCT_QUICKVIEW = By.cssSelector("div.products > article:last-child .quick-view");
    private static final By ADD_TO_CART_BUTTON = By.cssSelector(".btn.btn-primary.add-to-cart");
    private static final By MODAL_WINDOW = By.cssSelector("#myModalLabel");
    private static final By WOMEN_CATEGORY = By.cssSelector("#category-3");
    private static final By SUMMER_DRESS_CATEGORY = By.cssSelector("#category-11");
    private static final By HOVER_SECTION = By.cssSelector(".product-description");
    private static final By SEARCH = By.cssSelector(".ui-autocomplete-input");
    private static final By CLICK_SEARCH = By.cssSelector(".material-icons.search");
    private static final By ANOTHER_PRODUCT_IMAGE = By.xpath("//*[@id='content']/section/div/article[4]/div/div[4]");
    private static final By ANOTHER_PRODUCT_QUICKVIEW = By.cssSelector(" .quick-view");

    public void goTo() {
        driver.get(URL);
    }

    public void navigateToSignInPage() {
        waitAndClick(SIGN_IN_BUTTON);
    }

    public void hoverOverItem() {

        actions.moveToElement(driver.findElement(DRESS_IMAGE)).build().perform();

        WebElement hoverView = driver.findElement(QUICK_VIEW_LINK);
        Assert.assertTrue(elementIsVisible(hoverView));
    }

    public void clickMoreButton() {
        waitAndClick(DRESS_IMAGE);
    }


    public void maximiseBrowserWindow() {
        driver.manage().window().maximize();
    }

    public void addItemToCart() {
        WebElement firstProductImage = driver.findElement(FIRST_PRODUCT_IMAGE);
        WebElement firstProductQuickView = driver.findElement(FIRST_PRODUCT_QUICKVIEW);
        actions
                .moveToElement(firstProductImage)
                .click(firstProductQuickView)
                .perform();
        waitAndClick(ADD_TO_CART_BUTTON);
    }

    public void addedToCart() {
        waitUntilVisible(MODAL_WINDOW);
        WebElement addedToCart = driver.findElement(MODAL_WINDOW);
        Assert.assertTrue(elementIsVisible(addedToCart));
    }


    public void itemAddedToCart() {
        maximiseBrowserWindow();
        addItemToCart();
        addedToCart();
    }



    public void hoverOverCategory() {

        actions.moveToElement(driver.findElement(WOMEN_CATEGORY)).build().perform();

        WebElement hoverView = driver.findElement(SUMMER_DRESS_CATEGORY);
        Assert.assertTrue(elementIsVisible(hoverView));
    }

    public void clickSummerDresses(){
        waitAndClick(SUMMER_DRESS_CATEGORY);
    }

    public void hoverAndClickQuickview(){ hoverAndClick(driver, HOVER_SECTION, QUICK_VIEW_LINK);

    }

    public void addToCartButton(){
        waitAndClick(ADD_TO_CART_BUTTON);
    }

    public void search(String productName){findAndType(SEARCH, productName);

    }
    public void clickSearch(){waitAndClick(CLICK_SEARCH);}

    public void hoverAndContinueShopping(){hoverAndClick(driver, ANOTHER_PRODUCT_IMAGE, ANOTHER_PRODUCT_QUICKVIEW);}


}
