package com.herokuapp;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.junit.runner.RunWith;
import org.testng.annotations.DataProvider;

/*
Test​ ​Automation​ ​Engineer​ ​|​ ​Candidate​ ​Task

Thank you for applying for the Test Automation Engineer vacancy at Quandoo. In efforts to have a general
understanding of your level of expertise, we would like to proceed with an assessment that will give you the chance to
show Quandoo that you are a battle proven Engineer!
The​ ​Task:
We need you to execute test on the following page: http://the-internet.herokuapp.com/
The test should cover the 5 following scenarios:
1.​ ​scenario​ ​Login​ ​Success
- go to http://the-internet.herokuapp.com/login
- fill in valid user credentials (they are displayed on the page)
- after login, verify that the text partial „You logged into a secure area is present“ is displayed in the browser
2.​ ​ ​scenario​ ​Login​ ​failure​ ​1
- go to http://the-internet.herokuapp.com/login
- fill in wrong user name (anything but „tomsmith“)
- after click on login button, verify that the text partial „Your username is invalid“ is displayed in the browser
3.​ ​ ​scenario​ ​Login​ ​failure​ ​2
- go to http://the-internet.herokuapp.com/login
- fill in correct username but wrong password
- after click on login button, verify that the text partial „Your password is invalid“ is displayed in the browser
4.​ ​scenario​ ​Hovers
- go to http://the-internet.herokuapp.com/hovers
- hover over the 3 avatar pictures
- verify that the username „user1“, „user2“, etc... is displayed as soon as the hover is triggered
5.​ ​scenario​ ​sortable​ ​data​ ​table
- go to http://the-internet.herokuapp.com/tables
- main element to test is table „Example 2“
- test should show, that if you order this table by „Last Name“ in an ascending AND descending order, that the
displayed last names are ordered alphabetically in an ascending and descending order
Goals:
The framework should include a small documentation. The doc should contain:
- the technology stack that is used (e.g. Java, Webdriver, Cucumber)
- a small documentation about how to make the framework work and how to execute the test. The
documentation can have 2 formats. .txt or .md (Markdown). All others will be not accepted anymore.
- the test execution should produce at least ONE report file in one of the following formats: JSON, Html, XML
Good luck!

Once you’re done please send us a link to a github or bitbucket repo (no zip files will be accepted) with your work to:
assessment.submittal@quandoo.com
Sincerely,
Your Quandoo Team
 */
@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"json:target/cucumber-report.json", "pretty"},
        glue = "com.herokuapp",
        strict = true
       // tags ="@dom" //   or mvn test -Dcucumber.options="--tags @login" in order to run the @login steps only
)
public class RunCukesTest extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}

