package pageObjects;

import java.io.IOException;
import java.time.Duration;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
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
import pojo.Lms_Pojo;

public class ProgramPage_Part2 extends Constants {
	WebDriver driver;
	WebDriverWait wait;
	Utility_Methods util;
	Lms_Pojo lms = new Lms_Pojo();

	@FindBy(xpath = "(//span[@class='mat-button-wrapper'])[2]")
	WebElement progBtn;

	@FindBy(xpath = "//button[@label='Save']")
	WebElement saveBtn;

	@FindBy(xpath = "//button[@label='Cancel']")
	WebElement cancelBtn;

	@FindBy(xpath = "//div[text()=' Manage Program']")
	WebElement programTitle;
	
	@FindBy(xpath = "//label[text()='Name']")
	WebElement programNameLabel;
	
	@FindBy(xpath = "//label[text()='Description']")
	WebElement programDescLabel;
	@FindBy(xpath = "//lable[text()='Status']")
	WebElement programStatusLabel;

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

	@FindBy(xpath = "//*[contains(text(),'Showing 0 to 0 of 0 entries')]")
	private WebElement paginationTextWithZeroRecord;

	@FindBy(xpath = "//tr/th[2]")
	private WebElement programNameColumnHeader;
	@FindBy(xpath = "//tr/th[3]")
	private WebElement programDescColumnHeader;

	@FindBy(xpath = "//tr/td[3]")
	private WebElement programDescList;
	@FindBy(xpath = "//tr/th[4]")
	private WebElement programStatuscColumnHeader;

	@FindBy(xpath = "//tr/td[4]")
	private List<WebElement>  programStatusList;

	@FindBy(xpath = "//i[@class='p-sortable-column-icon pi pi-fw pi-sort-amount-up-alt']")
	WebElement progSortDescIcon;
	
	@FindBy(xpath = "//span[text()='Program Details']")
	WebElement editProgramPopupTitle;


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
	public boolean validateProgramEditPopup() {
		try {
			return editProgramPopupTitle.isDisplayed()&& saveBtn.isDisplayed() && cancelBtn.isDisplayed();
		} catch (NoSuchElementException e) {
			return false;
		}
	}
	
	public boolean validateProgramEditTitle() {
		try {
			return editProgramPopupTitle.isDisplayed();
		} catch (NoSuchElementException e) {
			return false;
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
			util.waitForElement(alertmsg);
			String actualMsg = alertmsg.getText().replaceAll("\\s+", " ").trim();
			String expectedMsg = data.get(1).replaceAll("\\s+", " ").trim();
			lms.setProgramName(data.get(1));
			System.out.println("Program name---" + Lms_Pojo.getProgramName());
			if (actualMsg.contains(expectedMsg)) {
				lms.setProgramName(data.get(1));
			}
			// util.validateAlertMessage(alertmsg, data.get(4));
		} catch (Exception e) {
			Assert.fail("Error in getting alerts: " + e.getMessage());
		}
	}
	
	public boolean validateAsterisk(String asterisk, String field) {
		By asterisk_path = By.xpath("(//span[text()='*'])");
		String expectedColor = "rgba(255, 0, 0, 1)";
		WebElement field_path;

		try {
			for (int i = 1; i <= 3; i++) {
				WebElement asteriskElement = driver.findElement(By.xpath(asterisk_path + "[" + i + "]"));
				String color = asteriskElement.getCssValue("color");

				switch (field) {
				case "Program name":
					field_path = programNameLabel;
					break;
				case "Description":
					field_path = programDescLabel;
					break;
				case "Status":
					field_path = programStatusLabel;
					break;
				default:
					Assert.fail("Field not recognized: " + field);
					return false;
				}
				if (field_path.getText().equals(field) && asteriskElement.isDisplayed()) {
					if (color.equals(expectedColor)) {
						return true;
					} else {
						Assert.fail("Asterisk validation failed");
					}
				}
			}
		} catch (Exception e) {
			return false; // Return false if an exception occurs
		}

		return false; // Return false if no conditions were met
	}
	public boolean isProgramDetailsPopupDisappears() {
		try {
			util.waitForElement(editProgramPopupTitle);
			boolean isInvisible = wait.until(ExpectedConditions.invisibilityOf(editProgramPopupTitle));
			return isInvisible;
		} catch (Exception e) {
			return false;
		}
	}

	// Add Program

	public void enterValidProgramDetails(String sheetName, String scenarioName) throws IOException {
		List<String> data = xlutils.getRowData(sheetName, 0, scenarioName);

		String programNameText = data.get(1);
		String descriptionText = data.get(2);
		progNameTextBox.sendKeys(programNameText);
		progDescTextBox.sendKeys(descriptionText);
		util.waitForElement(activeBtn);
		activeBtn.click();
		// util.clickUsingJS(util.waitUntilClickable(activeBtn, 50));

		clickSaveBtn();
	}

	// search program

