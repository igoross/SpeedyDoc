Feature: Login
  As a user
  I want to log in to the system
  So that I can access my account

  Scenario: Login with valid credentials
    Given User is on the login page
    When User enters valid credentials
    And User click on the Login button
    Then User should be redirected to the home page

  Scenario: User logs in with invalid credentials
    Given User is on the login page
    When User enters invalid credentials
    And User click on the Login button
    Then User should see an error message