package GM.gmAssertion.maintainEstimates;

import GM.gmObjectRepository.maintainEstimates.SearchEstimatePage;
import base.AbstractAssertion;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class SearchEstimatePageAssertion extends AbstractAssertion<SearchEstimatePage> {

    public SearchEstimatePageAssertion assertIfDeleteStatusDisplayed() {
        assertThat(functionalLibrary.isDeletedIconDisplayed()).as("Verify that Estimates with the correct status are returned.").isTrue();
        return this;
    }

    public SearchEstimatePageAssertion assertIfSavedStatusDisplayed() {
        assertThat(functionalLibrary.isSavedIconDisplayed()).as("Verify that Estimates with the correct status are returned.").isTrue();
        return this;
    }

    public SearchEstimatePageAssertion assertIfAllSearchedStatusDisplayed() {
        assertThat(functionalLibrary.isSavedIconDisplayed()).as("Verify that Estimates with the correct status are returned.").isTrue();
        assertThat(functionalLibrary.isDeletedIconDisplayed()).as("Verify that Estimates with the correct status are returned.").isTrue();
        return this;
    }

    public SearchEstimatePageAssertion assertIfAllEstimatesWithTheVINAreReturned(String vinNo) {
        assertThat(functionalLibrary.getVinSearchResult()).as("Verify that All estimates with the VIN are returned.").contains(vinNo);
        return this;
    }

    public SearchEstimatePageAssertion assertIfAllEstimatesWithVINsMatchingThePartialCriteriaAreReturned(String vinNo) {
        int size = functionalLibrary.getVinSearchSize();
        for (int i = 1; i <= size; i++) {
            assertThat(functionalLibrary.getPartialVinSearchResult(i)).as("Verify that All estimates with VIN’s matching the partial criteria are returned.").contains(vinNo);
        }
        return this;
    }

    public SearchEstimatePageAssertion assertIfAllEstimatesWithCustomerNameMatchingAreReturned(String customerName) {
        int size = functionalLibrary.getCustomerNameSearchSize();
        for (int i = 1; i <= size; i++) {
            assertThat(functionalLibrary.getCustomerNameSearchResult(i)).as("Verify that All estimates with Customer Name matching the partial criteria are returned.").contains(customerName);
        }
        return this;
    }

    public SearchEstimatePageAssertion assertIfAllEstimatesWithTheEstimateIsReturned(String estimateNo) {
        assertThat(functionalLibrary.getEstimateNoSearchResult()).as("Verify that All estimates with the Estimate number are returned.").contains(estimateNo);
        return this;
    }

    public SearchEstimatePageAssertion assertIfAllEstimatesWithDateMatchingAreReturned(String customerName) {
        int size = functionalLibrary.getDateSearchResultSize();
        for (int i = 1; i <= size; i++) {
            assertThat(functionalLibrary.getDateSearchResult(i)).as("Verify that All estimates with date matching are returned.").contains(customerName);
        }
        return this;
    }

    public SearchEstimatePageAssertion assertIfInvalidDateErrorMessageAppears(String errorMsg) {
        assertThat(functionalLibrary.getInvalidDateErrorMsg()).as("Verify that Error message appears “The date range is invalid”.").contains(errorMsg);
        return this;
    }

    public SearchEstimatePageAssertion assertIfEstimatesAreSortedAscendingAsExpected() {
        int size = functionalLibrary.getEstimateNumberSearchSize();
        for (int i = 1; i <= size; i++) {
            assertThat(functionalLibrary.getEstimateNumberSearchResult(i)).as("Verify that Estimates Are Sorted Ascending As Expected").isEqualTo(String.valueOf(i));
        }
        return this;
    }

    public SearchEstimatePageAssertion assertIfEstimatesAreSortedDescendingAsExpected() {
        int size = functionalLibrary.getEstimateNumberSearchSize();
        for (int i = 0; i < size; i++) {
            assertThat(functionalLibrary.getEstimateNumberSearchResult(i + 1)).as("Verify that Estimates Are Sorted Descending As Expected").isEqualTo(String.valueOf(size - i));
        }
        return this;
    }

    public SearchEstimatePageAssertion assertIfExpectedSubTabsInfoDisplayed(List<String> expectedSubTabs) {
        assertThat(functionalLibrary.getSubTabs()).as("Verify that All estimates with the Estimate number are returned.").isEqualTo(expectedSubTabs);
        return this;
    }

    public SearchEstimatePageAssertion assertIfDeletingWarningMessageIsShown(String expectedWarnMsg) {
        String actualWarnMsg = functionalLibrary.getDeleteWarningMSg();
        assertThat(actualWarnMsg).as("User is prompted to confirm estimate delete. ").isEqualTo(expectedWarnMsg);
        return this;
    }

    public SearchEstimatePageAssertion assertIfPrintOptionsAreDisplayed() {
        int size = functionalLibrary.getPrintOptionSize();
        for (int i = 0; i < size; i++) {
            assertThat(functionalLibrary.isPrintOptionsDisplayedBasedOnIndex(i + 1)).as("Verify that Print options screen shown. ").isTrue();
        }
        return this;
    }

    public SearchEstimatePageAssertion assertIfEstimateNumberIsPrefixedAndSuffixedByTheTextEnteredInSystemSettings() {
        assertThat(functionalLibrary.getEstimateNo()).as("The quote number is prefixed and suffixed by the text entered in system settings.").contains("SeleniumTesting");
        return this;
    }

    public SearchEstimatePageAssertion assertIfInvalidDateAlertMessageAppears(String errorMsg) {
        assertThat(functionalLibrary.getInvalidDateAlertMsg()).as("Verify that Error message appears “The date range is invalid”.").contains(errorMsg);
        return this;
    }

    public SearchEstimatePageAssertion assertIfDeferredStatusDisplayed() {
        assertThat(functionalLibrary.isDeferredIconDisplayed()).as("Verify that Estimates with the correct status are returned.").isTrue();
        return this;
    }
    public SearchEstimatePageAssertion assertIfLostStatusDisplayed() {
        assertThat(functionalLibrary.isLostIconDisplayed()).as("Verify that Estimates with the correct status are returned.").isTrue();
        return this;
    }

    public SearchEstimatePageAssertion assertIfDeleteConfirmationMessageAppears(String errorMsg) {
        assertThat(functionalLibrary.getDeleteConfirmMsg()).as("Verify that User is prompted to confirm quote delete”.").contains(errorMsg);
        return this;
    }

    public SearchEstimatePageAssertion assertIfDetailedBtnEnabled() {
        assertThat(functionalLibrary.isDetailedBtnEnabled()).as("Verify that Detailed Btn Enabled").isTrue();
        return this;
    }

    public SearchEstimatePageAssertion assertIfDetailed2BtnEnabled() {
        assertThat(functionalLibrary.isDetailed2BtnEnabled()).as("Verify that Detailed 2 Btn Enabled").isTrue();
        return this;
    }

    public SearchEstimatePageAssertion assertIfSummaryBtnEnabled() {
        assertThat(functionalLibrary.isSummaryBtnEnabled()).as("Verify that Summary Btn Enabled").isTrue();
        return this;
    }

    public SearchEstimatePageAssertion assertIfUserIsReturnedToQuoteViewPage() {
        assertThat(functionalLibrary.isJobDetailsIconDisplayed()).as("Verify that User is returned to quote view").isTrue();
        return this;
    }
}