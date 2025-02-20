package pageObjects;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import commonUtilities.Constants;

public class LoginPage extends Constants {

	public WebDriver driver;

	WebDriverWait wait;
	@FindBy(xpath = "//input[@id='username']")
	WebElement userName;

	@FindBy(xpath = "//input[@id='password']")
	WebElement password;

	@FindBy(xpath = "(//span[text()='Select the role'])[1]")
	WebElement selectRole;

	@FindBy(xpath = "(//mat-option[@role='option'])[1]")
	WebElement adminRole;

	@FindBy(xpath = "//button[@id='login']")
	WebElement login;

	@FindBy(xpath = "//button[@id='dashboard']")
	WebElement homeBtn;

	@FindBy(xpath = "//div[text()=' Dashboard']")
	WebElement dashboardTitle;

	@FindBy(id = "logout")
	WebElement logout;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void getloginUrl() {
		System.out.println("============baseURL================ " + Constants.baseURL);
		driver.get(baseURL);
	}

	public void checkvalidlogin(String sheetName, String scenarioName) throws IOException, InterruptedException {
		List<String> data = xlutils.getRowData(sheetName, 0, scenarioName);

		if (data.isEmpty()) {
			throw new RuntimeException("No data found for scenario: " + scenarioName);
		}

		String username = data.get(1);
		String pass = data.get(2);

		System.out.println("==================Username===== " + userName);
		System.out.println("==================Password===== " + pass);

		userName.sendKeys(username);
		password.sendKeys(pass);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		selectRole.click();
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		adminRole.click();
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		login.click();

	}

	public boolean validateHomePage() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		return homeBtn.isDisplayed() && dashboardTitle.isDisplayed() && logout.isDisplayed();
	}

}
