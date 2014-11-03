Feature: User Login

  Background:
    Given I am in the login page

  Scenario: Try to login with an account that does not exist
    Given I have entered "legal@gmail.com" as an email address
    And I have entered "Tartaruga01" as a password to login
    When I press the Login button
    Then The error message "Account does not exist" should appear on the screen and user should not be loged in

  Scenario: Try to login with a wrong password
    Given I have entered "bruno1@gmail.com" as an email address
    And I have entered "Tartaruga011111111111" as a password to login
    When I press the Login button
    Then The error message "Email/Password combination is wrong." should appear on the screen and user should not be loged in

  Scenario: Login with an account
    Given I have entered "bruno1@gmail.com" as an email address
    And I have entered "Tartaruga01" as a password to login
    When I press the Login button
    Then I should login in the system

   