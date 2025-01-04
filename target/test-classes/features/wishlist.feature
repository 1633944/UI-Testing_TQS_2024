Feature: Whislist

  Scenario: Add Product to wishlist
    Given the user is on the registration page for wishlist
    When the user enters valid registration details for wishlist: "John", "Doe", "john.doe@example.com", "JDOEsecure123Password123JDOE"
    And the user submits the registration form for wishlist
    And the user adds a product to the wishlist
    And the user navigates to the "My wishlists" section
    Then the user verifies the product appears in the wishlist