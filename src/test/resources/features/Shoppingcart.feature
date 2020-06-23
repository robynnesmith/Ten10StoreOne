Feature: This is a feature

  Scenario:Different invoice

    Given user is on the "basket" page
    And user is logged in
    And user has "1 item" in basket
    When user changes invoice address on checkout
    Then shipping method should be displayed
