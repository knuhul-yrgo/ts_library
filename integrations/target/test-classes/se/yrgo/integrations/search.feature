Feature: Searching for books
  As a user I want to be able to search for available books so I know what I can
  loan.

  Scenario: Getting to the search page
    Given the user is on the start page.
    When the user navigates to the book search.
    Then they can see the search form.

  Scenario: Searching for an existing ISBN
    Given the user is on the start page.
    When the user navigates to the book search.
    And the user types in an existing isbn.
    And the user presses the search button.
    Then information about the book is shown.

  Scenario: Searching for an existing author
    Given the user is on the start page.
    When the user navigates to the book search.
    And the user types in an existing author.
    And the user presses the search button.
    Then the books by the author is shown.