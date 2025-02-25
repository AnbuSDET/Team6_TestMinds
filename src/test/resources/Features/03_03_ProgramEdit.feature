@programedit
Feature: Edit Program

Background: 
    Given Admin is in login Page.
    When Admin enter valid data with "Login" and "Login with valid credentials" in all fields and clicks login button
    Then Admin should land on Home page
    Then Admin is on the Manage Program page after login
    
#Scenario: Verify Edit option
#When Admin clicks on "Edit Option" for particular program
#Then Admin should see pop up window for program details
#
#
#Scenario: Verify title of the pop up window
#When Admin clicks on "Edit Option" for particular program
#Then Admin should see window title as "Program Details"
#
#
#Scenario Outline: Verify mandatory fields with red "*" mark 
#When Admin clicks on "Edit Option" for particular program
#Then Admin should see red "*" mark beside mandatory field '<field>'
#
#Examples:
#|field|
#|Program name|
#|Description|
#|Status|
#
#
#Scenario: Verify Admin able to click cancel button
#When Admin clicks on "Edit Option" for particular program
#When Admin clicks Cancel button
#Then Admin can see Program Details form disappears 
    #
      #
      #
#Scenario Outline: Verify edit program 
  #When Admin edits the program and click on save button from "<sheetName>" with scenario name "<scenarioName>"
  #Then Updated program name is seen by the Admin from "<sheetName>" with scenario name "<scenarioName>"
#
#Examples:
#|sheetName|scenarioName|
#|Program|Edit program with program name| 
#|Program|Edit Program with program description|
#|program|Edit Program with program status|


Scenario: Validate next page link
When Admin clicks next page link on the data table
Then Admin should see the Next enabled link 


Scenario: validate last page link
When  Admin clicks last page link on the data table
Then Admin should see the last page link with next page link disabled on the table 


Scenario: validate the previous page link
When  Admin clicks previous page link on the data table
Then Admin should see the previous page on the table


Scenario: validate the first page link
When Admin clicks first page link on the data table
Then Admin should see the very first page on the data table

      