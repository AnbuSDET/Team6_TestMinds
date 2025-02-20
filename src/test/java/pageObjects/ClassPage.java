package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import commonUtilities.Constants;

public class ClassPage extends Constants{
	public WebDriver driver;
	WebDriverWait wait;
	@FindBy(xpath = "//span[text()='Class']")
	WebElement classLink;
	
	@FindBy(xpath = "//div[text()=' Manage Class']")
	WebElement pageTitle;
	
	@FindBy(xpath = "//span[text()=' LMS - Learning Management System ']")
	WebElement headerTitle;
	
	@FindBy(id = "filterGlobal")
	WebElement searchBar;
	
	public ClassPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void classBtnClick() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		classLink.click();
	}
	
	public boolean verifyPageTitle(String expected) {

		if (pageTitle.getText().equals(expected)) {
			return true;
		}

		return false;
	}
	
	public boolean verifyHeaderTitle(String expected) {

		if (headerTitle.getText().equals(expected)) {
			return true;
		}

		return false;
	}
	

	public boolean verifySearhBox() {
		if (searchBar.isEnabled()) {
			return true;
		}
		return false;
	}
	
	

	
	
}
