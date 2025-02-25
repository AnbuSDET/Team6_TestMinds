package pageObjects;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import commonUtilities.Constants;
import commonUtilities.ExcelReader;
import commonUtilities.Utility_Methods;

public class ProgramPage extends Constants{

	public WebDriver driver;
	Utility_Methods util;
     WebDriverWait wait;
     
	@FindBy(xpath = "//button[@id='program']")
	public WebElement ProgramLink;	
	
	@FindBy(xpath = "//span[normalize-space()='Logout']")
	 WebElement LogoutHeader;
	
	@FindBy(xpath = "//span[normalize-space()='LMS - Learning Management System']")
	 WebElement LmsHeading;
	
    @FindBy(xpath = "//*[@id=\"mat-menu-panel-0\"]/div/button")
	 WebElement Addnewprogram;
	
	@FindBy(xpath = "//div[normalize-space(text())='Manage Program' ]")
	public WebElement ManageProgramHeader;
	
	@FindBy (xpath = "//button[@class='p-button-danger p-button p-component p-button-icon-only']")
	public WebElement LeftDeleteBtn;
	
	@FindBy(id = "filterGlobal")
	public WebElement Searchbar;
	
	@FindBy(xpath = "//tr/th")
    List<WebElement> progcolHeaders;
	
	@FindBy(xpath = "//div[@class='p-checkbox-box']")
	WebElement Headerunchecked;
	
	
	@FindBy(xpath = "//div[@class='p-checkbox p-component']")
	List<WebElement> alluncheckedicons;
	
	@FindBy(xpath = "//table/tbody/tr//button[contains(@icon, 'pi-pencil')]") 
	List<WebElement> allEditicons;
	
	 @FindBy(xpath = "//table/tbody/tr//button[contains(@icon, 'pi-trash')]") 
   	List<WebElement> allDeleteIcons;
	   	
	@FindBy(xpath = "//i[contains(@class, 'p-sortable-column-icon')]")
	WebElement sorticons;
	
	@FindBy(xpath = "//span[@class='p-paginator-current ng-star-inserted']")
	private WebElement paginationText;

	@FindBy(xpath = "//button[@class='p-paginator-first p-paginator-element p-link p-disabled p-ripple ng-star-inserted']")
	private WebElement prevSetofPagesMove;

	@FindBy(xpath = "//button[@class='p-paginator-last p-paginator-element p-link p-ripple ng-star-inserted']")
	private WebElement nextSetofPagesMove;

	@FindBy(xpath = "//span[@class='p-paginator-icon pi pi-angle-right']")
	private WebElement nextPageMove;

	@FindBy(xpath = "//span[@class='p-paginator-icon pi pi-angle-left']")
	private WebElement prevPageMove;

	@FindBy(xpath = "//div[@class='p-d-flex p-ai-center p-jc-between ng-star-inserted']")
	 WebElement programfooter;

	//Addprogram 
	
	@FindBy(xpath = "//div[@role='dialog']")
	 WebElement popupWindow;
	
	@FindBy(xpath = "//span[text()='Program Details']")
	 WebElement programDetails;
	
	@FindBy(xpath = "//label[text()='Name']")
	 WebElement programName;

	@FindBy(xpath = "//label[text()='Description']")
	 WebElement programDesc;

	@FindBy(xpath = "//label[text()='Status']")
	 WebElement programStatus;
	 
    @FindBy(xpath = "//button[@id='saveProgram']")
	 WebElement savebtn;
    
    @FindBy(xpath = "//span[normalize-space()='Cancel']")
	 WebElement cancelbtn;

	@FindBy(xpath = "//label[@for='programName']//span[contains(text(),'*')]")
	WebElement Nameasteriskmark;
	
	@FindBy(xpath = "//small[text()='Program name is required.']")
	WebElement programerror;
	
	@FindBy(xpath = "//small[normalize-space()='Description is required.']")
	WebElement descerror;
	

	@FindBy(xpath = "//small[normalize-space()='Status is required.']")
	WebElement statuserror;  
	
    @FindBy(xpath = "//input[@id='programName']")
    WebElement progNameTxtbox;
    
    @FindBy(xpath = "//input[@id='programDescription']")
    WebElement DescTxtbox;
    
    @FindBy(xpath = "//div[@class='p-hidden-accessible']//input[@type='radio' and @id='Active']")
    WebElement Activebtn;
    
    @FindBy(xpath ="//input[contains(@id, 'Inactive') and @type='radio']")
    WebElement inActivebtn;
    
    @FindBy(xpath ="//div[contains(@class, 'p-toast-detail')]")
    WebElement sucessmsg;
    
    @FindBy(xpath ="//input[@type='text' ]")
    WebElement searchBtn;
    
