package pageObjects;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import commonUtilities.Constants;
import commonUtilities.Utility_Methods;

public class ProgramPage_Part2 extends Constants {
	WebDriver driver;
	WebDriverWait wait;
	Utility_Methods util;

	@FindBy(xpath = "(//span[@class='mat-button-wrapper'])[2]")
	WebElement progBtn;

	@FindBy(xpath = "//button[@label='Save']")
	WebElement saveBtn;

	@FindBy(xpath = "//button[@label='Cancel']")
	WebElement cancelBtn;

	@FindBy(xpath = "//div[text()=' Manage Program']")
	WebElement programTitle;

	@FindBy(xpath = "(//span[@class='p-button-icon pi pi-pencil'])[1]")
	WebElement progEditBtnFirst;

	@FindBy(xpath = "//input[@id='programName']")
	WebElement progNameTextBox;

	@FindBy(xpath = "//input[@id='programDescription']")
	WebElement progDescTextBox;

	@FindBy(xpath = "(//p-radiobutton[@name='category'])[1]")
	WebElement activeBtn;

	@FindBy(xpath = "(//p-radiobutton[@name='category'])[2]")
	WebElement inactiveBtn;

	@FindBy(xpath = "//div[text()=' Inactive ']")
	WebElement inactiveText;

	@FindBy(xpath = "//div[contains(@class, 'p-toast-detail')]")
	WebElement alertmsg;

	@FindBy(xpath = "//button[text()='Add New Program']")
	WebElement addNewProgramBtn;

	@FindBy(id = "filterGlobal")
	private WebElement searchTextBox;
	
	@FindBy(xpath = "//tr[1]/td[2]")
	private WebElement firstrowNameField;
	
	@FindBy(xpath = "//tr[1]/td[3]")
	private WebElement firstrowDescField;
	
	@FindBy(xpath = "//tr[1]/td[4]")
	private WebElement firstrowStatusField;

	@FindBy(xpath = "//tr/td[2]")
	private List<WebElement> progNameList;

	@FindBy(xpath = "//tr/td[3]")
	private List<WebElement> progDescList;

	@FindBy(xpath = "//button[@class='p-paginator-next p-paginator-element p-link p-ripple']")
	private WebElement nextBtn;
	
	@FindBy(xpath="//*[contains(text(),'Showing 0 to 0 of 0 entries')]")
	private WebElement paginationTextWithZeroRecord;

	public ProgramPage_Part2(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		util = new Utility_Methods(driver);
	}

	public boolean validateProgramTitle() {
		util.waitForElement(progBtn);
		progBtn.click();
		return programTitle.isDisplayed();
	}

	public void clickProgramEditBtn() {
		if (progEditBtnFirst.isDisplayed()) {
			util.clickUsingJS(util.waitUntilClickable(progEditBtnFirst, 50));
		} else {
			Assert.fail("Unable to find edit button");
		}
	}

	public void clickProgramAddBtn() {
		if (progBtn.isDisplayed()) {
			util.clickUsingJS(util.waitUntilClickable(progBtn, 50));
			util.clickUsingJS(util.waitUntilClickable(addNewProgramBtn, 50));
		} else {
			Assert.fail("Unable to find edit button");
		}
	}

	public void clickSaveBtn() {
		if (saveBtn.isDisplayed()) {
			util.clickUsingJS(util.waitUntilClickable(saveBtn, 50));
		} else {
			Assert.fail("Save Button is not displayed");
		}
	}

	public void clickCancelBtn() {
		if (cancelBtn.isDisplayed()) {
			util.clickUsingJS(util.waitUntilClickable(cancelBtn, 50));
		} else {
			Assert.fail("Cancel Button is not displayed");
		}
	}

	public void editProgramName(String sheetName, String scenarioName) throws IOException {
		List<String> data = xlutils.getRowData(sheetName, 0, scenarioName);

		switch (scenarioName.toLowerCase()) {
		case "edit program with program name":
			editProgramTextField(progNameTextBox, data.get(1));
			break;

		case "edit program with program description":
			editProgramTextField(progDescTextBox, data.get(2));
			break;

		case "edit program with program status":
			editProgramStatus(data.get(3));
			break;

		default:
			Assert.fail("Invalid scenario: " + scenarioName);
		}
	}

	private void editProgramTextField(WebElement textBox, String newValue) {
		if (textBox.isDisplayed()) {
			util.waitForElement(textBox);
			textBox.clear();
			textBox.sendKeys(newValue);
			clickSaveBtn();
		}
	}

	private void editProgramStatus(String expectedStatus) {
		if (inactiveBtn.isDisplayed()) {
			util.waitForElement(inactiveBtn);
			util.clickUsingJS(util.waitUntilClickable(inactiveBtn, 50));

			if (inactiveText.getText().equals(expectedStatus)) {
				clickSaveBtn();
			}
		}
	}

	public void validateProgram(String sheetname, String scenarioName) {
		try {
			List<String> data = xlutils.getRowData(sheetname, 0, scenarioName);
			if (data.isEmpty()) {
				Assert.fail("No data found for scenario: " + scenarioName);
			}
			util.validateAlertMessage(alertmsg, data.get(4));
		} catch (Exception e) {
			Assert.fail("Error in getting alerts: " + e.getMessage());
		}
	}

