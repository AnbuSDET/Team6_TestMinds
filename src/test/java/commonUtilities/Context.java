package commonUtilities;

import driverManager.DriverFactory;
import pageObjects.ClassPage;
import pageObjects.LoginPage;
import pageObjects.ManageBatchPage;
import pageObjects.Pagination;


public class Context {

	private DriverFactory driverFactory;
	private LoginPage loginPage;
	private ClassPage classPage;
	private ManageBatchPage managebatchpage;
	private Pagination pagination;
	private Utility_Methods util;

	public Context() {
		driverFactory = DriverFactory.getInstance();
		loginPage = new LoginPage(driverFactory.setupDriver());
		classPage = new ClassPage(driverFactory.setupDriver());
	   managebatchpage = new ManageBatchPage(driverFactory.setupDriver());
	   pagination= new Pagination(driverFactory.setupDriver());
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
	
	public Pagination getpagination()
	{
		return pagination;
	}
	
	public Utility_Methods getUtils()
	{
		return util;
	}
}
