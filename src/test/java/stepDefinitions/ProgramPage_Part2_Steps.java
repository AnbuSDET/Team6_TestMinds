package stepDefinitions;

import java.io.IOException;

import org.testng.Assert;

import commonUtilities.Constants;
import commonUtilities.Context;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.ProgramPage_Part2;

public class ProgramPage_Part2_Steps extends Constants {
	

	Context context;
	ProgramPage_Part2 programpage2;

	public ProgramPage_Part2_Steps(Context context) {
		this.context = context;
		programpage2 = context.getProgramPage2();
	}

	@Then("Admin is on the Manage Program page after login")
	public void admin_is_on_the_manage_program_page_after_login() {
	    programpage2.validateProgramTitle();
	}

	//Edit Program
	
	@When("Admin edits the program and click on save button from {string} with scenario name {string}")
	public void admin_edits_the_program_and_click_on_save_button_from_with_scenario_name(String sheetName, String scenarioName) throws IOException {
	    programpage2.clickProgramEditBtn();
		programpage2.editProgramName(sheetName, scenarioName);
	}
	@Then("Updated program name is seen by the Admin from {string} with scenario name {string}")
	public void updated_program_name_is_seen_by_the_admin_from_with_scenario_name(String sheetName, String scenarioName) {
	   programpage2.validateProgram(sheetName, scenarioName);
	}
	
	@When("Admin clicks on {string} for particular program")
	public void admin_clicks_on_for_particular_program(String string) {
		 programpage2.clickProgramEditBtn();
	}
	@Then("Admin should see pop up window for program details")
	public void admin_should_see_pop_up_window_for_program_details() {
	   programpage2.validateProgramEditPopup();
	}

	@Then("Admin should see window title as {string}")
	public void admin_should_see_window_title_as(String string) {
		programpage2.validateProgramEditTitle();
	}
	
	@Then("Admin should see red {string} mark beside mandatory field {string}")
	public void admin_should_see_red_mark_beside_mandatory_field(String asterisk, String field) {
		programpage2.validateAsterisk(asterisk, field);
	}
	
	@When("Admin clicks Cancel button")
	public void admin_clicks_cancel_button() {
		programpage2.clickCancelBtn();
	}

	@Then("Admin can see Program Details form disappears")
	public void admin_can_see_program_details_form_disappears() {
		programpage2.isProgramDetailsPopupDisappears();
	}
	//Add Program
	
	@When("Admin adds the program and click on save button from {string} with scenario name {string}")
	public void admin_adds_the_program_and_click_on_save_button_from_with_scenario_name(String sheetName, String scenarioName) throws IOException, InterruptedException {
		 programpage2.clickProgramAddBtn();
		programpage2.enterValidProgramDetails(sheetName, scenarioName);
	}
	@Then("Admin gets message for new program for each {string} and  {string}")
	public void admin_gets_message_for_new_program_for_each_and(String sheetName, String scenarioName) {
		programpage2.validateProgram(sheetName, scenarioName);
	}
	
	//Search Program
	
	@Then("Admin searches with newly created program name from {string} with scenario name {string}")
	public void admin_searches_with_newly_created_program_name_from_with_scenario_name(String sheetName, String scenarioName) throws IOException, InterruptedException {
		programpage2.searchProgram(sheetName, scenarioName);
	}
	
	//sorting
	
