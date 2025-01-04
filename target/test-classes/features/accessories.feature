Feature: Navigation to Accessories categories

Scenario Outline: Navigate to specific Accessories category
  Given the user is on the index page for accessories
  When the user clicks on "Accessories" for accessories
  And the user choose the "<category>" category for accessories
  Then the user is redirected to the "<category>" page for accessories

Examples:
  | category 						|
  | STATIONERY     			|
  | HOME ACCESSORIES    |
