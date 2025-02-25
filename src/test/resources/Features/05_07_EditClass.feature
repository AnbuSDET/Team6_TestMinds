@editclass
Feature: Edit Class

  Background: 
    Given Admin is in login Page.
    When Admin enter valid data with "Login" and "Login with valid credentials" in all fields and clicks login button
    Then Admin should land on Home page
    Then Admin is on the Manage Class page after login

  Scenario: Validate row level edit icon
    When Admin clicks on the edit icon
    Then A new pop up with class details appears

  Scenario: Check disabled  batch name
    When Admin clicks on the edit icon
    Then Admin should see batch name field is disabled

  Scenario: Check disabled class topic
    When Admin clicks on the edit icon
    Then Admin should see class topic field is disabled

  Scenario Outline: Verify edit class functionalities
    Given Admin is on the Edit Class Popup window
    When Admin updates the class and click on save button from "<sheetName>" with scenario name "<scenarioName>"
    Then the Admin gets message from "<sheetName>" with scenario name "<scenarioName>"

    Examples: 
      | sheetName | scenarioName                                  |
      | Class     | Edit class with valid data                    |
      | Class     | Edit class with invalid data                  |
      | Class     | Edit class with mandatory fields              |
      | Class     | Edit class with optional fields               |
      | Class     | Edit class with invalid values in text fields |

  Scenario: Validate Cancel button on Edit popup
    Given Admin is on the Edit Class Popup window
    When Admin clicks Cancel button on edit popup
    Then Admin can see the class details popup disappears and can see nothing changed for particular Class
