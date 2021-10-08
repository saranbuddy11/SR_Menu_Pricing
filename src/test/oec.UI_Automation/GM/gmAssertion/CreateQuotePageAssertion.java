package GM.gmAssertion;

import GM.gmObjectRepository.CreateQuotePage;
import base.AbstractAssertion;

import static org.assertj.core.api.Assertions.assertThat;

public class CreateQuotePageAssertion extends AbstractAssertion<CreateQuotePage> {

    public CreateQuotePageAssertion assertServiceJobIsAddedToTheQuote() {
        assertThat(functionalLibrary.isServiceDescriptionDisplayed()).as("Verify that Job Detail Table Contains Service Description '20,000 Mile Service (2 Yearly) - Kit 20,000 Miles/2 Year Service 03/2013-'.").isTrue();
        return this;
    }

    public CreateQuotePageAssertion assertIfSaveButtonEnabled() {
        assertThat(functionalLibrary.isSaveBtnEnable())
                .as("Verify that save button should be active/enabled.").isTrue();
        return this;
    }

    public CreateQuotePageAssertion assertQuoteStatus(String status) {
        assertThat(functionalLibrary.getStatus()).as("Verify ")
                .isEqualTo(status);
        return this;
    }

    public CreateQuotePageAssertion assertIfJobSheetIconIsEnable() {
        assertThat(functionalLibrary.isCheckSheetEnable()).as("Verify that Job Detail Table Contains Service Description '20,000 Mile Service (2 Yearly) - Kit 20,000 Miles/2 Year Service 03/2013-'.").isTrue();
        return this;
    }

    public CreateQuotePageAssertion assertQuoteHasBeenAssignedAQuoteNumber() {
        String actualAssignedQuoteNo = functionalLibrary.getAssignedQuoteNumber().trim();
        assertThat(actualAssignedQuoteNo).as("verify that Customer Quote Number is ").containsOnlyDigits();
        return this;
    }

    public CreateQuotePageAssertion assertEstimateTabIsSelected() {
        assertThat(functionalLibrary.isEstimateSelected()).as("Verify that Estimate Tab is Selected.").isTrue();
        return this;
    }

    public CreateQuotePageAssertion assertJobWorkItemCreatedAndIsDisplayedInQuote() {
        assertThat(functionalLibrary.isJobWorkItemIsCreatedQuote()).as("Verify that 20,000 mls Job work Item added in Quote.").isTrue();
        return this;
    }

    public CreateQuotePageAssertion assertJobWorkItemCreatedAndIsDisplayedInQuoteOPEL() {
        assertThat(functionalLibrary.isJobWorkItemIsCreatedQuoteOPEL()).as("Verify that 20,000 mls Job work Item added in Quote.").isTrue();
        return this;
    }

    public CreateQuotePageAssertion assertJobWorkItemCreatedAndIsDisplayedInGMQuote() {
        assertThat(functionalLibrary.isJobWorkItemIsCreatedQuoteInGM()).as("Verify that Cabin Filter Remove & Replace Job work Item added in Quote.").isTrue();
        return this;
    }

    public CreateQuotePageAssertion assertQuoteSpanIsSelected() {
        assertThat(functionalLibrary.isQuoteSelected()).as("Verify that Quote Span is Selected.").isTrue();
        return this;
    }

    public CreateQuotePageAssertion assertCustomerDetailsIsDisplayed() {
        assertThat(functionalLibrary.isCustomerStatusContent()).as("verify that Customer Name displayed in Quote Page is displayed").isTrue();
        assertThat(functionalLibrary.isCustomerAddressContent()).as("verify that Customer Address displayed in Quote Page is displayed").isTrue();
        assertThat(functionalLibrary.isCustomerPostCodeContent()).as("verify that Customer PostCode displayed in Quote Page is displayed").isTrue();
        return this;
    }
}
