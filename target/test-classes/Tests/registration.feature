Feature: registration 
Scenario Outline: Positive test validating Registration
	Given user is on Home Page
	And Clicks on register link in home Page
	When User register with <username>,<mail>,<password>,<confirmpassword>
	Then Verify that user is succesfully logged in
   And edibles table is empty
Examples:
|username|mail|password|confirmpassword|
|nikoszap5|nikoszap5@gmail.com|12345678|12345678|

Scenario Outline: Negative test cases
	Given user is on Home Page
	And Clicks on register link in home Page
	When User register with <username>,<mail>,<password>,<confirmpassword>
	Then Verify Registration failed
Examples:
|username|mail|password|confirmpassword|
|n|n@gmail.com|1|1|
|nikoszap@gmail.com|nikoszap@gmail.com|12345678|12345678|
