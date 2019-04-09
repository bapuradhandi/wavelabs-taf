package com.pwc.tests.steps;


import com.taf.test.framework.helpers.UrlBuilder;
import cucumber.api.java.en.Given;

public class NavigationSteps {

    @Given("^user launches pwc portal$")
    public void userLaunchesHireAlchemyPortal() throws Throwable {
        UrlBuilder.startAtHomePage();
    }


    @Given("^user launches portal$")
    public void userLaunchesPortal() throws Throwable {
        UrlBuilder.startAtHomePage();
    }
}