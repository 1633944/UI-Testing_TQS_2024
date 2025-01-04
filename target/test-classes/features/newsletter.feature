Feature: Newsletter Subscription

  Scenario: Subscribe to the newsletter successfully
    Given the user is on the homepage for newsletter
    When the user enters "john.doe@example.com" into the subscription field
    And the user clicks the "Subscribe" button
    Then a success message is displayed confirming the subscription