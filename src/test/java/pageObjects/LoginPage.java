package pageObjects;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.FileHandler;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.nio.file.Files;
import commonUtilities.Constants;
import commonUtilities.Utility_Methods;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class LoginPage extends Constants {

	public WebDriver driver;
	Utility_Methods util;
	WebDriverWait wait;
	WebDriverWait webDriverWait;

	JavascriptExecutor js;

	Actions actions;

	@FindBy(xpath = "//input[@id='username']")
	WebElement userName;

	@FindBy(xpath = "//input[@id='password']")
	WebElement password;

	@FindBy(xpath = "(//span[text()='Select the role'])[1]")
	WebElement selectRole;

	@FindBy(xpath = "(//mat-option[@role='option'])[1]")
	WebElement adminRole;

	@FindBy(xpath = "(//mat-option[@role='option'])")
	List<WebElement> DropdownText;

	@FindBy(xpath = "//button[@id='login']")
	WebElement login;

	@FindBy(xpath = "//button[@id='dashboard']")
	WebElement homeBtn;

	@FindBy(xpath = "//input[@id='username' or @id='password']")
	List<WebElement> textBoxesList;

	@FindBy(xpath = "//div[text()=' Dashboard']")
	WebElement dashboardTitle;

	@FindBy(id = "logout")
	WebElement logout;

	@FindBy(xpath = "//*[contains(text(),'User')]")
	WebElement userText;

	@FindBy(xpath = "//*[contains(text(),'Password')]")
	WebElement passwordText;

	@FindBy(css = ".mat-error")
	WebElement errorMessage;

	@FindBy(id = "program")
	WebElement ProgramBtn;

	@FindBy(xpath = "//div[@id='mat-select-value-1']")
	WebElement SelectRoleText;

	@FindBy(xpath = "//mat-error[text()=' Please enter your password ']")
	WebElement passwordErrMesg;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		js = (JavascriptExecutor) driver;
		util = new Utility_Methods(driver);
		actions = new Actions(driver);
		webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(20));

	}

	public void getloginUrl() {

		driver.get(baseURL);
	}

	public void checkvalidlogin(String sheetName, String scenarioName) throws IOException, InterruptedException {
		List<String> data = xlutils.getRowData(sheetName, 0, scenarioName);

		if (data.isEmpty()) {
			throw new RuntimeException("No data found for scenario: " + scenarioName);
		}

		String username = data.get(1);
		String pass = data.get(2);

		userName.sendKeys(username);
		password.sendKeys(pass);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		selectRole.click();
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		adminRole.click();
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		login.click();

	}

	public void login_usingKeyBoardAction() throws IOException {

		List<String> data = xlutils.getRowData("Login", 0, "Login with valid credentials");

		String username = data.get(1);
		String pass = data.get(2);

		if (data.isEmpty()) {
			throw new RuntimeException("No data found for scenario: " + "Login with valid credentials");
		}

		actions.sendKeys(Keys.TAB).sendKeys(username).perform();
		actions.sendKeys(Keys.TAB).sendKeys(pass).perform();
		actions.sendKeys(Keys.TAB).perform();
		actions.sendKeys(Keys.ARROW_DOWN).perform();
		actions.sendKeys(Keys.TAB).sendKeys(Keys.ENTER).build().perform();
	}

	public void Action_Clicks(String ActionName) throws IOException
	{
		
		List<String> data = xlutils.getRowData("Login", 0, "Login with valid credentials");

		String username = data.get(1);
		String pass = data.get(2);
		
		if (data.isEmpty()) {
			throw new RuntimeException("No data found for scenario: " + "Login with valid credentials");
		}
		System.out.println("ActionName::"+ActionName);
   switch (ActionName) {
   		
	    case "KeyBoard": 
	    	System.out.println("KeyBoard action");
	    	actions.sendKeys(Keys.TAB).sendKeys(username).perform();	
		    actions.sendKeys(Keys.TAB).sendKeys(pass).perform(); 
		    actions.sendKeys(Keys.TAB).perform();
		    actions.sendKeys(Keys.ARROW_DOWN).perform();		    
	    	actions.sendKeys(Keys.TAB).sendKeys(Keys.ENTER).build().perform();	
	    	break;
	    	
	    case "Mouse": 
	    	System.out.println("Mouse action");
	    	wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	    	actions.moveToElement(userName)            
            .sendKeys(username) 
            .moveToElement(password)            
            .sendKeys(pass)             
            .moveToElement(selectRole)
            .click()
            .moveToElement(adminRole)
            .click()
            .moveToElement(login)
            .click()
            .build()
            .perform();
	    	System.out.println("Finishing Mouse action");
		break;
		
		default:
	           break;
		
   }
	}
		


	public void clickLogin() {
		util.waitForElement(login);
	}

	public boolean validateHomePage() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		return homeBtn.isDisplayed() && dashboardTitle.isDisplayed() && logout.isDisplayed();
	}

	public String DashboardValidation() {
		util.waitForElement(ProgramBtn);
		String title2 = driver.getCurrentUrl();
		return title2;
	}

	public String LMSportalURLValidation() {
		util.waitForElement(login);
		String title2 = driver.getCurrentUrl();
		return title2;
	}

	public void enterUsername(String Name) {

		userName.sendKeys(Name);

	}

	public void UserRoleSelect() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		selectRole.click();
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		adminRole.click();
	}

	public void enterPassword(String passWord) {
		password.sendKeys(passWord);
	}

	public void getInvalidbaseurl() {
		driver.get(configProp.getString("InvalidBaseURL"));
	}

	public int InvalidURLValidation() throws IOException {

		URL url = new URL(configProp.getString("InvalidBaseURL"));
		HttpURLConnection huc = (HttpURLConnection) url.openConnection();
		huc.setRequestMethod("GET");
		huc.connect();
		int responseCode = huc.getResponseCode();
		return responseCode;
	}

	public int BrokenLinkValidation() throws MalformedURLException, IOException {
		int i = 0;
		int Rescode = -1;
		List<WebElement> links = driver.findElements(By.tagName("link"));

		for (WebElement link : links) {
			String url = link.getAttribute("href");

			if (url == null || url.isEmpty()) {
				continue;
			}

			HttpURLConnection huc = (HttpURLConnection) (new URL(url).openConnection());
			huc.connect();

			Rescode = huc.getResponseCode();

			if (Rescode >= 400) {
				i++;
				System.out.println("Broken Links " + i);
			} else {
			}

		}
		return i;
	}

	public Boolean homePageTextValidation() {
		util.waitForElement(login);
		String Alltexts = driver.findElement(By.cssSelector("body")).getText();
		System.out.println(Alltexts);
		List<String> stringsToValidate = Arrays.asList("User *", "Password *", "Please login to LMS application",
				"Login", "Select the role");
		for (String expectedText : stringsToValidate) {
			if (!Alltexts.toLowerCase().contains(expectedText.toLowerCase())) {

				return false;
			}
		}

		return true;
	}

	public boolean appicationNameValidation(String ExpText, boolean order) throws TesseractException, IOException {

		util.waitForElement(login);

		// Take a screenshot of the image
		File imageFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File tempFile = new File("temp_image.png");
		Files.copy(imageFile.toPath(), tempFile.toPath());

		// Initialize Tesseract

		Tesseract tesseract = new Tesseract();
		tesseract.setDatapath("C://Program Files//Tesseract-OCR//tessdata");
		tesseract.setLanguage("eng");

		// Extract text from the image
		String extractedText = tesseract.doOCR(tempFile);
		if (order) {
			int LMSIndex = extractedText.indexOf("LMS");
			int NumpytIndex = extractedText.indexOf("Numpy");

			if (ExpText.contains("LMS") && LMSIndex < NumpytIndex) {

				return true;
			} else if (ExpText.contains("Numpy") && NumpytIndex > LMSIndex) {
				System.out.println("Numpy is after LMS");
				return true;
			}

		} else {
			if (extractedText.contains(ExpText))
				return true;
			else
				return false;
		}
		return false;
	}

	public int countOfTextboxes() {
		int txtBoxCount = textBoxesList.size();
		return txtBoxCount;
	}

	public Boolean verifyingTextField(String text) {

		util.waitForElement(login);

		List<WebElement> textBoxesList = driver.findElements(By.xpath("//form//mat-form-field"));
		switch (text) {

		case "User":

			if (textBoxesList.get(0).getText().contains(text)) {
				System.out.println(textBoxesList.get(0).getText());
				return true;
			}
			break;

		case "Password":
			if (textBoxesList.get(1).getText().contains(text)) {
				System.out.println(textBoxesList.get(1).getText());
				return true;
			}
			break;

		case "User *":
			if (textBoxesList.get(0).getText().equalsIgnoreCase(text)) {
				return true;
			}
			break;

		case "Password *":

			if (textBoxesList.get(1).getText().equalsIgnoreCase(text)) {
				return true;
			}
			break;

		case "MandatoryFields":
			if (textBoxesList.get(1).getText().equalsIgnoreCase("Password *")
					& textBoxesList.get(0).getText().equalsIgnoreCase("User *")) {
				return true;
			}
			break;
		default:
			System.out.println("Invalid text input.");

		}
		return false;
	}

	public boolean SelectRoleDisplayed() {

		return true;
	}

	public String SelectTheRoletextValidation() {
		String selectTheroleTxt = selectRole.getText();
		return selectTheroleTxt;
	}

	public Boolean DropdownTextValidation() throws InterruptedException {
		util.webElement_Click(selectRole);
		Thread.sleep(1000);
		String AllTexts = driver.findElement(By.xpath("//div[@role='listbox']")).getText();
		List<String> stringsToValidate = Arrays.asList("Staff", "Admin", "Student");
		for (String expectedText : stringsToValidate) {
			if (!AllTexts.toLowerCase().contains(expectedText.toLowerCase())) {

				return false;
			}
		}

		return true;
	}

	public String DropdownText() throws InterruptedException {
		util.webElement_Click(selectRole);
		Thread.sleep(1000);

		WebElement ele = driver.findElement(By.xpath("//div[@role='listbox']"));
		String Text = ele.getText();
		System.out.println(Text);
		return Text;

	}

	public boolean textColorValidation(String Text) throws InterruptedException {
		util.waitForElement(userText);
		Thread.sleep(1000);
		String expectedColor = "rgba(0, 0, 0, 0.54)";

		switch (Text) {
		case "User":
			String textColor = userText.getCssValue("color");
			System.out.println("textColor" + textColor);
			if (textColor.equalsIgnoreCase(expectedColor))
				return true;
			break;

		case "Password":
			String PasstextColor = passwordText.getCssValue("color");
			System.out.println("PasstextColor" + PasstextColor);
			if (PasstextColor.equalsIgnoreCase(expectedColor))
				return true;
			break;

		default:
			return false;
		}

		return false;

	}

	public boolean loginBtnValidation() {
		return login.isDisplayed();
	}

	public String loginErrormessage() {
		util.waitForElement(errorMessage);
		String message = errorMessage.getText();
		return message;
	}

}