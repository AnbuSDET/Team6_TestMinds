package pageObjects;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import commonUtilities.Utility_Methods;

public class Pagination {
	public WebDriver driver;
	Utility_Methods util;
	WebDriverWait wait;

	@FindBy(xpath ="//span[@class='p-paginator-icon pi pi-angle-right']")
  	public WebElement nextbutton;
	
	@FindBy(xpath ="//span[@class='p-paginator-icon pi pi-angle-double-right']")
  	public WebElement doublearrowrightbutton;
	
	@FindBy(xpath ="//button[@class='p-paginator-next p-paginator-element p-link p-ripple p-disabled']")
  	public WebElement disablenextbutton;
	
	@FindBy(xpath ="//button[@class='p-paginator-last p-paginator-element p-link p-ripple ng-star-inserted p-disabled']")
  	public WebElement disabledoublearrowrightbutton;
	
	@FindBy(xpath ="//span[@class='p-paginator-icon pi pi-angle-left']")
  	public WebElement backbutton;
	
	@FindBy(xpath ="//span[@class='p-paginator-icon pi pi-angle-double-left']")
  	public WebElement doublearrowleftbutton;
	
	@FindBy(xpath ="//button[@class='p-paginator-prev p-paginator-element p-link p-ripple p-disabled']")
  	public WebElement disablebackbutton;
	
	@FindBy(xpath ="//button[@class='p-paginator-first p-paginator-element p-link p-ripple ng-star-inserted p-disabled']")
  	public WebElement disabledoublearrowleftbutton;
	
	@FindBy(xpath="//button[@class='p-paginator-page p-paginator-element p-link p-highlight p-ripple ng-star-inserted' and text()='1']")
	public WebElement firstPageLink;
	
	JavascriptExecutor js ;
	WebDriverWait webDriverWait;
	Actions actions;
	public Pagination(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		js = (JavascriptExecutor) driver;
		 util=new Utility_Methods(driver);	
		 webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(20));
		  actions = new Actions(driver);
	}	
	
	public void clicknextpagelink() throws InterruptedException {
		actions.sendKeys(Keys.ESCAPE).perform();
		webDriverWait.until(ExpectedConditions.visibilityOf(nextbutton));			 
		 js.executeScript("arguments[0].click();",nextbutton);
	     }
		
	public boolean isNextLinkEnabled() {
		System.out.println(doublearrowrightbutton.isEnabled());
	    return doublearrowrightbutton.isEnabled();
	}
	
	public void clicklastpagelink() throws InterruptedException {	
		actions.sendKeys(Keys.ESCAPE).perform();
		 webDriverWait.until(ExpectedConditions.visibilityOf(doublearrowrightbutton));		
		 js.executeScript("arguments[0].click();",doublearrowrightbutton);
		 js.executeScript("arguments[0].click();",doublearrowrightbutton);
		 Thread.sleep(1000);
	}
	
	public boolean[] nextandlastlinksdisabled() throws InterruptedException {
		
		js.executeScript("arguments[0].click();",disabledoublearrowrightbutton);
		webDriverWait.until(ExpectedConditions.visibilityOf(disabledoublearrowrightbutton));
		
		 System.out.println(disabledoublearrowrightbutton.isEnabled());
		 webDriverWait.until(ExpectedConditions.visibilityOf(disablenextbutton));		 
		 System.out.println(disablenextbutton.isEnabled());
		 return new boolean[] {disabledoublearrowrightbutton.isEnabled(), disablenextbutton.isEnabled()};
	} 
	
	public void clickbackwardpagelink() throws InterruptedException {
		actions.sendKeys(Keys.ESCAPE).perform();
		webDriverWait.until(ExpectedConditions.visibilityOf(backbutton));		
		 js.executeScript("arguments[0].click();",backbutton);
		 Thread.sleep(1000);
	     }
	
	
	public boolean isPreviousLinkEnabled() {
		System.out.println(doublearrowleftbutton.isEnabled());
	    return doublearrowleftbutton.isEnabled();
	}
	
	public void clickfirstpagelink() throws InterruptedException {	
		
		actions.sendKeys(Keys.ESCAPE).perform();
		 clicknextpagelink();
		 js.executeScript("arguments[0].click();",doublearrowleftbutton);
		 webDriverWait.until(ExpectedConditions.visibilityOf(doublearrowleftbutton));
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("arguments[0].click();",doublearrowleftbutton);
		 Thread.sleep(1000);			
	 }	
	
	public boolean[] backwardandpreviouslinksdisabled() throws InterruptedException {
		 webDriverWait.until(ExpectedConditions.visibilityOf(disabledoublearrowleftbutton));		
		 System.out.println(disabledoublearrowleftbutton.isEnabled());
		 webDriverWait.until(ExpectedConditions.visibilityOf(disablebackbutton));		 
		 System.out.println(disablebackbutton.isEnabled());
		 return new boolean[] {disabledoublearrowleftbutton.isEnabled(), disablebackbutton.isEnabled()};
	}
}
