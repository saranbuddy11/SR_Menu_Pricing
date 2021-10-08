package MOPAR.moparAssertion;

import MOPAR.moparObjectRepository.MOPARLoginPage;
import base.AbstractAssertion;

import static org.assertj.core.api.Assertions.assertThat;

public class MOPARLoginPageAssertion extends AbstractAssertion<MOPARLoginPage> {

    public MOPARLoginPageAssertion assertAtLoginPage() {
        String currentUrl = functionalLibrary.getPageUrl();
        String expectedUrl = functionalLibrary.getBaseURL();
        assertThat(functionalLibrary.isAt(expectedUrl)).as("verify if at 'Login Page' page" +
                "\nExpected: " + expectedUrl + "\nActual: " + currentUrl)
                .isTrue();
        return this;
    }

    public MOPARLoginPageAssertion assertRequiredFieldsArePresent() {
        assertThat(functionalLibrary.isDealerIDDisplayed()).as("Verify that DealerID field is present.").isTrue();
        assertThat(functionalLibrary.isUserIDDisplayed()).as("Verify that UserID field is present.").isTrue();
        assertThat(functionalLibrary.isPasswordDisplayed()).as("Verify that Password field is present.").isTrue();
        assertThat(functionalLibrary.isMarketDisplayed()).as("Verify that Market field is present.").isTrue();
        assertThat(functionalLibrary.isAdviseMessageDisplayed()).as("Verify that Advise Message is present.").isTrue();
        assertThat(functionalLibrary.isLoginBtnDisplayed()).as("Verify that Login Button is present.").isTrue();
        return this;
    }

    public MOPARLoginPageAssertion assertLoginValidationErrorDisplayed_InValidEmail_WrongPassword() {
        assertThat(functionalLibrary.getLoginErrorMessage()).as("Verify Login Validation Error Displayed .")
                .isEqualTo("Please supply a valid combination of dealer code, user name, password and market to proceed.");
        return this;
    }
}
