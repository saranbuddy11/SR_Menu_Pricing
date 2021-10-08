package stepDefinitions.runner.ui.JLR;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(features = "@src/test/resources/JLRprojectFailedReport/failed-UI-Report/failed.txt",
        glue = "JLR.jlrUIStepDefinitions",
        plugin = {"pretty", "json:target/cucumber-rerun-reports/Cucumber.json"},
        dryRun = false,
        monochrome = true,
        strict = true,
        tags = {"@Smoke"})

public class JLRUISmokeReRunnerTest {
}
