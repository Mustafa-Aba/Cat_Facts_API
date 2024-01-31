package com.catfactninja.pages;

import com.catfactninja.utility.ConfigReader;
import com.catfactninja.utility.library.RestAPILibrary;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.HashMap;
import java.util.Map;

public class ApiBasePage extends RestAPILibrary {
    private static Response response;
    private boolean authorization;
    Map<String, String> headers = new HashMap<>();

    public void setAuthorization(boolean authorize) {
        this.authorization = authorize;
    }

    public boolean getAuthorization() {
        return authorization;
    }

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }

    public Response getResponse(RequestSpecification request, String method, String url, String body, Map<String, String> cookies) {
        headers.put("accept", "application/json");
        if (getAuthorization()) {
            headers.put("X-CSRF-TOKEN", ConfigReader.getProperty("access_token"));
        } else
            headers.put("Authorization", null);
        return makeRequest(request, method, url, body, headers, cookies);
    }
}



