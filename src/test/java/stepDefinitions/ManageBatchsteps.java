package stepDefinitions;


import static org.junit.Assert.assertFalse;

import java.io.IOException;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import commonUtilities.Context;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.ManageBatchPage;
import pageObjects.Pagination;


public class ManageBatchsteps {
	
	Context context;	
	ManageBatchPage managebatchPage;	
	Pagination pagination;
	
	
	public ManageBatchsteps(Context context) {		
		this.context = context;
		managebatchPage = context.getmanagebatchpage();		
		pagination=context.getpagination();
		
	}
	
	// Background
	
	@When("Admin clicks the batch menu from the header")
	public void admin_clicks_the_batch_menu_from_the_header() {
		managebatchPage.headerBatchClick();
	}

	@Then("Admin should land on the Batch page")
	public void admin_should_land_on_the_batch_page() {
		Assert.assertEquals(managebatchPage.BatchPageValidation().contains("batch"),true);
		
	}
	

	//	Validate "Title" in Batch Page

	@Then("Admin should see the {string} Title")
	public void admin_should_see_the_title(String title) {	
		
		Assert.assertEquals(managebatchPage.TitleValidation().contains(title),true);
	}
	
	
     // Validate "heading" in the Batch Page
	
	@Then("Admin should see the {string} Heading")
	public void admin_should_see_the_heading(String heading) {
		Assert.assertEquals(managebatchPage.batchHeadingValidation().contains(heading),true);
	}

	
	// Validate disabled "Delete Icon" under the header in the Batch Page
	
	@Then("Admin should see the disabled Delete Icon under the header")
	public void admin_should_see_the_disabled_delete_icon_under_the_header() {
		Assert.assertEquals(managebatchPage.batchdisableDelBtn(),false);		
	}
	
	// Validate pagination in the Batch Page
	
	@Then("Admin should see the enabled pagination controls under the data table")
	public void admin_should_see_the_enabled_pagination_controls_under_the_data_table() {
		Assert.assertEquals(managebatchPage.enabledpaginationBtn(),true);
	    
	}
       // Validate edit icon, check box , delete icon in each data rows
	
	@Then("Admin should see the {string} in each rows")
	public void admin_should_see_the_in_each_rows(String Options) {
	    Assert.assertEquals(managebatchPage.batchAllrowOptions(Options), true);
		
	}

		// Validate sort icon next to all the data table header
	
	@Then("Admin should see the sort icon next to all Datatable headers")
	public void admin_should_see_the_sort_icon_next_to_all_datatable_headers() {
		
		managebatchPage.validateSortIcons();
	}
	
	
	//Validate Check box in the Data table header row 
	
	@Then("Admin should see the checkbox  in the datatable header row")
	public void admin_should_see_the_checkbox_in_the_datatable_header_row() {
		Assert.assertEquals(managebatchPage.headerCheckboxValidation(),true);
		
	}
	
	// Validate  Data table headers	

   @Then("Admin should see the datatable headers {string}")
   public void admin_should_see_the_datatable_headers(String Headertext) {
    Assert.assertEquals(managebatchPage.getTableHeader().contains(Headertext), true);
}
	
   // Verify sub menu displayed in batch menu bar
   
   @Then("Admin should see sub menu in menu bar as {string}")
   public void admin_should_see_sub_menu_in_menu_bar_as(String addBatch) {
       Assert.assertEquals(managebatchPage.addNewBatch_btnValidation().contains(addBatch), true);
   }
	
   // Validate all the fields exist in Add new Batch pop up
   
   @When("Admin Clicks the Add New batch button")
   public void admin_clicks_the_add_new_batch_button() {
	   managebatchPage.clickAddnewbatch();
   }
   @Then("The pop up should have all the enabled fields for New batch")
   public void the_pop_up_should_have_all_the_enabled_fields_for_new_batch() {
	   Assert.assertEquals(managebatchPage.batchPopupAllfieldValidation(), true);
	   
   }
   
   // Validate batch name prefix selected program name
   
   @When("Admin selects the program name in the dropdown")
   public void admin_selects_the_program_name_in_the_dropdown() {
	   managebatchPage.popUp_ProgramName_Select();
	   
   }
   
   @Then("Admin should see selected program name in the batch name prefix box")
   public void admin_should_see_selected_program_name_in_the_batch_name_prefix_box() {
      Assert.assertEquals(managebatchPage.batchNamePrefixValidation(),true);
   }
   
   //  Validate batch name suffix box should accept only numbers
   
   @When("Admin enters alphabets in batch name suffix box")
   public void admin_enters_alphabets_in_batch_name_suffix_box() {
	   managebatchPage.batchNameSuffix_sendKeys();
   }
   @Then("Admin should get error message below the text box of respective field")
   public void admin_should_get_error_message_below_the_text_box_of_respective_field() {
       Assert.assertEquals(managebatchPage.batchNameSufix_Validation().contains(" field accept only numbers"),true);
   }
   
   // validate close icon on the batch details pop up
   
