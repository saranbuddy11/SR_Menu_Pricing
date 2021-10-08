package GM.gmStepDefinitions.CreateEstimate;

import GM.gmAssertion.GMCreateEstimatePageAssertion;
import GM.gmAssertion.HomePageAssertion;
import GM.gmAssertion.LoginPageAssertion;
import GM.gmObjectRepository.GMCreateEstimatePage;
import GM.gmObjectRepository.HomePage;
import GM.gmObjectRepository.LoginPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import model.ManualMatchOption;
import stepDefinitions.AbstractTest;

import java.io.IOException;
import java.util.List;

public class VehicleTest extends AbstractTest {

    @When("Enter VIN {string} into the VIN field and click Search.")
    public void enter_VIN_into_the_VIN_field_and_click_Search(String vinNo) {
        super.setUp();
        homePage = functionalLibrary.gmLogIn(environment, configuration, HomePage.class);
        homePage.inputVIN(vinNo)
                .clickOnSearchBtnGM();

    }

    @Then("The vehicle is found with {string} characteristics displayed.")
    public void the_vehicle_is_found_with_characteristics_displayed(String vehicleName) {
        gmCreateEstimatePage = new GMCreateEstimatePage(driver);
        gmCreateEstimatePage.startAssertions(GMCreateEstimatePageAssertion.class)
                .assertIfVehicleDetailsFound(vehicleName)
                .endAssertion()
                .clickOnVehicleTab()
        ;
    }

    @When("Enter VIN {string} into the VIN field and press the enter key")
    public void enter_VIN_into_the_VIN_field_and_press_the_enter_key(String vinNo) {
        homePage = new HomePage(driver);
        homePage.clickOnClearBtn()
                .inputVIN(vinNo)
                .pressEnterKey()
                .pressEnterKey()
        ;
    }

    @Then("The vehicle is found with its characteristics displayed. {string}")
    public void the_vehicle_is_found_with_its_characteristics_displayed(String vehicleName) {
        gmCreateEstimatePage = new GMCreateEstimatePage(driver);
        gmCreateEstimatePage.startAssertions(GMCreateEstimatePageAssertion.class)
                .assertIfVehicleDetailsFound(vehicleName)
                .endAssertion()
                .clickOnVehicleTab()
        ;
    }

    @When("Enter something into the VIN box that is not a valid VIN an click Search {string}")
    public void enter_something_into_the_VIN_box_that_is_not_a_valid_VIN_and_click_Search(String wrongVinNo) {
        homePage = new HomePage(driver);
        homePage.clickOnClearBtn()
                .acceptAlertIfPresent(HomePage.class);
        homePage.inputVIN(wrongVinNo)
                .clickOnSearchBtnGM();
    }

    @Then("User is shown message: {string} The manual match drop down lists are now available.")
    public void userIsShownMessageTheManualMatchDropDownListsAreNowAvailable(String expectedErrorMsg) {
        homePage.startAssertions(HomePageAssertion.class)
                .assertIfErrorMsgIsDisplayed(expectedErrorMsg)
                .endAssertion()
                .clickOnClearBtn();
        ;
    }

    @When("Enter something into the Lic No {string} box  [i.e. non alphanumeric characters] that is not a valid  License Number.")
    public void enterSomethingIntoTheLicNoBoxIENonAlphanumericCharactersThatIsNotAValidLicenseNumber(String invalidLICNo) {
        homePage.inputLicNo(invalidLICNo);
    }

    @Then("Does not accept the invalid License Number. It is impossible to put to the LIC no box.")
    public void does_not_accept_the_invalid_License_Number_It_is_impossible_to_put_to_the_LIC_no_box() {
        homePage.startAssertions(HomePageAssertion.class)
                .assertIfLICNoBoxSpecialCharactersAreNotAccepted()
                .endAssertion()
        ;
    }

    @When("Enter something into the Engine No.box {string}")
    public void enterSomethingIntoTheEngineNoBox(String invalidEngineNo) {
        homePage.inputEngineNo(invalidEngineNo);
    }

    @Then("Does not accept an invalid engine number. It is impossible to put to the Engine No. box")
    public void doesNotAcceptAnInvalidEngineNumberItIsImpossibleToPutToTheEngineNoBox() {
        homePage.startAssertions(HomePageAssertion.class)
                .assertIfEngineNoBoxSpecialCharactersAreNotAccepted()
                .endAssertion()
        ;
    }

