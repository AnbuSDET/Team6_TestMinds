package commonUtilities;

import driverManager.DriverFactory;
import pageObjects.ClassPage;
import pageObjects.LoginPage;
import pageObjects.ManageBatchPage;


public class Context {

	private DriverFactory driverFactory;
	private LoginPage loginPage;
	private ClassPage classPage;
	private ManageBatchPage managebatchpage;
	private Utility_Methods util;

	public Context() {
		driverFactory = DriverFactory.getInstance();
		loginPage = new LoginPage(driverFactory.setupDriver());
		classPage = new ClassPage(driverFactory.setupDriver());
	   managebatchpage = new ManageBatchPage(driverFactory.setupDriver());
	   util= new  Utility_Methods(driverFactory.setupDriver());

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
	
	public ManageBatchPage getmanagebatchpage() {
		return managebatchpage;
	}
	
	public Utility_Methods getUtils()
	{
		return util;
	}
}
