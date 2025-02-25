package stepDefinitions;

import java.io.IOException;

import org.testng.Assert;

import commonUtilities.Constants;
import commonUtilities.Context;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.ClassPage;

public class ClassSteps extends Constants {
	Context context;
	ClassPage classPage;

	public ClassSteps(Context context) {
		this.context = context;
		classPage = context.getClassPage();
	}

//@Given("Admin is on the Dashboard Page in class")
//public void admin_is_on_the_dashboard_page_in_class() {
//  
//}

	@When("Admin clicks the {string} in the Header in class")
	public void admin_clicks_the_in_the_header_in_class(String classHeader) throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		classPage.classBtnClick();

	}

	@Then("Admin should land on the {string} in class")
	public void admin_should_land_on_the_in_class(String pageHeader) {
		// Write code here that turns the phrase above into concrete actions
		classPage.verifyPageTitle(pageHeader);
	}

	@Then("Admin should see the {string} Title in class")
	public void admin_should_see_the_title_in_class(String columnHeader) {
		// Write code here that turns the phrase above into concrete actions
		classPage.verifyHeaderTitle(columnHeader);
	}

	@Then("Admin should see the Searchbar in class")
	public void admin_should_see_the_searchbar_in_class() {
		// Write code here that turns the phrase above into concrete actions
		classPage.verifySearchBox();
	}

	@Then("Admin should see the data table heading")
	public void admin_should_see_the_data_table_heading(io.cucumber.datatable.DataTable dataTable) {
		// Write code here that turns the phrase above into concrete actions
		classPage.columnHeaderTopic();
	}

	@Then("Admin should see the {string} and enabled pagination controls under the data table in class")
	public void admin_should_see_the_and_enabled_pagination_controls_under_the_data_table_in_class(String string) {
		// Write code here that turns the phrase above into concrete actions
		classPage.paginationDetails();
	}

	@Then("Admin should see the Sort icon for all the fields in the data table in class")
	public void admin_should_see_the_sort_icon_for_all_the_fields_in_the_data_table_in_class() {
		// Write code here that turns the phrase above into concrete actions
		classPage.batchSortIcon();
	}

	@Then("Admin should see the Delete button under the Manage class page header in class")
	public void admin_should_see_the_delete_button_under_the_manage_class_page_header_in_class() {
		// Write code here that turns the phrase above into concrete actions
		classPage.trashIcon();
	}

	@Then("Admin should see {string} in below of the data table in class")
	public void admin_should_see_in_below_of_the_data_table_in_class(String footer) {
		// Write code here that turns the phrase above into concrete actions
classPage.getFooterText(footer);
	}

	@Given("Admin is on the Manage class page in class")
	public void admin_is_on_the_manage_class_page_in_class() {
		// Write code here that turns the phrase above into concrete actions
		classPage.openClassUrl();
	}

	@When("Admin clicks add new class under the class menu bar in class")
	public void admin_clicks_add_new_class_under_the_class_menu_bar_in_class() throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions

		classPage.classBtnClick();
		classPage.addNewClass();
	}

	@Then("Admin should see a manage class pop up with empty form and <SAVE> and <CANCEL> button and Close\\(X) Icon on the top right corner of the window in class")
	public void admin_should_see_a_manage_class_pop_up_with_empty_form_and_save_and_cancel_button_and_close_x_icon_on_the_top_right_corner_of_the_window_in_class() {
		// Write code here that turns the phrase above into concrete actions
		classPage.classDetailsPopup();
	}

	@Then("Admin should see few input fields and their respective text boxes in the class details window in class")
	public void admin_should_see_few_input_fields_and_their_respective_text_boxes_in_the_class_details_window_in_class() {
		// Write code here that turns the phrase above into concrete actions
		classPage.checkInputFields();
	}

	@Given("Admin is on the Class Popup window in class")
	public void admin_is_on_the_class_popup_window_in_class() {
		// Write code here that turns the phrase above into concrete actions
		classPage.openClassUrl();
		// classPage.clickSearchBar();
	}

	@When("Admin enters {string} and {string} mandatory fields in the form and clicks on save button in class")
	public void admin_enters_and_mandatory_fields_in_the_form_and_clicks_on_save_button_in_class(String sheetName,
			String scenarioName) throws IOException, InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		classPage.classBtnClick();
		classPage.addNewClass();
		classPage.addClass(sheetName, scenarioName);
	}

	@Then("Admin gets message Class added Successfully in class")
	public void admin_gets_message_class_added_successfully_in_class() {
		// Write code here that turns the phrase above into concrete actions
		classPage.ValSuccessToastMsg("Successful");
	}

	@When("Admin clicks on save button without entering data")
	public void admin_clicks_on_save_button_without_entering_data() throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		classPage.classBtnClick();
		classPage.addNewClass();
		classPage.clickSaveBtn();
	}

	@Then("Class not created and Admin gets error message below mandatory fields in red")
	public void class_not_created_and_admin_gets_error_message_below_mandatory_fields_in_red() {
		// Write code here that turns the phrase above into concrete actions
		classPage.emptyFieldValidation();
	}

	@When("Admin clicks Cancel Icon on class Details form")
	public void admin_clicks_cancel_icon_on_class_details_form() {
		// Write code here that turns the phrase above into concrete actions
		classPage.clickCancelBtn();
	}

	@Then("Class Details popup window should be closed")
	public void class_details_popup_window_should_be_closed() {
		// Write code here that turns the phrase above into concrete actions
		classPage.verifyClassDetailsPopUpClosed();
	}

	@When("Admin selects class date in date picker {string}")
	public void admin_selects_class_date_in_date_picker(String classDate) throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		classPage.classBtnClick();
		classPage.addNewClass();
		classPage.selectDate();
	}

	@Then("Admin should see no of class value is added automatically {string}")
	public void admin_should_see_no_of_class_value_is_added_automatically(String numOfClass) {
		// Write code here that turns the phrase above into concrete actions
		classPage.verifyNoOfClasses(numOfClass);
	}

	@When("Admin clicks date picker")
	public void admin_clicks_date_picker() throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		classPage.classBtnClick();
		classPage.addNewClass();
		classPage.selectCalendar();
	}

	@Then("Admin should see weekends dates are disabled to select {string}")
	public void admin_should_see_weekends_dates_are_disabled_to_select(String day) {
		// Write code here that turns the phrase above into concrete actions
		classPage.validateIsDateDisabled(day);
	}

	@When("admin enters only the optional field {string} and {string} and clicks save")
	public void admin_enters_only_the_optional_field_and_and_clicks_save(String sheetName, String scenarioName)
			throws IOException, InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		classPage.classBtnClick();
		classPage.addNewClass();
		classPage.addClass(sheetName, scenarioName);
	}

	@Then("Class not created and Admin gets error message below mandatory fields in red for {string} and {string}")
	public void class_not_created_and_admin_gets_error_message_below_mandatory_fields_in_red_for_and(String sheetName,
			String scenarioName) {
		// Write code here that turns the phrase above into concrete actions
		classPage.validateAddClass(sheetName, scenarioName);
	}

	@When("Admin clicks close button")
	public void admin_clicks_close_button() {
		// Write code here that turns the phrase above into concrete actions

	}

}
