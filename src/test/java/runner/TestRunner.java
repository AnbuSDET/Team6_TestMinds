package runner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;

@io.cucumber.testng.CucumberOptions(features = { "src/test/resources/Features/04_ManageBatch.feature" }, glue = { "stepDefinitions",
		"hooks" },

		plugin = { "pretty", "html:target/cucumber-reports/reports.html",
				"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm", "json:target/cucumber-reports/cucumber.json",
				"junit:target/cucumber-reports/cucumber.xml",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				"rerun:target/rerun.txt" }, publish = true, tags = "@test")




public class TestRunner extends AbstractTestNGCucumberTests {

	@Override
	@DataProvider(parallel = false)
	public Object[][] scenarios() {
		return super.scenarios();
	}

}
