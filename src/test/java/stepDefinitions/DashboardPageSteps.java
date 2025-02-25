package stepDefinitions;

import java.io.IOException;
import java.util.List;

import org.testng.Assert;

import commonUtilities.Context;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import pageObjects.DashboardPage;

public class DashboardPageSteps {

	Context context;
	DashboardPage dashboardpage;

	public DashboardPageSteps(Context context) {
		this.context = context;
		dashboardpage = context.getDashboardPage();
	}

	@Then("Admin should see LMS -Learning management system as title")
	public void admin_should_see_lms_learning_management_system_as_title() {
		Assert.assertTrue(
				dashboardpage.getLearningManagementSystemTitle().trim().contains("LMS - Learning Management System"),
				"'LMS - Learning Management System' page is not displayed");
	}

	@Then("LMS title should be on the top left corner of page")
	public void lms_title_should_be_on_the_top_left_corner_of_page() {
		dashboardpage.checkLMSAlignment();
	}

	@Then("Admin should see correct spelling in navigation bar text")
	public void admin_should_see_correct_spelling_in_navigation_bar_text() {
		dashboardpage.verifyNavigationBarTexts();
	}

	@Then("Admin should see correct spelling and space in the LMS title")
	public void admin_should_see_correct_spelling_and_space_in_the_lms_title() {
		dashboardpage.verifyLMSTitleSpellAndSpace();
	}

	@Then("Admin should see the navigation bar text on the top right side")
	public void admin_should_see_the_navigation_bar_text_on_the_top_right_side() {
		dashboardpage.verifyNavigationBarTopAlignment();
	}

	@Then("Admin should see the navigation bar items in the correct order")
	public void admin_should_see_field_in_the_place(DataTable table) {
		List<String> expectedFields = table.asList();
		dashboardpage.verifyNavigationBarOrder(expectedFields);
	}

	@Then("Admin should see the pie chart")
	public void admin_should_see_the_pie_chart() {
		dashboardpage.validatePieChart();
	}

	@Then("Admin should see a welcome message with the user name and role")
	public void admin_should_see_a_welcome_message_with_the_user_name_and_role() throws IOException {
		dashboardpage.validateUserAndRole("Login", "Login with valid credentials");
	}

	@Then("Admin should see the bar chart for active and inactive users")
	public void admin_should_see_the_bar_chart_for_active_and_inactive_users() throws InterruptedException {
		dashboardpage.validateBarChart();
	}

	@Then("Admin should see the program count \\(includes active and inactive)")
	public void admin_should_see_the_program_count_includes_active_and_inactive() throws InterruptedException {
		dashboardpage.extractProgramCount();
	}

	@Then("Admin should see the user count \\(includes active and inactive)")
	public void admin_should_see_the_user_count_includes_active_and_inactive() throws InterruptedException {
		dashboardpage.extractUserCount();
	}

	@Then("Admin should see the staff count \\(includes active and inactive)")
	public void admin_should_see_the_staff_count_includes_active_and_inactive() throws InterruptedException {
		dashboardpage.extractStaffCount();
	}

	@Then("Admin should see the batch count \\(includes active and inactive)")
	public void admin_should_see_the_batch_count_includes_active_and_inactive() throws InterruptedException {
		dashboardpage.extractBatchCount();
	}

	@Then("Admin should see the first page icon disabled")
	public void admin_should_see_the_first_page_icon_disabled() {
		dashboardpage.validateFirstPageIcon();
	}

	@Then("Admin should see {int} staff data entries per page")
	public void admin_should_see_staff_data_entries_per_page(Integer int1) {
		dashboardpage.validatepaginatorEntries();
	}

	@Then("Admin should see the previous page icon disabled")
	public void admin_should_see_the_previous_page_icon_disabled() {
		dashboardpage.validatePreviousPageIcon();
	}

	@Then("Admin should see the staff table with pagination icons")
	public void admin_should_see_the_staff_table_with_pagination_icons() {
		dashboardpage.validatepaginationIcons();
	}

}
