
package stepDefinitions;

import java.io.IOException;

import org.testng.Assert;

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
	public void admin_updates_the_class_and_click_on_save_button_from_with_scenario_name(String sheetName,
			String scenarioName) throws IOException {
		classpage2.editClass(sheetName, scenarioName);
	}

	@Then("the Admin gets message from {string} with scenario name {string}")
	public void the_admin_gets_message_from_with_scenario_name(String sheetName, String scenarioName) {
		classpage2.validateEditedClass(sheetName, scenarioName);
	}

	@When("Admin clicks Cancel button on edit popup")
	public void admin_clicks_cancel_button_on_edit_popup() {
		classpage2.clickCancelBtn();
	}

	@Then("Admin can see the class details popup disappears and can see nothing changed for particular Class")
	public void admin_can_see_the_class_details_popup_disappears_and_can_see_nothing_changed_for_particular_class() {
		classpage2.validateClassEditPopupNotDisplayed();

	}

	// sorting

	@When("Admin clicks the sort icon of Class Status column in the Class module")
	public void admin_clicks_the_sort_icon_of_class_status_column_in_the_class_module() {
		classpage2.clickClassStatusSortIcon();
	}

	@Then("The data get sorted on the table based on the Class Status column values in ascending order in the Class module")
	public void the_data_get_sorted_on_the_table_based_on_the_class_status_column_values_in_ascending_order_in_the_class_module() {
		classpage2.getSortedClassStatusListAsc();
		// compare original vs sorted list
		Assert.assertTrue(classpage2.getOriginalClassStatusList().equals(classpage2.getSortedClassStatusListAsc()),
				"The data is sorted on the table based on the class status column values in ascending order");
	}

	@When("Admin clicks the sort icon of Class Status column to sort Class status in descending order in the Class module")
	public void admin_clicks_the_sort_icon_of_class_status_column_to_sort_class_status_in_descending_order_in_the_class_module() {
		classpage2.clickClassDescSortIcon();
	}

	@Then("The data get sorted on the table based on the Class Status column values in descending order in the Class module")
	public void the_data_get_sorted_on_the_table_based_on_the_class_status_column_values_in_descending_order_in_the_class_module() {
		Assert.assertTrue(classpage2.getOriginalClassStatusList().equals(classpage2.getSortedClassStatusListDesc()),
				"The data is sorted on the table based on the class status column values in descending order");
	}

	@When("Admin clicks the sort icon of Class Description column in the Class module")
	public void admin_clicks_the_sort_icon_of_class_description_column_in_the_class_module() {
		classpage2.clickClassDescSortIcon();
	}

	@Then("The data get sorted on the table based on the Class Description column values in ascending order in the Class module")
	public void the_data_get_sorted_on_the_table_based_on_the_class_description_column_values_in_ascending_order_in_the_class_module() {
		classpage2.getSortedClassDescListAsc();
		// compare original vs sorted list
		Assert.assertTrue(classpage2.getOriginalClassDescList().equals(classpage2.getSortedClassDescListAsc()),
				"The data is sorted on the table based on the class description column values in ascending order");
	}

	@When("Admin clicks the sort icon of Class Description column to sort Class Description in descending order in the Class module")
	public void admin_clicks_the_sort_icon_of_class_description_column_to_sort_class_description_in_descending_order_in_the_class_module() {
		classpage2.clickClassSortDescIcon();
	}

	@Then("The data get sorted on the table based on the Class Description column values in descending order in the Class module")
	public void the_data_get_sorted_on_the_table_based_on_the_class_description_column_values_in_descending_order_in_the_class_module() {
		Assert.assertTrue(classpage2.getOriginalClassDescList().equals(classpage2.getSortedClassDescListDesc()),
				"The data is sorted on the table based on the class description column values in descending order");
	}

	@When("Admin clicks the sort icon of Batch Name column in the Class module")
	public void admin_clicks_the_sort_icon_of_batch_name_column_in_the_class_module() {
		classpage2.clickBatchSortIcon();
	}

	@Then("The data get sorted on the table based on the Batch Name  column values in ascending order in the Class module")
	public void the_data_get_sorted_on_the_table_based_on_the_batch_name_column_values_in_ascending_order_in_the_class_module() {
		classpage2.getSortedBatchNameListAsc();
		// compare original vs sorted list
		Assert.assertTrue(classpage2.getOriginalBatchNameList().equals(classpage2.getSortedBatchNameListAsc()),
				"The data is sorted on the table based on the batch name column values in ascending order");
	}

	@When("Admin clicks the sort icon of Batch Name column to sort Batch Name  in descending order in the Class module")
	public void admin_clicks_the_sort_icon_of_batch_name_column_to_sort_batch_name_in_descending_order_in_the_class_module() {
		classpage2.clickClassSortDescIcon();
	}

	@Then("The data get sorted on the table based on the Batch Name column values in descending order in the Class module")
	public void the_data_get_sorted_on_the_table_based_on_the_batch_name_column_values_in_descending_order_in_the_class_module() {
		Assert.assertTrue(classpage2.getOriginalBatchNameList().equals(classpage2.getSortedBatchNameListDesc()),
				"The data is sorted on the table based on the batch name column values in descending order");
	}

	@When("Admin clicks the sort icon of Class Date column in the Class module")
	public void admin_clicks_the_sort_icon_of_class_date_column_in_the_class_module() {
		classpage2.clickClassDateSortIcon();
	}

	@Then("The data get sorted on the table based on the Class Date column values in ascending order in the Class module")
	public void the_data_get_sorted_on_the_table_based_on_the_class_date_column_values_in_ascending_order_in_the_class_module() {
		classpage2.getSortedClassDateListAsc();
		// compare original vs sorted list
		Assert.assertTrue(classpage2.getOriginalClassDateList().equals(classpage2.getSortedClassDateListAsc()),
				"The data is sorted on the table based on the class date column values in ascending order");
	}

	@When("Admin clicks the sort icon of Class Date column to sort Class Date in descending order in the Class module")
	public void admin_clicks_the_sort_icon_of_class_date_column_to_sort_class_date_in_descending_order_in_the_class_module() {
		classpage2.clickClassSortDescIcon();
	}

	@Then("The data get sorted on the table based on the Class Date column values in descending order in the Class module")
	public void the_data_get_sorted_on_the_table_based_on_the_class_date_column_values_in_descending_order_in_the_class_module() {
		Assert.assertTrue(classpage2.getOriginalClassDateList().equals(classpage2.getSortedClassDateListDesc()),
				"The data is sorted on the table based on the class date column values in descending order");
	}

	@When("Admin clicks the sort icon of Class Topic column in the Class module")
	public void admin_clicks_the_sort_icon_of_class_topic_column_in_the_class_module() {
		classpage2.clickClassTopicSortIcon();
	}

	@Then("The data get sorted on the table based on the  Class Topic column values in ascending order in the Class module")
	public void the_data_get_sorted_on_the_table_based_on_the_class_topic_column_values_in_ascending_order_in_the_class_module() {
		classpage2.getSortedClassTopicListAsc();
		// compare original vs sorted list
		Assert.assertTrue(classpage2.getOriginalClassTopicList().equals(classpage2.getSortedClassTopicListAsc()),
				"The data is sorted on the table based on the class topic column values in ascending order");
	}

	@When("Admin clicks the sort icon of  Class Topic  column to sort  Class Topic in descending order in the Class module")
	public void admin_clicks_the_sort_icon_of_class_topic_column_to_sort_class_topic_in_descending_order_in_the_class_module() {
		classpage2.clickClassSortDescIcon();
	}

	@Then("The data get sorted on the table based on the Class Topic column values in descending order in the Class module")
	public void the_data_get_sorted_on_the_table_based_on_the_class_topic_column_values_in_descending_order_in_the_class_module() {
		classpage2.getOriginalClassTopicList();
		// compare original vs sorted list
		Assert.assertTrue(classpage2.getOriginalClassTopicList().equals(classpage2.getSortedClassTopicListDesc()),
				"The data is sorted on the table based on the class topic column values in descending order");
	}

	@When("Admin clicks the sort icon of Staff Name column in the Class module")
	public void admin_clicks_the_sort_icon_of_staff_name_column_in_the_class_module() {
		classpage2.clickClassStaffNameSortIcon();

	}

	@Then("The data get sorted on the table based on the Staff Name column values in ascending order in the Class module")
	public void the_data_get_sorted_on_the_table_based_on_the_staff_name_column_values_in_ascending_order_in_the_class_module() {
		classpage2.getSortedClassStatusListAsc();
		// compare original vs sorted list
		Assert.assertTrue(classpage2.getOriginalClassStaffNameList().equals(classpage2.getSortedClassStatusListAsc()),
				"The data is sorted on the table based on the class staff name column values in ascending order");
	}

	@When("Admin clicks the sort icon of Staff Name column to sort Staff Name in descending order in the Class module")
	public void admin_clicks_the_sort_icon_of_staff_name_column_to_sort_staff_name_in_descending_order_in_the_class_module() {
		classpage2.clickClassSortDescIcon();
	}

	@Then("The data get sorted on the table based on the Staff Name column values in descending order in the Class module")
	public void the_data_get_sorted_on_the_table_based_on_the_staff_name_column_values_in_descending_order_in_the_class_module() {
		Assert.assertTrue(classpage2.getOriginalClassStaffNameList().equals(classpage2.getSortedClassStatusListDesc()),
				"The data is sorted on the table based on the class staff name column values in descending order");
	}
}