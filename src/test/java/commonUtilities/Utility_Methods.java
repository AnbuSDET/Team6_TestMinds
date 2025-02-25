package commonUtilities;

import java.time.Duration;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Utility_Methods extends Constants{

	public WebDriver driver;
	WebDriverWait webDriverWait;

	public Utility_Methods(WebDriver driver) {
		this.driver = driver;
		// Utility for methods

		webDriverWait = new WebDriverWait(this.driver, Duration.ofSeconds(20));
	}

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

	// Element Display
	
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

	// Element Enabled
	
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

	// sendKeys
	
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
	
	// check element enabled in all rows or List
	
	public boolean elementVisible_allRows(List<WebElement> elementsList )
	{				
		for (WebElement element : elementsList) {
	        webDriverWait.until(ExpectedConditions.visibilityOf(element));
	    }
        for (WebElement editIcon : elementsList) {        	
        	
            if (!editIcon.isEnabled()) {
                System.out.println("Icons are enabled: " + editIcon.getText());
                return false;
            }
        }
        return true;		
	}
	
		
	
	
	// element Click

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

	public String random5LetterWord() {
		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 5; i++) {
			int index = (int) (100 * Math.random()) % 25;
			sb.append(alphabet.charAt(index));
		}
		return sb.toString();

	}

	public String getPageTitle() {
		String title = driver.getTitle();
		return title;
	}
   
    public  String getPageCurrrentURL() {
		String CurrentURL = driver.getCurrentUrl();
		return CurrentURL;
	}
    

	public void assertText(WebElement element, String expected, String msg) {
		Assert.assertTrue(getElementText(element).equals(expected), msg);
	}

	public void clickUsingJS(WebElement element) {
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
	}

  
 

	public WebElement waitUntilClickable(WebElement element, int timeoutInSeconds) {
		return new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds))
				.until(ExpectedConditions.elementToBeClickable(element));
	}


//sorting 
	
	
	public void clickSortIcon(WebElement sortIcon) {
	    clickUsingJS(waitUntilClickable(sortIcon, 50));
	}

	public List<String> getOriginalList(List<WebElement> elementsList) {
	    return elementsList.stream()
	            .map(e -> e.getText().toLowerCase().trim())
	            .collect(Collectors.toList());
	}

	public List<String> getSortedList(List<WebElement> elementsList, boolean ascending) {
	    List<String> originalList = getOriginalList(elementsList);
	    return ascending
	            ? originalList.stream().sorted().collect(Collectors.toList())
	            : originalList.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
	}

	


	public void validateAlertMessage(WebElement element, String expectedText) {
		waitForElement(element);
		String actualMsg = element.getText().replaceAll("\\s+", " ").trim();
		String expectedMsg = expectedText.replaceAll("\\s+", " ").trim();
		Assert.assertTrue(actualMsg.contains(expectedMsg), "Expected alert message containing: " + expectedMsg);		
	}
	
	
	public void scrollIntoView(WebElement element) {
		//WebElement element = driver.findElement(By.id("elementId"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	
	}
	
	public void openSpecificPage(String subPage) {
		driver.get(configProp.getString("BaseUrl") + subPage);
		
	}
	

}