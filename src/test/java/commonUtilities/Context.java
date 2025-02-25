package commonUtilities;

import driverManager.DriverFactory;
import pageObjects.ClassPage;
import pageObjects.ClassPage_Part2;
import pageObjects.DashboardPage;
import pageObjects.LoginPage;
import pageObjects.LogoutPage;
import pageObjects.ManageBatchPage;
import pageObjects.Pagination;
import pageObjects.ProgramPage;
import pageObjects.ProgramPage_Part2;


public class Context extends Constants{

	private DriverFactory driverFactory;
	private LoginPage loginPage;
	private ClassPage classPage;

	private ManageBatchPage managebatchpage;
	private Pagination pagination;
	private Utility_Methods util;

	private ClassPage_Part2 classpage2;
	private ProgramPage_Part2 programpage2;
	private DashboardPage dashboardpage;
	private ProgramPage programpage;
	private LogoutPage logoutPage;
	


	public Context() {
		driverFactory = DriverFactory.getInstance();
		loginPage = new LoginPage(driverFactory.setupDriver(configProp.getString("browser")));
		classPage = new ClassPage(driverFactory.setupDriver(configProp.getString("browser")));
		System.out.println("setting up driver in context");

	   managebatchpage = new ManageBatchPage(driverFactory.setupDriver(configProp.getString("browser")));
	   pagination= new Pagination(driverFactory.setupDriver(configProp.getString("browser")));
	   util= new  Utility_Methods(driverFactory.setupDriver(configProp.getString("browser")));

		classpage2 = new ClassPage_Part2(driverFactory.setupDriver(configProp.getString("browser")));
		programpage2=new ProgramPage_Part2(driverFactory.setupDriver(configProp.getString("browser")));
		dashboardpage=new DashboardPage(driverFactory.setupDriver(configProp.getString("browser")));
		programpage=new ProgramPage(driverFactory.setupDriver(configProp.getString("browser")));
		logoutPage = new LogoutPage(driverFactory.setupDriver(configProp.getString("browser")));

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


	public ClassPage_Part2 getClassPage2() {
		return classpage2;
	}
	
	public ProgramPage_Part2 getProgramPage2() {
		return programpage2;
	}
	public DashboardPage getDashboardPage() {
		return dashboardpage;
	}
	public ProgramPage getProgramPage() {
		return programpage;
	}
	
	

	public LogoutPage getLogoutPage() {
			return logoutPage;
		}
}
