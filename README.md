# shopist-automation-framework
This automation framework consists of test cases which covers the below scenarios in testing shopist website through Selenium (Java)

  1. Clicking on chairs and storing the price of first chair 
  2. Clicking on sofas and storing the price of first sofa
  3. Validating that the total price and price in cart are same

Pre-requisites:
  1. Install Java and IntelliJ
  2. Import maven dependencies in pom.xml file for selenium and testng
  3. Import dependencies to class path 

Folders and Files:
  1. configuration: Includes the base configuration to set-up driver and initiate tests
  2. resources: Includes test data file to provide and update user input (Update driver location in REPLACE_ME)
  3. utils: Includes WebDriver functionalities and config reader file to read input data
  4. pages and tests: Includes test cases and corresponding page objects

Test Execution:
ShopistAutomationTask.xml must be executed which includes the test class file.

