Feature: Login

  Scenario: Login correct
    Given the user is on the login page
    When the user enter the username "1636526@uab.cat"
    And the user enter the password "A123456B123456C"
    And the user log in
    Then the user should be logged in

  Scenario: Login with incorrect password
    Given the user is on the login page
    When the user enter the username "1636526@uab.cat"
    And the user enter the password "incorrecte"
    And the user log in
    Then the user should see the login error message "Authentication failed."