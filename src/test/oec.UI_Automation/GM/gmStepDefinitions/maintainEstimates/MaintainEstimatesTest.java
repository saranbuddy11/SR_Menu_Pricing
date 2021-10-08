package GM.gmStepDefinitions.maintainEstimates;

import GM.gmAssertion.GMCreateEstimateCustomerPageAssertion;
import GM.gmAssertion.GMCreateEstimatePageAssertion;
import GM.gmAssertion.GMCreateEstimatesNotesPageAssertion;
import GM.gmAssertion.HomePageAssertion;
import GM.gmAssertion.maintainEstimates.SearchEstimatePageAssertion;
import GM.gmObjectRepository.GMCreateEstimateCustomerPage;
import GM.gmObjectRepository.GMCreateEstimateNotesPage;
import GM.gmObjectRepository.GMCreateEstimatePage;
import GM.gmObjectRepository.HomePage;
import GM.gmObjectRepository.maintainEstimates.SearchEstimatePage;
import io.cucumber.java.After;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import model.SearchStatus;
import stepDefinitions.AbstractTest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaintainEstimatesTest extends AbstractTest {

    @When("Go to Maintain Estimates tab")
    public void go_to_Maintain_Estimates_tab() {
        super.setUp();
        homePage = functionalLibrary.gmLogIn(environment, configuration, HomePage.class);
        homePage.startAssertions(HomePageAssertion.class)
                .assertAtHomePage()
                .endAssertion()
                .openMaintainEstimatesTab()
                .startAssertions(HomePageAssertion.class)
                .assertAtSearchTab()
                .endAssertion()
        ;
    }

    @When("Select various Statuses from the drop down list and Search.")
    public void select_various_Statuses_from_the_drop_down_list_and_Search() {
        searchEstimatePage = new SearchEstimatePage(driver);
        searchEstimatePage.selectSearchStatus(SearchStatus.All)
                .enterFromDate("02/05/2020")
                .clickOnSearchBtn()
                .startAssertions(SearchEstimatePageAssertion.class)
                .assertIfAllSearchedStatusDisplayed()
                .endAssertion()
                .clickOnClearBtn()
                .selectSearchStatus(SearchStatus.Deleted)
                .enterFromDate("02/05/2020")
                .clickOnSearchBtn()
                .startAssertions(SearchEstimatePageAssertion.class)
                .assertIfDeleteStatusDisplayed()
                .endAssertion()
                .clickOnClearBtn()
                .selectSearchStatus(SearchStatus.Saved)
                .clickOnSearchBtn()
        ;
    }

    @Then("Estimates with the correct status are returned.")
    public void estimates_with_the_correct_status_are_returned() {
        searchEstimatePage.startAssertions(SearchEstimatePageAssertion.class)
                .assertIfSavedStatusDisplayed()
                .endAssertion()
                .clickOnClearBtn()
        ;
    }

    @When("Search for estimates using VIN {string}.")
    public void search_for_estimates_using_VIN(String vinNo) {
        searchEstimatePage.enterVinNo(vinNo)
                .clickOnSearchBtn()
        ;
    }

    @Then("All estimates with the VIN {string} are returned.")
    public void all_estimates_with_the_VIN_are_returned(String vinNo) {
        searchEstimatePage.startAssertions(SearchEstimatePageAssertion.class)
                .assertIfAllEstimatesWithTheVINAreReturned(vinNo)
                .endAssertion()
                .clickOnClearBtn()
        ;
    }

    @When("Search for a estimate with partial VIN {string}.")
    public void search_for_a_estimate_with_partial_VIN(String partialVinNo) {
        searchEstimatePage.enterVinNo(partialVinNo)
                .clickOnSearchBtn()
        ;
    }

    @Then("All estimates with VIN’s matching the partial criteria {string} are returned.")
    public void all_estimates_with_VIN_s_matching_the_partial_criteria_are_returned(String partialVinNo) {
        searchEstimatePage.startAssertions(SearchEstimatePageAssertion.class)
                .assertIfAllEstimatesWithVINsMatchingThePartialCriteriaAreReturned(partialVinNo)
                .endAssertion()
                .clickOnClearBtn()
        ;
    }

    @When("Search for estimates using Lic No {string} and Date {string}.")
    public void search_for_estimates_using_Lic_No_and_Date(String licNo, String date) {
        searchEstimatePage.enterLicNo(licNo)
                .enterFromDate(date)
                .clickOnSearchBtn()
        ;
    }

    @Then("All estimates with the Lic Nos {string} are returned.")
    public void all_estimates_with_the_Lic_Nos_are_returned(String licNo) {
        searchEstimatePage.startAssertions(SearchEstimatePageAssertion.class)
                .assertIfAllEstimatesWithTheVINAreReturned(licNo)
                .endAssertion()
                .clickOnClearBtn()
        ;

    }

    @When("Search for a estimate with partial Lic No {string}.")
    public void search_for_a_estimate_with_partial_Lic_No(String partialLicNo) {
        searchEstimatePage.enterLicNo(partialLicNo)
                .clickOnSearchBtn()
        ;
    }

    @Then("All estimates with Lic Nos {string} matching the partial criteria are returned.")
    public void all_estimates_with_Lic_Nos_matching_the_partial_criteria_are_returned(String partialLicNo) {
        searchEstimatePage.startAssertions(SearchEstimatePageAssertion.class)
                .assertIfAllEstimatesWithVINsMatchingThePartialCriteriaAreReturned(partialLicNo)
                .endAssertion()
                .clickOnClearBtn()
        ;
    }

    @When("Search for estimates using Customer {string}.")
    public void search_for_estimates_using_Customer(String customerName) {
        searchEstimatePage.enterCustomerName(customerName)
                .clickOnSearchBtn()
        ;
    }

    @Then("All estimates with the Customer {string} are returned.")
    public void all_estimates_with_the_Customer_are_returned(String customerName) {
        searchEstimatePage.startAssertions(SearchEstimatePageAssertion.class)
                .assertIfAllEstimatesWithCustomerNameMatchingAreReturned(customerName)
                .endAssertion()
        ;
    }

    @When("Search for a estimate with partial Customer {string}.")
    public void search_for_a_estimate_with_partial_Customer(String partialCustomerName) {
        searchEstimatePage.enterCustomerName(partialCustomerName)
                .clickOnSearchBtn()
        ;
    }

    @Then("All estimates with Customers {string} matching the partial criteria are returned.")
    public void all_estimates_with_Customers_matching_the_partial_criteria_are_returned(String partialCustomer) {
        searchEstimatePage.startAssertions(SearchEstimatePageAssertion.class)
                .assertIfAllEstimatesWithCustomerNameMatchingAreReturned(partialCustomer)
                .endAssertion()
                .clickOnClearBtn()
        ;
    }

    @When("Search for estimates using an Address {string}.")
    public void search_for_estimates_using_an_Address(String address) {
        searchEstimatePage.enterAddress(address)
                .clickOnSearchBtn()
                .clickOnClearBtn()
        ;
    }

    @When("Search for a estimate with partial Address {string}.")
    public void search_for_a_estimate_with_partial_Address(String partialAddress) {
        searchEstimatePage.enterAddress(partialAddress)
                .clickOnSearchBtn()
                .clickOnClearBtn()
        ;

    }

    @When("Search for estimates using a Zipcode {string}")
    public void search_for_estimates_using_a_Zipcode(String zipCode) {
        searchEstimatePage.enterZipCode(zipCode)
                .clickOnSearchBtn()
                .clickOnClearBtn()
        ;

    }

    @When("Search for a estimate with partial Zipcode {string}")
    public void search_for_a_estimate_with_partial_Zipcode(String partialZipcode) {
        searchEstimatePage.enterZipCode(partialZipcode)
                .clickOnSearchBtn()
                .clickOnClearBtn()
        ;
    }

    @When("Enter a specific estimate number {string} and search.")
    public void enter_a_specific_estimate_number_and_search(String estimateNumber) {
        searchEstimatePage.enterEstimateNo(estimateNumber)
                .enterFromDate("10/27/2019")
                .clickOnSearchBtn()
        ;
    }

    @Then("The estimate number {string} is returned.")
    public void the_estimate_number_is_returned(String estimateNumber) {
        searchEstimatePage.startAssertions(SearchEstimatePageAssertion.class)
                .assertIfAllEstimatesWithTheEstimateIsReturned(estimateNumber)
                .endAssertion()
                .clickOnClearBtn()
        ;
    }

    @When("Enter a Date from and a Date To {string} in the specified format and search.")
    public void enter_a_Date_from_and_a_Date_To_in_the_specified_format_and_search(String date) {
        searchEstimatePage.enterFromDate(date)
                .enterToDate(date)
                .clickOnSearchBtn()
        ;
    }

    @Then("All estimates saved within the two dates {string} are returned.")
    public void all_estimates_saved_within_the_two_dates_are_returned(String date) {
        searchEstimatePage.startAssertions(SearchEstimatePageAssertion.class)
                .assertIfAllEstimatesWithDateMatchingAreReturned(date)
                .endAssertion()
                .clickOnClearBtn()
        ;
    }

    @When("Enter a From date {string} that is ahead of the To date {string}. Click search.")
    public void enter_a_From_date_that_is_ahead_of_the_To_date_Click_search(String fromDate, String toDate) {
        searchEstimatePage.enterFromDate(fromDate)
                .enterToDate(toDate)
                .clickOnSearchBtn()
        ;
    }

    @Then("Error message appears {string}.")
    public void error_message_appears(String errorMsg) {
        searchEstimatePage.startAssertions(SearchEstimatePageAssertion.class)
                .assertIfInvalidDateErrorMessageAppears(errorMsg)
                .endAssertion()
                .clickOnCloseBtn()
                .clickOnClearBtn()
        ;
    }

    @When("Perform a search that returns multiple estimates. Click on the column headers to sort the estimates i.e. Status.")
    public void perform_a_search_that_returns_multiple_estimates_Click_on_the_column_headers_to_sort_the_estimates_i_e_Status() {
        searchEstimatePage.enterFromDate("10/01/2020")
                .enterToDate("11/22/2020")
                .clickOnSearchBtn()
                .clickOnAscendingOrderArrow()
                .startAssertions(SearchEstimatePageAssertion.class)
                .assertIfEstimatesAreSortedAscendingAsExpected()
                .endAssertion()
                .clickOnDescendingOrderArrow()
        ;
    }

    @Then("Estimates are sorted as expected.")
    public void estimates_are_sorted_as_expected() {
        searchEstimatePage.startAssertions(SearchEstimatePageAssertion.class)
                .assertIfEstimatesAreSortedDescendingAsExpected()
                .endAssertion()
                .clickOnClearBtn()
        ;
    }

    @When("Find a estimate and double click on it.")
    public void find_a_estimate_and_double_click_on_it() {
        searchEstimatePage.clickOnSearchBtn()
                .doubleClickOnSearchResultVinNo()
        ;
    }

    @Then("Estimate is opened.")
    public void estimate_is_opened() {
        gmCreateEstimatePage = new GMCreateEstimatePage(driver);
        gmCreateEstimatePage.startAssertions(GMCreateEstimatePageAssertion.class)
                .assertAtEstimateTab()
                .endAssertion();
        homePage = new HomePage(driver);
        homePage.openAdministrationTab()
                .openMaintainEstimatesTab()
        ;
    }

    @When("Find a estimate and single click on it to select then click on the Continue button.")
    public void find_a_estimate_and_single_click_on_it_to_select_then_click_on_the_Continue_button() {
        searchEstimatePage = new SearchEstimatePage(driver);
        searchEstimatePage.clickOnClearBtn()
                .clickOnSearchBtn()
                .clickOnSearchResultVinNo();
        gmCreateEstimateCustomerPage = new GMCreateEstimateCustomerPage(driver);
        gmCreateEstimateCustomerPage.clickOnContinueBtn();
    }

    @Then("Close the browser")
    public void Close_the_browser() {
        super.close();
    }

    @When("Go to Historic Quote - Search Quote tab")
    public void go_to_Historic_Quote_Search_Quote_tab() {
        super.setUp();
        homePage = functionalLibrary.jlrLogIn(environment, configuration, HomePage.class);
        homePage.startAssertions(HomePageAssertion.class)
                .assertAtHomePage()
                .endAssertion()
                .openHistoricQuotesTab()
                .clickBasedOnName("includeDeleted")
        ;
    }

    @Then("Search error message appears {string}.")
    public void search_error_message_appears(String errorMsg) {
        searchEstimatePage.startAssertions(SearchEstimatePageAssertion.class)
                .assertIfInvalidDateAlertMessageAppears(errorMsg)
                .endAssertion();
        homePage = new HomePage(driver);
        homePage.clickOnWarningAcceptBtn();
        searchEstimatePage = new SearchEstimatePage(driver);
        searchEstimatePage.clickOnClearBtn()
        ;
    }

    @Then("Quote is opened.")
    public void quote_is_opened() {
        gmCreateEstimatePage = new GMCreateEstimatePage(driver);
        gmCreateEstimatePage.startAssertions(GMCreateEstimatePageAssertion.class)
                .assertAtQuoteTab()
                .endAssertion();
        homePage = new HomePage(driver);
        homePage.openAdministrationTab()
                .openHistoricQuotesTab()
        ;
    }

    @When("Select each Status and search {string}")
    public void select_each_Status_and_search(String date) {
        searchEstimatePage = new SearchEstimatePage(driver);
        searchEstimatePage.clickBasedOnName("includeDeleted");
        searchEstimatePage.selectSearchStatus(SearchStatus.All)
                .enterFromDate("25/05/2021")
                .clickOnSearchBtn()
                .startAssertions(SearchEstimatePageAssertion.class)
                .assertIfAllSearchedStatusDisplayed()
                .endAssertion()
                .clickOnClearBtn();
        searchEstimatePage.clickBasedOnName("includeDeleted");
        searchEstimatePage.selectSearchStatus(SearchStatus.Deleted)
                .enterFromDate("25/05/2021")
                .clickOnSearchBtn()
                .startAssertions(SearchEstimatePageAssertion.class)
                .assertIfDeleteStatusDisplayed()
                .endAssertion()
                .clickOnClearBtn()
                .selectSearchStatus(SearchStatus.Saved)
                .clickOnSearchBtn()
                .startAssertions(SearchEstimatePageAssertion.class)
                .assertIfSavedStatusDisplayed()
                .endAssertion()
                .selectSearchStatus(SearchStatus.Deferred)
                .clickOnSearchBtn()
                .startAssertions(SearchEstimatePageAssertion.class)
                .assertIfDeferredStatusDisplayed()
                .endAssertion()
                .enterFromDate(date)
                .selectSearchStatus(SearchStatus.Lost)
                .clickOnSearchBtn()
        ;
    }

    @Then("Only quotes in the specified Status are returned.")
    public void only_quotes_in_the_specified_Status_are_returned() {
        searchEstimatePage.startAssertions(SearchEstimatePageAssertion.class)
                .assertIfLostStatusDisplayed()
                .endAssertion()
        ;
    }

    @When("Find a quote and open it.")
    public void find_a_quote_and_open_it() {
        searchEstimatePage = new SearchEstimatePage(driver);
        searchEstimatePage.clickOnSearchBtn()
                .doubleClickOnSearchResultVinNo()
        ;
    }

    @When("Click on each of the quote tabs.")
    public void click_on_each_of_the_quote_tabs() {
        gmCreateEstimatePage = new GMCreateEstimatePage(driver);
        gmCreateEstimatePage.startAssertions(GMCreateEstimatePageAssertion.class)
                .assertAtQuoteTab()
                .endAssertion()
                .clickOnVehicleTab()
                .clickOnCustomerTab();
        gmCreateEstimateCustomerPage = new GMCreateEstimateCustomerPage(driver);
        gmCreateEstimateCustomerPage.startAssertions(GMCreateEstimateCustomerPageAssertion.class)
                .assertIfCustomerTab()
                .endAssertion();
        gmCreateEstimatePage = new GMCreateEstimatePage(driver);
        gmCreateEstimatePage.clickOnNotesTab();
        gmCreateEstimateNotesPage = new GMCreateEstimateNotesPage(driver);
        gmCreateEstimateNotesPage.startAssertions(GMCreateEstimatesNotesPageAssertion.class)
                .assertAtNotesTab()
                .endAssertion();
        searchEstimatePage = new SearchEstimatePage(driver);
        searchEstimatePage.clickOnQuoteTab()
        ;
    }

    @Then("Vehicle, Quote,Customer and Notes tab opened and display expected info.")
    public void vehicle_Quote_Customer_and_Notes_tab_opened_and_display_expected_info() {
        gmCreateEstimatePage = new GMCreateEstimatePage(driver);
        gmCreateEstimatePage.startAssertions(GMCreateEstimatePageAssertion.class)
                .assertAtQuoteTab()
                .endAssertion()
        ;
    }

    @When("Click on the New Search button.")
    public void click_on_the_New_Search_button() {
        searchEstimatePage = new SearchEstimatePage(driver);
        searchEstimatePage.clickOnNewSearchBtn()
        ;
    }

    @Then("User is returned to the Historic Quotes search screen.")
    public void user_is_returned_to_the_Historic_Quotes_search_screen() {
        searchEstimatePage.startAssertions(SearchEstimatePageAssertion.class)
                .assertIfSavedStatusDisplayed()
                .endAssertion()
        ;
    }

    @When("Click on the Delete button.")
    public void click_on_the_Delete_button() throws IOException {
        homePage = new HomePage(driver);
        homePage.openCreateEstimateTab()
                .startAssertions(HomePageAssertion.class)
                .assertAtHomePage()
                .endAssertion()
                .inputRegistrationNo(excel.getData(7, 0))
                .searchBtn();
        gmCreateEstimatePage = new GMCreateEstimatePage(driver);
        gmCreateEstimatePage.expandJobTreeInnerRow(1)
                .expandJobTreeSubInnerRow(1)
                .clickOnLabour15KAnd24K()
                .clickOnContinueBtn()
                .clickOnContinueBtn()
                .clickOnSaveBtn();
        homePage = new HomePage(driver);
        homePage.openAdministrationTab()
                .openHistoricQuotesTab();
        searchEstimatePage = new SearchEstimatePage(driver);
        searchEstimatePage.clickOnSearchBtn()
                .doubleClickOnSearchResultVinNo()
                .clickOnDeleteBtn()
        ;
    }

    @Then("User is prompted to confirm quote delete {string}")
    public void user_is_prompted_to_confirm_quote_delete(String msg) {
        searchEstimatePage.startAssertions(SearchEstimatePageAssertion.class)
                .assertIfDeleteConfirmationMessageAppears(msg)
                .endAssertion()
        ;
    }

    @When("Select Cancel")
    public void select_Cancel() {
        searchEstimatePage.clickOnCancelBtn();
    }

    @When("Click on the Delete button again and click OK.")
    public void click_on_the_Delete_button_again_and_click_OK() {
        searchEstimatePage.clickOnDeleteBtn()
                .clickOnOKBtn();
    }

    @Then("User is returned to the Maintain Quote search screen and the quotes status is now Deleted.")
    public void user_is_returned_to_the_Maintain_Quote_search_screen_and_the_quotes_status_is_now_Deleted() {
        searchEstimatePage = new SearchEstimatePage(driver);
        searchEstimatePage.startAssertions(SearchEstimatePageAssertion.class)
                .assertIfDeleteStatusDisplayed()
                .endAssertion()
                .clickBasedOnName("includeDeleted")
                .clickOnSearchBtn()
        ;
    }

    @When("Click on the Print button.")
    public void click_on_the_Print_button() {
        searchEstimatePage.doubleClickOnSearchResultVinNo()
                .clickOnPrintBtn()
        ;
    }

    @Then("Print options screen shown.")
    public void print_options_screen_shown() {
        searchEstimatePage.startAssertions(SearchEstimatePageAssertion.class)
                .assertIfPrintOptionsAreDisplayed()
                .endAssertion()
        ;
    }

    @When("Detailed button is enabled.")
    public void detailed_button_is_enabled() {
        searchEstimatePage.startAssertions(SearchEstimatePageAssertion.class)
                .assertIfDetailedBtnEnabled()
                .endAssertion()
        ;
    }

    @When("Detailed$2 button is enabled.")
    public void detailed$2_button_is_enabled() {
        searchEstimatePage.startAssertions(SearchEstimatePageAssertion.class)
                .assertIfDetailed2BtnEnabled()
                .endAssertion()
        ;
    }

    @When("Summary button is enabled.")
    public void summary_button_is_enabled() {
        searchEstimatePage.startAssertions(SearchEstimatePageAssertion.class)
                .assertIfSummaryBtnEnabled()
                .endAssertion()
        ;
    }

    @When("Click on the <  button.")
    public void click_on_the_button() {
        searchEstimatePage.clickOnBackBtn()
        ;
    }

    @Then("User is returned to quote view")
    public void user_is_returned_to_quote_view() {
        searchEstimatePage.startAssertions(SearchEstimatePageAssertion.class)
                .assertIfUserIsReturnedToQuoteViewPage()
                .endAssertion()
        ;
    }

    @When("Open quote and click on the Copy button.")
    public void open_quote_and_click_on_the_Copy_button() {
        searchEstimatePage.clickOnCopyBtn()
        ;
    }

    @When("Click the Cancel button.")
    public void click_the_Cancel_button() {
        searchEstimatePage.clickOnCancelBtn()
        ;
    }

    @When("Click on the Continue button until the save screen appears.")
    public void click_on_the_Continue_button_until_the_save_screen_appears() {
        gmCreateEstimatePage = new GMCreateEstimatePage(driver);
        gmCreateEstimatePage.clickOnContinueBtn()
                .clickOnContinueBtn()
        ;
    }

    @Then("Original quote is left as is and a new copy is created.")
    public void original_quote_is_left_as_is_and_a_new_copy_is_created(io.cucumber.datatable.DataTable dataTable) {
        List<String> copyData = new ArrayList<>();
        List<String> data = dataTable.asList();
        if (environment.contains("qa")) {
            copyData = Arrays.asList(data.get(0),data.get(1),data.get(2));
        } else if (environment.contains("uat")) {
            copyData = Arrays.asList(data.get(3),data.get(4),data.get(5));
        }
        gmCreateEstimatePage.startAssertions(GMCreateEstimatePageAssertion.class)
                .assertIfQuantityDescriptionAndPriceAddedToQuote(copyData, 2)
                .endAssertion()
        ;
    }

    @When("Click Save.")
    public void click_Save() {
        gmCreateEstimatePage.clickOnSaveBtn()
        ;
    }

    @Then("Copy of quote is saved.")
    public void copy_of_quote_is_saved(io.cucumber.datatable.DataTable dataTable) {
        List<String> savedData = new ArrayList<>();
        List<String> data = dataTable.asList();
        if (environment.contains("qa")) {
            savedData = Arrays.asList(data.get(0),data.get(1),data.get(2));
        } else if (environment.contains("uat")) {
            savedData = Arrays.asList(data.get(3),data.get(4),data.get(5));
        }
        gmCreateEstimatePage.startAssertions(GMCreateEstimatePageAssertion.class)
                .assertIfCopyQuoteSaved()
                .assertIfQuantityDescriptionAndPriceAddedToQuote(savedData, 2)
                .endAssertion()
        ;
    }

    @After
    public void close() {
        super.close();
    }
}