package GM.gmAssertion;

import GMMP.gmAPIObjectRepository.APIPage;
import io.restassured.response.Response;

import static org.assertj.core.api.Assertions.assertThat;

public class XmlResponseAssertion {

    APIPage apiPage = new APIPage();

    public XmlResponseAssertion assertGetJobDetailsAPIStatusCode(Response response, int statusCode) {
        assertThat(apiPage.getPostMethodStatusCode(response))
                .as("Verify the Status Code for Get Job Details Request").isEqualTo(statusCode);
        return this;
    }

    public XmlResponseAssertion assertResponsePartPrice(Response response, String price) {
        assertThat(apiPage.getResponsePartPrice(response))
                .as("Verify Part price value from the Response").contains(price);
        return this;
    }

    public XmlResponseAssertion assertResponseStatusDescription(Response response, String description) {
        assertThat(apiPage.getResponseStatusDescription(response))
                .as("Verify status description from the Response").contains(description);
        return this;
    }

    public XmlResponseAssertion assertResponsePartPriceDMS(Response response, String expectedValue) {
        assertThat(apiPage.getResponsePartPriceForDMS(response))
                .as("Verify Part price value from the Response").contains(expectedValue);
        return this;
    }

    public XmlResponseAssertion assertResponseSingleLabourPrice(Response response, String expectedValue) {
        assertThat(apiPage.getResponseSingleLabourPrice(response))
                .as("Verify Single labour price value from the Response").contains(expectedValue);
        return this;
    }

    public XmlResponseAssertion assertResponseMMRuleTotalPrice(Response response, String price) {
        assertThat(apiPage.getResponseMMRuleTotalPrice(response))
                .as("Verify MMRule Total Price from the Response").contains(price);
        return this;
    }
    public XmlResponseAssertion assertResponseMMRuleJobDescription(Response response, String desc) {
        assertThat(apiPage.getResponseMMRuleJobDescription(response))
                .as("Verify MMRule Job Description from the Response").contains(desc);
        return this;
    }

    public XmlResponseAssertion assertResponseLinkedJobsDescription(Response response, String desc, String tag) {
        assertThat(apiPage.getResponseDescriptionLinkedJobs(response, tag))
                .as("Verify linked Job Description from the Response").contains(desc);
        return this;
    }

    public XmlResponseAssertion assertResponsePromotionCode(Response response, String code, String tag) {
        assertThat(apiPage.getResponsePromotioncode(response, tag))
                .as("Verify promotion code from the Response").contains(code);
        return this;
    }

    public XmlResponseAssertion assertResponsePromotionPrice(Response response, String price, String tag){
        assertThat(apiPage.getResponsePromotionPrice(response, tag))
                .as("Verify promotion price from the response").contains(price);
        return this;
    }

    public XmlResponseAssertion assertResponseLaboursAttribute(Response response, String tabName, String attributeName, String value){
        assertThat(apiPage.getResponseLabours(response, tabName, attributeName))
                .as("Verify Labours attribute from the response").contains(value);
        return this;
    }

    public XmlResponseAssertion assertResponseLabourAttribute(Response response, String tabName, String attributeName, String value){
        String attribute = apiPage.getAttributeLabour(response, tabName, attributeName);
        assertThat(apiPage.getAttributeLabour(response, tabName, attributeName))
                .as("Verify Labour attribute from the response").contains(value);
        return this;
    }

    public XmlResponseAssertion assertResponseJobAttribute(Response response, String tabName, String attributeName, String value){
        assertThat(apiPage.getJobAttribute(response, tabName, attributeName))
                .as("Verify job attribute from the response").contains(value);
        return this;
    }

    public XmlResponseAssertion assertResponsePartsListAttribute(Response response, String attributeName, String tagName, String value){
        assertThat(apiPage.getPartsListAttribute(response, tagName, attributeName))
                .as("Verify PartsList attribute from the response").contains(value);
        return this;
    }

    public XmlResponseAssertion assertResponseChildValue(Response response, String tagName, String value){
        assertThat(apiPage.getChildValue(response, tagName))
                .as("Verify PartsList attribute from the response").contains(value);
        return this;
    }

}
