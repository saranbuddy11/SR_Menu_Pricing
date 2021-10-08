package GM.gmAssertion.miscellaneous;

import GM.gmObjectRepository.miscellaneous.LaborPage;
import base.AbstractAssertion;

import static org.assertj.core.api.Assertions.assertThat;

public class LaborPageAssertion extends AbstractAssertion<LaborPage> {

    public LaborPageAssertion assertIsAtMiscellaneousLaborPage() {
        assertThat((functionalLibrary.isAt(functionalLibrary.getBaseURL()))).as("verify if at 'Miscellaneous Labor' page.").isTrue();
        return this;
    }
}
