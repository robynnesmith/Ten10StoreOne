Feature: This is a feature
 Background: Cookies are clear and user is on homepage
   Given user is on the "home" page
 And cookies are clear
  When  user logs on
  Then  user is on the "home" page


  Scenario:Different invoice

    Given user is on the "basket" page
    And user has "1 item" in basket
    When user changes invoice address on checkout
    Then shipping method should be displayed


    Scenario: multiple Item
      Given user has item in basket
     And user is on the "basket" page
      And user has "2 items" in basket
      Then product counter & prices are correct

      Scenario: Empty basket once logged out
        Given user is on the "shopping cart" page
        And user has "1 item" in basket
      And user is on the "basket" page
        When user signs out from "checkout" page
        Then cart is empty if user logs back on


    Scenario: Remove item from shopping cart
      Given user has "1 item" in basket
      When  user is on the "basket" page
      Then user deletes item
      And verify item removed

      Scenario: Increase quantity of product
        Given user has item in basket
        And user is on the "basket" page
        And user has "2 items" in basket
        Then product counter & prices are correct

        Scenario: Proceed to checkout not signed in
          Given user signs out from "home" page
          And user has "1 item" in basket
          And user is on the "basket" page
          When user goes to checkout
          Then Personal information is displayed
@dev
          Scenario: Proceed to checkout signed in
            Given user has "1 item" in basket
            And user is on the "basket" page
            When user goes to checkout
            And delivery is showed
            And shipping address is showed
            And user add comments to shipping
            Then user pays
            And user agrees to terms and conditions
            And order is confirmed
