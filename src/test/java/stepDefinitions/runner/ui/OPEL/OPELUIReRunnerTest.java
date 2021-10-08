package stepDefinitions.runner.ui.OPEL;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(features = "@src/test/resources/OPELprojectFailedReport/failed-UI-Report/failed.txt",
        glue = "OPEL.opelStepDefinitions",
        plugin = {"pretty", "json:target/cucumber-rerun-reports/Cucumber.json"},
        dryRun = false,
        monochrome = true,
        strict = true,
        tags = {"@Smoke"})

public class OPELUIReRunnerTest {
}
