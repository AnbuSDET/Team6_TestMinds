package commonUtilities;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Utility_Methods {
	
	public WebDriver driver;
	
	public Utility_Methods(WebDriver driver) {
		this.driver = driver;		
	}
	// Utility for methods	
	
	WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(20));

	public void waitForElement(WebElement element) {
		webDriverWait.until(ExpectedConditions.visibilityOf(element));
	}

	public static boolean validator(String actual, String expected) {

		if (actual.equalsIgnoreCase(expected)) {
			return true;
		} else {
			return false;
		}

	}
	

	public String getElementText(WebElement ele) {
		return ele.getText();
	}

	public String getElementTagName(WebElement element) {

		String tagName = element.getTagName();
		System.out.println("Element tag name is: " + tagName);
		return tagName;
	}

	public String getCurrentURL()
	{
		String CurtUrl= driver.getCurrentUrl();
		
		return CurtUrl;
		
	}
	public boolean isElementDisplayed(WebElement element) {
		boolean flag = false;
		try {

			WebElement ele = new WebDriverWait(driver, Duration.ofSeconds(30))
					.until(ExpectedConditions.visibilityOf(element));

			if (ele.isDisplayed()) {
				flag = true;
			}

			else {
				throw new Exception("Element is not displayed");
			}

		} catch (Exception e) {
			e.printStackTrace();

		}
		return flag;
	}

	public boolean isElementEnabled(WebElement element) {
		boolean flag = false;
		try {

			WebElement ele = new WebDriverWait(driver, Duration.ofSeconds(30))
					.until(ExpectedConditions.visibilityOf(element));

			if (ele.isEnabled()) {
				flag = true;
			}

			else {
				throw new Exception("Element is not displayed");
			}

		} catch (Exception e) {
			e.printStackTrace();

		}
		return flag;
	}

	public boolean webSendKeys(WebElement element, String text) {
		try {
			WebElement ele = new WebDriverWait(driver, Duration.ofSeconds(10))
					.until(ExpectedConditions.visibilityOf(element));

			if (ele.isEnabled()) {
				try {
					ele.clear();
					ele.sendKeys(text);
					return true;
				} catch (Exception e) {
					e.printStackTrace();
					return false;
				}
			} else {
				throw new Exception("Element is not enabled");
			}
		}

		catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean webElement_Click(WebElement element) {
		try {
			WebElement ele_toclick = new WebDriverWait(driver, Duration.ofSeconds(10))
					.until(ExpectedConditions.visibilityOf(element));

			if (ele_toclick.isEnabled() && ele_toclick.isDisplayed()) {
				try {
					ele_toclick.click();
					return true;
				} catch (Exception e) {
					e.printStackTrace();
					return false;
				}
			} else {
				throw new Exception(element + " Element is not enabled or clickable or displayed");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	

	public static String random5LetterWord(){
		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 5; i++) {
			int index = (int)(100 * Math.random()) % 25;
			sb.append(alphabet.charAt(index));
		}
		return sb.toString();
		 
	}
	            
    public String getPageTitle() {
		String title = driver.getTitle();
		return title;
	}
   
     void assertText(WebElement element, String expected,String msg) {
		Assert.assertTrue(getElementText(element).equals(expected),msg);
	}
	
	 
   
    

  
   
}