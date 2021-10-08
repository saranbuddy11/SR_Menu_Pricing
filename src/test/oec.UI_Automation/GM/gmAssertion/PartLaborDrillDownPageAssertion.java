package GM.gmAssertion;

import GM.gmObjectRepository.PartLaborDrillDownPage;
import base.AbstractAssertion;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PartLaborDrillDownPageAssertion extends AbstractAssertion<PartLaborDrillDownPage> {
    public PartLaborDrillDownPageAssertion assertIfPartsAndLabourDetailsOpened() {
        Boolean actualPrice = functionalLibrary.IsPartsAndLaborDetailDisplayed();
        assertThat(actualPrice).as("Verify that opened the Parts and Labour details.").isTrue();
        return this;
    }

    public PartLaborDrillDownPageAssertion assertIfPartsAndLabourItemsAreShownAlongWithTheirPrice(List<List<String>> expectedPartAndPrice, List<List<String>> expectedLaborAndPRice) {
        assertThat(functionalLibrary.getPartDescriptionAndPriceList()).as("Verify that Parts items are shown along with their price EX VAT.").isEqualTo(expectedPartAndPrice);
        assertThat(functionalLibrary.getLaborDescriptionAndPriceList()).as("Verify that Labour items are shown along with their price EX VAT.").isEqualTo(expectedLaborAndPRice);
        return this;
    }

    public PartLaborDrillDownPageAssertion assertIfNewLabourCodeIsAddedToTheJobShowingWithThePrice(List<String> expectedNewLaborCode) {
        assertThat(functionalLibrary.getAddedLabourCode()).as("Verify that The new labour code is added to the job, showing the price EX VAT.").isEqualTo(expectedNewLaborCode);
        return this;
    }

    public PartLaborDrillDownPageAssertion assertIfTheJobsTotalPriceIsReCalculatedWithTheNewLabourTime(List<String> expectedNewLaborCode) {
        assertThat(functionalLibrary.getAddedLabourCode()).as("Verify that The new labour code is added to the job, showing the price EX VAT.").isEqualTo(expectedNewLaborCode);
        return this;
    }

    public PartLaborDrillDownPageAssertion assertIfNewJobIsAddedToQuote(String expectedNewLaborJob) {
        assertThat(functionalLibrary.getAddedJobToLaborList()).as("Verify that Estimate is started and Job is added to quote.").isEqualTo(expectedNewLaborJob);
        return this;
    }

    public PartLaborDrillDownPageAssertion assertIfNewJobIsAddedToQuotePriceAsExpected(String laborRetailPricePerHr) {
        assertThat(functionalLibrary.getTotalPrice(laborRetailPricePerHr)).as("Verify that Estimate is started and Job is added to quote.").isEqualTo(functionalLibrary.getLaborTotalPriceToAddedJob());
        return this;
    }

    public PartLaborDrillDownPageAssertion assertIfAddedPartsAreShownAlongWithTheirPrice(List<String> expectedPartAndPrice) {
        assertThat(functionalLibrary.getPartDescriptionAndPrice()).as("Verify that Price 1.99 should be visible").isEqualTo(expectedPartAndPrice);
        return this;
    }

    public PartLaborDrillDownPageAssertion assertIfCostPriceDiscountApplied(Double costPrice, int percentage) {
        Double price = costPrice + (costPrice * (percentage / 100.0f));
        double roundOff = Math.round(price * 100) / 100.0;
        double actualPrice = Math.round(functionalLibrary.getPartCostPrice() * 100) / 100.0;
        assertThat(actualPrice).as("Verify that Cost Price from step 6 + 10% should be visible").isEqualTo(roundOff);
        return this;
    }

    public PartLaborDrillDownPageAssertion assertIfCostPriceDeductionApplied(Double costPrice, int percentage) {
        Double price = costPrice - (costPrice * (percentage / 100.0f));
        double expectedPrice = Math.round(price * 100) / 100.0;
        double actualPrice = Math.round(functionalLibrary.getPartCostPrice() * 100) / 100.0;
        assertThat(actualPrice).as("Verify that Cost Price from step 6 + 10% should be visible").isEqualTo(expectedPrice);
        return this;
    }

    public PartLaborDrillDownPageAssertion assertIfPartPriceForAddedJobBasedOnQuantity(Double exceptPartPrice) {
        double expectedPrice = Math.round(functionalLibrary.getPartCostPrice() * 100) / 100.0;
        double actualPrice = Math.round(functionalLibrary.getPartPriceForAQuantity(exceptPartPrice, 3) * 100) / 100.0;
        assertThat(actualPrice).as("Check part price.").isEqualTo(expectedPrice);
        return this;
    }

    public PartLaborDrillDownPageAssertion assertIfAddedPartsAreShownQuantityAlongWithTheirPrice(List<String> expectedPartAndPrice) {
        assertThat(functionalLibrary.getPartQuantityAndPrice(3)).as("Verify that Quantity and Price (Ex tax) should be visible" +expectedPartAndPrice).isEqualTo(expectedPartAndPrice);
        return this;
    }

    public PartLaborDrillDownPageAssertion assertIfGenericPartRoundUpApplied(Double containerSize, Double expectedPrice1, Double expectedPrice2, Double retailerPrice) {
        Double expectedPrice = 0.0d;
        if (environment.contains("qa")) {
            expectedPrice = expectedPrice1;
        } else if (environment.contains("uat")) {
            expectedPrice = expectedPrice2;
        }
        Double partPrice = (containerSize * retailerPrice);
        int actualPrice = functionalLibrary.getPartPriceForAQuantity(partPrice, 8).intValue();
        assertThat(actualPrice).as("Verify Expected calculated qty in application = 4.2 quarts / container size of used part [rounded up]\n").isEqualTo(expectedPrice.intValue());
        return this;
    }

    public PartLaborDrillDownPageAssertion assertIfLabourPricingJobDifficultyApplied(int price, String LOC, int index) {
        String expectedPrice = functionalLibrary.getLaborTotalPriceToAddedJob();
        String actualPrice = functionalLibrary.getLaborTime(price, LOC, index);
        assertThat(actualPrice).as("Verify Simple job uses rate 10, Normal job uses rate 50, Complex job uses rate 100.").isEqualTo(expectedPrice);
        return this;
    }

    public PartLaborDrillDownPageAssertion assertIfLabourPricingTimeDisplayedAsSetInMenuManager(float expectedMins, String LOC, int index) {
        Float actualPrice = functionalLibrary.getLaborTimeWithoutPrice(LOC, index);
        assertThat(actualPrice).as("Verify that Menu manager rules take precedence over the Labor Pricing - Single Labor Rate.").isEqualTo(expectedMins);
        return this;
    }

    public PartLaborDrillDownPageAssertion assertIfJLRPartsAndLabourItemsAreShownAlongWithTheirPrice(List<List<String>> expectedPartAndPrice, List<List<String>> expectedLaborAndPRice) {
        assertThat(functionalLibrary.getPartsItemDescriptionAndPrice()).as("Verify that Parts items are shown along with their price EX VAT.").isEqualTo(expectedPartAndPrice);
        assertThat(functionalLibrary.getLabourItemDescriptionAndPrice()).as("Verify that Labour items are shown along with their price EX VAT.").isEqualTo(expectedLaborAndPRice);
        return this;
    }

    public PartLaborDrillDownPageAssertion assertUserAtSupportEnquiryPage() {
        assertThat(functionalLibrary.isSupportPageTitleDisplayed()).as("Verify that The support window loads").isTrue();
        return this;
    }

    public PartLaborDrillDownPageAssertion assertIfUserWarnedToSelectAPartToSendEnquiry(String warnMsg) {
        assertThat(functionalLibrary.getErrorMsg()).as("Verify that Error message displayed: 'Please select at least one Part or Labour to send enquiry.").isEqualTo(warnMsg);
        return this;
    }
}