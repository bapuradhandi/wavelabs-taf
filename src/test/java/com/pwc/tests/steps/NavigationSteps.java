package com.pwc.tests.steps;


import com.taf.test.framework.helpers.UrlBuilder;
import cucumber.api.java.en.Given;

public class NavigationSteps {

    @Given("^user launches pwc portal$")
    public void userLaunchesPwcPortal() throws Throwable {
        UrlBuilder.startAtHomePage();
    }


    @Given("^user launches api portal$")
    public void userLaunchesApiPortal() throws Throwable {
        UrlBuilder.startApiHomePage();
    }
    

}