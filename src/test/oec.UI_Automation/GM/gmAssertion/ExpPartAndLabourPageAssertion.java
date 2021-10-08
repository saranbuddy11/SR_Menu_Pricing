package GM.gmAssertion;

import GM.gmObjectRepository.ExpPartAndLabourPage;
import base.AbstractAssertion;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ExpPartAndLabourPageAssertion extends AbstractAssertion<ExpPartAndLabourPage> {

    public ExpPartAndLabourPageAssertion assertIfExpPartAndLabourTab() {
        assertThat(functionalLibrary.getColor("Exp. PartAndLabour")).as("Verify that User at Customer Types").isEqualTo(functionalLibrary.BLACK_COLOR_HEX_CODE);
        return this;
    }

    public ExpPartAndLabourPageAssertion assertIfAllRadioBtnSelectedAsPerInput() {
        assertThat(functionalLibrary.isRadioOptionsSelected()).as("All radio buttons are clickable and fill once clicked.").isTrue();
        return this;
    }

    public ExpPartAndLabourPageAssertion assertIfDropDownFieldTextDisplayed() {
        assertThat(functionalLibrary.isBlankTextDisplayed()).as("verify that DropDown Text is Displayed").isTrue();
        return this;
    }

    public ExpPartAndLabourPageAssertion assertTheDropDownOptionItemsAreDisplayed(List<String> expectedOptions, String name) {
        assertThat(functionalLibrary.getBlackTextDropDownOptions(name)).as("verify that DropDown Item is Displayed").isEqualTo(expectedOptions);
        return this;
    }

    public ExpPartAndLabourPageAssertion assertIfSelectedBlankTextOption(String selectedOption, String name) {
        assertThat(functionalLibrary.getSelectedBlankTextOption(name)).as("verify that selected DropDown Text is Displayed").isEqualTo(selectedOption);
        return this;
    }

    public ExpPartAndLabourPageAssertion assertIfDropDownSeparatorFieldDisplayed() {
        assertThat(functionalLibrary.isSeparatorLabelDisplayed()).as("verify that Separator DropDown Text is Displayed").isTrue();
        return this;
    }

    public ExpPartAndLabourPageAssertion assertIfContentTransferableFromSelectedColumnToAvailableColumn(List<String> expectedColumnValues){
        assertThat(functionalLibrary.getAvailableColumnValues()).as("verify that ContentTransferableFromSelectedColumnToAvailableColumn").containsAll(expectedColumnValues);
        return this;
    }

    public ExpPartAndLabourPageAssertion assertIfContentTransferableFromAvailableColumnToSelectedColumn(List<String> expectedColumnValues){
        assertThat(functionalLibrary.getSelectedColumnValues()).as("verify that ContentTransferableFromSelectedColumnToAvailableColumn").containsAll(expectedColumnValues);
        return this;
    }

    public ExpPartAndLabourPageAssertion assertFileFormatSelected(String format){
        assertThat(functionalLibrary.getSelectedFormat(format)).as("expected format selected").isTrue();
        return this;
    }
}
