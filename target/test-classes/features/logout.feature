Feature: User Sign Out

  Scenario: Register and then Sign Out
    Given the user is on the registration page for logout
    When the user enters valid registration details for logout: "John", "Doe", "john.doe@example.com", "JDOEsecure123Password123JDOE"
    And the user submits the registration form for logout
    When the user clicks on sign out
    Then the user should be logged out successfully
    
    