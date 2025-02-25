@searchBatch
Feature: Batch Search Bar
 

  Background: 
Given Admin is in login Page.
When Admin enter valid data with "Login" and "Login with valid credentials" in all fields and clicks login button
Then Admin should land on Home page
When Admin clicks the batch menu from the header
Then Admin should land on the Batch page


 Scenario Outline: Verify Admin is able to search results found for valid batch fields
  Then Admin searches by valid batch name with "<sheetName>" and "<scenarioName>" in the batch module
Examples:

		|	sheetName	| scenarioName												|
		|	Batch		| Search with valid batch name			|