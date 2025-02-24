@navigatevalidationclass
Feature: Navigate class validation

  Background: 
    Given Admin is in login Page.
    When Admin enter valid data with "Login" and "Login with valid credentials" in all fields and clicks login button
    Then Admin should land on Home page
    Then Admin is on the Manage Class page after login
    
   Scenario:  Class link on navigation bar
   When Admin clicks on Class link on Manage Class page
   Then Admin is redirected to class page
   
   Scenario: Class link to other page on navigation bar
   When Admin clicks on any page link on Manage Class page
   Then Admin is redirected to which page link they clicked.
   
   Scenario: Logout link on navigation bar
   When Admin clicks on Logout link on Manage class page
   Then Admin is redirected to Login page
   