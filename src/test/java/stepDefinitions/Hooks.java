package stepDefinitions;

import context.TestContext;
import cucumber.api.java.After;
import cucumber.api.java.Before;
 
// Hooks for before and after each scenario
public class Hooks {
 
 TestContext testContext;
 
 public Hooks(TestContext context) {
 testContext = context;
 }
 
 @Before
 public void BeforeSteps() {

 }
 
 @After
 public void AfterSteps() {
	 // close the browser
	 testContext.getWebDriverManager().closeDriver();
 }
 
}