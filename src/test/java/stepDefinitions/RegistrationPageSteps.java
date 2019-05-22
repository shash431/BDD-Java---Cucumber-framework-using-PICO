package stepDefinitions;

import org.junit.Assert;

import context.TestContext;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.RegistrationPage;

//Step Definitions related to Register Page http://calories-calc.herokuapp.com/register
public class RegistrationPageSteps {
	TestContext testContext;
	RegistrationPage registrationPage;

	 public RegistrationPageSteps(TestContext context) {
			testContext = context;
			registrationPage = testContext.getPageObjectManager().getRegistrationPage();
	 }
	 
	 @When("^User register with (.+),(.+),(.+),(.+)$")
	 public void User_register(String userName, String mail, String passwd, String confirmPasswd) throws Throwable {
		 registrationPage.RegisterNewUser(userName, mail, passwd, confirmPasswd);
	 }

	 
	
	@Then("^Verify Registration failed$")
	 public void Verify_Registration_Failed() throws Throwable {
	     // Write code here that turns the phrase above into concrete actions
		 Assert.assertTrue(registrationPage.registrationFailed());
	 }	 
	 
}
