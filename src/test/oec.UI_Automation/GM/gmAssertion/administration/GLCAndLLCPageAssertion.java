package GM.gmAssertion.administration;

import GM.gmObjectRepository.administration.GLCAndLLCPage;
import base.AbstractAssertion;

import static org.assertj.core.api.Assertions.assertThat;

public class GLCAndLLCPageAssertion extends AbstractAssertion<GLCAndLLCPage> {

    public GLCAndLLCPageAssertion assertAtGLCAndLLCTab() {
        assertThat(functionalLibrary.getColor("GLC/LLC")).as("Verify that User at GLC/LLC").isEqualTo(functionalLibrary.ORANGE_COLOR_HEX_CODE);
        return this;
    }

    public GLCAndLLCPageAssertion assertIfGLCAndLLCListArePopulated() {
        assertThat(functionalLibrary.isElementPopulateWithDataDisplayed()).as("verify that Is possible to put values to fields").contains(true);
        return this;
    }

    public GLCAndLLCPageAssertion assertIfGLCAndLLCTablePopulatedWithInfo() {
        assertThat(functionalLibrary.getGLCAndLLCData()).as("Verify that The table is populated with information ").isNotNull();
        return this;
    }

    public GLCAndLLCPageAssertion assertIfLLCIsSetAgainstTheRelevantGLC(String llc) {
        assertThat(functionalLibrary.getLLC()).as("Verify that The LLC is set against the relevant GLC and the information is saved ").isEqualTo(llc);
        return this;
    }

    public GLCAndLLCPageAssertion assertIfAllUnmappedGLCAreDisplayed() {
        assertThat(functionalLibrary.getDescriptionGLCAndLLCData()).as("Verify that All unmapped GLC's are displayed ").isNotEqualTo("1111111");
        return this;
    }

    public GLCAndLLCPageAssertion assertIfResultsPulledBackBasedOnTheSearchTerm(String searchResult) {
        assertThat(functionalLibrary.getDescriptionGLCAndLLCData()).as("Verify that Results pulled back are based on the search term").contains(searchResult);
        return this;
    }
}
