package com.herokuapp;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"json:target/cucumber-report.json", "pretty"},
        glue = "com.herokuapp",
        strict = true
       // tags ="@positive_login" //   or mvn test -Dcucumber.options="--tags @login" in order to run the @login steps only
)
public class RunCukesTest {
}

