Feature: User Registration

  Scenario: Successful user registration
    Given the user is on the registration page
    When the user enters valid registration details: "John", "Doe", "john.doe@example.com", "JDOEsecure123Password123JDOE"
    And the user submits the registration form
    Then the user is successfully registered
