package GM.gmAssertion;

import GM.gmObjectRepository.GMCreateEstimateNotesPage;
import base.AbstractAssertion;

import java.util.Arrays;
import java.util.List;

import static base.FunctionalLibrary.getCurrentDate;
import static org.assertj.core.api.Assertions.assertThat;

public class GMCreateEstimatesNotesPageAssertion extends AbstractAssertion<GMCreateEstimateNotesPage> {

    public GMCreateEstimatesNotesPageAssertion assertAtNotesTab() {
        String color = null;
        if (System.getProperty("environment").contains("jlrmenupricingonline")) {
            color = functionalLibrary.BLACK_COLOR_HEX_CODE;
        }
        if (System.getProperty("environment").contains("gmmenupricingonline")) {
            color = functionalLibrary.ORANGE_COLOR_HEX_CODE;
        }
        assertThat(functionalLibrary.getColor("Notes")).as("Verify that Notes Tab is Selected.").isEqualTo(color);
        return this;
    }

    public GMCreateEstimatesNotesPageAssertion assertIfVehiclesVINAreShownInTheCorrespondingBoxes(String vinNo) {
        assertThat(functionalLibrary.isVinDisplayedBox(vinNo)).as("Verify that vehicles VIN are shown in the corresponding boxes.").isTrue();
        return this;
    }

    public GMCreateEstimatesNotesPageAssertion assertIfVehicleEstimateValidDateChanged() {
        String expectedDate = null;
        if (environment.contains("JLR")) {
            expectedDate = functionalLibrary.getCurrentDateSystemFormat();
        } else if (environment.contains("GM")) {
            expectedDate = functionalLibrary.getCurrentDate();
        }
        assertThat(functionalLibrary.getEstimateValidateChanged()).as("Verify that ate changed.").isEqualTo(expectedDate);
        return this;
    }

    public GMCreateEstimatesNotesPageAssertion assertIfNotesUpdated(String text) {
        assertThat(functionalLibrary.getNotesText()).as("Verify that notes updated.").isEqualTo(text);
        return this;
    }

    public GMCreateEstimatesNotesPageAssertion assertIfRegVINAndDistanceBoxesAreEmpty() {
        System.out.println(functionalLibrary.getFormFieldValue());
        assertThat(functionalLibrary.getFormFieldValue()).as("Verify that Reg, VIN and Distance boxes are empty.").isEqualTo(Arrays.asList("", "", ""));
        return this;
    }

    public GMCreateEstimatesNotesPageAssertion assertIfRegAndVINCanBeManuallyEntered(List<String> vinAndRegNo) {
        assertThat(functionalLibrary.getVinAndRegNoValue()).as("Verify that Reg & VIN can be manually entered.").isEqualTo(vinAndRegNo);
        return this;
    }

    public GMCreateEstimatesNotesPageAssertion assertIfTextInputShouldBeDisabledInMileageTextBox() {
        assertThat(functionalLibrary.getMileageTextBoxValue()).as("Verify that Text input should be disabled. ").isEqualTo("");
        return this;
    }

    public GMCreateEstimatesNotesPageAssertion assertAtJLRNotesTab() {
        assertThat(functionalLibrary.getColor("Notes")).as("Verify that Notes Tab is Selected.").isEqualTo(functionalLibrary.BLACK_COLOR_HEX_CODE);
        return this;
    }

    public GMCreateEstimatesNotesPageAssertion assertIfNoteValidUntilDateChanged(String date) {
        assertThat(functionalLibrary.getNoteValidUntilDate()).as("Date changed.").isEqualTo(date);
        return this;
    }

    public GMCreateEstimatesNotesPageAssertion assertIfTheSixDigitsIsTheLimitForThisField(String expectedMileage) {
        assertThat(functionalLibrary.getMileageTextBoxValue()).as("Verify that 6 digits is the limit for this field.  ").isEqualTo(expectedMileage);
        return this;
    }

    public GMCreateEstimatesNotesPageAssertion assertIfTheFieldAcceptsTheReasonableFigureMileageTextBox() {
        int actualValue = functionalLibrary.getMileageTextBoxValue().length();
        assertThat(actualValue).as("Verify that The field accepts the reasonable figure. ").isEqualTo(6);
        return this;
    }
}
