package pageObjects;

import java.io.IOException;
import java.time.Duration;

import java.util.List;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import commonUtilities.Constants;
import commonUtilities.Utility_Methods;

public class ClassPage_Part2 extends Constants {
	WebDriver driver;
	WebDriverWait wait;
	Utility_Methods util;

	@FindBy(xpath = "(//span[@class='mat-button-wrapper'])[4]")
	WebElement classBtn;

	@FindBy(xpath = "//div[text()=' Manage Class']")
	WebElement classTitle;

	@FindBy(xpath = "(//span[@class='p-button-icon pi pi-pencil'])[1]")
	WebElement classEditBtnFirst;

	@FindBy(xpath = "//span[text()='Class Details']")
	WebElement editClassPopupTitle;

	@FindBy(id = "batchName")
	WebElement batchNameDrpdown;

	@FindBy(id = "classTopic")
	WebElement classTopic;

	@FindBy(id = "classDescription")
	WebElement classDesc;

	@FindBy(xpath = "//span[@class='p-button-icon pi pi-calendar']")
	WebElement calendar;

	@FindBy(xpath = "//input[@id='icon']")
	WebElement calendarText;

	@FindBy(xpath = "(//div[@role='button'])[2]")
	WebElement staffNameSelect;

	@FindBy(xpath = "(//li[@role='option'])[1]")
	WebElement staffNameFirst;

	@FindBy(xpath = "(//p-radiobutton[@name='category'])[1]")
	WebElement activeBtn;

	@FindBy(xpath = "(//p-radiobutton[@name='category'])[2]")
	WebElement inactiveBtn;

	@FindBy(id = "classComments")
	WebElement comments;

	@FindBy(id = "classNotes")
	WebElement notes;

	@FindBy(id = "classRecordingPath")
	WebElement recording;

	@FindBy(xpath = "//button[@label='Save']")
	WebElement saveBtn;

	@FindBy(xpath = "//button[@label='Cancel']")
	WebElement cancelBtn;

	@FindBy(xpath = "//span[normalize-space()='31']")
	WebElement dateToSelect;

	@FindBy(xpath = "//label[@for='classNo']")
	WebElement classNumLabel;

	@FindBy(xpath = "//div[contains(@class, 'p-toast-detail')]")
	WebElement alertmsg;

	@FindBy(xpath = "(//small[@class='p-invalid ng-star-inserted'])[1]")
	WebElement classDateErrormsg;

	@FindBy(xpath = "(//i[@class='p-sortable-column-icon pi pi-fw pi-sort-alt'])[1]")
	WebElement batchNameSort;

	@FindBy(xpath = "(//i[@class='p-sortable-column-icon pi pi-fw pi-sort-alt'])[2]")
	WebElement classTopicSort;

	@FindBy(xpath = "(//i[@class='p-sortable-column-icon pi pi-fw pi-sort-alt'])[3]")
	WebElement classDescSort;

	@FindBy(xpath = "(//i[@class='p-sortable-column-icon pi pi-fw pi-sort-alt'])[4]")
	WebElement classStatusSort;

	@FindBy(xpath = "(//i[@class='p-sortable-column-icon pi pi-fw pi-sort-alt'])[5]")
	WebElement classDateSort;

	@FindBy(xpath = "(//i[@class='p-sortable-column-icon pi pi-fw pi-sort-alt'])[6]")
	WebElement classStaffNameSort;

	@FindBy(xpath = "//i[@class='p-sortable-column-icon pi pi-fw pi-sort-amount-up-alt']")
	WebElement classSortDescIcon;

	@FindBy(xpath = "//tr/td[2]")
	private List<WebElement> batchNameList;

	@FindBy(xpath = "//tr/td[3]")
	private List<WebElement> classTopicList;

	@FindBy(xpath = "//tr/td[4]")
	private List<WebElement> classDescList;

	@FindBy(xpath = "//tr/td[5]")
	private List<WebElement> classStatusList;

	@FindBy(xpath = "//tr/td[6]")
	private List<WebElement> classDateList;

	@FindBy(xpath = "//tr/td[7]")
	private List<WebElement> classStaffNameList;

	public ClassPage_Part2(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		util = new Utility_Methods(driver);
	}

