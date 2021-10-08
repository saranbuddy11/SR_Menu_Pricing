package GM.gmStepDefinitions.administration;

import GM.gmAssertion.GMCreateEstimatePageAssertion;
import GM.gmAssertion.HomePageAssertion;
import GM.gmAssertion.PartLaborDrillDownPageAssertion;
import GM.gmAssertion.administration.LaborPricingPageAssertion;
import GM.gmAssertion.administration.SystemSettingsPageAssertion;
import GM.gmAssertion.menuManager.MenuManagerPageAssertion;
import GM.gmObjectRepository.GMCreateEstimatePage;
import GM.gmObjectRepository.HomePage;
import GM.gmObjectRepository.PartLaborDrillDownPage;
import GM.gmObjectRepository.administration.LaborPricingPage;
import GM.gmObjectRepository.administration.SystemSettingsPage;
import GM.gmObjectRepository.menuManager.MenuManagerPage;
import base.FunctionalLibrary;
import io.cucumber.java.After;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import model.LaborPriceTypes;
import stepDefinitions.AbstractTest;

import java.util.Arrays;
import java.util.List;

import static base.FunctionalLibrary.getCurrentDate;

public class LaborPriceTest extends AbstractTest {

    @When("Select {string} from the System Settings Labor Pricing Type and Save. Open the Labor Pricing tab")
    public void select_from_the_System_Settings_Labor_Pricing_Type_and_Save_Open_the_Labor_Pricing_tab(String singleLaborRateType) {
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
                .assertIfLaborPricingTypeIsSelectedAsExpected(singleLaborRateType)
                .endAssertion();
        laborPricingPage = new LaborPricingPage(driver);
        laborPricingPage.openLaborPricingTab()
                .startAssertions(LaborPricingPageAssertion.class)
                .assertIfLaborPricingTab()
                .endAssertion()
        ;
    }

    @Then("Single Labor Rate is the default option")
    public void single_Labor_Rate_is_the_default_option() {
        laborPricingPage.startAssertions(LaborPricingPageAssertion.class)
                .assertAtSingleLaborRateTab()
                .endAssertion()
        ;
    }

