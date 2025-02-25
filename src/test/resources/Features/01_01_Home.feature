Feature: Login Module functionalities      
 
  Scenario: Verify Admin is able to land on login page
    When Admin gives the correct LMS portal URL
    Then Admin should land on the login page    

  Scenario: Verify Admin is able to land on home page with invalid URL
    When Admin gives the invalid LMS portal URL
    Then Admin should receive application error
    

  Scenario: Verify for broken link
    When Admin gives the correct LMS portal URL
    Then HTTP response should be >= 400, indicating the link is broken
    
 
  Scenario: Verify the text spelling in the page
    When Admin gives the correct LMS portal URL
    Then Admin should see correct spellings in all fields
    

  Scenario: Verify application name
    When Admin gives the correct LMS portal URL
    Then Admin should see "LMS - Learning Management System"
    
 
  Scenario: Verify company name
    When Admin gives the correct LMS portal URL
    Then Admin should see company name below the app name 
     

  Scenario: Verify text field is present
    When Admin gives the correct LMS portal URL
    Then Admin should see two text fields
    

  Scenario: Verify text on the first field
    When Admin gives the correct LMS portal URL
    Then Admin should see "User" in the first text field
    

  #Scenario: Verify dropdown is present
    #When Admin gives the correct LMS portal URL
    #Then Admin should see one dropdown
    

  Scenario: Verify asterisk next to USER text
    When Admin gives the correct LMS portal URL
    Then Admin should see an asterisk mark symbol next to the text for mandatory fields


  Scenario: Verify text on the second field
    When Admin gives the correct LMS portal URL
    Then Admin should see "Password" in the second text field

  Scenario: Verify asterisk mark symbol next to password text
    When Admin gives the correct LMS portal URL
    Then Admin should see an asterisk mark symbol next to the password text    

  Scenario: Verify placeholder in dropdown to select role
   When Admin gives the correct LMS portal URL
    Then Admin should see "Select the role" placeholder in dropdown
    

  Scenario: Verify dropdown option to select role
    When Admin gives the correct LMS portal URL
    Then Admin should see  "Admin , staff, student" options in dropdown
    
   
  Scenario: Verify the alignment of input fields for login
    When Admin gives the correct LMS portal URL
    Then Admin should see input fields in the center of the page


  Scenario: Verify Login button is present
    When Admin gives the correct LMS portal URL
   Then Admin should see the login button


  Scenario Outline: Verify input descriptive text in user field
   When Admin gives the correct LMS portal URL
   Then Admin should see "<TextNames>" in gray color
   
   Examples:
   |TextNames|
   |User|
   |Password|   
  
    
   
  
        
    
    


  