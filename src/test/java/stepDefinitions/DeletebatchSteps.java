package stepDefinitions;


import static org.testng.Assert.assertEquals;

import java.io.IOException;

import commonUtilities.Context;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import pageObjects.ManageBatchPage;


public class DeletebatchSteps {	
  
	Context context;	
	ManageBatchPage managebatchPage;	
	
	public DeletebatchSteps(Context context) {		
		this.context = context;
		managebatchPage = context.getmanagebatchpage();	
		
	}
	
	
	 //  validate delete Icon on any row
	   
	   @When("Admin clicks on the delete icon and click no button")
	   public void admin_clicks_on_the_delete_icon_and_click_no_button() throws InterruptedException {
		   managebatchPage.click_randomDelBtn();
		   managebatchPage.click_DelBatch_NoBtn();
		   
	   }
	   
	
	@SuppressWarnings("deprecation")
	@Then("Admin should see the alert box closed and the batch is not deleted")
	   public void admin_should_see_the_alert_box_closed_and_the_batch_is_not_deleted() {
		 
		Assert.assertEquals(managebatchPage.delBatchNoValidation(), true);
		
	}
	   
	   // 
	   
	   @When("Admin clicks on the delete icon and click yes button")
	   public void admin_clicks_on_the_delete_icon_and_click_yes_button() throws InterruptedException, IOException {
		   managebatchPage.click_DeleteBatchusingSearch();
		   managebatchPage.Click_batchDelYesBtn();
		   
	   }
	   
	   @SuppressWarnings("deprecation")
	@Then("Admin should see the successful message and the batch should be deleted")
	   public void admin_should_see_the_successful_message_and_the_batch_should_be_deleted() throws InterruptedException {
			/*
			 * String[] results=managebatchPage.sucessmessgetext();
			 * assertEquals(results[0],"Successful");
			 * assertEquals(results[1],"batch Deleted");
			 */
		   Assert.assertEquals(managebatchPage.delBatchNoValidation(), false);
	   }
	   
	   // validate delete Icon on any row
	   
	   @When("Admin clicks the delete Icon on any row")
	   public void admin_clicks_the_delete_icon_on_any_row() {
	       managebatchPage.click_randomDelBtn();
	   }
	      
	   
	   @SuppressWarnings("deprecation")
	@Then("Admin should see the confirm alert box with yes and no button BM")
	   public void admin_should_see_the_confirm_alert_box_with_yes_and_no_button_bm() {
		   Assert.assertEquals(managebatchPage.delBatchNoValidation(), true);
	   }
	 
	   
	   
	   // validate close Icon on the alert box
	   
	   @When("Admin clicks on the close icon")
	   public void admin_clicks_on_the_close_icon() throws InterruptedException {
		   managebatchPage.click_randomDelBtn();
		   managebatchPage.DelclickCloseBtn();
	   }
	   
	   @SuppressWarnings("deprecation")
	@Then("Admin should see the alert box closed in BM")
	   public void admin_should_see_the_alert_box_closed_in_bm() {
		  Assert.assertEquals(managebatchPage.delBatchNoValidation(), true);
	   }

}