	// Add Program

	public void enterValidProgramDetails(String sheetName, String scenarioName) throws IOException {
		List<String> data = xlutils.getRowData(sheetName, 0, scenarioName);

		String programNameText = data.get(1);
		String descriptionText = data.get(2);
		progNameTextBox.sendKeys(programNameText);
		progDescTextBox.sendKeys(descriptionText);

		util.clickUsingJS(util.waitUntilClickable(activeBtn, 50));

		clickSaveBtn();
	}

	// search program

//	public void searchProgram(String sheetname,String scenarioName) throws IOException, InterruptedException {
//
//		
//        List<String> rowData = xlutils.getRowData(sheetname, 0, scenarioName);
//        String programName = rowData.get(1);
//		String programDesc = rowData.get(2);
//		String status = rowData.get(3);
//		
//		
//		if(scenarioName.equalsIgnoreCase("searchWithValidProgramName")) {
//			util.clickUsingJS(util.waitUntilClickable(searchTextBox, 50));
//			searchTextBox.sendKeys(programName);
//			searchTextBox.sendKeys(Keys.ENTER);
//		   util.waitForElement(firstrowNameField);
//
//			Assert.assertTrue(programName.equalsIgnoreCase(firstrowNameField.getText().trim()));
//			Assert.assertTrue(programDesc.equalsIgnoreCase(firstrowDescField.getText().trim()));
//			Assert.assertTrue(status.equalsIgnoreCase(firstrowStatusField.getText().trim()));
//		}
//		else if(scenarioName.equalsIgnoreCase("searchWithValidProgramDesc")) {
//			searchTextBox.sendKeys(programDesc);
//			searchTextBox.sendKeys(Keys.ENTER);
//			util.waitForElement(firstrowNameField);
//
//			Assert.assertTrue(programName.equalsIgnoreCase(firstrowNameField.getText().trim()));
//			Assert.assertTrue(programDesc.equalsIgnoreCase(firstrowDescField.getText().trim()));
//			Assert.assertTrue(status.equalsIgnoreCase(firstrowStatusField.getText().trim()));
//		}
//		else if(scenarioName.equalsIgnoreCase("searchWithInvalidProgramName")) {
//			searchTextBox.sendKeys(programName);
//			searchTextBox.sendKeys(Keys.ENTER);
//			
//			Assert.assertTrue(paginationTextWithZeroRecord.getText().trim().contains("Showing 0 to 0 of 0 entries"));
//		}
//		else if(scenarioName.equalsIgnoreCase("searchWithPartialProgramName")) {
//			searchTextBox.sendKeys(programDesc);
//			searchTextBox.sendKeys(Keys.ENTER);
//			util.waitForElement(firstrowNameField);
//			
//			Assert.assertTrue(programName.equalsIgnoreCase(firstrowNameField.getText().trim()));
//			Assert.assertTrue(programDesc.equalsIgnoreCase(firstrowDescField.getText().trim()));
//			Assert.assertTrue(status.equalsIgnoreCase(firstrowStatusField.getText().trim()));
//
//		}
//	}
	
	public void searchProgram(String sheetName, String scenarioName) throws IOException, InterruptedException {
	    List<String> rowData = xlutils.getRowData(sheetName, 0, scenarioName);
	    String programName = rowData.get(1);
	    String programDesc = rowData.get(2);
	    String status = rowData.get(3);

	    if (scenarioName.equalsIgnoreCase("Searching the added program using program name")) {
	        performSearch(programName);
	        validateSearchResults(programName, programDesc, status);
	    } 
	    else if (scenarioName.equalsIgnoreCase("Searching the added program using program description")) {
	        performSearch(programDesc);
	        validateSearchResults(programName, programDesc, status);
	    } 
	    else if (scenarioName.equalsIgnoreCase("Searching the added program using partial program name")) {
	        performSearch(programDesc);
	        validateSearchResults(programName, programDesc, status);
	    } 
	    else if (scenarioName.equalsIgnoreCase("Searching the added program using invalid program name")) {
	    	 performSearch(programName);
			Assert.assertTrue(paginationTextWithZeroRecord.getText().trim().contains("Showing 0 to 0 of 0 entries"));
		
	    } 
	    else {
	        Assert.fail("Invalid search scenario: " + scenarioName);
	    }
	}

	
	private void performSearch(String searchQuery) {
	    searchTextBox.sendKeys(searchQuery);
	    searchTextBox.sendKeys(Keys.ENTER);
	    util.waitForElement(firstrowNameField);
	}

	private void validateSearchResults(String expectedName, String expectedDesc, String expectedStatus) {
	    Assert.assertTrue(expectedName.equalsIgnoreCase(firstrowNameField.getText().trim()));
	    Assert.assertTrue(expectedDesc.equalsIgnoreCase(firstrowDescField.getText().trim()));
	    Assert.assertTrue(expectedStatus.equalsIgnoreCase(firstrowStatusField.getText().trim()));
	}


}