    @When("Enter something into the Customer Name box that is not valid {string} and click Search.")
    public void enterSomethingIntoTheCustomerNameBoxThatIsNotValidSeleniumTestingAndClickSearch(String customerName) {
        homePage.inputCustomerName(customerName)
                .clickOnSearchBtnGM()
        ;
    }

    @When("Enter the Name of an existing customer {string} and click Search.")
    public void enterTheNameOfAnExistingCustomerJoeDoeAndClickSearch(String customerName) {
        homePage.inputCustomerName(customerName)
                .clickOnSearchBtnGM()
        ;
    }

    @Then("The customer is found and is displayed with each of their associated vehicles but the Continue button is disabled at this time.")
    public void the_customer_is_found_and_is_displayed_with_each_of_their_associated_vehicles_but_the_Continue_button_is_disabled_at_this_time() {
        homePage.startAssertions(HomePageAssertion.class)
//                .assertIfCustomerIsFoundWithEachOfTheirAssociatedVehiclesAndIsDisplayed()
                .assertIfContinueBtnIsEnabled()
                .endAssertion()
        ;
    }

    @Then("One click on one of the vehicles activates the Continue button. double clicking one of the vehicles selects and continues the quote to the next page.")
    public void one_click_on_one_of_the_vehicles_activates_the_Continue_button_double_clicking_one_of_the_vehicles_selects_and_continues_the_quote_to_the_next_page() {
        homePage.clickOnARowInSearchVehicle()
                .continueBtnClick()
                .continueBtnClick();
        gmCreateEstimatePage = new GMCreateEstimatePage(driver);
        gmCreateEstimatePage.startAssertions(GMCreateEstimatePageAssertion.class)
                .assertAtEstimateTab()
                .endAssertion()
                .clickOnVehicleTab()
        ;
    }

    @Then("For only one vehicle associated, The customer {string} and their vehicle is found and the Create Estimate page is automatically loaded.")
    public void for_only_one_vehicle_associated_The_customer_and_their_vehicle_is_found_and_the_Create_Estimate_page_is_automatically_loaded(String customerName) {
        homePage.clickOnClearBtn()
                .acceptAlertIfPresent(HomePage.class);
        homePage.inputCustomerName(customerName)
                .clickOnSearchBtnGM()
                .clickOnARowInSearchVehicle()
                .clickOnARowInSearchVehicle();
        gmCreateEstimatePage = new GMCreateEstimatePage(driver);
        gmCreateEstimatePage.clickOnContinueBtn()
                .clickOnContinueBtn()
                .startAssertions(GMCreateEstimatePageAssertion.class)
                .assertAtEstimateTab()
                .endAssertion()
                .clickOnVehicleTab()
        ;
    }

//    @When("Enter the Address of one of the existing customers into the Address box and click Search. [UAT address: ADD]")
//    public void enter_the_Address_of_one_of_the_existing_customers_into_the_Address_box_and_click_Search_UAT_address_ADD() {
//
//
//    }
//
//    @Then("The customer\\(s) with the entered address are displayed with any associated vehicles.")
//    public void the_customer_s_with_the_entered_address_are_displayed_with_any_associated_vehicles() {
//
//
//    }

    @When("Enter {string} into the Address box that is not stored as an Address and click Search.")
    public void enter_into_the_Address_box_that_is_not_stored_as_an_Address_and_click_Search(String address) {
        homePage = new HomePage(driver);
        homePage.clickOnClearBtn()
                .acceptAlertIfPresent(GMCreateEstimatePage.class);
        homePage.inputAddress(address)
                .searchBtn()
        ;
    }

//    @Then("User is shown message: “No vehicles found. Please verify VIN or manually select the vehicle below. \".The manual match drop down lists are now displayed.")
//    public void user_is_shown_message_No_vehicles_found_Please_verify_VIN_or_manually_select_the_vehicle_below_The_manual_match_drop_down_lists_are_now_displayed() {
//
//
//    }

//    @When("Enter the zip Code of one of the existing customers into the zip Code box and click Search.")
//    public void enter_the_zip_Code_of_one_of_the_existing_customers_into_the_zip_Code_box_and_click_Search() {
//
//
//    }
//
//    @Then("The customer\\(s) with the entered post code is displayed with any associated vehicles.")
//    public void the_customer_s_with_the_entered_post_code_is_displayed_with_any_associated_vehicles() {
//
//
//    }

