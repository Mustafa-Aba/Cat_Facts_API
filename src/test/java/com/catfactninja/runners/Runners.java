package com.catfactninja.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        //dryRun = true,
        features = {"src/test/resources/Features/"},
        glue = {"com/catfactninja/stepdefinitions"},
        tags = "@API",
        plugin = {"json:target/cucumber.json",
                "html:target/default-report.html"}
)
public class Runners {
}
