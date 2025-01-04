Feature: Login

  El sistema de login de la web nos permite iniciar sesión en la página web. Una vez iniciada
  la sesión, podemos realizar acciones restringidas a los usuarios identificados.

  Scenario: Login correcto
    Given I am on the login page
    When I enter the username "1636526@uab.cat"
    And I enter the password "A123456B123456C"
    And I log in
    Then I should be logged in

  Scenario: Login con contraseña incorrecta
    Given I am on the login page
    When I enter the username "1636526@uab.cat"
    And I enter the password "incorrecte"
    And I log in
    Then I should see the login error message "Authentication failed."