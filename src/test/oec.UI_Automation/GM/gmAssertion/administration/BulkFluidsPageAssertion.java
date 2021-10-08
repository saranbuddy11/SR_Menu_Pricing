package GM.gmAssertion.administration;

import GM.gmObjectRepository.administration.BulkFluidsPage;
import base.AbstractAssertion;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BulkFluidsPageAssertion extends AbstractAssertion<BulkFluidsPage> {

    public BulkFluidsPageAssertion assertAtBulkFluidsTab() {
        assertThat(functionalLibrary.getColor("Bulk Fluids")).as("Verify that User at Bulk Fluids page").isEqualTo(functionalLibrary.ORANGE_COLOR_HEX_CODE);
        return this;
    }

    public BulkFluidsPageAssertion assertIfLocalPartAddedWithCorrectData(List<String> addedPartDetails, int index) {
        assertThat(functionalLibrary.getAddedLocalPart(index)).as("Verify that Local part \"Test part 1\" is added with correct data.").isEqualTo(addedPartDetails);
        return this;
    }

    public BulkFluidsPageAssertion assertIfAdministrationBulkFluidsTabOnlyMarketAndLocalFluidTypesAreDisplayed(String expectedLabel) {
        assertThat(functionalLibrary.getFormLabel()).as("Verify that For Administration/BulkFluids tab Only Market and Local fluid types are displayed. ").isEqualTo(expectedLabel);
        assertThat(functionalLibrary.getDropDownValue()).as("Verify that There is no Manufacturer Parts for 'Please select a LocalPart' drop down box values").isEmpty();
        return this;
    }

    public BulkFluidsPageAssertion assertIfLocalPrtDetailsPopulatedIntoEditBoxes() {
        assertThat(functionalLibrary.getEditFieldLocalPart()).as("Verify that Local part details populated into edit boxes.").isNotNull();
        return this;
    }

    public BulkFluidsPageAssertion assertIfLocalPartDeletedFromList(String deletedDescription) {
        assertThat(functionalLibrary.getDescriptionList()).as("Verify that Local part \"Test Part 11\" is deleted from the list.").doesNotContain(deletedDescription);
        return this;
    }

    public BulkFluidsPageAssertion assertIfLocalPartCreatedWithoutOpsCode(int index) {
        assertThat(functionalLibrary.getOperationCodeValue(index)).as("Verify that Local part can be created without entering an Ops code.").isEmpty();
        return this;
    }

    public BulkFluidsPageAssertion assertIfTextBoxCharacterMaxLimit(int expectedTextLimit, int index) {
        assertThat(functionalLibrary.getTextBoxCharSize(index)).as("Verify that A maximum of 20 characters can be entered into the Ops field.").isEqualTo(expectedTextLimit);
        return this;
    }

    public BulkFluidsPageAssertion assertIfLocalMarketPartIsDefined(int index) {
        assertThat(functionalLibrary.isMarketPartDefined(index)).as("Local Market Part is defined").isTrue();
        return this;
    }

    public BulkFluidsPageAssertion assertIfPartCanBeEditedOrSavedWithoutEnteringTheBrandAndQuality(int index) {
        assertThat(functionalLibrary.getBrandAndQualityValue(index)).as("Part can be edited/saved without entering the Brand/Quality.").isEmpty();
        return this;
    }

    public BulkFluidsPageAssertion assertIfPartEditedOrSavedWithEnteringTheBrandAndQuality(int index, String brandName) {
        assertThat(functionalLibrary.getBrandAndQualityValue(index)).as("Part edited/saved with entering the Brand/Quality.").isEqualTo(brandName);
        return this;
    }

    public BulkFluidsPageAssertion assertIfBulkFluidCollisionMessageDisplayed() {
        assertThat(functionalLibrary.isBulkFluidCollisionMessageDisplayed()).as("Bulk Fluid Collision Message is displayed").isTrue();
        return this;
    }

    public BulkFluidsPageAssertion assertIfGenericPartsTab() {
        assertThat(functionalLibrary.getColor("Generic Parts")).as("Verify that User at Generic Parts Page").isEqualTo(functionalLibrary.BLACK_COLOR_HEX_CODE);
        return this;
    }

    public BulkFluidsPageAssertion assertIfJLRLocalPartAddedWithCorrectData(List<String> addedPartDetails, int index1, int index2) {
        int index = 0;
        if (environment.contains("qa")) {
            index = index2;
        } else if (environment.contains("uat")) {
            index = index1;
        }
        assertThat(functionalLibrary.getJLRAddedLocalPart(index)).as("Verify that Local part \"Test part 1\" is added with correct data.").isEqualTo(addedPartDetails);
        return this;
    }
}