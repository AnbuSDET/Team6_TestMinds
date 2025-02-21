package commonUtilities;

import driverManager.DriverFactory;
import pageObjects.ClassPage;
import pageObjects.ClassPage_Part2;
import pageObjects.LoginPage;

public class Context {

	private DriverFactory driverFactory;
	private LoginPage loginPage;
	private ClassPage classPage;
	private ClassPage_Part2 classpage2;

	public Context() {
		driverFactory = DriverFactory.getInstance();
		loginPage = new LoginPage(driverFactory.setupDriver());
		classPage = new ClassPage(driverFactory.setupDriver());
		classpage2 = new ClassPage_Part2(driverFactory.setupDriver());

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

	public ClassPage_Part2 getClassPage2() {
		return classpage2;
	}
}
