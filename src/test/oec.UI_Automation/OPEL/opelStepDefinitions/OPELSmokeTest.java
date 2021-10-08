package OPEL.opelStepDefinitions;

import OPEL.opelAssertion.OPELHomePageAssertion;
import OPEL.opelAssertion.OPELLoginPageAssertion;
import OPEL.opelObjectRepository.OPELHomePage;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import stepDefinitions.AbstractTest;

import java.awt.*;

public class OPELSmokeTest extends AbstractTest {
    @Given("Go to the url & verify that the login screen is displayed with all required fields .")
    public void goToTheUrlVerifyThatTheLoginScreenIsDisplayedWithAllRequiredFields() {
        super.setUp();
        opelLoginPage.startAssertions(OPELLoginPageAssertion.class)
                .assertAtLoginPage()
                .assertRequiredFieldsArePresent()
                .endAssertion();
    }

    @When("Enter a valid userId and correct password .")
    public void enterAValidUserIdAndCorrectPassword() {
        opelLoginPage.inputDealerID(configuration.getDealerId())
                .inputUserID(configuration.getUserId())
                .inputPassword(configuration.getPassword())
                .selectMarket(configuration.getMarket())
        ;
    }

    @And("Click login then verify that the home screen is opened .")
    public void clickLoginThenVerifyThatTheHomeScreenIsOpened() {
        opelLoginPage.loginBtn();
        opelHomePage = new OPELHomePage(driver);
        opelHomePage.startAssertions(OPELHomePageAssertion.class)
                .assertAtHomePage()
                .endAssertion();
    }

    @Then("Click Logout to confirm the Welcome screen is displayed .")
    public void clickLogoutToConfirmTheWelcomeScreenIsDisplayed() {
        opelHomePage.logoutBtn()
                .dismissAlertIfPresent(OPELHomePage.class);
        super.close();
    }

    @And("Click login and click Create Quote Tab .")
    public void clickLoginAndClickCreateQuoteTab() {
        opelLoginPage.loginBtn();
        opelHomePage = new OPELHomePage(driver);
        opelHomePage.startAssertions(OPELHomePageAssertion.class)
                .assertAtHomePage()
                .endAssertion()
                .createQuote();
    }

    @And("Enter Reg No and click search. {string}.")
    public void enterRegNoAndClickSearch(String regNo) {
        opelHomePage.inputRegistrationNo(regNo)
                .searchBtn();
    }

    @Then("Verify Vehicle found and landed at Quote Tab .")
    public void verifyVehicleFoundAndLandedAtQuoteTab() {
        opelHomePage = new OPELHomePage(driver);
        opelHomePage.startAssertions(OPELHomePageAssertion.class)
                .assertVehicleDetailsFound()
                .assertQuoteSpanIsSelected()
                .endAssertion();
    }

    @When("Click expand Servicing category")
    public void clickExpandServicingCategory() {
        opelHomePage.servicingToggleExpand();
    }

    @And("Expand Mileage Servicing category and click on twenty thousand Mls")
    public void expandMileageServicingCategoryAndClickOnTwentyThousandMls() {
        opelHomePage.mileageServicingToggleExpand()
                .jobWorkItemToggleExpand();
    }

    @When("Pop up window appears Select menu to be added to the quote with list of available jobs.")
    public void pop_up_window_appears_Select_menu_to_be_added_to_the_quote_with_list_of_available_jobs() {
        opelHomePage.clickOnAddToQuote();
    }

    @Then("Verify Mileage Servicing added to the quote")
    public void verifyMileageServicingAddedToTheQuote() {
        opelHomePage.startAssertions(OPELHomePageAssertion.class)
                .assertJobWorkItemIsDisplayedInQuote()
                .endAssertion();
    }

    @When("Click on Job Check-sheet icon")
    public void clickOnJobCheckSheetIcon() {
        opelHomePage.jobSheetIconClick();
    }

    @Then("Verify User is given the option to open or save the Check-sheet")
    public void verifyUserIsGivenTheOptionToOpenOrSaveTheCheckSheet() throws AWTException {
        opelHomePage.openJobSheet();
    }

    @When("Close the PDF file and click continue to Notes Tab")
    public void closeThePDFFileAndClickContinueToNotesTab() throws AWTException {
        opelHomePage.closeJobSheet()
                .continueBtnClick();
    }

    @And("Enter the Distance details, Service Card Number and Notes. {string}, {string}, {string}")
    public void enterTheDistanceDetailsServiceCardNumberAndNotes(String distance, String serviceCardNo, String notes) {
        opelHomePage.inputQuotationDetails(distance, serviceCardNo, notes);
    }

    @And("Click continue .")
    public void clickContinue() {
        opelHomePage.continueBtnClick();
    }

    @Then("Verify Quote tab page arrived and verify the Customer details are present with Save Button enabled. {string}, {string}, {string} .")
    public void verifyQuoteTabPageArrivedAndVerifyTheCustomerDetailsArePresentWithSaveButtonEnabled(String customerName, String customerAddress, String customerPostcode) {
        opelHomePage.startAssertions(OPELHomePageAssertion.class)
                .assertQuoteSpanIsSelected()
                .assertCustomerDetailsIsDisplayed(customerName, customerAddress, customerPostcode)
                .assertSaveBtnIsEnabled()
                .endAssertion();
    }

    @When("Click Save Button .")
    public void clickSaveButton() {
        opelHomePage.saveBtnClick();
    }

    @Then("Verify Quote is now in Status {string} and has been assigned a quote numbers")
    public void verifyQuoteIsNowInStatusSavedAndHasBeenAssignedAQuoteNumbers(String status) {
        opelHomePage.startAssertions(OPELHomePageAssertion.class)
                .assertQuoteDetails(status)
                .endAssertion();
    }


    @After
    public void close() {
        super.close();
    }
}
