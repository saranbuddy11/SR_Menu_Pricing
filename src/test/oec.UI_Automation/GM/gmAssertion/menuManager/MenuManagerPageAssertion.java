package GM.gmAssertion.menuManager;

import GM.gmObjectRepository.menuManager.MenuManagerPage;
import base.AbstractAssertion;

import static org.assertj.core.api.Assertions.assertThat;

public class MenuManagerPageAssertion extends AbstractAssertion<MenuManagerPage> {

    public MenuManagerPageAssertion assertAtRuleBasicsTab() {
        assertThat(functionalLibrary.getColor("Rule Basics")).as("Verify that User at Rule Basics tab")
                .isEqualTo(functionalLibrary.ORANGE_COLOR_HEX_CODE);
        return this;
    }

    public MenuManagerPageAssertion assertAtListRulesTab() {
        assertThat(functionalLibrary.getColor("List Rules")).as("Verify that User at List Rules tab")
                .isEqualTo(functionalLibrary.ORANGE_COLOR_HEX_CODE);
        return this;
    }

    public MenuManagerPageAssertion assertIfTheInputIsKeptAndTheRuleIsCopied(String expectedNameOfIDRule) {
        assertThat(functionalLibrary.getNameOfIdRule()).as("Verify that The input is kept, and the rule is copied ")
                .isEqualTo(expectedNameOfIDRule);
        return this;
    }

    public MenuManagerPageAssertion assertAtRuleStructureTab() {
        assertThat(functionalLibrary.getColorOfRuleStructureTab()).as("Verify that User at Rule Structure tab")
                .isEqualTo(functionalLibrary.ORANGE_COLOR_HEX_CODE);
        return this;
    }

    public MenuManagerPageAssertion assertIfRuleStructureStatusIsSaved() {
        assertThat(functionalLibrary.isRuleStructureSaved()).as("Verify that Any input is saved, the user can then proceed to rule structure. ")
                .isTrue();
        return this;
    }

    public MenuManagerPageAssertion assertIfReportResultsPulledBackDependOnTheRangeEntered(String date) {
        assertThat(functionalLibrary.getReportResult()).as("Verify that The results pulled back depend on the range entered")
                .contains(date);
        return this;
    }

    public MenuManagerPageAssertion assertIfRulesFileDownloadedSuccessfully(String fileName) {
        assertThat(functionalLibrary.isFileDownloaded(fileName)).as("Verify that Downloaded successfully").isTrue();
        return this;
    }

    public MenuManagerPageAssertion assertIfRuleAppendedToCurrent() {
        assertThat(functionalLibrary.isAppendedRule()).as("Upload successful. Rules appended to current")
                .isTrue();
        return this;
    }

    public MenuManagerPageAssertion assertIfTheRuleIsRemovedFromTheListRuleTable(String ruleName) {
        assertThat(functionalLibrary.getListOfRuleNames()).as("Verify that The rule is removed from the table. ")
                .doesNotContain(ruleName);
        return this;
    }

    public MenuManagerPageAssertion assertIfAllRulesCurrentlyCreatedWillBeDeployedToTheEnvironment(String date) {
        assertThat(functionalLibrary.getDeployedDate()).as("Verify that All rules currently created will be 'deployed' to the enviroment.")
                .containsIgnoringCase(date);
        return this;
    }

    public MenuManagerPageAssertion assertIfFieldsAndDropDownContainTheRelevantData(String value1, String value2, String value3) {
        assertThat(functionalLibrary.getConditionEntryValue1()).as("Verify that Dropdown menus contain relevant data.")
                .isEqualTo(value1);
        assertThat(functionalLibrary.getEffectEntryValue1()).as("Verify that menus contain relevant data.\n")
                .isEqualTo(value2);
        assertThat(functionalLibrary.is240EffectComponentAutoAddMenuSelected()).as("Verify that menus contain relevant data.\n")
                .isTrue();
        assertThat(functionalLibrary.getEffectEntryValue2()).as("Verify that menus contain relevant data.\n")
                .isEqualTo(value3);
        return this;
    }

    public MenuManagerPageAssertion assertIfDateFieldAmendable(String date) {
        assertThat(functionalLibrary.getBeforeDate()).as("Field amendable").isEqualTo(date);
        return this;
    }

    public MenuManagerPageAssertion assertIfExpectedRuleStructureDisplayed(String effect1, String effect2){
        assertThat(functionalLibrary.verifyEffect(effect1, effect2)).as("Verify expected rule structure is displayed").isTrue();
        return this;
    }
}
