Feature: Edit Class

  Background: 
    Given Admin is in login Page.
    When Admin enter valid data with "Login" and "Login with valid credentials" in all fields and clicks login button
    Then Admin should land on Home page
    Then Admin is on the Manage Class page after login

  Scenario: Validates Sorting(data ordering) of Batch Name on the Class Data table
    When Admin clicks the sort icon of Batch Name column in the Class module
    Then The data get sorted on the table based on the Batch Name  column values in ascending order in the Class module
    When Admin clicks the sort icon of Batch Name column to sort Batch Name  in descending order in the Class module
    Then The data get sorted on the table based on the Batch Name column values in descending order in the Class module

  Scenario: Validates Sorting(data ordering) of Class Topic Order on the Class Data table
    When Admin clicks the sort icon of Class Topic column in the Class module
    Then The data get sorted on the table based on the  Class Topic column values in ascending order in the Class module
    When Admin clicks the sort icon of  Class Topic  column to sort  Class Topic in descending order in the Class module
    Then The data get sorted on the table based on the Class Topic column values in descending order in the Class module

  Scenario: Validates Sorting(data ordering) of Class Description on the Class Data table
    When Admin clicks the sort icon of Class Description column in the Class module
    Then The data get sorted on the table based on the Class Description column values in ascending order in the Class module
    When Admin clicks the sort icon of Class Description column to sort Class Description in descending order in the Class module
    Then The data get sorted on the table based on the Class Description column values in descending order in the Class module

  Scenario: Validates Sorting(data ordering) of Class Status on the Class Data table
    When Admin clicks the sort icon of Class Status column in the Class module
    Then The data get sorted on the table based on the Class Status column values in ascending order in the Class module
    When Admin clicks the sort icon of Class Status column to sort Class status in descending order in the Class module
    Then The data get sorted on the table based on the Class Status column values in descending order in the Class module

  Scenario: Validates Sorting(data ordering) of Class Date on the Class Data table
    When Admin clicks the sort icon of Class Date column in the Class module
    Then The data get sorted on the table based on the Class Date column values in ascending order in the Class module
    When Admin clicks the sort icon of Class Date column to sort Class Date in descending order in the Class module
    Then The data get sorted on the table based on the Class Date column values in descending order in the Class module

  Scenario: Validates Sorting(data ordering) of Staff Name on the Class Data table
    When Admin clicks the sort icon of Staff Name column in the Class module
    Then The data get sorted on the table based on the Staff Name column values in ascending order in the Class module
    When Admin clicks the sort icon of Staff Name column to sort Staff Name in descending order in the Class module
    Then The data get sorted on the table based on the Staff Name column values in descending order in the Class module
