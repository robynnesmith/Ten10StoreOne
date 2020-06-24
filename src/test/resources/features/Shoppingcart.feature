Feature: This is a feature
 Background: Cookies are clear and user is on homepage
   Given user is on the "home" page
 And cookies are clear
  When  user is on the "home" page
  Then  user logs on

  Scenario:Different invoice

    Given user is on the "basket" page
    And user has "1 item" in basket
    When user changes invoice address on checkout
    Then shipping method should be displayed
  @dev
    Scenario: multiple Items

      Given user is on the "basket" page
      And user has "2 items" in basket
      Then product counter & prices are correct

      Scenario: Empty basket once logged out
        Given user is on the "shopping cart" page
        And user has "1 item" in basket
        When user signs out from checkout page
        Then cart is empty if user logs back on

