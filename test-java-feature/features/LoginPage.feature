Feature: User Login

  Scenario: Try to login with an account that does not exist
    Given I have entered "legal@gmail.com" as an invalid email address
    And I have entered "Tartaruga01" as a password
    When I press the Login button
    Then The error message "<string>" should appear on the screen and user should not be loged in
