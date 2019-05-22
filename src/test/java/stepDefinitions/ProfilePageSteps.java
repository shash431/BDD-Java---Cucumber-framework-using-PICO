package stepDefinitions;

import context.TestContext;
import cucumber.api.java.en.When;
import pageObjects.ProfilePage;

//Step Definitions related to Profile Page http://calories-calc.herokuapp.com/profile
public class ProfilePageSteps {

	TestContext testContext;
	ProfilePage profilePage;

	 public ProfilePageSteps(TestContext context) {
			testContext = context;
			profilePage = testContext.getPageObjectManager().getProfilePage();
	}

	 @When("^set profile MaxCalories to \"([^\"]*)\"$")
	 public void Set_Profile_MaxCalories(String maxCalories) throws Throwable {
	     // Write code here that turns the phrase above into concrete actions
		 profilePage.SetMaxCalories(maxCalories);
	 }
	 
	 
}
