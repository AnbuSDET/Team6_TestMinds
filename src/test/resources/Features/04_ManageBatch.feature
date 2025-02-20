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