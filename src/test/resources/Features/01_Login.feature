@login
Feature: Login

  Scenario Outline: Validate login with valid credentials
    Given Admin is in login Page.
    When Admin enter valid data with "<sheetName>" and "<scenarioName>" in all fields and clicks login button
    Then Admin should land on Home page

    Examples: 
      | sheetName | scenarioName                 |
      | Login     | Login with valid credentials |
