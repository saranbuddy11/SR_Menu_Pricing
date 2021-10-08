package GM.gmAssertion.miscellaneous;


import GM.gmObjectRepository.miscellaneous.JobsPage;
import base.AbstractAssertion;

import static org.assertj.core.api.Assertions.assertThat;

public class JobsPageAssertion extends AbstractAssertion<JobsPage> {

    public JobsPageAssertion assertIsAtMiscellaneousJobsPage() {
        assertThat((functionalLibrary.isAt(functionalLibrary.getBaseURL()))).as("verify if at 'Miscellaneous Jobs' page.").isTrue();
        return this;
    }

    public JobsPageAssertion assertIfTaxRateIsTheMarketsDefaultZero(String expectedTaxRate) {
        assertThat(functionalLibrary.getTaxRate()).as("Verify that The Miscellaneous Jobs window opens. \n" + "Tax rate is the Markets default (0% for US)").isEqualTo(expectedTaxRate);
        return this;
    }

    public JobsPageAssertion assertIfMiscAddJobErrorMsgDisplayed(String expectedWarnMsg) {
        assertThat(functionalLibrary.getMiscAddJobErrorMsg()).as("Verify that A message is shown informing the user that all fields must be filled.").isEqualTo(expectedWarnMsg);
        return this;
    }
}