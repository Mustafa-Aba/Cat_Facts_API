package com.catfactninja.utility.library;

public class AppLibrary {
    private APILibrary apiLibrary;
    private RestAPILibrary restAPILibrary;

    public AppLibrary() {
        apiLibrary = new APILibrary();
        restAPILibrary = new RestAPILibrary();
    }

    public APILibrary getApiLibrary() {
        return apiLibrary;
    }

    public RestAPILibrary getRestAPILibrary() {
        return restAPILibrary;
    }
}
