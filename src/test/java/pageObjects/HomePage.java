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

    private static String URL = "http://3.11.70.191/index.php";
    private Actions actions = new Actions(driver);

    private static final By SIGN_IN_BUTTON = By.cssSelector("#_desktop_user_info a");
    private static final By DRESS_IMAGE = By.cssSelector("img[alt = 'Printed Chiffon Dress']");
    private static final By QUICK_VIEW_LINK = By.cssSelector(".quick-view");
    private static final By FIRST_PRODUCT_IMAGE = By.cssSelector("div.products > article:last-child img");
    private static final By FIRST_PRODUCT_QUICKVIEW = By.cssSelector("div.products > article:last-child .quick-view");
    private static final By ADD_TO_CART_BUTTON = By.cssSelector(".btn.btn-primary.add-to-cart");
    private static final By MODAL_WINDOW = By.cssSelector("#myModalLabel");
    private static final By SIGNOUT = By.cssSelector("");
    private static final By SEARCH = By.cssSelector(".ui-autocomplete-input");
    private static final By CLICK_SEARCH = By.cssSelector(".material-icons.search");
    private static final By WOMEN_CATEGORY = By.cssSelector("#category-3");
    private static final By SUMMER_DRESS_CATEGORY = By.cssSelector("#category-11");
    private static final By HOVER_SECTION = By.cssSelector(".product-description");
    private static final By SELECT_PRICE_FILTER = By.cssSelector(" [href='http://3.11.70.191/index.php?controller=category&amp;id_category=3&amp;q=Price-%24-16-17']");
    private static final By SELECT_SIZE_FILTER  = By.cssSelector("[href='http://3.11.70.191/index.php?controller=category&amp;id_category=3&amp;q=Size-S'] ");
    private static final By SELECT_COLOUR_FILTER = By.cssSelector("[href='http://3.11.70.191/index.php?controller=category&amp;id_category=3&amp;q=Color-Yellow']");
    private static final By CLICK_SUBSCRIBE = By.cssSelector(".btn.btn-primary.float-xs-right.hidden-xs-down");
    private static final By SUBSCRIBE_SUCCESS = By.cssSelector(".alert.alert-success");
    private static final By CONTACT_US = By.linkText("Contact us");
    private static final By EMAIL_ADDRESS_CONTACT = By.cssSelector(".form-control[type = 'email']");
    private static final By SEND_MESSAGE = By.cssSelector(".btn.btn-primary");
    private static final By MESSAGE_SENT_SUCCESS = By.cssSelector(".col-xs-12.alert.alert-success");
    private static final By CLEAR_FILTERS = By.cssSelector("#_desktop_search_filters_clear_all");




    public void goTo() {
        driver.get(URL);
    }


    public void signout(){
        waitAndClick(SIGNOUT);
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

    public void search(String productName){findAndType(SEARCH, productName);

    }

    public void clickSearch(){waitAndClick(CLICK_SEARCH);}


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

    public void clickWomenCategory(){waitAndClick(WOMEN_CATEGORY);}

    public void addToCartButton(){
        waitAndClick(ADD_TO_CART_BUTTON);
    }

    public void clickPriceFilter(){waitAndClick(SELECT_PRICE_FILTER);
    }

    public void clickSizeFilter(){waitAndClick(SELECT_SIZE_FILTER);}

    public void clickColourFilter(){waitAndClick(SELECT_COLOUR_FILTER);}

    public void clickSubscribe(){waitAndClick(CLICK_SUBSCRIBE);}

    public void subscribeSuccessAlert(){
        waitUntilVisible(SUBSCRIBE_SUCCESS);
        WebElement subscribeSuccess = driver.findElement(SUBSCRIBE_SUCCESS);
        Assert.assertTrue(elementIsVisible(subscribeSuccess));
    }

    public void clickContactUs(){waitAndClick(CONTACT_US);
    }
    public void enterEmailAddress(String email){findAndType(EMAIL_ADDRESS_CONTACT, email);}

    public void sendMessage(){waitAndClick(SEND_MESSAGE);}

    public void messageSentSuccess(){
        waitUntilVisible(MESSAGE_SENT_SUCCESS);
        WebElement messageSuccess = driver.findElement(MESSAGE_SENT_SUCCESS);
        Assert.assertTrue(elementIsVisible(messageSuccess));

    }

    public void clickClearFilters(){waitAndClick(CLEAR_FILTERS);}


}
