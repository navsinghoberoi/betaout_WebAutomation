# betaout_WebAutomation

# WebAutomationProject :

For every ui/backend release, QA team needs to run sanity/regression tests manually everytime. This website automation repo will help in saving time and efforts by running automation tests whenever required.


# Getting Started :

Below mentioned instructions will get you a copy of the project up and running on your local machine for testing purposes.


# Prerequisites :

Clone the repository via ssh/http.


# Running the tests :

Automated tests : To run the automated tests, follow the steps -

Go to the folder -- cd betaout_WebAutomation/ You will see two files a) testng.xml b) run.bat 
You can now proceed to run the automated tests


# Built With :

Selenium Webdriver, Java, TestNG


# Authors :

Navpreet Singh


# Add test cases :

Remember below mentioned points before creating new pages or scenarios -- 
Page class should be created in betaout_WebAutomation/betaout_WebAutomation/src package by creating a package with suffix as Pages. For ex CartRecoveryPages.
Scenario class should be created in betaout_WebAutomation/betaout_WebAutomation/src package by creating a package with suffix as Scenarios. For ex CartRecoveryScenarios.


# NOTE : This repo is used for CI purposes via Jenkins. After runnging all the testcases, email (with tests report) is sent to the client.
