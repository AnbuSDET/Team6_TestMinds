package pageObjects;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import javax.swing.JTree.DynamicUtilTreeNode;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import commonUtilities.Constants;
import commonUtilities.ExcelReader;
import commonUtilities.Utility_Methods;
import io.vavr.collection.Set;
import pojo.Lms_Pojo;

//TeamBlogathon

public class ManageBatchPage extends Constants {
	
	public WebDriver driver;
	Utility_Methods util;
	WebDriverWait wait;	
	
	@FindBy(xpath="//span[text()='Batch']") 
	WebElement batchinMenuBar;
	
	@FindBy(xpath="//*[text()=' Manage Batch']") 
	WebElement manageBatcheHeading;

	@FindBy(xpath="//button[@class='p-button-danger p-button p-component p-button-icon-only']") 
	WebElement disabledDeleteIcon;
	
	@FindBy(xpath="//span[@class='p-paginator-pages ng-star-inserted']")
	WebElement enabledPaginatnBtn;
	
	@FindBy(xpath = "//table/tbody/tr//button[contains(@icon, 'pi-pencil')]") 
	List<WebElement> allEditicons;
	
   	@FindBy(xpath = "//table/tbody/tr//button[contains(@icon, 'pi-trash')]") 
   	List<WebElement> allDeleteIcons;
   	
   	@FindBy(xpath = "//div[@class='p-checkbox-box p-component']") 
   	List<WebElement> allCheckboxIcons;

   	@FindBy(xpath="//i[@class='p-sortable-column-icon pi pi-fw pi-sort-alt']") 
   	List<WebElement> allSortIcons;
   	
   	@FindBy(xpath="//th")
   	List<WebElement> headers;
   	
   	@FindBy(xpath="//i[@class='p-sortable-column-icon pi pi-fw pi-sort-alt']")
   	List<WebElement> sortIcons;  	
   	
   	@FindBy(xpath="//thead[@class='p-datatable-thead']") 
   	WebElement dataTableHeader;
	
   	
   	@FindBy(xpath="//div[@class='p-checkbox-box']")
   	WebElement headerCheckBox;
   	
   	@FindBy(xpath="//*[text()='Add New Batch']")
   	WebElement AddNewBatchBtn;
   	
   	@FindBy(xpath="//span[@class='p-button-icon pi pi-pencil']")
   	WebElement batchEditIcon;
   	
	List<String> sortableHeaders = Arrays.asList("Batch Name", "Batch Description", "Batch Status","No Of Classes","Program Name"); 
	
	@FindBy(xpath="//div[@role='dialog']") 
	WebElement batchPopupbox;	
	
	@FindBy (id="pr_id_34-label")
	WebElement ClickpopUp;
	
	
	@FindBy (css="div.p-dialog")
    WebElement dialog;
	
	public @FindBy(xpath="//div[@role='dialog']")
	WebElement dialogBox;
	
    @FindBy (css=".p-dropdown-trigger")
    WebElement programNameDropdowntrigger;  
    
    
	@FindBy(xpath="//input[@class='p-dropdown-label p-inputtext ng-tns-c88-12 ng-star-inserted']")
	WebElement popUpprogramNamedropDown;
	
	@FindBy(xpath="//div[@class='p-dropdown-trigger ng-tns-c88-13']")
	WebElement popUpprogramName_DropdownArrow;
	
	@FindBy(xpath="//div[@class='p-dropdown-items-wrapper ng-tns-c88-20']")
	WebElement popUpprogramName_DropdownMenu;
	
	@FindBy(id="batchProg")
	WebElement popUpBatchname_Prefix;
	
	@FindBy(id="batchName")
	WebElement popUpBatchname_Sufix;	
	
	@FindBy(xpath="//input[@type='text' and @readonly and @disabled]")
	WebElement editPopupProgramName;
	
	@FindBy(id="text-danger")
	WebElement batchNameSufic_errorMesg;
	
	@FindBy(id="batchDescription")
	WebElement popUpBatchdescription;
	
	@FindBy(id="batchStatus")
	WebElement popUpBatchstatus;
	
	@FindBy(xpath="(//p-radiobutton[@name='category'])[1]") 
	 WebElement activeradioBtn;
	
	@FindBy(xpath="(//p-radiobutton[@name='category'])[2]") 
	WebElement inactiveradioBtn;
	
	@FindBy(id="batchNoOfClasses")
	WebElement popUpBatchnoOfclasses;
	
