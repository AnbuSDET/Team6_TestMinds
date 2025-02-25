package stepDefinitions;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Arrays;
import java.util.List;

import org.testng.Assert;

import commonUtilities.Constants;
import commonUtilities.Context;
import commonUtilities.ExcelReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.sourceforge.tess4j.TesseractException;
import pageObjects.LoginPage;

public class LoginSteps extends Constants {

	Context context;
	LoginPage loginPage;
	String user;
	String password;
	
	
	public LoginSteps(Context context) {
		this.context = context;
		loginPage = context.getLoginPage();
	}

	@Given("Admin is in login Page.")
	public void admin_is_in_login_page() {
		loginPage.getloginUrl();
	}

	@When("Admin enter valid data with {string} and {string} in all fields and clicks login button")
	public void admin_enter_valid_data_with_and_in_all_fields_and_clicks_login_button(String sheetName,
			String scenarioName) throws IOException, InterruptedException {
		loginPage.checkvalidlogin(sheetName, scenarioName);
	}

	@Then("Admin should land on Home page")
	public void admin_should_land_on_home_page() {
		loginPage.validateHomePage();
	}
	
	// Valid Login URL
	
	@When("Admin gives the correct LMS portal URL")
	public void admin_gives_the_correct_lms_portal_url() {
		loginPage.driver.get(baseURL);
	}
	@Then("Admin should land on the login page")
	public void admin_should_land_on_the_login_page() {
	    Assert.assertEquals(loginPage.LMSportalURLValidation().contains("login"), true);
	}
	
	
	// Invalid Login URL
	
	@When("Admin gives the invalid LMS portal URL")
	public void admin_gives_the_invalid_lms_portal_url() {
		loginPage.getInvalidbaseurl();
	}
	@Then("Admin should receive application error")
	public void admin_should_receive_application_error() throws IOException {
		 Assert.assertEquals(loginPage.InvalidURLValidation(), 404);
	}
	
	// Verify for broken link
	
	@Then("HTTP response should be >= {int}, indicating the link is broken")
	public void http_response_should_be_indicating_the_link_is_broken(Integer int1) throws MalformedURLException, IOException {
		Assert.assertEquals(loginPage.BrokenLinkValidation(),1);
	}
	
	
	// Verify the text spelling in the page
	
	@Then("Admin should see correct spellings in all fields")
	public void admin_should_see_correct_spellings_in_all_fields() {	   
		Assert.assertEquals(loginPage.homePageTextValidation(), true);
	}
	
	// Verify application name
	
	@Then("Admin should see {string}")
	public void admin_should_see(String Lms) throws TesseractException, IOException {
		
		   Assert.assertEquals(loginPage.appicationNameValidation("LMS",false), true);
	}
	
	//
	
	@Then("Admin should see company name below the app name")
	public void admin_should_see_company_name_below_the_app_name() throws TesseractException, IOException {
		String ExpText="Numpy";
		Assert.assertEquals(loginPage.appicationNameValidation(ExpText,true), true);
	}
	
	
	// Verify company name
	
	@Then("Admin should see two text fields")
	public void admin_should_see_two_text_fields() {
		Assert.assertEquals(loginPage.countOfTextboxes(),2);
	}
	
	
	
	
	@Then("Admin should see {string} in the first text field")
	public void admin_should_see_in_the_first_text_field(String string) {
		user = "User";		
		Assert.assertEquals(loginPage.verifyingTextField(user), true);
		
	}
	
	//
	
	@Then("Admin should see one dropdown")
	public void admin_should_see_one_dropdown() {
	    
		
	}
	
	
	
	
	@Then("Admin should see {string} placeholder in dropdown")
	public void admin_should_see_placeholder_in_dropdown(String text) {
		Assert.assertEquals(loginPage.SelectTheRoletextValidation().contains(text), true);
	}
	
	
	
	
	@Then("Admin should see an asterisk mark symbol next to the password text")
	public void admin_should_see_an_asterisk_mark_symbol_next_to_the_password_text() {
	  
		password = "Password *";		
		Assert.assertEquals(loginPage.verifyingTextField(password), true);
	}
	
	
	//  Verify asterisk next to USER text
	
	@Then("Admin should see an asterisk mark symbol next to the text for mandatory fields")
	public void admin_should_see_an_asterisk_mark_symbol_next_to_the_text_for_mandatory_fields() {
		Assert.assertEquals(loginPage.verifyingTextField("MandatoryFields"), true);
	}
	
	
	//   Verify text on the second field	
	
	@Then("Admin should see {string} in the second text field")
	public void admin_should_see_in_the_second_text_field(String string) {
		    password = "Password";		
			Assert.assertEquals(loginPage.verifyingTextField(password), true);
	}
	
	
	@Then("Admin should see  {string} options in dropdown")
	public void admin_should_see_options_in_dropdown(String menu) throws InterruptedException {
		
		Assert.assertEquals(loginPage.DropdownTextValidation(), true);
	}
	
//
	

@Then("Admin should see {string} in gray color")
public void admin_should_see_in_gray_color(String Textname) throws InterruptedException {
	Assert.assertEquals(loginPage.textColorValidation(Textname), true);
}

// 

@Then("Admin should see the login button")
public void admin_should_see_the_login_button() {
 Assert.assertEquals(loginPage.loginBtnValidation(), true);
}
	
// Invalid Login


@When("Admin enter invalid  {string} credentials and clicks login button")
public void admin_enter_invalid_credentials_and_clicks_login_button(String scenarioName) throws IOException, InterruptedException {
	loginPage.enterUsername(xlutils.getTestData("Login", scenarioName, "username"));
	loginPage.enterPassword(xlutils.getTestData("Login", scenarioName, "password"));   
	loginPage.UserRoleSelect();
	loginPage.clickLogin();
}

@Then("Error message please {string} check Adminname\\/password")
public void error_message_please_check_adminname_password(String scenarioName) throws IOException {
	
Assert.assertEquals(loginPage.loginErrormessage().contains(xlutils.getTestData("Login", scenarioName, "ErrorMessage")), true);
	
}

// Login using Mouse

@When("Admin enter valid credentials  and clicks login button through mouse")
public void admin_enter_valid_credentials_and_clicks_login_button_through_mouse() throws IOException {
	loginPage.Action_Clicks("Mouse");
}

@Then("Admin should land on dashboard page")
public void admin_should_land_on_dashboard_page() {
	loginPage.validateHomePage();
}

 // login using Keyboard

@When("Admin enter valid credentials  and clicks login button through keyboard")
public void admin_enter_valid_credentials_and_clicks_login_button_through_keyboard() throws IOException {
	loginPage.Action_Clicks("KeyBoard");
}


}
