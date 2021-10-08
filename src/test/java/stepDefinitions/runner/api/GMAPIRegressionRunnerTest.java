package stepDefinitions.runner.api;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(features = "src/test/resources/features/api/Regression/GMMP",
        glue = "GMMP.gmAPIStepDefinitions",
        plugin = {"pretty", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:", "json:target/cucumber-reports/Cucumber.json", "rerun:src/test/resources/GMprojectFailedReport/failed-UI-Report/failed.txt"},
        dryRun = false,
        monochrome = true,
        strict = true,
        tags = {"@API"})

public class GMAPIRegressionRunnerTest {
}