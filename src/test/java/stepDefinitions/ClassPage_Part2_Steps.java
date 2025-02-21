
package stepDefinitions;

import java.io.IOException;

import commonUtilities.Constants;
import commonUtilities.Context;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.ClassPage_Part2;

public class ClassPage_Part2_Steps extends Constants {

	Context context;
	ClassPage_Part2 classpage2;

	public ClassPage_Part2_Steps(Context context) {
		this.context = context;
		classpage2 = context.getClassPage2();
	}

	@Then("Admin is on the Manage Class page after login")
	public void admin_is_on_the_manage_class_page_after_login() {
		classpage2.validateClassTitle();
	}

	@When("Admin clicks on the edit icon")
	public void admin_clicks_on_the_edit_icon() {
		classpage2.clickClassEditBtn();
	}

	@Then("A new pop up with class details appears")
	public void a_new_pop_up_with_class_details_appears() {
		classpage2.validateClassEditPopup();
	}

	@Then("Admin should see batch name field is disabled")
	public void admin_should_see_batch_name_field_is_disabled() {
		classpage2.validateDisabledBatchName();
	}

	@Then("Admin should see class topic field is disabled")
	public void admin_should_see_class_topic_field_is_disabled() {
		classpage2.validateDisabledClassTopic();
	}

	@Given("Admin is on the Edit Class Popup window")
	public void admin_is_on_the_edit_class_popup_window() {
		classpage2.clickClassEditBtn();
	}
	@When("Admin updates the class and click on save button from {string} with scenario name {string}")
	public void admin_updates_the_class_and_click_on_save_button_from_with_scenario_name(String sheetName, String scenarioName) throws IOException {
	   classpage2.editClass(sheetName, scenarioName);
	}
	@Then("the Admin gets message from {string} with scenario name {string}")
	public void the_admin_gets_message_from_with_scenario_name(String sheetName, String scenarioName) {
	  classpage2.validateEditedClass(sheetName, scenarioName);
	}

}