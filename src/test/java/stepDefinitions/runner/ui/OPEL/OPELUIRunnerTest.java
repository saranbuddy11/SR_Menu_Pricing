package stepDefinitions.runner.ui.OPEL;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(features = "src/test/resources/features/ui/OPEL",
        glue = "OPEL.opelStepDefinitions",
        plugin = {"pretty", "json:target/cucumber-reports/Cucumber.json", "rerun:src/test/resources/OPELprojectFailedReport/failed-UI-Report/failed.txt"},
        dryRun = false,
        monochrome = true,
        strict = true,
        tags = {"@Smoke"})

public class OPELUIRunnerTest {
}
