package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import commonUtilities.Utility_Methods;


public class ManageBatchPage {
	
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

	public ManageBatchPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		 util=new Utility_Methods(driver);
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

	 
	 
		
	 
	 
	 
	 
	}
	

	
	
	
	
	
