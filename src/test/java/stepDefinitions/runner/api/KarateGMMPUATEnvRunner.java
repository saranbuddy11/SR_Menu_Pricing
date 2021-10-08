package stepDefinitions.runner.api;

import com.intuit.karate.junit5.Karate;
import utils.SchemaValidator;

class KarateGMMPUATEnvRunner {

    // this will run all *.feature files that exist in sub-directories
    // see https://github.com/intuit/karate#naming-conventions   
    @Karate.Test
    Karate testAll() {
        return Karate.run("classpath:features/api/UAT/GMMP").relativeTo(SchemaValidator.class);
    }
}