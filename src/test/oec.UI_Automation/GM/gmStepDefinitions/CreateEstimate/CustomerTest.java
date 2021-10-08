package GM.gmStepDefinitions.CreateEstimate;

import GM.gmAssertion.*;
import GM.gmObjectRepository.*;
import base.Bug;
import base.Environment;
import io.cucumber.java.After;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import stepDefinitions.AbstractTest;

import java.io.IOException;
import java.util.List;

public class CustomerTest extends AbstractTest {

    @When("Create a estimate using {string} vehicle that has no associated customers. Move to the customer tab.")
    public void create_a_estimate_using_vehicle_that_has_no_associated_customers_Move_to_the_customer_tab(String vinNo) {
        super.setUp();
        homePage = functionalLibrary.gmLogIn(environment, configuration, HomePage.class);
        homePage.startAssertions(HomePageAssertion.class)
                .assertAtHomePage()
                .endAssertion()
                .inputVIN(vinNo)
                .searchBtn()
                .continueBtnClick();
        gmCreateEstimatePage = new GMCreateEstimatePage(driver);
        gmCreateEstimatePage.startAssertions(GMCreateEstimatePageAssertion.class)
                .assertAtEstimateTab()
                .endAssertion()
                .clickOnContinueBtn();
        ;
    }

    @Then("Customer page opened.")
    public void customer_page_opened() {
        gmCreateEstimateCustomerPage = new GMCreateEstimateCustomerPage(driver);
        gmCreateEstimateCustomerPage.startAssertions(GMCreateEstimateCustomerPageAssertion.class)
                .assertIfCustomerTab()
                .endAssertion()
        ;

    }

    @When("Enter the name of {string} known customer and click on the Search button.")
    public void enter_the_name_of_known_customer_and_click_on_the_Search_button(String customerName) {
        gmCreateEstimateCustomerPage.enterCustomerName(customerName)
                .clickOnSearchBtn()
        ;
    }

    @Then("Known customer is found and displayed.If there is more than one customer found, the list of customers is populated.")
    public void known_customer_is_found_and_displayed_If_there_is_more_than_one_customer_found_the_list_of_customers_is_populated() {
        gmCreateEstimateCustomerPage.startAssertions(GMCreateEstimateCustomerPageAssertion.class)
                .assertIfKnownCustomerIsFoundAndDisplayed()
                .endAssertion()
        ;
    }

    @When("If only one customer is found just click Continue button.")
    public void if_only_one_customer_is_found_just_click_Continue_button(io.cucumber.datatable.DataTable dataTable) {
        List<String> expectedCustomerDetails = dataTable.asList();
        gmCreateEstimateCustomerPage.clickOnContinueBtn()
                .startAssertions(GMCreateEstimateCustomerPageAssertion.class)
                .assertIfCustomerDetailUpdateInHeader(expectedCustomerDetails)
                .endAssertion()
        ;
    }

    @Then("The customer name is added to the quote. User is navigated to the Notes tab.")
    public void the_customer_name_is_added_to_the_quote_User_is_navigated_to_the_Notes_tab() {
        gmCreateEstimateNotesPage = new GMCreateEstimateNotesPage(driver);
        gmCreateEstimateNotesPage.startAssertions(GMCreateEstimatesNotesPageAssertion.class)
                .assertAtNotesTab()
                .endAssertion()
        ;
    }

    @When("Go back to the Customer tab - Search for the customer using a partial name {string} search.")
    public void go_back_to_the_Customer_tab_Search_for_the_customer_using_a_partial_name_search(String customerName) {
        gmCreateEstimatePage = new GMCreateEstimatePage(driver);
        gmCreateEstimatePage.clickOnCustomerTab();
        gmCreateEstimateCustomerPage = new GMCreateEstimateCustomerPage(driver);
        gmCreateEstimateCustomerPage.enterCustomerName(customerName)
                .clickOnSearchBtn()
                .acceptAlertIfPresent(GMCreateEstimateCustomerPage.class);
        ;
    }

    @Bug(ticket = "AD 35056", environment = Environment.QC)
    @When("Search for the customer using a partial address search.")
    public void search_for_the_customer_using_a_partial_address_search() {

    }

    @Then("Customer and any others matching the partial search are found.")
    public void customer_and_any_others_matching_the_partial_search_are_found() {
        gmCreateEstimateCustomerPage.startAssertions(GMCreateEstimateCustomerPageAssertion.class)
                .assertIfKnownCustomerIsFoundAndDisplayed()
                .endAssertion()
        ;
    }

    @Bug(ticket = "AD 35056", environment = Environment.QC)
    @When("Search for the customer using a partial postcode search.")
    public void search_for_the_customer_using_a_partial_postcode_search() {

    }

    @When("Click on the customer Create button.")
    public void click_on_the_customer_Create_button() {
        gmCreateEstimateCustomerPage.clickOnOKBtn()
                .clickOnClearBtn()
                .clickOnCreateBtn()
        ;
    }

    @When("Click on the Create button.")
    public void click_on_the_Create_button() {
        gmCreateEstimateCustomerPage.clickOnClearBtn()
                .clickOnCreateBtn()
        ;
    }

    @Then("The Customer Details form is shown.")
    public void the_Customer_Details_form_is_shown() {
        gmCreateEstimateCustomerPage.startAssertions(GMCreateEstimateCustomerPageAssertion.class)
                .assertIfTheCustomerDetailsFormIsShown()
                .endAssertion();
    }

    @When("Hit the Log Out button.")
    public void hit_the_Log_Out_button() {
        homePage = new HomePage(driver);
        homePage.logoutBtn();
    }

