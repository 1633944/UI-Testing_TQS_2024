Feature: Login

  Scenario: Login true
    Given I am on the login page
    When I enter the username "1636526@uab.cat"
    And I enter the password "A123456B123456C"
    And I log in
    Then I should be logged in

  Scenario: Login not correct
    Given I am on the login page
    When I enter the username "1636526@uab.cat"
    And I enter the password "incorrecte"
    And I log in
    Then I should see the login error message "Authentication failed."
