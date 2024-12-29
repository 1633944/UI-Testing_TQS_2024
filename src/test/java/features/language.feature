Feature: Change language

Scenario Outline: Change site language
  Given the user is on the index page
  When the user opens the language selection dropdown
  And the user selects <language>
  Then the site is displayed in <language>

Examples:
  | language  |
  | Español   |
  | Deutsch   |