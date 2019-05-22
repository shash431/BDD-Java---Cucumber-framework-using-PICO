package stepDefinitions;

import org.junit.Assert;

import context.TestContext;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.LoginPage;

//Step Definitions related to login Page http://calories-calc.herokuapp.com/login
public class LoginPageSteps {
	
	TestContext testContext;
	LoginPage loginPage;
	
	 public LoginPageSteps(TestContext context) {
			testContext = context;
			loginPage = testContext.getPageObjectManager().getLoginPage();
		}

	
	 @When("^User enters \"([^\"]*)\" and \"([^\"]*)\" and logs in$")
	 public void User_login(String usermail, String password) throws Throwable {
    	loginPage.userLogin(usermail, password);
    }
    
    @Then("^Verify that user is not logged in$")
    public void Verify_User_Not_Logged() throws Throwable {
    	 Assert.assertTrue(loginPage.GetLoginFailedMessage().contains("login failed"));
		
    }

}
