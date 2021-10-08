package stepDefinitions.runner.ui.GM;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(features = "@src/test/resources/GMprojectFailedReport/failed-UI-Report/failed.txt",
        glue = "GM.gmStepDefinitions",
        plugin = {"pretty", "json:target/cucumber-rerun-reports/Cucumber.json"},
        dryRun = false,
        monochrome = true,
        strict = true,
        tags = {"@Smoke"})

public class GMUIReRunnerTest {
}
