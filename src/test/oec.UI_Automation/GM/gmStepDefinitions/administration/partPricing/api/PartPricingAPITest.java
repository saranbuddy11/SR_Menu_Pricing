package GM.gmStepDefinitions.administration.partPricing.api;

import base.FunctionalLibrary;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import stepDefinitions.runner.AbstractAPITest;
import java.util.List;

public class PartPricingAPITest extends AbstractAPITest {

    @When("Run {string} request in SOAP {string} job ID {string}")
    public void run_request_in_SOAP_job_ID(String xmlPath, String vinNo, String jobID) {
        xmlUtils.setValuesInXmlFile(getRequestBodyPath(xmlPath), jobID, vinNo);
        response = apiPage.postMethodAPI(configuration.getDealerId(), configuration.getAPIUrl(), getRequestBodyPath(xmlPath));
        System.out.println("response" + response);
    }

    @Then("In response price should be also {string}")
    public void in_response_price_should_be_also(String price) {
        xmlResponseAssertion.assertGetJobDetailsAPIStatusCode(response, 200)
                .assertResponsePartPrice(response, price);
    }

    @Then("In response price should be {string}")
    public void in_response_price_should_be(String expectedResult) {
        xmlResponseAssertion.assertGetJobDetailsAPIStatusCode(response, 200)
                .assertResponsePartPriceDMS(response, expectedResult);
    }

    @Then("In response total price should be also {string},{string}")
    public void in_response_total_price_should_be_also(String description, String price) {
        xmlResponseAssertion.assertGetJobDetailsAPIStatusCode(response, 200)
                .assertResponseMMRuleTotalPrice(response, price)
                .assertResponseMMRuleJobDescription(response, description);
    }

    @Then("In response single labour price should be {string}")
    public void in_response_single_labour_price_should_be(String expectedPrice) {
        xmlResponseAssertion.assertGetJobDetailsAPIStatusCode(response, 200)
                .assertResponseSingleLabourPrice(response, expectedPrice);
    }

    @Then("In response verify {string} with description {string}")
    public void in_response_verify_with_description(String tag, String description) {
        xmlResponseAssertion.assertGetJobDetailsAPIStatusCode(response, 200)
                .assertResponseLinkedJobsDescription(response, description, tag);
    }

    @When("Run {string} request in SOAP with VIN {string} job ID {string}")
    public void run_request_in_SOAP_with_VIN_job_ID(String xmlPath, String vinNo, String jobID) {
        xmlUtils.setValuesInXmlFile(getRequestBodyPath(xmlPath), jobID, vinNo);
        response = apiPage.postMethodAPI(configuration.getMMDealerID(), configuration.getAPIUrl(), getRequestBodyPath(xmlPath));
        logger.info(response);
    }

    @Then("In response verify {string} with code {string} and price {string}")
    public void in_response_verify_with_code_and_price(String promotion, String code, String priceFixedAt) {
        xmlResponseAssertion.assertGetJobDetailsAPIStatusCode(response, 200)
                .assertResponsePromotionCode(response, code, promotion)
                .assertResponsePromotionPrice(response, priceFixedAt, promotion);
    }

    @Then("In response verify {string} with attributes {string}, {string}, {string}, {string}")
    public void in_response_verify_with_attributes(String tagName, String priceExTax, String priceIncTax, String priceFixed, String type, io.cucumber.datatable.DataTable dataTable) {
        List<String> expectedData = dataTable.asList();
        xmlResponseAssertion.assertResponseLaboursAttribute(response, tagName, priceExTax, expectedData.get(0))
                .assertResponseLaboursAttribute(response, tagName, priceIncTax, expectedData.get(1))
                .assertResponseLaboursAttribute(response, tagName, priceFixed, expectedData.get(2))
                .assertResponseLaboursAttribute(response, tagName, type, expectedData.get(3));
    }

    @Then("In response verify {string} with attributes {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}")
    public void in_response_verify_with_attributes(String tagName, String id, String labourAlgoCode, String desc, String text, String DTU, String labourRate, String adLabourRate, String labourValue, io.cucumber.datatable.DataTable dataTable) {
        List<String> expectedData = dataTable.asList();
        xmlResponseAssertion.assertResponseLabourAttribute(response, tagName, id, expectedData.get(0))
                .assertResponseLabourAttribute(response, tagName, labourAlgoCode, expectedData.get(1))
                .assertResponseLabourAttribute(response, tagName, desc, expectedData.get(2))
                .assertResponseLabourAttribute(response, tagName, text, expectedData.get(3))
                .assertResponseLabourAttribute(response, tagName, DTU, expectedData.get(4))
                .assertResponseLabourAttribute(response, tagName, labourRate, expectedData.get(5))
                .assertResponseLabourAttribute(response, tagName, adLabourRate, expectedData.get(6))
                .assertResponseLabourAttribute(response, tagName, labourValue, expectedData.get(7));
    }

    @Then("In response verify job {string} with description {string} contains {string}")
    public void in_response_verify_job_with_description(String tag, String attributeName, String value) {
        xmlResponseAssertion.assertGetJobDetailsAPIStatusCode(response, 200)
                .assertResponseJobAttribute(response, tag, attributeName, value);
    }

    @Then("In response verify {string} with {string} contains {string}")
    public void in_response_verify_with_attributes(String tagName, String attributeName, String value) {
        xmlResponseAssertion.assertResponseLaboursAttribute(response, tagName, attributeName, value);
    }

    @Then("In response verify the value in {string} tag in {string}")
    public void in_response_verify_the_value_in_tag_in(String attributeName, String tagName) {
        String partPrice = FunctionalLibrary.partprice;
        xmlResponseAssertion.assertResponsePartsListAttribute(response, attributeName, tagName, partPrice);
    }

    @Then("In response verify the value {string} for the child {string}")
    public void in_response_verify_the_value_for_the_child(String value, String tagName) {
        xmlResponseAssertion.assertResponseChildValue(response, tagName, value);
    }
}