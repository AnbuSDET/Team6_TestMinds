package pageObjects;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import commonUtilities.Constants;
import commonUtilities.Utility_Methods;

public class ClassPage extends Constants {
	public WebDriver driver;
	WebDriverWait wait;
	Utility_Methods util;

	@FindBy(xpath = "//span[text()='Class']/..")
	WebElement classLink;

	@FindBy(xpath = " //div[text()=\" Manage Class\"]")
	WebElement manageClass;

	@FindBy(xpath = "//div[text()=' Manage Class']")
	WebElement pageTitle;

	@FindBy(xpath = "//span[text()=' LMS - Learning Management System ']")
	WebElement headerTitle;

	@FindBy(id = "filterGlobal")
	WebElement searchBar;

	@FindBy(xpath = "//th[@psortablecolumn=\"classTopic\"]")
	WebElement columnHeaderClassTopic;

	@FindBy(xpath = "//th[@psortablecolumn=\"batchName\"]")
	WebElement columnHeaderBatchName;

	@FindBy(xpath = "//span[contains(text(),'Showing')]")
	WebElement pageFooter;

	@FindBy(xpath = "//p-sorticon[@field = \"batchName\"]")
	WebElement batchSortIcon;

	@FindBy(xpath = "//div[@class=\"box\"]//button[@icon=\"pi pi-trash\"]")
	WebElement trashIcon;

	@FindBy(xpath = "//button[@role=\"menuitem\"]")
	WebElement addNewClass;

	@FindBy(xpath = "//button[@label='Save']")
	WebElement saveBtn;

	@FindBy(xpath = "//button[@label='Cancel']")
	WebElement cancelBtn;

	@FindBy(xpath = "//button[contains(@class,'close')]")
	WebElement closeBtn;

	@FindBy(id = "classTopic")
	WebElement classTopicInputBox;

	@FindBy(id = "classDescription")
	WebElement classDescriptionInputBox;

	@FindBy(xpath = "//input[contains(@placeholder,'Batch Name')]")
	WebElement batchNameDrpDwn;

	@FindBy(xpath = "//p-dropdown[@id = \"batchName\"]/div/div[@role=\"button\"]")
	WebElement batchNameDrpDwnIcon;

	@FindBy(xpath = "//p-dropdown[@id = \"batchName\"]")
	WebElement batchNameDrpDwnBox;

//	@FindBy(xpath = "//li[@aria-label=\" + batchName + \"]")
//	WebElement selectBatchName;

	@FindBy(xpath = "//p-dropdown[@id = \"staffId\"]/div/div[@role=\"button\"]")
	WebElement staffNameDrpDownIcon;

	@FindBy(xpath = "//li[@aria-label=\"arunasel S\"]")
	WebElement selectStaffName;

	@FindBy(xpath = "//p-dropdown[@id = \"staffId\"]")
	WebElement staffNameDrpDwnBox;

	@FindBy(id = "classComments")
	WebElement classComments;

	@FindBy(id = "classNotes")
	WebElement classNotes;

	@FindBy(id = "classRecordingPath")
	WebElement classRecordingPath;

	@FindBy(xpath = "//input[@id=\"Active\"]/../following-sibling::div")
	WebElement status;

	@FindBy(xpath = "//span[@class='p-button-icon pi pi-calendar']")
	WebElement calendar;

	@FindBy(xpath = "//span[normalize-space()='25']")
	WebElement dateToSelect;

	@FindBy(xpath = "//label[@for='classNo']")
	WebElement classNumLabel;
		
	@FindBy(id = "classNo")
	WebElement classNumInputBox;

	@FindBy(xpath = "//div[contains(@class,'p-toast-summary')]")
	WebElement saveSuccessMsgPop;

	@FindBy(xpath = "//input[@id='classTopic']/following-sibling::small")
	WebElement classTopicErrormsg;

	@FindBy(xpath = "//p-dropdown[@id='batchName']/following-sibling::small")
	WebElement batchNameErrormsg;

	@FindBy(xpath = "//p-calendar[@inputid='icon']/following-sibling::small")
	WebElement classDateErrormsg;

	@FindBy(xpath = "//div[contains(@class, 'p-toast-detail')]")
	WebElement alertmsg;

	@FindBy(xpath = "//div[contains(@class,'p-dialog-header')]")
	WebElement classDetailsPopUpClosed;

