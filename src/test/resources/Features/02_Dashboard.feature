@home
Feature: HomePage

  Background: 
    Given Admin is in login Page.
    When Admin enter valid data with "Login" and "Login with valid credentials" in all fields and clicks login button
    Then Admin should land on Home page

  Scenario: Verify LMS title
    Then Admin should see LMS -Learning management system as title

  Scenario: Verify LMS title alignment
    Then LMS title should be on the top left corner of page

  Scenario: Validate navigation bar text
    Then Admin should see correct spelling in navigation bar text

  Scenario: Validate LMS title has correct spelling and spacing
    Then Admin should see correct spelling and space in the LMS title

  Scenario: Validate alignment for navigation bar
    Then Admin should see the navigation bar text on the top right side

  Scenario: Validate navigation bar order
    Then Admin should see the navigation bar items in the correct order
      | Home    |
      | Program |
      | Batch   |
      | Class   |
      | Logout  |

  Scenario: Verify pie-chart presence
    Then Admin should see the pie chart

  Scenario: Verify user details
    Then Admin should see a welcome message with the user name and role

  Scenario: Verify bar chart
    Then Admin should see the bar chart for active and inactive users

  Scenario: Verify user count
    Then Admin should see the user count (includes active and inactive)

  Scenario: Verify staff count
    Then Admin should see the staff count (includes active and inactive)

  Scenario: Verify program count
    Then Admin should see the program count (includes active and inactive)

  Scenario: Verify batch count
    Then Admin should see the batch count (includes active and inactive)

  Scenario: Verify staff table pagination
    Then Admin should see the staff table with pagination icons

  Scenario: Verify staff data page split
    Then Admin should see 5 staff data entries per page

  Scenario: Verify previous page icon disabled
    Then Admin should see the previous page icon disabled

  Scenario: Verify first page icon disabled
    Then Admin should see the first page icon disabled
