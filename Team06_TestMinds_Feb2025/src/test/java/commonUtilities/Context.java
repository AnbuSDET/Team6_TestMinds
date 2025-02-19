package commonUtilities;

import driverManager.DriverFactory;
import pageObjects.LoginPage;

public class Context {

    private DriverFactory driverFactory;
    private LoginPage loginPage;    

    public Context() {
        driverFactory = DriverFactory.getInstance();
        loginPage = new LoginPage(driverFactory.getDriver());
    }

    public DriverFactory getDriverFactory() {
        return driverFactory;
    }

    public LoginPage getLoginPage() {
        return loginPage;
    }
}
