package stepDefinitions;

import org.junit.Assert;

import context.TestContext;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import pageObjects.HomePage;

// Step Definitions related to Home Page http://calories-calc.herokuapp.com
public class HomePageSteps {

	HomePage homePage;
	TestContext testContext;
		
		
	 public HomePageSteps(TestContext context) {
			testContext = context;
			homePage = testContext.getPageObjectManager().getHomePage();
		}
	 
	 // navigate to page
	@Given("^user is on Home Page$")
    public void User_is_on_home_page() throws Throwable {
		 homePage.navigateTo_HomePage(); 
	}
	
	// click on log in 
    @And("^Clicks on login link in home Page$")
    public void Click_LogIn() throws Throwable {
    	homePage.click_LogIn();
    }

	// click on register
    @And("^Clicks on register link in home Page$")
    public void Click_Register() throws Throwable {
    	homePage.click_Register();
    }

    @Then("^Verify user is in the Home Page$")
    public void Verify_User_is_in_Home_Page() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
    	Assert.assertTrue(homePage.getLoginBtn().isDisplayed());
    	Assert.assertTrue(homePage.getRegisterBtn().isDisplayed());
    }

	   
}