    @When("Enter {string} into the zip Code box that is not stored as a zip Code and click Search.")
    public void enter_into_the_zip_Code_box_that_is_not_stored_as_a_zip_Code_and_click_Search(String zipCode) {
        homePage.inputZipCode(zipCode)
                .searchBtn()
        ;
    }

//    @Then("User is shown message: “No vehicles found. Please verify VIN or manually select the vehicle below.\"The manual match drop down lists are now displayed.")
//    public void user_is_shown_message_No_vehicles_found_Please_verify_VIN_or_manually_select_the_vehicle_below_The_manual_match_drop_down_lists_are_now_displayed() {
//
//
//    }

    @When("Type text into all the search boxes and then click the Clear button.")
    public void type_text_into_all_the_search_boxes_and_then_click_the_Clear_button(io.cucumber.datatable.DataTable data) {
        List<String> detail = data.asList();
        homePage.inputVIN(detail.get(0))
                .inputLicNo(detail.get(1))
                .inputEngineNo(detail.get(2))
                .inputCustomerName(detail.get(3))
                .inputAddress(detail.get(4))
                .inputZipCode(detail.get(5))
                .startAssertions(HomePageAssertion.class)
                .assertISearchFieldInputedElementsDisplayed()
                .endAssertion()
                .clickOnClearBtn()
        ;
    }

    @Then("The search boxes manual match drop down lists customer details vehicle details are cleared.")
    public void theSearchBoxesManualMatchDropDownListsCustomerDetailsVehicleDetailsAreCleared() {
        homePage.startAssertions(HomePageAssertion.class)
                .assertISearchFieldAreCleared()
                .endAssertion()
        ;
    }

    @When("Type a partial amount of text into the VIN box {string} and click the Search button.")
    public void type_a_partial_amount_of_text_into_the_VIN_box_and_click_the_Search_button(String partialVin) {
        homePage.inputVIN(partialVin)
                .clickOnSearchBtnGM()
        ;
    }

    @Then("Vehicles with a partial match to the VIN are displayed. The search results will max out at $200 and a message is shown to the user: {string}.")
    public void vehicles_with_a_partial_match_to_the_VIN_are_displayed_The_search_results_will_max_out_at_$200_and_a_message_is_shown_to_the_user(String searchResultExceedErrorMSg) {
        homePage.startAssertions(HomePageAssertion.class)
                .assertIfErrorMsgIsDisplayed(searchResultExceedErrorMSg)
                .endAssertion()
                .clickOnClearBtn()
        ;
    }

    @When("Type a partial amount of text into the Name box {string} and click the Search button.")
    public void type_a_partial_amount_of_text_into_the_Name_box_and_click_the_Search_button(String partialCustomerName) {
        homePage.inputCustomerName(partialCustomerName)
                .searchBtn()
        ;
    }

    @Then("Customers \\(and any associated vehicles) with a partial match to the Name {string} are displayed.")
    public void customers_and_any_associated_vehicles_with_a_partial_match_to_the_Name_are_displayed(String customerName) {
        homePage.startAssertions(HomePageAssertion.class)
                .assertIfCustomerNameDisplayedInSearchResult(customerName)
                .endAssertion()
        ;
    }

    //    @When("Type a partial amount of text into the Address box and click the {string} button.")
//    public void type_a_partial_amount_of_text_into_the_Address_box_and_click_the_button(String string) {
//
//
//    }
//
//    @Then("Customers \\(and any associated vehicles) with a partial match to the Address are displayed.")
//    public void customers_and_any_associated_vehicles_with_a_partial_match_to_the_Address_are_displayed() {
//
//
//    }
//
//    @When("Type a partial amount of text into the Post Code box and click the {string} button.")
//    public void type_a_partial_amount_of_text_into_the_Post_Code_box_and_click_the_button(String string) {
//
//
//    }
//
//    @Then("Customers \\(and any associated vehicles) with a partial match to the Post Code are displayed.")
//    public void customers_and_any_associated_vehicles_with_a_partial_match_to_the_Post_Code_are_displayed() {
//
//
//    }
    @When("Click the New Estimate button after each of the following has been done Vehicle identified with details loaded Customer found and displayed.")
    public void click_the_New_Estimate_button_after_each_of_the_following_has_been_done_Vehicle_identified_with_details_loaded_Customer_found_and_displayed() {
        homePage.clickOnARowInSearchVehicle()
                .clickOnNewEstimateBtn()
        ;
    }

