package stepDefinitions.runner.api;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "@src/test/resources/projectFailedReport/failed-API-Report/failed.txt", glue = "stepDefinitions", plugin = {"pretty", "json:target/cucumber-rerun-reports/Cucumber.json"}, dryRun = false, monochrome = true, strict = true, tags = {})
public class APITestReRunner {
}
