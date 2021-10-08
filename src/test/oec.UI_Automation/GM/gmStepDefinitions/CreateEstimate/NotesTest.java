package GM.gmStepDefinitions.CreateEstimate;

import GM.gmAssertion.GMCreateEstimatePageAssertion;
import GM.gmAssertion.GMCreateEstimatesNotesPageAssertion;
import GM.gmAssertion.HomePageAssertion;
import GM.gmObjectRepository.*;
import GM.gmObjectRepository.menuManager.MenuManagerPage;
import io.cucumber.java.After;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import model.ManualMatchOption;
import stepDefinitions.AbstractTest;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class NotesTest extends AbstractTest {

    @When("Create Estimate for using {string} vehicle with a VIN. Move to the Notes page.")
    public void create_Estimate_for_using_vehicle_with_a_VIN_Move_to_the_Notes_page(String vinNo) {
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
        gmCreateEstimateCustomerPage = new GMCreateEstimateCustomerPage(driver);
        gmCreateEstimateCustomerPage.enterCustomerName("Joe Doe")
                .clickOnSearchBtn()
                .clickOnContinueBtn();
        gmCreateEstimateNotesPage = new GMCreateEstimateNotesPage(driver);
        gmCreateEstimateNotesPage.startAssertions(GMCreateEstimatesNotesPageAssertion.class)
                .assertAtNotesTab()
                .endAssertion()
        ;
    }

    @Then("The vehicles VIN {string} are shown in the corresponding boxes.")
    public void the_vehicles_VIN_are_shown_in_the_corresponding_boxes(String vinNo) {
        gmCreateEstimateNotesPage = new GMCreateEstimateNotesPage(driver);
        gmCreateEstimateNotesPage.startAssertions(GMCreateEstimatesNotesPageAssertion.class)
                .assertIfVehiclesVINAreShownInTheCorrespondingBoxes(vinNo)
                .endAssertion()
        ;
    }

    @When("Edit the Estimate valid until date.")
    public void edit_the_Estimate_valid_until_date() {
        gmCreateEstimateNotesPage.editEstimateDate();
        gmCreateEstimatePage = new GMCreateEstimatePage(driver);
        gmCreateEstimatePage.clickOnContinueBtn()
                .clickOnNotesTab();
    }

    @Then("Date changed.")
    public void date_changed() {
        gmCreateEstimateNotesPage.startAssertions(GMCreateEstimatesNotesPageAssertion.class)
                .assertIfVehicleEstimateValidDateChanged()
                .endAssertion()
        ;
    }

    @When("Attempt to type more than six digits into the Distance box.")
    public void attempt_to_type_more_than_six_digits_into_the_Distance_box() {
        gmCreateEstimateNotesPage = new GMCreateEstimateNotesPage(driver);
        gmCreateEstimateNotesPage.enterMileage("2500000")
        ;
    }

    @Then("six digits is the limit for this field.")
    public void six_digits_is_the_limit_for_this_field() {
        gmCreateEstimateNotesPage = new GMCreateEstimateNotesPage(driver);
        gmCreateEstimateNotesPage.startAssertions(GMCreateEstimatesNotesPageAssertion.class)
                .assertIfTheSixDigitsIsTheLimitForThisField("250000")
                .endAssertion()
        ;
    }

    @When("Enter a reasonable figure into the Distance box.")
    public void enter_a_reasonable_figure_into_the_Distance_box() {
        gmCreateEstimateNotesPage = new GMCreateEstimateNotesPage(driver);
        gmCreateEstimateNotesPage.enterMileage("250000")
        ;
    }

    @Then("The field accepts the reasonable figure.")
    public void the_field_accepts_the_reasonable_figure() {
        gmCreateEstimateNotesPage = new GMCreateEstimateNotesPage(driver);
        gmCreateEstimateNotesPage.startAssertions(GMCreateEstimatesNotesPageAssertion.class)
                .assertIfTheFieldAcceptsTheReasonableFigureMileageTextBox()
                .endAssertion()
        ;
    }

    @When("Enter {string} into the Notes box and click Continue.")
    public void enter_into_the_Notes_box_and_click_Continue(String text) {
        gmCreateEstimateNotesPage = new GMCreateEstimateNotesPage(driver);
        gmCreateEstimateNotesPage.enterNotes(text);
        gmCreateEstimatePage = new GMCreateEstimatePage(driver);
        gmCreateEstimatePage.clickOnContinueBtn()
                .clickOnNotesTab()
        ;
    }

    @Then("Notes created with {string} text. Estimate continued to Estimate tab.")
    public void notes_created_with_text_Estimate_continued_to_Estimate_tab(String note) {
        gmCreateEstimateNotesPage = new GMCreateEstimateNotesPage(driver);
        gmCreateEstimateNotesPage.startAssertions(GMCreateEstimatesNotesPageAssertion.class)
                .assertIfNotesUpdated(note)
                .endAssertion();
        gmCreateEstimatePage = new GMCreateEstimatePage(driver);
        gmCreateEstimatePage.clickOnContinueBtn()
                .startAssertions(GMCreateEstimatePageAssertion.class)
                .assertAtEstimateTab()
                .endAssertion()

        ;
    }

    @When("Create Estimate for a manually matched vehicle. Move to the Notes page.")
    public void create_Estimate_for_a_manually_matched_vehicle_Move_to_the_Notes_page() {
        gmCreateEstimatePage.clickOnVehicleTab();
        homePage = new HomePage(driver);
        homePage.startAssertions(HomePageAssertion.class)
                .assertAtHomePage()
                .endAssertion()
                .clickOnClearBtn()
                .acceptAlertIfPresent(HomePage.class);
        homePage.searchBtn()
                .selectSalesMakeFromManuallyDropDown(ManualMatchOption.Chevrolet)
                .selectModelFromManuallyDropDown(ManualMatchOption.Impala)
                .selectYearFromManuallyDropDown(ManualMatchOption.Year2017)
                .selectCCFromManuallyDropDown(ManualMatchOption.CC3Series)
                .selectBadgeFromManuallyDropDown(ManualMatchOption.LT)
                .continueBtnClick();
        gmCreateEstimatePage = new GMCreateEstimatePage(driver);
        gmCreateEstimatePage.clickOnContinueBtn();
        gmCreateEstimateCustomerPage = new GMCreateEstimateCustomerPage(driver);
        gmCreateEstimateCustomerPage.enterCustomerName("Joe Doe")
                .clickOnSearchBtn()
                .clickOnContinueBtn();
        gmCreateEstimateNotesPage = new GMCreateEstimateNotesPage(driver);
        gmCreateEstimateNotesPage.startAssertions(GMCreateEstimatesNotesPageAssertion.class)
                .assertAtNotesTab()
                .endAssertion()
        ;
    }

    @Then("LIC, VIN and Distance boxes are empty.")
    public void lic_VIN_and_Distance_boxes_are_empty() {
        gmCreateEstimateNotesPage.startAssertions(GMCreateEstimatesNotesPageAssertion.class)
                .assertIfRegVINAndDistanceBoxesAreEmpty()
                .endAssertion()
        ;
    }

    @When("Enter a LIC {string}, VIN {string} and distance {string}.")
    public void enter_a_LIC_VIN_and_distance(String regNo, String vinNo, String distance) {
        gmCreateEstimateNotesPage.enterLicensePlate(regNo)
                .enterVinNo(vinNo)
                .enterMileage(distance);
        gmCreateEstimatePage = new GMCreateEstimatePage(driver);
        gmCreateEstimatePage.clickOnContinueBtn()
                .clickOnNotesTab()
        ;
    }

    @Then("LIC {string} and VIN {string} can be manually entered.")
    public void lic_and_VIN_can_be_manually_entered(String regNo, String vinNo) {
        List<String> expectedRegAndVinNo = Arrays.asList(regNo, vinNo);
        gmCreateEstimateNotesPage = new GMCreateEstimateNotesPage(driver);
        gmCreateEstimateNotesPage.startAssertions(GMCreateEstimatesNotesPageAssertion.class)
                .assertIfRegAndVINCanBeManuallyEntered(expectedRegAndVinNo)
                .endAssertion()
        ;
    }

    @When("Click on the Continue button.")
    public void click_on_the_Continue_button() {
        gmCreateEstimatePage = new GMCreateEstimatePage(driver);
        gmCreateEstimatePage.clickOnContinueBtn()
        ;
    }

    @Then("LIC {string}, VIN {string} are now displayed in Your Selection at top of page. Estimate continued to Estimate tab.")
    public void lic_VIN_are_now_displayed_in_Your_Selection_at_top_of_page_Estimate_continued_to_Estimate_tab(String regNo, String vinNo) {
        List<String> expectedRegAndVinNo = Arrays.asList(regNo, vinNo);
        gmCreateEstimatePage.startAssertions(GMCreateEstimatePageAssertion.class)
                .assertAtEstimateTab()
                .assertIfRegVINAreNowDisplayedInYourSelectionAtTopOfPage(expectedRegAndVinNo)
                .endAssertion()
                .clickOnNotesTab()
        ;
    }

    @When("Attempt to type {string} into the Distance box.")
    public void attempt_to_type_into_the_Distance_box(String text) {
        gmCreateEstimateNotesPage = new GMCreateEstimateNotesPage(driver);
        gmCreateEstimateNotesPage.enterMileage(text)
        ;
    }

    @Then("Text input should be disabled.")
    public void text_input_should_be_disabled() {
        gmCreateEstimateNotesPage.startAssertions(GMCreateEstimatesNotesPageAssertion.class)
                .assertIfTextInputShouldBeDisabledInMileageTextBox()
                .endAssertion()
                .enterMileage("1000")
        ;
    }

    @When("Once all fields are completed click the continue button.")
    public void once_all_fields_are_completed_click_the_continue_button() {
        gmCreateEstimatePage = new GMCreateEstimatePage(driver);
        gmCreateEstimatePage.clickOnContinueBtn();
    }

    @Then("The user is taken back to the Estimate tab.")
    public void the_user_is_taken_back_to_the_Estimate_tab() {
        gmCreateEstimatePage.startAssertions(GMCreateEstimatePageAssertion.class)
                .assertAtEstimateTab()
                .endAssertion();
    }

    @When("Create a quote for a vehicle with a VIN & Reg. Move to the Notes page.")
    public void createAQuoteForAVehicleWithAVINRegMoveToTheNotesPage() throws IOException {
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
        ;
    }

    @Then("User is taken to the notes tab.")
    public void user_is_taken_to_the_notes_tab() {
        gmCreateEstimateNotesPage = new GMCreateEstimateNotesPage(driver);
        gmCreateEstimateNotesPage.startAssertions(GMCreateEstimatesNotesPageAssertion.class)
                .assertAtJLRNotesTab()
                .endAssertion()
        ;
    }

    @When("Edit the Quote valid until date.")
    public void edit_the_Quote_valid_until_date() {
        menuManagerPage = new MenuManagerPage(driver);
        menuManagerPage.selectDateCurrentDate();
        calenderPage = new CalenderPage(driver);
        calenderPage.setTodayDate()
        ;
    }

    @Then("Notes created with {string} text. Quote continued to Quote tab.")
    public void notes_created_with_text_Quote_continued_to_Quote_tab(String note) {
        gmCreateEstimateNotesPage = new GMCreateEstimateNotesPage(driver);
        gmCreateEstimateNotesPage.startAssertions(GMCreateEstimatesNotesPageAssertion.class)
                .assertIfNotesUpdated(note)
                .endAssertion();
        gmCreateEstimatePage = new GMCreateEstimatePage(driver);
        gmCreateEstimatePage.clickOnContinueBtn()
                .startAssertions(GMCreateEstimatePageAssertion.class)
                .assertAtQuoteTab()
                .endAssertion()
                .clickOnNewQuote();
        homePage = new HomePage(driver);
        homePage.clickOnWarningAcceptBtn()
        ;
    }

    @When("Navigate to manual match by selecting a brand icon.")
    public void navigate_to_manual_match_by_selecting_a_brand_icon() {
        homePage.clickOnJaguarLogo()
                .clickOnVehicleModelX70()
        ;
    }

    @When("Select desired manufacturer - Jaguar.")
    public void select_desired_manufacturer_Jaguar() {
        homePage.selectYearFromManuallyDropDown(ManualMatchOption.Year2019)
                .selectCCFromManuallyDropDown(ManualMatchOption.CC2Series)
        ;
    }

    @When("Click Continue jaguar")
    public void click_Continue_jaguar() {
        homePage.continueBtnClick()
                .clickOnWarningAcceptBtn();
        gmCreateEstimatePage = new GMCreateEstimatePage(driver);
        gmCreateEstimatePage.expandJobTreeInnerRow(1)
                .expandJobTreeSubInnerRow(1)
                .expandJobTreeLevelThreeInnerRow(1)
                .clickOnFirstLevel4Job()
                .clickOnContinueBtn();
        gmCreateEstimateCustomerPage = new GMCreateEstimateCustomerPage(driver);
        gmCreateEstimateCustomerPage.enterCustomerName("Joe Doe")
                .clickOnSearchBtn()
                .clickOnContinueBtn()
        ;
    }

    @When("Click Continue land rover")
    public void click_Continue_land_rover() {
        homePage.continueBtnClick()
                .clickOnWarningAcceptBtn();
        gmCreateEstimatePage = new GMCreateEstimatePage(driver);
        gmCreateEstimatePage.expandJobTreeInnerRow(1)
                .expandJobTreeSubInnerRow(1)
                .clickOnFirstLevel3Job()
                .clickOnContinueBtn();
        gmCreateEstimateCustomerPage = new GMCreateEstimateCustomerPage(driver);
        gmCreateEstimateCustomerPage.enterCustomerName("Joe Doe")
                .clickOnSearchBtn()
                .clickOnContinueBtn()
        ;
    }

    @When("Navigate to manual match of landrover by selecting a brand icon.")
    public void navigate_to_manual_match_of_landrover_by_selecting_a_brand_icon() {
        homePage.clickOnNewEstimateBtn()
                .clickOnWarningAcceptBtn()
                .clickOnLandroverLogo()
                .clickOnVehicleModelL538()
        ;
    }

    @When("Select desired manufacturer - Land Rover.")
    public void select_desired_manufacturer_Land_Rover() {
        homePage.selectYearFromManuallyDropDown(ManualMatchOption.Year2018)
                .selectCCFromManuallyDropDown(ManualMatchOption.CC2Series)
                .selectEngineFromManuallyDropDown(ManualMatchOption.Engine20Si4)
        ;
    }

    @When("Click Unpriced generic jobs, click to complete ensure the link works correctly. Located at the bottom of the page")
    public void click_Unpriced_generic_jobs_click_to_complete_ensure_the_link_works_correctly_Located_at_the_bottom_of_the_page() {
        homePage.clickOnNewEstimateBtn()
                .clickOnWarningAcceptBtn()
                .clickOnUnpricedCommonCustomJobsLink()
        ;
    }

    @Then("User is taken to Administration> Generic Jobs. Navigate back to customer tab.")
    public void user_is_taken_to_Administration_Generic_Jobs_Navigate_back_to_customer_tab() {
        homePage.startAssertions(HomePageAssertion.class)
                .assertAtGenericJobsTab()
                .endAssertion()
        ;
    }

    @When("Click Generic parts priced below retail, click to complete ensure the link works correctly Located at the bottom of the page")
    public void click_Generic_parts_priced_below_retail_click_to_complete_ensure_the_link_works_correctly_Located_at_the_bottom_of_the_page() {
        homePage.openCreateEstimateTab()
                .clickOnGenericPartsPriceLink()
        ;
    }

    @Then("User is taken to Administration> Generic Parts. Navigate back to customer tab.")
    public void user_is_taken_to_Administration_Generic_Parts_Navigate_back_to_customer_tab() {
        homePage.startAssertions(HomePageAssertion.class)
                .assertAtGenericPartsTab()
                .endAssertion()
        ;
    }

    @Then("The vehicle is found: {string}.The user is taken to the quote page")
    public void the_vehicle_is_found_The_user_is_taken_to_the_quote_page(String expectedVehicle) {
        homePage.startAssertions(HomePageAssertion.class)
                .assertIfVehicleDetailsFound(expectedVehicle)
                .endAssertion()
        ;
    }

    @After
    public void close() {
        super.close();
    }
}