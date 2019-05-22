package stepDefinitions;

import org.junit.Assert;

import context.TestContext;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.MenuPage;

//Step Definitions related to Menu (Edibles, Profile, Logout links) 
// As menu page we 
public class MenuPageSteps {

	TestContext testContext;
	MenuPage menuPage;

	 public MenuPageSteps(TestContext context) {
			testContext = context;
			menuPage = testContext.getPageObjectManager().getMenuPage();
		}

	
	@When("^User logout$")
	public void User_Logout() throws Throwable {
		menuPage.LogOut();
	}

	@When("^User navigate to profile page$")
	public void User_Navigate_to_ProfilePage() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		menuPage.ClickProfile();
	}
	
	@When("^User navigate to edibles page$")
	public void User_Navigate_to_EdiblesPage() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		menuPage.ClickEdibles();
	}
	
	 @Then("^Verify that user is succesfully logged in$")
	 public void Verify_User_Logged() throws Throwable {
		   Assert.assertTrue(menuPage.getGreetingsText().toLowerCase().contains("hi"));
	  }

}
