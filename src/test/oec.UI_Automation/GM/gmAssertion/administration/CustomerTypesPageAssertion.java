package GM.gmAssertion.administration;

import GM.gmObjectRepository.administration.CustomerTypesPage;
import base.AbstractAssertion;

import static org.assertj.core.api.Assertions.assertThat;

public class CustomerTypesPageAssertion extends AbstractAssertion<CustomerTypesPage> {

    public CustomerTypesPageAssertion assertIfCustomerTypesTab() {
        String color = null;
        if (System.getProperty("environment").contains("jlrmenupricingonline")) {
            color = functionalLibrary.BLACK_COLOR_HEX_CODE;
        }
        else if (System.getProperty("environment").contains("gmmenupricingonline")) {
            color = functionalLibrary.ORANGE_COLOR_HEX_CODE;
        }
        assertThat(functionalLibrary.getColor("Cust. Types")).as("Verify that User at Customer Types").isEqualTo(color);
        return this;
    }

    public CustomerTypesPageAssertion assertIsPossibleToPutValuesToFields() {
        assertThat(functionalLibrary.isDescriptionDisplayed()).as("verify that Is possible to put values to fields").isTrue();
        assertThat(functionalLibrary.isAdjustPercentPartsDisplayed()).as("verify that Is possible to put values to fields.").isTrue();
        assertThat(functionalLibrary.isAdjustPercentLabourDisplayed()).as("verify that Is possible to put values to fields.").isTrue();
        return this;
    }

    public CustomerTypesPageAssertion assertIfNewlyAddedCustomerTypeIsSaved() {
        assertThat(functionalLibrary.isDeleteIconDisplayed()).as("verify that The customer type is saved.").isTrue();
        return this;
    }

    public CustomerTypesPageAssertion assertIfCustomerTypeIsPermanentlyDeleted() {
        assertThat(functionalLibrary.getDeleteIconSize()).as("verify that The customer type is permanently deleted.").isEqualTo(1);
        return this;
    }

    public CustomerTypesPageAssertion assertIfErrorMsgDisplayed(String expectedErrorMsg) {
        assertThat(functionalLibrary.getErrorMsg()).as("verify that Message appears: When saving, a changed row must not contain any blank field.").isEqualTo(expectedErrorMsg);
        return this;
    }

    public CustomerTypesPageAssertion assertIfAdjustPercentPartsIsInactiveForBasedOnEqualToNone() {
        assertThat(functionalLibrary.isAdjustPercentPartDisable()).as("verify that Adjust % Parts is inactive for Based On = None").isTrue();
        return this;
    }
}
