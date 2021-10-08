package JLR.jlrAssertion;

import JLR.jlrObjectRepository.JLRLoginPage;
import base.AbstractAssertion;

import static org.assertj.core.api.Assertions.assertThat;

public class JLRLoginPageAssertion extends AbstractAssertion<JLRLoginPage> {

    public JLRLoginPageAssertion assertAtLoginPage() {
        String currentUrl = functionalLibrary.getPageUrl();
        String expectedUrl = functionalLibrary.getBaseURL();
        assertThat(functionalLibrary.isAt(expectedUrl)).as("verify if at 'Login Page' page" +
                "\nExpected: " + expectedUrl + "\nActual: " + currentUrl)
                .isTrue();
        return this;
    }

    public JLR.jlrAssertion.JLRLoginPageAssertion assertRequiredFieldsArePresent() {
        assertThat(functionalLibrary.isDealerIDDisplayed()).as("Verify that DealerID field is present.").isTrue();
        assertThat(functionalLibrary.isUserIDDisplayed()).as("Verify that UserID field is present.").isTrue();
        assertThat(functionalLibrary.isPasswordDisplayed()).as("Verify that Password field is present.").isTrue();
        assertThat(functionalLibrary.isMarketDisplayed()).as("Verify that Market field is present.").isTrue();
        assertThat(functionalLibrary.isLoginBtnDisplayed()).as("Verify that Login Button is present.").isTrue();
        return this;
    }

    public JLR.jlrAssertion.JLRLoginPageAssertion assertLoginValidationErrorDisplayed_InValidEmail_WrongPassword() {
        assertThat(functionalLibrary.getLoginErrorMessage()).as("Verify Login Validation Error Displayed .")
                .isEqualTo("Please supply a valid combination of retailer code, user name, password and market to proceed.\n" +
                        "jlr.support@oeconnection.com    0333 999 7821");
        return this;
    }

}

