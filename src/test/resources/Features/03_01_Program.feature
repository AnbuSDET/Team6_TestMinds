Feature: program Module

  Background: Navigating to the program module
    Given Admin is in login Page.
    When Admin enter valid data with "Login" and "Login with valid credentials" in all fields and clicks login button
    Then Admin should land on Home page
    When Admin clicks the program menu from the header
    Then Admin should land on the program page

  Scenario: Validate "Title" in Program Page
    Then Admin should see the "LMS" Title

  Scenario: Verify Logout displayed in menu bar
   Given Admin is on home page after Login
    When Admin clicks "Program" on the navigation bar
    Then Admin should see Logout in menu bar
    

  Scenario: Verify sub menu displayed in program menu bar
    Given Admin is on  program page
    When Admin clicks "Program" on the navigation bar
    Then Admin should see sub menu menu bar as "Add New Program"    

  Scenario: Verify heading in manage program
    Given Admin is on home page after Login
    When Admin clicks "Program" on the navigation bar
    Then Admin should see the heading "Manage Program"
    
  Scenario: Verify the Multiple Delete button state
    Given Admin is on home page after Login
    Then Admin clicks "Program" on the navigation bar
    When Admin should see a Delete button in left top is disabled
        

  Scenario: Verify the Search button
    Given Admin is on home page after Login
    When Admin clicks "Program" on the navigation bar
    Then Admin should see Search bar with text as "Search..."    

  
  Scenario Outline: Verify column headers on the Manage Program Page
    Given Admin is on home page after Login
     When Admin clicks "Program" on the navigation bar
    Then Admin should see data table with column headers on the Manage Program Page
      | Program Name        |
      | Program Description |
      | Program Status      |
      | Edit / Delete       |

  Scenario: Verify checkbox default state beside Program Name column header
    Given Admin is on the home page after login
    When Admin clicks "Program" on the navigation bar
    Then Admin should see the checkbox default state as unchecked beside the Program Name column header

  Scenario Outline: Validate edit icon, check box , delete icon in each data rows for program module
     Then Admin should see the "<Options>" in each rows

    Examples: 
      | Options     |
      | Edit_Icon   |
      | Check_Box   |
      | Delete_Icon |
      
  Scenario: Verify pagination icons and text below data table
    Given Admin is on the home page after Login
    When Admin clicks "Program" on the navigation bar
    Then Admin should see the text as "Showing x to y of z entries" along with Pagination icons below the table

  Scenario: Admin should see the footer message with total number of programs
    Given Admin is on the home page after Login
    When Admin clicks "Program" on the navigation bar
    Then Admin should see the footer as "In total there are z programs"
