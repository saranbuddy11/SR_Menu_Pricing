package GM.gmAssertion.administration;

import GM.gmObjectRepository.administration.SystemSettingsPage;
import base.AbstractAssertion;

import java.io.IOException;

import static base.FunctionalLibrary.address;
import static base.FunctionalLibrary.postalcode;
import static org.assertj.core.api.Assertions.assertThat;

public class SystemSettingsPageAssertion extends AbstractAssertion<SystemSettingsPage> {

    public SystemSettingsPageAssertion assertIfSystemSettingsTab() {
        String color = null;
        if (System.getProperty("environment").contains("jlrmenupricingonline")) {
            color = functionalLibrary.BLACK_COLOR_HEX_CODE;
        }
        else if (System.getProperty("environment").contains("gmmenupricingonline")) {
            color = functionalLibrary.ORANGE_COLOR_HEX_CODE;
        }
        assertThat(functionalLibrary.getColor("System Settings")).as("Verify that User at System Settings").isEqualTo(color);
        return this;
    }

    public SystemSettingsPageAssertion assertIfLaborPricingTypeIsSelectedAsExpected(String expectedLaborPriceType) {
        assertThat(functionalLibrary.getLaborPricingTypeSelectedText()).as(" Labor Pricing Type is selected as Single Labor Rate.").isEqualTo(expectedLaborPriceType);
        return this;
    }

    public SystemSettingsPageAssertion assertIfEstimateValidUntilDateIsTheNumberOfDaysSetInSystemSettings() {
        assertThat(functionalLibrary.getSystemSettingsSetDate()).as("Verify that Estimate valid until date is the number of days set in system settings").isEqualTo(functionalLibrary.getEstimateValidDate());
        return this;
    }
    public SystemSettingsPageAssertion assertIfQuoteExpiryCorrectlyDisplayed(String days)
    {
        assertThat(functionalLibrary.validateQuoteExpiry(days)).as("Quote Expiry date displayed correctly").isTrue();
        return this;
    }

    public SystemSettingsPageAssertion assertIfDefaultCustomerNameCorrectlyDisplayed()
    {
        assertThat(functionalLibrary.verifyCustomerName()).as("Verify default customer name correctly displayed").isTrue();
        return this;
    }

    public SystemSettingsPageAssertion assertIfQuotenameaddedwithprefixsuffix(String filename, String prefix, String suffix) throws IOException {
        assertThat(functionalLibrary.verifyQuoteNameWithPrefixSuffix(filename, prefix, suffix)).as("Verify quote name correctly displayed in downloaded PDF").isTrue();
        return this;
    }

    public SystemSettingsPageAssertion assertIfAddresscorrectlyDisplayedinPDF(String filename) throws IOException {
        assertThat(functionalLibrary.verifyAddressinPDF(filename, address, postalcode)).as("Verfify address correctly displayed in downloaded PDF").isTrue();
        return this;
    }

    public SystemSettingsPageAssertion assertIfSystemSettingstabDisplayed()
    {
        assertThat(functionalLibrary.checkSystemSettingsTabPresent()).as("Verify System Settings tab is displayed").isTrue();
        return this;
    }

}
