package GM.gmStepDefinitions.CreateEstimate;

import GM.gmAssertion.*;
import GM.gmAssertion.administration.BulkFluidsPageAssertion;
import GM.gmAssertion.administration.CommonJobsPageAssertion;
import GM.gmAssertion.administration.SystemSettingsPageAssertion;
import GM.gmAssertion.miscellaneous.JobsPageAssertion;
import GM.gmAssertion.miscellaneous.LaborPageAssertion;
import GM.gmAssertion.miscellaneous.PartPageAssertion;
import GM.gmObjectRepository.*;
import GM.gmObjectRepository.administration.BulkFluidsPage;
import GM.gmObjectRepository.administration.CommonJobsPage;
import GM.gmObjectRepository.administration.SystemSettingsPage;
import GM.gmObjectRepository.maintainEstimates.SearchEstimatePage;
import GM.gmObjectRepository.miscellaneous.JobsPage;
import GM.gmObjectRepository.miscellaneous.LaborPage;
import GM.gmObjectRepository.miscellaneous.PartPage;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import model.CustomerType;
import model.JobFormList;
import model.LaborPriceTypes;
import stepDefinitions.AbstractTest;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class EstimateTest extends AbstractTest {

    @When("Start a new quote with VIN {string}. SEARCH button continue to the Estimate tab.")
    public void start_a_new_quote_with_VIN_SEARCH_button_continue_to_the_Estimate_tab(String vinNo) {
        super.setUp();
        homePage = functionalLibrary.gmLogIn(environment, configuration, HomePage.class);
        homePage.startAssertions(HomePageAssertion.class)
                .assertAtHomePage()
                .endAssertion()
                .openAdministrationTab();
        systemSettingsPage = new SystemSettingsPage(driver);
        systemSettingsPage.openSystemSettingsTab()
                .startAssertions(SystemSettingsPageAssertion.class)
                .assertIfSystemSettingsTab()
                .endAssertion()
                .selectLaborPricingTypes(LaborPriceTypes.SingleLaborRate)
                .clickOnSaveBtn();
        systemSettingsPage.startAssertions(SystemSettingsPageAssertion.class)
                .assertIfLaborPricingTypeIsSelectedAsExpected("Single Labor Rate")
                .endAssertion();
        homePage = new HomePage(driver);
        homePage.openCreateEstimateTab()
                .inputVIN(vinNo)
                .searchBtn()
        ;
    }

    @When("Click on the + link of the Servicing job in the Job Tree.")
    public void click_on_the_link_of_the_Servicing_job_in_the_Job_Tree() {
        gmCreateEstimatePage = new GMCreateEstimatePage(driver);
        gmCreateEstimatePage.startAssertions(GMCreateEstimatePageAssertion.class)
                .assertAtEstimateTab()
                .endAssertion()
                .expandJobTreeInnerRow(2)
                .expandJobTreeSubInnerRow(7)
        ;
    }

    @Then("The Tree is Expanded.")
    public void the_Tree_is_Expanded() {
        gmCreateEstimatePage.startAssertions(GMCreateEstimatePageAssertion.class)
                .assertIfTheTreeIsExpanded()
                .endAssertion()
        ;
    }

    @When("Click on the - link of the Serving job in the Job Tree.")
    public void click_on_the_link_of_the_Serving_job_in_the_Job_Tree() {
        gmCreateEstimatePage.expandJobTreeSubInnerRow(7)
        ;
    }

    @Then("The tree is minimized.")
    public void the_tree_is_minimized() {
        gmCreateEstimatePage.startAssertions(GMCreateEstimatePageAssertion.class)
                .assertIfTheTreeIsMinimized()
                .endAssertion()
        ;
    }

    @When("Click on the plus link of the Scheduled Maintenance job in the Job Tree and click on Job Mileage Normal and Labor Only $15000 miles and $24000km")
    public void click_on_the_plus_link_of_the_Scheduled_Maintenance_job_in_the_Job_Tree_and_click_on_Job_Mileage_Normal_and_Labor_Only_$15000_miles_and_$24000km() {
        gmCreateEstimatePage = new GMCreateEstimatePage(driver);
        gmCreateEstimatePage.expandJobTreeInnerRow(1)
                .expandJobTreeSubInnerRow(1)
                .clickOnLabour15KAnd24K()
        ;
    }

    @Then("The {string} job is added to the Estimate.")
    public void the_job_is_added_to_the_Estimate(String description) {
        gmCreateEstimatePage.startAssertions(GMCreateEstimatePageAssertion.class)
                .assertIfTheMileageNormalLaborOnly15000MilesAnd24000KMJobIsAddedToTheEstimate(description)
                .endAssertion()
        ;
    }

    @When("Click on the job tree Mileage Normal Labor Only $15000 miles and $24000km job again.")
    public void click_on_the_job_tree_Mileage_Normal_Labor_Only_$15000_miles_and_$24000km_job_again() {
        gmCreateEstimatePage.clickOnLabour15KAnd24K();
    }

    @Then("Message is shown to user:{string}")
    public void message_is_shown_to_user(String warnMsg) {
//        gmCreateEstimatePage.startAssertions(GMCreateEstimatePageAssertion.class)
//                .assertIfWarningMsgDisplayed(warnMsg)
//                .endAssertion()
        gmCreateEstimatePage.clickOnDeleteIcon(1)
        ;
    }

    @When("Click the Add Miscellaneous Job button.")
    public void click_the_Add_Miscellaneous_Job_button() {
        gmCreateEstimatePage.clickOnAddMiscellaneousJobButton()
        ;
    }

    @Then("The Miscellaneous Jobs window opens.Tax rate is the Markets default {string} for US")
    public void the_Miscellaneous_Jobs_window_opens_Tax_rate_is_the_Markets_default_for_US(String defaultPercentage) {
        jobsPage = new JobsPage(driver);
        jobsPage.switchToTab(2)
                .startAssertions(JobsPageAssertion.class)
                .assertIsAtMiscellaneousJobsPage()
                .assertIfTaxRateIsTheMarketsDefaultZero(defaultPercentage)
                .endAssertion()
        ;
    }

    @When("Click on the Add button within the Misc Job window without entering any details.")
    public void click_on_the_Add_button_within_the_Misc_Job_window_without_entering_any_details() {
        jobsPage.clickOnAddBtn();
    }

    @Then("A message is shown: {string}")
    public void a_message_is_shown(String errorMsg) {
        jobsPage.startAssertions(JobsPageAssertion.class)
                .assertIfMiscAddJobErrorMsgDisplayed(errorMsg)
                .endAssertion()
        ;
    }

    @When("Ensure the Ad Hoc job is selected and type text into the Description box {string}, enter cost price {string} and Price Excl. Tax {string}, select tax rate as {string}. Click Add.")
    public void ensure_the_Ad_Hoc_job_is_selected_and_type_text_into_the_Description_box_enter_cost_price_and_Price_Excl_Tax_select_tax_rate_as_Click_Add(String description, String cost, String price, String tax) {
        jobsPage.selectJobFormDropDownOption(JobFormList.AdHoc)
                .inputDescription(description)
                .inputCost(cost)
                .inputPrice(price)
                .selectTaxRate(tax)
                .clickOnAddBtn()
        ;
    }

    @Then("The {string} is added to the quote and the price Incl. Tax is {string}. Quantity is {string}")
    public void the_is_added_to_the_quote_and_the_price_Incl_Tax_is_Quantity_is(String description, String priceTax, String quantity) {
//        List<String> expectedResult = Arrays.asList(quantity, description, priceTax, priceTax);
        List<String> expectedResult = Arrays.asList(quantity, description, priceTax);//priceTax
        gmCreateEstimatePage = new GMCreateEstimatePage(driver);
        gmCreateEstimatePage.switchToTab(1)
                .startAssertions(GMCreateEstimatePageAssertion.class)
                .assertIfQuantityDescriptionAndPriceAddedNewToQuote(expectedResult, 2)
                .endAssertion()
                .clickOnDeleteIcon(1)
        ;
    }

    @When("Open the Add Misc Job window and click on the Cancel button.")
    public void open_the_Add_Misc_Job_window_and_click_on_the_Cancel_button() {
        gmCreateEstimatePage.clickOnAddMiscellaneousJobButton();
        jobsPage = new JobsPage(driver);
        jobsPage.switchToTab(2)
                .startAssertions(JobsPageAssertion.class)
                .assertIsAtMiscellaneousJobsPage()
                .endAssertion()
                .clickOnCancelBtn()
        ;
    }

    @Then("The window is closed and nothing is added to the quote.")
    public void the_window_is_closed_and_nothing_is_added_to_the_quote() {
        gmCreateEstimatePage = new GMCreateEstimatePage(driver);
        gmCreateEstimatePage.switchToTab(1)
                .startAssertions(GMCreateEstimatePageAssertion.class)
                .assertAtEstimateTab()
                .endAssertion()
        ;
    }

    @When("Open the Job window and select a job from the drop down list \\(there must be custom jobs set up in Admin). Click the Add button.")
    public void open_the_Job_window_and_select_a_job_from_the_drop_down_list_there_must_be_custom_jobs_set_up_in_Admin_Click_the_Add_button() {
        gmCreateEstimatePage.clickOnAddMiscellaneousJobButton();
        jobsPage = new JobsPage(driver);
        jobsPage.switchToTab(2);
        jobsPage.selectJobFormDropDownOption(JobFormList.Data)
                .clickOnAddBtn()
        ;
    }

    @Then("The selected job is added to the Estimate.")
    public void the_selected_job_is_added_to_the_Estimate(io.cucumber.datatable.DataTable data) {
        List<String> expectedAddedQuote = data.asList();
        gmCreateEstimatePage = new GMCreateEstimatePage(driver);
        gmCreateEstimatePage.switchToTab(1)
                .startAssertions(GMCreateEstimatePageAssertion.class)
                .assertIfQuantityDescriptionAndPriceAddedNewToQuote(expectedAddedQuote, 2)
                .endAssertion()
                .clickOnDeleteIcon(1)
        ;
    }

    @When("Click on the Labor button.")
    public void click_on_the_Labor_button() {
        gmCreateEstimatePage.clickOnLaborMiscellaneousButton();
    }

    @Then("The Miscellaneous Labour window opens.")
    public void the_Miscellaneous_Labour_window_opens() {
        laborPage = new LaborPage(driver);
        laborPage.startAssertions(LaborPageAssertion.class)
                .assertIsAtMiscellaneousLaborPage()
                .endAssertion()
        ;
    }

    @When("Click on the Add button within the Labour window without entering any details.")
    public void click_on_the_Add_button_within_the_Labour_window_without_entering_any_details() {
        jobsPage = new JobsPage(driver);
        jobsPage.switchToTab(2);
        jobsPage.clickOnAddBtn();
    }

    @When("Enter a DTU value {string} and a description {string}. Click the Add button.")
    public void enter_a_DTU_value_and_a_description_Click_the_Add_button(String laborUnit, String description) {
        laborPage = new LaborPage(driver);
        laborPage.enterLaborUnit(laborUnit);
        jobsPage = new JobsPage(driver);
        jobsPage.inputDescription(description)
                .clickOnAddBtn()
        ;
    }

    @Then("The Misc Labour item is added to the Estimate.")
    public void the_Misc_Labour_item_is_added_to_the_Estimate(io.cucumber.datatable.DataTable data) {
        List<String> expectedAddedQuote = data.asList();
        gmCreateEstimatePage = new GMCreateEstimatePage(driver);
        gmCreateEstimatePage.switchToTab(1)
                .startAssertions(GMCreateEstimatePageAssertion.class)
                .assertIfQuantityDescriptionAndPriceAddedNewToQuote(expectedAddedQuote, 2)
                .endAssertion()
                .clickOnDeleteIcon(1)
        ;
    }

    @When("Open the Add Labour window and click on the Cancel button.")
    public void open_the_Add_Labour_window_and_click_on_the_Cancel_button() {
        gmCreateEstimatePage.clickOnLaborMiscellaneousButton();
        laborPage = new LaborPage(driver);
        laborPage.switchToTab(2)
                .startAssertions(LaborPageAssertion.class)
                .assertIsAtMiscellaneousLaborPage()
                .endAssertion();
        jobsPage = new JobsPage(driver);
        jobsPage.clickOnCancelBtn()
        ;
    }

    @When("Click on the Part button.")
    public void click_on_the_Part_button() {
        gmCreateEstimatePage.clickOnPartMiscellaneousButton();
    }

    @Then("The Miscellaneous Parts window opens.")
    public void the_Miscellaneous_Parts_window_opens() {
        partPage = new PartPage(driver);
        partPage.switchToTab(2)
                .startAssertions(PartPageAssertion.class)
                .assertIsAtMiscellaneousPartPage()
                .endAssertion()
        ;
    }

    @When("Click on the Add button within the Misc Part window without entering any details.")
    public void click_on_the_Add_button_within_the_Misc_Part_window_without_entering_any_details() {
        jobsPage = new JobsPage(driver);
        jobsPage.clickOnAddBtn()
        ;
    }

    @When("Ensure the Ad Hoc part is selected, enter the desired Quantity, type a Part number, Description, cost and enter the Price Excl. Tax, Click the Add button.")
    public void ensure_the_Ad_Hoc_part_is_selected_enter_the_desired_Quantity_type_a_Part_number_Description_cost_and_enter_the_Price_Excl_Tax_Click_the_Add_button(io.cucumber.datatable.DataTable data) {
        List<String> list = data.asList();
        jobsPage.selectJobFormDropDownOption(JobFormList.AdHoc);
        partPage = new PartPage(driver);
        partPage.enterPartQuantity(list.get(0))
                .enterPartNumber(list.get(1))
                .enterPartDescription(list.get(2));
        jobsPage = new JobsPage(driver);
        jobsPage.inputCost(list.get(3))
                .inputPrice(list.get(4))
                .clickOnAddBtn()
        ;
    }

    @Then("The Misc Part is added to the quote.")
    public void the_Misc_Part_is_added_to_the_quote(io.cucumber.datatable.DataTable data) {
        List<String> expectedAddedQuote = data.asList();
        gmCreateEstimatePage = new GMCreateEstimatePage(driver);
        gmCreateEstimatePage.switchToTab(1)
                .startAssertions(GMCreateEstimatePageAssertion.class)
                .assertIfQuantityDescriptionAndPriceAddedNewToQuote(expectedAddedQuote, 2)
                .endAssertion()
                .clickOnDeleteIcon(1)
        ;
    }

    @When("Open the Part window and select Manufacturer Parts from the drop down list.")
    public void open_the_Part_window_and_select_Manufacturer_Parts_from_the_drop_down_list() {
        gmCreateEstimatePage = new GMCreateEstimatePage(driver);
        gmCreateEstimatePage.switchToTab(1);
        gmCreateEstimatePage.clickOnPartMiscellaneousButton();
        partPage = new PartPage(driver);
        partPage.switchToTab(2)
                .startAssertions(PartPageAssertion.class)
                .assertIsAtMiscellaneousPartPage()
                .endAssertion();
        jobsPage = new JobsPage(driver);
        jobsPage.selectJobFormDropDownOption(JobFormList.ManufacturerParts)
        ;
    }

    @Then("The window changes to the Manufacturer Parts search.")
    public void the_window_changes_to_the_Manufacturer_Parts_search() {
        partPage.startAssertions(PartPageAssertion.class)
                .assertAtManufacturerPartsSearchPage()
                .endAssertion()
        ;
    }

    @When("Click on the Back button.")
    public void click_on_the_Back_button() {
        partPage = new PartPage(driver);
        partPage.clickOnBackBtn();
    }

    @Then("The window changes back to the Parts screen")
    public void the_window_changes_back_to_the_Parts_screen() {
        partPage = new PartPage(driver);
        partPage.startAssertions(PartPageAssertion.class)
                .assertIsAtMiscellaneousPartPage()
                .endAssertion();
        jobsPage = new JobsPage(driver);
        jobsPage.clickOnCancelBtn();
    }

    @When("Search for a Part ID {string}.")
    public void search_for_a_Part_ID(String id) {
        partPage = new PartPage(driver);
        partPage.enterSearchCriteriaID(id)
                .clickOnPartSearchBtn()
        ;
    }

    @Then("The part is found and displayed in the list.")
    public void the_part_is_found_and_displayed_in_the_list() {
        partPage.startAssertions(PartPageAssertion.class)
                .assertIfPartIsFoundAndDisplayedInTheList(1)
                .endAssertion()
        ;
    }

    @When("Click on the Add icon.")
    public void click_on_the_Add_icon() {
        partPage.clickOnAddIcon()
        ;
    }

    @Then("The window changes back to the Misc part screen with the selected parts details populated.")
    public void the_window_changes_back_to_the_Misc_part_screen_with_the_selected_parts_details_populated() {
        partPage.startAssertions(PartPageAssertion.class)
                .assertIsAtMiscellaneousPartPage()
                .assertIfSelectedPartsDetailsPopulatedWithData()
                .endAssertion()
        ;
    }

    @When("Click Add button.")
    public void click_Add_button() {
        jobsPage = new JobsPage(driver);
        jobsPage.clickOnAddBtn();
    }

    @Then("Part is added to the quote.")
    public void part_is_added_to_the_quote(io.cucumber.datatable.DataTable data) {
        List<String> expectedAddedQuote = data.asList();
        gmCreateEstimatePage = new GMCreateEstimatePage(driver);
        gmCreateEstimatePage.switchToTab(1)
                .startAssertions(GMCreateEstimatePageAssertion.class)
                .assertIfQuantityDescriptionAndPriceAddedNewToQuote(expectedAddedQuote, 2)
                .endAssertion()
                .clickOnDeleteIcon(1)
        ;
    }

    @When("Open the window again, this time search for a Part description.{string}")
    public void open_the_window_again_this_time_search_for_a_Part_description(String partDescription) {
        gmCreateEstimatePage.clickOnPartMiscellaneousButton();
        jobsPage = new JobsPage(driver);
        jobsPage.switchToTab(2);
        jobsPage.selectJobFormDropDownOption(JobFormList.ManufacturerParts);
        partPage = new PartPage(driver);
        partPage.startAssertions(PartPageAssertion.class)
                .assertAtManufacturerPartsSearchPage()
                .endAssertion()
                .clickOnPartRadioBtn()
                .enterSearchCriteriaID(partDescription)
                .clickOnPartSearchBtn()
        ;
    }

    @Then("Window opens, a part description is successfully searched for.")
    public void window_opens_a_part_description_is_successfully_searched_for() {
        partPage = new PartPage(driver);
        partPage.startAssertions(PartPageAssertion.class)
                .assertIfPartIsFoundAndDisplayedInTheList(3)
                .endAssertion()
        ;
    }

    @When("Click on the Add icon of a part. Update quantity to {string} and click Add button")
    public void click_on_the_Add_icon_of_a_part_Update_quantity_to_and_click_Add_button(String quantity) {
        partPage.clickOnAddIcon()
                .enterPartQuantity(quantity);
        jobsPage = new JobsPage(driver);
        jobsPage.clickOnAddBtn()
        ;
    }

    @Then("The user is able select and update the QTY then allowed to add to the estimate. Part is added to the estimate. Quantity = $2 is visible for this part.")
    public void the_user_is_able_select_and_update_the_QTY_then_allowed_to_add_to_the_estimate_Part_is_added_to_the_estimate_Quantity_$2_is_visible_for_this_part(io.cucumber.datatable.DataTable data) {
        List<String> expectedResult = data.asList();
        gmCreateEstimatePage = new GMCreateEstimatePage(driver);
        gmCreateEstimatePage.switchToTab(1)
                .startAssertions(GMCreateEstimatePageAssertion.class)
                .assertIfQuantityDescriptionAndPriceAddedNewToQuote(expectedResult, 2)
                .endAssertion()
                .clickOnDeleteIcon(1)
        ;
    }

    @When("Create Estimate and Add some jobs to a Estimate")
    public void create_Estimate_and_Add_some_jobs_to_a_Estimate() {
        gmCreateEstimatePage.expandJobTreeSubInnerRow(7)
                .clickOnRemoveAndReplace()
        ;
    }

    @Then("Estimate is created with jobs.")
    public void estimate_is_created_with_jobs(io.cucumber.datatable.DataTable data) {
        List<String> expectedResult = data.asList();
        gmCreateEstimatePage.startAssertions(GMCreateEstimatePageAssertion.class)
                .assertIfQuantityDescriptionAndPriceAddedToGMQuote(expectedResult, 2)
                .endAssertion()
                .clickOnDeleteIcon(1)
        ;
    }

    @When("Change the customer type by selecting a new customer from the Customer Type drop down list")
    public void change_the_customer_type_by_selecting_a_new_customer_from_the_Customer_Type_drop_down_list() {
        gmCreateEstimatePage.selectCustomerType(CustomerType.New);
    }

    @Then("The quotes price is changed in accordance to the customer types settings.{string}")
    public void the_quotes_price_is_changed_in_accordance_to_the_customer_types_settings(String changedPrice) {
        gmCreateEstimatePage.startAssertions(GMCreateEstimatePageAssertion.class)
                .assertIfQuotesPriceIsChangedInAccordanceToTheCustomerTypesSettings(changedPrice)
                .endAssertion()
                .selectCustomerType(CustomerType.Retail);
        ;
    }

    @When("Add a job with parts and labour to a estimate. Click on the Magnifying Glass icon to open the Parts and Labour details.")
    public void add_a_job_with_parts_and_labour_to_a_estimate_Click_on_the_Magnifying_Glass_icon_to_open_the_Parts_and_Labour_details() {
        gmCreateEstimatePage.expandJobTreeInnerRow(12)
                .expandJobTreeSubInnerRow(39)
                .expandJobTreeLevelThreeInnerRowBasedOnEnv(environment, 52, 53)
                .clickOnRemoveAndReplaceCoilSpringBothSides()
                .clickOnMagnifyingGlassIcon(1);
        partLaborDrillDownPage = new PartLaborDrillDownPage(driver);
        partLaborDrillDownPage.switchToTab(2)
                .startAssertions(PartLaborDrillDownPageAssertion.class)
                .assertIfPartsAndLabourDetailsOpened()
                .endAssertion()
        ;
    }

    @Then("Parts and Labour items are shown along with their price EX VAT.")
    public void parts_and_Labour_items_are_shown_along_with_their_price_EX_VAT(io.cucumber.datatable.DataTable data) {
        List<String> partDescription = null;
        List<String> partPrice = null;
        List<String> laborDescription = null;
        List<String> laborPrice = null;
        List<String> list = data.asList();
//
//        partDescription = Arrays.asList(list.get(0), list.get(1), list.get(2));
//        partPrice = Arrays.asList(list.get(3), list.get(4), list.get(5));
//        laborDescription = Arrays.asList(list.get(6));
//        laborPrice = Arrays.asList(list.get(7));
//=======
//        if (environment.contains("qa")) {
            partDescription = Arrays.asList(list.get(0), list.get(1), list.get(2));
            partPrice = Arrays.asList(list.get(3), list.get(4), list.get(5));
            laborDescription = Arrays.asList(list.get(6));
            laborPrice = Arrays.asList(list.get(7));
//        } else if (environment.contains("uat")) {
//            partDescription = Arrays.asList(list.get(9), list.get(10), list.get(10));
//            partPrice = Arrays.asList(list.get(3), list.get(4), list.get(5));
//            laborDescription = Arrays.asList(list.get(6));
//            laborPrice = Arrays.asList(list.get(7));
//        }
        List<List<String>> partDescriptionAndPrice = Arrays.asList(partDescription, partPrice);
        List<List<String>> laborDescriptionAndPrice = Arrays.asList(laborDescription, laborPrice);
        partLaborDrillDownPage = new PartLaborDrillDownPage(driver);
        partLaborDrillDownPage.startAssertions(PartLaborDrillDownPageAssertion.class)
                .assertIfPartsAndLabourItemsAreShownAlongWithTheirPrice(partDescriptionAndPrice, laborDescriptionAndPrice)
                .endAssertion()
        ;
    }

    @When("Click on the ADD LABOR button, search for a new labour code {string} Specify labor Time to {string} mins and add it to the job by clicking Add icon.")
    public void click_on_the_ADD_LABOR_button_search_for_a_new_labour_code_Specify_labor_Time_to_mins_and_add_it_to_the_job_by_clicking_Add_icon(String laborCode, String laborTime) {
        partLaborDrillDownPage.clickOnAddLaborBtn()
                .selectRadioBtn(1)
                .enterSearchCriteria(laborCode)
                .clickOnSearchBtn()
                .enterLaborTime(laborTime)
                .clickOnAddIcon(1)
        ;
    }

    @Then("The new labour code is added to the job, showing the price EX VAT.")
    public void the_new_labour_code_is_added_to_the_job_showing_the_price_EX_VAT(io.cucumber.datatable.DataTable data) {
        List<String> addedLaborCode = data.asList();
        partLaborDrillDownPage.startAssertions(PartLaborDrillDownPageAssertion.class)
                .assertIfNewLabourCodeIsAddedToTheJobShowingWithThePrice(addedLaborCode)
                .endAssertion()
        ;
    }

    @When("Click the CONTINUE button.")
    public void click_the_CONTINUE_button() {
        partLaborDrillDownPage.clickOnContinueBtn();
    }

    @Then("The jobs total price is re-calculated with the new labour time")
    public void the_jobs_total_price_is_re_calculated_with_the_new_labour_time() {
        gmCreateEstimatePage = new GMCreateEstimatePage(driver);
        gmCreateEstimatePage.switchToTab(1)
                .startAssertions(GMCreateEstimatePageAssertion.class)
                .assertIfTheJobsTotalPriceIsRecalculatedWithTheNewLabourTime(268.5f)
                .endAssertion()
        ;
    }

    @When("Click on the Delete icon next to a job in a estimate.")
    public void click_on_the_Delete_icon_next_to_a_job_in_a_estimate() {
        gmCreateEstimatePage.clickOnDeleteIcon(1);
    }

    @Then("The job is removed from the estimate and the estimate price is adjusted correctly.")
    public void the_job_is_removed_from_the_estimate_and_the_estimate_price_is_adjusted_correctly() {
        gmCreateEstimatePage.startAssertions(GMCreateEstimatePageAssertion.class)
                .assertIfJobIsRemovedFromTheEstimateAndTheEstimatePriceIsAdjustedCorrectly("Rear Suspension Remove & Replace Coil Spring - Both Sides", "$26.00")
                .endAssertion()
        ;
    }

    @When("Add some jobs to a estimate and click on the Deal Price icon.")
    public void add_some_jobs_to_a_estimate_and_click_on_the_Deal_Price_icon(io.cucumber.datatable.DataTable data) {
        List<String> expectedResult = data.asList();
        gmCreateEstimatePage.clickOnRemoveAndReplace()
                .clickOnRemoveAndReplace()
                .startAssertions(GMCreateEstimatePageAssertion.class)
                .assertIfQuantityDescriptionAndPriceAddedToGMQuote(expectedResult, 2)
                .endAssertion()
                .clickOnDealPriceIcon()
        ;
    }

    @Then("Set Deal Price window opens.")
    public void set_Deal_Price_window_opens() {
        DealPriceIconPage dealPriceIconPage = new DealPriceIconPage(driver);
        dealPriceIconPage.switchToTab(2)
                .startAssertions(DealPriceIconPageAssertion.class)
                .assertIfSetDealPriceWindowOpened()
                .endAssertion()
        ;
    }

    @When("Click on the Cancel button")
    public void click_on_the_Cancel_button() {
        jobsPage = new JobsPage(driver);
        jobsPage.clickOnCancelBtn()
        ;
    }

    @Then("Deal price window closes with no change to the quote price.")
    public void deal_price_window_closes_with_no_change_to_the_quote_price() {
        gmCreateEstimatePage = new GMCreateEstimatePage(driver);
        gmCreateEstimatePage.switchToTab(1)
                .startAssertions(GMCreateEstimatePageAssertion.class)
                .assertAtEstimateTab()
                .assertIfNoChangeToTheQuotePrice(68.54f)
                .endAssertion()
                .clickOnDeleteIcon(1)
        ;
    }

    @When("Change the description {string}")
    public void change_the_description(String description) {
        dealPriceIconPage = new DealPriceIconPage(driver);
        dealPriceIconPage.renameDiscountDescription(description);
    }

    @Then("Description can be changed.")
    public void description_can_be_changed() {
        dealPriceIconPage.startAssertions(DealPriceIconPageAssertion.class)
                .assertIfDescriptionChanged()
                .endAssertion()
        ;
    }

    @When("Enter a discount percentage to Deal Price Discount {string}")
    public void enter_a_discount_percentage_to_Deal_Price_Discount(String price) {
        dealPriceIconPage.enterDealPrice(price);
    }

    @Then("Field accepts numbers.")
    public void field_accepts_numbers() {
        dealPriceIconPage.startAssertions(DealPriceIconPageAssertion.class)
                .assertIfFieldAcceptsNumbers()
                .endAssertion()
        ;
    }

    @When("Click OK.")
    public void click_OK() {
        dealPriceIconPage.clickOnOkBtn();
    }

    @Then("The price is accepted and reflected on the quote")
    public void the_price_is_accepted_and_reflected_on_the_quote(io.cucumber.datatable.DataTable data) {
        List<String> expectedAddedQuote = data.asList();
        gmCreateEstimatePage = new GMCreateEstimatePage(driver);
        gmCreateEstimatePage.switchToTab(1)
                .startAssertions(GMCreateEstimatePageAssertion.class)
                .assertIfQuantityDescriptionAndPriceAddedToQuote(expectedAddedQuote, 3)
                .endAssertion()
                .clickOnDeleteIcon(1)
                .clickOnDeleteIcon(1)
        ;
    }

    @When("Enter a Deal Price for the discount.")
    public void enter_a_Deal_Price_for_the_discount() {
        dealPriceIconPage = new DealPriceIconPage(driver);
        dealPriceIconPage.switchToTab(2);
        dealPriceIconPage.clickOnDiscountRadioBtn(2)
                .enterDealPriceDiscount("10")
        ;
    }

    @When("Open the Deal Price window and click OK without entering any prices.")
    public void open_the_Deal_Price_window_and_click_OK_without_entering_any_prices() {
        gmCreateEstimatePage = new GMCreateEstimatePage(driver);
        gmCreateEstimatePage.clickOnDealPriceIcon();
        dealPriceIconPage = new DealPriceIconPage(driver);
        dealPriceIconPage.switchToTab(2)
                .startAssertions(DealPriceIconPageAssertion.class)
                .assertIfSetDealPriceWindowOpened()
                .endAssertion()
                .clickOnOkBtn()
        ;
    }

    @Then("User is warned that a {string}.")
    public void user_is_warned_that_a(String warnMsg) {
        dealPriceIconPage.startAssertions(DealPriceIconPageAssertion.class)
                .assertIfUserWarnedThatDealPriceIsRequiredMsg(warnMsg)
                .endAssertion()
                .clickOnCancelBtn()
        ;
    }

    @When("Add some jobs to a quote and click on the New Estimate button.")
    public void add_some_jobs_to_a_quote_and_click_on_the_New_Estimate_button(io.cucumber.datatable.DataTable data) {
        List<String> expectedResult = data.asList();
        gmCreateEstimatePage = new GMCreateEstimatePage(driver);
        gmCreateEstimatePage.switchToTab(1);
        gmCreateEstimatePage.clickOnRemoveAndReplace()
                .clickOnRemoveAndReplace()
                .startAssertions(GMCreateEstimatePageAssertion.class)
                .assertIfQuantityDescriptionAndPriceAddedToGMQuote(expectedResult, 2)
                .endAssertion()
                .clickOnNewEstimate()
        ;
    }

    @Then("Message is shown to user: {string}. OK returns the screen to the first stage of Create Quote and Cancel leaves the page as is.")
    public void message_is_shown_to_user_OK_returns_the_screen_to_the_first_stage_of_Create_Quote_and_Cancel_leaves_the_page_as_is(String warnMsg) {
        gmCreateEstimatePage.startAssertions(GMCreateEstimatePageAssertion.class)
                .assertIfWindowsWarningMsgDisplayed(warnMsg)
                .endAssertion()
                .acceptAlertIfPresent(GMCreateEstimatePage.class);
        homePage = new HomePage(driver);
        homePage.startAssertions(HomePageAssertion.class)
                .assertAtHomePage()
                .endAssertion()
                .inputVIN("1G1ZA5ST1HF190045")
                .searchBtn();
        gmCreateEstimatePage = new GMCreateEstimatePage(driver);
        gmCreateEstimatePage.expandJobTreeInnerRow(2)
                .expandJobTreeSubInnerRow(7)
                .clickOnRemoveAndReplace()
                .clickOnNewEstimate()
                .startAssertions(GMCreateEstimatePageAssertion.class)
                .assertIfWindowsWarningMsgDisplayed(warnMsg)
                .endAssertion()
                .dismissAlertIfPresent(GMCreateEstimatePage.class);
        gmCreateEstimatePage = new GMCreateEstimatePage(driver);
        gmCreateEstimatePage.startAssertions(GMCreateEstimatePageAssertion.class)
                .assertAtEstimateTab()
                .endAssertion()
        ;
    }

    @When("Click the continue button.")
    public void click_the_continue_button() {
        gmCreateEstimatePage.clickOnContinueBtn();
    }

    @Then("User is taken to the Notes tab.Exception: If there is no Customer assigned to the VIN then user is taken to the Customer tab.")
    public void user_is_taken_to_the_Notes_tab_Exception_If_there_is_no_Customer_assigned_to_the_VIN_then_user_is_taken_to_the_Customer_tab() {
        gmCreateEstimateNotesPage = new GMCreateEstimateNotesPage(driver);
        gmCreateEstimateNotesPage.startAssertions(GMCreateEstimatesNotesPageAssertion.class)
                .assertAtNotesTab()
                .endAssertion();
        super.close();
    }

    @When("Start a new quote with Reg {string}. Continue to the Quote tab.")
    public void start_a_new_quote_with_Reg_Continue_to_the_Quote_tab(String string) throws IOException {
        super.setUp();
        homePage = functionalLibrary.jlrLogIn(environment, configuration, HomePage.class);
        homePage.startAssertions(HomePageAssertion.class)
                .assertAtHomePage()
                .endAssertion()
                .inputRegistrationNo(excel.getData(7, 0))
                .searchBtn()
        ;
    }

    @When("Click on + link of the Servicing job in the Job Tree")
    public void click_on_link_of_the_Servicing_job_in_the_Job_Tree() {
        gmCreateEstimatePage = new GMCreateEstimatePage(driver);
        gmCreateEstimatePage.expandJobTreeInnerRow(1)
                .expandJobTreeSubInnerRow(2)
        ;
    }

    @Then("Tree is Expanded.")
    public void Tree_is_Expanded() {
        gmCreateEstimatePage.startAssertions(GMCreateEstimatePageAssertion.class)
                .assertIfTheTreeIsExpanded()
                .endAssertion()
        ;
    }

    @When("Click on - link of the Serving job in the Job Tree")
    public void click_on_link_of_the_Serving_job_in_the_Job_Tree() {
        gmCreateEstimatePage.expandJobTreeSubInnerRow(2)
        ;
    }

    @Then("Tree is minimized.")
    public void Tree_is_minimized() {
        gmCreateEstimatePage.startAssertions(GMCreateEstimatePageAssertion.class)
                .assertIfTheJLRTreeIsMinimized()
                .endAssertion()
        ;
    }

    @When("Click on the + link of the Servicing job in the Job Tree and click on Job Maintenance Service Schedules, Service Interval Schedules job")
    public void click_on_the_link_of_the_Servicing_job_in_the_Job_Tree_and_click_on_Job_Maintenance_Service_Schedules_Service_Interval_Schedules_job() {
        gmCreateEstimatePage = new GMCreateEstimatePage(driver);
        gmCreateEstimatePage.expandJobTreeSubInnerRow(2)
                .expandJobTreeLevelThreeInnerRow(1)
        ;
    }

    @Then("The {string} job is added to the quote .")
    public void the_job_is_added_to_the_quote(String job) {
        gmCreateEstimatePage = new GMCreateEstimatePage(driver);
        gmCreateEstimatePage.clickOnMY15DieselParticleFilter()
                .startAssertions(GMCreateEstimatePageAssertion.class)
                .assertIfTheMileageNormalLaborOnly15000MilesAnd24000KMJobIsAddedToTheEstimate(job)
                .endAssertion()
        ;
    }

    @When("Click on the job tree \"Service Interval Schedules $16,$000Mls and $26,$000KM and $12 Months job again.")
    public void click_on_the_job_tree_Service_Interval_Schedules_$16_$000Mls_and_$26_$000KM_and_$12_Months_job_again() {
        gmCreateEstimatePage.clickOnMY15DieselParticleFilter()
        ;
    }

    @Then("A message informs that {string}.")
    public void a_message_informs_that(String warnMsg) {
        gmCreateEstimatePage = new GMCreateEstimatePage(driver);
        gmCreateEstimatePage.startAssertions(GMCreateEstimatePageAssertion.class)
                .assertIfJobTwiceWarningMsgDisplayed(warnMsg)
                .endAssertion();
        homePage = new HomePage(driver);
        homePage.clickOnWarningAcceptBtn();
        gmCreateEstimatePage = new GMCreateEstimatePage(driver);
        gmCreateEstimatePage.clickOnDeleteIcon(1)
        ;
    }

    @Then("The Miscellaneous Jobs window opens. Tax rate is the Markets default")
    public void the_Miscellaneous_Jobs_window_opens_Tax_rate_is_the_Markets_default() {
        jobsPage = new JobsPage(driver);
        jobsPage.switchToTab(2)
                .startAssertions(JobsPageAssertion.class)
                .assertIsAtMiscellaneousJobsPage()
                .assertIfTaxRateIsTheMarketsDefaultZero("20%")
                .endAssertion()
        ;
    }

    @Then("The Test Job is added to the quote and the price Incl. Tax.")
    public void the_Test_Job_is_added_to_the_quote_and_the_price_Incl_Tax(io.cucumber.datatable.DataTable dataTable) {
        List<String> expectedResult = dataTable.asList();
        gmCreateEstimatePage = new GMCreateEstimatePage(driver);
        gmCreateEstimatePage.switchToTab(1)
                .startAssertions(GMCreateEstimatePageAssertion.class)
                .assertIfQuantityDescriptionAndPriceAddedNewToQuoteWithVATPrice(expectedResult, 1)
                .endAssertion()
                .clickOnDeleteIcon(1)
        ;
    }

    @When("Open the Job window and select a job from the drop down list . Click the Add button.")
    public void open_the_Job_window_and_select_a_job_from_the_drop_down_list_Click_the_Add_button() {
        gmCreateEstimatePage.clickOnAddMiscellaneousJobButton();
        jobsPage = new JobsPage(driver);
        jobsPage.switchToTab(2);
        jobsPage.selectJobFormDropDownOption(JobFormList.Automation_Job)
                .clickOnAddBtn()
        ;
    }

    @Then("The selected job is added to the quote.")
    public void the_selected_job_is_added_to_the_quote(io.cucumber.datatable.DataTable dataTable) {
        List<String> expectedResult = dataTable.asList();
        gmCreateEstimatePage = new GMCreateEstimatePage(driver);
        gmCreateEstimatePage.switchToTab(1)
                .startAssertions(GMCreateEstimatePageAssertion.class)
                .assertIfQuantityDescriptionAndPriceAddedNewToQuoteWithVATPrice(expectedResult, 1)
                .endAssertion()
                .clickOnDeleteIcon(1)
        ;
    }

    @When("Click on the Labour button.")
    public void click_on_the_Labour_button() {
        gmCreateEstimatePage.clickOnLaborMiscellaneousButton();
    }

    @When("Enter a DTU value and a description. Click the Add button")
    public void enter_a_DTU_value_and_a_description_Click_the_Add_button(io.cucumber.datatable.DataTable data) {
        List<String> list = data.asList();
        jobsPage.selectJobFormDropDownOption(JobFormList.AdHoc);
        partPage = new PartPage(driver);
        partPage.enterPartQuantity(list.get(0))
                .enterPartNumber(list.get(1))
                .enterPartDescription(list.get(2));
        jobsPage = new JobsPage(driver);
        jobsPage.inputCost(list.get(3))
                .inputPrice(list.get(4))
                .clickOnAddBtn()
        ;
    }

    @When("Open the window again, this time search for a Part description")
    public void open_the_window_again_this_time_search_for_a_Part_description() throws IOException {
        gmCreateEstimatePage.clickOnPartMiscellaneousButton();
        jobsPage = new JobsPage(driver);
        jobsPage.switchToTab(2);
        jobsPage.selectJobFormDropDownOption(JobFormList.ManufacturerParts);
        partPage = new PartPage(driver);
        partPage.startAssertions(PartPageAssertion.class)
                .assertAtManufacturerPartsSearchPage()
                .endAssertion()
                .clickOnPartRadioBtn()
                .enterSearchCriteriaID(excel.getData(10, 0))
                .clickOnPartSearchBtn();
        partPage.startAssertions(PartPageAssertion.class)
                .assertIfPartIsFoundAndDisplayedInTheList(1)
                .endAssertion()
        ;
    }

    @When("Click on the Add icon of a part, ensure you select the QTY desired.")
    public void click_on_the_Add_icon_of_a_part_ensure_you_select_the_QTY_desired() {
        partPage.clickOnAddIcon();
        jobsPage = new JobsPage(driver);
        jobsPage.clickOnAddBtn()
        ;
    }

    @Then("The user is able select the QTY then allowed to add to the quote. Part is added to the quote")
    public void the_user_is_able_select_the_QTY_then_allowed_to_add_to_the_quote_Part_is_added_to_the_quote(io.cucumber.datatable.DataTable data) {
        List<String> addedQuote = data.asList();
        List<String> expectedAddedQuote = null;

        if (environment.contains("qa")) {
            expectedAddedQuote = Arrays.asList(addedQuote.get(0), addedQuote.get(1), addedQuote.get(2), addedQuote.get(3));
        } else if (environment.contains("uat")) {
            expectedAddedQuote = Arrays.asList(addedQuote.get(0), addedQuote.get(1), addedQuote.get(4), addedQuote.get(5));
        }
        gmCreateEstimatePage = new GMCreateEstimatePage(driver);
        gmCreateEstimatePage.switchToTab(1)
                .startAssertions(GMCreateEstimatePageAssertion.class)
                .assertIfQuantityDescriptionAndPriceAddedNewToQuoteWithVATPrice(expectedAddedQuote, 1)
                .endAssertion();
        gmCreateEstimatePage = new GMCreateEstimatePage(driver);
        gmCreateEstimatePage.clickOnDeleteIcon(1)
        ;

    }

    @When("Add some jobs to a quote and change the customer type by selecting a new customer from the Customer Type drop down list")
    public void add_some_jobs_to_a_quote_and_change_the_customer_type_by_selecting_a_new_customer_from_the_Customer_Type_drop_down_list() {
        gmCreateEstimatePage = new GMCreateEstimatePage(driver);
        gmCreateEstimatePage.clickOnMY15DieselParticleFilter()
                .selectCustomerType(CustomerType.New)
        ;
    }

    @Then("The quotes price is changed in accordance to the customer types settings.")
    public void the_quotes_price_is_changed_in_accordance_to_the_customer_types_settings() throws IOException {
        gmCreateEstimatePage.startAssertions(GMCreateEstimatePageAssertion.class)
                .assertIfQuotesPriceIsChangedInAccordanceToTheCustomerTypesSettings(excel.getData(12, 0))
                .endAssertion()
                .selectCustomerType(CustomerType.Retail)
        ;
    }

    @When("Add a job with parts and labour to a quote. Click on the Job Detail icon to open the Parts and Labour details")
    public void add_a_job_with_parts_and_labour_to_a_quote_Click_on_the_Job_Detail_icon_to_open_the_Parts_and_Labour_details() {
        gmCreateEstimatePage.clickOnMagnifyingGlassIcon(1)
        ;
    }

    @Then("Parts and Labour items are shown along with their prices EX VAT")
    public void parts_and_Labour_items_are_shown_along_with_their_prices_EX_VAT(io.cucumber.datatable.DataTable dataTable) {
        List<String> data = dataTable.asList();
        List<String> expectedValue1 = null;
        List<String> expectedValue2 = null;
        List<String> expectedValue4 = null;
        if (environment.contains("qa")) {
            expectedValue1 = Arrays.asList(data.get(0), data.get(1), data.get(2), data.get(3), data.get(5), data.get(4), data.get(6));
            expectedValue2 = Arrays.asList(data.get(8), data.get(9), data.get(10), data.get(11), data.get(12), data.get(13));
            expectedValue4 = Arrays.asList(data.get(6));
        } else if (environment.contains("uat")) {
            expectedValue1 = Arrays.asList(data.get(0), data.get(1), data.get(2), data.get(3), data.get(7), data.get(4), data.get(6));
            expectedValue2 = Arrays.asList(data.get(8), data.get(9), data.get(10), data.get(11), data.get(14), data.get(13));
            expectedValue4 = Arrays.asList(data.get(6));
        }
        List<List<String>> expectedValue = Arrays.asList(expectedValue1, expectedValue2);
        List<String> expectedValue3 = Arrays.asList(data.get(17));
        List<List<String>> expectedLaborValue = Arrays.asList(expectedValue3, expectedValue4);
        partLaborDrillDownPage = new PartLaborDrillDownPage(driver);
        partLaborDrillDownPage.switchToTab(2)
                .startAssertions(PartLaborDrillDownPageAssertion.class)
                .assertIfPartsAndLabourDetailsOpened()
                .assertIfJLRPartsAndLabourItemsAreShownAlongWithTheirPrice(expectedValue, expectedLaborValue)
                .endAssertion()
        ;
    }

    @When("Click on the ADD LABOUR button, search for a new labour code and add it to the job.")
    public void click_on_the_ADD_LABOUR_button_search_for_a_new_labour_code_and_add_it_to_the_job() throws IOException {
        partLaborDrillDownPage.clickOnAddLaborBtn()
                .selectRadioBtn(1)
                .enterSearchCriteria(excel.getData(12, 0))
                .clickOnSearchBtn()
                .enterJLRLaborTime(excel.getData(13, 0))
                .clickOnAddIcon(2)
                .clickOnContinueBtn()
        ;
    }

    @Then("The job window is closed and nothing is added to the quote.")
    public void the_job_window_is_closed_and_nothing_is_added_to_the_quote() {
        gmCreateEstimatePage = new GMCreateEstimatePage(driver);
        gmCreateEstimatePage.switchToTab(1)
                .startAssertions(GMCreateEstimatePageAssertion.class)
                .assertAtQuoteTab()
                .endAssertion()
        ;
    }

    @Then("The new jlr labour code is added to the job, showing the price EX VAT")
    public void the_new_jlr_labour_code_is_added_to_the_job_showing_the_price_EX_VAT(io.cucumber.datatable.DataTable data) {
        List<String> addedQuote = data.asList();
        List<String> expectedAddedQuote = null;
        if (environment.contains("qa")) {
            expectedAddedQuote = Arrays.asList(addedQuote.get(0), addedQuote.get(1), addedQuote.get(2), addedQuote.get(3), "");
        } else if (environment.contains("uat")) {
            expectedAddedQuote = Arrays.asList(addedQuote.get(0), addedQuote.get(1), addedQuote.get(4), addedQuote.get(5), "");
        }
        gmCreateEstimatePage = new GMCreateEstimatePage(driver);
        gmCreateEstimatePage.switchToTab(1)
                .startAssertions(GMCreateEstimatePageAssertion.class)
                .assertIfQuantityDescriptionAndPriceAddedNewToQuoteWithVATPrice(expectedAddedQuote, 1)
                .endAssertion()
                .clickOnDeleteIcon(1)
        ;
    }

    @When("Add some jobs to a quote and click on the Deal Price icon.")
    public void add_some_jobs_to_a_quote_and_click_on_the_Deal_Price_icon() {
        gmCreateEstimatePage = new GMCreateEstimatePage(driver);
        gmCreateEstimatePage.clickOnMY15DieselParticleFilter()
                .clickOnDealPriceIcon()
        ;
    }

    @Then("Deal price window closes with no change to the jlr quote price.")
    public void deal_price_window_closes_with_no_change_to_the_jlr_quote_price() {
        gmCreateEstimatePage = new GMCreateEstimatePage(driver);
        gmCreateEstimatePage.switchToTab(1)
                .startAssertions(GMCreateEstimatePageAssertion.class)
                .assertAtQuoteTab()
                .endAssertion()
                .clickOnDeleteIcon(1)
        ;
    }

    @When("Change the description")
    public void change_the_description() throws IOException {
        dealPriceIconPage = new DealPriceIconPage(driver);
        dealPriceIconPage.renameDiscountDescription(excel.getData(14, 0));
        ;
    }

    @When("Enter a discount percentage")
    public void enter_a_discount_percentage() throws IOException {
        dealPriceIconPage.enterDealPrice(excel.getData(13, 0));
    }

    @Then("The price is accepted and reflected on the jlr quote {string},{string}")
    public void the_price_is_accepted_and_reflected_on_the_jlr_quote(String price1, String price2) {
        String expectedAddedQuote = null;
        if (environment.contains("qa")) {
            expectedAddedQuote = price1;
        } else if (environment.contains("uat")) {
            expectedAddedQuote = price2;
        }
        gmCreateEstimatePage = new GMCreateEstimatePage(driver);
        gmCreateEstimatePage.switchToTab(1)
                .startAssertions(GMCreateEstimatePageAssertion.class)
                .assertIfThePriceIsAcceptedAndReflectedOnTheQuoteTotal(expectedAddedQuote)
                .endAssertion()
                .clickOnDeleteIcon(1)
                .clickOnDeleteIcon(1)
        ;
    }

    @Then("jlr User is warned that a {string}.")
    public void jlr_user_is_warned_that_a(String warnMsg) {
        dealPriceIconPage.startAssertions(DealPriceIconPageAssertion.class)
                .assertIfJLRUserWarnedThatDealPriceIsRequiredMsg(warnMsg)
                .endAssertion()
                .clickOnCancelBtn()
                .switchToTab(1)
        ;
    }

    @When("Open the Job Detail window")
    public void open_the_Job_Detail_window() {
        gmCreateEstimatePage = new GMCreateEstimatePage(driver);
        gmCreateEstimatePage.clickOnMagnifyingGlassIcon(1);
    }

    @Then("The job detail window loads.")
    public void the_job_detail_window_loads() {
        partLaborDrillDownPage = new PartLaborDrillDownPage(driver);
        partLaborDrillDownPage.switchToTab(2)
                .startAssertions(PartLaborDrillDownPageAssertion.class)
                .assertIfPartsAndLabourDetailsOpened()
                .endAssertion()
        ;
    }

    @When("Hit the Support button.")
    public void hit_the_Support_button() {
        partLaborDrillDownPage.clickOnSupportBtn();
    }

    @Then("The support window loads")
    public void the_support_window_loads() {
        partLaborDrillDownPage.switchToTab(2)
                .startAssertions(PartLaborDrillDownPageAssertion.class)
                .assertUserAtSupportEnquiryPage()
                .endAssertion()
        ;
    }

    @When("Select a part and labour item, and insert some data in the text field.")
    public void select_a_part_and_labour_item_and_insert_some_data_in_the_text_field() {
        partLaborDrillDownPage.clickOnPartAndLaborEnquiryCheckbox(1);
    }

    @Then("Tick appears in box once selected, and the text field allows text entry.")
    public void tick_appears_in_box_once_selected_and_the_text_field_allows_text_entry() throws IOException {
        partLaborDrillDownPage.enterRelevantInfoText(excel.getData(14, 0));
    }

    @When("Hit Ok to close the window.")
    public void hit_Ok_to_close_the_window() {
        partLaborDrillDownPage.clickOnCancelBtn()
                .switchToTab(2);
        partLaborDrillDownPage.clickOnContinueBtn()
                .switchToTab(1);
    }

    @Then("Window is dismissed.")
    public void window_is_dismissed() {
        gmCreateEstimatePage = new GMCreateEstimatePage(driver);
        gmCreateEstimatePage.startAssertions(GMCreateEstimatePageAssertion.class)
                .assertAtQuoteTab()
                .endAssertion()
        ;
    }

    @When("Hit the Send button")
    public void hit_the_Send_button() {
        partLaborDrillDownPage = new PartLaborDrillDownPage(driver);
        partLaborDrillDownPage.clickOnSendBtn();
    }

    @Then("Error message displayed: {string}.")
    public void error_message_displayed(String errorMsg) {
        partLaborDrillDownPage.startAssertions(PartLaborDrillDownPageAssertion.class)
                .assertIfUserWarnedToSelectAPartToSendEnquiry(errorMsg)
                .endAssertion()
        ;
    }

    @When("On HISTORIC QUOTES Quote tab, a Checksheet icon should be visible")
    public void on_HISTORIC_QUOTES_Quote_tab_a_Checksheet_icon_should_be_visible() {
        gmCreateEstimatePage = new GMCreateEstimatePage(driver);
        gmCreateEstimatePage.clickOnSaveBtn();
    }

    @Then("Checksheet icon is visible")
    public void checksheet_icon_is_visible() throws IOException {
        gmCreateEstimatePage.startAssertions(GMCreateEstimatePageAssertion.class)
                .assertIfCheckSheetIconDisplayed()
                .endAssertion();
        homePage = new HomePage(driver);
        homePage.openCreateEstimateTab()
                .inputRegistrationNo(excel.getData(7, 0))
                .searchBtn();
        gmCreateEstimatePage = new GMCreateEstimatePage(driver);
        gmCreateEstimatePage.expandJobTreeInnerRow(1)
                .expandJobTreeSubInnerRow(2)
                .expandJobTreeLevelThreeInnerRow(1);
    }

    @When("Delete all jobs from the quote")
    public void delete_all_jobs_from_the_quote() {
        gmCreateEstimatePage = new GMCreateEstimatePage(driver);
        gmCreateEstimatePage.clickOnDeleteIcon(1)
        ;
    }

    @When("Hit Lost Sale and then hit OK.")
    public void hit_Lost_Sale_and_then_hit_OK() {
        gmCreateEstimatePage = new GMCreateEstimatePage(driver);
        gmCreateEstimatePage.clickOnLostSaleBtn();
    }

    @Then("Warning box occurs {string}")
    public void warning_box_occurs(String warnMsg) {
        gmCreateEstimatePage.startAssertions(GMCreateEstimatePageAssertion.class)
                .assertIfCurrentQuoteEmptyWarningMsgDisplayed(warnMsg)
                .endAssertion();
        homePage = new HomePage(driver);
        homePage.clickOnWarningAcceptBtn();
        ;
    }

    @When("Hit Lost Sale")
    public void hit_Lost_Sale() {
        gmCreateEstimatePage = new GMCreateEstimatePage(driver);
        gmCreateEstimatePage.clickOnLostSaleBtn();
    }

    @Then("Lost sale window is opened.")
    public void lost_sale_window_is_opened() {
        gmCreateEstimatePage.switchToTab(2)
                .startAssertions(GMCreateEstimatePageAssertion.class)
                .assertIfLostSaleWindowIsOpened("Lost Sale Record")
                .endAssertion()
        ;
    }

    @When("Fill out the lost sales record and ensure that expected values are available in drop down box")
    public void fill_out_the_lost_sales_record_and_ensure_that_expected_values_are_available_in_drop_down_box(io.cucumber.datatable.DataTable options) {
        List<String> lostSaleReasons = options.asList();
        jobsPage = new JobsPage(driver);
        jobsPage.inputDescription(lostSaleReasons.get(1));
        gmCreateEstimatePage = new GMCreateEstimatePage(driver);
        gmCreateEstimatePage.enterFormattedPrice(lostSaleReasons.get(2))
        ;
    }

    @Then("Drop down Reason should contain")
    public void drop_down_Reason_should_contain(io.cucumber.datatable.DataTable options) {
        List<String> lostSaleReasons = options.asList();
        gmCreateEstimatePage.startAssertions(GMCreateEstimatePageAssertion.class)
                .assertLostSaleDropDownReasons(lostSaleReasons)
                .endAssertion()
        ;
    }

    @When("hit Add.")
    public void hit_Add() {
        gmCreateEstimatePage.clickOnLostSaleAddBtn()
                .switchToTab(1);
    }

    @Then("pop up form is closed")
    public void pop_up_form_is_closed() throws IOException {
        searchEstimatePage = new SearchEstimatePage(driver);
        searchEstimatePage.clickOnDeleteBtn();
        homePage = new HomePage(driver);
        homePage.clickOnWarningAcceptBtn()
                .openCreateEstimateTab()
                .inputRegistrationNo(excel.getData(7, 0))
                .searchBtn();
        gmCreateEstimatePage.expandJobTreeInnerRow(1)
                .expandJobTreeSubInnerRow(2)
                .expandJobTreeLevelThreeInnerRow(1)
        ;
    }

    @When("Select the Deferred button.")
    public void select_the_Deferred_button() {
        gmCreateEstimatePage.clickOnDeferredBtn();
    }

    @Then("Deferred window is opened.")
    public void deferred_window_is_opened() throws IOException {
        gmCreateEstimatePage.switchToTab(2)
                .startAssertions(GMCreateEstimatePageAssertion.class)
                .assertIfLostSaleWindowIsOpened(excel.getData(15, 0))
                .endAssertion()
        ;
    }

    @When("Using the calender icon, select a date for the deferred quote.")
    public void using_the_calender_icon_select_a_date_for_the_deferred_quote() {
        gmCreateEstimatePage.clickOnCalendarDateWhichIsAvailable();
    }

    @When("Hit Save.")
    public void hit_Save() {
        gmCreateEstimatePage.clickOnSaveBtn()
                .switchToTab(1);
    }

    @Then("The deferred date is saved and the window is closed.")
    public void theDeferredDateIsSavedAndTheWindowIsClosed() throws IOException {
        homePage = new HomePage(driver);
        homePage.openCreateEstimateTab()
                .inputRegistrationNo(excel.getData(7, 0))
                .searchBtn();
        gmCreateEstimatePage.expandJobTreeInnerRow(1)
                .expandJobTreeSubInnerRow(2)
                .expandJobTreeLevelThreeInnerRow(1)
        ;
    }

    @When("Click Unpriced generic jobs, click to complete ensure the link works correctly")
    public void click_Unpriced_generic_jobs_click_to_complete_ensure_the_link_works_correctly() {
        homePage = new HomePage(driver);
        homePage.startAssertions(HomePageAssertion.class)
                .assertIfAHyperlinkToTheCommonJobsPageIsVisible()
                .endAssertion()
                .clickOnUnpricedCommonCustomJobsLink()
        ;
    }

    @Then("User is taken to Administration > Generic Jobs.")
    public void user_is_taken_to_Administration_Generic_Jobs() {
        commonJobsPage = new CommonJobsPage(driver);
        commonJobsPage.startAssertions(CommonJobsPageAssertion.class)
                .assertIfGenericJobsTab()
                .endAssertion();
        homePage = new HomePage(driver);
        homePage.openCreateEstimateTab()
        ;
    }

    @When("Click Generic parts priced below retail, click to complete ensure the link works correctly")
    public void click_Generic_parts_priced_below_retail_click_to_complete_ensure_the_link_works_correctly() {
        homePage = new HomePage(driver);
        homePage.clickOnGenericPartsPriceLink()
        ;
    }

    @Then("User is taken to Administation > Generic parts.")
    public void user_is_taken_to_Administation_Generic_parts() {
        bulkFluidsPage = new BulkFluidsPage(driver);
        bulkFluidsPage.startAssertions(BulkFluidsPageAssertion.class)
                .assertIfGenericPartsTab()
                .endAssertion();
        homePage = new HomePage(driver);
        homePage.openCreateEstimateTab()
        ;
    }

    @When("Add some jobs to a quote and click on the New Quote button.")
    public void add_some_jobs_to_a_quote_and_click_on_the_New_Quote_button() {
        gmCreateEstimatePage = new GMCreateEstimatePage(driver);
        gmCreateEstimatePage.clickOnNewQuote();
    }

    @Then("Message is shown to user: {string} .OK returns the screen to the first stage of jlr Create Quote and Cancel leaves the page as is.")
    public void message_is_shown_to_user_OK_returns_the_screen_to_the_first_stage_of_jlr_Create_Quote_and_Cancel_leaves_the_page_as_is(String warnMsg) throws IOException {
        gmCreateEstimatePage.startAssertions(GMCreateEstimatePageAssertion.class)
                .assertIfDialogConfirmContentMsgDisplayed(warnMsg)
                .endAssertion()
                .acceptAlertIfPresent(GMCreateEstimatePage.class);
        homePage = new HomePage(driver);
        homePage.clickOnWarningAcceptBtn()
                .startAssertions(HomePageAssertion.class)
                .assertAtHomePage()
                .endAssertion()
                .inputRegistrationNo(excel.getData(7, 0))
                .searchBtn();
        gmCreateEstimatePage = new GMCreateEstimatePage(driver);
        gmCreateEstimatePage.expandJobTreeInnerRow(1)
                .expandJobTreeSubInnerRow(1)
                .clickOnLabour15KAnd24K()
                .clickOnNewQuote()
                .startAssertions(GMCreateEstimatePageAssertion.class)
                .assertIfDialogConfirmContentMsgDisplayed(warnMsg)
                .endAssertion();
        homePage = new HomePage(driver);
        homePage.clickOnWarningCancelBtn();
        gmCreateEstimatePage = new GMCreateEstimatePage(driver);
        gmCreateEstimatePage.startAssertions(GMCreateEstimatePageAssertion.class)
                .assertAtQuoteTab()
                .endAssertion()
        ;
    }

    @When("Hit the Log Out button, press OK when the warning message prompts")
    public void hit_the_Log_Out_button_press_OK_when_the_warning_message_prompts() {
        homePage = new HomePage(driver);
        homePage.logoutBtn();
        gmCreateEstimatePage = new GMCreateEstimatePage(driver);
        gmCreateEstimatePage.clickOnOKBtn()
        ;
    }

    @Then("The user is logged out of the current session and taken back to the login screen")
    public void the_user_is_logged_out_of_the_current_session_and_taken_back_to_the_login_screen() throws IOException {
        loginPage = new LoginPage(driver);
        loginPage.startAssertions(LoginPageAssertion.class)
                .assertAtLoginPage()
                .endAssertion()
                .jlrLogin(configuration.getDealerId(), configuration.getUserId(), configuration.getPassword(), HomePage.class);
        homePage = new HomePage(driver);
        homePage.inputRegistrationNo(excel.getData(7, 0))
                .searchBtn();
        gmCreateEstimatePage = new GMCreateEstimatePage(driver);
        gmCreateEstimatePage.expandJobTreeInnerRow(1)
                .expandJobTreeSubInnerRow(1)
                .clickOnLabour15KAnd24K()
        ;
    }

    @Then("Part is added to the jlr quote")
    public void part_is_added_to_the_jlr_quote(io.cucumber.datatable.DataTable data) {
        List<String> addedQuote = data.asList();
        List<String> expectedAddedQuote = null;
        if (environment.contains("qa")) {
            expectedAddedQuote = Arrays.asList(addedQuote.get(0), addedQuote.get(1), addedQuote.get(2));
        } else if (environment.contains("uat")) {
            expectedAddedQuote = Arrays.asList(addedQuote.get(0), addedQuote.get(1), addedQuote.get(3));
        }
        gmCreateEstimatePage = new GMCreateEstimatePage(driver);
        gmCreateEstimatePage.switchToTab(1)
                .startAssertions(GMCreateEstimatePageAssertion.class)
                .assertIfQuantityDescriptionAndPriceAddedNewToQuote(expectedAddedQuote, 2)
                .endAssertion()
                .clickOnDeleteIcon(1)
        ;
    }

    @Then("Click Job Details window and validate the {string} window opened and check Labour price {string}.")
    public void click_Job_Details_window_and_validate_the_window_opened_and_check_Labour_price(String Title, String labourPrice) {
        gmCreateEstimatePage.clickOnJobDetailsIcon();
        homePage.switchToSpecificWindow(Title);
        gmCreateEstimatePage.startAssertions(GMCreateEstimatePageAssertion.class)
                .assetLabourPrice(labourPrice)
                .endAssertion();
        driver.close();
        homePage.switchToSpecificWindow("JLR Menu Pricing");
    }
    @Given("Login into Dealer application {string}")
    public void login_into_dealer_application(String loginPerson) {
        super.setUp();
        homePage = functionalLibrary.logIn(environment, configuration, loginPerson, HomePage.class);
        homePage.startAssertions(HomePageAssertion.class)
                .assertAtHomePage()
                .endAssertion();
    }


    @When("click Administration tab")
    public void click_Administration_tab() {
        homePage = new HomePage(driver);
        homePage.startAssertions(HomePageAssertion.class)
                .assertAtHomePage()
                .endAssertion()
                .openAdministrationTab();
        systemSettingsPage = new SystemSettingsPage(driver);
        systemSettingsPage.openSystemSettingsTab();
    }

    @Then("navigate to createQuote page and verify that warning popup got displayed")
    public void navigate_to_createQuote_page_and_verify_that_warning_popup_got_displayed() {
        homePage.startAssertions(HomePageAssertion.class)
                .assertAtHomePage()
                .assertIfWarningDisplayed()
                .endAssertion()
                ;
    }

    @When("Navigate to Administration - System Settings")
    public void navigate_to_Administration_System_Settings() {
        super.setUp();
        homePage = functionalLibrary.jlrLogIn(environment, configuration, HomePage.class);
        homePage.startAssertions(HomePageAssertion.class)
                .assertAtHomePage()
                .endAssertion()
                .openAdministrationTab();
        systemSettingsPage = new SystemSettingsPage(driver);
        systemSettingsPage.openSystemSettingsTab();
    }

    @When("Edit the Cost and Retail prices as {string} and {string} and click labourcostRetail as default checkbox . Click Save.")
    public void edit_the_Cost_and_Retail_prices_as_and_and_click_labourcost_Retail_as_default_checkbox_Click_Save(String cost, String retail) {
        systemSettingsPage = new SystemSettingsPage(driver);
        systemSettingsPage.enterLabourCostPrice(cost)
                .enterRetailCostPrice(retail);
        systemSettingsPage.checkDefaultLabourRates();
        commonJobsPage = new CommonJobsPage(driver);
        commonJobsPage.clickOnSaveBtn()
        ;
    }

    @When("Create a new quote with Reg {string}. Continue to the Quote tab.")
    public void create_a_new_quote_with_Reg_Continue_to_the_Quote_tab(String RegistrationNo) {
        homePage = new HomePage(driver);
        homePage.startAssertions(HomePageAssertion.class)
                .assertAtHomePage()
                .endAssertion()
                .createQuote()
                .inputRegistrationNo(RegistrationNo)
                .searchBtn();
    }

    @Then("New quote is created and the quote tab is opened.")
    public void new_quote_is_created_and_the_quote_tab_is_opened() {
        gmCreateEstimatePage = new GMCreateEstimatePage(driver);
        gmCreateEstimatePage.startAssertions(GMCreateEstimatePageAssertion.class)
                .assertAtQuoteTab()
                .endAssertion()
        ;
    }

    @When("click on CreateQuote tab")
    public void click_on_CreateQuote_tab() {
        homePage = new HomePage(driver);
        homePage.startAssertions(HomePageAssertion.class)
                .assertAtHomePage()
                .endAssertion()
                .createQuote()
                ;
    }

    @Then("click Warning Ok button")
    public void click_Warning_Ok_button() {
        homePage.clickWarningOKButton();
    }

    @When("click on Labour in Add miscellaneous Items")
    public void click_on_Labour_in_Add_miscellaneous_Items() {
        homePage.clickLabourButton();
    }

    @Then("Navigate to {string} and Verify correct priceExcel.VAT {string} and Cost {string} displayed")
    public void verify_correct_priceExcel_VAT_and_Cost_displayed(String title, String cost, String priceexclVAT) {
        homePage.switchToSpecificWindow(title);
        homePage.startAssertions(HomePageAssertion.class)
                .assertAtHomePage()
                .assertIfCostcorrectlyDisplayed(cost, priceexclVAT)
                .endAssertion()
        ;
        driver.close();
        homePage.switchToSpecificWindow("JLR Menu Pricing");
    }

    @Then("set Labour Rates for Brands and Navigate to {string}")
    public void set_Labour_Rates_for_Brands_and_Navigate_to(String title) {
        systemSettingsPage.uncheckDefaultLabourRates()
                .clickSetLabourRates();
        homePage.switchToSpecificWindow(title);
    }

    @Then("set labour cost {string} and labour retail {string} for {string}")
    public void set_labour_cost_and_labour_retail_for(String labourcost, String labourRetail, String Brand) {
        systemSettingsPage.setLabourCostRetail(Brand, labourcost, labourRetail);
    }

    @Then("click ok and Save")
    public void click_ok_and_Save() {
        systemSettingsPage = new SystemSettingsPage(driver);
        systemSettingsPage.clickOK();
        homePage = new HomePage(driver);
        homePage.switchToSpecificWindow("JLR Menu Pricing");
        commonJobsPage = new CommonJobsPage(driver);
        commonJobsPage.clickOnSaveBtn();
    }

    @Then("click the Vehicle and clear existing quote")
    public void click_the_Vehicle_and_clear_existing_quote() {
        systemSettingsPage.clickVehicle();
        homePage.clickWarningOKButton();
    }

    @Then("logout from application")
    public void logout_from_application() {
        helpSupportPage = new HelpSupportPage(driver);
        helpSupportPage.clickHelpSupportTab()
                .clickLogout()
                .confirmLogout()
        ;
        super.close();
    }

    @Then("Set number of days for Quote Expiry as {string}")
    public void set_number_of_days_for_Quote_Expiry(String days) {
        systemSettingsPage.enterQuoteExpiry(days);
        commonJobsPage = new CommonJobsPage(driver);
        commonJobsPage.clickOnSaveBtn();
    }

    @Then("validate the quote expiry date as per number of days as {string} for Quote Expiry")
    public void validate_the_quote_expiry_date_as_per_number_of_days_as_for_Quote_Expiry(String days) {
           systemSettingsPage.startAssertions(SystemSettingsPageAssertion.class)
                   .assertIfQuoteExpiryCorrectlyDisplayed(days)
                   .endAssertion();
    }

    @When("User clicks continue button")
    public void user_clicks_continue_button() {
        gmCreateEstimatePage.clickOnContinueBtn();
    }

    @Then("click on create quote and click new quote button")
    public void click_on_create_quote_and_click_new_quote_button() {
        homePage.createQuote()
                .createNewQuote();
    }

    @Then("set next quote number and save the value")
    public void set_next_quote_number_and_save_the_value() {
        systemSettingsPage.getNextQuoteNumber();
        homePage.saveBtn();
    }

    @Then("save the quote and verify the quote number correctly displayed")
    public void save_the_quote_and_verify_the_quote_number_correctly_displayed() {
        gmCreateEstimatePage.clickOnContinueBtn().clickOnContinueBtn();
        homePage.saveBtn();
        homePage.startAssertions(HomePageAssertion.class)
                .assertIfQuoteNumberCorrectlyDisplayed()
                .endAssertion();
    }

    @Then("set the Quote prefix as {string} and Quote suffix as {string}")
    public void set_the_Quote_prefix_as_and_Quote_suffix_as(String prefix, String suffix) {
              systemSettingsPage.enterPrefixSuffix(prefix, suffix);
              homePage.saveBtn();
    }

    @Then("save and print the quote and verify the quote number added with {string} and {string}")
    public void save_and_print_the_quote_and_verify_the_quote_number_added_with_and(String prefix, String suffix) throws IOException {
        gmCreateEstimatePage.clickOnContinueBtn().clickOnContinueBtn();
        homePage.saveBtn();
        gmCreateEstimatePage.clickOnPrint().clickOnDetailed();
        gmCreateEstimatePage.startAssertions(GMCreateEstimatePageAssertion.class)
                .assertIfFileDownloaded().endAssertion();
        systemSettingsPage = new SystemSettingsPage(driver);
        systemSettingsPage.startAssertions(SystemSettingsPageAssertion.class)
                .assertIfQuotenameaddedwithprefixsuffix(excel.readExcel("downloadedFileName", "Sheet1", 0, 0), prefix, suffix)
                .endAssertion();
        functionalLibrary.deleteFile(excel.readExcel("downloadedFileName", "Sheet1", 0, 0));

    }

    @Then("Enter {string} in Default Customer Name box and save")
    public void enter_in_Default_Customer_Name_box_and_save(String customerName) {
        systemSettingsPage.enterDefaultCustomerName(customerName);
        homePage.saveBtn();
    }

    @Then("click on continue button and verify the default customer name")
    public void click_on_continue_button_and_verify_the_default_customer_name() {
        gmCreateEstimatePage.clickOnContinueBtn();
        systemSettingsPage.startAssertions(SystemSettingsPageAssertion.class)
                .assertIfDefaultCustomerNameCorrectlyDisplayed()
                .endAssertion();
    }

    @Then("set Printer top margin in system settings and verify able to save the settings")
    public void set_Printer_top_margin_in_system_settings_and_verify_able_to_save_the_settings() {
        systemSettingsPage.enterPrintQuoteTopMargin("2");
        homePage.saveBtn();
        systemSettingsPage.enterPrintQuoteTopMargin("0");
        homePage.saveBtn();
    }

    @Then("get Address information from Org.details")
    public void get_Address_information_from_Org_details() {
        homePage = new HomePage(driver);
        homePage.startAssertions(HomePageAssertion.class)
                .assertAtHomePage()
                .endAssertion()
                .openAdministrationTab();
        systemSettingsPage = new SystemSettingsPage(driver);
        systemSettingsPage.openSystemSettingsTab()
                        .checkShowAddress();
        homePage.saveBtn();
        systemSettingsPage = new SystemSettingsPage(driver);
        systemSettingsPage.clickOrgDetail()
                .getAddressPostalCode();
    }

    @Then("Verify that address correctly displayed in PDF file")
    public void verify_that_address_correctly_displayed_in_PDF_file() throws IOException {
        gmCreateEstimatePage.clickOnContinueBtn().clickOnContinueBtn();
        homePage.saveBtn();
        gmCreateEstimatePage.clickOnPrint().clickOnDetailed();
        gmCreateEstimatePage.startAssertions(GMCreateEstimatePageAssertion.class)
                .assertIfFileDownloaded().endAssertion();
        systemSettingsPage = new SystemSettingsPage(driver);
        systemSettingsPage.startAssertions(SystemSettingsPageAssertion.class)
                .assertIfAddresscorrectlyDisplayedinPDF(excel.readExcel("downloadedFileName", "Sheet1", 0, 0))
                .endAssertion();
        functionalLibrary.deleteFile(excel.readExcel("downloadedFileName", "Sheet1", 0, 0));
        }

    @Then("verify that warning message {string} displayed")
    public void verify_that_warning_message_displayed(String warnmessage) {
        homePage.startAssertions(HomePageAssertion.class)
                .assertIfWarningMessageCorrectlyDisplayed(warnmessage)
                .endAssertion();

    }

    @Then("tick the prompt for Generic Parts Selection box and Save")
    public void tick_the_prompt_for_Generic_Parts_Selection_box_and_Save() {
        systemSettingsPage.clickGenericParts();
        homePage.saveBtn();
    }

    @When("Search job and select {string} job for new quote")
    public void search_job_and_select_job_for_new_quote(String searchText) {
        gmCreateEstimatePage = new GMCreateEstimatePage(driver);
        gmCreateEstimatePage.selectBrakeFluid(searchText);
    }

    @Then("Navigate to {string} window and select fluid optional and continue")
    public void navigate_to_window_and_select_fluid_optional_and_continue(String title) {
        homePage.switchToSpecificWindow(title);
        gmCreateEstimatePage.selectFluidOptional();
        homePage.switchToSpecificWindow("JLR Menu Pricing");
    }

    @Then("Navigate to {string} verify fluid optional is displayed in job details")
    public void navigate_to_verify_fluid_optional_is_displayed_in_job_details(String jobDrilldownwindow) {
        gmCreateEstimatePage.clickOnJobDetailsIcon();
        homePage.switchToSpecificWindow(jobDrilldownwindow);
        gmCreateEstimatePage.startAssertions(GMCreateEstimatePageAssertion.class)
                .assertIfFluidOptionalPriceDisplayed()
                .endAssertion();
        driver.close();
        homePage.switchToSpecificWindow("JLR Menu Pricing");
    }

    @Then("{string} window not displayed")
    public void window_not_displayed(String ReplacementPart) {
      gmCreateEstimatePage.startAssertions(GMCreateEstimatePageAssertion.class)
              .assertIfSpecificWindowNotDisplayed(ReplacementPart)
              .endAssertion();
    }

    @Then("Navigate to {string} verify the fluid optional not added with job quote")
    public void navigate_to_verify_the_fluid_optional_not_added_with_job_quote(String jobDrilldownwindow) {
        gmCreateEstimatePage.clickOnJobDetailsIcon();
        homePage.switchToSpecificWindow(jobDrilldownwindow);
        gmCreateEstimatePage.startAssertions(GMCreateEstimatePageAssertion.class)
                .assertIfFluidOptionalPricenotDisplayed()
                .endAssertion();
        driver.close();
        homePage.switchToSpecificWindow("JLR Menu Pricing");
    }

    @Then("untick the prompt for Generic Parts Selection box and Save")
    public void untick_the_prompt_for_Generic_Parts_Selection_box_and_Save() {
        systemSettingsPage.uncheckGenericParts();
        homePage.saveBtn();
    }

    @After
    public void close() {
        super.close();
    }
}
