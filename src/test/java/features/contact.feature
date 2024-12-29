Feature: Contact us

  Scenario: Successful user contact
    Given the user is on the contact us page
    When the user enters valid contact details: "john.doe@example.com", "Pagina pocha"
    And the user submits the contact us form
    Then the message is successfully sent
