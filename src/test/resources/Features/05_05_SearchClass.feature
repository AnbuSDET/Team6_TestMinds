@searchclass
Feature: Class Search Bar
 

  Background: 
    Given Admin is in login Page.
    When Admin enter valid data with "Login" and "Login with valid credentials" in all fields and clicks login button
    Then Admin should land on Home page
    Then Admin is on the Manage Class page after login


 Scenario Outline: Verify Admin is able to search results found for valid class fields
  Then Admin searches by valid batch name,class topic and staff name with "<sheetName>" and "<scenarioName>" in the class module
Examples:

		|	sheetName	| scenarioName												|
		|	Class		| Search with valid batch name			|
		|	Class		|	Search with valid class topic			|
		|	Class		|	Search with valid staff name		|			
	