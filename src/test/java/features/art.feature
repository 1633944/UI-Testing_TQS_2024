Feature: Navigation to Art categories

Scenario Outline: Navigate to specific art category
  Given the user is on the index page for art
  When the user clicks on "Art" for art
  Then the user is redirected to the "ART" page for art
