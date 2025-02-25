@programadd
Feature: Lms End to End

  Scenario: Lms end to end
    Given Admin is in login Page.
    When Admin enter valid data with "Login" and "Login with valid credentials" in all fields and clicks login button
    Then Admin should land on Home page
    Then Admin is on the Manage Program page after login
    When Admin adds the program and click on save button from "Program" with scenario name "Add new program with valid data"
    Then Admin gets message for new program for each "Program" and  "Add new program with valid data"
    When Admin clicks the batch menu from the header
    When Admin Clicks the Add New batch button
    Then Admin Adds new Batch and click on save button for the scenario "onlyMandatoryfields" in batch module
    Then Admin gets message for the scenario "onlyMandatoryfields" for batch Module
    
