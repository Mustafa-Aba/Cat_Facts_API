package com.catfactninja.stepdefinitions;

import com.catfactninja.utility.ConfigReader;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class FactsStepdefs extends TestBase {
    RequestSpecification request = given();
    static int expectedLimit;
    static int expectedMaxLength;

    @When("user send {string} request with given {string} and {string} to get random fact")
    public void userSendRequestWithGivenAndToGetRandomFact(String method, String endPoint, String body) {
        String url = ConfigReader.getProperty("baseUrl") + endPoint;
        getAppLibrary().getApiLibrary().getFactsPage().setMaxLengthParameter();
        expectedMaxLength = getAppLibrary().getApiLibrary().getFactsPage().getMax_length();
        request.queryParam("max_length", expectedMaxLength);
        getAppLibrary().getApiLibrary().getApiBasePage().setResponse(getAppLibrary().getApiLibrary().getApiBasePage().getResponse(request, method, url, body, null));
        getAppLibrary().getApiLibrary().getApiBasePage().getResponse().prettyPrint();
    }

    @When("user send {string} request with given {string} and {string} to get a list of facts")
    public void userSendRequestWithGivenAndToGetAListOfFacts(String method, String endPoint, String body) {
        String url = ConfigReader.getProperty("baseUrl") + endPoint;
        getAppLibrary().getApiLibrary().getFactsPage().setMaxLengthParameter();
        expectedMaxLength = getAppLibrary().getApiLibrary().getFactsPage().getMax_length();
        getAppLibrary().getApiLibrary().getFactsPage().setLimitParameter();
        expectedLimit = getAppLibrary().getApiLibrary().getFactsPage().getLimit();
        request.queryParams("limit", expectedLimit, "max_length", expectedMaxLength);
        getAppLibrary().getApiLibrary().getApiBasePage().setResponse(getAppLibrary().getApiLibrary().getApiBasePage().getResponse(request, method, url, body, null));
        getAppLibrary().getApiLibrary().getApiBasePage().getResponse().prettyPrint();
    }

    @Then("validate that the Response contains expected fields\\(Fact,Length) and valid data type")
    public void validateThatTheResponseContainsExpectedFieldsFactLengthAndValidDataType() {
        Response response = getAppLibrary().getApiLibrary().getApiBasePage().getResponse();
        response.then().assertThat().body("length", lessThanOrEqualTo(((expectedMaxLength))));
        response.then().assertThat().body("fact", notNullValue());
        response.then().assertThat().body("length", notNullValue());
        response.then().assertThat().body("fact", instanceOf(String.class));
        response.then().assertThat().body("length", instanceOf(Number.class));
    }

    @Then("validate that the Response contains a list of facts with the specified fields and valid data")
    public void validateThatTheResponseContainsAListOfFactsWithTheSpecifiedFieldsAndValidData() {
        Response response = getAppLibrary().getApiLibrary().getApiBasePage().getResponse();
        int itemCount = response.path("data.size()");
        Assert.assertTrue(itemCount <= expectedLimit);
        response.then().assertThat().body("data.fact", everyItem(notNullValue()));
        response.then().assertThat().body("data.length", everyItem(lessThanOrEqualTo(((expectedMaxLength)))));
    }
}
