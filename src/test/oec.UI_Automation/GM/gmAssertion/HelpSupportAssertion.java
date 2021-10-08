package GM.gmAssertion;

import GM.gmObjectRepository.HelpSupportPage;
import base.AbstractAssertion;

import static org.assertj.core.api.Assertions.assertThat;

public class HelpSupportAssertion extends AbstractAssertion<HelpSupportPage> {

    public HelpSupportAssertion assertAtHelpSupportPage() {
        assertThat((functionalLibrary.isAt(functionalLibrary.getBaseURL()))).as("Verify that you are at 'Home' page").isTrue();
        return this;
    }
    public HelpSupportAssertion assertContactNo(String expectedDetails) {
        assertThat(functionalLibrary.getContactNo()).as("Verify the contact number is correct").contains(expectedDetails);
        return this;
    }

    public HelpSupportAssertion assertLink(String expectedDetails) {
        assertThat(functionalLibrary.getLink()).as("Verify the help link is correct").contains(expectedDetails);
        return this;
    }

    public HelpSupportAssertion assertPageTitle(String expectedDetails) {
        assertThat(functionalLibrary.getPageTitle()).as("Verify the page title").contains(expectedDetails);
        return this;
    }

    public HelpSupportAssertion assertLinkCount(String expectedDetails) {
        assertThat(functionalLibrary.getLinkCount()).as("Verify the link count").contains(expectedDetails);
        return this;
    }

    public HelpSupportAssertion assertFileExist(String environment){
        assertThat(functionalLibrary.getFile(environment)).as("Verify file is present").isTrue();
        return this;
    }
}