    @Then("Message is shown to user: {string} OK clears the screen Cancel leaves the page as is.")
    public void message_is_shown_to_user_OK_clears_the_screen_Cancel_leaves_the_page(String expectedWarnMSg) {
        homePage.startAssertions(HomePageAssertion.class)
                .assertIfDataLoseWarningMessageIsShown(expectedWarnMSg)
                .endAssertion()
                .acceptAlertIfPresent(HomePage.class);
        ;
    }

    @When("Navigate to manual match by clicking SEARCH without any fields filled.")
    public void navigate_to_manual_match_by_clicking_SEARCH_without_any_fields_filled() {
        homePage.startAssertions(HomePageAssertion.class)
                .assertISearchFieldAreCleared()
                .endAssertion()
                .clickOnSearchBtnGM()
                .startAssertions(HomePageAssertion.class)
                .assertIfErrorMsgIsDisplayed("No vehicles found. Please verify VIN or manually select the vehicle below.")
                .endAssertion()
        ;
    }

    @Then("Manual Match is displayed.")
    public void manual_Match_is_displayed() {
        homePage.startAssertions(HomePageAssertion.class)
                .assertIfManualMatchIsDisplayed()
                .endAssertion()
        ;
    }

    @When("Select desired manufacturer - field Sales Make.")
    public void select_desired_manufacturer_field_Sales_Make() {
        homePage.selectSalesMakeFromManuallyDropDown(ManualMatchOption.Chevrolet);

    }

    @Then("Manufacturer selected.")
    public void manufacturer_selected() {
        homePage.selectModelFromManuallyDropDown(ManualMatchOption.Beat);
    }

    @When("Select attributes from the drop down lists until a complete set  of details is ready.")
    public void select_attributes_from_the_drop_down_lists_until_a_complete_set_of_details_is_ready() {
        homePage.selectYearFromManuallyDropDown(ManualMatchOption.Year2018);
    }

    @Then("Dropdown populates with correct detail.")
    public void dropdown_populates_with_correct_detail() {
        homePage.startAssertions(HomePageAssertion.class)
                .assertIfManualSelectionElementsDisplayed()
                .endAssertion()
        ;
    }

    @When("Click on Continue.")
    public void click_on_Continue() {
        homePage.continueBtnClick()
                .acceptAlertIfPresent(HomePage.class);
    }

    @Then("Upon hitting continue user is taken to Create Quote screen.")
    public void upon_hitting_continue_user_is_taken_to_Create_Quote_screen() {
        gmCreateEstimatePage = new GMCreateEstimatePage(driver);
        gmCreateEstimatePage.startAssertions(GMCreateEstimatePageAssertion.class)
                .assertAtEstimateTab()
                .endAssertion()
                .clickOnVehicleTab();
        homePage = new HomePage(driver);
        homePage.clickOnClearBtn()
                .acceptAlertIfPresent(HomePage.class)
        ;
    }

    @When("Start NEW ESTIMATE - Click the Search button with no details entered.")
    public void start_NEW_ESTIMATE_Click_the_Search_button_with_no_details_entered() {
        homePage.clickOnNewEstimateBtn()
                .acceptAlertIfPresent(HomePage.class);
        homePage.searchBtn()
        ;
    }

    @Then("Manual match drop down lists appear")
    public void manual_match_drop_down_lists_appear() {
        homePage.startAssertions(HomePageAssertion.class)
                .assertIfManualMatchIsDisplayed()
                .endAssertion()
        ;
    }

    @When("Select half of the attributes from the drop down lists.")
    public void select_half_of_the_attributes_from_the_drop_down_lists() {
        homePage.selectModelFromManuallyDropDown(ManualMatchOption.Beat)
                .selectYearFromManuallyDropDown(ManualMatchOption.Year2018)
                .selectModelFromManuallyDropDown(ManualMatchOption.Null)
                .continueBtnClick()
        ;
    }

    @Then("Warning shown: {string}")
    public void warning_shown(String warningMsg) {
        homePage.startAssertions(HomePageAssertion.class)
                .assertIfDataLoseWarningMessageIsShown(warningMsg)
                .endAssertion()
                .acceptAlertIfPresent(HomePage.class)
        ;
    }

    @When("Click Unpriced Common Custom Jobs, click to complete ensure the link works correctly \\(Located at the bottom of the page, may need to be setup).")
    public void click_Unpriced_Common_Custom_Jobs_click_to_complete_ensure_the_link_works_correctly_Located_at_the_bottom_of_the_page_may_need_to_be_setup() {
        homePage.clickOnUnpricedCommonCustomJobsLink();
    }

