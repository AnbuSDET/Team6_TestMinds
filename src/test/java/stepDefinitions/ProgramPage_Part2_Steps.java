package stepDefinitions;

import java.io.IOException;

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

	//Add Program
	
	@When("Admin adds the program and click on save button from {string} with scenario name {string}")
	public void admin_adds_the_program_and_click_on_save_button_from_with_scenario_name(String sheetName, String scenarioName) throws IOException {
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
	
}
