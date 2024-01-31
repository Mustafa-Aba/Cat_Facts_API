package com.catfactninja.stepdefinitions;

import com.catfactninja.utility.library.AppLibrary;

public class TestBase {
    private AppLibrary appLibrary;

    public TestBase() {
        this.appLibrary = new AppLibrary();
    }

    public AppLibrary getAppLibrary() {
        return appLibrary;
    }

}