    @Then("The user is logged out from the current session and redirected to the SSO login page.")
    public void the_user_is_logged_out_from_the_current_session_and_redirected_to_the_SSO_login_page() {
        loginPage = new LoginPage(driver);
        loginPage.startAssertions(LoginPageAssertion.class)
                .assertAtLoginPage()
                .endAssertion()
                .goToPreviousPage(LoginPage.class)
                .startAssertions(LoginPageAssertion.class)
                .assertAtLoginPage()
                .endAssertion();
        super.close();
    }

    @When("Create a Quote using {string} vehicle that has no associated customers. Move to the customer tab.")
    public void create_a_Quote_using_vehicle_that_has_no_associated_customers_Move_to_the_customer_tab(String vinNo) throws IOException {
        super.setUp();
        homePage = functionalLibrary.jlrLogIn(environment, configuration, HomePage.class);
        homePage.startAssertions(HomePageAssertion.class)
                .assertAtHomePage()
                .endAssertion()
                .inputRegistrationNo(excel.getData(7, 0))
                .searchBtn();
        gmCreateEstimatePage = new GMCreateEstimatePage(driver);
        gmCreateEstimatePage.expandJobTreeInnerRow(1)
                .expandJobTreeSubInnerRow(1)
                .clickOnLabour15KAnd24K()
                .clickOnContinueBtn()
                .clickOnCustomerTab()
        ;
    }

    @Then("Known jlr customer is found and displayed.If there is more than one customer found, the list of customers is populated.")
    public void known_jlr_customer_is_found_and_displayed_If_there_is_more_than_one_customer_found_the_list_of_customers_is_populated() {
        gmCreateEstimateCustomerPage.startAssertions(GMCreateEstimateCustomerPageAssertion.class)
                .assertIfKnownCustomerIsFoundAndDisplayed()
                .endAssertion()
                .clickOnOKBtn()
        ;
    }

    @When("Search for the jlr customer using a partial address search.")
    public void search_for_the_jlr_customer_using_a_partial_address_search() throws IOException {
        gmCreateEstimateCustomerPage.clickOnOKBtn()
                .enterAddress(excel.getData(4, 1))
                .clickOnSearchBtn()
        ;
    }

    @When("Search for the jlr customer using a partial postcode search.")
    public void search_for_the_jlr_customer_using_a_partial_postcode_search() throws IOException {
        gmCreateEstimateCustomerPage.clickOnOKBtn()
                .enterPostCode(excel.getData(5, 1))
                .clickOnSearchBtn()
        ;
    }

    @When("Click jlr Unpriced generic jobs, click to complete ensure the link works correctly. Located at the bottom of the page")
    public void click_jlr_Unpriced_generic_jobs_click_to_complete_ensure_the_link_works_correctly_Located_at_the_bottom_of_the_page() throws IOException {
        super.setUp();
        homePage = functionalLibrary.jlrLogIn(environment, configuration, HomePage.class);
        homePage.startAssertions(HomePageAssertion.class)
                .assertAtHomePage()
                .endAssertion()
                .inputRegistrationNo(excel.getData(7, 0))
                .searchBtn();
        gmCreateEstimatePage = new GMCreateEstimatePage(driver);
        gmCreateEstimatePage.expandJobTreeInnerRow(1)
                .expandJobTreeSubInnerRow(1)
                .clickOnLabour15KAnd24K()
                .clickOnContinueBtn()
                .clickOnCustomerTab();
        homePage = new HomePage(driver);
        homePage.clickOnUnpricedCommonCustomJobsLink()
        ;
    }

    @Then("jlr User is taken to Administration> Generic Jobs. Navigate back to customer tab.")
    public void jlr_user_is_taken_to_Administration_Generic_Jobs_Navigate_back_to_customer_tab() {
        homePage.startAssertions(HomePageAssertion.class)
                .assertAtGenericJobsTab()
                .endAssertion()
        ;
    }

    @When("Click jlr Generic parts priced below retail, click to complete ensure the link works correctly Located at the bottom of the page")
    public void click_jlr_Generic_parts_priced_below_retail_click_to_complete_ensure_the_link_works_correctly_Located_at_the_bottom_of_the_page() throws IOException {
        homePage.openCreateEstimateTab();
        gmCreateEstimatePage = new GMCreateEstimatePage(driver);
        gmCreateEstimatePage.clickOnVehicleTab();
        homePage = new HomePage(driver);
        homePage.startAssertions(HomePageAssertion.class)
                .assertAtHomePage()
                .endAssertion()
                .inputRegistrationNo(excel.getData(7, 0))
                .searchBtn();
        gmCreateEstimateCustomerPage = new GMCreateEstimateCustomerPage(driver);
        gmCreateEstimateCustomerPage.clickOnOKBtn();
        gmCreateEstimatePage = new GMCreateEstimatePage(driver);
        gmCreateEstimatePage.expandJobTreeInnerRow(1)
                .expandJobTreeSubInnerRow(1)
                .clickOnLabour15KAnd24K()
                .clickOnContinueBtn()
                .clickOnCustomerTab();
        homePage = new HomePage(driver);
        homePage.clickOnGenericPartsPriceLink()
        ;
    }

    @Then("jlr User is taken to Administration> Generic Parts. Navigate back to customer tab.")
    public void jlr_user_is_taken_to_Administration_Generic_Parts_Navigate_back_to_customer_tab() {
        homePage.startAssertions(HomePageAssertion.class)
                .assertAtGenericPartsTab()
                .endAssertion()
        ;
    }

    @After
    public void close() {
        super.close();
    }
}
