Feature: Carousel navigation and selection

  Scenario: Navigate through the carousel and select the first image
    Given the user is on the homepage with a carousel
    When the user clicks the carousel s Next button
    Then the second image is displayed
    When the user clicks the carousel s Next button again
    Then the third image is displayed
    When the user clicks the carousel s Next button a third time
    Then the first image is displayed
    When the user clicks on the middle of the first image
    Then the user is navigated to the first image s details page
