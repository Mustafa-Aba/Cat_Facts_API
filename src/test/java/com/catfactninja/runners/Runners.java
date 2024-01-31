package com.catfactninja.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        //dryRun = true,
        monochrome = true,
        features = {"src/test/resources/Features/"},
        glue = {"com/catfactninja/stepdefinitions"},
        tags = "@API",
        plugin = {"pretty","json:target/reports/cucumber.json",
                "html:target/reports/default-report.html",
                "rerun:target/reports/failed-reports/failed.txt"}
)
public class Runners {
}
