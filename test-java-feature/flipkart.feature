Feature: Account Creation

  Scenario: Create an account with weak password
    Given I have entered a valid email address
    And I have entered a small password
    When I press Sign up button
    Then The error message should appear on the screen and account should not be created


