package stepDefinitions.runner.ui.JLR;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(features = "src/test/resources/features/ui",
        glue = "GM.gmStepDefinitions",
        plugin = {"pretty", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:", "json:target/cucumber-reports/Cucumber.json", "rerun:src/test/resources/JLRProjectFailedReport/failed-UI-Report/failed.txt"},
        dryRun = false,
        monochrome = true,
        strict = true,
        tags = {"@JLRRegression"})

public class JLRUIRegressionRunnerTest {
}