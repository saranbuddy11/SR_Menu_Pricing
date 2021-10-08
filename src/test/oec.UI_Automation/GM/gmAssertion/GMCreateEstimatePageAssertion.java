package GM.gmAssertion;

import GM.gmObjectRepository.GMCreateEstimatePage;
import base.AbstractAssertion;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class GMCreateEstimatePageAssertion extends AbstractAssertion<GMCreateEstimatePage> {

    public GMCreateEstimatePageAssertion assertIfVehicleDetailsFound(String expectedVehicleName) {
        assertThat(functionalLibrary.getVehicleName()).as("The vehicle is found with its characteristics displayed. \n" + "Chevrolet\n" + "Malibu").isEqualTo(expectedVehicleName);
        return this;
    }

    public GMCreateEstimatePageAssertion assertAtEstimateTab() {
        assertThat(functionalLibrary.getColor()).as("Verify that Estimate Tab is Selected.").isEqualTo(functionalLibrary.ORANGE_COLOR_HEX_CODE);
        return this;
    }

    public GMCreateEstimatePageAssertion assertAtCommonJobsTab() {
        assertThat(functionalLibrary.getCurrentSubAdministrationTab()).as("Verify that Common jobs Tab is Selected.").isEqualTo("Common Jobs");
        return this;
    }

    public GMCreateEstimatePageAssertion assertIfTheTreeIsExpanded() {
        assertThat(functionalLibrary.isRowMinimized()).as("Verify that The Tree is Expanded.").isTrue();
        return this;
    }

    public GMCreateEstimatePageAssertion assertIfTheTreeIsMinimized() {
        assertThat(functionalLibrary.isRowExpanded()).as("Verify that The Tree is minimized.").isTrue();
        return this;
    }

    public GMCreateEstimatePageAssertion assertIfTheMileageNormalLaborOnly15000MilesAnd24000KMJobIsAddedToTheEstimate(String expectedAddedJob) {
        assertThat(functionalLibrary.getAddedJobs()).as("Verify that The Mileage Normal --> Labor Only 15,000 miles / 24,000km job is added to the Estimate.").isEqualTo(expectedAddedJob);
        return this;
    }

    public GMCreateEstimatePageAssertion assertIfWarningMsgDisplayed(String expectedWarnMsg) {
        assertThat(functionalLibrary.getWarningMsg()).as("Verify that Message is shown to user: \"1. Job \"Labor Only 15,000 miles / 24,000km\" cannot be added twice to the same estimate.\n" + "The job is not added to the quote a second time.").isEqualTo(expectedWarnMsg);
        return this;
    }

    public GMCreateEstimatePageAssertion assertIfQuantityDescriptionAndPriceAddedToQuote(List<String> expectedAddedQuote, int index) {
        assertThat(functionalLibrary.getDescriptionAndPrice(index)).as("Verify that The " + expectedAddedQuote + "s added to the quote and the price Incl.").isEqualTo(expectedAddedQuote);
        return this;
    }

    public GMCreateEstimatePageAssertion assertIfQuantityDescriptionAndPriceAddedToGMQuote(List<String> expectedAddedQuote, int index) {
        List<String> expectedAddedQuantityAndPrice = Arrays.asList(expectedAddedQuote.get(0), expectedAddedQuote.get(2));
        assertThat(functionalLibrary.getQuantityAndPrice(index)).as("Verify that The " + expectedAddedQuote + "s added to the quote and the price Incl.").isEqualTo(expectedAddedQuantityAndPrice);
        assertThat(functionalLibrary.getDescription(index)).as("Verify that The " + expectedAddedQuote + "s added to the quote and the price Incl.").contains(expectedAddedQuote.get(1));
        return this;
    }

    public GMCreateEstimatePageAssertion assertIfQuantityDescriptionAndPriceAddedNewToQuote(List<String> expectedAddedQuote, int index) {
        List<String> expectedAddedQuoteDetails = null;
        expectedAddedQuoteDetails = Arrays.asList(expectedAddedQuote.get(0), expectedAddedQuote.get(1), expectedAddedQuote.get(2));
        assertThat(functionalLibrary.getDescriptionAndPrice(index)).as("Verify that The " + expectedAddedQuote + "s added to the quote and the price Incl.").isEqualTo(expectedAddedQuoteDetails);
        return this;
    }

    public GMCreateEstimatePageAssertion assertIfQuotesPriceIsChangedInAccordanceToTheCustomerTypesSettings(String expectedValue) {
        String actualPrice = functionalLibrary.getTotalPrice();
        assertThat(actualPrice).as("Verify that The quotes price is changed in accordance to the customer types settings.").isNotEqualTo(expectedValue).isNotEqualTo("null");
        return this;
    }

    public GMCreateEstimatePageAssertion assertIfTheJobsTotalPriceIsRecalculatedWithTheNewLabourTime(Float expectedPrice) {
        Float actualPrice = functionalLibrary.getPrices();
        assertThat(actualPrice).as("Verify that The quotes price is changed in accordance to the customer types settings.").isEqualTo(expectedPrice);
        return this;
    }

    public GMCreateEstimatePageAssertion assertIfJobIsRemovedFromTheEstimateAndTheEstimatePriceIsAdjustedCorrectly(String removedItem, String expectedPrice) {
        List<String> actualJobList = functionalLibrary.getEstimateJobList();
        String actualPrice = functionalLibrary.getTotalPrice();
        assertThat(actualJobList).as("Verify that The job is removed from the estimate.").doesNotContain(removedItem);
        assertThat(actualPrice).as("Verify that The job is removed from the estimate and the estimate price is adjusted correctly.").isEqualTo(expectedPrice);
        return this;
    }

    public GMCreateEstimatePageAssertion assertIfNoChangeToTheQuotePrice(float expectedPrice) {
        Float actualPrice = functionalLibrary.getPrices();
        assertThat(actualPrice).as("Verify that Deal price window closes with no change to the quote price.").isEqualTo(expectedPrice);
        return this;
    }

    public GMCreateEstimatePageAssertion assertIfWindowsWarningMsgDisplayed(String expectedWarnMsg) {
        assertThat(functionalLibrary.getPopUpMsg()).as("Verify that Message is shown to user: If you open a new estimate you will loose all data of the present estimate").isEqualTo(expectedWarnMsg);
        return this;
    }

    public GMCreateEstimatePageAssertion assertIfRegVINAreNowDisplayedInYourSelectionAtTopOfPage(List<String> vinAndRegNo) {
        assertThat(functionalLibrary.getHeaderVinAndLicNo()).as("Verify that eg & VIN are now displayed in ‘Your Selection’ at top of page").isEqualTo(vinAndRegNo);
        return this;
    }

    public GMCreateEstimatePageAssertion assertIfVINNumberIsDisplayedInYourSelectionAtTopOfPage(String vinNo) {
        assertThat(functionalLibrary.getHeaderVinNo()).as("Verify that VIN are now displayed in ‘Your Selection’ at top of page").isEqualTo(vinNo);
        return this;
    }

    public GMCreateEstimatePageAssertion assertIfWhenJobIsAddedToQuoteLabourNewWindowOpens(String option) {
        assertThat(functionalLibrary.getReplaceGenericPartsHeader()).as("Verify that When job is added to quote the Parts & Labour window opens automatically giving user option to Replace Generic parts. ").isEqualTo(option);
        return this;
    }

    public GMCreateEstimatePageAssertion assertIfJobHighlightedWithColor(String expectedHighlightedJob, String color) {
        assertThat(functionalLibrary.getHighlightedJob(color)).as("Verify that Oil change --> Engine Oil and Oil Filter Replacement is selected as an Exception and is highlighted Red (currently selected item)").isEqualTo(expectedHighlightedJob);
        return this;
    }

    public GMCreateEstimatePageAssertion assertIfJobHighLevelHighlightedWithColor(List<String> expectedResult) {
        assertThat(functionalLibrary.getHighlightedLevelJobColor(expectedResult.get(2), 1)).as("Verify that Oil change --> Engine Oil and Oil Filter Replacement is selected as an Exception and is highlighted Red (currently selected item)").isEqualTo(expectedResult.get(0));
        assertThat(functionalLibrary.getHighlightedJob(expectedResult.get(3))).as("Verify that Oil change --> Engine Oil and Oil Filter Replacement is selected as an Exception and is highlighted Red (currently selected item)").isEqualTo(expectedResult.get(1));
        return this;
    }

    public GMCreateEstimatePageAssertion assertIfJobHighLevel2HighlightedWithColorRemoved(List<String> expectedResult) {
        assertThat(functionalLibrary.getHighlightedLevelJobColor(expectedResult.get(0), 1)).as("Verify that Oil change --> Engine Oil and Oil Filter Replacement is selected as an Exception and is highlighted Red (currently selected item)").isEqualTo("");
        assertThat(functionalLibrary.getHighlightedJob(expectedResult.get(1))).as("Verify that Oil change --> Engine Oil and Oil Filter Replacement is selected as an Exception and is highlighted Red (currently selected item)").isEqualTo("");
        return this;
    }

    public GMCreateEstimatePageAssertion assertIfJobHighLevel1HighlightedWithColor(List<String> expectedResult) {
        assertThat(functionalLibrary.getHighlightedLevel1JobColor(expectedResult.get(1))).as("Verify that Only the top level i.e. Body Systems is coloured Green (after refreshing)").isEqualTo(expectedResult.get(0));
        return this;
    }

    public GMCreateEstimatePageAssertion assertIfMenuManagerRulesTakePrecedenceOverTheLaborPricing(String value) {
        float expectedTotalValue = Float.parseFloat(value);
        Float actualPrice = functionalLibrary.getCabinFilterPrice();
        assertThat(actualPrice).as("Verify that Menu manager rules take precedence over the Labor Pricing - Single Labor Rate").isEqualTo(expectedTotalValue);
        return this;
    }

    public GMCreateEstimatePageAssertion assertIfCurrentQuoteEmptyWarningMsgDisplayed(String expectedWarnMsg) {
        assertThat(functionalLibrary.getCurrentQuoteEmptyDialogAlertMsg()).as("Verify that Warning box occurs Can not proceed. The current quote is empty.").isEqualTo(expectedWarnMsg);
        return this;
    }

    public GMCreateEstimatePageAssertion assertIfLostSaleWindowIsOpened(String expectedTitle) {
        assertThat(functionalLibrary.getReplaceGenericPartsHeader()).as("Verify that Lost sale window is opened.").isEqualTo(expectedTitle);
        return this;
    }

    public GMCreateEstimatePageAssertion assertLostSaleDropDownReasons(List<String> expectedReasons) {
        assertThat(functionalLibrary.getLostSaleReason()).as("Verify that Drop down Reason should contain [ Pricing, Part Availability, Service Availability]").isEqualTo(expectedReasons);
        return this;
    }

    public GMCreateEstimatePageAssertion assertIfDialogConfirmContentMsgDisplayed(String expectedWarnMsg) {
        assertThat(functionalLibrary.getDialogConfirmContent()).as("Verify that Message is shown to user: If you open a new quote at this stage you will loose all data of the present quote").containsIgnoringCase(expectedWarnMsg);
        return this;
    }

    public GMCreateEstimatePageAssertion assertIfCheckSheetIconDisplayed() {
        assertThat(functionalLibrary.isCheckSheetIconDisplayed()).as("Verify that Check Sheet Icon Displayed.").isTrue();
        return this;
    }
    public GMCreateEstimatePageAssertion assertAtQuoteTab() {
        assertThat(functionalLibrary.getColor("Quote")).as("Verify that Quote Tab is Selected.").isEqualTo(functionalLibrary.BLACK_COLOR_HEX_CODE);
        return this;
    }

    public GMCreateEstimatePageAssertion assertIfTheJLRTreeIsMinimized() {
        assertThat(functionalLibrary.isJLRRowExpanded()).as("Verify that The Tree is minimized.").isTrue();
        return this;
    }

    public GMCreateEstimatePageAssertion assertIfJobTwiceWarningMsgDisplayed(String expectedWarnMsg) {
        assertThat(functionalLibrary.getJobDuplicateWarnMsg()).as("Verify that Message is shown to user: \"1. Job \"Labor Only 15,000 miles / 24,000km\" cannot be added twice to the same estimate.\n" + "The job is not added to the quote a second time.").isEqualTo(expectedWarnMsg);
        return this;
    }

    public GMCreateEstimatePageAssertion assertIfQuantityDescriptionAndPriceAddedNewToQuoteWithVATPrice(List<String> expectedAddedQuote, int index) {
        assertThat(functionalLibrary.getAddedQuoteDetails(index)).as("Verify that The " + expectedAddedQuote + "s added to the quote and the price Incl.").isEqualTo(expectedAddedQuote);
        return this;
    }

    public GMCreateEstimatePageAssertion assertIfThePriceIsAcceptedAndReflectedOnTheQuoteTotal(String expectedPrice) {
        assertThat(functionalLibrary.getAddedQuoteTotalPrice()).as("Verify that The " + expectedPrice + "The price is accepted and refelcted on the quote. ").isEqualTo(expectedPrice);
        return this;
    }

    public GMCreateEstimatePageAssertion assertIfCopyQuoteSaved() {
        assertThat(functionalLibrary.isQuoteStatusSaved()).as("Verify that  Copy of quote is saved.").isTrue();
        return this;
    }

    public GMCreateEstimatePageAssertion assertIfPrintOptionDisplayed() {
        assertThat(functionalLibrary.verifyPrintOptionPresent()).as("Verify Print option is displayed").isTrue();
        return this;
    }

    public GMCreateEstimatePageAssertion assertIfTotalPriceElementDisplayed() {
        assertThat(functionalLibrary.verifyTotalPriceElementPresent()).as("Verify total price element is displayed").isTrue();
        return this;
    }

    public GMCreateEstimatePageAssertion assertIfSendButtonDisplayed() {
        assertThat(functionalLibrary.verifyEmailSendButton()).as("Verify that Send button displayed").isTrue();
        return this;
    }

    public GMCreateEstimatePageAssertion assertIfCancelButtonDisplayed() {
        assertThat(functionalLibrary.verifyEmailCancelButton()).as("Verify that cancel button displayed").isTrue();
        return this;
    }

    public GMCreateEstimatePageAssertion assertIfExpectedQuoteTypeDisplayed(String quoteType) {
        assertThat(functionalLibrary.getTextQuoteType(quoteType)).as("Verify that expected QuoteType got displayed").isTrue();
        return this;
    }

    public GMCreateEstimatePageAssertion assertIfWarningDialogDisplayed() {
        assertThat(functionalLibrary.verifyWarningDialog()).as("Verify that warning dialog is displayed").isTrue();
        return this;
    }

    public GMCreateEstimatePageAssertion assertIfWarningDialognotDisplayed() {
        assertThat(functionalLibrary.verifyWarningDialog()).as("Verify that Warning dialog is not displayed").isFalse();
        return this;
    }

    public GMCreateEstimatePageAssertion assertIfExcelFileDownloaded(String dateFormat, String fileFormat) {
        assertThat(functionalLibrary.validateFilenameWithPartialText(dateFormat, fileFormat)).as("Verify that expected excel file getting downloaded").isTrue();
        return this;
    }

    public GMCreateEstimatePageAssertion assertIfFileDownloaded() {
        assertThat(functionalLibrary.CheckFileDownloaded()).as("Verify that expected file getting downloaded").isTrue();
        return this;
    }

    public GMCreateEstimatePageAssertion assetLabourPrice(String labourPrice)
    {
        assertThat(functionalLibrary.getLabourPrice(labourPrice)).as("Verify expected labour price got displayed").isTrue();
        return this;
    }

    public GMCreateEstimatePageAssertion assertIfFluidOptionalPriceDisplayed()
    {
        assertThat(functionalLibrary.verifyFluidOptionalPrice()).as("Fluid optional price displayed in job details").isTrue();
        return this;
    }

    public GMCreateEstimatePageAssertion assertIfSpecificWindowNotDisplayed(String title)
    {
        assertThat(functionalLibrary.verifySingleWindow(title)).as("verify specific window not displayed").isTrue();
        return this;
    }

    public GMCreateEstimatePageAssertion assertIfFluidOptionalPricenotDisplayed()
    {
        assertThat(functionalLibrary.verifyFluidOptionalpriceDisplayed()).as("Fluid optional price not displayed in job details").isFalse();
        return this;
    }

    public GMCreateEstimatePageAssertion assertIfHistoricQuotePageDisplayed()
    {
        assertThat(functionalLibrary.verifyHistoricQuotePage()).as("verify historic quote page displayed").isTrue();
        return this;
    }

    public GMCreateEstimatePageAssertion assertIfQuoteItemAdded(String jobName)
    {
        assertThat(functionalLibrary.verifyJob(jobName)).as("verify Quote item is displayed").isTrue();
        return this;
    }

    public GMCreateEstimatePageAssertion assertIfPartPriceWithLabourCostDisplayed()
    {
        assertThat(functionalLibrary.verifyPariceExTax()).as("Verify Part price with expected labour cost is displayed").isTrue();
        return this;
    }

    public GMCreateEstimatePageAssertion assertIfDealerDescriptionAppendedWithGivenText(String appendText)
    {
        assertThat(functionalLibrary.verifyDescription(appendText)).as("Verify dealer description appended with given text").isTrue();
        return this;
    }

    public GMCreateEstimatePageAssertion assertIfPartPriceWithGivenTaxDisplayed(String tax, String job)
    {
        assertThat(functionalLibrary.verifyPriceInclTax(tax, job)).as("Verify expected part price with given tax is displayed").isTrue();
        return this;
    }

    public GMCreateEstimatePageAssertion assertIfPriceWithTaxDisplayed(String tax)
    {
        assertThat(functionalLibrary.verifyPriceTax(tax)).as("Verify expected price is displayed").isTrue();
        return this;
    }
}

