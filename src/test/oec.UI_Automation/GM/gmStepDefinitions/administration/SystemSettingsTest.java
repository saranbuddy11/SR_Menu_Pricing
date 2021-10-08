package GM.gmStepDefinitions.administration;

import GM.gmAssertion.GMCreateEstimatePageAssertion;
import GM.gmAssertion.HomePageAssertion;
import GM.gmAssertion.PartLaborDrillDownPageAssertion;
import GM.gmAssertion.administration.LaborPricingPageAssertion;
import GM.gmAssertion.administration.SystemSettingsPageAssertion;
import GM.gmAssertion.maintainEstimates.SearchEstimatePageAssertion;
import GM.gmObjectRepository.GMCreateEstimatePage;
import GM.gmObjectRepository.HomePage;
import GM.gmObjectRepository.PartLaborDrillDownPage;
import GM.gmObjectRepository.administration.BulkFluidsPage;
import GM.gmObjectRepository.administration.LaborPricingPage;
import GM.gmObjectRepository.administration.SystemSettingsPage;
import GM.gmObjectRepository.maintainEstimates.SearchEstimatePage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import model.BulkFluidLocalParts;
import model.LaborPriceTypes;
import stepDefinitions.AbstractTest;

import java.util.List;

public class SystemSettingsTest extends AbstractTest {

    @When("Open System Settings. Change the Labor Pricing Type to Single Labor Rate.")
    public void open_System_Settings_Change_the_Labor_Pricing_Type_to_Single_Labor_Rate() {
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
                .clickOnSaveBtn()
        ;
    }

    @Then("Labor Pricing Type is selected as {string}")
    public void labor_Pricing_Type_is_selected_as(String singleLaborRateType) {
        systemSettingsPage.startAssertions(SystemSettingsPageAssertion.class)
                .assertIfLaborPricingTypeIsSelectedAsExpected(singleLaborRateType)
                .endAssertion()
        ;
    }

    @When("Select the Labor Pricing tab and set the Labor Retail per hour value to {string}. Click Save.")
    public void select_the_Labor_Pricing_tab_and_set_the_Labor_Retail_per_hour_value_to_Click_Save(String laborRetailValue) {
        laborPricingPage = new LaborPricingPage(driver);
        laborPricingPage.openLaborPricingTab()
                .startAssertions(LaborPricingPageAssertion.class)
                .assertIfLaborPricingTab()
                .endAssertion()
                .enterLaborRetailHour(laborRetailValue)
                .clickOnSaveBtn()
        ;
    }

    @Then("New labour value {string} is saved.")
    public void new_labour_value_is_saved(String laborValue) {
        laborPricingPage.startAssertions(LaborPricingPageAssertion.class)
                .assertIfNewLabourValueIsSaved(laborValue)
                .endAssertion()
        ;
    }

    @When("Start a new Estimate with VIN {string} and add Job Service Add-On Cabin Filter Remove and Replace. Open the Job Details window of the job.")
    public void start_a_new_Estimate_with_VIN_and_add_Job_Service_Add_On_Cabin_Filter_Remove_and_Replace_Open_the_Job_Details_window_of_the_job(String vinNo) {
        homePage = new HomePage(driver);
        homePage.openCreateEstimateTab()
                .inputVIN(vinNo)
                .searchBtn();
        gmCreateEstimatePage = new GMCreateEstimatePage(driver);
        gmCreateEstimatePage.expandJobTreeInnerRow(2)
                .expandJobTreeSubInnerRow(7)
                .clickOnRemoveAndReplace()
                .clickOnMagnifyingGlassIcon(1)
        ;
    }

    @Then("Estimate is started and Job is added {string} to quote. Labour Price of job is {string}.")
    public void estimate_is_started_and_Job_is_added_to_quote_Labour_Price_of_job_is(String addedJob, String laborRetailPrice) {
        partLaborDrillDownPage = new PartLaborDrillDownPage(driver);
        partLaborDrillDownPage.switchToTab(2)
                .startAssertions(PartLaborDrillDownPageAssertion.class)
                .assertIfNewJobIsAddedToQuote(addedJob)
                .assertIfNewJobIsAddedToQuotePriceAsExpected(laborRetailPrice)
                .endAssertion()
                .clickOnContinueBtn()
                .switchToTab(1)
        ;
    }

