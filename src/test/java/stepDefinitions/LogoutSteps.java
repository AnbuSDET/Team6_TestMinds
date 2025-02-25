package stepDefinitions;

import commonUtilities.Constants;
import commonUtilities.Context;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.ClassPage;
import pageObjects.LogoutPage;

public class LogoutSteps extends Constants {
	Context context;
	LogoutPage logoutPage;

	public LogoutSteps(Context context) {
		this.context = context;
		logoutPage = context.getLogoutPage();
	}
	@When("Admin clicks on the logout in the menu bar")
	public void admin_clicks_on_the_logout_in_the_menu_bar() {
	    // Write code here that turns the phrase above into concrete actions
		logoutPage.clkLogoutBtn();
	}

	@Then("Admin should be redirected to login page")
	public void admin_should_be_redirected_to_login_page() {
	    // Write code here that turns the phrase above into concrete actions
		logoutPage.loginScrn();
	}

	@When("Admin clicks  browser back button")
	public void admin_clicks_browser_back_button() {
	    // Write code here that turns the phrase above into concrete actions
	   logoutPage.navigateback();
	}

	@Then("Admin should receive error message")
	public void admin_should_receive_error_message() {
	    // Write code here that turns the phrase above into concrete actions
		logoutPage.loginScrn();
	}
}
