package stepDefinitions.runner;

import GM.gmAssertion.XmlResponseAssertion;
import GMMP.gmAPIAssertion.BaseAssertion;
import GMMP.gmAPIObjectRepository.APIPage;
import base.Excel;
import base.FunctionalLibrary;
import io.restassured.response.Response;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import utilsBrowser.XmlUtils;
import utilsBrowser.configuration.Configuration;
import utilsBrowser.configuration.ConfigurationProvider;

public abstract class AbstractAPITest {

    public static final String environment = getEnvironment();

    protected static ConfigurationProvider configurationProvider = new ConfigurationProvider();
    protected Configuration configuration = configurationProvider.getConfiguration(environment);
    protected XmlResponseAssertion xmlResponseAssertion = new XmlResponseAssertion();
    protected BaseAssertion baseAssertion = new BaseAssertion();
    protected XmlUtils xmlUtils = new XmlUtils();
    protected Response response;
    protected APIPage apiPage = new APIPage();
    protected Excel excel = new Excel();
    public Log logger = LogFactory.getLog(FunctionalLibrary.class);

    private static String getEnvironment() {
        return System.getProperty("environment");
    }

    public String getRequestBodyPath(String xmlPath) {
        String requestBodyPath = "src/test/resources/apiXml/" + xmlPath + ".xml";
        return requestBodyPath;
    }

    public String getRequestBodyDataValidationPath(String xmlPath) {
        String requestBodyPath = "src/test/resources/apiXml/GMMP/DataValidation/" + xmlPath + ".xml";
        return requestBodyPath;
    }

    public String getEnvironmentType() {
        String env = null;
        if (getEnvironment().contains("uat")) {
            env = "UAT";
        } else if (getEnvironment().contains("prd")) {
            env = "PROD";

        } else if (getEnvironment().contains("qa")) {
            env = "QC";
        }
        return env;
    }
}
