Feature: profile page
Background: User log in
	Given user is on Home Page
	And Clicks on login link in home Page
	When User enters "nikoszap@gmail.com" and "12345678" and logs in
	Then Verify that user is succesfully logged in
	And edibles table is empty

Scenario: Set Max Calories to zero 
	Given User navigate to profile page
	And set profile MaxCalories to "0"
	When User navigate to edibles page
	Then Verify that edibles validation message colour is red

Scenario: Maximize profile calories 
	Given User navigate to profile page
	And set profile MaxCalories to "200"
	When User navigate to edibles page
	Then Verify that edibles validation message colour is green

	