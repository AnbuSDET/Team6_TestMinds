package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import commonUtilities.Constants;
import commonUtilities.Utility_Methods;

public class LogoutPage  extends Constants {
	public WebDriver driver;
	WebDriverWait wait;
	Utility_Methods util;

	@FindBy(xpath = "//span[text()=\"Logout\"]/..")
	WebElement logoutBtn;
	
	@FindBy(xpath = "//p[text()=\"Please login to LMS application\"]")
	WebElement loginPage;
	
	
	public LogoutPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		util = new Utility_Methods(driver);
	}

	public void clkLogoutBtn() {
		logoutBtn.click();
	}
	
	public boolean loginScrn() {
		return loginPage.isDisplayed();
	}
	
	public void navigateback() {
		driver.navigate().back();
	}
	
}
