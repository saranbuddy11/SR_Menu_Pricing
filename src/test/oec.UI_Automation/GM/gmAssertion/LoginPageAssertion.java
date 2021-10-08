package GM.gmAssertion;

import GM.gmObjectRepository.LoginPage;
import base.AbstractAssertion;
import model.Market;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LoginPageAssertion extends AbstractAssertion<LoginPage> {

//    public LoginPageAssertion assertAtLoginPage() {
//        String currentUrl = functionalLibrary.getPageUrl();
//        String expectedUrl = functionalLibrary.getBaseURL();
//        assertThat(functionalLibrary.isAt(expectedUrl)).as("verify if the current page is at 'Login Page'" +
//                "\nExpected: " + expectedUrl + "\nActual: " + currentUrl)
//                .isTrue();
//        return this;
//    }
//    public LoginPageAssertion assertRequiredFieldsArePresent() {
//        assertThat(functionalLibrary.isDealerIDDisplayed()).as("Verify that DealerID field is present.").isTrue();
//        assertThat(functionalLibrary.isUserIDDisplayed()).as("Verify that UserID field is present.").isTrue();
//        assertThat(functionalLibrary.isPasswordDisplayed()).as("Verify that Password field is present.").isTrue();
//        assertThat(functionalLibrary.isMarketDisplayed()).as("Verify that Market field is present.").isTrue();
//        assertThat(functionalLibrary.isLoginBtnDisplayed()).as("Verify that Login Button is present.").isTrue();
//        return this;
//    }

    public LoginPageAssertion assertLoginValidationErrorDisplayed_InValidUserId_InvalidPassword() {
        String cc = functionalLibrary.getLoginErrorMessage();
        assertThat(functionalLibrary.getLoginErrorMessage()).as("Verify Login Validation Error Displayed .")
                .contains("Please supply a valid combination of dealer code, user name, password and market to proceed");
        return this;
    }

    public LoginPageAssertion assertAtLoginPage() {
        String currentUrl = functionalLibrary.getPageUrl();
        String expectedUrl = functionalLibrary.getBaseURL();
        assertThat(functionalLibrary.isAt(expectedUrl)).as("verify if at 'Login Page' page" +
                "\nExpected: " + expectedUrl + "\nActual: " + currentUrl)
                .isTrue();
        return this;
    }

    public LoginPageAssertion assertIfHeaderTextAndTabPresent(String title, List<String> headers) {
        assertThat(functionalLibrary.getLoginPageHeaders()).as("Verify that headers are displayed.").isEqualTo(headers);
        return this;
    }

    public LoginPageAssertion assertRequiredFieldsArePresent() {
        assertThat(functionalLibrary.isDealerIDDisplayed()).as("Verify that DealerID field is present.").isTrue();
        assertThat(functionalLibrary.isUserIDDisplayed()).as("Verify that UserID field is present.").isTrue();
        assertThat(functionalLibrary.isPasswordDisplayed()).as("Verify that Password field is present.").isTrue();
        assertThat(functionalLibrary.isMarketDisplayed()).as("Verify that Market field is present.").isTrue();
        assertThat(functionalLibrary.isLoginBtnDisplayed()).as("Verify that Login Button is present.").isTrue();
        return this;
    }

    public LoginPageAssertion assertHYDLoginValidationErrorDisplayed_InValidEmail_WrongPassword(String errorMsg) {
        assertThat(functionalLibrary.getLoginErrorMessage()).as("Verify Login Validation Error Displayed").isEqualTo("Please supply a valid combination of dealer code, user name, password and market to proceed.\n" +
                "hmuk.support@oeconnection.com    0333 003 1922");
        return this;
    }

    public LoginPageAssertion assertGMLoginValidationErrorDisplayed_InValidEmail_WrongPassword() {
        assertThat(functionalLibrary.getLoginErrorMessage()).as("Verify Login Validation Error Displayed").isEqualTo("Please supply a valid combination of dealer code, user name, password and market to proceed.\n" +
                "NO ENTRY");
        return this;
    }

    public LoginPageAssertion assertJLRLoginValidationErrorDisplayed_InValidEmail_WrongPassword() {
        assertThat(functionalLibrary.getLoginErrorMessage()).as("Verify Login Validation Error Displayed").contains("Please supply a valid combination of retailer code, user name, password and market to proceed.");
        return this;
    }

    public LoginPageAssertion assertOpelLoginValidationErrorDisplayed_InValidEmail_WrongPassword() {
        assertThat(functionalLibrary.getLoginErrorMessage()).as("Verify Login Validation Error Displayed").isEqualTo("Please supply a valid combination of dealer code, user name, password and market to proceed.\n" +
                "0800 917 4781");
        return this;
    }

    public LoginPageAssertion assertMoparLoginValidationErrorDisplayed_InValidEmail_WrongPassword() {
        assertThat(functionalLibrary.getLoginErrorMessage()).as("Verify Login Validation Error Displayed").isEqualTo("Please supply a valid combination of dealer code, user name, password and market to proceed.");
        return this;
    }

    public LoginPageAssertion assertIfLoginValidationErrorDisplayed_InvalidCredentials(String errorMsg1, String errorMsg2) {
        String expectedValue = errorMsg1 + "\n" + errorMsg2;
        assertThat(functionalLibrary.getLoginErrorMessages()).as("Verify Login Validation Error Displayed")
                .isEqualTo(expectedValue);
        return this;
    }

    public LoginPageAssertion assertIfCursorPointAt(String name) {
        assertThat(functionalLibrary.isCursorAt(name)).as("Verify that cursorPoint is present.").isTrue();
        return this;
    }

    public LoginPageAssertion assertIfCopyAndPasteDoesNotPossibleInPassword() {
        assertThat(functionalLibrary.getPassword()).as("This should not be possible.").isEmpty();
        return this;
    }

    public LoginPageAssertion assertIfDropdownSelectedMarketWillChangeToThatCountry() {
        String expectedMarket = String.valueOf(Market.ES);
        assertThat(functionalLibrary.getSelectedMarket()).as("Verify that Market selected.").isEqualTo(expectedMarket);
        return this;
    }

    public LoginPageAssertion assertIfAccountDisabledSErrorMsgDisplayed(String expectedErrorMsg) {
        assertThat(functionalLibrary.getLoginErrorMessage()).as("Verify Login Validation Error Displayed .")
                .contains(expectedErrorMsg);
        return this;
    }

}
