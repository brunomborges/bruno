Feature: Account Creation

  Scenario: Create an account with weak password
    Given I have clicked the Sign Up button on the upper menu
    And I have entered a valid email address
    And I have entered "123" as a password
    And I have entered "123" as a password confirmation
    When I press Sign up button
    Then The error message "Password should be minimum 4 characters long." should appear on the screen and account should not be created


  Scenario: Create an account with unmatched passwords
    Given I have clicked the Sign Up button on the upper menu
    And I have entered a valid email address
    And I have entered "Tartaruga01" as a password
    And I have entered "Tartaruga8978978998" as a password confirmation
    When I press Sign up button
    Then The error message "Passwords don't match" should appear on the screen and account should not be created


  Scenario: Create an account successfully
    Given I have clicked the Sign Up button on the upper menu
    And I have entered a valid email address
    And I have entered "Tartaruga01" as a password
    And I have entered "Tartaruga01" as a password confirmation
    When I press Sign up button
    Then the user should be logged in


