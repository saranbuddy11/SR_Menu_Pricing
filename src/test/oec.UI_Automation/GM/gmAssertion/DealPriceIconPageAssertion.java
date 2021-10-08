package GM.gmAssertion;

import GM.gmObjectRepository.DealPriceIconPage;
import base.AbstractAssertion;

import static org.assertj.core.api.Assertions.assertThat;

public class DealPriceIconPageAssertion extends AbstractAssertion<DealPriceIconPage> {

    public DealPriceIconPageAssertion assertIfSetDealPriceWindowOpened() {
        assertThat(functionalLibrary.isDealPriceTitleDisplayed()).as("Verify that Set Deal Price window opens.").isTrue();
        return this;
    }

    public DealPriceIconPageAssertion assertIfDescriptionChanged() {
        assertThat(functionalLibrary.getRenameDiscountDescription()).as("Verify that Description can be changed.").isTrue();
        return this;
    }

    public DealPriceIconPageAssertion assertIfFieldAcceptsNumbers() {
        assertThat(functionalLibrary.isDealPriceEnteredDigit()).as("Verify that Field accepts numbers.").isTrue();
        return this;
    }

    public DealPriceIconPageAssertion assertIfUserWarnedThatDealPriceIsRequiredMsg(String warnMsg) {
        assertThat(functionalLibrary.getDealPriceWarnMsg()).as("Verify that User is warned that a Deal Price is required.").isEqualTo(warnMsg);
        return this;
    }

    public DealPriceIconPageAssertion assertIfJLRUserWarnedThatDealPriceIsRequiredMsg(String warnMsg) {
        assertThat(functionalLibrary.getJLRDealPriceWarnMsg()).as("Verify that User is warned that a Deal Price is required.").isEqualTo(warnMsg);
        return this;
    }
}
