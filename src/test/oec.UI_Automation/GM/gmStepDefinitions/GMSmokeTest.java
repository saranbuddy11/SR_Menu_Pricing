package GM.gmStepDefinitions;

import GM.gmAssertion.CreateQuotePageAssertion;
import GM.gmObjectRepository.CreateQuotePage;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import GM.gmAssertion.HomePageAssertion;
import GM.gmAssertion.LoginPageAssertion;
import GM.gmObjectRepository.HomePage;
import stepDefinitions.AbstractTest;

import java.util.List;

public class GMSmokeTest extends AbstractTest {

    @Given("Go to the qc url & verify that the all required fields are displayed in login screen")
    public void go_to_the_qc_url_verify_that_the_all_required_fields_are_displayed_in_login_screen() {
        super.setUp();
        loginPage.startAssertions(LoginPageAssertion.class)
                .assertAtLoginPage()
                .assertRequiredFieldsArePresent()
                .endAssertion();
    }

    @When("Enter a valid userId and valid password")
    public void enter_a_valid_userId_and_valid_password() {
        loginPage.inputDealerID(configuration.getDealerId())
                .inputUserID(configuration.getUserId())
                .inputPassword(configuration.getPassword());
    }

    @When("Select a  market value and Click login button")
    public void Selct_a_market_value_and_click_login_button() {
        loginPage.loginBtn();
    }

    @When("verify that successfully logged in and the home screen is opened")
    public void verify_that_successfully_loggedin_the_home_screen_is_opened() {
        homePage = new HomePage(driver);
        homePage.startAssertions(HomePageAssertion.class)
                .assertIfUserAtHomePage()
                .endAssertion();
    }

    @Then("Click Logout button")
    public void Click_Logout_button() {
        homePage.smokeLogoutBtn();
        super.close();
    }

    @When("Enter a invalid userId and invalid password")
    public void enter_a_invalid_userId_and_invalid_password() {
        loginPage.inputUserID(configuration.getInvalidUserId())
                .inputPassword(configuration.getInvalidPassword());

    }

    @When("Enter valid dealerId and market value")
    public void Enter_valid_dealerId_and_market_value() {
        loginPage.inputDealerID(configuration.getDealerId());
    }

    @When("Click login button")
    public void click_login_button() {
        loginPage.loginBtn();
    }

    @Then("verify that the warning message are displayed correctly")
    public void verify_that_the_warning_message_are_displayed_correctly() {
        loginPage.startAssertions(LoginPageAssertion.class)
                .assertAtLoginPage()
                .assertLoginValidationErrorDisplayed_InValidUserId_InvalidPassword()
                .endAssertion();
        super.close();
    }

    @When("Click Create Estimate tab")
    public void Click_Create_Estimate_tab() {
        homePage = new HomePage(driver);
        homePage.createEstimateTab();
    }

    @When("Enter VIN and click search. {string}")
    public void enter_VIN_and_click_search(String vin) {
        homePage.inputVIN(vin)
                .searchBtn();
    }

    @Then("Verify Vehicle is found")
    public void verify_Vehicle_is_found() {
        homePage.startAssertions(HomePageAssertion.class)
                .assertVehicleFound()
                .endAssertion();
    }

    @When("Add Job Service Add-On Cabin Filter Remove & Replace")
    public void add_Job_Service_Add_On_Cabin_Filter_Remove_Replace() {
        homePage.serviceAddOnExpand()
                .cabinFilterExpand()
                .removeAndReplace();
    }

    @Then("Verify Job is added to the Estimate")
    public void verify_Job_is_added_to_the_Estimate() {
        homePage.startAssertions(HomePageAssertion.class)
                .assertJobWorkItemIsDisplayedInEstimation()
                .endAssertion();
    }

    @Then("Click the Continue button")
    public void click_the_Continue_button() {
        homePage.continueBtnClick();
    }

    @And("Enter the Notes. {string},{string}")
    public void enterTheNotes(String distance, String notes) {
        HomePage homePage = new HomePage(driver);
        homePage.inputQuotationDetail(distance, notes);
    }


    @Then("Verify Estimate tab page selected and verify the Customer details are added to the estimate and Save Button enabled.")
    public void verify_Estimate_tab_page_selected_and_verify_the_Customer_details_are_added_to_the_estimate_and_Save_Button_enabled() {
        CreateQuotePage createQuotePage = new CreateQuotePage(driver);
        createQuotePage.startAssertions(CreateQuotePageAssertion.class)
                .assertEstimateTabIsSelected()
                .assertCustomerDetailsIsDisplayed()
                .assertIfSaveButtonEnabled()
                .endAssertion();
    }

    @When("Click Save button")
    public void click_Save_button() {
        homePage.saveBtn();
    }

    @Then("Verify Estimate is now in Status {string} and has been assigned a estimate number")
    public void verify_Estimate_is_now_in_Status_and_has_been_assigned_a_estimate_number(String status) {
        homePage.startAssertions(HomePageAssertion.class)
                .assertQuoteDetails(status)
                .endAssertion();
    }

    @After
    public void close() {
        super.close();
    }
}
