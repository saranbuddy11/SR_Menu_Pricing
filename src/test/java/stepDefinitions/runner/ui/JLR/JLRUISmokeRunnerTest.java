package stepDefinitions.runner.ui.JLR;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(features = "src/test/resources/features/ui/JLR",
        glue = "JLR.jlrStepDefinitions",
        plugin = {"pretty","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:", "json:target/cucumber-reports/Cucumber.json", "rerun:src/test/resources/JLRprojectFailedReport/failed-UI-Report/failed.txt"},
        dryRun = false,
        monochrome = true,
        strict = true,
        tags = {"@Smoke"})

public class JLRUISmokeRunnerTest {
}
