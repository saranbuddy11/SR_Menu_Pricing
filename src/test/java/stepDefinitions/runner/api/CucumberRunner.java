package stepDefinitions.runner.api;

import com.intuit.karate.KarateOptions;
import com.intuit.karate.Results;
import com.intuit.karate.Runner;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import utils.SchemaValidator;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static junit.framework.TestCase.assertTrue;

@KarateOptions(tags = {"~@ignore"}, features = "src/test/java/oec/API_Automation")
public class CucumberRunner {

  @Test
  public void testParallel() {
    System.setProperty("mock.env", "karateTesting");
    Results results = Runner.parallel(SchemaValidator.class, 5);
    CucumberRunner.generateReport(results.getReportDir());
    assertTrue(results.getErrorMessages(), results.getFailCount() == 0);
  }

  public static void generateReport(String karateOutputPath) {
    Collection<File> jsonFiles = FileUtils.listFiles(new File(karateOutputPath), new String[] {"json"}, true);
    List<String> jsonPaths = new ArrayList(jsonFiles.size());
    jsonFiles.forEach(file -> jsonPaths.add(file.getAbsolutePath()));
    Configuration config = new Configuration(new File("target"), "karateTesting");
    ReportBuilder reportBuilder = new ReportBuilder(jsonPaths, config);
    reportBuilder.generateReports();
  }
}