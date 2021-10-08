package GM.gmStepDefinitions.administration.partPricing.ui;

import GM.gmAssertion.ExpPartAndLabourPageAssertion;
import GM.gmAssertion.GMCreateEstimatePageAssertion;
import GM.gmAssertion.HomePageAssertion;
import GM.gmAssertion.PartLaborDrillDownPageAssertion;
import GM.gmAssertion.administration.PartPricingPageAssertion;
import GM.gmAssertion.miscellaneous.PartPageAssertion;
import GM.gmObjectRepository.*;
import GM.gmObjectRepository.administration.PartPricingPage;
import GM.gmObjectRepository.maintainEstimates.SearchEstimatePage;
import GM.gmObjectRepository.miscellaneous.JobsPage;
import GM.gmObjectRepository.miscellaneous.PartPage;
import io.cucumber.java.After;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import model.JobFormList;
import model.PartPricePricingTypes;
import model.SearchReasons;
import stepDefinitions.AbstractTest;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class PartPricingUITest extends AbstractTest {

    @When("Go to the Administration Part Pricing Except. by Category tab")
    public void go_to_the_Administration_Part_Pricing_Except_by_Category_tab() {
        super.setUp();
        homePage = functionalLibrary.gmLogIn(environment, configuration, HomePage.class);
        homePage.startAssertions(HomePageAssertion.class)
                .assertAtHomePage()
                .endAssertion()
                .openAdministrationTab();
        partPricingPage = new PartPricingPage(driver);
        partPricingPage.openPartPricingTab()
                .startAssertions(PartPricingPageAssertion.class)
                .assertAtPartPricingTab()
                .endAssertion()
                .openExceptByCategoryTab()
        ;
    }

    @Then("Except. by Category tab is accessible")
    public void except_by_Category_tab_is_accessible() {
        partPricingPage.startAssertions(PartPricingPageAssertion.class)
                .assertIfExceptByCategoryTabIsAccessible()
                .endAssertion()
        ;
    }

    @When("To add new part category exception click button ADD")
    public void to_add_new_part_category_exception_click_button_ADD() {
        partPricingPage.clickOnAddBtn();
    }

    @Then("A window pop ups with the list of all part categories available.")
    public void a_window_pop_ups_with_the_list_of_all_part_categories_available() {
        partPricingPage.startAssertions(PartPricingPageAssertion.class)
                .assertIfPartCategoriesListAvailable()
                .endAssertion()
        ;
    }

    @When("Search part category {string}")
    public void search_part_category(String part) {
        partPricingPage.searchPartCategoryTextBox(part)
                .clickOnSearchBtn();
    }

    @Then("{string} category should be visible on the list")
    public void category_should_be_visible_on_the_list(String part) {
        partPricingPage.startAssertions(PartPricingPageAssertion.class)
                .assertIfSearchedCategoryVisibleInList(part)
                .endAssertion()
                .selectHornPart()
        ;
    }

    @When("Select Fixed Price type from the drop down box and set value to {double}")
    public void select_Fixed_Price_type_from_the_drop_down_box_and_set_value_to(Double value) {
        partPricingPage.selectPricingOptions(PartPricePricingTypes.FixedPrice)
                .setFixedPrice(value)
                .selectHornPart()
                .clickOnSaveBtn()
        ;
    }

    @Then("Record for {string} is created or updated.")
    public void record_for_is_created_or_updated(String part) {
        partPricingPage.startAssertions(PartPricingPageAssertion.class)
                .assertIfPartRecordCreated(part)
                .endAssertion()
        ;
    }

    @When("Create estimate with VIN {string} and add Job Body Systems Horn Remove & Replace Dual")
    public void create_estimate_with_VIN_and_add_Job_Body_Systems_Horn_Remove_Replace_Dual(String vinNo) {
        int row1 = 0, row2 = 0;
        if (environment.contains("gmmenupricingonlineqa")) {
            row1 = 25;
            row2 = 18;
        } else if (environment.contains("gmmenupricingonlineuat")) {
            row1 = 24;
            row2 = 16;
        }
        homePage = new HomePage(driver);
        homePage.openCreateEstimateTab();
        homePage.inputVIN(vinNo)
                .searchBtn()
                .continueBtnClick();
        gmCreateEstimatePage = new GMCreateEstimatePage(driver);
        gmCreateEstimatePage.expandJobTreeInnerRow(4)
                .expandJobTreeSubInnerRow(row1)
                .expandJobTreeLevelThreeInnerRow(row2)
                .clickOnHornDual()
        ;
    }

    @Then("Estimate is created with job added")
    public void estimate_is_created_with_job_added(io.cucumber.datatable.DataTable addedJob) {
        List<String> data = addedJob.asList();
        gmCreateEstimatePage.startAssertions(GMCreateEstimatePageAssertion.class)
                .assertIfQuantityDescriptionAndPriceAddedNewToQuote(data, 2)
                .endAssertion()
        ;
    }

    @When("Open Job details and check part price for Horn")
    public void open_Job_details_and_check_part_price_for_Horn() {
        gmCreateEstimatePage.clickOnMagnifyingGlassIcon(1)
                .switchToTab(2);
    }

    @Then("Price should be visible")
    public void price_should_be_visible(io.cucumber.datatable.DataTable addedJob) {
        partLaborDrillDownPage = new PartLaborDrillDownPage(driver);
        List<String> data = addedJob.asList();
        List<String> value = null;
        if (environment.contains("qa")) {
            value = Arrays.asList(data.get(2), data.get(1));
        } else if (environment.contains("uat")) {
            value = Arrays.asList(data.get(2), data.get(1));
        }
        partLaborDrillDownPage.startAssertions(PartLaborDrillDownPageAssertion.class)
                .assertIfAddedPartsAreShownAlongWithTheirPrice(value)
                .endAssertion()
                .clickOnContinueBtn();
    }

    @Then("close browser")
    public void close_browser() {
        super.close();
    }

    @When("Select Cost Plus Price type from the drop down box and set value to {double}")
    public void select_Cost_Plus_Price_type_from_the_drop_down_box_and_set_value_to(Double value) {
        partPricingPage.selectPricingOptions(PartPricePricingTypes.CostPricePlus)
                .setCostPrice(value)
                .selectHornPart()
                .clickOnSaveBtn()
        ;
    }

    @When("Check Cost and Price of the tested PN {string}")
    public void check_Cost_and_Price_of_the_tested_PN(String partID) {
        gmCreateEstimatePage = new GMCreateEstimatePage(driver);
        gmCreateEstimatePage.switchToTab(1);
        gmCreateEstimatePage.clickOnPartMiscellaneousButton()
                .switchToTab(2);
        partPage = new PartPage(driver);
        jobsPage = new JobsPage(driver);
        jobsPage.selectJobFormDropDownOption(JobFormList.ManufacturerParts);
        partPage.enterSearchCriteriaID(partID)
                .clickOnPartSearchBtn()
                .clickOnAddIcon()
        ;
    }

    @Then("Part Number, Description, Cost, Price Exl tax is now visible")
    public void part_Number_Description_Cost_Price_Exl_tax_is_now_visible() {
        partPage.startAssertions(PartPageAssertion.class)
                .assertIfSelectedPartsDetailsPopulatedWithData()
                .endAssertion();
        jobsPage = new JobsPage(driver);
        jobsPage.clickOnAddBtn()
                .switchToTab(1)
        ;
    }

    @Then("Cost Price from {double} plus {int}% should be visible")
    public void cost_Price_from_plus_should_be_visible(Double costPrice, Integer percentage) {
        partLaborDrillDownPage = new PartLaborDrillDownPage(driver);
        partLaborDrillDownPage.startAssertions(PartLaborDrillDownPageAssertion.class)
                .assertIfCostPriceDiscountApplied(costPrice, percentage)
                .endAssertion()
        ;
    }

    @When("Select Cost Minus Price type from the drop down box and set value to {double}")
    public void select_Cost_Minus_Price_type_from_the_drop_down_box_and_set_value_to(Double value) {
        partPricingPage.selectPricingOptions(PartPricePricingTypes.CostPriceMinus)
                .setCostPrice(value)
                .selectHornPart()
                .clickOnSaveBtn()
        ;
    }

    @Then("Cost Price from {double} minus {int}% should be visible")
    public void cost_Price_from_minus_should_be_visible(Double costPrice, Integer percentage) {
        partLaborDrillDownPage = new PartLaborDrillDownPage(driver);
        partLaborDrillDownPage.startAssertions(PartLaborDrillDownPageAssertion.class)
                .assertIfCostPriceDeductionApplied(costPrice, percentage)
                .endAssertion()
        ;
    }

    @When("Select list price type from the drop down box and set value to {double}")
    public void select_list_price_type_from_the_drop_down_box_and_set_value_to(Double value) {
        partPricingPage.selectPricingOptions(PartPricePricingTypes.ListPricePlus)
                .setCostPrice(value)
                .selectHornPart()
                .clickOnSaveBtn()
        ;
    }

    @When("Select List Minus Price type from the drop down box and set value to {double}")
    public void select_List_Minus_Price_type_from_the_drop_down_box_and_set_value_to(Double value) {
        partPricingPage.selectPricingOptions(PartPricePricingTypes.ListPriceMinus)
                .setCostPrice(value)
                .selectHornPart()
                .clickOnSaveBtn()
        ;
    }

    @When("When Create estimate with VIN {string} and add Job Body Systems Horn Remove & Replace Dual")
    public void when_Create_estimate_with_VIN_and_add_Job_Body_Systems_Horn_Remove_Replace_Dual(String vinNo) {
        int row1 = 0, row2 = 0;
        if (environment.contains("gmmenupricingonlineqa")) {
            row1 = 13;
            row2 = 11;
        } else if (environment.contains("gmmenupricingonlineuat")) {
            row1 = 12;
            row2 = 10;
        }
        super.setUp();
        homePage = functionalLibrary.gmLogIn(environment, configuration, HomePage.class);
        homePage.startAssertions(HomePageAssertion.class)
                .assertAtHomePage()
                .endAssertion()
                .inputVIN(vinNo)
                .searchBtn()
                .continueBtnClick();
        gmCreateEstimatePage = new GMCreateEstimatePage(driver);
        gmCreateEstimatePage.expandJobTreeInnerRow(2)
                .expandJobTreeSubInnerRow(row1)
                .expandJobTreeLevelThreeInnerRow(row2)
                .clickOnFromModelYear2014To2018()
        ;
    }

    @Then("Estimate is created with added job.")
    public void estimate_is_created_with_added_job(io.cucumber.datatable.DataTable data) {
        List<String> expectedAddedQuote = data.asList();
        gmCreateEstimatePage.startAssertions(GMCreateEstimatePageAssertion.class)
                .assertIfQuantityDescriptionAndPriceAddedNewToQuote(expectedAddedQuote, 2)
                .endAssertion()
        ;
    }

    @When("Open Job details for the added job in the created estimate and check part price {double} for $19300457")
    public void open_Job_details_for_the_added_job_in_the_created_estimate_and_check_part_price_for_$19300457(Double value) {
        gmCreateEstimatePage.clickOnMagnifyingGlassIcon();
        partLaborDrillDownPage = new PartLaborDrillDownPage(driver);
        partLaborDrillDownPage.switchToTab(2)
                .startAssertions(PartLaborDrillDownPageAssertion.class)
                .assertIfPartPriceForAddedJobBasedOnQuantity(value)
                .endAssertion()
        ;
    }

    @Then("Quantity {string} and Price \\(Ex tax) {string} should be visible")
    public void quantity_and_Price_Ex_tax_should_be_visible(String quantity, String price) {
        List<String> expectedQuantityAndPrice = Arrays.asList(quantity, price);
        partLaborDrillDownPage.startAssertions(PartLaborDrillDownPageAssertion.class)
                .assertIfAddedPartsAreShownQuantityAlongWithTheirPrice(expectedQuantityAndPrice)
                .endAssertion()
                .clickOnContinueBtn()
                .switchToTab(1);
        homePage = new HomePage(driver);
        homePage.openCreateEstimateTab()
        ;
    }

    @When("Go to the Administration Part Pricing Except. by Part Number")
    public void go_to_the_Administration_Part_Pricing_Except_by_Part_Number() {
        homePage = new HomePage(driver);
        homePage.startAssertions(HomePageAssertion.class)
                .assertAtHomePage()
                .endAssertion()
                .openAdministrationTab();
        partPricingPage = new PartPricingPage(driver);
        partPricingPage.openPartPricingTab()
                .startAssertions(PartPricingPageAssertion.class)
                .assertAtPartPricingTab()
                .endAssertion()
                .openExceptByPartNumberTab()
        ;
    }

    @Then("Except. by Part Number tab is accessible")
    public void except_by_Part_Number_tab_is_accessible() {
        partPricingPage.startAssertions(PartPricingPageAssertion.class)
                .assertIfExceptByPartNumberTabIsAccessible()
                .endAssertion()
        ;
    }

    @When("To add new part number exception click button ADD")
    public void to_add_new_part_number_exception_click_button_ADD() {
        jobsPage = new JobsPage(driver);
        jobsPage.clickOnAddBtn();
    }

    @Then("A window pop ups with the Manufacturer Parts search option.")
    public void a_window_pop_ups_with_the_Manufacturer_Parts_search_option() {
        partPage = new PartPage(driver);
        partPage.switchToTab(2)
                .startAssertions(PartPageAssertion.class)
                .assertIsAtMiscellaneousPartPage()
                .endAssertion()
        ;
    }

    @When("Search part by Part ID  {string}")
    public void search_part_by_Part_ID(String partID) {
        partPage.enterSearchCriteriaID(partID)
                .clickOnPartSearchBtn()
        ;
    }

    @Then("Rear Axle  should be visible on the list")
    public void rear_Axle_should_be_visible_on_the_list() {
        partPage.startAssertions(PartPageAssertion.class)
                .assertIfPartIsFoundAndDisplayedInTheList(1)
                .endAssertion()
        ;
    }

    @When("Click Add icon")
    public void click_Add_icon() {
        partPage.clickOnAddIcon();
    }

    @Then("Record with part is added to the list where is possible to update Cost, Selling Price")
    public void record_with_part_is_added_to_the_list_where_is_possible_to_update_Cost_Selling_Price() {
        partPricingPage = new PartPricingPage(driver);
        partPricingPage.switchToTab(1)
                .startAssertions(PartPricingPageAssertion.class)
                .assertIfCostAndSellingPriceIsEditable()
                .endAssertion()
        ;
    }

    @When("Update the Selling Price {string} to your desired values and click Save")
    public void update_the_Selling_Price_to_your_desired_values_and_click_Save(String price) {
        partPricingPage.enterSellingPrice(price)
                .clickOnSaveBtn()
        ;
    }

    @Then("Exception is created Record with values {string} is stored on Except. by Part Number list")
    public void exception_is_created_Record_with_values_is_stored_on_Except_by_Part_Number_list(String value) {
        partPricingPage.startAssertions(PartPricingPageAssertion.class)
                .assertIfRecordWithValuesIsStored(value)
                .endAssertion()
        ;
    }

    @When("Open Job details for the added job in the created estimate and check part price for {string}")
    public void open_Job_details_for_the_added_job_in_the_created_estimate_and_check_part_price_for(String string) {
        homePage = new HomePage(driver);
        homePage.openCreateEstimateTab();
    }

    @Then("Pop up window appears {string}")
    public void pop_up_window_appears(String warnMsg) {
        homePage.startAssertions(HomePageAssertion.class)
                .assertIfDataLoseWarningMessageIsShown(warnMsg)
                .endAssertion()
                .acceptAlertIfPresent(HomePage.class);
        ;
    }

    @Then("Price Ex Tax {double} and Quantity should be equal to defined exception")
    public void price_Ex_Tax_and_Quantity_should_be_equal_to_defined_exception(Double value) {
        gmCreateEstimatePage = new GMCreateEstimatePage(driver);
        gmCreateEstimatePage.clickOnLocalPriceFlagIcon(1)
                .switchToTab(2);
        partLaborDrillDownPage = new PartLaborDrillDownPage(driver);
        partLaborDrillDownPage.startAssertions(PartLaborDrillDownPageAssertion.class)
                .assertIfPartPriceForAddedJobBasedOnQuantity(value)
                .endAssertion()
                .clickOnContinueBtn()
                .switchToTab(1)
        ;
    }

    @Then("application clean up")
    public void application_clean_up() {
        homePage = new HomePage(driver);
        homePage.openAdministrationTab();
        partPricingPage = new PartPricingPage(driver);
        partPricingPage.openPartPricingTab()
                .openExceptByPartNumberTab()
                .clickOnDeleteAllBtn()
                .acceptAlertIfPresent(HomePage.class);
        partPricingPage.openExceptByCategoryTab()
        ;
    }

    @When("Upload a {string} non .CSV file")
    public void upload_a_non_CSV_file(String invalidFile) {
        super.setUp();
        homePage = functionalLibrary.gmLogIn(environment, configuration, HomePage.class);
        homePage.startAssertions(HomePageAssertion.class)
                .assertAtHomePage()
                .endAssertion()
                .openAdministrationTab();
        partPricingPage = new PartPricingPage(driver);
        partPricingPage.openPartPricingTab()
                .startAssertions(PartPricingPageAssertion.class)
                .assertAtPartPricingTab()
                .endAssertion()
                .openPartPricingUploadTab()
                .clickOnChooseFile(functionalLibrary.getAbsolutePath(invalidFile))
                .clickOnUploadBtn()
        ;
    }

    @Then("Error message displayed {string}.")
    public void error_message_displayed(String errorMsg) {
        partPricingPage.startAssertions(PartPricingPageAssertion.class)
                .assertIfInvalidFileFormatErrorMsgDisplayed(errorMsg)
                .endAssertion()
        ;
    }

    @When("Download the stock upload example")
    public void download_the_stock_upload_example() {
        partPricingPage.clickOnDownloadBtn();
    }

    @Then("{string} Downloads successfully")
    public void downloads_successfully(String fileName) {
        partPricingPage.startAssertions(PartPricingPageAssertion.class)
                .assertIfFileDownloadedSuccessfully(fileName)
                .endAssertion()
        ;
    }

    @When("Upload the stock upload example")
    public void upload_the_stock_upload_example() {
        partPricingPage.clickOnChooseFile(functionalLibrary.getAbsolutePath("StockUploadData.csv"))
                .clickOnUploadBtn()
        ;
    }

    @Then("Uploads successfully")
    public void uploads_successfully() {
        partPricingPage.startAssertions(PartPricingPageAssertion.class)
                .assertIfUploadDataSuccessfully()
                .endAssertion()
        ;
    }

    @When("Hit the Choose file button")
    public void hit_the_Choose_file_button() {
        partPricingPage.clickOnChooseFile(functionalLibrary.getAbsolutePath("StockUploadData.csv"));

    }

    @Then("The file viewer loads")
    public void the_file_viewer_loads() {
        partPricingPage.startAssertions(PartPricingPageAssertion.class)
                .assertTheFileViewerLoads()
                .endAssertion()
        ;
    }

    @When("Hit Cancel when the window pops up.")
    public void hit_Cancel_when_the_window_pops_up() {
        partPricingPage.clickOnChooseFileBtn()
                .clickOnCancelBtn()
        ;
    }

    @Then("The file viewer closes.")
    public void the_file_viewer_closes() {
        partPricingPage.startAssertions(PartPricingPageAssertion.class)
                .assertTheTheFileViewerCloses()
                .endAssertion()
        ;
    }

    @When("Upload a jlr {string} non .CSV file")
    public void upload_a_jlr_non_CSV_file(String invalidFile) {
        super.setUp();
        homePage = functionalLibrary.jlrLogIn(environment, configuration, HomePage.class);
        homePage.startAssertions(HomePageAssertion.class)
                .assertAtHomePage()
                .endAssertion()
                .openAdministrationTab();
        partPricingPage = new PartPricingPage(driver);
        partPricingPage.openStockUploadTab()
                .startAssertions(PartPricingPageAssertion.class)
                .assertAtStockUploadTab()
                .endAssertion()
                .clickOnChooseFile(functionalLibrary.getAbsolutePath(invalidFile))
                .clickOnUploadBtn()
        ;
    }

    @When("Upload the jlr stock upload example")
    public void upload_the_jlr_stock_upload_example() {
        partPricingPage.clickOnChooseFile(functionalLibrary.getAbsolutePath("JLR-Stock-Upload.csv"))
                .clickOnUploadBtn()
        ;
    }

    @Then("Stock Uploads successfully")
    public void stock_uploads_successfully() {
        partPricingPage.startAssertions(PartPricingPageAssertion.class)
                .assertIfStockUploadDataSuccessfully()
                .endAssertion()
        ;
    }

    @Then("The stock upload file viewer closes.")
    public void the_stock_upload_file_viewer_closes() {
        partPricingPage.startAssertions(PartPricingPageAssertion.class)
                .assertTheTheStockUploadFileViewerCloses()
                .endAssertion()
        ;
    }

    @Then("The stock uploaded file viewer loads")
    public void the_stock_uploaded_file_viewer_loads() {
        partPricingPage.startAssertions(PartPricingPageAssertion.class)
                .assertTheStockUploadFileViewerLoads()
                .endAssertion()
        ;
    }

    @When("Ensure Date from field can be amended {string}.")
    public void ensure_Date_from_field_can_be_amended(String date) {
        super.setUp();
        homePage = functionalLibrary.jlrLogIn(environment, configuration, HomePage.class);
        homePage.startAssertions(HomePageAssertion.class)
                .assertAtHomePage()
                .endAssertion()
                .openAdministrationTab()
                .openLostSalesTab();
        searchEstimatePage = new SearchEstimatePage(driver);
        searchEstimatePage.enterFromDate(date)
        ;
    }

    @Then("Date Field amendable {string},{int}")
    public void date_Field_amendable(String date, Integer index) {
        partPricingPage = new PartPricingPage(driver);
        partPricingPage.startAssertions(PartPricingPageAssertion.class)
                .assertIfFieldAmendable(date, index)
                .endAssertion()
        ;
    }

    @When("Ensure Date to can be amended {string}.")
    public void ensure_Date_to_can_be_amended(String date) {
        searchEstimatePage = new SearchEstimatePage(driver);
        searchEstimatePage.enterToDate(date)
        ;
    }

    @When("Dropdown the Reason menu")
    public void dropdown_the_Reason_menu(io.cucumber.datatable.DataTable searchReason) {
        partPricingPage = new PartPricingPage(driver);
        partPricingPage.startAssertions(PartPricingPageAssertion.class)
                .assertIfSearchReasonsAreAvailable(searchReason.asList())
                .endAssertion()
        ;
    }

    @When("Select Pricing, Parts Availability & Service Availability.")
    public void select_Pricing_Parts_Availability_Service_Availability() {
        partPricingPage.selectSearchReason(SearchReasons.Pricing)
                .startAssertions(PartPricingPageAssertion.class)
                .assertThatSelectedSearchReasonsAreAvailable(SearchReasons.Pricing)
                .endAssertion()
                .selectSearchReason(SearchReasons.All)
                .startAssertions(PartPricingPageAssertion.class)
                .assertThatSelectedSearchReasonsAreAvailable(SearchReasons.All)
                .endAssertion()
                .selectSearchReason(SearchReasons.ServiceAvailability)
                .startAssertions(PartPricingPageAssertion.class)
                .assertThatSelectedSearchReasonsAreAvailable(SearchReasons.ServiceAvailability)
                .endAssertion()
                .selectSearchReason(SearchReasons.PartsAvailability)
        ;
    }

    @Then("Each reason can be selected.")
    public void each_reason_can_be_selected() {
        partPricingPage.startAssertions(PartPricingPageAssertion.class)
                .assertThatSelectedSearchReasonsAreAvailable(SearchReasons.PartsAvailability)
                .endAssertion()
        ;
    }

    @When("Hit the Search button.")
    public void hit_the_Search_button() {
        searchEstimatePage = new SearchEstimatePage(driver);
        searchEstimatePage.clickOnSearchBtn()
        ;
    }

    @Then("Results depended on what has been searched will be displayed.")
    public void results_depended_on_what_has_been_searched_will_be_displayed() {
        partPricingPage.startAssertions(PartPricingPageAssertion.class)
                .assertIfSearchedLostAndSaleDataCorrect(SearchReasons.PartsAvailability)
                .endAssertion()
        ;
    }

    @When("Hit the Export button.")
    public void hit_the_Export_button() {
        partPricingPage.clickOnExportBtn();
    }

    @Then("A .CSV is downloaded")
    public void a_CSV_is_downloaded() {
        partPricingPage.startAssertions(PartPricingPageAssertion.class)
                .assertIfFileDownloadedSuccessfully("LostSalesRecord.csv")
                .endAssertion()
        ;
    }

    @When("Open the Stock upload tab.")
    public void open_the_stock_upload_tab() {
        partPricingPage.openStockUploadTab();
    }

    @Then("User is taken to the stock upload tab.")
    public void user_is_taken_to_the_stock_upload_tab() {
        partPricingPage.startAssertions(PartPricingPageAssertion.class)
                .assertAtStockUploadTab()
                .endAssertion();
    }

    @When("Navigate to the Administration Export PartAndLabour")
    public void navigate_to_the_Administration_Export_PartAndLabour() {
        super.setUp();
        homePage = functionalLibrary.jlrLogIn(environment, configuration, HomePage.class);
        homePage.startAssertions(HomePageAssertion.class)
                .assertAtHomePage()
                .endAssertion()
                .openAdministrationTab()
                .openExpPartAndLabourTab();
        expPartAndLabourPage = new ExpPartAndLabourPage(driver);
        expPartAndLabourPage.startAssertions(ExpPartAndLabourPageAssertion.class)
                .assertIfExpPartAndLabourTab()
                .endAssertion()
        ;
    }

    @When("Ensure all radio buttons are clickable and once clicked upon they fill correctly.")
    public void ensure_all_radio_buttons_are_clickable_and_once_clicked_upon_they_fill_correctly() {
        expPartAndLabourPage.clickOnRadioBtn();
        homePage = new HomePage(driver);
        homePage.clickOnSearchBtnGM();
        gmCreateEstimateCustomerPage = new GMCreateEstimateCustomerPage(driver);
        gmCreateEstimateCustomerPage.clickOnOKBtn()
        ;
    }

    @Then("All radio buttons are clickable and fill once clicked.")
    public void all_radio_buttons_are_clickable_and_fill_once_clicked() {
        expPartAndLabourPage = new ExpPartAndLabourPage(driver);
        expPartAndLabourPage.startAssertions(ExpPartAndLabourPageAssertion.class)
                .assertIfAllRadioBtnSelectedAsPerInput()
                .endAssertion()
        ;
    }

    @When("Dropdown the BlankText menu.")
    public void dropdown_the_BlankText_menu() {
        expPartAndLabourPage.startAssertions(ExpPartAndLabourPageAssertion.class)
                .assertIfDropDownFieldTextDisplayed()
                .endAssertion()
        ;
    }

    @Then("Items are displayed. {string}")
    public void items_are_displayed(String name, io.cucumber.datatable.DataTable dataTable) {
        List<String> items = dataTable.asList();
        expPartAndLabourPage.startAssertions(ExpPartAndLabourPageAssertion.class)
                .assertTheDropDownOptionItemsAreDisplayed(items, name)
                .endAssertion()
        ;
    }

    @When("Ensure your able to select an item from the dropdown.{string}")
    public void ensure_your_able_to_select_an_item_from_the_dropdown(String name) {
        expPartAndLabourPage.selectBlankTextOption(name);
        homePage = new HomePage(driver);
        homePage.clickOnSearchBtnGM();
        gmCreateEstimateCustomerPage = new GMCreateEstimateCustomerPage(driver);
        gmCreateEstimateCustomerPage.clickOnOKBtn()
        ;
    }

    @Then("Item is selectable.{string}")
    public void item_is_selectable(String name) throws IOException {
        expPartAndLabourPage = new ExpPartAndLabourPage(driver);
        expPartAndLabourPage.startAssertions(ExpPartAndLabourPageAssertion.class)
                .assertIfSelectedBlankTextOption(excel.getData(7, 1), name)
                .endAssertion()
        ;
    }

    @When("Dropdown the separator menu.")
    public void dropdown_the_separator_menu() {
        expPartAndLabourPage.startAssertions(ExpPartAndLabourPageAssertion.class)
                .assertIfDropDownSeparatorFieldDisplayed()
                .endAssertion()
        ;
    }

    @When("Ensure content is transferable from the available columns to the Selected columns using the provided arrows.")
    public void ensure_content_is_transferable_from_the_available_columns_to_the_Selected_columns_using_the_provided_arrows() throws IOException {
        List<String> columnValues1 = Arrays.asList(excel.getData(3, 3), excel.getData(4, 3));
        expPartAndLabourPage.selectedAPartContent(excel.getData(1, 3), excel.getData(2, 3))
                .selectArrowsBtn("<", 1)
                .startAssertions(ExpPartAndLabourPageAssertion.class)
                .assertIfContentTransferableFromSelectedColumnToAvailableColumn(columnValues1)
                .endAssertion()
        ;
    }

    @Then("Once content is selected it is transferred successfully to and from using the provided arrow buttons.")
    public void once_content_is_selected_it_is_transferred_successfully_to_and_from_using_the_provided_arrow_buttons() throws IOException {
        List<String> columnValues1 = Arrays.asList(excel.getData(3, 3), excel.getData(4, 3));
        List<String> columnValues2 = new ArrayList<>();
        for (int i = 3; i <= 8; i++) {
            columnValues2.add(excel.getData(i, 3));
        }
        expPartAndLabourPage.selectArrowsBtn("<<", 1)
                .startAssertions(ExpPartAndLabourPageAssertion.class)
                .assertIfContentTransferableFromSelectedColumnToAvailableColumn(columnValues2)
                .endAssertion()
                .availableAPartContent(excel.getData(1, 3), excel.getData(2, 3))
                .selectArrowsBtn(">", 1)
                .startAssertions(ExpPartAndLabourPageAssertion.class)
                .assertIfContentTransferableFromAvailableColumnToSelectedColumn(columnValues1)
                .endAssertion()
                .selectArrowsBtn(">>", 1)
                .startAssertions(ExpPartAndLabourPageAssertion.class)
                .assertIfContentTransferableFromAvailableColumnToSelectedColumn(columnValues2)
                .endAssertion()
        ;
    }

    @When("Hit the Save Changes button")
    public void hit_the_Save_Changes_button() {
        homePage = new HomePage(driver);
        homePage.clickOnSearchBtnGM();
        gmCreateEstimateCustomerPage = new GMCreateEstimateCustomerPage(driver);
        gmCreateEstimateCustomerPage.clickOnOKBtn()
        ;
    }

    @Then("Settings are saved.")
    public void settings_are_saved() throws IOException {
        List<String> columnValues2 = new ArrayList<>();
        for (int i = 3; i <= 8; i++) {
            columnValues2.add(excel.getData(i, 3));
        }
        expPartAndLabourPage = new ExpPartAndLabourPage(driver);
        expPartAndLabourPage.startAssertions(ExpPartAndLabourPageAssertion.class)
                .assertIfContentTransferableFromAvailableColumnToSelectedColumn(columnValues2)
                .endAssertion()
        ;
    }

    @When("Create a new quote, add a job. Open the job details and click on the Export button.")
    public void create_a_new_quote_add_a_job_Open_the_job_details_and_click_on_the_Export_button() throws IOException {
        homePage = new HomePage(driver);
        homePage.openCreateEstimateTab()
                .inputRegistrationNo(excel.getData(7, 0))
                .searchBtn();
        gmCreateEstimatePage = new GMCreateEstimatePage(driver);
        gmCreateEstimatePage.expandJobTreeInnerRow(1)
                .expandJobTreeSubInnerRow(1)
                .clickOnLabour15KAnd24K()
        ;
    }

    @Then("Export file is produced with the selected options. {string}")
    public void export_file_is_produced_with_the_selected_options(String description) {
        gmCreateEstimatePage.startAssertions(GMCreateEstimatePageAssertion.class)
                .assertIfTheMileageNormalLaborOnly15000MilesAnd24000KMJobIsAddedToTheEstimate(description)
                .endAssertion()
        ;
    }

    @When("Navigate to the Administration and Ex.PartAndLabour")
    public void navigate_to_the_Administration_and_Ex_PartAndLabour() {
        super.setUp();
        homePage = functionalLibrary.jlrLogIn(environment, configuration, HomePage.class);
        homePage.startAssertions(HomePageAssertion.class)
                .assertAtHomePage()
                .endAssertion()
                .openAdministrationTab()
                .openExpPartAndLabourTab();
    }

    @Then("Validate {string} got selected in FileFormat")
    public void validate_got_selected_in_FileFormat(String format) {
        expPartAndLabourPage = new ExpPartAndLabourPage(driver);
        expPartAndLabourPage.startAssertions(ExpPartAndLabourPageAssertion.class)
                .assertFileFormatSelected(format)
                .endAssertion();
    }

    @Then("Create a quote for Registration Number {string}")
    public void create_a_quote_for_Registration_Number(String regNo){
        homePage.startAssertions(HomePageAssertion.class)
                .assertAtHomePage()
                .endAssertion()
                .createQuote()
                .inputRegistrationNo(regNo)
                .searchBtn();
        gmCreateEstimatePage = new GMCreateEstimatePage(driver);
        gmCreateEstimatePage.expandJobTreeInnerRow(1)
                .expandJobTreeSubInnerRow(1)
                .clickOnLabour15KAnd24K()
                .clickOnContinueBtn();
    }

    @When("User clicks on continue button")
    public void user_clicks_on_continue_button() {
        gmCreateEstimatePage.clickOnContinueBtn();
    }

    @Then("User clicks on Export All button")
    public void user_clicks_on_Export_All_button() {
        gmCreateEstimatePage.clickOnExportAll();
    }

    @Then("User clicks on Save button")
    public void user_clicks_on_Save_button() {
        gmCreateEstimatePage.clickOnSave();
    }

    @Then("User clicks on Print button")
    public void user_clicks_on_Print_button() {
        gmCreateEstimatePage.clickOnPrint();
        gmCreateEstimatePage.startAssertions(GMCreateEstimatePageAssertion.class)
                .assertIfPrintOptionDisplayed()
                .endAssertion();
    }

    @Then("User clicks on Detailed button")
    public void user_clicks_on_Detailed_button() {
        gmCreateEstimatePage.clickOnDetailed();
    }

    @Then("User clicks on Summary button")
    public void user_clicks_on_Summary_button() {
        gmCreateEstimatePage.clickOnSummary();
    }

    @Then("User clicks on Back button and verify navigated to previous page")
    public void user_clicks_on_Back_button_and_verify_navigated_to_previous_page() {
        gmCreateEstimatePage.clickOnBack();
        gmCreateEstimatePage.startAssertions(GMCreateEstimatePageAssertion.class)
                .assertIfTotalPriceElementDisplayed()
                .endAssertion();
    }

    @Then("User clicks on Email button and navigated to {string}")
    public void user_clicks_on_Email_button_and_navigated_to(String title) {
        gmCreateEstimatePage.clickOnEmail();
        homePage.switchToSpecificWindow(title);
    }

    @Then("Verify {string} Quote type got displayed")
    public void verify_Quote_type_got_displayed(String string) {
        gmCreateEstimatePage.startAssertions(GMCreateEstimatePageAssertion.class)
                .assertIfExpectedQuoteTypeDisplayed(string)
                .endAssertion();
    }

    @Then("Verify send and cancel button got displayed")
    public void verify_send_and_cancel_button_got_displayed() {
        gmCreateEstimatePage.startAssertions(GMCreateEstimatePageAssertion.class)
                .assertIfSendButtonDisplayed()
                .assertIfCancelButtonDisplayed()
                .endAssertion();
    }

    @Then("Verify warning message after a copy of quote sent to customer")
    public void verify_warning_message_after_a_copy_of_quote_sent_to_customer() {
        gmCreateEstimatePage.clickSendButtonWarning();
        homePage.switchToSpecificWindow("JLR Menu Pricing");
        gmCreateEstimatePage.startAssertions(GMCreateEstimatePageAssertion.class)
                .assertIfWarningDialogDisplayed()
                .endAssertion();
        gmCreateEstimatePage.clickOKButtoninDialog();
        gmCreateEstimatePage.startAssertions(GMCreateEstimatePageAssertion.class)
                .assertIfWarningDialognotDisplayed()
                .endAssertion();
    }

    @Then("Verify file is getting downloaded in {string} format")
    public void verify_file_is_getting_downloaded_in_format(String fileFormat) throws IOException {
        gmCreateEstimatePage.startAssertions(GMCreateEstimatePageAssertion.class)
                .assertIfExcelFileDownloaded("Export"+new SimpleDateFormat("yyMMdd").format(new Date()), fileFormat)
                .endAssertion();
        functionalLibrary.deleteFile(excel.readExcel("downloadedFileName", "Sheet1", 0, 0));

    }

    @Then("Verify file is getting downloaded")
    public void verify_file_is_getting_downloaded() throws IOException {
        gmCreateEstimatePage.startAssertions(GMCreateEstimatePageAssertion.class)
                .assertIfFileDownloaded().endAssertion();
        functionalLibrary.deleteFile(excel.readExcel("downloadedFileName", "Sheet1", 0, 0));

    }

    @After
    public void close() {
        super.close();
    }

}