Feature: Header Verification

Scenario: Verify the header logo is visible and clickable
  Given the user is on the index page for header
  When the user checks the header
  Then the user verifies the logo is visible and clickable
