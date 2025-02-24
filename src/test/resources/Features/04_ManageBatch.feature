Feature: Batch Module

Background: Navigating to the Batch module

Given Admin is in login Page.
When Admin enter valid data with "Login" and "Login with valid credentials" in all fields and clicks login button
Then Admin should land on Home page
When Admin clicks the batch menu from the header
Then Admin should land on the Batch page

Scenario: Validate "Title" in Batch Page

Then  Admin should see the "LMS-Learning Management System" Title

Scenario: Validate "heading" in the Batch Page

Then  Admin should see the "Manage Batch" Heading

Scenario: Validate disabled "Delete Icon" under the header in the Batch Page

Then  Admin should see the disabled Delete Icon under the header

Scenario: Validate pagination in the Batch Page

Then Admin should see the enabled pagination controls under the data table

Scenario Outline: Validate edit icon, check box , delete icon in each data rows

Then Admin should see the "<Options>" in each rows

Examples:
|Options|
|Edit_Icon|
|Check_Box|
|Delete_Icon|


Scenario: Validate sort icon next to all the datatable header

Then Admin should see the sort icon next to all Datatable headers


Scenario: Validate Datatable headers

Then Admin should see the datatable headers "Batch Name Batch Description Batch Status No Of Classes Program Name Edit / Delete"


Scenario: Validate Checkbox in the Datatable header row

Then Admin should see the checkbox  in the datatable header row


Scenario: Verify sub menu displayed in batch menu bar

Then Admin should see sub menu in menu bar as "Add New Batch"

### Add New  Batch TestCases

Scenario: Validate all the fields exist in pop up 

When Admin Clicks the Add New batch button 
Then The pop up should have all the enabled fields for New batch


Scenario: Validate batchname prefix selected program name

When Admin Clicks the Add New batch button 
And  Admin selects the program name in the dropdown
Then Admin should see selected program name in the batch name prefix box


Scenario: Validate batch name suffix box should accept only numbers

When  Admin Clicks the Add New batch button 
And   Admin selects the program name in the dropdown
When  Admin enters alphabets in batch name suffix box
Then  Admin should get error message below the text box of respective field


Scenario: Validate batch name prefix box is not editable

When  Admin Clicks the Add New batch button 
When  Admin Enters the alphabets in batch name Prefix box
Then  Admin should see empty text box


Scenario: validate close icon on the batch details pop up

When  Admin Clicks the Add New batch button
When  Admin clicks the close button 
Then  Admin should see the batch details pop up closes 


Scenario Outline: Verify Add  Batch functionalities 

When  Admin Clicks the Add New batch button 
Then  Admin Adds new Batch and click on save button for the scenario "<scenarioName>" in batch module
Then  Admin gets message for the scenario "<scenarioName>" for batch Module


Examples:
|scenarioName|
|onlyMandatoryfields|
|withoutMandatoryfields|
|allValidFields|
|cancelBtnwithValiddata|


### Edit Batch TestCases


Scenario: Validate Edit icon feature in any row 

When Admin clicks the edit icon
Then Admin should see the Batch details pop up window


Scenario Outline: Validate program name & Batch Name value is disabled to edit

When Admin clicks the edit icon 
Then Admin should see Program & Batch "<Names>" field is disabled for editing

Examples:
|Names|
|Program|
|Batch|



Scenario Outline: Verify Edit Popup functionalities
When Admin clicks the edit icon 
Then Admin Edits Batch and click on save button for the scenario "<scenarioName>" in batch module
Then Admin gets message for the Edit batch scenario "<scenarioName>" for batch Module

Examples:
|scenarioName|
|description_noOfClasses_Invalid|
|saveBtnwithValidData|
|cancelBtnwithValiddata|


## Batch Page Pagination

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







