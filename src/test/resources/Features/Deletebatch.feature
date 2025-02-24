Feature: Delete Batch Functionalities


Background: Navigating to the Batch module

Given Admin is in login Page.
When Admin enter valid data with "Login" and "Login with valid credentials" in all fields and clicks login button
Then Admin should land on Home page
When Admin clicks the batch menu from the header
Then Admin should land on the Batch page



Scenario: validate delete Icon on any row

When Admin clicks the delete Icon on any row
Then Admin should see the confirm alert box with yes and no button BM


Scenario: Admin clicks on the delete icon and click yes button

When  Admin clicks on the delete icon and click yes button
Then  Admin should see the successful message and the batch should be deleted


Scenario: Admin clicks on the delete icon and click no button

When Admin clicks on the delete icon and click no button
Then Admin should see the alert box closed and the batch is not deleted


Scenario: validate close Icon on the alert box

When Admin clicks on the close icon
Then Admin should see the alert box closed in BM

