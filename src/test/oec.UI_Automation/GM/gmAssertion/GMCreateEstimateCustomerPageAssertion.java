package GM.gmAssertion;

import GM.gmObjectRepository.GMCreateEstimateCustomerPage;
import base.AbstractAssertion;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class GMCreateEstimateCustomerPageAssertion extends AbstractAssertion<GMCreateEstimateCustomerPage> {

    public GMCreateEstimateCustomerPageAssertion assertIfCustomerTab() {
        String color = null;
        if (System.getProperty("environment").contains("jlrmenupricingonline")) {
            color = functionalLibrary.BLACK_COLOR_HEX_CODE;
        }
        else  if (System.getProperty("environment").contains("gmmenupricingonline")) {
            color = functionalLibrary.ORANGE_COLOR_HEX_CODE;
        }
        assertThat(functionalLibrary.getColor("Customer")).as("Verify that User at CustomerTab").isEqualTo((color));
        return this;
    }

    public GMCreateEstimateCustomerPageAssertion assertIfKnownCustomerIsFoundAndDisplayed() {
        List<String> actualResult = functionalLibrary.getRepairerDetailInput();
        assertThat(actualResult).as("Verify that Known customer is found and displayed.\n" + "If there is more than one customer found, the list of customers is populated.\n").isNotNull();
        return this;
    }

    public GMCreateEstimateCustomerPageAssertion assertIfTheCustomerDetailsFormIsShown() {
        assertThat(functionalLibrary.isRepairerDetailFieldDisplayed()).as("Verify that The Customer Details form is shown.").isTrue();
        return this;
    }

    public GMCreateEstimateCustomerPageAssertion assertIfCustomerDetailUpdateInHeader(List<String> expectedResult) {
        List<String> actualResult = functionalLibrary.getHeaderCustomerDetails();
        assertThat(actualResult).as("Verify that Customer Detail Update In Header").isEqualTo(expectedResult);
        return this;
    }

}
