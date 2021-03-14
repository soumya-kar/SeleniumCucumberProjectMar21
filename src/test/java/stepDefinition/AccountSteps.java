package stepDefinition;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.pages.AccountPage;
import com.pages.LoginPage;
import com.qa.factory.DriverFactory;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class AccountSteps {
	
	private LoginPage loginPage= new LoginPage(DriverFactory.getDriver());
	private AccountPage accountPage;
	@Given("user has already logged in to application")
	public void user_has_already_logged_in_to_application(DataTable dataTable) {
	    List<Map<String, String>> credList = dataTable.asMaps();
	    String username= credList.get(0).get("username");
	    String password= credList.get(0).get("password");
	    DriverFactory.getDriver().get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
	    accountPage = loginPage.doLogin(username, password);
	}


	@Then("user gets accounts section")
	public void user_gets_accounts_section(DataTable sectionTable) {
	    List<String> expectedAccountSectionList= sectionTable.asList();
	    System.out.println("Expected accounts section list: "+expectedAccountSectionList);
	    List<String> actualAccountSectionList=accountPage.getAccountSectionList();
	    System.out.println("Actual accounts section list: "+actualAccountSectionList);
	    Assert.assertTrue(expectedAccountSectionList.equals(actualAccountSectionList));
	    
	}

	@Then("Account section count should be {int}")
	public void account_section_count_should_be(Integer expectedCount) {
	    Assert.assertTrue(accountPage.getAccountSectionSize()==expectedCount);
	}


}
