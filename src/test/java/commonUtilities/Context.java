package commonUtilities;

import driverManager.DriverFactory;
import pageObjects.ClassPage;
import pageObjects.ClassPage_Part2;
import pageObjects.DashboardPage;
import pageObjects.LoginPage;

import pageObjects.ManageBatchPage;
import pageObjects.Pagination;


import pageObjects.ProgramPage_Part2;


public class Context {

	private DriverFactory driverFactory;
	private LoginPage loginPage;
	private ClassPage classPage;

	private ManageBatchPage managebatchpage;
	private Pagination pagination;
	private Utility_Methods util;

	private ClassPage_Part2 classpage2;
	private ProgramPage_Part2 programpage2;
	private DashboardPage dashboardpage;


	public Context() {
		driverFactory = DriverFactory.getInstance();
		loginPage = new LoginPage(driverFactory.setupDriver());
		classPage = new ClassPage(driverFactory.setupDriver());
		System.out.println("setting up driver in context");

	   managebatchpage = new ManageBatchPage(driverFactory.setupDriver());
	   pagination= new Pagination(driverFactory.setupDriver());
	   util= new  Utility_Methods(driverFactory.setupDriver());

		classpage2 = new ClassPage_Part2(driverFactory.setupDriver());
		programpage2=new ProgramPage_Part2(driverFactory.setupDriver());
		dashboardpage=new DashboardPage(driverFactory.setupDriver());


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

}
