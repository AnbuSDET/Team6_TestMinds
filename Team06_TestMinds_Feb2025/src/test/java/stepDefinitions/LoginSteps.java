package stepDefinitions;

import java.io.IOException;

import org.testng.Assert;

import commonUtilities.Constants;
import commonUtilities.Context;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LoginPage;



public class LoginSteps extends Constants{

	Context context;
	LoginPage loginPage;
	

	public LoginSteps(Context context) {
		this.context = context;
		loginPage = context.getLoginPage();
	}


	@Given("Admin is in login Page.")
	public void admin_is_in_login_page() {
	  loginPage.getloginUrl();
	}
	@When("Admin enter valid data with {string} and {string} in all fields and clicks login button")
	public void admin_enter_valid_data_with_and_in_all_fields_and_clicks_login_button(String sheetName, String scenarioName) throws IOException, InterruptedException {
	    loginPage.checkvalidlogin(sheetName, scenarioName);
	}
	@Then("Admin should land on Home page")
	public void admin_should_land_on_home_page() {
		loginPage.validateHomePage();
	}
	
	
	
	
	
}
