package GMMP.gmAPIStepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import stepDefinitions.runner.AbstractAPITest;

public class BaseStepDefinitionTest extends AbstractAPITest {

    @When("send {string} request")
    public void send_request(String fileName) {
        xmlUtils.setTimeStampInXmlFile(getRequestBodyPath(fileName));
        response = apiPage.postMethodAPI(configuration.getDealerId(), configuration.getAPIUrl(), getRequestBodyPath(fileName));
    }

    @Then("Verify the GetGenericParts2 response Status code as {int}")
    public void verify_the_GetGenericParts2_response_Status_code_as(Integer statusCode) {
        xmlResponseAssertion.assertGetJobDetailsAPIStatusCode(response, statusCode);
    }

    @Then("match response Envelope not contains {string}")
    public void match_response_Envelope_not_contains(String fault) {
        baseAssertion.assertSOAPFaultStatus(response, fault);
    }

    @Then("Verify the {string} response description as {string}")
    public void verify_the_response_description_as(String elementPath, String description) {
        baseAssertion.assertResponseDescription(response, elementPath, description);
    }

    @Then("assert responseTime < {string} or {string}")
    public void assert_responseTime_or(String uatDuration, String qaDuration) {
        String duration = null;
        if (environment.contains("qa")) {
            duration = qaDuration;
        } else if (environment.contains("uat")) {
            duration = uatDuration;
        }
        baseAssertion.assertIfResponseTimeLessThan3000(response, duration);
    }

    @When("send {string} request 1")
    public void send_request_1(String fileName) {
        String fName = null;
        int count = fileName.length();
        if (environment.contains("qa")) {
            fName = fileName.substring(0, count - 3);
        } else {
            fName = fileName;
        }
        xmlUtils.setTimeStampInXmlFile(getRequestBodyPath(fName));
        response = apiPage.postMethodAPI(configuration.getDealerId(), configuration.getAPIUrl1(), getRequestBodyPath(fName));
    }

    @When("send {string} request 2")
    public void send_request_2(String fileName) {
        String fName = null;
        int count = fileName.length();
        if (environment.contains("qa")) {
            fName = fileName.substring(0, count - 3);
        } else {
            fName = fileName;
        }
        xmlUtils.setTimeStampInXmlFile(getRequestBodyPath(fName));
        response = apiPage.postMethodAPI(configuration.getDealerId(), configuration.getAPIUrl2(), getRequestBodyPath(fName));
    }

    @Then("Verify the requested job response Promo type as {string} for {int}")
    public void verify_the_requested_job_response_Promo_type_as_for(String promoType, Integer index) {
        baseAssertion.assertIfPromoTypeFlagVisible(response, index, promoType);
    }

    @Then("Verify the requested job response Promo type as {string}")
    public void verify_the_requested_job_response_Promo_type_as(String promoType) {
        for (int i = 0; i <= 10; i++) {
            baseAssertion.assertIfPromoTypeFlagVisible(response, i, promoType);
        }
    }
}
