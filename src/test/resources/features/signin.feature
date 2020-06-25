Feature: sign in

  Scenario: Sign in as registered user
    Given the user is on the "sign in" page
    When the user fills in sign in details with "registered" email
    Then the user is signed in
    And the users account is displayed

  Scenario: Sign in as unregistered user
    Given the user is on the "sign in" page
    When the user fills in sign in details with "unregistered" email
    Then error message is displayed

  Scenario: Sign out
    Given the user is on the "homepage" page
    When the user selects sign out
    Then the user is signed out

  Scenario: Forgotten password
    Given the user is on the "sign in" page
    And navigates to the forgotten password page
    When the user fills in forgotten password with an "registered" email
    Then the forgotten password result is displayed

  Scenario: Invalid forgotten password
    Given the user is on the "sign in" page
    And navigates to the forgotten password page
    When the user fills in sign in details with "unregistered" email
    Then the forgotten password result is displayed

  Scenario: Change account preferences
    Given the user is on the "account" page
    When the user updates account preferences
    Then the updated account alert is displayed

  Scenario: Sign in using invalid password
    Given the user is on the "sign-in" page
    When the user signs in with invalid password
    Then the invalid password alert is displayed

  Scenario: Add new address to account
    Given the user is on the "account" page
    When the user adds a new address
    Then the updated account alert is displayed

  Scenario: Add message to pre-existing order on account
    Given the user is on the "account" page
    When the user adds a message to order
    Then the order is updated