	public void searchProgram(String sheetName, String scenarioName) throws IOException, InterruptedException {
		List<String> rowData = xlutils.getRowData(sheetName, 0, scenarioName);
		String programName = rowData.get(1);
		String programDesc = rowData.get(2);
		String status = rowData.get(3);

		if (scenarioName.equalsIgnoreCase("Searching the added program using program name")) {
			performSearch(programName);
			validateSearchResults(programName, programDesc, status);
		} else if (scenarioName.equalsIgnoreCase("Searching the added program using program description")) {
			performSearch(programDesc);
			validateSearchResults(programName, programDesc, status);
		} else if (scenarioName.equalsIgnoreCase("Searching the added program using partial program name")) {
			performSearch(programName);
			validateSearchResults(programName, programDesc, status);
		} else if (scenarioName.equalsIgnoreCase("Searching the added program using invalid program name")) {
			performSearch(programName);
			Assert.assertTrue(paginationTextWithZeroRecord.getText().contains("0"));

		} else {
			Assert.fail("Invalid search scenario: " + scenarioName);
		}
	}

	private void performSearch(String searchQuery) {
		searchTextBox.sendKeys(searchQuery);
		searchTextBox.sendKeys(Keys.ENTER);
		util.waitForElement(firstrowNameField);
	}

	private void validateSearchResults(String expectedName, String expectedDesc, String expectedStatus) {
		util.waitForElement(firstrowNameField);
		util.waitForElement(firstrowDescField);
		util.waitForElement(firstrowStatusField);

		Assert.assertTrue(expectedName.trim().contains(firstrowNameField.getText().trim()));
		Assert.assertTrue(expectedDesc.equalsIgnoreCase(firstrowDescField.getText().trim()));
		Assert.assertTrue(expectedStatus.equalsIgnoreCase(firstrowStatusField.getText().trim()));
	}

	// sorting

	public void clickProgramNameColumnHeader() {
		util.waitForElement(programNameColumnHeader);
		util.clickUsingJS(util.waitUntilClickable(programNameColumnHeader, 50));
	}

	public List<String> getSortedProgramNameListAsc() {

		// sort on the original list ->sorted list in Ascending order
		List<String> sortedlList = getOriginalProgramNameList().stream().sorted().collect(Collectors.toList());
		System.out.println("sortedlList " + sortedlList);

		return sortedlList;

	}

	public List<String> getOriginalProgramNameList() {
		// capture all the web elements into list

		// capture text of all elements into new(original) list
		List<String> originalList = progNameList.stream().map(s -> s.getText().toLowerCase().trim())
				.collect(Collectors.toList());
		System.out.println("originalList " + originalList);

		return originalList;
	}

	public void clickProgDescSortIcon() {
		util.clickSortIcon(progSortDescIcon);
	}

	public List<String> getSortedProgramNameListDesc() {

		List<String> sortedlListdesc = getOriginalProgramNameList().stream().sorted(Comparator.reverseOrder())
				.collect(Collectors.toList());
		System.out.println("sortedlList desc " + sortedlListdesc);

		return sortedlListdesc;
	}

	public void clickProgramDescColumnHeader() {
		util.waitForElement(programDescColumnHeader);
		util.clickUsingJS(util.waitUntilClickable(programDescColumnHeader, 50));

	}

	public List<String> getOriginalProgramDescList() {

		// capture text of all elements into new(original) list
		List<String> originalProgramDescriptionList = progDescList.stream().map(s -> s.getText().toLowerCase().trim())
				.collect(Collectors.toList());
		System.out.println("originalProgramDescList " + originalProgramDescriptionList);
		return originalProgramDescriptionList;
	}

	public List<String> getSortedProgramDescriptionListAsc() {

		// sort on the original list ->sorted list in Ascending order
		List<String> desiredlList = getOriginalProgramDescList();
		// Sort the list
		Collections.sort(desiredlList);

		System.out.println("getSortedProgramDescriptionListAsc " + desiredlList);

		return desiredlList;

	}

	public List<String> getSortedProgramDescriptionListDesc() {

		// sort on the original list ->sorted list in Descending order
		List<String> sortedlListdesc = getOriginalProgramDescList().stream().sorted(Comparator.reverseOrder())
				.collect(Collectors.toList());
		System.out.println("getSortedProgramDescriptionListDesc sortedlList desc " + sortedlListdesc);

		return sortedlListdesc;

	}
	
	public void clickProgramStatusColumnHeader() {
		util.waitForElement(programStatuscColumnHeader);
		util.clickUsingJS(util.waitUntilClickable(programStatuscColumnHeader, 50));
		
	}
	
	public List<String> getSortedProgramStatusListAsc() {
		
		  //sort on the original list->sorted list in Ascending order
		  List<String> desiredlList = getOriginalProgramStatusList();
	        // Sort the list
	        Collections.sort(desiredlList);
	        
	        System.out.println("getSortedProgramStatusListAsc "+desiredlList);  

		  return desiredlList;

	}

	public List<String> getSortedProgramStatusListDesc() {
		
		  //sort on the original list->sorted list in Descending order
		  List<String> sortedlListdesc = getOriginalProgramStatusList().stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
		  System.out.println("getSortedProgramDescriptionListDesc sortedlList desc "+sortedlListdesc);

		  return sortedlListdesc;

	}
	public List<String> getOriginalProgramStatusList() {
		  
		  
		  //capture text of all elements into new(original) list
		  List<String> originalProgramStatusList = programStatusList.stream().map(s->s.getText().toLowerCase().trim()).collect(Collectors.toList());
		  System.out.println("originalProgramStatusList "+originalProgramStatusList);
		  return originalProgramStatusList;
	}
}