    @FindBy(xpath="//button[contains(@class, 'p-dialog-header-close')]")
    WebElement closebtn;
   
	
	public ProgramPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		 util=new Utility_Methods(driver);
	    wait = new WebDriverWait(driver, Duration.ofSeconds(30)); // Initialize WebDriverWait
	  
	    
		
	}
	
	public void programBtnClick() {
		 try {
		        // Wait for the ProgramLink element to be clickable
		        wait.until(ExpectedConditions.elementToBeClickable(ProgramLink));

		        // Click the Program menu using JavaScript
		        JavascriptExecutor js = (JavascriptExecutor) driver;
		        js.executeScript("arguments[0].click();", ProgramLink);
		    } catch (Exception e) {
		        e.printStackTrace();
		        throw new RuntimeException("Failed to click the Program menu: " + e.getMessage());
		    }
	}
	public String programPageValidation() 
	
    { 
        return util.getPageCurrrentURL();

    }
 	  
 	 public String TitleValidation()
 	 
	 {
         return util.getPageTitle();
	  	   
    }
 	 
 	public boolean checklogut() {
 		
        return util.isElementDisplayed(LogoutHeader);
		 
 	 }
 	
 	public void validateAddNewProgBtn(String expectedText) {
 		
 		String actualText = util.getElementText(Addnewprogram).trim();
        Assert.assertEquals(expectedText, actualText, "Submenu text does not match");
 	}
 	
 	public void validateManageHeader(String expectedText) {
 		
 	    String actualText = ManageProgramHeader.getText().trim();
 	    Assert.assertEquals(expectedText, actualText, "Heading text does not match");
 	}
 	
 	public void clickLeftDeleteBtn() {
 		
        util.webElement_Click(LeftDeleteBtn);

    }
 	public void enterSearchText(String searchText) {
 		
        util.webSendKeys(Searchbar, searchText);
    }

    public boolean isSearchBarDisplayed() {
    	
        return util.isElementDisplayed(Searchbar);
    }
 	
    public void validateAllColHeaders(String expectedProgName, String expectedDescription, String expectedStatus,
            String expectedEditdel) {
    	

    	
    	List<String> actualColheaders = new ArrayList<>();
    	
    	for (WebElement header : progcolHeaders) {
    		
        	
            if (!header.getText().trim().isEmpty()) {
            	actualColheaders.add(header.getText());    	
            }
            
   		}
    	
    	Assert.assertTrue(actualColheaders.contains(expectedProgName), "Program Name header not found!");
    	Assert.assertTrue(actualColheaders.contains(expectedDescription), "Program Description header not found!");
    	Assert.assertTrue(actualColheaders.contains(expectedStatus), "Program Status header not found!");
    	Assert.assertTrue(actualColheaders.contains(expectedEditdel), "Program Edit/Delete header not found!");
    	
   	}
    
    public boolean validateheaderCheckBoxUnchecked() {
    	
        try {
            return !Headerunchecked.isSelected();
        } catch (Exception e) {
            return false;
        }
        
        
    }
    
    public boolean programAllrowOptions(String option) {
	    boolean flag = true; 

	    switch(option) {
	        case "Edit_Icon":
	            if (util.elementVisible_allRows(allEditicons) == flag) {
	                return true; 
	            }
	            break; 

	        case "Delete_Icon":
	            if (util.elementVisible_allRows(allDeleteIcons) == flag) {
	                return true; 
	            }
	            break; 

	        case "Check_Box":
	        	if (util.elementVisible_allRows(alluncheckedicons) == flag) {
	                return true; 
	            }
	            break;

	        default:
	           
	            break;
	    }

	    return false; 
	}
    
    public void validatePaginationTextandIcons(String text) throws InterruptedException {
    	
        Thread.sleep(1000); 
        boolean areIconsPresent = prevPageMove.isDisplayed()
                && prevSetofPagesMove.isDisplayed()
                && nextPageMove.isDisplayed()
                && nextSetofPagesMove.isDisplayed();

        try {
        	
            if (areIconsPresent) {
                String textValidation = paginationText.getText();
                Pattern pattern = Pattern.compile("\\d+");
                Matcher matcher = pattern.matcher(textValidation);
                List<Integer> numericValues = new ArrayList<>();

                while (matcher.find()) {
                    int numericValue = Integer.parseInt(matcher.group());
                    numericValues.add(numericValue);
                }

                text = String.format("Showing %d to %d of %d entries", numericValues.get(0), numericValues.get(1),
                        numericValues.get(2));
                log.info(text);
                Assert.assertEquals(text, textValidation);
            }
        } catch (Exception e) {
            log.error("Pagination Icons are not displayed: " + e);
        }
    }
    public void clickAddNewProgram() {
    	
    	try {
    		
            System.out.println("Clicking Add New Program button...");
            wait.until(ExpectedConditions.elementToBeClickable(Addnewprogram)).click();
            System.out.println("Add New Program button clicked successfully.");
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", Addnewprogram);
            
            System.out.println("Add New Program button clicked successfully.");
            // Wait for the popup to be visible
            wait.until(ExpectedConditions.visibilityOf(popupWindow));
            System.out.println("Popup window is visible.");
        } catch (Exception e) {
            System.out.println("Failed to click Add New Program button: " + e.getMessage());
            throw new RuntimeException("Failed to click Add New Program button: " + e.getMessage());
        }
    }

    
    
    public void validateFooter(String count) {
    	
        String tot_cnt = programfooter.getText();
        count = tot_cnt.replaceAll("\\D+", ""); // Extract numeric value from the text
        Integer.parseInt(count.trim()); // Convert the extracted value to an integer
        Assert.assertEquals(tot_cnt, "In total there are " + count + " programs.");
    }
    
    public boolean isPopupWindowDisplayed() {
    	
        try {
            wait = new WebDriverWait(driver, Duration.ofSeconds(30)); // 30 seconds timeout
            WebElement popupWindowElement = wait.until(ExpectedConditions.visibilityOf(popupWindow));
            return popupWindowElement.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
        
    public void validateProgramDetailsTitle(String expectedTitle) {
    	
        try {
            wait.until(ExpectedConditions.visibilityOf(programDetails));
            String actualTitle = programDetails.getText().trim();
            Assert.assertEquals(actualTitle, expectedTitle, "Program details title does not match!");
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to validate program details title: " + e.getMessage());
        }
    }
    
    public boolean isProgramDetailsPopup() {
          try {
              wait = new WebDriverWait(driver, Duration.ofSeconds(30));
              WebElement programDetailsElement = wait.until(ExpectedConditions.visibilityOf(programDetails));
              return programDetailsElement.isDisplayed();
          } catch (Exception e) {
              return false;
          }
      }
  

    public boolean isNameAsteriskMarkDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOf(Nameasteriskmark));
            return Nameasteriskmark.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
    
    
    public void clickSaveBtn() {
    	int attempts = 0;
        while (attempts < 3) { // Retry up to 3 times
            try {
            	
                System.out.println("Attempting to click Save button...");
                wait.until(ExpectedConditions.elementToBeClickable(savebtn)).click();
                System.out.println("Save button clicked successfully.");
                break; // Exit the loop if successful
            } catch (StaleElementReferenceException e) {
                // Re-locate the element if it becomes stale
                savebtn = driver.findElement(By.xpath("//button[@id='saveProgram']"));
                attempts++;
            } catch (Exception e) {
                System.out.println("Failed to click the save button: " + e.getMessage());
                throw new RuntimeException("Failed to click the save button: " + e.getMessage());
            }
        }
    }
    
    public void waitForPopupWindow() {
    	
    	try {
    		
            System.out.println("Waiting for popup window to appear...");
            wait = new WebDriverWait(driver, Duration.ofSeconds(90));
            wait.until(ExpectedConditions.visibilityOf(popupWindow));
            System.out.println("Popup window appeared.");
        } catch (TimeoutException e) {
            System.out.println("Popup window did not appear within the expected time.");
            throw new RuntimeException("Popup window did not appear: " + e.getMessage());
        }
    }

    public void clickCancelBtn() {
    	int attempts = 0;
        while (attempts < 3) { // Retry up to 3 times
        	
         try {
        	 
              WebElement cancelBtn = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[normalize-space()='Cancel']")));
                
                wait.until(ExpectedConditions.elementToBeClickable(cancelBtn)).click();
                System.out.println("Cancel button clicked successfully.");
                break; // Exit the loop if successful
            } catch (StaleElementReferenceException e) {
                attempts++;
            } catch (Exception e) {
                throw new RuntimeException("Failed to click the cancel button: " + e.getMessage());
            }
        }
    }


    public void validateEmptyFormSubmissionErrors(io.cucumber.datatable.DataTable dataTable) {
    	
        List<String> expectedErrors = dataTable.asList(String.class);
        Map<String, WebElement> errorFields = new HashMap<>();
        errorFields.put("Program name is required.", programerror);
        errorFields.put("Description is required.", descerror);
        errorFields.put("Status is required.", statuserror);

        for (String expectedError : expectedErrors) {
        	
            WebElement errorElement = errorFields.get(expectedError);
            if (errorElement != null) {
                try {
                    wait.until(ExpectedConditions.visibilityOf(errorElement));
                    String actualError = errorElement.getText().trim();
                    Assert.assertTrue(actualError.contains(expectedError), 
                        "Error message for " + expectedError + " is not as expected. Actual: " + actualError);
                } catch (Exception e) {
                    System.out.println("Error locating element for: " + expectedError);
                    e.printStackTrace();
                    Assert.fail("Error locating element for: " + expectedError);
                }
            } else {
                Assert.fail("No error element found for: " + expectedError);
            }
        }
    }    
    public boolean isProgramDetailsPopupDisappears() {
    	
        try {
            wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            boolean isInvisible = wait.until(ExpectedConditions.invisibilityOf(programDetails));
            return isInvisible;
        } catch (Exception e) {
            return false;
        }
        
        
    }
    
    public void enterProgramName(String sheetName, String scenarioName) throws IOException {
    	
        List<String> data = xlutils.getRowData(sheetName, 0, scenarioName);
        String programNameText = data.get(1);
        progNameTxtbox.sendKeys(programNameText);
    }
    
    public void validateProgramName(String sheetName, String scenarioName) throws IOException {
    	
        List<String> data = xlutils.getRowData(sheetName, 0, scenarioName);
        String expectedProgramName = data.get(1);
        String actualProgramName = progNameTxtbox.getAttribute("value");
        Assert.assertEquals(actualProgramName, expectedProgramName, "Program name does not match the expected value.");
    }

public void enterdescription(String sheetName, String scenarioName) throws IOException {
    	
        List<String> data = xlutils.getRowData(sheetName, 0, scenarioName);
        String Descriptiontxt = data.get(2);
        DescTxtbox.sendKeys(Descriptiontxt);
    }

public void validatedescription(String sheetName, String scenarioName) throws IOException {
	
    List<String> data = xlutils.getRowData(sheetName, 0, scenarioName);
    String expectedDescription = data.get(1);
    String actualProgramName = DescTxtbox.getAttribute("value");
    Assert.assertEquals(actualProgramName, expectedDescription, "Program name does not match the expected value.");
}

public void selectStatus(String sheetName, String scenarioName, String status) throws IOException {
	
    List<String> data = xlutils.getRowData(sheetName, 0, scenarioName);
    String statusToSelect = data.get(3); 
    if (statusToSelect.equalsIgnoreCase("Active")) {
        Activebtn.click();
    } else if (statusToSelect.equalsIgnoreCase("Inactive")) {
        inActivebtn.click();
    } else {
        throw new IllegalArgumentException("Invalid status provided: " + statusToSelect);
    }
}

public void validateStatus(String sheetName, String scenarioName, String status) throws IOException {
	
    List<String> data = xlutils.getRowData(sheetName, 0, scenarioName);
    String expectedStatus = data.get(3); // Assuming status is in the third column (index 2)
    String actualStatus = "";
    if (Activebtn.isSelected()) {
        actualStatus = "Active";
    } else if (inActivebtn.isSelected()) {
        actualStatus = "Inactive";
    }
    Assert.assertEquals(actualStatus, expectedStatus, "Status does not match the expected value.");
}

public void enterValidDetails(String sheetName, String scenarioName) throws IOException {
	
    List<String> data = xlutils.getRowData(sheetName, 0, scenarioName);
    String programNameText = data.get(1);
    String descriptionText = data.get(2);
    String SelectStatus = data.get(3);
          // Assuming program name is in the second column
    progNameTxtbox.sendKeys(programNameText);
    DescTxtbox.sendKeys(descriptionText);
    Activebtn.click();
    savebtn.click();
    
    
}
public String getSuccessMessage() {
	
    wait.until(ExpectedConditions.visibilityOf(sucessmsg));
    return sucessmsg.getText();
}

public void validateSuccessMessage(String sheetName, String scenarioName, String expectedMessage) throws IOException {
	
    List<String> data = xlutils.getRowData(sheetName, 0, scenarioName);
    String actualMessage = getSuccessMessage();
    Assert.assertEquals(actualMessage, expectedMessage, "Success message does not match the expected value.");
}

    

    public void searchProgName(String sheetName, String scenarioName) throws IOException {
    	
		List<String> data = xlutils.getRowData(sheetName, 0, scenarioName);
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(searchBtn));
        if (searchBtn.isDisplayed()) {
            System.out.println("Program name is: " + data.get(1));
            searchBtn.sendKeys(data.get(1));
            searchBtn.sendKeys(Keys.ENTER);
        } else {
            Assert.fail("No search bar is displayed");
        }
    }

   

    public void clickCloseBtn() {
    	
    	int attempts = 0;
        while (attempts < 3) {
            try {
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
                WebElement closeButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(@class, 'p-dialog-header-close')]")));
                closeButton.click();
                break;
            } catch (StaleElementReferenceException e) {
                attempts++;
                System.out.println("Stale element encountered. Retrying...");
            } catch (TimeoutException e) {
                System.out.println("Close button not found within the expected time.");
                throw e;
            }
        }
    }
}
    






    
