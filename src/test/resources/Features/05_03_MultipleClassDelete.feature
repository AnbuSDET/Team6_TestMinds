@multipledeleteclass
Feature: Multiple Delete Class

  Background: 
    Given Admin is in login Page.
    When Admin enter valid data with "Login" and "Login with valid credentials" in all fields and clicks login button
    Then Admin should land on Home page
    Then Admin is on the Manage Class page after login

  Scenario: Validate Common Delete button enabled after clicking on any checkbox
    When Admin clicks any checkbox in the data table
    Then Admin should see common delete option enabled under header Manage class

  Scenario: Validate multiple class deletion by selecting Single checkbox
    When Admin clicks any checkbox in the data table
    When Click delete icon below 'Manage Class' header  in the class module
    Then The respective row in the table is not Deleted after clicking NO in confirm delete form in the class module
    When Click delete icon below 'Manage Class' header  in the class module
    Then The respective row in the table is deleted after clicking YES in confirm delete form in the class module

  Scenario: Validate multiple class deletion by selecting multiple check boxes
    When admin clicks two or more checkboxes in the class module
    When Click delete icon below 'Manage Class' header  in the class module
    Then The respective rows in the table is not deleted after clicking NO in confirm delete form  in the class module
    When Click delete icon below 'Manage Class' header  in the class module
    Then The respective rows in the table is deleted after clicking YES in confirm delete form  in the class module
