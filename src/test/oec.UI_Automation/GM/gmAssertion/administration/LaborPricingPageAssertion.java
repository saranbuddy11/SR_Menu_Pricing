package GM.gmAssertion.administration;

import GM.gmObjectRepository.administration.LaborPricingPage;
import base.AbstractAssertion;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LaborPricingPageAssertion extends AbstractAssertion<LaborPricingPage> {

    public LaborPricingPageAssertion assertIfLaborPricingTab() {
        assertThat(functionalLibrary.getColor("Labor Pricing")).as("Verify that User at Labor Pricing").isEqualTo(functionalLibrary.ORANGE_COLOR_HEX_CODE);
        return this;
    }

    public LaborPricingPageAssertion assertIfNewLabourValueIsSaved(String expectedLaborRetailValue) {
        assertThat(functionalLibrary.getLaborRetailValue()).as("New labour value is saved.").isEqualTo(expectedLaborRetailValue);
        return this;
    }

    public LaborPricingPageAssertion assertAtSingleLaborRateTab() {
        assertThat(functionalLibrary.getSingleLaborRateColor("Single Labor Rate")).as("Verify that User at Single Labor Rate").isEqualTo(functionalLibrary.RED_COLOR_HEX_CODE);
        return this;
    }

    public LaborPricingPageAssertion assertAtJobDifficultyTab() {
        assertThat(functionalLibrary.getJobDifficultyColor("Job Difficulty")).as("Verify that User at Job Difficulty").isEqualTo(functionalLibrary.RED_COLOR_HEX_CODE);
        return this;
    }

    public LaborPricingPageAssertion assertAtLaborMatrixTab() {
        assertThat(functionalLibrary.getJobDifficultyColor("Labor Matrix")).as("Verify that User at Labor Matrix").isEqualTo(functionalLibrary.RED_COLOR_HEX_CODE);
        return this;
    }

    public LaborPricingPageAssertion assertIfUserAdvisedTheyNeedToAddValues(String expectedWarnMsg) {
        assertThat(functionalLibrary.getWarningMsg()).as("User is advised they need to add values for all difficulty levels.").isEqualTo(expectedWarnMsg);
        return this;
    }

    public LaborPricingPageAssertion assertIfVehicleRatesAreSavedInDefaultOptionBox(List<String> expectedWarnMsg) {
        assertThat(functionalLibrary.getDefaultOptionVehicleRetailPrice()).as("Rates are saved").containsAll(expectedWarnMsg);
        return this;
    }

    public LaborPricingPageAssertion assertIfModelsAreSortedInAlphabetical(String vehicleType) {
        List<String> expectedVehicleModels = functionalLibrary.getVehicleModels(vehicleType);
        Collections.sort(expectedVehicleModels);
        assertThat(functionalLibrary.getVehicleModels(vehicleType)).as("Models are sorted in alphabetical order by Brand and by Model under each vehicle type").isEqualTo(expectedVehicleModels);
        return this;
    }

    public LaborPricingPageAssertion assertIfAllEmptyCellsArePopulatedWithTheValue() {
        assertThat(functionalLibrary.getPopulateEmptyCellsValue()).as("All empty cells are populated with the value.").containsOnly("10.00");
        return this;
    }

    public LaborPricingPageAssertion assertIfAllRatesAreConvertedIntoPrice(int value) {
        List<String> expectedTotalPrice = functionalLibrary.getPopulateEmptyCellsValue(value);
        assertThat(functionalLibrary.getPopulateEmptyCellsValue()).as("All rates are converted into a Price and prices are calculated correctly.").isEqualTo(expectedTotalPrice);
        return this;
    }

    public LaborPricingPageAssertion assertIfJobContentSearchIsPopulatedWithTheJobHierarchy() {
        for (int i = 1; i <= functionalLibrary.getJobHierarchySize(); i++) {
            assertThat(functionalLibrary.isJobHierarchyDisplayed(i)).as("the job Content Search is populated with the job hierarchy.").isTrue();
        }
        for (int i = 1; i <= functionalLibrary.getPopulateValuesSize(); i++) {
            assertThat(functionalLibrary.isLaborRateEditable(i)).as("Cells are changed to Exception view").isFalse();
        }
        return this;
    }

    public LaborPricingPageAssertion assertIfTheRateIsConvertedIntoAPriceAndTickBoxesAreDisabled(float value) {
        Float CalculatedPrice = value * Float.parseFloat(functionalLibrary.getLaborRateHourFormated3Value().trim());
        String expectedCalculatedPrice = functionalLibrary.df.format(CalculatedPrice);
        assertThat(functionalLibrary.getLaborRateFormated3Value()).as("The rate is converted into a Price and is calculated correctly.").isEqualTo(expectedCalculatedPrice);
        for (int i = 1; i <= functionalLibrary.getMatrixCheckBoxSize(); i++) {
            assertThat(functionalLibrary.isRowsTickBoxesDisabled(i)).as("Tick boxes are disabled.").isTrue();
        }
        return this;
    }

    public LaborPricingPageAssertion assertIfExceptionRateIsDeleted() {
        assertThat(functionalLibrary.isMatrixEditable()).as("Exception rate is deleted .").isFalse();
        return this;
    }
}
