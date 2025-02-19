package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import commonUtilities.Utility_Methods;

public class ManageBatchPage {
	
	public WebDriver driver;
	Utility_Methods util;
	WebDriverWait wait;
	
	@FindBy(xpath="//span[text()='Batch']") 
	WebElement batchinMenuBar;
	

	public ManageBatchPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		 util=new Utility_Methods(driver);
	}
	
	
	
	
	public void headerBatchClick()
	{       
       util.webElement_Click(batchinMenuBar);
	}
}
