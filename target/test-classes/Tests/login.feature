Feature: Login feature
#Description: The purpose of this feature is to test End 2 End integration.
 
Scenario: User login and logout successfully
	Given user is on Home Page
	And Clicks on login link in home Page
	When User enters "nikoszap@gmail.com" and "12345678" and logs in
	Then Verify that user is succesfully logged in
	When User logout
	Then Verify user is in the Home Page
	
Scenario: Negative test cases
	Given user is on Home Page
	And Clicks on login link in home Page
	When User enters "nikoszap@gmail.com" and "1" and logs in
	Then Verify that user is not logged in