	@FindBy(xpath="//button[@label='Cancel']")
	WebElement popUpBatchcancelBtn;
	
	@FindBy(xpath="//*[text()='Save']")
	WebElement popUpBatchsaveBtn;
	
	@FindBy(css=".p-dialog-header-close")
	WebElement popUpBatchcloseBtn;	
	
	@FindBy(xpath="//div[contains(@class, 'p-toast-detail')]")
	WebElement batchcreation_SucessMesg;
	
	@FindBy(xpath="//small[text()='Program Name is required.']")
	WebElement programNameErrormesg;
	
	@FindBy(xpath="//small[text()='Batch Name is required.']")
	WebElement batchNameErrormesg;
	
	@FindBy(xpath="//small[text()='Status is required.']")
	WebElement batchtatusErrormesg;
	
	@FindBy(xpath="//small[@id='text-danger' and text()='This field should start with an alphabet and min 2 character.']")
	WebElement batchDescriptionErrormesg;
	
	@FindBy(xpath="//small[text()='Number of classes is required.']")
	WebElement numberOfclassesErrormesg;
	
	@FindBy (xpath="//small[text()='This field should start with an alphabet and min 2 character.']")
	 WebElement batchDescriptionerrorMesg;
		
	@FindBy (xpath="//input[@id='filterGlobal']")
	public WebElement batchSearchBtn;
	
	@FindBy(xpath="//div[text()='Successful']")
	public  WebElement successmessage1;
	
	@FindBy(xpath="//div[text()='batch Updated']//div[@class='p-toast-summary ng-tns-c20-133']")
	public  WebElement successmessage2;
	
	@FindBy(xpath="//*[@id='text-danger']")
	public  WebElement errortext;
	
	@FindBy(xpath="//table/tbody/tr[1]/td[7]/div/span[2]/button")
	WebElement FirstbatcDelBtn;
	
	@FindBy (xpath="//div[@class='ng-trigger ng-trigger-animation ng-tns-c118-11 p-dialog p-confirm-dialog p-component ng-star-inserted']")
	private WebElement deletedialogueBox;
	
	@FindBy(xpath = "//span[text()='Yes']")
	private WebElement deleteYesbtn;

	@FindBy(xpath = "//span[text()='No']")
	private WebElement deleteNobtn;

	@FindBy(xpath = "//span[text()='Confirm']")
	private WebElement deleteConfirmHeader;
	
	@FindBy(xpath = "//button[contains(@class, 'p-dialog-header-close')]")
	private WebElement deletebatchClosebtn;
	
	@FindBy(xpath="//button[contains(@class, 'p-button-rounded p-button-danger')]")
	private WebElement commomDelIcon;
	
	 @FindBy(xpath = "//tbody/tr/td[2]")
	 public List<WebElement> batchnamelist;	 
     
	 //@FindBy(xpath="//tr[1]/td[1]")
	 @FindBy(xpath="//div[@role='checkbox']")
	 public  WebElement singlecheckbox;
	 
	 @FindBy(xpath = "//div[text()='Successful']")
	 public  WebElement Successmessage1;
	 
	 @FindBy(xpath = "//div[text()='batch Deleted']")
	 public  WebElement Successmessage2;
	 
    List<String> batchNameBeforeClick;
    List<String> batchNameAfterClick1;
	List<String> batchNameAfterClick2;
	
    List<String> Batchnames;	
	
	WebDriverWait webDriverWait;
	
	JavascriptExecutor js ;
	
	Lms_Pojo lms = new Lms_Pojo();
	Actions actions;
	
