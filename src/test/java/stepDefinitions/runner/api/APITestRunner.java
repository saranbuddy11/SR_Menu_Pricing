package stepDefinitions.runner.api;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features/api", glue = "apiStepDefinitions", plugin = {"pretty", "json:target/cucumber-reports/Cucumber.json", "rerun:src/test/resources/projectFailedReport/failed-API-Report/failed.txt"}, dryRun = false, monochrome = true, strict = true, tags = {"Skeleton"})
public class APITestRunner {
}
