package testRunners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

//@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
		features = { "src/test/resources/features" }, 
		glue = {"stepDefinition", "appHooks" }, 
		monochrome = true, 
		//tags="not @Skip",
		plugin = { "pretty", 
				"html:target/reports.html",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				"timeline:test-output-thread/",
				"rerun:target/failedRerun.txt"}
		
)
public class MySerenityTestRunner {

}
