package com.pwc.tests.steps;

import com.pwc.tests.pages.LandingPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.assertj.core.api.Assertions.assertThat;

public class LandingPageSteps {

    private LandingPage landingPage;

    public LandingPageSteps(LandingPage landingPage) {
        this.landingPage = landingPage;
    }

    @When("^user enters user name \"([^\"]*)\"$")
    public void userEntersUserName(String userName) throws Throwable {
        landingPage.enterUserName(userName);
    }

    @And("^user enters password \"([^\"]*)\"$")
    public void userEntersPassword(String password) throws Throwable {
        landingPage.enterPassword(password);
    }

    @When("^user clicks on sign in button$")
    public void userClicksOnSignInButton() throws Throwable {
        landingPage.clickOnSignInBtn();
    }
}

