package GM.gmAssertion.administration;

import GM.gmObjectRepository.administration.OrgDetailPage;
import base.AbstractAssertion;

import static org.assertj.core.api.Assertions.assertThat;

public class OrgDetailPageAssertion extends AbstractAssertion<OrgDetailPage> {

    public OrgDetailPageAssertion assertAtOrgDetailTab() {
        assertThat(functionalLibrary.getColor("Org. Detail")).as("Verify that Org. Detail Tab is Selected.").isEqualTo(functionalLibrary.ORANGE_COLOR_HEX_CODE);
        return this;
    }

    public OrgDetailPageAssertion assertAtJLROrgDetailTab() {
        assertThat(functionalLibrary.getColor("Org. Detail")).as("Verify that Org. Detail Tab is Selected.").isEqualTo(functionalLibrary.BLACK_COLOR_HEX_CODE);
        return this;
    }

    public OrgDetailPageAssertion assertIfInputValueUpdated(String element, String expectedValue) {
        assertThat(functionalLibrary.getOrgDetails(element)).as("Verify if Detail updated changed.").isEqualTo(expectedValue);
        return this;
    }

    public OrgDetailPageAssertion assertIfAddressInputValueUpdated(String element, String expectedValue) {
        assertThat(functionalLibrary.getOrgAddressDetails(element)).as("Verify if Address Detail updated changed.").isEqualTo(expectedValue);
        return this;
    }

    public OrgDetailPageAssertion assertIfTheBoxIsTickableAndTheWarningAppears(String expectedMsg) {
        assertThat(functionalLibrary.getPopUpWarnMsg()).as("Verify that The box is tickable and the warning appears").isEqualTo(expectedMsg);
        return this;
    }
}
