package GM.gmAssertion.administration;

import GM.gmObjectRepository.administration.UserMaintainPage;
import base.AbstractAssertion;

import static org.assertj.core.api.Assertions.assertThat;

public class UserMaintainPageAssertion extends AbstractAssertion<UserMaintainPage> {

    public UserMaintainPageAssertion assertAtJLRUserMaintenanceTab() {
        assertThat(functionalLibrary.getColor("User Maint.")).as("Verify that Org. Detail Tab is Selected.").isEqualTo(functionalLibrary.BLACK_COLOR_HEX_CODE);
        return this;
    }

    public UserMaintainPageAssertion assertIfPasswordNotAcceptedFullErrorMessageShown(String expectedErrorMsg) {
        assertThat(functionalLibrary.getErrorMSg()).as("verify that Error message is shown").isEqualTo(expectedErrorMsg);
        return this;
    }

    public UserMaintainPageAssertion assertIfTheUsersStatusIsChangedFromEnabledToDeactivated(String expectedStatus) {
        assertThat(functionalLibrary.getStatusOfUser()).as("The users status is changed from Enabled to Deactivated. ").isEqualTo(expectedStatus);
        return this;
    }
}
