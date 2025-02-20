package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import commonUtilities.Utility_Methods;
import pojo.Lms_pojo;

public class ManageBatchPage {
	
	public WebDriver driver;
	Utility_Methods util;
	WebDriverWait wait;
	String bat ="Test";
	Lms_pojo poj= new Lms_pojo();
	
	@FindBy(xpath="//span[text()='Batch']") 
	WebElement batchinMenuBar;
	
	@FindBy(xpath="//*[text()=' Manage Batch']") 
	WebElement manageBatcheHeading;
		
	

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
		 String batcurlURL= util.getCurrentURL();
		 return batcurlURL;		
	}
	
	
	
	
	
	
}
