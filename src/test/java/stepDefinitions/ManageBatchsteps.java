package stepDefinitions;

import org.testng.Assert;

import commonUtilities.Context;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.ManageBatchPage;

public class ManageBatchsteps {
	
	Context context;	
	ManageBatchPage managebatchPage;	
	
	public ManageBatchsteps(Context context) {		
		this.context = context;
		managebatchPage = context.getmanagebatchpage();			
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


}