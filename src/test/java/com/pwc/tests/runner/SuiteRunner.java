package com.pwc.tests.runner;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features/pwc",tags = {"@gui"},plugin = {"pretty","com.epam.reportportal.cucumber.ScenarioReporter","json:target/cucumber-report/SuiteRunner/cucumber.json",
        "rerun:target/cucumber-report/SuiteRunner/rerun.txt"},glue = "com.pwc.tests.steps")
public class SuiteRunner {
}