	public ManageBatchPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		js = (JavascriptExecutor) driver;
		 util=new Utility_Methods(driver);		 
		 actions= new Actions(driver);
		 webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(20));
	}	
			
	public void headerBatchClick()
	{       
       util.webElement_Click(batchinMenuBar);
	}
	
	 public String BatchPageValidation() 
       { 
    	  String batcurlURL= util.getPageCurrrentURL();
    	  return batcurlURL; 
    	   
       }
	          
	 
	 public String TitleValidation()
	 {
		 String Title= util.getPageTitle();
		 System.out.println("title:"+Title);
		 return Title;
	 }
	 
	 public String batchHeadingValidation()
	 {
		 return util.getElementText(manageBatcheHeading);
	 }
	 
	 public boolean batchdisableDelBtn()
	 {
		 boolean delBtnVisiblity=util.isElementEnabled(disabledDeleteIcon);
		 
		 return delBtnVisiblity;
	 }
	 
	 public boolean enabledpaginationBtn()
	 {
		 boolean disablePagination=util.isElementEnabled(enabledPaginatnBtn);
		 
		 return disablePagination;
	 } 
	 
	 public boolean headerCheckboxValidation()
		{
		 boolean headchkBox=util.isElementDisplayed(headerCheckBox);
		 return headchkBox;
		}
	 
	 
	 public String addNewBatch_btnValidation()
		{
		boolean  Flag =true;
		 String text="";
		 util.waitForElement(AddNewBatchBtn);
		 if(AddNewBatchBtn.isDisplayed()==Flag) {
			  text= AddNewBatchBtn.getText();
		 }
		 return text;
		}
	 
	 
	 public boolean batchAllrowOptions(String option) {
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
		        	if (util.elementVisible_allRows(allCheckboxIcons) == flag) {
		                return true; 
		            }
		            break;

		        default:
		           
		            break;
		    }

		    return false; 
		}
	
		
		public boolean validateSortIcons() {
				    
			
		    HashSet<String> sortableHeaderSet = new HashSet<String>(sortableHeaders);
		    System.out.println("sortableHeaderSet: " +sortableHeaderSet.size()+",sortIcons:"+sortIcons.size()+",headers:"+headers.size());
		    
		    
		    for (int i = 0; i < sortableHeaderSet.size(); i++) { 
		        WebElement header = headers.get(i+1); 
		        WebElement sortIcon = sortIcons.get(i);
		        String headerText = header.getText();
		        System.out.println("header: " + header+",headerText:"+headerText+",sortableHeaderSet.contains(headerText):"+sortableHeaderSet.contains(headerText));
		        
		        
		        if (sortableHeaderSet.contains(headerText)) {
		        	
		           
		            if (!sortIcon.isDisplayed()) {
		                System.out.println("Sort icon is not visible for header: " + headerText);
		                return false;
		            }

		            
		            if (!sortIcon.isEnabled()) {
		                System.out.println("Sort icon is not enabled for header: " + headerText);
		                return false;
		            }

		            System.out.println("Sort icon is valid for sortable header: " + headerText);
		        } else {
		            
		            System.out.println("Header is not sortable: " + headerText);
		        }
		    }

		    return true; 
		}

	 
		public String getTableHeader() {
	    	if (dataTableHeader.isDisplayed()) {	    		
	    		return dataTableHeader.getText();
	    	} else {
	    		return "";
	    	}
	    }
		
		
		// Add New batch Definitions
		
		public void clickAddnewbatch()
		{
			util.webElement_Click(AddNewBatchBtn);
		}
		
		
		public boolean batchPopupAllfieldValidation()
		{		
			   
			    List<WebElement> popUpElements = Arrays.asList(
			        popUpprogramNamedropDown,
			        popUpBatchname_Prefix,
			        popUpBatchname_Sufix,
			        popUpBatchdescription,
			        popUpBatchstatus,
			        popUpBatchnoOfclasses,
			        popUpBatchcancelBtn,
			        popUpBatchsaveBtn,
			        popUpBatchcloseBtn
			    );	    
			    
			    if (batchPopupbox.isDisplayed()) {
			        boolean allFieldsValid = true; 

			        for (WebElement popUpElement : popUpElements) {
			        	
			            util.waitForElement(popUpElement); 
			            
			            boolean isDisplayed = popUpElement.isDisplayed();
			            boolean isEnabled = popUpElement.isEnabled();

			            // Mark as invalid if either is false
			            if (!isDisplayed || !isEnabled) {               
			                
			                allFieldsValid = false; 
			            } else {
			            	System.out.println("Fields are valid & enabled");
			                
			            }
			        }

			        return allFieldsValid; // Return true only if all fields are valid
			    } else {
			        System.out.println("Batch popup box is not displayed.");
			        return false; 
			    }
			}   
			    
			    	   
			    
			    public void popUp_ProgramName_Select()
			    {	  
			    	
			    	//String optionValue="testingtesting";		
			    	//lms.setProgramName(optionValue);
			    			    	
			    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			    	util.waitForElement(dialog);
			    	util.webElement_Click(programNameDropdowntrigger);			
			     
			     boolean optionFound = false;
			        while (!optionFound) {
			        	
			            // Get all drop down options
			        	
			            List<WebElement> options = driver.findElements(By.cssSelector(".p-dropdown-item"));

			            // Check if any options match the desired text
			            for (WebElement option : options) {
			                if (option.getText().equals(lms.getProgramName())) {
			                    option.click(); 
			                    optionFound = true;
			                    return; 
			                }
			            }

			            // If not found, scroll down
			            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollTop = arguments[0].scrollHeight", programNameDropdowntrigger);
			            
			               }
			        
			    }
			    
			    
			    public boolean batchNamePrefixValidation()
			    {
			        //WebElement inputField = driver.findElement(By.id("batchProg"));
		            String text=popUpBatchname_Prefix.getAttribute("value");		            
			        return 	text.contains(lms.getProgramName());
			    
			    }
			    
			    public void batchNameSuffix_sendKeys()
			    {
			    	util.webSendKeys(popUpBatchname_Sufix, "test");
			    }
			    
			  public String batchNameSufix_Validation() {
				  String errorMesg=batchNameSufic_errorMesg.getText();
				  return errorMesg;
			  }
			    
			  
			  public void batchname_prefixSendKeys()
			  {
				  util.webSendKeys(popUpBatchname_Prefix, "test");
			  }
			    
			  public boolean batchname_prefixValidation()			  
			  {
				  String prefixText= popUpBatchname_Prefix.getAttribute(("readonly"));
				  if (prefixText.equalsIgnoreCase("true"))
				  System.out.println("prefixText Attribute"+prefixText);
				  return true;				  
			  }
			  
			  public void addNewbatch_closeBtn_click()
				{
				    util.waitForElement(dialog);
					util.webElement_Click(popUpBatchcloseBtn);
				}
			  
			  			   