	public ClassPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		util = new Utility_Methods(driver);
	}

	public void openClassUrl() {

		// util.clickUsingJS(util.waitUntilClickable(classLink, 20));
		util.openSpecificPage("session");

	}

	public void classBtnClick() throws InterruptedException {
		Thread.sleep(500);
		util.clickUsingJS(util.waitUntilClickable(classLink, 20));
		// util.openSpecificPage("session");
	}

	public void clickSearchBar() {
		util.clickUsingJS(util.waitUntilClickable(searchBar, 20));
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

	public boolean verifySearchBox() {
		if (searchBar.isEnabled()) {
			return true;
		}
		return false;
	}

	public boolean columnHeaderTopic() {

		if ((columnHeaderClassTopic.getText().equals("Class Topic"))
				&& (columnHeaderBatchName.getText().equals("Batch Name"))) {
			return true;
		}
		return false;
	}

	public boolean paginationDetails() {
		if (pageFooter.isDisplayed()) {
			return true;
		}
		return false;

	}

//	public void chkPagination() {
//		String entryText = pageFooter.getText();
//
//        // Parse the number of total entries
//        String[] parts = entryText.split("of");
//        int totalEntries = Integer.parseInt(parts[1].trim());
//        if (totalEntries > 10) {
//        	if (nextButton.isEnabled()) {
//                System.out.println("Next button is enabled");
//            } else {
//                System.out.println("Next button is disabled");
//            }
//        } else {
//            System.out.println("There are 5 or fewer entries, no need to check the next button.");
//		
//	}

	public boolean batchSortIcon() {
		if (batchSortIcon.isDisplayed()) {
			return true;
		}
		return false;
	}

	public boolean trashIcon() {
		if (trashIcon.isDisplayed()) {
			return true;
		}
		return false;
	}

	public void addNewClass() {

		util.clickUsingJS(util.waitUntilClickable(addNewClass, 20));
	}

	public boolean classDetailsPopup() {

		if (saveBtn.isDisplayed() && cancelBtn.isDisplayed() && closeBtn.isEnabled()) {
			return true;
		} else
			return false;

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

	public boolean checkInputFields() {

		if (classTopicInputBox.isDisplayed() && classDescriptionInputBox.isDisplayed()
				&& batchNameDrpDwn.isDisplayed()) {
			return true;
		}
		return false;
	}

	public void addClass(String sheetName, String scenarioName) throws IOException, InterruptedException {

		List<String> data = xlutils.getRowData(sheetName, 0, scenarioName);

		String batchName = data.get(1);
		String StaffName = data.get(6);

		util.waitForElement(batchNameDrpDwnBox);
		WebElement batchNameDrpDwnIconBox = batchNameDrpDwnBox.findElement(By.xpath("./div/div[@role='button']"));
		switch (scenarioName) {
		case "validInputAll":
		case "optionalInput":

			if (batchNameDrpDwnIconBox.isDisplayed()) {
				util.clickUsingJS(util.waitUntilClickable(batchNameDrpDwnIconBox, 50));
				WebElement selectBatchName = batchNameDrpDwnBox
						.findElement(By.xpath(".//span[text()=\"" + batchName + "\"]"));
				util.clickUsingJS(util.waitUntilClickable(selectBatchName, 50));
			}
			String classTopicVal = data.get(2).isEmpty() ? "" : data.get(2) + util.random5LetterWord();

			util.webSendKeys(classTopicInputBox, classTopicVal);
			util.webSendKeys(classDescriptionInputBox, data.get(3) + util.random5LetterWord());
			selectDate();

			util.scrollIntoView(staffNameDrpDwnBox);
			util.clickUsingJS(util.waitUntilClickable(staffNameDrpDownIcon, 50));
			WebElement selectStaffName = staffNameDrpDwnBox
					.findElement(By.xpath(".//span[text()=\"" + StaffName + "\"]"));
			util.clickUsingJS(util.waitUntilClickable(selectStaffName, 50));

			util.clickUsingJS(util.waitUntilClickable(status, 50));

			util.webSendKeys(classComments, data.get(8));
			util.webSendKeys(classNotes, data.get(9));
			util.webSendKeys(classRecordingPath, data.get(10));
			clickSaveBtn();
			break;
		case "validInputMandatory":
		case "InvalidInputMandatory":

			if (batchNameDrpDwnIconBox.isDisplayed()) {
				util.clickUsingJS(util.waitUntilClickable(batchNameDrpDwnIconBox, 50));
				WebElement selectBatchName = batchNameDrpDwnBox
						.findElement(By.xpath(".//span[text()=\"" + batchName + "\"]"));
				util.clickUsingJS(util.waitUntilClickable(selectBatchName, 50));
			}

			util.webSendKeys(classTopicInputBox, data.get(2) + util.random5LetterWord());

			selectDate();
			util.scrollIntoView(staffNameDrpDwnBox);
			util.clickUsingJS(util.waitUntilClickable(staffNameDrpDownIcon, 50));
			WebElement selectStaffName1 = staffNameDrpDwnBox
					.findElement(By.xpath(".//span[text()=\"" + StaffName + "\"]"));
			util.clickUsingJS(util.waitUntilClickable(selectStaffName1, 50));

			util.clickUsingJS(util.waitUntilClickable(status, 50));
			clickSaveBtn();

			break;
		default:
			// Code to be executed if expression does not match any case
		}

	}

	public void selectDate() {
		util.clickUsingJS(util.waitUntilClickable(calendar, 50));
		util.clickUsingJS(util.waitUntilClickable(dateToSelect, 50));
		util.clickUsingJS(util.waitUntilClickable(classNumLabel, 50));
	}

	public void verifyNoOfClasses(String noOfClasses) {
		Assert.assertEquals(noOfClasses, classNumInputBox.getAttribute("ng-reflect-model"));		

	}

	public String waitForToastAndGetText() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement toast = wait.until(ExpectedConditions.visibilityOf(saveSuccessMsgPop));
		return toast.getText();
	}

	public void ValSuccessToastMsg(String expectedSuccessmsg) {
		System.out.println("ValSuccessToastMsg");
		String successMsg = waitForToastAndGetText();
		System.out.println("successMsg-->" + successMsg);
		Assert.assertTrue(successMsg.contains(expectedSuccessmsg), "The message should contain the substring");

	}

	public void validateToastMessageNotDisplayed() {
		System.out.println("Validating that the success toast message is not displayed.");

		// Get the success message from the toast
		String successMsg = waitForToastAndGetText();

		System.out.println("Success Message: " + successMsg);

		// Assert that the success message is either empty or null
		Assert.assertTrue(successMsg == null || successMsg.isEmpty(), "No success message to be displayed");
	}

	public void validateAddClass(String sheetname, String scenarioName) {
		try {
			if ((scenarioName.equals("optionalInput")) || (scenarioName.equals("InvalidInputMandatory"))) {
				util.scrollIntoView(classTopicInputBox);
				util.waitForElement(classTopicErrormsg);
				validateAddClassErrorMessage(classTopicErrormsg, "required");
			} else {
//				List<String> data = xlutils.getRowData(sheetname, 0, scenarioName);
//				if (data.isEmpty()) {
//					Assert.fail("No data found for scenario: " + scenarioName);
//				}
//				util.validateAlertMessage(alertmsg, data.get(11));
				Assert.fail("Error in getting classTopicErrormsg ");
			}
		} catch (Exception e) {
			Assert.fail("Error in getting alerts: " + e.getMessage());
		}
	}

	public void emptyFieldValidation() {

		util.waitForElement(batchNameErrormsg);
		validateAddClassErrorMessage(batchNameErrormsg, "required");
		validateAddClassErrorMessage(classTopicErrormsg, "required");
		validateAddClassErrorMessage(classDateErrormsg, "required");
	}

	public void validateAddClassErrorMessage(WebElement element, String expectedText) {
		util.waitForElement(element);
		Assert.assertTrue(element.isDisplayed() && element.getText().contains(expectedText),
				"Expected error message containing: " + expectedText);
	}

	public boolean verifyClassDetailsPopUpClosed() {
		if (!classDetailsPopUpClosed.isDisplayed()) {
			return true;
		} else
			return false;
	}

	public void selectCalendar() {
		util.clickUsingJS(util.waitUntilClickable(calendar, 50));
	}

	public boolean isDateDisabled(String day) {

		return driver.findElement(By.xpath("//span[text()='" + day + "' and contains(@class,'p-disabled')]")) != null;
	}

	public void validateIsDateDisabled(String day) {
		Assert.assertEquals(true, isDateDisabled(day));
	}

}
