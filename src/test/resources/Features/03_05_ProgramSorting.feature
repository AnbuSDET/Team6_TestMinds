@programsort
Feature: Sort Program

  Background: 
    Given Admin is in login Page.
    When Admin enter valid data with "Login" and "Login with valid credentials" in all fields and clicks login button
    Then Admin should land on Home page
    Then Admin is on the Manage Program page after login

  Scenario: Validates Sorting(data ordering) of Program Name on the Program Data table
    When Admin clicks the sort icon of Program Name column in the Program module
    Then The data get sorted on the table based on the Program Name column values in ascending order in the Program module
    When Admin clicks the sort icon of Program Name column to sort Program Name in descending order in the Program module
    Then The data get sorted on the table based on the Program Name column values in descending order in the Program module
    
    
  Scenario: Validates Sorting(data ordering) of Program Description on the Program Data table
    When Admin clicks the sort icon of Program Description column in the Program module
    Then The data get sorted on the table based on the Program Description column values in ascending order in the Program module
    When Admin clicks the sort icon of Program Description column to sort Program Description in descending order in the Program module
    Then The data get sorted on the table based on the Program Description column values in descending order in the Program module

  Scenario: Validates Sorting(data ordering) of Program Status on the Program Data table
    When Admin clicks the sort icon of Program Status column in the Program module
    Then The data get sorted on the table based on the Program Status column values in ascending order in the Program module
    When Admin clicks the sort icon of Program Status column to sort Program status in descending order in the Program module
    Then The data get sorted on the table based on the Program Status column values in descending order in the Program module