    @Then("User is taken to Administration > Common Jobs.")
    public void user_is_taken_to_Administration_Common_Jobs() {
        gmCreateEstimatePage = new GMCreateEstimatePage(driver);
        gmCreateEstimatePage.startAssertions(GMCreateEstimatePageAssertion.class)
                .assertAtCommonJobsTab()
                .endAssertion();
        super.close()
        ;
    }

    @When("Enter a VIN {string} into the VIN field and click Search.")
    public void enter_a_VIN_into_the_VIN_field_and_click_Search(String vinNo) throws IOException {
        super.setUp();
        homePage = functionalLibrary.jlrLogIn(environment, configuration, HomePage.class);
        homePage.startAssertions(HomePageAssertion.class)
                .assertAtHomePage()
                .endAssertion()
                .inputVIN(excel.getData(1, 0))
                .searchBtn()
        ;
    }

    @Then("The vehicle is found: {string}.The user is taken to the quote page.")
    public void the_vehicle_is_found_The_user_is_taken_to_the_quote_page(String expectedVehicle) {
        homePage.startAssertions(HomePageAssertion.class)
                .assertIfVehicleDetailsFound(expectedVehicle)
                .endAssertion();
        ;
    }

    @When("Enter a VIN {string} into the VIN field and press the ENTER key.")
    public void enter_a_VIN_into_the_VIN_field_and_press_the_ENTER_key(String string) throws IOException {
        gmCreateEstimatePage = new GMCreateEstimatePage(driver);
        gmCreateEstimatePage.clickOnVehicleTab();
        homePage = new HomePage(driver);
        homePage.clickOnClearBtn();
        homePage.clickOnWarningAcceptBtn()
                .inputVIN(excel.getData(1, 0))
                .pressEnterKey()
        ;
    }

    @When("Enter something into the VIN box that is not a valid VIN {string} and Search.")
    public void enter_something_into_the_VIN_box_that_is_not_a_valid_VIN_and_Search(String string) throws IOException {
        gmCreateEstimatePage = new GMCreateEstimatePage(driver);
        gmCreateEstimatePage.clickOnVehicleTab();
        homePage = new HomePage(driver);
        homePage.clickOnClearBtn()
                .clickOnWarningAcceptBtn();
        homePage.inputVIN(excel.getData(2, 0))
                .searchBtn()
                .clickOnWarningAcceptBtn()
        ;
    }

    @Then("Warning message is displayed: {string}")
    public void warning_message_is_displayed(String warnMsg) {
        homePage.startAssertions(HomePageAssertion.class)
                .assertIfInvalidDataWarningMessageIsDisplayed(warnMsg)
                .endAssertion()
                .acceptAlertIfPresent(HomePage.class)
        ;
    }

    @When("Enter REG {string} into the REG field and click Search.")
    public void enter_REG_into_the_REG_field_and_click_Search(String regNo) throws IOException {
        homePage.clickOnClearBtn()
                .inputRegistrationNo(excel.getData(7, 0))
                .searchBtn()
        ;
    }

    @When("Enter REG {string} into the REG field and press the ENTER key.")
    public void enter_REG_into_the_REG_field_and_press_the_ENTER_key(String regNo) {
        gmCreateEstimatePage = new GMCreateEstimatePage(driver);
        gmCreateEstimatePage.clickOnVehicleTab();
        homePage = new HomePage(driver);
        homePage.clickOnClearBtn()
                .clickOnWarningAcceptBtn()
                .inputRegistrationNo(regNo)
                .pressEnterKey()
        ;
    }

    @When("Enter something into the REG box that is not a valid REG {string} and click Search.")
    public void enter_something_into_the_REG_box_that_is_not_a_valid_REG_and_click_Search(String invalidRegNo) {
        gmCreateEstimatePage = new GMCreateEstimatePage(driver);
        gmCreateEstimatePage.clickOnVehicleTab();
        homePage = new HomePage(driver);
        homePage.clickOnClearBtn()
                .clickOnWarningAcceptBtn();
        homePage.inputRegistrationNo(invalidRegNo)
                .searchBtn()
                .clickOnWarningAcceptBtn()
        ;
    }


    @When("Enter the Name of an existing customer who has just one vehicle associated to them and click Search.")
    public void enter_the_Name_of_an_existing_customer_who_has_just_one_vehicle_associated_to_them_and_click_Search() throws IOException {
        homePage.clickOnWarningAcceptBtn()
                .clickOnClearBtn()
                .inputCustomerName(excel.getData(3, 0))
                .searchBtn()
                .clickOnFirstSearchVehicle()
        ;
    }

