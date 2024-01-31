package com.catfactninja.stepdefinitions;


import com.catfactninja.utility.helper.LoggerHelper;
import com.catfactninja.utility.library.APILibrary;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.apache.log4j.Logger;

public class Hooks extends APILibrary {
    private static final Logger LOGGER = LoggerHelper.getLogger(Hooks.class);
    @Before
    public void beforeScenario() {
        LOGGER.info("Execution started");
    }

    @After
    public void afterScenario() {

        LOGGER.info("Execution finished");
    }

}
