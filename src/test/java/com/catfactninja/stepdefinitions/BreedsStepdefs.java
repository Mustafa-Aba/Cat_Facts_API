package com.catfactninja.stepdefinitions;

import com.catfactninja.utility.ConfigReader;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class BreedsStepdefs extends TestBase {
    RequestSpecification request = given();
    static int expectedLimit;

    @When("user send {string} request with given {string} and {string} to get a list of breeds")
    public void userSendRequestWithGivenAndToGetAListOfBreeds(String method, String endPoint, String body) {
        String url = ConfigReader.getProperty("baseUrl") + endPoint;
        getAppLibrary().getApiLibrary().getBreedsPage().setLimitParameter();
        expectedLimit = getAppLibrary().getApiLibrary().getBreedsPage().getLimit();
        request.queryParam("limit", expectedLimit);
        getAppLibrary().getApiLibrary().getApiBasePage().setResponse(getAppLibrary().getApiLibrary().getApiBasePage().getResponse(request, method, url, body, null));
        getAppLibrary().getApiLibrary().getApiBasePage().getResponse().prettyPrint();
    }

    @Then("validate that the Response contains a list of breeds with the specified fields and valid data")
    public void validateThatTheResponseContainsAListOfBreedsWithTheSpecifiedFieldsAndValidData() {
        Response response = getAppLibrary().getApiLibrary().getApiBasePage().getResponse();
        int itemCount = response.path("data.size()");
        Assert.assertTrue(itemCount <= expectedLimit);
        List<Map<String, String>> dataList = response.jsonPath().getList("data");
        for (Map<String, String> item : dataList) {
            assert item.containsKey("breed");
            assert item.containsKey("country");
            assert item.containsKey("origin");
            assert item.containsKey("coat");
            assert item.containsKey("pattern");
        }
        Assert.assertEquals("Abyssinian", dataList.get(0).get("breed"));
        Assert.assertEquals("Ethiopia", dataList.get(0).get("country"));
        Assert.assertEquals("Natural/Standard", dataList.get(0).get("origin"));
        Assert.assertEquals("Short", dataList.get(0).get("coat"));
        Assert.assertEquals("Ticked", dataList.get(0).get("pattern"));
    }
}
