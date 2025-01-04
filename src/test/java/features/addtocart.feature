Feature: Add to Cart

  As a user
  I want to add a product to the cart
  So that I can purchase it

  Scenario: Successfully add a product to the cart
    Given the user is on the product details page
    When the user clicks on Add to Cart
    Then the product is added to the cart with a confirmation message
