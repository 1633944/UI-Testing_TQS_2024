Feature: Validate footer links

Scenario: Verify footer links are clickable
  Given the user is on the index page for footer
  When the user scrolls to the footer
  Then the user verifies that all footer links are clickable