    @When("Vehicle: Enter something into the Customer Name box that is not valid and click Search.")
    public void vehicle_Enter_something_into_the_Customer_Name_box_that_is_not_valid_and_click_Search() throws IOException {
        gmCreateEstimatePage = new GMCreateEstimatePage(driver);
        gmCreateEstimatePage.clickOnVehicleTab();
        homePage = new HomePage(driver);
        homePage.clickOnClearBtn();
        homePage.clickOnWarningAcceptBtn()
                .inputCustomerName(excel.getData(9, 0))
                .searchBtn()
                .clickOnWarningAcceptBtn()
        ;
    }

    @When("Vehicle: Enter the Name of an existing customer who has more than one vehicle associated to them and click Search.")
    public void vehicle_Enter_the_Name_of_an_existing_customer_who_has_more_than_one_vehicle_associated_to_them_and_click_Search() throws IOException {
        homePage.clickOnWarningAcceptBtn()
                .clickOnClearBtn()
                .inputCustomerName(excel.getData(4, 0))
                .searchBtn()
        ;

    }

    @Then("The customer {string} is found and is displayed with each of their associated vehicles but the Continue button is disabled at this time.{int} click on one of the vehicles activates the Continue button; double clicking one of the vehicles selects and continues the quote to the next page.")
    public void the_customer_is_found_and_is_displayed_with_each_of_their_associated_vehicles_but_the_Continue_button_is_disabled_at_this_time_click_on_one_of_the_vehicles_activates_the_Continue_button_double_clicking_one_of_the_vehicles_selects_and_continues_the_quote_to_the_next_page(String customerName, Integer int1) {
        homePage.startAssertions(HomePageAssertion.class)
                .assertIfCustomerNameDisplayedInSearchResult(customerName)
                .assertIfContinueBtnIsEnabled()
                .endAssertion()
        ;
    }

    @When("Customer: Enter the Address of one of the existing customers into the Address box and click Search.")
    public void customer_Enter_the_Address_of_one_of_the_existing_customers_into_the_Address_box_and_click_Search() throws IOException {
        homePage.clickOnClearBtn()
                .inputAddress(excel.getData(5, 0))
                .searchBtn()
        ;
    }

    @Then("The customer with the entered address are displayed with any associated vehicles.")
    public void the_customer_with_the_entered_address_are_displayed_with_any_associated_vehicles() throws IOException {
        homePage.startAssertions(HomePageAssertion.class)
                .assertIfCustomerNameDisplayedInSearchResult(excel.getData(5, 0))
                .assertIfContinueBtnIsEnabled()
                .endAssertion()
        ;
    }

    @When("Customer: Enter something into the Address box that is not stored as an Address and click Search.")
    public void customer_Enter_something_into_the_Address_box_that_is_not_stored_as_an_Address_and_click_Search() throws IOException {
        homePage = new HomePage(driver);
        homePage.clickOnClearBtn();
        homePage.inputAddress(excel.getData(9, 0))
                .searchBtn()
        ;
    }

    @When("Customer: Enter the Post Code of one of the existing customers into the Post Code box and click Search.")
    public void customer_Enter_the_Post_Code_of_one_of_the_existing_customers_into_the_Post_Code_box_and_click_Search() throws IOException {
        homePage.clickOnWarningAcceptBtn()
                .clickOnClearBtn()
                .inputZipCode(excel.getData(6, 0))
                .searchBtn()
        ;
    }

    @Then("The customer with the entered post code is displayed with any associated vehicles.")
    public void the_customer_with_the_entered_post_code_is_displayed_with_any_associated_vehicles() throws IOException {
        homePage.startAssertions(HomePageAssertion.class)
                .assertIfCustomerNameDisplayedInSearchResult(excel.getData(6, 0))
                .endAssertion()
        ;
    }

    @When("Customer: Enter something into the Post Code box that is not stored as a Post Code and click Search.")
    public void customer_Enter_something_into_the_Post_Code_box_that_is_not_stored_as_a_Post_Code_and_click_Search() throws IOException {
        homePage = new HomePage(driver);
        homePage.clickOnClearBtn();
        homePage.inputAddress(excel.getData(9, 0))
                .searchBtn()
        ;
    }

