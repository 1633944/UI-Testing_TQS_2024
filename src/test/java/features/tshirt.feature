Feature: TShirt

Scenario Outline: Show TShirt

Given the user is in the index page
When the user enters <article> in the search bar
And the user press the Enter key
Then the <article> list appears

Examples:
|article|
|T-Shirt|
|Mug|
|Sweater|