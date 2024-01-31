package com.catfactninja.utility.library;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.Map;

public class RestAPILibrary {
    public Response makeRequest(RequestSpecification request, String method, String url, String payload, Map<String, String> headers, Map<String, String> cookies) {
        if (payload != null && !payload.isEmpty()) {
            request.body(payload);
        }
        if (headers != null && !headers.isEmpty()) {
            request.headers(headers);
        }
        switch (method.toUpperCase()) {
            case "GET":
                return request.get(url);
            case "POST":
                return request.post(url);
            case "PUT":
                return request.put(url);
            case "DELETE":
                return request.delete(url);
            default:
                throw new IllegalArgumentException("Invalid HTTP method: " + method);
        }
    }
}
