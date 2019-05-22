Feature: End to End scenarios
Scenario Outline: Login add, edit, delete an edible and logout
	Given user is on Home Page
	And Clicks on register link in home Page
	When User register with <username>,<mail>,<password>,<confirmpassword>
	Then Verify that user is succesfully logged in
	And edibles table is empty
	When User adds an edible "makaronia" - "245" - "24032019-2130"
	Then Verify that edible is added on the table
	When User edit edible "makaronia" and change to "makaronia2" - "300" - "26032018-2145"
	Then Verify that edible has changed
	When User Delete edible "makaronia2"
	Then Verify that edible is not in the tables
	When User logout
	Then Verify user is in the Home Page  
Examples:
|username|mail|password|confirmpassword|
|pas|pas@gmail.com|12345678|12345678|
