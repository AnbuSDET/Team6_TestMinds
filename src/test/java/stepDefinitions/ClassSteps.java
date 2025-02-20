package stepDefinitions;

import commonUtilities.Constants;
import commonUtilities.Context;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.ClassPage;

public class ClassSteps extends Constants{
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
public void admin_clicks_the_in_the_header_in_class(String string) {
    // Write code here that turns the phrase above into concrete actions
    System.out.println("executing class01 scenario");
    classPage.classBtnClick();
    
}

@Then("Admin should land on the {string} in class")
public void admin_should_land_on_the_in_class(String pageHeader) {
    // Write code here that turns the phrase above into concrete actions
   classPage.verifyPageTitle(pageHeader);
}

@Then("Admin should see the {string} Title in class")
public void admin_should_see_the_title_in_class(String string) {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}

@Then("Admin should see the Searchbar in class")
public void admin_should_see_the_searchbar_in_class() {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}

@Then("Admin should see the data table heading")
public void admin_should_see_the_data_table_heading(io.cucumber.datatable.DataTable dataTable) {
    // Write code here that turns the phrase above into concrete actions
    // For automatic transformation, change DataTable to one of
    // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
    // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
    // Double, Byte, Short, Long, BigInteger or BigDecimal.
    //
    // For other transformations you can register a DataTableType.
    throw new io.cucumber.java.PendingException();
}

@Then("Admin should see the {string} and enabled pagination controls under the data table in class")
public void admin_should_see_the_and_enabled_pagination_controls_under_the_data_table_in_class(String string) {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}

@Then("Admin should see the Sort icon for all the fields in the data table in class")
public void admin_should_see_the_sort_icon_for_all_the_fields_in_the_data_table_in_class() {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}

@Then("Admin should see the Delete button under the Manage class page header in class")
public void admin_should_see_the_delete_button_under_the_manage_class_page_header_in_class() {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}

@Then("Admin should see {string} in below of the data table in class")
public void admin_should_see_in_below_of_the_data_table_in_class(String string) {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}

@Given("Admin is on the Manage class page in class")
public void admin_is_on_the_manage_class_page_in_class() {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}

@When("Admin clicks add new class under the class menu bar in class")
public void admin_clicks_add_new_class_under_the_class_menu_bar_in_class() {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}

@Then("Admin should see a manage class pop up with empty form and <SAVE> and <CANCEL> button and Close\\(X) Icon on the top right corner of the window in class")
public void admin_should_see_a_manage_class_pop_up_with_empty_form_and_save_and_cancel_button_and_close_x_icon_on_the_top_right_corner_of_the_window_in_class() {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}

@Then("Admin should see few input fields and their respective text boxes in the class details window in class")
public void admin_should_see_few_input_fields_and_their_respective_text_boxes_in_the_class_details_window_in_class() {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}


}
