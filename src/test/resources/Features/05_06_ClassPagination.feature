@class
Feature: Class Pagination
 

  Background: 
    Given Admin is in login Page.
    When Admin enter valid data with "Login" and "Login with valid credentials" in all fields and clicks login button
    Then Admin should land on Home page
    Then Admin is on the Manage Class page after login



 Scenario: Verify Next page link
    When Admin clicks Next page link on the Class table 
    Then Admin should see the next page record on the table  with Pagination has first active link enabled

  Scenario: Verify Last page link
    When Admin clicks Last page link on the Class table
    Then Admin should see the last page record on the table with Next page link are disabled 

    Scenario: Verify Start page link
    When Admin clicks Start page link on the Class table 
    Then Admin should see the start page record on the table with pagination has start page link enabled
  
    Scenario: Verify First page link
    When Admin clicks First page link on the Class table
    Then Admin should see the very first page record on the table with Previous page link are disabled
 
  