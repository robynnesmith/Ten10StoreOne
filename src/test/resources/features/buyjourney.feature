Feature: Buy Journey

  Background:
    Given the user is on the home page

  Scenario: Select item from home page
    When the user goes to a product
    And clicks more
    Then the Product page is displayed


  Scenario: Add product to cart from homepage
    When User goes to a product
   And  the user clicks add to cart
   Then verify product has been added to cart


  Scenario: Add product to cart from product page
    When the user goes to a product page
    And selects quantity
    And select colour
    And clicks add to cart
    Then verify added to cart

  Scenario: Search for product then add to cart
    When item is searched for
    And search is clicked
    And is added to cart
    Then item is added to cart

 Scenario: Add item via summer dresses in menu
   When summer dresses is selected from the menu
   And user adds an item to cart through quickview
   Then then the item is added to cart


Scenario: check that the product page displays there are not enough products in Stock
  When user selects any product from the home page
  And enters a high value in the quantity field
  Then not enough products in stock alert is displayed

 Scenario: Add a message to an order
   Given the user is signed in
   And the user navigates to details page
   When the user fills out message form
   Then the message has been sent
   And verify message is displayed

Scenario: product page displays product available with different options
  When user selects a product with different options
  Then availability message is displayed


  Scenario: Reordering a previous purchase
    Given the user is signed in
    When the user navigates to Order history page
    And clicks on reorder
    And completes the purchase
    Then the purchase is successful

 Scenario: Subscribe the news and special sales
   When the user completes the newsletter form with a valid email
   Then A success message is displayed


Scenario: Send message through contact us page
  And they navigate to the Contact us page
  When the user completes the contact us form
  Then a confirmation message is displayed





