package com.catfactninja.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class CommonSteps extends TestBase {
    @Given("user logged in with {string} credentials")
    public void userLoggedInWithCredentials(String authorize) {
        getAppLibrary().getApiLibrary().getApiBasePage().setAuthorization(Boolean.parseBoolean(authorize));
    }

    @Then("user verify that status code: {string}")
    public void verifyThatUserShouldAbleToSee(String expectedStatusCode) {
        String actualStatusCode = String.valueOf(getAppLibrary().getApiLibrary().getApiBasePage().getResponse().getStatusCode());
        Assert.assertEquals(expectedStatusCode, actualStatusCode);
    }
}
