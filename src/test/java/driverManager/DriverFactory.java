package driverManager;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import commonUtilities.Constants;

public class DriverFactory extends Constants {

    private static DriverFactory instance;
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    private DriverFactory() {}

    public static DriverFactory getInstance() {
        if (instance == null) {
            instance = new DriverFactory();
        }
        return instance;
    }
    
    public void quitDriver() {
    	System.out.println("quitting the driver");
    	 driver.get().quit();
    	 driver.remove();
    }

	public WebDriver setupDriver() {
        if (driver.get() == null) {
        	System.out.println("setting the driver");
            String browser = configProp.getString("browser");
            System.out.println("browser value is:" + browser);
            switch (browser) {
                case "firefox":
                    driver.set(new FirefoxDriver());
                    break;
                case "edge":
                    driver.set(new EdgeDriver());
                    break;
                case "chrome":
                default:
                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.addArguments("--disable-popup-blocking");
                    chromeOptions.addArguments("--headless");
                    chromeOptions.addArguments("--disable-notifications");
                    chromeOptions.addArguments("--disable-extensions");
                    chromeOptions.addArguments("--blink-settings=imagesEnabled=false");
                 //   chromeOptions.addArguments("--auto-open-devtools-for-tabs");
                    driver.set(new ChromeDriver(chromeOptions));
                    break;
            }
            driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
            driver.get().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
            driver.get().manage().deleteAllCookies();
            driver.get().manage().window().maximize();
        }
        return driver.get();
    }
}
