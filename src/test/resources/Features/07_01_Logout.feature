@logout
Feature: logout Module

  Background: Admin logged on the Dashboard page
    Given Admin is in login Page.
    When Admin enter valid data with "Login" and "Login with valid credentials" in all fields and clicks login button
    Then Admin should land on Home page
    
    @logout1
  Scenario: Verify logout function
    When Admin clicks on the logout in the menu bar
    Then Admin should be redirected to login page
  
      @logout2
  Scenario: Verify back button function
    When Admin clicks  browser back button
    Then Admin should receive error message