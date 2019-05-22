# -BDD-Java---Cucumber-framework

The code is inside the zip file.
A BDD (Java - Cucumber) framework is developed.
1. Java 1.8
2. maven
3. selenium web driver
4. junit

• Feature files
Location: src/test/resources/Tests

• Configuration file  (configs directory)
The properties file contains parameters for the design of the WebDriver Manager

• Packages under the src/test/java folder
1. stepDefinitions:
The definitions of the feature files 
2. runners :
The test runner 
3. dataObjects: 
The definition of the object that is used in order to share state between steps in cucumber (PicoContainer (http://picocontainer.com/ ) a Dependency Injection container)


• Packages under the src/test/java folder 
1. context: 
It contains the TestContext class which holds all the objects state (Sharing Test Context between Cucumber Step Definitions) 
 
2. enums 
3. managers 
  - a manager class for the page Objects (PageObjectManager.java) 
  - a manager class for the web driver (WebDriverManager.java) 
  - a manager class for the properties (FileReaderManager.java) 
4. pageObjects:
The page Object model (https://martinfowler.com/bliki/PageObject.html ) is used and is implemented using the Selenium page object factory. 5. Providers:
It contains a class for reading the configuration parameters.


How to run the tests? 

Navigate to the location of the project and run the following command
mvn test -Dcucumber.options="src/test/resources/Tests/<<feature-file-name>>.feature"