    @When("Type text into all the search boxes and then click the {string} button.")
    public void type_text_into_all_the_search_boxes_and_then_click_the_button(String string) throws IOException {
        homePage.clickOnWarningAcceptBtn()
                .inputVIN(excel.getData(1, 0))
                .inputRegistrationNo(excel.getData(7, 0))
                .inputZipCode(excel.getData(6, 0))
                .inputCustomerName(excel.getData(3, 0))
                .inputAddress(excel.getData(5, 0))
                .clickOnClearBtn()
        ;
    }

    @Then("The search boxes, manual match drop down lists, customer details and vehicle details are cleared.")
    public void the_search_boxes_manual_match_drop_down_lists_customer_details_and_vehicle_details_are_cleared() {
        homePage.startAssertions(HomePageAssertion.class)
                .assertISearchFieldAreCleared()
                .endAssertion()
        ;
    }

    @When("Vehicle: Type a partial amount of text into the VIN box and click the {string} button.")
    public void vehicle_Type_a_partial_amount_of_text_into_the_VIN_box_and_click_the_button(String string) throws IOException {
        homePage.inputVIN(excel.getData(1, 1))
                .searchBtn()
        ;
    }

    @Then("Vehicles with a partial match to the VIN are displayed with index of {int}. The search results will max out at {int} and a message is shown to the user: {string} {int} , {int}")
    public void vehicles_with_a_partial_match_to_the_VIN_are_displayed_with_index_of_The_search_results_will_max_out_at_and_a_message_is_shown_to_the_user(Integer index, Integer value, String noResultMsg, Integer row, Integer col) throws IOException {
        homePage.startAssertions(HomePageAssertion.class)
                .assertIfErrorMsgIsDisplayed(noResultMsg)
                .assertIfVehiclesWithAPartialMatchAreDisplayed(index, excel.getData(row, col))
                .endAssertion()
                .clickOnClearBtn()
        ;
    }

    @When("Vehicle: Type a partial amount of text into the Reg box and click the {string} button.")
    public void vehicle_Type_a_partial_amount_of_text_into_the_Reg_box_and_click_the_button(String string) throws IOException {
        homePage.inputRegistrationNo(excel.getData(2, 1))
                .searchBtn()
        ;

    }

    @Then("Vehicles with a partial match to the Reg are displayed. The search results will max out at {int} and a message is shown to the user: “Search result exceeds {int}. Only first {int} displayed! Please refine your search\".")
    public void vehicles_with_a_partial_match_to_the_Reg_are_displayed_The_search_results_will_max_out_at_and_a_message_is_shown_to_the_user_Search_result_exceeds_Only_first_displayed_Please_refine_your_search(Integer int1, Integer int2, Integer int3) throws IOException {
        homePage.inputVIN(excel.getData(3, 1))
                .searchBtn()
        ;
    }

    @When("Vehicle: Type a partial amount of text into the Customer Name box and click the {string} button.")
    public void vehicle_Type_a_partial_amount_of_text_into_the_Customer_Name_box_and_click_the_button(String string) throws IOException {
        homePage.inputCustomerName(excel.getData(3, 1))
                .searchBtn()
        ;
    }

    @Then("Customers and any associated vehicles with a partial match to the Address are displayed with index of {int} , {int} , {int}")
    public void customers_and_any_associated_vehicles_with_a_partial_match_to_the_Address_are_displayed_with_index_of(Integer index, Integer row, Integer col) throws IOException {
        homePage.startAssertions(HomePageAssertion.class)
                .assertIfCustomerDetailWithAPartialMatchAreDisplayed(index, excel.getData(row, col))
                .endAssertion()
                .clickOnClearBtn()
        ;

    }

    @When("Vehicle: Type a partial amount of text into the Address box and click the {string} button.")
    public void vehicle_Type_a_partial_amount_of_text_into_the_Address_box_and_click_the_button(String string) throws IOException {
        homePage.inputAddress(excel.getData(4, 1))
                .searchBtn()
        ;
    }

    @When("Vehicle: Type a partial amount of text into the Post Code box and click the {string} button.")
    public void vehicle_Type_a_partial_amount_of_text_into_the_Post_Code_box_and_click_the_button(String string) throws IOException {
        homePage.inputZipCode(excel.getData(5, 1))
                .searchBtn()
        ;
    }

    @When("Vehicle: Click the {string} button after each of the following has been done: Vehicle identified with details loaded. Customer found and displayed")
    public void vehicle_Click_the_button_after_each_of_the_following_has_been_done_Vehicle_identified_with_details_loaded_Customer_found_and_displayed(String string) throws IOException {
        homePage.inputVIN(excel.getData(8, 0))
                .searchBtn()
                .clickOnNewEstimateBtn()
        ;
    }