    @When("Return to the Labor Pricing tab. Change Labour Retail per hour value to {string}. Click Save. Return to Estimate tab.")
    public void return_to_the_Labor_Pricing_tab_Change_Labour_Retail_per_hour_value_to_Click_Save_Return_to_Estimate_tab(String laborRetailPrice) {
        homePage = new HomePage(driver);
        homePage.openAdministrationTab();
        laborPricingPage = new LaborPricingPage(driver);
        laborPricingPage.openLaborPricingTab()
                .startAssertions(LaborPricingPageAssertion.class)
                .assertIfLaborPricingTab()
                .endAssertion()
                .enterLaborRetailHour(laborRetailPrice)
                .clickOnSaveBtn()
        ;
    }

    @Then("New labour value {string} is saved. Upon returning to the Quote tab a pop up message appears {string}")
    public void new_labour_value_is_saved_Upon_returning_to_the_Quote_tab_a_pop_up_message_appears(String laborValue, String warnMsg) {
        laborPricingPage.startAssertions(LaborPricingPageAssertion.class)
                .assertIfNewLabourValueIsSaved(laborValue)
                .endAssertion();
        homePage = new HomePage(driver);
        homePage.openCreateEstimateTab();
//        gmCreateEstimatePage = new GMCreateEstimatePage(driver);
//        gmCreateEstimatePage.startAssertions(GMCreateEstimatePageAssertion.class)
//                .assertIfWindowsWarningMsgDisplayed(warnMsg)
//                .endAssertion()
        ;
    }

    @When("Click OK on the pop up message.")
    public void click_OK_on_the_pop_up_message() {
        gmCreateEstimatePage = new GMCreateEstimatePage(driver);
        gmCreateEstimatePage.acceptAlertIfPresent(GMCreateEstimatePage.class);
    }

    @Then("The estimate is loaded again.")
    public void the_estimate_is_loaded_again() {
        gmCreateEstimatePage.startAssertions(GMCreateEstimatePageAssertion.class)
                .assertIfTheTreeIsExpanded()
                .endAssertion()
        ;
    }

    @When("Open the Job Details window again.")
    public void open_the_Job_Details_window_again() {
        gmCreateEstimatePage.clickOnMagnifyingGlassIcon(1);
    }

    @Then("Labour Price is job has changed to {string}. Enter labor retail Hour has {string}")
    public void labour_Price_is_job_has_changed_to_Enter_labor_retail_Hour_has(String laborRetailPrice, String retailHour) {
        partLaborDrillDownPage = new PartLaborDrillDownPage(driver);
        partLaborDrillDownPage.switchToTab(2)
                .startAssertions(PartLaborDrillDownPageAssertion.class)
                .assertIfNewJobIsAddedToQuotePriceAsExpected(laborRetailPrice)
                .endAssertion()
                .clickOnContinueBtn()
                .switchToTab(1);
        homePage.openAdministrationTab();
        laborPricingPage = new LaborPricingPage(driver);
        laborPricingPage.openLaborPricingTab()
                .enterLaborRetailHour(retailHour)
                .clickOnSaveBtn()
        ;
    }

    @When("Change the number of {string} days in the Estimate expiration days field. Create a new estimate and move to the Notes tab.")
    public void change_the_number_of_days_in_the_Estimate_expiration_days_field_Create_a_new_estimate_and_move_to_the_Notes_tab(String days) {
        systemSettingsPage = new SystemSettingsPage(driver);
        systemSettingsPage.openSystemSettingsTab()
                .enterEstimateExpiration(days)
                .clickOnSaveBtn();
        homePage = new HomePage(driver);
        homePage.openCreateEstimateTab();
        gmCreateEstimatePage = new GMCreateEstimatePage(driver);
        gmCreateEstimatePage.acceptAlertIfPresent(GMCreateEstimatePage.class);
        gmCreateEstimatePage.clickOnVehicleTab();
        homePage = new HomePage(driver);
        homePage.searchBtn()
                .acceptAlertIfPresent(HomePage.class);
        gmCreateEstimatePage = new GMCreateEstimatePage(driver);
        gmCreateEstimatePage.expandJobTreeInnerRow(2)
                .expandJobTreeSubInnerRow(7)
                .clickOnRemoveAndReplace()
                .clickOnContinueBtn()
        ;
    }

    @Then("Estimate valid until date is the number of days set in system settings.")
    public void estimate_valid_until_date_is_the_number_of_days_set_in_system_settings() {
        systemSettingsPage = new SystemSettingsPage(driver);
        systemSettingsPage.startAssertions(SystemSettingsPageAssertion.class)
                .assertIfEstimateValidUntilDateIsTheNumberOfDaysSetInSystemSettings()
                .endAssertion();
        homePage = new HomePage(driver);
        homePage.openAdministrationTab();
        systemSettingsPage = new SystemSettingsPage(driver);
        systemSettingsPage.openSystemSettingsTab()
                .enterEstimateExpiration("30")
                .clickOnSaveBtn()
        ;
    }

