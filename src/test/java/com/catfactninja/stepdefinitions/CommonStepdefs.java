package com.catfactninja.stepdefinitions;

import com.catfactninja.utility.helper.LoggerHelper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.apache.log4j.Logger;
import org.junit.Assert;


public class CommonStepdefs extends TestBase {


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