    @Then("Message is shown to user: {string}. OK clears the screen Cancel leaves the page as is.")
    public void message_is_shown_to_user_OK_clears_the_screen_Cancel_leaves_the_page_as_is(String warnMsg) {
        homePage.startAssertions(HomePageAssertion.class)
                .assertIfInvalidDataWarningMessageIsDisplayed(warnMsg)
                .endAssertion()
                .clickOnWarningAcceptBtn();
        homePage.startAssertions(HomePageAssertion.class)
                .assertISearchFieldAreCleared()
                .endAssertion()
        ;
    }

    @When("Navigate to manual match by selecting a brand icon")
    public void navigate_to_manual_match_by_selecting_a_brand_icon() {
        homePage.clickOnJaguarLogo()
                .clickOnVehicleModelX70()
        ;
    }

    @When("Select desired manufacturer - Jaguar")
    public void select_desired_manufacturer_Jaguar() {
        homePage.selectYearFromManuallyDropDown(ManualMatchOption.Year2019)
                .selectCCFromManuallyDropDown(ManualMatchOption.CC2Series)
        ;
    }

    @When("Click Continue.")
    public void click_Continue() {
        homePage.continueBtnClick()
                .clickOnWarningAcceptBtn()
        ;
    }

    @When("Navigate to manual match of landrover by selecting a brand icon")
    public void navigate_to_manual_match_of_landrover_by_selecting_a_brand_icon() {
        homePage.clickOnNewEstimateBtn()
                .clickOnWarningAcceptBtn()
                .clickOnLandroverLogo()
                .clickOnVehicleModelL538()
        ;
    }

    @When("Select desired manufacturer - Land Rover")
    public void select_desired_manufacturer_Land_Rover() {
        homePage.selectYearFromManuallyDropDown(ManualMatchOption.Year2018)
                .selectCCFromManuallyDropDown(ManualMatchOption.CC2Series)
                .selectEngineFromManuallyDropDown(ManualMatchOption.Engine20Si4)
        ;
    }

    @When("Click Unpriced generic jobs, click to complete ensure the link works correctly. Located at the bottom of the page.")
    public void click_Unpriced_generic_jobs_click_to_complete_ensure_the_link_works_correctly_Located_at_the_bottom_of_the_page() {
        homePage.clickOnNewEstimateBtn()
                .clickOnWarningAcceptBtn()
                .clickOnUnpricedCommonCustomJobsLink()
        ;
    }

    @Then("User is taken to Administration> Generic Jobs. Navigate back to customer tab")
    public void user_is_taken_to_Administration_Generic_Jobs_Navigate_back_to_customer_tab() {
        homePage.startAssertions(HomePageAssertion.class)
                .assertAtGenericJobsTab()
                .endAssertion()
        ;
    }

    @When("Click Generic parts priced below retail, click to complete ensure the link works correctly Located at the bottom of the page.")
    public void click_Generic_parts_priced_below_retail_click_to_complete_ensure_the_link_works_correctly_Located_at_the_bottom_of_the_page() {
        homePage.openCreateEstimateTab()
                .clickOnGenericPartsPriceLink()
        ;
    }

    @Then("User is taken to Administration> Generic Parts. Navigate back to customer tab")
    public void user_is_taken_to_Administration_Generic_Parts_Navigate_back_to_customer_tab() {
        homePage.startAssertions(HomePageAssertion.class)
                .assertAtGenericPartsTab()
                .endAssertion()
        ;
    }

    @When("Hit the Log Out button, press OK when the warning message prompts.")
    public void hit_the_Log_Out_button_press_OK_when_the_warning_message_prompts() {
        homePage.openCreateEstimateTab()
                .clickBasedOnName("logout");
        homePage.clickOnWarningAcceptBtn()
        ;
    }

    @Then("The user is logged out of the current session and taken back to the login screen. Log back in and navigate to screen before logging out")
    public void the_user_is_logged_out_of_the_current_session_and_taken_back_to_the_login_screen_Log_back_in_and_navigate_to_screen_before_logging_out() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.startAssertions(LoginPageAssertion.class)
                .assertAtLoginPage()
                .endAssertion()
                .goToPreviousPage(LoginPage.class)
                .startAssertions(LoginPageAssertion.class)
                .assertAtLoginPage()
                .endAssertion();
        super.close();
    }
}