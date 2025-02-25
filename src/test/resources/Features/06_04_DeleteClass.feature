@deleteclass
Feature: Delete Class

  Background: 
    Given Admin is in login Page.
    When Admin enter valid data with "Login" and "Login with valid credentials" in all fields and clicks login button
    Then Admin should land on Home page
    Then Admin is on the Manage Class page after login
    
    Scenario: Validate row level delete icon
    When Admin clicks the delete icon
    Then Admin should see a alert open with heading "Confirm" along with  <YES> and <NO> button for deletion
    
    
    Scenario: Click Yes on deletion window
    When Admin clicks the delete icon
    When Admin clicks yes option
    Then  Admin gets a message "Class Deleted" alert and do not see that Class in the data table
    
    Scenario: Click No on deletion window
    When Admin clicks the delete icon
    When Admin clicks No option
    Then Admin can see the deletion alert disappears without deleting    
    
    Scenario: Validate Close(X) icon on Confirm Deletion alert
    When Admin clicks the delete icon
    When Admin clicks on close button
    Then Admin can see the deletion alert disappears without any changes
    
    