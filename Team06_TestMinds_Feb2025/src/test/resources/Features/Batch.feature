Feature: Batch Module

Background: Navigating to the Batch module

Scenario Outline: Validate login with valid credentials

Given Admin is in login Page.
When Admin enter valid data with "Login" and "Login with valid credentials" in all fields and clicks login button
Then Admin should land on Home page
When Admin clicks the batch menu from the header
Then Admin should land on the Batch page

Scenario: Validate "Title" in Batch Page

Given Admin is on the Batch Page
Then  Admin should see the "LMS-Learning Management System" Title

Scenario: Validate "heading" in the Batch Page

Given Admin is on the Batch Page
Then  Admin should see the "Manage Batch" Heading

Scenario: Validate disabled "Delete Icon" under the header in the Batch Page

Given Admin is on the Batch Page
Then  Admin should see the disabled "Delete Icon" under the header

