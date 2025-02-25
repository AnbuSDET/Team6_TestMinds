@programadd
Feature: Add Program

 Background: 
    Given Admin is in login Page.
    When Admin enter valid data with "Login" and "Login with valid credentials" in all fields and clicks login button
    Then Admin should land on Home page
    Then Admin is on the Manage Program page after login
      
 @test  
 Scenario Outline: Verify Add program 
  When Admin adds the program and click on save button from "<sheetName>" with scenario name "<scenarioName>"
  Then Admin gets message for new program for each "<sheetName>" and  "<scenarioName>"


Examples:

 |sheetName|scenarioName|
 |Program|Add new program with valid data|
      