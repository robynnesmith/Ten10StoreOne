Feature: Registration

  Scenario: Register user with already registered email address
    Given the user is on the "sign in" page
    When the user completes the registration form with an "registered" email address
    Then the already registered alert is displayed

  Scenario: register as new user
    Given the user is on the "sign in" page
    When the user completes the registration form with an "unregistered" email address
    Then the account page is displayed
    And the account page is displayed

  Scenario: register user with numeric values in name
    Given the user is on the "sign in" page
    When the user completes registration form with a numeric name
    Then the invalid name alert is displayed

  Scenario: register user with numeric values in password
    Given the user is on the "sign in" page
    When the user completes registration form with a numeric password
    Then the account page is displayed

  Scenario: register user with invalid birthdate
    Given the user is on the "sign in" page
    When the user completes registration form with an invalid birthdate
    Then the invalid birthdate alert is displayed



