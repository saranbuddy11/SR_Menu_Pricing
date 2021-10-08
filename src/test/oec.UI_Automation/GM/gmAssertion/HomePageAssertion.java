package GM.gmAssertion;

import GM.gmObjectRepository.HomePage;
import base.AbstractAssertion;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class HomePageAssertion extends AbstractAssertion<HomePage> {

    public HomePageAssertion assertIfUserAtHomePage() {
        assertThat((functionalLibrary.isAt(functionalLibrary.getBaseURL()))).as("Verify that current page is at 'Home' page").isTrue();
        return this;
    }

    public HomePageAssertion assertVehicleFound() {
        assertThat(functionalLibrary.isVehicleFound()).as("Verify that Vehicle is present.").isTrue();
        return this;
    }

    public HomePageAssertion assertJobWorkItemIsDisplayedInEstimation() {
        assertThat(functionalLibrary.jobWorkItemInEstimate()).as("Verify that Cabin Filter Remove & Replace Job work Item added in Estimate.").isTrue();
        return this;
    }

    public HomePageAssertion assertEstimateTabIsSelected() {
        assertThat(functionalLibrary.isEstimateSelected()).as("Verify that Estimate Tab is Selected.").isTrue();
        return this;
    }

//    public HomePageAssertion assertCustomerDetailsIsDisplayed(String environment, List<String> expectedDetails) {
//        String expectedName = "", expectedAddress = "", expectedPostCode = "";
//        if (environment.contains("prd")) {
//            expectedName = expectedDetails.get(0);
//            expectedAddress = expectedDetails.get(1);
//            expectedPostCode = expectedDetails.get(2);
//        } else if (environment.contains("qa")|| environment.contains("uat")) {
//            expectedName = expectedDetails.get(3);
//            expectedAddress = expectedDetails.get(4);
//            expectedPostCode = expectedDetails.get(5);
//        }
//        String actualName = functionalLibrary.getCustomerStatusContent().trim();
//        String actualAddress = functionalLibrary.getCustomerAddressContent().trim();
//        String actualPostcode = functionalLibrary.getCustomerPostCodeContent().trim();
//        assertThat(actualName).as("verify that Customer Name displayed in Estimate Page is" +
//                "\nExpected: " + expectedName + "\nActual: " + actualName).contains(expectedName);
//        assertThat(actualAddress).as("verify that Customer Address displayed in Estimate Page is" +
//                "\nExpected: " + expectedAddress + "\nActual: " + actualAddress).contains(expectedAddress);
//        assertThat(actualPostcode).as("verify that Customer Postcode displayed in Estimate Page is" +
//                "\nExpected: " + expectedPostCode + "\nActual: " + actualPostcode).contains(expectedPostCode);
//        return this;
//    }


//    public HomePageAssertion assertSaveBtnIsEnabled() {
//        assertThat(functionalLibrary.isSaveBtnEnabled()).as("Verify that Save Button is Enabled.").isTrue();
//        return this;
//    }

//    public HomePageAssertion assertQuoteDetails(String expectedStatus) {
//        String actualStatus = functionalLibrary.getEstimateStatus().trim();
//        String actualQuoteNo = functionalLibrary.getEstimateNo().trim();
//        assertThat(functionalLibrary.isEstimateNoIsDisplayed()).as("Verify that Estimate Number is Displayed.").isTrue();
//        assertThat(functionalLibrary.isEstimateStatusDisplayed()).as("Verify that Estimate Status is Displayed.").isTrue();
//        assertThat(actualStatus).as("verify that Customer Quote Status is SAVED" +
//                "\nExpected: " + expectedStatus + "\nActual: " + actualStatus).isEqualTo(expectedStatus);
//        assertThat(actualQuoteNo).as("verify that Customer Quote Number is ").containsOnlyDigits();
//        return this;
//    }

    public HomePageAssertion assertAtHomePage() {
        assertThat((functionalLibrary.isAt(functionalLibrary.getBaseURL()))).as("Verify that you are at 'Home' page").isTrue();
        return this;
    }

    public HomePageAssertion assertVehicleDetailsFound() {
        assertThat(functionalLibrary.isVehicleFound()).as("Verify that Vehicle details is present.").isTrue();
        return this;
    }

    public HomePageAssertion assertQuoteSpanIsSelected() {
        assertThat(functionalLibrary.isQuoteSelected()).as("Verify that Quote Span is Selected.").isTrue();
        return this;
    }

    public HomePageAssertion assertJobWorkItemIsDisplayedInQuote() {
        assertThat(functionalLibrary.isJobWorkItemInQuote()).as("Verify that 20,000 mls Job work Item added in Quote.").isTrue();
        return this;
    }

    public HomePageAssertion assertJLRJobWorkItemIsDisplayedInQuote() {
        assertThat(functionalLibrary.isJLRJobWorkItemInQuote()).as("Verify that Compressor & Drive Remove & Replace Compressor Job work Item added in Quote.").isTrue();
        return this;
    }

    public HomePageAssertion assertSaveBtnIsEnabled() {
        assertThat(functionalLibrary.isSaveBtnEnabled()).as("Verify that Save Button is Enabled.").isTrue();
        return this;
    }

    public HomePageAssertion assertQuoteDetails(String expectedStatus) {
        String actualStatus = functionalLibrary.getQuoteStatus();
        String actualQuoteNo = functionalLibrary.getQuoteNo().trim();
        assertThat(functionalLibrary.isQuoteNoIsDisplayed()).as("Verify that Quote Number is Displayed.").isTrue();
        assertThat(functionalLibrary.isQuoteStatusIsDisplayed()).as("Verify that Quote Status is Displayed.").isTrue();
        assertThat(actualStatus).as("verify that Customer Quote Status is SAVED" +
                "\nExpected: " + expectedStatus + "\nActual: " + actualStatus).isEqualTo(expectedStatus);
        assertThat(actualQuoteNo).as("verify that Customer Quote Number is ").containsOnlyDigits();
        return this;
    }

    public HomePageAssertion assertAtCreateQuoteTab() {
        assertThat(functionalLibrary.isCreateQuotesTabDisplayed()).as("Verify that landed page is Create Quote Tab.").isTrue();
        return this;
    }

    public HomePageAssertion assertIfErrorMsgIsDisplayed(String expectedVinErrorMsg) {
        String actualErrorMsg = functionalLibrary.getGMVinErrorMsg();
        assertThat(actualErrorMsg).as("User is shown message: No vehicles found. Please verify VIN or manually select the vehicle below. The manual match drop down lists are now available. ").isEqualTo(expectedVinErrorMsg);
        return this;
    }

    public HomePageAssertion assertIfLICNoBoxSpecialCharactersAreNotAccepted() {
        String actualErrorMsg = functionalLibrary.getLicNo();
        assertThat(actualErrorMsg).as("Does not accept the invalid License Number. It is impossible to put [i.e. non alphanumeric characters] to the LIC no box.").isEmpty();
        return this;
    }

    public HomePageAssertion assertIfEngineNoBoxSpecialCharactersAreNotAccepted() {
        String actualErrorMsg = functionalLibrary.getEngineNo();
        assertThat(actualErrorMsg).as("Does not accept the invalid License Number. It is impossible to put [i.e. non alphanumeric characters] to the LIC no box.").isEmpty();
        return this;
    }

    public HomePageAssertion assertIfCustomerIsFoundWithEachOfTheirAssociatedVehiclesAndIsDisplayed() {
        List<String> actualCustomerDetail = functionalLibrary.getCustomerDetails();
        List<String> expectedDetails = Arrays.asList("Joe Doe ", "Krakow ", "12345 ", "  ", "12345678901234567  ", "  ", "  ", "Chevrolet, Impala, 2017 ", "1G1105S30HU111699  ", "  ", "01/25/2017  ", " Chevrolet, Malibu, 2017  ", " 1G1ZA5ST1HF190045  ", "  ", " 06/18/2018  ");
        assertThat(actualCustomerDetail).as("The customer is found and is displayed with each of their associated vehicles but the Continue button is disabled at this time").containsAll(expectedDetails);
        return this;
    }

    public HomePageAssertion assertIfContinueBtnIsEnabled() {
        assertThat(functionalLibrary.isContinueBtnEnabled()).as("Verify that Continue Button is disabled.").isFalse();
        return this;
    }

    public HomePageAssertion assertISearchFieldInputedElementsDisplayed() {
        List<String> actualResult = functionalLibrary.getSearchFieldInputElementsDisplayed();
        assertThat(actualResult).as("Verify that inputed text into all the search boxes are displayed.").isNotEqualTo("null");
        return this;
    }

    public HomePageAssertion assertISearchFieldAreCleared() {
        List<String> actualResult = functionalLibrary.getSearchFieldInputElementsDisplayed();
        assertThat(actualResult).as("The search boxes/manual match drop down lists/customer details/vehicle details are cleared..").containsOnly("");
        return this;
    }

    public HomePageAssertion assertIfCustomerNameDisplayedInSearchResult(String expectedResult) {
        String actualResult = functionalLibrary.getCustomerNameSearchResult(expectedResult);
        assertThat(actualResult).as("Customers (and any associated vehicles) with a partial match to the Name are displayed.").isEqualTo(expectedResult);
        return this;
    }

    public HomePageAssertion assertIfDataLoseWarningMessageIsShown(String expectedWarnMsg) {
        String actualWarnMsg = functionalLibrary.getWarningMSg();
        assertThat(actualWarnMsg).as("Message is shown to user:\n" +
                "“If you open a new estimate at this stage you will lose all data of the present estimate!”.OK clears the screen Cancel leaves the page as is.").isEqualTo(expectedWarnMsg);
        return this;
    }

    public HomePageAssertion assertIfManualMatchIsDisplayed() {
        assertThat(functionalLibrary.isManualMatchDisplayed()).as("Verify that Manual Match is displayed.").isTrue();
        return this;
    }

    public HomePageAssertion assertIfManualSelectionElementsDisplayed() {
        List<String> expected = Arrays.asList("Chevrolet", "Beat", "2018");
        List<String> actualResult = functionalLibrary.getManuallySelectedInputElementsDisplayed();
        assertThat(actualResult).as("Verify that input text into all the search boxes are displayed.").isEqualTo(expected);
        return this;
    }

    public HomePageAssertion assertIfAHyperlinkToTheCommonJobsPageIsVisible() {
        assertThat(functionalLibrary.isUnpricedCommonCustomJobsLinkDisplayed()).as("Verify that A hyperlink to the Common Jobs page is visible.").isTrue();
        return this;
    }

    public HomePageAssertion assertIfAHyperlinkToTheCommonJobsPageIsNotVisible() {
        assertThat(functionalLibrary.isUnpricedCommonCustomJobsLinkDisplayed()).as("Verify that A hyperlink to the Common Jobs page is Not visible.").isFalse();
        return this;
    }

    public HomePageAssertion assertAtSearchTab() {
        assertThat(functionalLibrary.getSearchEstimatesTabColor()).as("Verify that Search Tab is Selected.").isEqualTo(functionalLibrary.ORANGE_COLOR_HEX_CODE);
        return this;
    }

    public HomePageAssertion assertAtHelpAndSupport() {
        assertThat((functionalLibrary.isAt(functionalLibrary.getBaseURL()))).as("Verify that you are at 'Help And Support' page").isTrue();
        return this;
    }

    public HomePageAssertion assertIfHomePageHeaderTabsDoesNotContainAdmin(String admin) {
        assertThat(functionalLibrary.getHomePageHeaders()).as("Verify that headers are displayed.")
                .doesNotContain(admin);
        assertThat(functionalLibrary.getHomePageCurrentHeaders()).as("Verify that headers are displayed.")
                .doesNotContain(admin);
        return this;
    }

    public HomePageAssertion assertIfVehicleDetailsFound(String expectedVehicle) {
        assertThat(functionalLibrary.getVehicleFound()).as("Verify that Vehicle details is present.").contains(expectedVehicle);
        return this;
    }

    public HomePageAssertion assertIfInvalidDataWarningMessageIsDisplayed(String expectedMsg) {
        assertThat(functionalLibrary.getDialogAlertContent()).as("Verify that Warning message is displayed: \"Your search did not return any results. Please review and adjust your search or use the model selector to manually select your vehicle.").contains(expectedMsg);
        return this;
    }

    public HomePageAssertion assertIfVehiclesWithAPartialMatchAreDisplayed(int index, String partialValue) {
        for (int i = 1; i < functionalLibrary.getSearchVinResultSize(index); i++) {
            logger.info("iteration :" + i);
            assertThat(functionalLibrary.getSearchVinResult(index, i)).as("Vehicles with a partial match to the VIN are displayed").contains(partialValue);
        }
        return this;
    }

    public HomePageAssertion assertIfCustomerDetailWithAPartialMatchAreDisplayed(int index, String partialValue) {
        assertThat(functionalLibrary.getSearchCustomerDetailResult(index)).as("Customer details with a partial match to the details are displayed").contains(partialValue);
        return this;
    }

    public HomePageAssertion assertAtGenericJobsTab() {
        assertThat(functionalLibrary.getColor("Generic Jobs")).as("Verify that User at Generic Jobs").isEqualTo(functionalLibrary.BLACK_COLOR_HEX_CODE);
        return this;
    }

    public HomePageAssertion assertAtGenericPartsTab() {
        assertThat(functionalLibrary.getColor("Generic Parts")).as("Verify that User at Generic Parts").isEqualTo(functionalLibrary.BLACK_COLOR_HEX_CODE);
        return this;
    }

    public HomePageAssertion assertIfResultsAreCorrect() {
        assertThat(functionalLibrary.isResultsEnquiryDisplayed()).as("Results are displayed and are correct. If no results are found then ‘The search returned zero result'.").isTrue();
        return this;
    }
    public HomePageAssertion assertIfEnquiryFileDownloadedSuccessfully(String fileName) {
        assertThat(functionalLibrary.isFileDownloaded(fileName)).as("Verify that Downloaded successfully").isTrue();
        return this;
    }

    public HomePageAssertion assertIfPageIsTranslatedCorrectly(String expectedMenuName) {
        assertThat(functionalLibrary.getCreateQuoteMenuSpainName()).as("Ensure the page is translated correctly. ").isEqualTo(expectedMenuName);
        return this;
    }

    public HomePageAssertion assertIfWarningDisplayed()
    {
        assertThat(functionalLibrary.verifyWarningDialog()).as("Ensure warning dialog is displayed").isTrue();
        return this;
    }

    public HomePageAssertion assertIfCostcorrectlyDisplayed(String cost, String priceexclVAT)
    {
        assertThat(functionalLibrary.verifyHourPrice(cost, priceexclVAT)).as("Ensure correct cost and price Excl.VAT displayed").isTrue();
        return this;
    }
    public HomePageAssertion assertIfQuoteNumberCorrectlyDisplayed()
    {
        assertThat(functionalLibrary.verifyQuoteNumber()).as("Ensure correct quote number got displayed").isTrue();
        return this;
    }

    public HomePageAssertion assertIfWarningMessageCorrectlyDisplayed(String message)
    {
        assertThat(functionalLibrary.verifyWarningMessage(message)).as("Ensure that warning message correctly displayed").isTrue();
        return this;
    }

    public HomePageAssertion assertIfCreateQuotePageDisplayed()
    {
        assertThat(functionalLibrary.verifyCreateQuotePage()).as("Verify create quote page displayed").isTrue();
        return this;
    }

    public HomePageAssertion assertIfListRulesDisplayed()
    {
        assertThat(functionalLibrary.verifyListRules()).as("Verify that List rules tab displayed").isTrue();
        return this;
    }

    public HomePageAssertion assertIfCustomerLabourDisplayed()
    {
        assertThat(functionalLibrary.CheckCustomLabourOption()).as("Verify that custom Labour option displayed").isTrue();
        return this;
    }

}
