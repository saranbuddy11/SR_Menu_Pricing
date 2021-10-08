package stepDefinitions.runner.ui.GM;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(features = "src/test/resources/features/ui/GM",
        glue = "GM.gmStepDefinitions",
        plugin = {"pretty", "json:target/cucumber-reports/Cucumber.json", "rerun:src/test/resources/GMprojectFailedReport/failed-UI-Report/failed.txt"},
        dryRun = false,
        monochrome = true,
        strict = true,
        tags = {"@Smoke"})

public class GMUIRunnerTest {
}