	@When("Admin clicks the sort icon of Program Description column in the Program module")
	public void admin_clicks_the_sort_icon_of_program_description_column_in_the_program_module() {
		log.info("ProgramSortingSteps---Admin clicks the sort icon of Program Description column to sort Program description in the Program module");
		programpage2.clickProgramDescColumnHeader();
	}
	@Then("The data get sorted on the table based on the Program Description column values in ascending order in the Program module")
	public void the_data_get_sorted_on_the_table_based_on_the_program_description_column_values_in_ascending_order_in_the_program_module() {
		log.info("ProgramSortingSteps---The data get sorted on the table based on the Program Description column values in ascending order in the Program module");
		//compare original vs sorted list
		  Assert.assertTrue(programpage2.getOriginalProgramDescList().equals(programpage2.getSortedProgramDescriptionListAsc()),"The data is sorted on the table based on the Program Description column values in ascending order");
	}
	@When("Admin clicks the sort icon of Program Description column to sort Program Description in descending order in the Program module")
	public void admin_clicks_the_sort_icon_of_program_description_column_to_sort_program_description_in_descending_order_in_the_program_module() {
		programpage2.clickProgDescSortIcon();
	}
	@Then("The data get sorted on the table based on the Program Description column values in descending order in the Program module")
	public void the_data_get_sorted_on_the_table_based_on_the_program_description_column_values_in_descending_order_in_the_program_module() {
		log.info("ProgramSortingSteps---The data get sorted on the table based on the Program Description column values in descending order in the Program module");
		//compare original vs sorted list
		Assert.assertTrue(programpage2.getOriginalProgramDescList().equals(programpage2.getSortedProgramDescriptionListDesc()),"The data get sorted on the table based on the Program Description column values in descending order");
	}
	
	@When("Admin clicks the sort icon of Program Status column in the Program module")
	public void admin_clicks_the_sort_icon_of_program_status_column_in_the_program_module() {
		log.info("ProgramSortingSteps---Admin clicks the sort icon of Program Status column in the Program module");
		programpage2.clickProgramStatusColumnHeader();
	}
	@Then("The data get sorted on the table based on the Program Status column values in ascending order in the Program module")
	public void the_data_get_sorted_on_the_table_based_on_the_program_status_column_values_in_ascending_order_in_the_program_module() {
		log.info("ProgramSortingSteps---The data get sorted on the table based on the Program Status column values in ascending order in the Program module");
		//compare original vs sorted list
		  Assert.assertTrue(programpage2.getOriginalProgramStatusList().equals(programpage2.getSortedProgramStatusListAsc()),"The data get sorted on the table based on the Program Status column values in ascending order");
	}
	@When("Admin clicks the sort icon of Program Status column to sort Program status in descending order in the Program module")
	public void admin_clicks_the_sort_icon_of_program_status_column_to_sort_program_status_in_descending_order_in_the_program_module() {
		programpage2.clickProgDescSortIcon();
	}
	@Then("The data get sorted on the table based on the Program Status column values in descending order in the Program module")
	public void the_data_get_sorted_on_the_table_based_on_the_program_status_column_values_in_descending_order_in_the_program_module() {
		log.info("ProgramSortingSteps---The data get sorted on the table based on the Program Status column values in descending order in the Program module");
		//compare original vs sorted list
		Assert.assertTrue(programpage2.getOriginalProgramStatusList().equals(programpage2.getSortedProgramStatusListDesc()),"The data get sorted on the table based on the Program Status column values in descending order");
	}
	
	@When("Admin clicks the sort icon of Program Name column in the Program module")
	public void admin_clicks_the_sort_icon_of_program_name_column_in_the_program_module() {
	   programpage2.clickProgramNameColumnHeader();
	}
	@Then("The data get sorted on the table based on the Program Name column values in ascending order in the Program module")
	public void the_data_get_sorted_on_the_table_based_on_the_program_name_column_values_in_ascending_order_in_the_program_module() {
		programpage2.getSortedProgramNameListAsc();
		//compare original vs sorted list
		  Assert.assertTrue(programpage2.getOriginalProgramNameList().equals(programpage2.getSortedProgramNameListAsc()),"The data is sorted on the table based on the program name column values in ascending order");
	}
	@When("Admin clicks the sort icon of Program Name column to sort Program Name in descending order in the Program module")
	public void admin_clicks_the_sort_icon_of_program_name_column_to_sort_program_name_in_descending_order_in_the_program_module() {
		programpage2.clickProgDescSortIcon();
	}
	@Then("The data get sorted on the table based on the Program Name column values in descending order in the Program module")
	public void the_data_get_sorted_on_the_table_based_on_the_program_name_column_values_in_descending_order_in_the_program_module() {
		log.info("ProgramSortingSteps---The data get sorted on the table based on the Program Name column values in descending order in the Program module");
		//compare original vs sorted list
		Assert.assertTrue(programpage2.getOriginalProgramNameList().equals(programpage2.getSortedProgramNameListDesc()),"The data is sorted on the table based on the Program Name column values in descending order");
	}

	
}
