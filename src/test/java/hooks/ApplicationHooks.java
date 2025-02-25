package hooks;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import commonUtilities.Constants;
import driverManager.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class ApplicationHooks extends Constants{

	private DriverFactory driverFactory;
	private WebDriver driver;
	public static Logger log = LogManager.getLogger();

	@Before
	public void launchBrowser() {
		System.out.println("=========launchBrowser=======================");
		driverFactory = DriverFactory.getInstance();
		driverFactory.setupDriver(configProp.getString("browser"));
	}

	@AfterStep
	public void screenShot(Scenario scenario) {
		if (scenario.isFailed()) {
			String screenshotName = scenario.getName().replaceAll(" ", "_");
			byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(sourcePath, "image/png", screenshotName);
			
		}
	}

	@After
	public void quitBrowser() {
		System.out.println("=========quitBrowser=======================");
		if(driverFactory!=null)
		driverFactory.quitDriver();
	}
}
