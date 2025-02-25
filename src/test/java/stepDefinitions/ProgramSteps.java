package stepDefinitions;

import java.io.IOException;
import java.util.List;

import org.testng.Assert;

import commonUtilities.Context;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.ProgramPage;

public class ProgramSteps {
	Context context;
	ProgramPage programpage;
	
public ProgramSteps(Context context) {
	
		this.context = context;
		programpage = context.getProgramPage();
	}	
	
	
	
@When("Admin clicks the program menu from the header")
public void admin_clicks_the_program_menu_from_the_header() {
    
	programpage.programBtnClick();
}

@Then("Admin should land on the program page")
public void admin_should_land_on_the_program_page() {
	
 Assert.assertTrue(programpage.programPageValidation().contains("program"), "Admin did not land on the program page.");

}

@Then("Admin should see the {string} Title")
public void admin_should_see_the_title(String expectedTitle) {
	
    Assert.assertTrue(programpage.TitleValidation().contains(expectedTitle), "Title does not match.");

	
}

@Given("Admin is on home page after Login")
public void admin_is_on_home_page_after_login() {
	
	String pageTitle = programpage.TitleValidation();
    Assert.assertTrue(pageTitle.contains("LMS"), "Admin is not on the home page.");    
}

@When("Admin clicks {string} on the navigation bar")
public void admin_clicks_on_the_navigation_bar(String string) {
	
	programpage.programBtnClick();
	 
}

@Then("Admin should see Logout in menu bar")
public void admin_should_see_logout_in_menu_bar() {
	
	
Assert.assertTrue(programpage.checklogut(), "Logout option is not visible in the menu bar.");
	
}

@Given("Admin is on  program page")
public void admin_is_on_program_page() {
	
	String programURL = programpage.programPageValidation();
    Assert.assertTrue(programURL.contains("program"), "Admin is not on the program page.");
    
}

@Then("Admin should see sub menu menu bar as {string}")
public void admin_should_see_sub_menu_in_menu_bar_as(String expectedText) {
	
    programpage.validateAddNewProgBtn(expectedText);


}

@Then("Admin should see the heading {string}")
public void admin_should_see_the_heading(String string) {
	
    programpage.validateManageHeader(string);

}

@When("Admin should see a Delete button in left top is disabled")
public void admin_should_see_a_delete_button_in_left_top_is_disabled() {
	
    Assert.assertFalse(programpage.LeftDeleteBtn.isEnabled(), "Left Delete button is not disabled.");

}
@Then("Admin should see Search bar with text as {string}")
public void admin_should_see_search_bar_with_text_as(String string) {
	
	String actualText = programpage.Searchbar.getAttribute("placeholder");
    Assert.assertEquals(actualText, string, "Search bar placeholder text does not match.");
}

@Then("Admin should see data table with column headers on the Manage Program Page")
public void admin_should_see_data_table_with_column_headers_on_the_manage_program_page(io.cucumber.datatable.DataTable dataTable) {
   
	List<String> expectedHeaders = dataTable.asList(String.class);

    // Validate each column header
    programpage.validateAllColHeaders(
            expectedHeaders.get(0), // Program Name
            expectedHeaders.get(1), // Program Description
            expectedHeaders.get(2), // Program Status
            expectedHeaders.get(3) // Edit/Delete
    );

}
@Given("Admin is on the home page after login")
public void admin_is_on_the_home_page_after_login() {
	
	 String pageTitle = programpage.TitleValidation();
     Assert.assertTrue(pageTitle.contains("LMS"), "Admin is not on the home page.");
}

@Then("Admin should see the checkbox default state as unchecked beside the Program Name column header")
public void admin_should_see_the_checkbox_default_state_as_unchecked_beside_the_program_name_column_header() {
    
	boolean isCheckboxUnchecked = programpage.validateheaderCheckBoxUnchecked();
    Assert.assertTrue(isCheckboxUnchecked, "Checkbox beside the Program Name column header is not unchecked by default.");
}



@Given("Admin is on the home page after Login")
public void admin_is_on_the_home_page_after_login1() {
	
	String pageTitle = programpage.TitleValidation();
    Assert.assertTrue(pageTitle.contains("LMS"), "Admin is not on the home page.");
}

@Then("Admin should see the text as {string} along with Pagination icons below the table")
public void admin_should_see_the_text_as_along_with_pagination_icons_below_the_table(String expectedText) {
	
	try {
		programpage.validatePaginationTextandIcons(expectedText);
    } catch (InterruptedException e) {
        Assert.fail("Test interrupted while validating pagination text and icons: " + e.getMessage());
    }
}

@Then("Admin should see the footer as {string}")
public void admin_should_see_the_footer_as(String expectedCount) {
	
	
    programpage.validateFooter(expectedCount);

}


//add new program 

@Given("Admin is on Program page")
public void admin_is_on_program_page1() {

	String programURL = programpage.programPageValidation();
    Assert.assertTrue(programURL.contains("program"), "Admin is not on the program page.");
    
}

@When("Admin clicks on {string} under the {string} menu bar")
public void admin_clicks_on_under_the_menu_bar(String buttonName, String menuName) {
      
	if (buttonName.equals("Add New Program") && menuName.equals("Program")) {
		programpage.clickAddNewProgram();
    } else {
        Assert.fail("Invalid button or menu name provided: " + buttonName + " under " + menuName);
    }
}

@Then("Admin should see a pop-up window for program details")
public void admin_should_see_a_pop_up_window_for_program_details() {
	
	boolean isPopupVisible = programpage.isPopupWindowDisplayed();
    Assert.assertTrue(isPopupVisible, "Program details popup is not visible");

   
}

@Then("Admin should see the window title as {string}")
public void admin_should_see_the_window_title_as(String expectedTitle) {

    programpage.validateProgramDetailsTitle(expectedTitle);

    
}

@Then("Admin should see red asterisk mark beside mandatory field {string}")
public void admin_should_see_red_asterisk_mark_beside_mandatory_field(String fieldName) {
	
	 boolean isAsteriskDisplayed = programpage.isNameAsteriskMarkDisplayed();
     Assert.assertTrue(isAsteriskDisplayed, "Red asterisk mark is not displayed beside the mandatory field: " + fieldName);
 }

   


@Given("Admin is on the Program details form")
public void admin_is_on_the_program_details_form1() {

   
}

@When("Admin clicks the save button without entering mandatory fields")
public void admin_clicks_the_save_button_without_entering_mandatory_fields() {
	
	programpage.clickAddNewProgram(); 
	programpage.waitForPopupWindow(); 
    programpage.clickSaveBtn();

}

@Then("Admin gets message {string} is required")
public void admin_gets_message_is_required(String string, io.cucumber.datatable.DataTable dataTable) {
    
    programpage.validateEmptyFormSubmissionErrors(dataTable);

}


@When("Admin clicks the Cancel button")
public void admin_clicks_the_cancel_button() {
	
	 programpage.clickAddNewProgram(); 
     programpage.clickCancelBtn();

}

@Then("Admin can see the Program Details form disappears")
public void admin_can_see_the_program_details_form_disappears() {
	
	boolean isPopupDisappeared = programpage.isProgramDetailsPopupDisappears();
    Assert.assertTrue(isPopupDisappeared, "Program Details form did not disappear after clicking Cancel.");
   
}

@Given("Admin is on program details form")
public void admin_is_on_program_details_form() {

   
}

@When("Admin enters the Name in the text box from {string} with scenario name {string}")
public void admin_enters_the_name_in_the_text_box_from_with_scenario_name(String sheetName, String scenarioName) {

	programpage.clickAddNewProgram();
	try {
		programpage.enterProgramName(sheetName, scenarioName);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

   
}

@Then("Admin can see the text entered from {string} with scenario name {string}")
public void admin_can_see_the_text_entered_from_with_scenario_name(String sheetName, String scenarioName) {

    try {
    	
		programpage.validateProgramName(sheetName, scenarioName);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}


}

@When("Admin enters the Description in text box from {string} with scenario name {string}")
public void admin_enters_the_description_in_text_box_from_with_scenario_name(String sheetName, String scenarioName) {
	
	try {
		programpage.enterdescription(sheetName, scenarioName);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
	

@Then("Admin can see the text entered in description box from {string} with scenario name {string}")
public void admin_can_see_the_text_entered_in_description_box_from_with_scenario_name(String sheetName, String scenarioName) {

	try {
		programpage.validatedescription(sheetName, scenarioName);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}

@When("Admin selects the status of the program by clicking on the radio button {string} from {string} with scenario name {string}")
public void admin_selects_the_status_of_the_program_by_clicking_on_the_radio_button_from_with_scenario_name(String sheetName, String scenarioName, String status) {

	try {
		programpage.selectStatus(sheetName, scenarioName, status);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

}
	


@Then("Admin can see {string} status selected from {string} with scenario name {string}")
public void admin_can_see_status_selected_from_with_scenario_name(String sheetName, String scenarioName, String status) {
	
	try {
		programpage.validateStatus(sheetName, scenarioName, status);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}




@When("Admin enter valid details for mandatory fields and Click on save button ")
public void admin_enter_valid_details_for_mandatory_fields_and_click_on_save_button_from_with_scenario_name(String sheetName, String scenarioName) {

	try {
		programpage.enterValidDetails(sheetName, scenarioName);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

}

@Then("Admin gets message {string} from {string} with scenario name {string}")
public void admin_gets_message_from_with_scenario_name(String sheetName, String scenarioName, String expectedMessage) {

	try {
		programpage.validateSuccessMessage(sheetName, scenarioName, expectedMessage);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}


@When("Admin clicks on the cancel button")
public void admin_clicks_on_the_cancel_button() {
	
	programpage.clickAddNewProgram();
    programpage.clickCancelBtn();
    

}

@Then("Admin can see the program details form disappear")
public void admin_can_see_the_program_details_form_disappear() {

	boolean isPopupDisappeared = programpage.isProgramDetailsPopupDisappears();
    Assert.assertTrue(isPopupDisappeared, "Program Details form did not disappear after clicking Cancel.");
}

@Given("Admin is on the Program page")
public void admin_is_on_the_program_page() {

   
}

@When("Admin searches with newly created {string}")
public void admin_searches_with_newly_created(String programName) {
	

	try {
        programpage.searchProgName("Program", programName);
    } catch (IOException e) {
        e.printStackTrace();
    }

}

@Then("Records of the newly created {string} should be displayed and match the data entered")
public void records_of_the_newly_created_should_be_displayed_and_match_the_data_entered(String programName) {
	
    try {
		programpage.validateProgramName("Program", programName);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}


}

@Given("Admin is on the program details form")
public void admin_is_on_the_program_details_form() {

   
}

@When("Admin clicks on the {string} button")
public void admin_clicks_on_the_button(String buttonName) {

	programpage.clickAddNewProgram();
        programpage.clickCloseBtn();
}

@Then("the program details form should disappear")
public void the_program_details_form_should_disappear() {

	boolean isPopupDisappeared = programpage.isProgramDetailsPopupDisappears();
    Assert.assertTrue(isPopupDisappeared, "Program Details form did not disappear after clicking X.");
    
}

}












