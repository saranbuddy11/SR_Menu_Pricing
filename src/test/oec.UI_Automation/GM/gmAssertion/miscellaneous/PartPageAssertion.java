package GM.gmAssertion.miscellaneous;

import GM.gmObjectRepository.miscellaneous.PartPage;
import base.AbstractAssertion;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PartPageAssertion extends AbstractAssertion<PartPage> {

    public PartPageAssertion assertIsAtMiscellaneousPartPage() {
        assertThat((functionalLibrary.isAt(functionalLibrary.getBaseURL()))).as("verify if at 'Miscellaneous Part' page.").isTrue();
        return this;
    }

    public PartPageAssertion assertAtManufacturerPartsSearchPage() {
        assertThat(functionalLibrary.isSearchTitleDisplayed()).as("Verify that  The window changes to the Manufacturer Parts search.").isTrue();
        return this;
    }

    public PartPageAssertion assertIfPartIsFoundAndDisplayedInTheList(int index) {
        assertThat(functionalLibrary.isSearchResultDisplayed(index)).as("Verify that  The part is found and displayed in the list").isTrue();
        return this;
    }

    public PartPageAssertion assertIfSelectedPartsDetailsPopulatedWithData() {
        List<String> actualResult = functionalLibrary.getFilledInputElementsDisplayed();
        assertThat(actualResult).as("Verify that The window changes back to the Misc part screen with the selected parts details populated.").isNotEqualTo("null");
        return this;
    }
}
