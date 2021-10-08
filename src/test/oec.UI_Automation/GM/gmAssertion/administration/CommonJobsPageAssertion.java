package GM.gmAssertion.administration;

import GM.gmObjectRepository.administration.CommonJobsPage;
import base.AbstractAssertion;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CommonJobsPageAssertion extends AbstractAssertion<CommonJobsPage> {

    public CommonJobsPageAssertion assertIfCommonJobsTab() {
        assertThat(functionalLibrary.getColor("Common Jobs")).as("Verify that User at CommonJobsTab").isEqualTo(functionalLibrary.ORANGE_COLOR_HEX_CODE);
        return this;
    }

    public CommonJobsPageAssertion assertIfCommonJobIsAddedToTheDealerCustomJobsList(String addedJob) {
        assertThat(functionalLibrary.isAddedDealerCustomJobDisplayed(addedJob)).as("Verify that Common job is added to the Dealer Custom Jobs list.").isTrue();
        return this;
    }

    public CommonJobsPageAssertion assertIfGenericJobEditFieldInputElementsDisplayed() {
        List<String> actualResult = functionalLibrary.getGenericJobEditFieldsElementsDisplayed();
        assertThat(actualResult).as("Verify that Generic job details loaded into edit fields.").isNotEqualTo("null");
        return this;
    }

    public CommonJobsPageAssertion assertIfVehicleCleaningEngineWashCommonJobsPriceAreUpdated(List<String> expectedPrice, String genericJob) {
        List<String> actualResult = functionalLibrary.getUpdatedVehicleCleaningEngineWashCommonJobsPrice(genericJob);
        assertThat(actualResult).as("Verify that Prices are updated.").containsAll(expectedPrice);
        return this;
    }

    public CommonJobsPageAssertion assertIfDeletingWarningMessageIsShown() {
        String expectedWarnMsg = "Do you really want to delete the selected item?";
        String actualWarnMsg = functionalLibrary.getWarningMSg();
        assertThat(actualWarnMsg).as("Message is shown to user:\n" +
                "Do you really want to delete the selected item?").isEqualTo(expectedWarnMsg);
        return this;
    }

    public CommonJobsPageAssertion assertIfTestJob1RemovedFromDealerCustomJobsTableDescriptions(String expectedPrice) {
        List<String> actualResult = functionalLibrary.getDealerCustomJobsTableDescriptions();
        assertThat(actualResult).as("Verify that Custom job Test Job 1 is removed from the list.").doesNotContain(expectedPrice);
        return this;
    }

    public CommonJobsPageAssertion assertIfErrorMessageDisplayed(String expectedErrorMsg) {
        String actualErrorMsg = functionalLibrary.getErrorMSg();
        assertThat(actualErrorMsg).as("Verify That Message informs user all fields must be filled in.").isEqualTo(expectedErrorMsg);
        return this;
    }

    public CommonJobsPageAssertion assertIfDeletingWarningMessageIsShownInGenericJobs(String expectedWarnMsg) {
        String actualWarnMsg = functionalLibrary.getDialogConfirmMSg();
        assertThat(actualWarnMsg).as("Message is shown to user:\n" +
                "Do you really want to delete the selected item?").isEqualTo(expectedWarnMsg);
        return this;
    }

    public CommonJobsPageAssertion assertIfGenericJobsTab() {
        assertThat(functionalLibrary.getColor("Generic Jobs")).as("Verify that User at Generic Parts Page").isEqualTo(functionalLibrary.BLACK_COLOR_HEX_CODE);
        return this;
    }
}
