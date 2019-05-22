Feature: Edibles add,edit,delete, filter
# Date format: ddmmyyyy-hhmm 
 
Background: User navigates to Company home page
	Given user is on Home Page
	And Clicks on login link in home Page
	When User enters "nikoszap@gmail.com" and "12345678" and logs in
	Then Verify that user is succesfully logged in
	
Scenario: Add an edible
	Given edibles table is empty
	When User adds an edible "makaronia" - "245" - "24032019-2130"
	Then Verify that edible is added on the table

Scenario: Filter edible
	When User filter with start date "24032016" and end date "24032018"
	Then edibles table is empty
	When User reset filter
	Then edibles table is not empty
	
Scenario: Edit an edible
	When User edit edible "makaronia" and change to "makaronia2" - "300" - "26032018-2145"
	Then Verify that edible has changed
	
Scenario: Delete an edible
	When User Delete edible "makaronia2"
	Then Verify that edible is not in the tables
	
Scenario: Add an empty edible
	Given edibles table is empty
	When User adds an edible "makaronia" - " " - " "
	Then Verify unprocessable entity error message appears
