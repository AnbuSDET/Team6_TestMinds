package commonUtilities;

import driverManager.DriverFactory;
import pageObjects.LoginPage;
import pageObjects.ManageBatchPage;

public class Context {

    private DriverFactory driverFactory;
    private LoginPage loginPage;  
    private ManageBatchPage managebatchPage;

    public Context() {
        driverFactory = DriverFactory.getInstance();
        loginPage = new LoginPage(driverFactory.getDriver());
        managebatchPage = new ManageBatchPage(driverFactory.getDriver());
    }

    public DriverFactory getDriverFactory() {
        return driverFactory;
    }

    public LoginPage getLoginPage() {
        return loginPage;
    }
    
    public ManageBatchPage getManagebatchPage() {
        return managebatchPage;
    }
}