	public boolean validateClassTitle() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		classBtn.click();
		return classTitle.isDisplayed();
	}

	public void clickClassEditBtn() {
		if (classEditBtnFirst.isDisplayed()) {
			util.clickUsingJS(util.waitUntilClickable(classEditBtnFirst, 50));
		} else {
			Assert.fail("Unable to find edit button");
		}
	}

	public boolean validateClassEditPopup() {
		try {
			return editClassPopupTitle.isDisplayed();
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public boolean validateClassEditPopupNotDisplayed() {
		try {
			return !editClassPopupTitle.isDisplayed();
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public boolean validateDisabledBatchName() {
		return batchNameDrpdown != null && !batchNameDrpdown.isEnabled();
	}

	public boolean validateDisabledClassTopic() {
		return classTopic != null && !classTopic.isEnabled();
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

	public void editClass(String sheetname, String scenarioName) throws IOException {
		List<String> data = xlutils.getRowData(sheetname, 0, scenarioName);

		try {
			if (scenarioName.equalsIgnoreCase("Edit class with invalid data")) {
				editInvalidCalendar();
			} else {
				fillClassDetails(data);
				if (scenarioName.equalsIgnoreCase("Edit class with invalid values in text fields")) {
					enterAdditionalInvalidValues(data);
				}
			}
			clickSaveBtn();
		} catch (Exception e) {
			Assert.fail("Not able to edit the class details successfully: " + e.getMessage());
		}
	}

	private void editInvalidCalendar() {
		util.waitForElement(calendarText);
		calendarText.clear();
		calendarText.sendKeys("&&@))");

	}

	private void enterCommonClassDetails(List<String> data) {
		if (classDesc.isDisplayed()) {
			util.waitForElement(classDesc);
			classDesc.clear();
			classDesc.sendKeys(data.get(1)); // Class description
		}

		util.clickUsingJS(util.waitUntilClickable(inactiveBtn, 50));

		util.webSendKeys(comments, data.get(2));
		util.webSendKeys(notes, data.get(3));
		util.webSendKeys(recording, data.get(4));
	}

	private void fillClassDetails(List<String> data) {
		enterCommonClassDetails(data);
		selectDate();
	}

	private void enterAdditionalInvalidValues(List<String> data) {
		enterCommonClassDetails(data);
		editInvalidCalendar();
	}

	private void selectDate() {
		util.clickUsingJS(util.waitUntilClickable(calendar, 50));
		util.clickUsingJS(util.waitUntilClickable(dateToSelect, 50));
		util.clickUsingJS(util.waitUntilClickable(classNumLabel, 50));
	}

	public void validateEditedClass(String sheetname, String scenarioName) {
		try {
			if (scenarioName.equals("Edit class with invalid data")
					|| scenarioName.equals("Edit class with invalid values in text fields")) {
				validateErrorMessage(classDateErrormsg, "required");
			} else {
				List<String> data = xlutils.getRowData(sheetname, 0, scenarioName);
				validateAlertMessage(alertmsg, data.get(5));
			}
		} catch (Exception e) {
			Assert.fail("Error in getting alerts: " + e.getMessage());
		}
	}

	private void validateErrorMessage(WebElement element, String expectedText) {
		wait.until(ExpectedConditions.visibilityOf(element));
		Assert.assertTrue(element.isDisplayed() && element.getText().contains(expectedText),
				"Expected error message containing: " + expectedText);
	}

	private void validateAlertMessage(WebElement element, String expectedText) {
		wait.until(ExpectedConditions.visibilityOf(element));
		String actualMsg = element.getText().replaceAll("\\s+", " ").trim();
		String expectedMsg = expectedText.replaceAll("\\s+", " ").trim();
		Assert.assertTrue(actualMsg.contains(expectedMsg), "Expected alert message containing: " + expectedMsg);
	}

	// sorting

	public void clickBatchSortIcon() {
		util.clickSortIcon(batchNameSort);

	}

	public void clickClassTopicSortIcon() {
		util.clickSortIcon(classTopicSort);
	}

	public void clickClassDescSortIcon() {
		util.clickSortIcon(classDescSort);
	}

	public void clickClassStatusSortIcon() {
		util.clickSortIcon(classStatusSort);
	}

	public void clickClassDateSortIcon() {
		util.clickSortIcon(classDateSort);
	}

	public void clickClassStaffNameSortIcon() {
		util.clickSortIcon(classStatusSort);
	}

	public void clickClassSortDescIcon() {
		util.clickSortIcon(classSortDescIcon);
	}

	public List<String> getOriginalBatchNameList() {
		// capture all the web elements into list
		List<String> originalBatchNameList = util.getOriginalList(batchNameList);
		return originalBatchNameList;
	}

	public List<String> getOriginalClassTopicList() {
		// capture all the web elements into list
		List<String> originalClassTopicList = util.getOriginalList(classTopicList);
		return originalClassTopicList;
	}

	public List<String> getOriginalClassDescList() {
		// capture all the web elements into list
		List<String> originalClassDescList = util.getOriginalList(classDescList);
		return originalClassDescList;
	}

	public List<String> getOriginalClassStatusList() {
		// capture all the web elements into list
		List<String> originalClassStatusList = util.getOriginalList(classStatusList);
		return originalClassStatusList;
	}

	public List<String> getOriginalClassDateList() {
		// capture all the web elements into list
		List<String> originalClassDateList = util.getOriginalList(classDateList);
		return originalClassDateList;
	}

	public List<String> getOriginalClassStaffNameList() {
		// capture all the web elements into list
		List<String> originalClassStaffNameList = util.getOriginalList(classStaffNameList);
		return originalClassStaffNameList;
	}

	public List<String> getSortedBatchNameListAsc() {
		List<String> sortedBatchAsc = util.getSortedList(batchNameList, true);
		return sortedBatchAsc;

	}

	public List<String> getSortedBatchNameListDesc() {

		List<String> sortedBatchDesc = util.getSortedList(batchNameList, false);
		return sortedBatchDesc;

	}

	public List<String> getSortedClassTopicListAsc() {

		// sort on the original list ->sorted list in Ascending order
		List<String> sortedClassTopicAsc = util.getSortedList(classTopicList, true);
		return sortedClassTopicAsc;

	}

	public List<String> getSortedClassTopicListDesc() {
		// sort on the original list ->sorted list in Descending order
		List<String> sortedClassTopicDesc = util.getSortedList(classTopicList, false);
		return sortedClassTopicDesc;

	}

	public List<String> getSortedClassDescListAsc() {

		// sort on the original list ->sorted list in Ascending order
		List<String> sortedClassDescAsc = util.getSortedList(classDescList, true);
		return sortedClassDescAsc;

	}

	public List<String> getSortedClassDescListDesc() {
		// sort on the original list ->sorted list in Descending order
		List<String> sortedClassDescrDesc = util.getSortedList(classDescList, false);
		return sortedClassDescrDesc;

	}

	public List<String> getSortedClassStatusListAsc() {

		// sort on the original list ->sorted list in Ascending order
		List<String> sortedClassStatusAsc = util.getSortedList(classStatusList, true);
		return sortedClassStatusAsc;

	}

	public List<String> getSortedClassStatusListDesc() {
		// sort on the original list ->sorted list in Descending order
		List<String> sortedClassStatusDesc = util.getSortedList(classStatusList, false);
		return sortedClassStatusDesc;

	}

	public List<String> getSortedClassDateListAsc() {

		// sort on the original list ->sorted list in Ascending order
		List<String> sortedClassDateAsc = util.getSortedList(classDateList, true);
		return sortedClassDateAsc;

	}

	public List<String> getSortedClassDateListDesc() {
		// sort on the original list ->sorted list in Descending order
		List<String> sortedClassDateDesc = util.getSortedList(classDateList, false);
		return sortedClassDateDesc;

	}

	public List<String> getSortedClassStaffNameListAsc() {

		// sort on the original list ->sorted list in Ascending order
		List<String> sortedClassStaffNameAsc = util.getSortedList(classStaffNameList, true);
		return sortedClassStaffNameAsc;

	}

	public List<String> getSortedClassStaffNameListDesc() {
		// sort on the original list ->sorted list in Descending order
		List<String> sortedClassStaffNameDesc = util.getSortedList(classStaffNameList, false);
		return sortedClassStaffNameDesc;

	}

}
