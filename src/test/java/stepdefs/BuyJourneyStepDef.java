package stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.HomePage;
import pageObjects.ProductPage;
import pageObjects.ShoppingCartPage;
import pageObjects.SignInPage;

public class BuyJourneyStepDef {


    private HomePage homepage = new HomePage();
    private ShoppingCartPage basketpage = new ShoppingCartPage();
    private ProductPage productPage = new ProductPage();
    private SignInPage signInPage = new SignInPage();


    @Given("the user is on the home page")
    public void theUserIsOnTheHomePage() {
        homepage.goTo();
    }

    @When("the user goes to a product")
    public void theUserGoesToAProduct() {
        homepage.hoverOverItem();
    }

    @And("clicks more")
    public void clicksMore() {
        homepage.clickMoreButton();
    }

    @Then("the Product page is displayed")
    public void theProductPageIsDisplayed() {
        productPage.productPageDisplayed();
    }


    @When("User goes to a product")
    public void userGoesToAProduct() {
        homepage.hoverOverItem();

    }

    @And("the user clicks add to cart")
    public void theUserClicksAddToCart() {
        homepage.addItemToCart();
    }

    @Then("verify product has been added to cart")
    public void verifyProductHasBeenAddedToCart() {
        homepage.addedToCart();
    }

    @When("the user goes to a product page")
    public void theUserGoesToAProductPage() {
        productPage.navigatetoProductPage();
    }

    @And("selects quantity")
    public void selectsQuantity() {
        productPage.selectQuantity();
    }

    //@And("selects size")
    //public void selectsSize() {
        //productPage.selectSize();
   //}

    @And("select colour")
    public void selectColour() {
        productPage.selectColour();
    }

    @And("clicks add to cart")
    public void clicksAddToCart() {
        basketpage.addToCart();
    }

    @Then("verify added to cart")
    public void verifyAddedToCart() {
        homepage.addedToCart();
    }

    @When("item is searched for")
    public void itemIsSearchedFor() {
        homepage.search("printed dress");
    }

    @And("search is clicked")
    public void searchIsClicked() {
        homepage.clickSearch();
    }

    @And("is added to cart")
    public void isAddedToCart() {
        homepage.addItemToCart();
    }

    @Then("item is added to cart")
    public void itemIsAddedToCart() {
        homepage.addedToCart();
    }

    @When("summer dresses is selected from the menu")
    public void summerDressesIsSelectedFromTheMenu() {
        homepage.hoverOverCategory();
        homepage.clickSummerDresses();

    }

    @And("user adds an item to cart through quickview")
    public void userAddsAnItemToCartThroughQuickview() {
        homepage.hoverAndClickQuickview();
        //productPage.selectSize();
        productPage.selectQuantity();
        homepage.addToCartButton();
    }

    @Then("then the item is added to cart")
    public void thenTheItemIsAddedToCart() {
        homepage.addedToCart();
    }

    @When("user selects any product from the home page")
    public void userSelectsAnyProductFromTheHomePage() {
        productPage.navigatetoProductPage();
    }

    @And("enters a high value in the quantity field")
    public void entersAHighValueInTheQuantityField() {
        basketpage.inputIncreaseQuantity("500");
    }

    @Then("not enough products in stock alert is displayed")
    public void notEnoughProductsInStockAlertIsDisplayed() {
        productPage.productAvailability();
    }

    @Given("the user is signed in")
    public void theUserIsSignedIn() {
        homepage.navigateToSignInPage();
        signInPage.enterSignInEmailAddress("jellybaby@gmail.com");
        signInPage.enterPasswordSignIn("sweet");
        signInPage.clickLogIn();
    }

    @And("the user navigates to details page")
    public void theUserNavigatesToDetailsPage() {
        basketpage.goToOrders();
        basketpage.clickOrderDetails();
        basketpage.selectProductInOrders();
        basketpage.selectProductInOrders();

    }

    @When("the user fills out message form")
    public void theUserFillsOutMessageForm() {
        basketpage.typeMessage(" where is my order?");

    }

    @Then("the message has been sent")
    public void theMessageHasBeenSent() {
        basketpage.sendMessage();
    }

    @And("verify message is displayed")
    public void verifyMessageIsDisplayed() {
        basketpage.checkMessageSent();

    }

    @When("user selects a product with different options")
    public void userSelectsAProductWithDifferentOptions() {
        productPage.navigatetoTshirtPage();
    }

    @Then("availability message is displayed")
    public void availabilityMessageIsDisplayed() {
        productPage.productAvailability();
    }
    //@Given("user is signs in")
    //public void userIsSignsIn() {
        //homepage.navigateToSignInPage();
        //signInPage.enterSignInEmailAddress("jellybaby@gmail.com");
        //signInPage.enterPasswordSignIn("sweet");
        //signInPage.clickLogIn();

    //}

    @When("the user navigates to Order history page")
    public void theUserNavigatesToOrderHistoryPage() {
        basketpage.goToOrders();
    }

    @And("clicks on reorder")
    public void clicksOnReorder() {
        basketpage.clickReorder();
    }

    @And("completes the purchase")
    public void completesThePurchase() {
        basketpage.countinueToShipping();
        basketpage.continueToPayment();
        basketpage.clickPaymentOption();
        basketpage.clickTermsAndAgreement();
        basketpage.confirmOrder();
    }

    @Then("the purchase is successful")
    public void thePurchaseIsSuccessful() {
        basketpage.orderConfirmationPageIsDisplayed("Your order is confirmation");
    }


    @When("the user completes the newsletter form with a valid email")
    public void theUserCompletesTheNewsletterFormWithAValidEmail() {
     signInPage.enterSignInEmailAddress("Jellybaby4@gmail.com");
     homepage.clickSubscribe();
    }

    @Then("A success message is displayed")
    public void aSuccessMessageIsDisplayed() {
        homepage.subscribeSuccessAlert();
    }


    @And("they navigate to the Contact us page")
    public void theyNavigateToTheContactUsPage() {
        homepage.clickContactUs();
    }

    @When("the user completes the contact us form")
    public void theUserCompletesTheContactUsForm() {
        homepage.enterEmailAddress("jellybaby@gmail.com");
        basketpage.typeMessage("Hello, what products do you have?");
        homepage.sendMessage();
    }


    @Then("a confirmation message is displayed")
    public void aConfirmationMessageIsDisplayed() {
        homepage.messageSentSuccess();
    }
}


