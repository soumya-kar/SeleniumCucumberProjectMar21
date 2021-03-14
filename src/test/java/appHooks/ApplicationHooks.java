package appHooks;

import java.util.Properties;

import org.junit.Assume;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.qa.factory.DriverFactory;
import com.qa.util.ConfigReader;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class ApplicationHooks {
	
	private DriverFactory driverFactory;
	private WebDriver driver;
	private ConfigReader configReader;
	private Properties prop;
	
	@Before(value="@Skip", order = -1)
	public void skip_Scenario(Scenario scenario){
		System.out.println("SKIPPED SCENARIO IS: "+scenario.getName());
		Assume.assumeTrue(false);
	}
	
	@Before(order=0)
	public void getProperty(){
		configReader= new ConfigReader();
		prop=configReader.initProp();
		
	}
	
	@Before(order=1)
	public void launchBrowser(){
		String browser=prop.getProperty("browser");
		driverFactory= new DriverFactory();
		driver=driverFactory.initDriver(browser);
	}
	
	@After(order=0)
	public void quitBrowser(){
		driverFactory.closeDriver();
	}
	
	@After(order=1)
	public void tearDown(Scenario scenario){
		if(scenario.isFailed()){
			String screenshotName= scenario.getName().replaceAll(" ", "_");
			byte [] sourcePath = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(sourcePath, "image/png", screenshotName);
		}
	}
	

}
