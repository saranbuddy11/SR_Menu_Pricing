package stepDefinitions.runner.ui.MOPAR;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(features = "src/test/resources/features/ui/MOPAR",
        glue = "MOPAR.moparStepDefinitions",
        plugin = {"pretty", "json:target/cucumber-reports/Cucumber.json", "rerun:src/test/resources/MOPARprojectFailedReport/failed-UI-Report/failed.txt"},
        dryRun = false,
        monochrome = true,
        strict = true,
        tags = {"@Smoke"})

public class MOPARUIRunnerTest {
}