    @When("Enter some text into the Estimate Prefix {string} and Estimate Suffix {string} boxes and save. Create and print a new quote.")
    public void enter_some_text_into_the_Estimate_Prefix_and_Estimate_Suffix_boxes_and_save_Create_and_print_a_new_quote(String prefix, String suffix) {
        systemSettingsPage.enterEstimatePrefix(prefix)
                .enterEstimateSuffix(suffix)
                .clickOnSaveBtn();
        homePage = new HomePage(driver);
        homePage.openCreateEstimateTab()
                .continueBtnClick()
                .continueBtnClick()
                .clickOnSaveBtn();
        homePage.openAdministrationTab()
                .openMaintainEstimatesTab();
        searchEstimatePage = new SearchEstimatePage(driver);
        searchEstimatePage.enterFromDate(functionalLibrary.getCurrentDate())
                .clickOnSearchBtn()
        ;
    }

    @Then("The quote number is prefixed and suffixed by the text entered in system settings.")
    public void the_quote_number_is_prefixed_and_suffixed_by_the_text_entered_in_system_settings() {
        searchEstimatePage.startAssertions(SearchEstimatePageAssertion.class)
                .assertIfEstimateNumberIsPrefixedAndSuffixedByTheTextEnteredInSystemSettings()
                .endAssertion();
        homePage = new HomePage(driver);
        homePage.openAdministrationTab();
        systemSettingsPage = new SystemSettingsPage(driver);
        systemSettingsPage.openSystemSettingsTab()
                .enterEstimateSuffix("")
                .enterEstimatePrefix("")
                .clickOnSaveBtn()
        ;
    }

    @When("Tick the Prompt For Generic Parts Selection box and save. Add a new Local Generic Part for Brake Fluid. Create a new quote. Add Brake Fluid change job")
    public void tick_the_Prompt_For_Generic_Parts_Selection_box_and_save_Add_a_new_Local_Generic_Part_for_Brake_Fluid_Create_a_new_quote_Add_Brake_Fluid_change_job(io.cucumber.datatable.DataTable details) {
        List<String> data = details.asList();
        systemSettingsPage.selectAlwaysPromptJobLocalPartCheckBox()
                .clickOnSaveBtn();
        homePage = new HomePage(driver);
        homePage.openBulkFluidsTab();
        bulkFluidsPage = new BulkFluidsPage(driver);
        bulkFluidsPage.selectLocalPart(BulkFluidLocalParts.BrakeDOT3)
                .enterInput("quantity", data.get(0))
                .enterInput("description", data.get(1))
                .enterInput("partNumber", data.get(2))
                .enterInput("cost", data.get(3))
                .enterInput("price", data.get(4))
                .clickOnSaveBtn();
        homePage = new HomePage(driver);
        homePage.openCreateEstimateTab();
        homePage.inputVIN("1G1ZA5ST1HF190045")
                .searchBtn();
        gmCreateEstimatePage = new GMCreateEstimatePage(driver);
        gmCreateEstimatePage.expandJobTreeInnerRow(2)
                .expandJobTreeSubInnerRow(14)
                .clickOnBrakeFluid()
        ;
    }

    @Then("Setting saved. New part added. When job is added to quote the Parts & Labour window opens automatically giving user option to {string} Generic parts.")
    public void setting_saved_New_part_added_When_job_is_added_to_quote_the_Parts_Labour_window_opens_automatically_giving_user_option_to_Generic_parts(String replace) {
        gmCreateEstimatePage.switchToTab(2)
                .startAssertions(GMCreateEstimatePageAssertion.class)
                .assertIfWhenJobIsAddedToQuoteLabourNewWindowOpens(replace)
                .endAssertion();
        partLaborDrillDownPage = new PartLaborDrillDownPage(driver);
        partLaborDrillDownPage.clickOnContinueBtn()
                .switchToTab(1);
        homePage = new HomePage(driver);
        homePage.openAdministrationTab();
        systemSettingsPage = new SystemSettingsPage(driver);
        systemSettingsPage.openSystemSettingsTab()
                .selectAlwaysPromptJobLocalPartCheckBox()
                .clickOnSaveBtn();
        homePage = new HomePage(driver);
        homePage.openBulkFluidsTab();
        bulkFluidsPage = new BulkFluidsPage(driver);
        bulkFluidsPage.selectLocalPart(BulkFluidLocalParts.BrakeDOT3)
                .clickOnDeleteIcon();
        super.close();
    }
}