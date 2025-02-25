package pageObjects;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import commonUtilities.Constants;
import commonUtilities.Utility_Methods;
import org.openqa.selenium.TakesScreenshot;

public class DashboardPage extends Constants {
	WebDriver driver;
	WebDriverWait wait;
	Utility_Methods util;

	@FindBy(xpath = "//span[normalize-space()='LMS - Learning Management System']")
	private WebElement lmsTitle;

	@FindBy(xpath = "//mat-toolbar[@class='mat-toolbar mat-primary mat-toolbar-single-row ng-star-inserted']")
	private WebElement navigationBar;

	@FindBy(xpath = "//mat-toolbar//button")
	private List<WebElement> navigationBarList;

	@FindBy(xpath = "(//div[@class='chartjs-size-monitor-expand'])[2]")
	private WebElement piechart;

	@FindBy(xpath = "//strong[contains(text(), 'Welcome')]")
	private WebElement welcome;

	@FindBy(xpath = "(//div[@class='bottom'])[1]")
	private WebElement userRole;

	@FindBy(xpath = "(//div[@class='chartjs-size-monitor-expand'])[1]")
	private WebElement barChart;

	@FindBy(xpath = "//div[@routerlink='/user']")
	private WebElement usercnt;

	@FindBy(xpath = "(//div[@class='top'])[3]")
	private WebElement staffcnt;

	@FindBy(xpath = "//div[@routerlink='/batch']")
	private WebElement batchcnt;

	@FindBy(xpath = "//div[@routerlink='/program']")
	private WebElement prgmcnt;

	@FindBy(xpath = "//tr/td[4]")
	private List<WebElement> batchActiveList;

	@FindBy(xpath = "//div[@class='mat-paginator-range-actions']")
	private WebElement paginatorIcons;

	@FindBy(xpath = "//div[@class='mat-paginator-range-label']")
	private WebElement paginatorLabel;

	@FindBy(xpath = "(//*[local-name()='svg'])[1]")
	private WebElement firstPageIcon;

	@FindBy(xpath = "(//*[local-name()='svg'])[2]")
	private WebElement prevPageIcon;
	
	@FindBy(xpath = "//mat-card[@class='mat-card mat-focus-indicator container']//mat-grid-tile[2]//figure[1]")
	private WebElement barChartContent;
	
	

	public DashboardPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		util = new Utility_Methods(driver);
	}

	public String getLearningManagementSystemTitle() {

		return lmsTitle.getText().trim();
	}

	public boolean validatePieChart() {

		return piechart.isDisplayed();
	}

	public boolean checkLMSAlignment() {

		int logoLeftX = lmsTitle.getLocation().getX();
		if (logoLeftX <= 100) {

			System.out.println("LMS Title is on the left side of the page.");
			return true;
		} else {
			System.out.println("LMS Title is not on the left side of the page.");
			return false;
		}

	}

	public void verifyNavigationBarTexts() {

		String actualText = navigationBar.getText().trim();
		List<String> expectedTexts = Arrays.asList("LMS - Learning Management System", "Home", "Program", "Batch",
				"Class", "Logout");
		List<String> actualTexts = Arrays.asList(actualText.split("\\r?\\n"));
		Assert.assertEquals(actualTexts, expectedTexts, "Navigation bar texts do not match!");
	}

	public void verifyLMSTitleSpellAndSpace() {
		String actualTitle = lmsTitle.getText().trim();
		String expectedTitle = "LMS - Learning Management System";
		String normalizedActualTitle = actualTitle.replaceAll("\\s+", " ");
		Assert.assertEquals(normalizedActualTitle, expectedTitle, "LMS title spelling or spacing is incorrect!");
	}

	public void verifyNavigationBarTopAlignment() {
		int y = navigationBar.getLocation().getY();
		Assert.assertTrue(y < 100, "Navigation bar is not positioned at the top!");
	}

	public void verifyNavigationBarOrder() {

		List<String> expectedOrder = Arrays.asList("Home", "Program", "Batch", "Class", "Logout");

		List<String> actualOrder = navigationBarList.stream().map(WebElement::getText).map(String::trim)
				.collect(Collectors.toList());

		System.out.println("Actual Navigation Order: " + actualOrder);
		Assert.assertEquals(actualOrder, expectedOrder, "Navigation bar order is incorrect!");
	}

	public void verifyNavigationBarOrder(List<String> expectedFields) {
		boolean fieldFound = false;
		for (int i = 0; i < expectedFields.size(); i++) {
			String field = expectedFields.get(i);
			for (int j = 0; j < navigationBarList.size(); j++) {
				String itemText = navigationBarList.get(j).getText().trim();
				if (itemText.equals(field)) {
					fieldFound = true;
					break;
				}
			}
			Assert.assertTrue(fieldFound, field + " not found in the navigation bar!");
		}

	}

	public boolean validateUserAndRole(String sheetName, String scenarioName) throws IOException {
		List<String> data = xlutils.getRowData(sheetName, 0, scenarioName);
		if (data.isEmpty()) {
			throw new RuntimeException("No data found for scenario: " + scenarioName);
		}

		String username = data.get(1);
		if (username.contains(welcome.getText())) {
			return welcome.isDisplayed() && userRole.isDisplayed();
		}
		return false;
	}

	public boolean validateBarChart() throws InterruptedException {

		return barChart.isDisplayed();
	}

	public void extractUserCount() throws InterruptedException {
		extractAndValidateCount(usercnt, "User");
	}

	public void extractStaffCount() throws InterruptedException {
		extractAndValidateCount(staffcnt, "Staff");
	}

	public void extractProgramCount() throws InterruptedException {
		extractAndValidateCount(prgmcnt, "Program");
	}

	public void extractBatchCount() throws InterruptedException {
		extractAndValidateCount(batchcnt, "Batch");
	}

	public void extractAndValidateCount(WebElement element, String countType) throws InterruptedException {

		util.waitForElement(element);
		Thread.sleep(3000);

		String countText = element.getText();

		Pattern pattern = Pattern.compile("\\d+");
		Matcher matcher = pattern.matcher(countText);

		if (matcher.find()) {
			int actualCount = Integer.parseInt(matcher.group());
			Assert.assertTrue(actualCount > 0,
					"Invalid " + countType + " count. Expected > 0 but found: " + actualCount);
		} else {
			Assert.fail(countType + " count extraction failed. No numeric value found.");
		}
	}

	public boolean validatepaginationIcons() {
		return paginatorIcons.isDisplayed();
	}

	public boolean validatepaginatorEntries() {
		if (paginatorLabel.getText().contains(" 1 – 5 ")) {
			return paginatorLabel.isDisplayed();
		}
		return false;
	}

	public boolean validatePreviousPageIcon() {
		return !prevPageIcon.isEnabled();
	}

	public boolean validateFirstPageIcon() {
		return !firstPageIcon.isEnabled();
	}
}