    @When("Make sure in system Settings > Labor Pricing Type: Single Labor Rate is selected. In Labor Pricing  > Single Labor Rate set Labor Retail per hour as {string} . Add a job to Estimate for vin {string}")
    public void make_sure_in_system_Settings_Labor_Pricing_Type_Single_Labor_Rate_is_selected_In_Labor_Pricing_Single_Labor_Rate_set_Labor_Retail_per_hour_as_Add_a_job_to_Estimate_for_vin(String laborRetailValue, String vinNo) {
        laborPricingPage.enterLaborRetailHour(laborRetailValue)
                .clickOnSaveBtn()
                .startAssertions(LaborPricingPageAssertion.class)
                .assertIfNewLabourValueIsSaved(laborRetailValue)
                .endAssertion();
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

    @Then("Correct labor price is calculated in job {string}, {string}")
    public void correct_labor_price_is_calculated_in_job(String description, String price) {
        partLaborDrillDownPage = new PartLaborDrillDownPage(driver);
        partLaborDrillDownPage.switchToTab(2)
                .startAssertions(PartLaborDrillDownPageAssertion.class)
                .assertIfNewJobIsAddedToQuote(description)
                .assertIfNewJobIsAddedToQuotePriceAsExpected(price)
                .endAssertion()
                .clickOnContinueBtn()
                .switchToTab(1)
        ;
    }

    @When("Set Labor Retail per hour as {string}")
    public void set_Labor_Retail_per_hour_as(String laborRetailPrice) {
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

    @Then("Labour price correctly adjusted {string}")
    public void labour_price_correctly_adjusted(String laborRetailValue) {
        laborPricingPage.startAssertions(LaborPricingPageAssertion.class)
                .assertIfNewLabourValueIsSaved(laborRetailValue)
                .endAssertion()
        ;
    }

    @When("Add a job to quote, check labor price. Change Single Labor Rate value. Return to quote")
    public void add_a_job_to_quote_check_labor_price_Change_Single_Labor_Rate_value_Return_to_quote() {
        homePage = new HomePage(driver);
        homePage.openCreateEstimateTab()
                .acceptAlertIfPresent(HomePage.class);
        gmCreateEstimatePage = new GMCreateEstimatePage(driver);
        gmCreateEstimatePage.clickOnMagnifyingGlassIcon(1)
        ;
    }

    @Then("Labor price has changed to reflect new Single Labor Rate. {string}, {string}")
    public void labor_price_has_changed_to_reflect_new_Single_Labor_Rate(String description, String price) {
        partLaborDrillDownPage = new PartLaborDrillDownPage(driver);
        partLaborDrillDownPage.switchToTab(2)
                .startAssertions(PartLaborDrillDownPageAssertion.class)
                .assertIfNewJobIsAddedToQuote(description)
                .assertIfNewJobIsAddedToQuotePriceAsExpected(price)
                .endAssertion()
                .clickOnContinueBtn()
                .switchToTab(1)
        ;
    }

    @When("Select {string} from the System Settings > Labor Pricing Type and Save")
    public void select_from_the_System_Settings_Labor_Pricing_Type_and_Save(String laborPricingType) {
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
                .selectLaborPricingTypes(LaborPriceTypes.JobDifficulty)
                .clickOnSaveBtn();
        systemSettingsPage.startAssertions(SystemSettingsPageAssertion.class)
                .assertIfLaborPricingTypeIsSelectedAsExpected(laborPricingType)
                .endAssertion();
        laborPricingPage = new LaborPricingPage(driver);
        laborPricingPage.openLaborPricingTab()
                .startAssertions(LaborPricingPageAssertion.class)
                .assertIfLaborPricingTab()
                .endAssertion()
        ;
    }

    @Then("Job Difficulty is the default option,")
    public void job_Difficulty_is_the_default_option() {
        laborPricingPage.startAssertions(LaborPricingPageAssertion.class)
                .assertAtJobDifficultyTab()
                .endAssertion()
        ;
    }

    @When("Open the Job Difficulty tab. Click the Save button without entering any rates.")
    public void open_the_Job_Difficulty_tab_Click_the_Save_button_without_entering_any_rates() {
        laborPricingPage.clearAllRates()
                .clickOnSaveBtn();
    }

    @Then("User is advised they need to {string}.")
    public void user_is_advised_they_need_to(String warnMsg) {
        laborPricingPage.startAssertions(LaborPricingPageAssertion.class)
                .assertIfUserAdvisedTheyNeedToAddValues(warnMsg)
                .endAssertion()
                .clickOnCloseBtn()
        ;
    }

    @When("Open the Job Difficulty tab. Enter values in each Default box \\(Simple, Normal, Complex – Car, Truck, Van). Click Save.")
    public void open_the_Job_Difficulty_tab_Enter_values_in_each_Default_box_Simple_Normal_Complex_Car_Truck_Van_Click_Save(io.cucumber.datatable.DataTable dataTable) {
        List<String> rates = dataTable.asList();
        laborPricingPage.startAssertions(LaborPricingPageAssertion.class)
                .assertAtJobDifficultyTab()
                .endAssertion()
                .enterDefaultOptionVehicleRetailPrice(rates)
                .clickOnSaveBtn()
        ;
    }

    @Then("Rates are saved.")
    public void rates_are_saved(io.cucumber.datatable.DataTable dataTable) {
        List<String> rate = dataTable.asList();
        laborPricingPage.startAssertions(LaborPricingPageAssertion.class)
                .assertIfVehicleRatesAreSavedInDefaultOptionBox(rate)
                .endAssertion()
        ;
    }

    @When("Remove one of the default rate values and click Save")
    public void remove_one_of_the_default_rate_values_and_click_Save() {
        laborPricingPage.clearAllRates()
                .clickOnSaveBtn();

    }

    @When("Select {string} from the System Settings DD and Save. Open the Labor Pricing tab")
    public void select_from_the_System_Settings_DD_and_Save_Open_the_Labor_Pricing_tab(String laborPricingType) {
        systemSettingsPage = new SystemSettingsPage(driver);
        systemSettingsPage.openSystemSettingsTab()
                .startAssertions(SystemSettingsPageAssertion.class)
                .assertIfSystemSettingsTab()
                .endAssertion()
                .selectLaborPricingTypes(LaborPriceTypes.JobDifficulty)
                .clickOnSaveBtn();
        systemSettingsPage.startAssertions(SystemSettingsPageAssertion.class)
                .assertIfLaborPricingTypeIsSelectedAsExpected(laborPricingType)
                .endAssertion();
        laborPricingPage = new LaborPricingPage(driver);
        laborPricingPage.openLaborPricingTab()
        ;
    }

    @Then("Job Difficulty is the default tab.")
    public void job_Difficulty_is_the_default_tab() {
        laborPricingPage.startAssertions(LaborPricingPageAssertion.class)
                .assertIfLaborPricingTab()
                .endAssertion();
        homePage = new HomePage(driver);
        homePage.openCreateEstimateTab()
        ;
    }

    @When("Set default car {string} rates as: Simple: {int}, Normal: {int}, Complex: {int}.Start quote with a Car and add one job from each Difficulty group.")
    public void set_default_car_rates_as_Simple_Normal_Complex_Start_quote_with_a_Car_and_add_one_job_from_each_Difficulty_group(String vinNo, Integer simplePrice, Integer normalPrice, Integer complexPrice) {
        homePage = new HomePage(driver);
        homePage.inputVIN(vinNo)
                .searchBtn()
                .acceptAlertIfPresent(HomePage.class);
        gmCreateEstimatePage = new GMCreateEstimatePage(driver);
        gmCreateEstimatePage.expandJobTreeInnerRow(1)
                .expandJobTreeSubInnerRow(5)
                .clickOnOilReplacement();
        gmCreateEstimatePage = new GMCreateEstimatePage(driver);
        gmCreateEstimatePage.expandJobTreeInnerRow(12)
                .expandJobTreeSubInnerRow(38)
                .clickOnRemoveAndReplaceCoilSpring()
                .clickOnRemoveAndReplaceSpringCoilUpToModelYear();
        gmCreateEstimatePage = new GMCreateEstimatePage(driver);
        gmCreateEstimatePage.expandJobTreeInnerRow(8)
                .expandJobTreeSubInnerRow(32)
                .clickOnRemoveAndReplaceHeaterCore()
        ;
    }

    @Then("Simple job uses rate {int}, Normal job uses rate {int}, Complex job uses rate {int}")
    public void simple_job_uses_rate_Normal_job_uses_rate_Complex_job_uses_rate(Integer simplePrice, Integer normalPrice, Integer complexPrice, io.cucumber.datatable.DataTable dataTable) {
        List<String> LOC = dataTable.asList();
        gmCreateEstimatePage = new GMCreateEstimatePage(driver);
        gmCreateEstimatePage.clickOnMagnifyingGlassIcon(1)
                .switchToTab(2);
        partLaborDrillDownPage = new PartLaborDrillDownPage(driver);
        partLaborDrillDownPage.startAssertions(PartLaborDrillDownPageAssertion.class)
                .assertIfLabourPricingJobDifficultyApplied(simplePrice, LOC.get(0), 1)
                .endAssertion()
                .clickOnContinueBtn()
                .switchToTab(1);
        gmCreateEstimatePage = new GMCreateEstimatePage(driver);
        gmCreateEstimatePage.clickOnMagnifyingGlassIcon(2)
                .switchToTab(2);
        partLaborDrillDownPage = new PartLaborDrillDownPage(driver);
        partLaborDrillDownPage.startAssertions(PartLaborDrillDownPageAssertion.class)
                .assertIfLabourPricingJobDifficultyApplied(normalPrice, LOC.get(1), 1)
                .endAssertion()
                .clickOnContinueBtn()
                .switchToTab(1);
        gmCreateEstimatePage = new GMCreateEstimatePage(driver);
        gmCreateEstimatePage.clickOnMagnifyingGlassIcon(3)
                .switchToTab(2);
        partLaborDrillDownPage = new PartLaborDrillDownPage(driver);
        partLaborDrillDownPage.startAssertions(PartLaborDrillDownPageAssertion.class)
                .assertIfLabourPricingJobDifficultyApplied(complexPrice, LOC.get(2), 1)
                .endAssertion()
                .clickOnContinueBtn()
                .switchToTab(1);
        gmCreateEstimatePage = new GMCreateEstimatePage(driver);
        gmCreateEstimatePage.clickOnVehicleTab()
        ;
    }

    @Then("Simple job uses rate {int}, Normal job uses rate {int}, Complex job uses rates {int}")
    public void simple_job_uses_rate_Normal_job_uses_rate_Complex_job_uses_rates(Integer simplePrice, Integer normalPrice, Integer complexPrice, io.cucumber.datatable.DataTable dataTable) {
        List<String> LOC = dataTable.asList();
        String LOCNo = "";
        if (environment.contains("uat")) {
            LOCNo = LOC.get(1);
        } else if (environment.contains("qa")) {
            LOCNo = LOC.get(3);
        }
        gmCreateEstimatePage = new GMCreateEstimatePage(driver);
        gmCreateEstimatePage.clickOnMagnifyingGlassIcon(1)
                .switchToTab(2);
        partLaborDrillDownPage = new PartLaborDrillDownPage(driver);
        partLaborDrillDownPage.startAssertions(PartLaborDrillDownPageAssertion.class)
                .assertIfLabourPricingJobDifficultyApplied(simplePrice, LOC.get(0), 1)
                .endAssertion()
                .clickOnContinueBtn()
                .switchToTab(1);
        gmCreateEstimatePage = new GMCreateEstimatePage(driver);
        gmCreateEstimatePage.clickOnMagnifyingGlassIcon(2)
                .switchToTab(2);
        partLaborDrillDownPage = new PartLaborDrillDownPage(driver);
        partLaborDrillDownPage.startAssertions(PartLaborDrillDownPageAssertion.class)
                .assertIfLabourPricingJobDifficultyApplied(normalPrice, LOCNo, 1)
                .endAssertion()
                .clickOnContinueBtn()
                .switchToTab(1);
        gmCreateEstimatePage = new GMCreateEstimatePage(driver);
        gmCreateEstimatePage.clickOnMagnifyingGlassIcon(3)
                .switchToTab(2);
        partLaborDrillDownPage = new PartLaborDrillDownPage(driver);
        partLaborDrillDownPage.startAssertions(PartLaborDrillDownPageAssertion.class)
                .assertIfLabourPricingJobDifficultyApplied(complexPrice, LOC.get(2), 1)
                .endAssertion()
                .clickOnContinueBtn()
                .switchToTab(1);
        gmCreateEstimatePage = new GMCreateEstimatePage(driver);
        gmCreateEstimatePage.clickOnVehicleTab()
        ;
    }

    @When("Set default truck {string} rates as: Simple: {int}, Normal: {int}, Complex: {int}.Start quote with a Car and add one job from each Difficulty group.")
    public void set_default_truck_rates_as_Simple_Normal_Complex_Start_quote_with_a_Car_and_add_one_job_from_each_Difficulty_group(String vinNo, Integer simplePrice, Integer normalPrice, Integer complexPrice) {
        homePage = new HomePage(driver);
        homePage.openCreateEstimateTab()
                .inputVIN(vinNo)
                .searchBtn()
                .acceptAlertIfPresent(HomePage.class);
        gmCreateEstimatePage = new GMCreateEstimatePage(driver);
        gmCreateEstimatePage.expandJobTreeInnerRow(1)
                .expandJobTreeSubInnerRow(5)
                .clickOnOilReplacement();
        gmCreateEstimatePage = new GMCreateEstimatePage(driver);
        gmCreateEstimatePage.expandJobTreeInnerRow(14)
                .expandJobTreeSubInnerRow(41)
                .clickOnTruckRemoveAndReplaceCoilSpring();
        gmCreateEstimatePage = new GMCreateEstimatePage(driver);
        gmCreateEstimatePage.expandJobTreeInnerRow(10)
                .expandJobTreeSubInnerRow(35)
                .clickOnTruckRemoveAndReplaceHeaterCore()
        ;
    }

    @When("Set default van {string} rates as: Simple: {int}, Normal: {int}, Complex: {int}.Start quote with a Car and add one job from each Difficulty group.")
    public void set_default_van_rates_as_Simple_Normal_Complex_Start_quote_with_a_Car_and_add_one_job_from_each_Difficulty_group(String vinNo, Integer simplePrice, Integer normalPrice, Integer complexPrice) {
        homePage = new HomePage(driver);
        homePage.openCreateEstimateTab()
                .inputVIN(vinNo)
                .searchBtn()
                .acceptAlertIfPresent(HomePage.class);
        gmCreateEstimatePage = new GMCreateEstimatePage(driver);
        gmCreateEstimatePage.expandJobTreeInnerRow(1)
                .expandJobTreeSubInnerRow(5)
                .clickOnLeafLevelThree(40);
        gmCreateEstimatePage = new GMCreateEstimatePage(driver);
        gmCreateEstimatePage.expandJobTreeInnerRow(13)
                .expandJobTreeSubInnerRow(42) //43
                .expandJobTreeLevelThreeInner(environment, 62, 60)
                .clickOnVanRemoveAndReplaceCoilSpring(environment, 1, 7); //1
        gmCreateEstimatePage = new GMCreateEstimatePage(driver);
        gmCreateEstimatePage.expandJobTreeInnerRow(9)
                .expandJobTreeSubInnerRow(35)//36
                .expandJobTreeLevelThreeInner(environment, 48, 47)
                .clickOnRearHeater(environment, 5, 5)
        ;
    }

    @When("Expand the Car, Truck, Van lists on the Job Difficulty tab.")
    public void expand_the_Car_Truck_Van_lists_on_the_Job_Difficulty_tab() {
        homePage = new HomePage(driver);
        homePage.openAdministrationTab();
        laborPricingPage = new LaborPricingPage(driver);
        laborPricingPage.openLaborPricingTab()
                .startAssertions(LaborPricingPageAssertion.class)
                .assertAtJobDifficultyTab()
                .endAssertion()
                .clickOnVehicleTextLink(4)
                .clickOnVehicleTextLink(5)
                .clickOnVehicleTextLink(6)
        ;
    }

    @Then("Models are sorted in alphabetical order by Brand and by Model under each vehicle type")
    public void models_are_sorted_in_alphabetical_order_by_Brand_and_by_Model_under_each_vehicle_type() {
        laborPricingPage.startAssertions(LaborPricingPageAssertion.class)
                .assertIfModelsAreSortedInAlphabetical("26")
                .assertIfModelsAreSortedInAlphabetical("27")
                .assertIfModelsAreSortedInAlphabetical("36")
                .endAssertion()
        ;
    }

    @When("Set rates for a specific Car model: i.e. {string} as Simple: {int}, Normal: {int}, Complex: {int}.")
    public void set_rates_for_a_specific_car_model_i_e_as_Simple_Normal_Complex(String vehicleModel, Integer simplePrice, Integer normalPrice, Integer complexPrice) {
        List<Integer> price = Arrays.asList(simplePrice, normalPrice, complexPrice);
        laborPricingPage.enterModelVehicleRetailPrice(vehicleModel, price)
                .clickOnSaveBtn();
        homePage = new HomePage(driver);
        homePage.openCreateEstimateTab();
        gmCreateEstimatePage = new GMCreateEstimatePage(driver);
        gmCreateEstimatePage.clickOnVehicleTab();

    }

    @When("Set rates for a specific truck model: i.e. {string} as Simple: {int}, Normal: {int}, Complex: {int}.")
    public void set_rates_for_a_specific_truck_model_i_e_as_Simple_Normal_Complex(String vehicleModel, Integer simplePrice, Integer normalPrice, Integer complexPrice) {
        List<Integer> price = Arrays.asList(simplePrice, normalPrice, complexPrice);
        laborPricingPage.enterModelVehicleRetailPrice(vehicleModel, price)
                .clickOnSaveBtn();
        homePage = new HomePage(driver);
        homePage.openCreateEstimateTab();
        gmCreateEstimatePage = new GMCreateEstimatePage(driver);
        gmCreateEstimatePage.clickOnVehicleTab();

    }

    @When("Set rates for a specific van model: i.e. {string} as Simple: {int}, Normal: {int}, Complex: {int}.")
    public void set_rates_for_a_specific_van_model_i_e_as_Simple_Normal_Complex(String vehicleModel, Integer simplePrice, Integer normalPrice, Integer complexPrice) {
        List<Integer> price = Arrays.asList(simplePrice, normalPrice, complexPrice);
        laborPricingPage.enterModelVehicleRetailPrice(vehicleModel, price)
                .clickOnSaveBtn();
        homePage = new HomePage(driver);
        homePage.openCreateEstimateTab();
        gmCreateEstimatePage = new GMCreateEstimatePage(driver);
        gmCreateEstimatePage.clickOnVehicleTab();

    }

    @Then("Clear the vehicle rental prices.")
    public void clear_the_vehicle_rental_prices(io.cucumber.datatable.DataTable dataTable) {
        List<String> data = dataTable.asList();
        homePage = new HomePage(driver);
        homePage.openAdministrationTab();
        laborPricingPage = new LaborPricingPage(driver);
        laborPricingPage.openLaborPricingTab()
                .clickOnVehicleTextLink(4)
                .clickOnVehicleTextLink(5)
                .clickOnVehicleTextLink(6)
                .clearModelVehicleRetailPrice(data.get(0))
                .clearModelVehicleRetailPrice(data.get(1))
                .clearModelVehicleRetailPrice(data.get(2))
                .clickOnSaveBtn();
        systemSettingsPage.openSystemSettingsTab()
                .selectLaborPricingTypes(LaborPriceTypes.SingleLaborRate)
                .clickOnSaveBtn();
        ;
    }

    @When("Select Labor Matrix from the System Settings > Labor Pricing Type and Save. Open the Labor Pricing tab")
    public void select_Labor_Matrix_from_the_System_Settings_Labor_Pricing_Type_and_Save_Open_the_Labor_Pricing_tab() {
        super.setUp();
        homePage = functionalLibrary.gmLogIn(environment, configuration, HomePage.class);
        homePage.startAssertions(HomePageAssertion.class)
                .assertAtHomePage()
                .endAssertion()
                .openAdministrationTab();
        laborPricingPage = new LaborPricingPage(driver);
        laborPricingPage.openLaborPricingTab()
                .clickLabourMatrix()
                .enterPopulateEmptyCellsValue("10")
                .clickBasedOnName("populateEmptyCellsButton")
                .clickOnSaveBtn();
        systemSettingsPage = new SystemSettingsPage(driver);
        systemSettingsPage.openSystemSettingsTab()
                .startAssertions(SystemSettingsPageAssertion.class)
                .assertIfSystemSettingsTab()
                .endAssertion()
                .selectLaborPricingTypes(LaborPriceTypes.LaborMatrix)
                .clickOnSaveBtn();
        systemSettingsPage.startAssertions(SystemSettingsPageAssertion.class)
                .assertIfLaborPricingTypeIsSelectedAsExpected("Labor Matrix")
                .endAssertion();
        laborPricingPage = new LaborPricingPage(driver);
        laborPricingPage.openLaborPricingTab()
                .startAssertions(LaborPricingPageAssertion.class)
                .assertIfLaborPricingTab()
                .endAssertion()
        ;

    }

    @Then("Labor matrix is the default option")
    public void labor_matrix_is_the_default_option() {
        laborPricingPage.startAssertions(LaborPricingPageAssertion.class)
                .assertAtLaborMatrixTab()
                .endAssertion()
        ;
    }

    @When("Enter a value {string} in the Populate empty cells field and click Add.")
    public void enter_a_value_in_the_Populate_empty_cells_field_and_click_Add(String value) {
        laborPricingPage.enterPopulateEmptyCellsValue(value)
                .clickBasedOnName("populateEmptyCellsButton")
                .clickOnSaveBtn()
        ;
    }

    @Then("All empty cells are populated with the value.")
    public void all_empty_cells_are_populated_with_the_value() {
        laborPricingPage.startAssertions(LaborPricingPageAssertion.class)
                .assertIfAllEmptyCellsArePopulatedWithTheValue()
                .endAssertion()
        ;
    }

    @When("Create a Estimate for vin {string}, add job, check labour time.")
    public void create_a_Estimate_for_vin_add_job_check_labour_time(String vinNo) {
        homePage = new HomePage(driver);
        homePage.openCreateEstimateTab()
                .inputVIN(vinNo)
                .searchBtn();
        gmCreateEstimatePage = new GMCreateEstimatePage(driver);
        gmCreateEstimatePage.expandJobTreeInnerRow(2)
                .expandJobTreeSubInnerRow(7)
                .clickOnRemoveAndReplace()
                .clickOnMagnifyingGlassIcon(1)
                .switchToTab(2)
        ;
    }

    @Then("The Labor Matrix rate for the labor time is used in the job")
    public void the_Labor_Matrix_rate_for_the_labor_time_is_used_in_the_job(io.cucumber.datatable.DataTable dataTable) {
        List<String> data = dataTable.asList();
        int price = Integer.parseInt(data.get(0));
        int index = Integer.parseInt(data.get(2));
        partLaborDrillDownPage = new PartLaborDrillDownPage(driver);
        partLaborDrillDownPage.startAssertions(PartLaborDrillDownPageAssertion.class)
                .assertIfLabourPricingJobDifficultyApplied(price, data.get(1), index)
                .endAssertion()
                .clickOnContinueBtn()
                .switchToTab(1)
        ;
    }

    @When("Click on the Calculated Price view option.")
    public void click_on_the_Calculated_Price_view_option() {
        homePage = new HomePage(driver);
        homePage.openAdministrationTab();
        laborPricingPage = new LaborPricingPage(driver);
        laborPricingPage.openLaborPricingTab()
                .startAssertions(LaborPricingPageAssertion.class)
                .assertAtLaborMatrixTab()
                .endAssertion()
                .selectViewTypeRadioBtn(4)
        ;
    }

    @Then("All rates are converted into a Price and prices are calculated correctly.")
    public void all_rates_are_converted_into_a_Price_and_prices_are_calculated_correctly() {
        laborPricingPage.startAssertions(LaborPricingPageAssertion.class)
                .assertIfAllRatesAreConvertedIntoPrice(10)
                .endAssertion()
        ;
    }

    @When("Click on the Exception matrix option.")
    public void click_on_the_Exception_matrix_option() {
        laborPricingPage.selectViewTypeRadioBtn(2);
    }

    @Then("Cells are changed to Exception view and the job Content Search is populated with the job hierarchy.")
    public void cells_are_changed_to_Exception_view_and_the_job_Content_Search_is_populated_with_the_job_hierarchy() {
        laborPricingPage.startAssertions(LaborPricingPageAssertion.class)
                .assertIfJobContentSearchIsPopulatedWithTheJobHierarchy()
                .endAssertion();
        gmCreateEstimatePage = new GMCreateEstimatePage(driver);
        gmCreateEstimatePage.expandJobTreeInnerRow(1)
                .expandJobTreeSubInnerRow(5)
                .clickOnEngineOilAndFilterReplace()
        ;
    }

    @Then("Oil change --> Engine Oil and Oil Filter Replacement is selected as an Exception and is highlighted Red")
    public void oil_change_Engine_Oil_and_Oil_Filter_Replacement_is_selected_as_an_Exception_and_is_highlighted_Red(io.cucumber.datatable.DataTable dataTable) {
        List<String> data = dataTable.asList();
        gmCreateEstimatePage.startAssertions(GMCreateEstimatePageAssertion.class)
                .assertIfJobHighlightedWithColor(data.get(0), data.get(1))
                .endAssertion()
        ;
    }

    @When("Enter a rate for {double} and Save. Drill down the Scheduled Maintenance hierarchy.")
    public void enter_a_rate_for_and_Save_Drill_down_the_Scheduled_Maintenance_hierarchy(Double double1) {
        laborPricingPage = new LaborPricingPage(driver);
        laborPricingPage.enterLaborRateFormated3Value("100")
                .clickOnSaveBtn();
    }

    @Then("The {int} levels above job are Yellow and the job is Green after refresh")
    public void the_levels_above_job_are_Yellow_and_the_job_is_Green_after_refresh(Integer int1, io.cucumber.datatable.DataTable dataTable) {
        List<String> result = dataTable.asList();
        laborPricingPage.refresh();
        laborPricingPage.selectViewTypeRadioBtn(2);
        gmCreateEstimatePage = new GMCreateEstimatePage(driver);
        gmCreateEstimatePage.expandJobTreeInnerRow(1)
                .expandJobTreeSubInnerRow(5)
                .startAssertions(GMCreateEstimatePageAssertion.class)
                .assertIfJobHighLevelHighlightedWithColor(result)
                .endAssertion()
        ;
    }

    @When("Start quote for VIN {string} and add job Scheduled Maintenance --> Oil change --> Engine Oil and Oil Filter Replacement")
    public void start_quote_for_VIN_and_add_job_Scheduled_Maintenance_Oil_change_Engine_Oil_and_Oil_Filter_Replacement(String vinNo) {
        homePage = new HomePage(driver);
        homePage.openCreateEstimateTab();
        gmCreateEstimatePage = new GMCreateEstimatePage(driver);
        gmCreateEstimatePage.clickOnVehicleTab();
        homePage = new HomePage(driver);
        homePage.inputVIN(vinNo)
                .searchBtn()
                .acceptAlertIfPresent(HomePage.class);
        gmCreateEstimatePage = new GMCreateEstimatePage(driver);
        gmCreateEstimatePage.expandJobTreeInnerRow(1)
                .expandJobTreeSubInnerRow(5)
                .clickOnLeafLevelThree(40)
                .clickOnMagnifyingGlassIcon(1)
                .switchToTab(2)
        ;
    }

    @Then("The Exception rate is used for this job")
    public void the_Exception_rate_is_used_for_this_job() {
        partLaborDrillDownPage = new PartLaborDrillDownPage(driver);
        partLaborDrillDownPage.startAssertions(PartLaborDrillDownPageAssertion.class)
                .assertIfLabourPricingJobDifficultyApplied(100, "0669040", 1)
                .endAssertion()
                .clickOnContinueBtn()
                .switchToTab(1);
    }

    @When("Open the Exception in the matrix and click the ‘Calculated Price’ view option.")
    public void open_the_Exception_in_the_matrix_and_click_the_Calculated_Price_view_option() {
        homePage = new HomePage(driver);
        homePage.openAdministrationTab();
        laborPricingPage = new LaborPricingPage(driver);
        laborPricingPage.openLaborPricingTab()
                .startAssertions(LaborPricingPageAssertion.class)
                .assertIfLaborPricingTab()
                .assertAtLaborMatrixTab()
                .endAssertion()
                .selectViewTypeRadioBtn(2);
        gmCreateEstimatePage = new GMCreateEstimatePage(driver);
        gmCreateEstimatePage.expandJobTreeInnerRow(1)
                .expandJobTreeSubInnerRow(5)
                .clickOnEngineOilAndFilterReplace();
        laborPricingPage = new LaborPricingPage(driver);
        laborPricingPage.selectViewTypeRadioBtn(4);

    }

    @Then("The rate is converted into a Price and is calculated correctly. Tick boxes are disabled.")
    public void the_rate_is_converted_into_a_Price_and_is_calculated_correctly_Tick_boxes_are_disabled() {
        laborPricingPage.startAssertions(LaborPricingPageAssertion.class)
                .assertIfTheRateIsConvertedIntoAPriceAndTickBoxesAreDisabled(100.00f)
                .endAssertion()
        ;
    }

    @When("Click the ‘Labour Rate’ view option. ‘Tick’ the box where the Exception rate is and click Delete")
    public void click_the_Labour_Rate_view_option_Tick_the_box_where_the_Exception_rate_is_and_click_Delete() {
        laborPricingPage.selectViewTypeRadioBtn(3)
                .clickOnMatrixCheckBox(1)
                .clickOnMatrixDeleteBtn()
                .acceptAlertIfPresent(FunctionalLibrary.class);
        laborPricingPage.refresh()
        ;
    }

    @Then("Exception rate is deleted and the hierarchy colours are removed")
    public void exception_rate_is_deleted_and_the_hierarchy_colours_are_removed(io.cucumber.datatable.DataTable dataTable) {
        List<String> result = dataTable.asList();
        laborPricingPage.selectViewTypeRadioBtn(2)
                .startAssertions(LaborPricingPageAssertion.class)
                .assertIfExceptionRateIsDeleted()
                .endAssertion();
        gmCreateEstimatePage = new GMCreateEstimatePage(driver);
        gmCreateEstimatePage.startAssertions(GMCreateEstimatePageAssertion.class)
                .assertIfJobHighLevel2HighlightedWithColorRemoved(result)
                .endAssertion()
        ;
    }

    @When("Create an Exception rate for the top level of a hierarchy group")
    public void create_an_Exception_rate_for_the_top_level_of_a_hierarchy_group() {
        gmCreateEstimatePage.clickOnBodySystems();
        laborPricingPage = new LaborPricingPage(driver);
        laborPricingPage.enterLaborRateFormated9Value("100")
                .clickOnSaveBtn()
                .refresh()
        ;
    }

    @Then("Only the top level i.e. Body Systems is coloured Green")
    public void only_the_top_level_i_e_Body_Systems_is_coloured_Green(io.cucumber.datatable.DataTable dataTable) {
        List<String> result = dataTable.asList();
        laborPricingPage = new LaborPricingPage(driver);
        laborPricingPage.selectViewTypeRadioBtn(2);
        gmCreateEstimatePage = new GMCreateEstimatePage(driver);
        gmCreateEstimatePage.startAssertions(GMCreateEstimatePageAssertion.class)
                .assertIfJobHighLevel1HighlightedWithColor(result)
                .endAssertion()
        ;
    }

    @When("Start quote, add job, change Labor Pricing Type in System Settings. {string}")
    public void start_quote_add_job_change_Labor_Pricing_Type_in_System_Settings(String vinNo) {
        homePage = new HomePage(driver);
        homePage.openCreateEstimateTab()
                .acceptAlertIfPresent(HomePage.class);
        gmCreateEstimatePage = new GMCreateEstimatePage(driver);
        gmCreateEstimatePage.clickOnVehicleTab();
        homePage = new HomePage(driver);
        homePage.inputVIN(vinNo)
                .searchBtn()
                .acceptAlertIfPresent(HomePage.class);
        gmCreateEstimatePage = new GMCreateEstimatePage(driver);
        gmCreateEstimatePage.expandJobTreeInnerRow(5)
                .expandJobTreeSubInnerRow(20)
                .clickOnRemoveAndReplaceHeatCore() //10
                .clickOnLevelFourJob(4)
                .clickOnMagnifyingGlassIcon(1)
                .switchToTab(2)
        ;

    }

    @Then("Labor price has changed to reflect new Labor Pricing Type")
    public void labor_price_has_changed_to_reflect_new_Labor_Pricing_Type() {
        partLaborDrillDownPage = new PartLaborDrillDownPage(driver);
        partLaborDrillDownPage.startAssertions(PartLaborDrillDownPageAssertion.class)
                .assertIfLabourPricingJobDifficultyApplied(100, "2030030", 1)
                .endAssertion()
                .clickOnContinueBtn()
                .switchToTab(1);
        homePage = new HomePage(driver);
        homePage.openAdministrationTab();
        laborPricingPage = new LaborPricingPage(driver);
        laborPricingPage.openLaborPricingTab();
        laborPricingPage.selectViewTypeRadioBtn(3)
                .clickOnMatrixCheckBox(1)
                .clickOnMatrixDeleteBtn()
                .acceptAlertIfPresent(FunctionalLibrary.class);
        laborPricingPage.refresh();
        systemSettingsPage = new SystemSettingsPage(driver);
        systemSettingsPage.openSystemSettingsTab()
                .acceptAlertIfPresent(FunctionalLibrary.class);
        systemSettingsPage.selectLaborPricingTypes(LaborPriceTypes.SingleLaborRate)
                .clickOnSaveBtn()
        ;
    }

    @When("Select Single Labor Rate from the System Settings Labor Pricing Type and Save. Open the Labor Pricing tab")
    public void select_Single_Labor_Rate_from_the_System_Settings_Labor_Pricing_Type_and_Save_Open_the_Labor_Pricing_tab() {
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
        laborPricingPage = new LaborPricingPage(driver);
        laborPricingPage.openLaborPricingTab()
                .startAssertions(LaborPricingPageAssertion.class)
                .assertIfLaborPricingTab()
                .endAssertion()
        ;
    }

    @When("Set up menu manager rule against a job with Labor Pricing using effects: Adjust total labor price exc. Tax Set labor rate excl tax Set any labor time to")
    public void set_up_menu_manager_rule_against_a_job_with_Labor_Pricing_using_effects_Adjust_total_labor_price_exc_Tax_Set_labor_rate_excl_tax_Set_any_labor_time_to(io.cucumber.datatable.DataTable dataTable) {
        List<String> data = dataTable.asList();
        homePage = new HomePage(driver);
        homePage.openMenuManagerTab();
        menuManagerPage = new MenuManagerPage(driver);
        menuManagerPage.startAssertions(MenuManagerPageAssertion.class)
                .assertAtListRulesTab()
                .endAssertion()
                .clickBasedOnName("createNewRule")
                .sendKeysBasedOnName(data.get(2), data.get(0))
                .sendKeysForTextAreaBasedOnName(data.get(3), data.get(1))
                .sendKeysForTextAreaBasedOnName(data.get(4), data.get(1))
                .sendKeysBasedOnName(data.get(5), getCurrentDate())
                .sendKeysBasedOnName(data.get(6), FunctionalLibrary.getFutureDay(2))
                .clickOnSaveBtn();
        menuManagerPage.openRuleStructureTab()
                .startAssertions(MenuManagerPageAssertion.class)
                .assertAtRuleStructureTab()
                .endAssertion()
                .clickOnChevroletMake()
                .clickOnMagnifierIcon();
        gmCreateEstimatePage = new GMCreateEstimatePage(driver);
        gmCreateEstimatePage.expandJobTreeInnerRowBasedOnIndex(2)
                .expandJobTreeSubInnerRow(7)
                .doubleClickOnRemoveAndReplace()
                .doubleClickOnRemoveAndReplace();
        menuManagerPage = new MenuManagerPage(driver);
        menuManagerPage.sendKeysEffectEntry("SeleniumTesting", 0)
                .clickOnAddIcon(1)
                .setTotalPrice()
                .sendKeysEffectEntry("100", 1)
                .clickOnAddIcon(2)
                .setLaborRate()
                .sendKeysEffectEntry("200", 2)
                .clickOnAddIcon(3)
                .setLaborTime()
                .sendKeysEffectEntry("300", 3)
                .clickOnRuleStructureSaveBtn()
                .openListRulesTab()
                .clickBasedOnName("deploy");
        HomePage homePage = new HomePage(driver);
        homePage.openCreateEstimateTab()
        ;
    }

    @Then("Menu manager rules take precedence over the Labor Pricing Single Labor Rate {string},{string}")
    public void menu_manager_rules_take_precedence_over_the_Labor_Pricing_Single_Labor_Rate(String vinNo, String value) {
        homePage = new HomePage(driver);
        homePage.openCreateEstimateTab()
                .inputVIN(vinNo)
                .searchBtn();
        gmCreateEstimatePage = new GMCreateEstimatePage(driver);
        gmCreateEstimatePage.expandJobTreeInnerRow(2)
                .expandJobTreeSubInnerRow(7)
                .clickOnMenuManagerRemoveAndReplaceJob()
                .startAssertions(GMCreateEstimatePageAssertion.class)
                .assertIfMenuManagerRulesTakePrecedenceOverTheLaborPricing(value)
                .endAssertion()
                .clickOnMagnifyingGlassIcon(1)
                .switchToTab(2);
        partLaborDrillDownPage = new PartLaborDrillDownPage(driver);
        partLaborDrillDownPage.startAssertions(PartLaborDrillDownPageAssertion.class)
                .assertIfLabourPricingTimeDisplayedAsSetInMenuManager(300f, "0665010", 1)
                .endAssertion()
                .clickOnContinueBtn()
                .switchToTab(1);
        gmCreateEstimatePage = new GMCreateEstimatePage(driver);
        gmCreateEstimatePage.clickOnDeleteIcon(1)
        ;
    }

    @Then("Select Single Labor Rate from the System Settings > Labor Pricing Type and Save")
    public void select_Single_Labor_Rate_from_the_System_Settings_Labor_Pricing_Type_and_Save() {
        homePage = new HomePage(driver);
        homePage.openMenuManagerTab()
                .openAdministrationTab();
        systemSettingsPage = new SystemSettingsPage(driver);
        systemSettingsPage.openSystemSettingsTab()
                .selectLaborPricingTypes(LaborPriceTypes.SingleLaborRate)
                .clickOnSaveBtn();
        super.close()
        ;
    }

    @After
    public void close() {
        super.close();
    }
}
