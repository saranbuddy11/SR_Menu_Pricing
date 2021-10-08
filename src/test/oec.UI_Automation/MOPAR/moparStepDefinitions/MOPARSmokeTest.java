package MOPAR.moparStepDefinitions;

import MOPAR.moparAssertion.MOPARHomePageAssertion;
import MOPAR.moparAssertion.MOPARLoginPageAssertion;
import MOPAR.moparObjectRepository.MOPARHomePage;
import OPEL.opelAssertion.OPELHomePageAssertion;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import stepDefinitions.AbstractTest;

public class MOPARSmokeTest extends AbstractTest {
    @Given("Go to the url & verify that the login screen is displayed with all required fields")
    public void goToTheUrlVerifyThatTheLoginScreenIsDisplayedWithAllRequiredFields() {
        super.setUp();
        moparLoginPage.startAssertions(MOPARLoginPageAssertion.class)
                .assertAtLoginPage()
                .assertRequiredFieldsArePresent()
                .endAssertion();
    }

    @When("Enter a invalid userId and incorrect password")
    public void enterAInvalidUserIdAndIncorrectPassword() {
        moparLoginPage.inputDealerID(configuration.getDealerId())
                .inputUserID(configuration.getInvalidUserId())
                .inputPassword(configuration.getInvalidPassword())
                .selectMarket(configuration.getMarket());
    }

    @And("click login then confirm that the validation errors are displayed")
    public void clickLoginThenConfirmThatTheValidationErrorsAreDisplayed() {
        moparLoginPage.loginBtn()
                .startAssertions(MOPARLoginPageAssertion.class)
                .assertAtLoginPage()
                .assertLoginValidationErrorDisplayed_InValidEmail_WrongPassword()
                .endAssertion();
        super.close();
    }

    @When("Enter a valid userId and correct password")
    public void enterAValidUserIdAndCorrectPassword() {
        moparLoginPage.inputDealerID(configuration.getDealerId())
                .inputUserID(configuration.getUserId())
                .inputPassword(configuration.getPassword())
                .selectMarket(configuration.getMarket())
        ;
    }

    @And("Click login then verify that the home screen is opened")
    public void clickLoginThenVerifyThatTheHomeScreenIsOpened() {
        moparLoginPage.loginBtn();
        moparHomePage = new MOPARHomePage(driver);
        moparHomePage.startAssertions(MOPARHomePageAssertion.class)
                .assertAtHomePage()
                .endAssertion();
    }

    @Then("Click Logout to confirm the Welcome screen is displayed")
    public void clickLogoutToConfirmTheWelcomeScreenIsDisplayed() {
        moparHomePage.logoutBtn()
                .dismissAlertIfPresent(MOPARHomePage.class);
        super.close();
    }

    @And("Click login and click Create Quote Tab")
    public void clickLoginAndClickCreateQuoteTab() {
        moparLoginPage.loginBtn();
        moparHomePage = new MOPARHomePage(driver);
        moparHomePage.startAssertions(MOPARHomePageAssertion.class)
                .assertAtHomePage()
                .endAssertion()
                .createQuote();
    }

    @And("Enter Reg No and click search. {string}")
    public void enterRegNoAndClickSearch(String regNo) {
        moparHomePage.inputRegistrationNo(regNo)
                .searchBtn(environment);
    }

    @Then("Verify Vehicle found and landed at Quote Tab")
    public void verifyVehicleFoundAndLandedAtQuoteTab() {
        moparHomePage.startAssertions(MOPARHomePageAssertion.class)
                .assertVehicleDetailsFound()
                .assertQuoteSpanIsSelected()
                .endAssertion();
    }

    @When("Click expand Clutch category")
    public void clickExpandClutchCategory() {
        moparHomePage.clutchToggleExpand();
    }

    @And("Expand Clutch Complete category and click on Remove & Replace Original Equipment")
    public void expandClutchCompleteCategoryAndClickOnRemoveReplaceOriginalEquipment() {
        moparHomePage.clutchCompleteToggleExpand()
                .jobWorkItemToggleExpand();
    }

    @Then("Verify Remove & Replace Original Equipment added to the quote")
    public void verifyRemoveReplaceOriginalEquipmentAddedToTheQuote() {
        moparHomePage.startAssertions(MOPARHomePageAssertion.class)
                .assertJobWorkItemIsDisplayedInQuote()
                .endAssertion();
    }

    @When("Click continue to Notes Tab")
    public void clickContinueToNotesTab() {
        moparHomePage.continueBtnClick();
    }

    @And("Enter the Distance details {string}, {string}")
    public void enterTheDistanceDetails(String distance, String notes) {
        moparHomePage.inputQuotationDetails(distance, notes);
    }

    @And("Click continue")
    public void clickContinue() {
        moparHomePage.continueBtnClick();
    }

    @Then("Verify Quote tab page arrived and verify the Customer details are present with Save Button enabled. {string}, {string}, {string}")
    public void verifyQuoteTabPageArrivedAndVerifyTheCustomerDetailsArePresentWithSaveButtonEnabled(String customerName, String customerAddress, String customerPostcode) {
        moparHomePage.startAssertions(MOPARHomePageAssertion.class)
                .assertQuoteSpanIsSelected()
                .assertCustomerDetailsIsDisplayed(customerName, customerAddress, customerPostcode)
                .assertSaveBtnIsEnabled()
                .endAssertion();
    }

    @When("Click Save Button")
    public void clickSaveButton() {
        moparHomePage.saveBtnClick();
    }

    @Then("Verify Quote is now in Status {string} and has been assigned a quote number")
    public void verifyQuoteIsNowInStatusSavedAndHasBeenAssignedAQuoteNumber(String status) {
        moparHomePage.startAssertions(MOPARHomePageAssertion.class)
                .assertQuoteDetails(status)
                .endAssertion()
                .logoutBtn();
    }

    @After
    public void close() {
        super.close();
    }
}