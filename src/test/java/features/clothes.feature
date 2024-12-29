Feature: Navigation to Clothes categories

Scenario Outline: Navigate to specific Clothes category
  Given the user is on the index page for clothes
  When the user clicks on "Clothes"
  And the user choose the "<category>" category
  Then the user is redirected to the "<category>" page

Examples:
  | category |
  | MEN      |
  | WOMEN    |
