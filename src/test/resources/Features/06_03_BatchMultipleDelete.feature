@batchmultipledelete
Feature: Batch Multiple Delete

  Background: 
    Given Admin is in login Page.
    When Admin enter valid data with "Login" and "Login with valid credentials" in all fields and clicks login button
    Then Admin should land on Home page
    When Admin clicks the batch menu from the header
    Then Admin should land on the Batch page
    
    
  Scenario: Validate Common Delete button enabled after clicking on any checkbox
    When Admin clicks any checkbox in the data table
    Then Admin should see common delete option 

  Scenario: Validate multiple class deletion by selecting Single checkbox
    When Admin clicks any checkbox in the data table
    When Click delete icon below 'Manage Batch' header
    Then The respective row in the table is not Deleted after clicking NO in confirm delete form 
    When Click delete icon below 'Manage Batch' header
    Then The respective row in the table is deleted after clicking YES in confirm delete form 

  Scenario: Validate multiple class deletion by selecting multiple check boxes
    When admin clicks two or more checkboxes
    When Click delete icon below 'Manage Batch' header
    Then The respective rows in the table is not deleted after clicking NO in confirm delete form
    When Click delete icon below 'Manage Batch' header
   Then The respective rows in the table is deleted after clicking YES in confirm delete form  