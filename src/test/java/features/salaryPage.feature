Feature: Salary Page
  As a user
  I want to verify that salary range works for selected role and country

  Scenario: Check salary range for QA Engineer in Canada
    When User is on the salary page
    When User choose "QA Engineer" role
    Then User choose "Role" dropdown item
    When User choose "Canada" country
    Then User choose "Country" dropdown item
    Then User click on "Search" button
    Then User verify salary for "QA Engineer" in "Canada" is displayed

  Scenario: Check wrong role error message
    When User is on the salary page
    When User choose "Wrong Role" role
    Then User verify "No results found" is displayed

  Scenario: Check wrong country error message
    When User is on the salary page
    When User choose "Wrong Country" country
    Then User verify "No results found" is displayed
