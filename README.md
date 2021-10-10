# HomeAssigment
This project covers E2E test for miro Sign Up process and Sign Up page elements functionality test.

# Built With
Language and libraries being used for the project
- Java 8
- Junit5 framework
- Selenium
- Hamcrest
- Allure report

#Getting started
## Prerequisites
This project uses chromeDriver. In order to launch it, you need to install chrome browser. By default the project configured to work with chrome version 94. If your version of chrome differs, please do the following:
1. Check your browser version
2. set different version in setupTest.WebDriverLauncher class like this:
```java
WebDriverManager.chromedriver().browserVersion("<YOUR CHROME VERSION>").setup();
```
  
## How to launch tests and see results
For local launch of tests open the project in IDE (Intellij Idea recommended) and put in terminal
   mvn clean test allure:serve
As a result
1. all the necessary libraries will be downloaded by maven
2. Test suite will be executed 
3. Selenium report genereated and automaticaly opened
