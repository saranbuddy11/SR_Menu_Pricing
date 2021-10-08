package JLR.jlrAssertion;

import JLR.jlrObjectRepository.JLRHomePage;
import MOPAR.moparAssertion.MOPARHomePageAssertion;
import base.AbstractAssertion;

import static org.assertj.core.api.Assertions.assertThat;

public class JLRHomePageAssertion extends AbstractAssertion<JLRHomePage> {

    public JLR.jlrAssertion.JLRHomePageAssertion assertAtHomePage() {
        assertThat((functionalLibrary.isAt(functionalLibrary.getBaseURL()))).as("Verify that you are at 'Home' page").isTrue();
        return this;
    }

    public JLRHomePageAssertion assertVehicleDetailsFound() {
        assertThat(functionalLibrary.isVehicleFound()).as("Verify that Vehicle details is present.").isTrue();
        return this;
    }

    public JLRHomePageAssertion assertQuoteSpanIsSelected() {
        assertThat(functionalLibrary.isQuoteSelected()).as("Verify that Quote Span is Selected.").isTrue();
        return this;
    }

    public JLRHomePageAssertion assertJobWorkItemIsDisplayedInQuote() {
        assertThat(functionalLibrary.jobWorkItemInQuote()).as("Verify that Remove & Replace Original Equipment Job work Item added in Quote.").isTrue();
        return this;
    }

    public JLRHomePageAssertion assertCustomerDetailsIsDisplayed(String expectedName, String expectedAddress, String expectedPostCode) {
        String actualName = functionalLibrary.getCustomerStatusContent();
        String actualAddress = functionalLibrary.getCustomerAddressContent();
        String actualPostcode = functionalLibrary.getCustomerPostCodeContent();
        assertThat(actualName).as("verify that Customer Name displayed in Quote Page is" +
                "\nExpected: " + expectedName + "\nActual: " + actualName).isEqualTo(expectedName);
        assertThat(actualAddress).as("verify that Customer Address displayed in Quote Page is" +
                "\nExpected: " + expectedAddress + "\nActual: " + actualAddress).isEqualTo(expectedAddress);
        assertThat(actualPostcode).as("verify that Customer Postcode displayed in Quote Page is" +
                "\nExpected: " + expectedPostCode + "\nActual: " + actualPostcode).isEqualTo(expectedPostCode);
        return this;
    }

    public JLRHomePageAssertion assertSaveBtnIsEnabled() {
        assertThat(functionalLibrary.isSaveBtnEnabled()).as("Verify that Save Button is Enabled.").isTrue();
        return this;
    }

    public JLRHomePageAssertion assertQuoteDetails(String expectedStatus) {
        String actualStatus = functionalLibrary.getQuoteStatus();
        String actualQuoteNo = functionalLibrary.getQuoteNo().trim();
        assertThat(functionalLibrary.isQuoteNoIsDisplayed()).as("Verify that Quote Number is Displayed.").isTrue();
        assertThat(functionalLibrary.isQuoteStatusIsDisplayed()).as("Verify that Quote Status is Displayed.").isTrue();
        assertThat(actualStatus).as("verify that Customer Quote Status is SAVED" +
                "\nExpected: " + expectedStatus + "\nActual: " + actualStatus).isEqualTo(expectedStatus);
        assertThat(actualQuoteNo).as("verify that Customer Quote Number is ").containsOnlyDigits();
        return this;
    }

}