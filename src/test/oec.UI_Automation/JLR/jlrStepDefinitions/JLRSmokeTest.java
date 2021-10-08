package JLR.jlrStepDefinitions;

import GM.gmAssertion.CreateQuotePageAssertion;
import GM.gmObjectRepository.CreateQuotePage;
import JLR.jlrAssertion.JLRHomePageAssertion;
import JLR.jlrAssertion.JLRLoginPageAssertion;
import JLR.jlrObjectRepository.JLRHomePage;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import stepDefinitions.AbstractTest;


public class JLRSmokeTest extends AbstractTest {
    @Given("Go to the url & verify that the login screen is displayed with all required fields.")
    public void goToTheUrlVerifyThatTheLoginScreenIsDisplayedWithAllRequiredFields() {
        super.setUp();
        jlrLoginPage.startAssertions(JLRLoginPageAssertion.class)
                .assertAtLoginPage()
                .assertRequiredFieldsArePresent()
                .endAssertion();
    }

    @When("Enter a valid userId and correct password.")
    public void enterAValidUserIdAndCorrectPassword() {
        jlrLoginPage.inputDealerID(configuration.getDealerId())
                .inputUserID(configuration.getUserId())
                .inputPassword(configuration.getPassword())
                .selectJLRMarket();
    }

    @And("click login then verify that the home screen is opened")
    public void clickLoginThenVerifyThatTheHomeScreenIsOpened() {
        jlrLoginPage.loginBtn();
        jlrHomePage = new JLRHomePage(driver);
        jlrHomePage.startAssertions(JLRHomePageAssertion.class)
                .assertAtHomePage()
                .endAssertion();
    }

    @Then("Click Logout to confirm the Welcome screen is displayed on the screen.")
    public void clickLogoutToConfirmTheWelcomeScreenIsDisplayed_on_the_screen() {
        jlrHomePage.logoutBtn()
                .dismissAlertIfPresent(JLRHomePage.class);
        super.close();
    }

    @And("Click login and click Create Quote Tab.")
    public void clickLoginAndClickCreateQuoteTab() {
        jlrLoginPage.loginBtn();
        jlrHomePage = new JLRHomePage(driver);
        jlrHomePage.startAssertions(JLRHomePageAssertion.class)
                .assertAtHomePage()
                .endAssertion()
                .createQuote();
    }

    @And("Enter Reg No and click search. {string} .")
    public void enterRegNoAndClickSearch(String regNo) {
        jlrHomePage.inputRegistrationNo(regNo)
                .searchBtn(environment);
    }

    @Then("Verify Vehicle found and landed at Quote Tab.")
    public void verifyVehicleFoundAndLandedAtQuoteTab() {
        jlrHomePage.startAssertions(JLRHomePageAssertion.class)
                .assertVehicleDetailsFound()
                .assertQuoteSpanIsSelected()
                .endAssertion();
    }

    @When("Click expand Air Conditioning category")
    public void clickExpandAirConditioningCategory() {
        JLRHomePage jlrHomePage = new JLRHomePage(driver);
        jlrHomePage.expandJobListInnerRow(19);
    }

    @And("Expand Compressor & Drive category and click on Remove & Replace Compressor")
    public void expandCompressorDriveCategoryAndClickOnRemoveReplaceCompressor() {
        JLRHomePage jlrHomePage = new JLRHomePage(driver);
        jlrHomePage.compressorDriveToggleExpand()
                .jobWorkItemToggleExpand();
    }

    @Then("Verify Remove & Replace Compressor added to the quote")
    public void verifyRemoveReplaceCompressorAddedToTheQuote() {
        jlrHomePage.startAssertions(JLRHomePageAssertion.class)
                .assertJobWorkItemIsDisplayedInQuote()
                .endAssertion();
    }

    @When("Click continue to Notes Tab.")
    public void clickContinueToNotesTab() {
        jlrHomePage.continueBtnClick();
    }

    @And("Enter the Distance details {string}, {string}.")
    public void enterTheDistanceDetails(String distance, String notes) {
        jlrHomePage.inputQuotationDetails(distance, notes);
    }

    @And("Click continue.")
    public void clickContinue() {
        jlrHomePage.continueBtnClick();
    }

    @Then("Verify Quote tab page arrived and verify the Customer details are present with Save Button enabled.")
    public void verifyQuoteTabPageArrivedAndVerifyTheCustomerDetailsArePresentWithSaveButtonEnabled() {
        CreateQuotePage createQuotePage = new CreateQuotePage(driver);
        createQuotePage.startAssertions(CreateQuotePageAssertion.class)
                .assertQuoteSpanIsSelected()
                .assertCustomerDetailsIsDisplayed()
                .assertIfSaveButtonEnabled()
                .endAssertion();
    }

    @When("Click Save Button.")
    public void clickSaveButton() {
        jlrHomePage.saveBtnClick();
    }

    @Then("Verify Quote is now in Status {string} and has been assigned a quote number.")
    public void verifyQuoteIsNowInStatusSavedAndHasBeenAssignedAQuoteNumber(String status) {
        jlrHomePage.startAssertions(JLRHomePageAssertion.class)
                .assertQuoteDetails(status)
                .endAssertion()
                .logoutBtn();
    }

    @After
    public void close() {
        super.close();
    }
}