public void addBatchValidDetails(String Scenario) throws IOException
{
	List<String> data = xlutils.getRowData("Batch", 0, Scenario);
	util.webSendKeys(popUpBatchdescription, data.get(1));
	 util.webSendKeys(popUpBatchname_Sufix, data.get(3));
	 util.clickUsingJS(activeradioBtn);
	 util.webElement_Click(activeradioBtn);
    util.webSendKeys(popUpBatchnoOfclasses,data.get(2));
}
			  


			  public void AddNewBath(String ScenarioName) throws IOException
			  {
				  List<String> data = xlutils.getRowData("Batch", 0, ScenarioName);
				  
				  switch(ScenarioName) {
				  
			        case "onlyMandatoryfields":  
			        	popUp_ProgramName_Select();
			        	addBatchValidDetails(ScenarioName);						
			             util.webElement_Click(popUpBatchsaveBtn);
			            break; 

			        case "withoutMandatoryfields":			            	
			            util.webElement_Click(popUpBatchsaveBtn);
			            break; 

			        case "allValidFields":
			        	 popUp_ProgramName_Select();
			        	 addBatchValidDetails(ScenarioName);			        
			             util.webElement_Click(popUpBatchsaveBtn);
			            break;
			        case "cancelBtnwithValiddata":  
			        	 popUp_ProgramName_Select();
			        	 addBatchValidDetails(ScenarioName);			         	
			             util.webElement_Click(popUpBatchcancelBtn);
			            break; 

			        default:
			           
			            break;
			    }
			  }
			  
			  			  			  
			  public boolean addNewBatch_Mesgvalidation(String ScenarioName) throws InterruptedException, IOException
			  {				
				  List<String> data = xlutils.getRowData("Batch", 0, ScenarioName);
				  String SuccessMesg="";
				  boolean returnValue = false;
				  switch(ScenarioName) {
				  
			        case "onlyMandatoryfields":	
						  ((JavascriptExecutor) driver).executeScript("arguments[0].click();", batchcreation_SucessMesg);
				        	SuccessMesg= batchcreation_SucessMesg.getText();				        	
			        	if(batchcreation_SucessMesg.isDisplayed()) {   
			        	      if (SuccessMesg.contains(data.get(4)))
			        	    	  lms.setBatchName1(lms.getProgramName()+data.get(3));
			        	       System.out.println("Batch Name:"+lms.getBatchName1());			        	      
			        	       returnValue = true;	
			        	}
							   break;
			        			            
				case "withoutMandatoryfields": 
			        	String prgramerrMesg = programNameErrormesg.getText();
			        	String batchNameerrMesg=batchNameErrormesg.getText();
			        	String batchStatusErrMesg=batchtatusErrormesg.getText();
			        	String noOfClasserrMesg= numberOfclassesErrormesg.getText();
			        	String batchDeErrormesg =batchDescriptionErrormesg.getText();
			        	if (prgramerrMesg.contains("required") && batchNameerrMesg.contains("required") && batchStatusErrMesg.contains("required") && noOfClasserrMesg.contains("required") && batchDeErrormesg.contains("required"))
			        		returnValue = true;
			        	break;
			        	
				case "cancelBtnwithValiddata": 					
					Thread.sleep(1000);
					    if (!dialogBox.isDisplayed()) {	
					    	returnValue = true;
					    }
		        	break;
			        	
			        case "allValidFields": 		  
						  ((JavascriptExecutor) driver).executeScript("arguments[0].click();", batchcreation_SucessMesg);
				        	SuccessMesg= batchcreation_SucessMesg.getText();				        	
			        	      if (SuccessMesg.contains(data.get(4))){
			        	    	  lms.setBatchName2(lms.getProgramName()+data.get(3));			        	    	  
			        	       System.out.println("Batch Name:"+lms.getBatchName2());							  
			        	       returnValue = true; 
			        	      }
			        	      break;
			  }
				  
			        	return returnValue;
		}	 
			  
			  
			  			  
			  
			  public void batch_ClickeditIcon()
			  {
				  lms.setBatchName2("BlogathonTesting78");
				  Actions actions = new Actions(driver);
				  actions.doubleClick(batchSearchBtn).perform();
				  util.webSendKeys(batchSearchBtn,lms.getBatchName2());
				  util.webElement_Click(batchEditIcon);
			  }
			  
			  public boolean ProgramBatchenableValidation(String Name)
			  {		
				  
				  ((JavascriptExecutor) driver).executeScript("arguments[0].click();", editPopupProgramName);
				  boolean Flag= false;
				  
				  if(Name.equalsIgnoreCase("Program") &&!editPopupProgramName.isEnabled())	
					  
					  Flag= true;
				  
				  else  if(Name.equalsIgnoreCase("Batch") &&!popUpBatchname_Sufix.isEnabled())				  
					  Flag= true;
				  
				  System.out.println("editProgramName"+editPopupProgramName.isEnabled());
				  System.out.println("batchname"+popUpBatchname_Sufix.isEnabled());
				  return Flag;
				  
			  }
			  
			  public void editBatchDetails(String Scenario) throws IOException
			  {
			  	List<String> data = xlutils.getRowData("Batch", 0, Scenario);
			  	util.waitForElement(popUpBatchdescription);
			  	popUpBatchdescription.clear();
			  	util.webSendKeys(popUpBatchdescription, data.get(1));
			  	util.waitForElement(popUpBatchnoOfclasses);
			  	popUpBatchnoOfclasses.clear();
			  	util.webSendKeys(popUpBatchnoOfclasses,data.get(2));
			  }	 
			  
			  
			  public void EditBath(String ScenarioName) throws IOException
			  {						  	
				 	  switch(ScenarioName) {	
				  
			        case "description_noOfClasses_Invalid":  
			        	 editBatchDetails(ScenarioName);						
			             util.webElement_Click(popUpBatchsaveBtn);
			            break; 

			        case "saveBtnwithValidData":			            	
			        	 editBatchDetails(ScenarioName);
			        	 util.webElement_Click(popUpBatchsaveBtn);
			            break; 
			       
			        case "cancelBtnwithValiddata":  
			        	 editBatchDetails(ScenarioName);			         	
			             util.webElement_Click(popUpBatchcancelBtn);
			            break; 

			        default:
			           
			            break;
			    }
			  }
			  
			  	  public boolean EditBatch_REsponseValidations(String Scenario) throws IOException, InterruptedException
			  	  {
			  		 List<String> data = xlutils.getRowData("Batch", 0, Scenario);
			  		boolean returnValue = false;
			  		switch(Scenario) {	
					  
			        case "description_noOfClasses_Invalid":  
			        	returnValue=EditBatcherrorMessage(Scenario);			        	
			            break; 

			        case "saveBtnwithValidData":	
			        	 ((JavascriptExecutor) driver).executeScript("arguments[0].click();", batchcreation_SucessMesg);
				    	 Thread.sleep(2000);
				    	 String text2=batchcreation_SucessMesg.getText();
				    	 returnValue=text2.contains(data.get(4));			        	
			            break; 
			       
			        case "cancelBtnwithValiddata": 			        	
			        	Thread.sleep(2000);
			        	System.out.println("Testing");
					   if(batchSearchBtn.isEnabled()){
						   returnValue=true;
					   }
			            break; 

			        default:
			           
			            break;
			    }
			  		return returnValue;  
			  	  }
			  
			  
		
			  public boolean EditBatcherrorMessage(String Scenario) throws InterruptedException, IOException
			  {
				  List<String> data = xlutils.getRowData("Batch", 0, Scenario);
				  boolean flag=false;
				  Thread.sleep(1000);				
				  ((JavascriptExecutor) driver).executeScript("arguments[0].click();", batchDescriptionErrormesg);
				  String Text2 =batchDescriptionErrormesg.getText();
				  if(Text2.contains(data.get(4)))
						  flag=true;
				  return flag;
				  
			  }
			  			  
			 
			  
			  public String errormessage() {
			    	return errortext.getText();
			    }
			  
			  
			  // Delete Batch
			  
			  public void click_randomDelBtn()
			  {
				  actions.sendKeys(Keys.ESCAPE).perform();
				  ((JavascriptExecutor) driver).executeScript("arguments[0].click();", FirstbatcDelBtn);
				  util.waitForElement(FirstbatcDelBtn);
			  }
			  
			  // delete yes Validation
			  
			  
			  public void click_DeleteBatchusingSearch()
			  {
				  batchNameBeforeClick=printlistofbatchName();
				  actions.sendKeys(Keys.ESCAPE).perform();
				  lms.setBatchName2("TestingforDelete1");				  
				  util.webSendKeys(batchSearchBtn,lms.getBatchName2());					  
				  actions.sendKeys(Keys.TAB).perform();				 
		   		   js.executeScript("arguments[0].click();",singlecheckbox);		   		 
				  WebElement delbtn=driver.findElement(By.xpath("//button[contains(@class, 'p-button-rounded p-button-danger')]"));
				  ((JavascriptExecutor) driver).executeScript("arguments[0].click();", delbtn);			 		 			   		  

			  }
			  
			 
			  public void  Click_batchDelYesBtn() throws InterruptedException
			  {				  		    	
				  ((JavascriptExecutor) driver).executeScript("arguments[0].click();", deleteYesbtn);					    
				    sucessmessgetext();	
				  driver.navigate().refresh();
				  batchNameAfterClick2 = printlistofbatchName();
				  
			  }
			  
			  public String[] sucessmessgetext() throws InterruptedException {
				    Thread.sleep(2000);
			    	String text1=Successmessage1.getText();
			    	String text2=Successmessage2.getText();
			    	return new String[] {text1,text2};
			    
			    }	  
			  
			  
			  public boolean delBatchNoValidation()
			    {  
			    	boolean flag=false;
			    	 if (batchNameBeforeClick.equals(batchNameAfterClick2)) {
			    		  System.out.println("It is  not deleted");
			    		   flag=true;
			    	 }
			    	 else if (!batchNameBeforeClick.equals(batchNameAfterClick2)){
			    		  System.out.println("It is deleted");
			    		  flag=false;
			    	 }
			    	return flag;
			    }
			  
			  //
			  
			  public void click_DelBatch_NoBtn() throws InterruptedException
			  {
				  Thread.sleep(2000);
				  batchNameBeforeClick=printlistofbatchName();				  
				  ((JavascriptExecutor) driver).executeScript("arguments[0].click();", deleteNobtn);		
				  batchNameAfterClick2 = printlistofbatchName();
			  }
			  
			  
			 
			 
			  public void DelclickCloseBtn() throws InterruptedException
			  {			
				  //webDriverWait.until(ExpectedConditions.visibilityOf((WebElement) batchnamelist));
				  Thread.sleep(1000);
				  batchNameBeforeClick=printlistofbatchName();
				  util.waitForElement(deletebatchClosebtn);
				  ((JavascriptExecutor) driver).executeScript("arguments[0].click();", deletebatchClosebtn);	
				  batchNameAfterClick2 = printlistofbatchName();
			  }
			    
			  	  
			  
			  public boolean searchBoxEnabled()
				 {
					 return batchSearchBtn.isDisplayed();
				 }			
		       
			   
			 
			    
			    
			    
		       public  ArrayList<String>  printlistofbatchName() {
		       	
		    	   Batchnames= new ArrayList<String>();
		      	
		      	for (WebElement names : batchnamelist) {
		      		Batchnames.add(names.getText());
		      	}	      	
		      	
		      	return (ArrayList<String>) Batchnames;
		  	    
		         }

				  public boolean Delete_dialogueBox_validation()
				  {						  
					return deletedialogueBox.isDisplayed();
					  
				  }
		       
		       
}




		
		
	

	
	
	
	
	
