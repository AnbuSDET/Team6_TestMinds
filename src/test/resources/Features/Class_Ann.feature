@class_Ann
Feature: Class Module

  Background: Admin logged on the Dashboard page
    Given Admin is in login Page.
    When Admin enter valid data with "Login" and "Login with valid credentials" in all fields and clicks login button
    Then Admin should land on Home page

  @TC_Class_01
  Scenario: Validating the class manage page
    When Admin clicks the "Class" in the Header in class
    Then Admin should land on the "Manage Class" in class
    And Admin should see the "LMS - Learning Management System" Title in class
    And Admin should see the Searchbar in class
    And Admin should see the data table heading
      | Batch Name  |
      | Class Topic |
    #	|Class Description |
    #	| Status |
    #	| Class Date |
    #	| Staff Name |
    And Admin should see the "Showing" and enabled pagination controls under the data table in class
    And Admin should see the Sort icon for all the fields in the data table in class
    And Admin should see the Delete button under the Manage class page header in class
    And Admin should see "In total there are" in below of the data table in class

  @TC_Class_02
  Scenario: Add New Class Validation
    Given Admin is on the Manage class page in class
    When Admin clicks add new class under the class menu bar in class
    Then Admin should see a manage class pop up with empty form and <SAVE> and <CANCEL> button and Close(X) Icon on the top right corner of the window in class
    Then Admin should see few input fields and their respective text boxes in the class details window in class

  @TC_Class_03
  Scenario Outline: Class Details pop up Validation
    Given Admin is on the Class Popup window in class
    When Admin enters "<sheetName>" and "<scenarioName>" mandatory fields in the form and clicks on save button in class
    Then Admin gets message Class added Successfully in class

    Examples: 
      | sheetName | scenarioName  |
      | Class     | validInputMandatory |
      | Class     | validInputAll |

  @TC_Class_04
  Scenario: Class Details pop up Invalid Input verification with empty
    Given Admin is on the Class Popup window in class
    When Admin clicks on save button without entering data
    Then Class not created and Admin gets error message below mandatory fields in red
    When Admin clicks Cancel Icon on class Details form
    Then Class Details popup window should be closed

  @TC_Class_05
  Scenario: Date Picker validation
    Given Admin is on the Class Popup window in class
    When Admin selects class date in date picker "02/25/2025"
    Then Admin should see no of class value is added automatically "1"
    When Admin clicks date picker
    Then Admin should see weekends dates are disabled to select "1"

  @TC_Class_06
  Scenario Outline: Class Details pop up Invalid Input verification with optional field
    Given Admin is on the Class Popup window in class
    When admin enters only the optional field "<sheetName>" and "<scenarioName>" and clicks save
    Then Class not created and Admin gets error message below mandatory fields in red for "<sheetName>" and "<scenarioName>"
    When Admin clicks close button
    Then Class Details popup window should be closed

    Examples: 
      | sheetName | scenarioName  |
      | Class     | optionalInput |
      | Class     | InvalidInputMandatory |
