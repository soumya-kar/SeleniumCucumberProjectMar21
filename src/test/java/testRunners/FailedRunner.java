package testRunners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = { "@target/failedRerun.txt" }, 
		glue = {"stepDefinition", "appHooks" }, 
		monochrome = true, 
		plugin = { "pretty", 
				"html:target/reports.html",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				"timeline:test-output-thread/",
				"rerun:target/failedRerun.txt"}
		
)
public class FailedRunner {

}
