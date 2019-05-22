package stepDefinitions;

import org.junit.Assert;

import context.TestContext;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import dataObjects.Edible;
import pageObjects.EdiblesPage;;

//Step Definitions related to Edibles Page http://calories-calc.herokuapp.com/edibles
public class EdiblesPageSteps {

	TestContext testContext;
	EdiblesPage ediblesPage;
    World worldObj;
    int row_editEdible;
	
	 public EdiblesPageSteps(TestContext context, World world) {
			testContext = context;
			ediblesPage = testContext.getPageObjectManager().getEdiblesPage();
			worldObj = world;

		}

		@When("^User adds an edible \"([^\"]*)\" - \"([^\"]*)\" - \"([^\"]*)\"$")
		public void adds_an_edible(String foodName, String calories, String dateAdded) throws Throwable {

			worldObj.edible = new Edible(foodName, calories, dateAdded);
			ediblesPage.addEdible(foodName, calories, dateAdded);
		}

		
		@Then("^Verify that edible is added on the table$")
		public void verify_edible_is_added() throws Throwable {
		   int rowFound = ediblesPage.isthereEdibleOnTable(worldObj.edible.getfoodName());
		   Assert.assertTrue(rowFound!=-1);
		}

		
		@When("^User edit edible \"([^\"]*)\" and change to \"([^\"]*)\" - \"([^\"]*)\" - \"([^\"]*)\"$")
		public void Edit_Edible(String edibleName, String newFoodName, String newCalories, String newDate) throws Throwable {
		    // Write code here that turns the phrase above into concrete actions
			row_editEdible = ediblesPage.EditEdible(edibleName, newFoodName, newCalories, newDate);
			worldObj.edible = new Edible(newFoodName, newCalories, newDate);
		}

		@Then("^Verify that edible has changed$")
		public void Verify_Edible_Has_Changed() throws Throwable {
		    // Write code here that turns the phrase above into concrete actions
			
			String expectedFoodName = worldObj.edible.getfoodName();
			String expectedCalories = worldObj.edible.getCalories();
			Assert.assertEquals(expectedFoodName,  ediblesPage.GetTableCellValue(row_editEdible, "Name"));
			Assert.assertEquals(expectedCalories, ediblesPage.GetTableCellValue(row_editEdible, "Calories"));	
			
		}
		
		@When("^User Delete edible \"([^\"]*)\"$")
		public void Delete_Edible(String foodName) throws Throwable {
			ediblesPage.DeleteEdible(foodName);
			worldObj.edible = new Edible(foodName, "", "");
		}

		@Then("^Verify that edible is not in the tables$")
		public void Verify_edible_Not_Exist() throws Throwable {
		    // Write code here that turns the phrase above into concrete actions
			   int rowFound = ediblesPage.isthereEdibleOnTable(worldObj.edible.getfoodName());
			   Assert.assertTrue(rowFound==-1);
		}
		
		@Then("^Verify that edibles validation message colour is red$")
		public void Edibles_Validation_Msg_Red() throws Throwable {
		    // Write code here that turns the phrase above into concrete actions
		    Assert.assertFalse(ediblesPage.isCaloryBoxGreen());
		}
		
		@Then("^Verify that edibles validation message colour is green$")
		public void Edibles_Validation_Msg_Green() throws Throwable {
		    // Write code here that turns the phrase above into concrete actions
		    Assert.assertTrue(ediblesPage.isCaloryBoxGreen());
		}
		
		@And("^edibles table is empty$")
		public void Edibles_Table_Empty() throws Throwable {
		    // Write code here that turns the phrase above into concrete actions
			int rowFound = ediblesPage.isthereEdibleOnTable("Nothing found :(");
			System.out.println(rowFound);
			Assert.assertTrue(rowFound==1);
		}
		
		@And("^edibles table is not empty$")
		public void Edibles_Table_Not_Empty() throws Throwable {
		    // Write code here that turns the phrase above into concrete actions
			int rowFound = ediblesPage.isthereEdibleOnTable("Nothing found :(");
			System.out.println("is not empty....rowFound: "+rowFound);
			Assert.assertTrue(rowFound==-1);
		}
	
		@When("^User filter with start date \"([^\"]*)\" and end date \"([^\"]*)\"$")
		public void Filter_with_Date(String startDate, String endDate) throws Throwable {
		    // Write code here that turns the phrase above into concrete actions
			ediblesPage.FilterByDate(startDate, endDate);
		}

		@When("^User reset filter$")
		public void Reset_Filter() throws Throwable {
		    // Write code here that turns the phrase above into concrete actions
			ediblesPage.resetFilterBtn.click();
		}

		@Then("^Verify unprocessable entity error message appears$")
		public void Verify_Unprocessable_Entity_Msg() throws Throwable {
		    // Write code here that turns the phrase above into concrete actions
			Assert.assertTrue(ediblesPage.UnprocessableEntity());
		}
}
