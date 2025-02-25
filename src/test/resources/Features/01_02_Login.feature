Feature: Login Functionalities

Background: Validate login with valid credentials
    Given Admin is in login Page.
    
Scenario: Validate login with valid data in all field
    When Admin enter valid data with "Login" and "Login with valid credentials" in all fields and clicks login button
    Then Admin should land on dashboard page


Scenario Outline: Validate login with invalid credentials

When  Admin enter invalid  "<TestCase>" credentials and clicks login button 
Then  Error message please "<TestCase>" check Adminname/password

Examples: 
|TestCase|
|login with Invalid UserName|
|login with InvalidPassword|
|login with InvalidData|


Scenario: verify login button action through keyboard

When Admin enter valid credentials  and clicks login button through keyboard
Then Admin should land on dashboard page


Scenario: verify login button action through mouse

When Admin enter valid credentials  and clicks login button through mouse
Then Admin should land on dashboard page




