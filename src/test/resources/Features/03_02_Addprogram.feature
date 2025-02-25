Feature: Addnew Programpage

  Background: Navigating to the program module
    Given Admin is in login Page.
    When Admin enter valid data with "Login" and "Login with valid credentials" in all fields and clicks login button
    Then Admin should land on Home page
    When Admin clicks the program menu from the header
    Then Admin should land on the program page

  Scenario: Verify Add New Program button functionality
    Given Admin is on Program page
    When Admin clicks on "Add New Program" under the "Program" menu bar
    Then Admin should see a pop-up window for program details

  Scenario: Admin verifies the title of the Add New Program pop-up window
    Given Admin is on Program page
    When Admin clicks on "Add New Program" under the "Program" menu bar
    Then Admin should see the window title as "Program Details"

  Scenario: Admin verifies mandatory fields with red asterisk mark
    Given Admin is on Program page
    When Admin clicks on "Add New Program" under the "Program" menu bar
    Then Admin should see red asterisk mark beside mandatory field "Name"

  Scenario Outline: Admin verifies empty form submission
    Given Admin is on the Program details form
    When Admin clicks the save button without entering mandatory fields
    Then Admin gets message '<field>' is required
      | Program name is required. |
      | Description is required.  |
      | Status is required.       |

  Scenario: Admin verifies cancel button
    Given Admin is on the Program details form
    When Admin clicks the Cancel button
    Then Admin can see the Program Details form disappears

  Scenario Outline: Verify enter program name
    Given Admin is on program details form
    When Admin enters the Name in the text box from "<sheetName>" with scenario name "<scenarioName>"
    Then Admin can see the text entered from "<sheetName>" with scenario name "<scenarioName>"

    Examples: 
      | sheetName  | ScenarioName             |
      | AddProgram | Enter valid program name |

  Scenario Outline: Verify enter description
    Given Admin is on program details form
    When Admin enters the Description in text box from "<sheetName>" with scenario name "<scenarioName>"
    Then Admin can see the text entered in description box from "<sheetName>" with scenario name "<scenarioName>"

    Examples: 
      | sheetName  | ScenarioName            |
      | AddProgram | Enter valid description |

  Scenario Outline: Verify select Status
    Given Admin is on program details form
    When Admin selects the status of the program by clicking on the radio button "<status>" from "<sheetName>" with scenario name "<scenarioName>"
    Then Admin can see '<status>' status selected from "<sheetName>" with scenario name "<scenarioName>"

    Examples: 
      | sheetName  | ScenarioName         | status |
      | AddProgram | Verify select Status | Active |

@test
  Scenario Outline: Verify Add program
    When Admin adds the program and click on save button from "<sheetName>" with scenario name "<scenarioName>"
    Then Admin gets message for new program for each "<sheetName>" and  "<scenarioName>"

    Examples: 
      | sheetName | scenarioName                    |
      | Program   | Add new program with valid data |

  Scenario: Verify cancel program details
    Given Admin is on program details form
    When Admin clicks on the cancel button
    Then Admin can see the program details form disappear

  Scenario: Verify added Program is created
    Given Admin is on the Program page
    When Admin searches with newly created "Program Name"
    Then Records of the newly created "Program Name" should be displayed and match the data entered

  Scenario: Verify close window with "X"
    Given Admin is on the program details form
    When Admin clicks on the "X" button
    Then the program details form should disappear
