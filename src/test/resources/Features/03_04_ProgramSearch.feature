@programsearch
Feature: Search Program

 Background: 
    Given Admin is in login Page.
    When Admin enter valid data with "Login" and "Login with valid credentials" in all fields and clicks login button
    Then Admin should land on Home page
    Then Admin is on the Manage Program page after login
    
Scenario Outline: Verify searching added program
 Then Admin searches with newly created program name from "<sheetName>" with scenario name "<scenarioName>"
 
Examples:

 |sheetName|scenarioName|
 |Program|Searching the added program using program name|
 |Program|Searching the added program using program description|
 |Program|Searching the added program using invalid program name|
 |Program|Searching the added program using partial program name|
 
    