   @When("Admin Enters the alphabets in batch name Prefix box")
   public void admin_enters_the_alphabets_in_batch_name_prefix_box() {
	   managebatchPage.batchname_prefixSendKeys();
   }
   @Then("Admin should see empty text box")
   public void admin_should_see_empty_text_box() {
	   Assert.assertEquals(managebatchPage.batchname_prefixValidation(),true);
   }
   
   //validate close icon on the batch details pop up

   @When("Admin clicks the close button")
   public void admin_clicks_the_close_button() {
	   managebatchPage.addNewbatch_closeBtn_click();
   }
   @Then("Admin should see the batch details pop up closes")
   public void admin_should_see_the_batch_details_pop_up_closes() {
	   Assert.assertEquals(managebatchPage.headerCheckboxValidation(),true);
   }
   
   // Verify Add  Batch functionalities 
   
   @Then("Admin Adds new Batch and click on save button for the scenario {string} in batch module")
   public void admin_adds_new_batch_and_click_on_save_button_for_the_scenario_in_batch_module(String scenarioName) throws IOException {
	   managebatchPage.AddNewBath(scenarioName);
   }
   @Then("Admin gets message for the scenario {string} for batch Module")
   public void admin_gets_message_for_the_scenario_for_batch_module(String scenarioName) throws InterruptedException, IOException {
	   Assert.assertEquals(managebatchPage.addNewBatch_Mesgvalidation(scenarioName),true);
   }
   
    // Edit Batch Functionalities
   
   //Validate Edit icon feature in any row
   
   @When("Admin clicks the edit icon")
   public void admin_clicks_the_edit_icon() {
	   managebatchPage.batch_ClickeditIcon();
   }
   
   @Then("Admin should see the Batch details pop up window")
   public void admin_should_see_the_batch_details_pop_up_window() {
       Assert.assertEquals(managebatchPage.dialogBox.isDisplayed(), true);
   }
   
   // Validate program name & Batch Name value is disabled to edit
   
   @Then("Admin should see Program & Batch {string} field is disabled for editing")
   public void admin_should_see_program_batch_field_is_disabled_for_editing(String names) {
       Assert.assertEquals(managebatchPage.ProgramBatchenableValidation(names), true);
	   
   }
   
   // Verify Edit Pop up functionalities
   
   @Then("Admin Edits Batch and click on save button for the scenario {string} in batch module")
   public void admin_edits_batch_and_click_on_save_button_for_the_scenario_in_batch_module(String scenarioName) throws InterruptedException, IOException {
	   managebatchPage.EditBath(scenarioName);
   }
   @Then("Admin gets message for the Edit batch scenario {string} for batch Module")
   public void admin_gets_message_for_the_edit_batch_scenario_for_batch_module(String scenarioName) throws InterruptedException, IOException {
	   Assert.assertEquals(managebatchPage.EditBatch_REsponseValidations(scenarioName), true);		
   }
   
   // Batch Page Pagination
   // Validate next page link
   
   @When("Admin clicks next page link on the data table")
   public void admin_clicks_next_page_link_on_the_data_table() throws InterruptedException {
     pagination.clicknextpagelink();
	   
   }
   @Then("Admin should see the Next enabled link")
   public void admin_should_see_the_next_enabled_link() {       
	   Assert.assertTrue(pagination.isNextLinkEnabled());
   }
   
   // Validate last page link
   
   @When("Admin clicks last page link on the data table")
   public void admin_clicks_last_page_link_on_the_data_table() throws InterruptedException {
      
	   pagination.clicklastpagelink();
   }
   @Then("Admin should see the last page link with next page link disabled on the table")
   public void admin_should_see_the_last_page_link_with_next_page_link_disabled_on_the_table() throws InterruptedException {
	   
	   boolean[] results = pagination.nextandlastlinksdisabled();
       assertFalse("Double arrow right button should be disabled", results[0]);
       assertFalse("Next button should be disabled", results[1]);
   }
   
   //validate the previous page link
   
   @When("Admin clicks previous page link on the data table")
   public void admin_clicks_previous_page_link_on_the_data_table() throws InterruptedException {
       pagination.clickbackwardpagelink();
   }
   @Then("Admin should see the previous page on the table")
   public void admin_should_see_the_previous_page_on_the_table() {
	   Assert.assertTrue(pagination.isPreviousLinkEnabled());
   }
   
   // validate the first page link
   
   @When("Admin clicks first page link on the data table")
   public void admin_clicks_first_page_link_on_the_data_table() throws InterruptedException {
       pagination.clickfirstpagelink();
   }
   @Then("Admin should see the very first page on the data table")
   public void admin_should_see_the_very_first_page_on_the_data_table() throws InterruptedException {
	   boolean[] results = pagination.backwardandpreviouslinksdisabled();
       assertFalse("Double arrow left button should be disabled", results[0]);
	     assertFalse("back button should be disabled", results[1]);
   }
   
   @Then("Admin searches by valid batch name with {string} and {string} in the batch module")
   public void admin_searches_by_valid_batch_name_with_and_in_the_batch_module(String sheetName, String scenarioName) throws IOException, InterruptedException {
       // Write code here that turns the phrase above into concrete actions
	   managebatchPage.searchBatch(sheetName, scenarioName);
   }
 
  
}