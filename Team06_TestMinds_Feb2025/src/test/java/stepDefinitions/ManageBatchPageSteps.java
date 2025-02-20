package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import commonUtilities.Context;
import commonUtilities.Utility_Methods;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.ManageBatchPage;

public class ManageBatchPageSteps {
	
	public WebDriver driver;
	Context context;	
	ManageBatchPage managebatchPage;	
	
	public ManageBatchPageSteps(Context context) {		
		this.context = context;
		managebatchPage = context.getManagebatchPage();		 
	}
	
	// Background
	
	@When("Admin clicks the batch menu from the header")
	public void admin_clicks_the_batch_menu_from_the_header() {
		managebatchPage.headerBatchClick();
	}

	@Then("Admin should land on the Batch page")
	public void admin_should_land_on_the_batch_page() {
	  Assert.assertEquals(managebatchPage.BatchPageValidation().contains("batch"), true);
	}

	//
	
	@Given("Admin is on the Batch Page")
	public void admin_is_on_the_batch_page() {
	
	}

	@Then("Admin should see the {string} Title")
	public void admin_should_see_the_title(String title) {
		Assert.assertEquals(managebatchPage.BatchPageValidation().contains(title),true);
	}
	
	

	@Then("Admin should see the {string} Heading")
	public void admin_should_see_the_heading(String heading) {
		
	}

	@Then("Admin should see the disabled {string} under the header")
	public void admin_should_see_the_disabled_under_the_header(String string) {
		System.out.println("Test");
	}


}
