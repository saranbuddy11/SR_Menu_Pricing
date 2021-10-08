package GMMP.gmAPIAssertion;

import GMMP.gmAPIObjectRepository.APIPage;
import io.restassured.response.Response;

import static org.assertj.core.api.Assertions.assertThat;

public class BaseAssertion extends APIPage {

    APIPage apiPage = new APIPage();

    public BaseAssertion assertSOAPFaultStatus(Response response, String fault) {
        assertThat(apiPage.getSOAPFault(response, fault)).as("Verify the SOAP fault Status").isFalse();
        return this;
    }

    public BaseAssertion assertIfResponseTimeLessThan3000(Response response, String duration) {
        assertThat(apiPage.getResponseTime(response, duration)).as("Verify the Response Time LessThan 3000").isTrue();
        return this;
    }

    public BaseAssertion assertResponseDescription(Response response, String elementPath, String description) {
        assertThat(apiPage.getResponseStatusDescription(response, elementPath))
                .as("Verify Description For GetGenericPart2 from the Response").contains(description);
        return this;
    }

    public BaseAssertion assertIfPromoTypeFlagVisible(Response response, int index, String description) {
        assertThat(apiPage.getResponsePromoTypeFlag(response, index))
                .as("Verify Promo type BAU flag is visible for requested job from the Response").contains(description);
        return this;
    }
}
