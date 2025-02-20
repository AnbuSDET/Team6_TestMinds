package commonUtilities;

import driverManager.DriverFactory;
import pageObjects.ClassPage;
import pageObjects.LoginPage;

public class Context {

	private DriverFactory driverFactory;
	private LoginPage loginPage;
	private ClassPage classPage;

	public Context() {
		driverFactory = DriverFactory.getInstance();
		loginPage = new LoginPage(driverFactory.setupDriver());
		classPage = new ClassPage(driverFactory.setupDriver());

	}

	public DriverFactory getDriverFactory() {
		return driverFactory;
	}

	public LoginPage getLoginPage() {
		return loginPage;
	}

	public ClassPage getClassPage() {
		return classPage;
	}
}
