package GM.gmStepDefinitions.menuManager;

import GM.gmAssertion.GMCreateEstimatePageAssertion;
import GM.gmAssertion.HomePageAssertion;
import GM.gmAssertion.menuManager.MenuManagerPageAssertion;
import GM.gmObjectRepository.GMCreateEstimateNotesPage;
import GM.gmObjectRepository.GMCreateEstimatePage;
import GM.gmObjectRepository.HomePage;
import GM.gmObjectRepository.menuManager.MenuManagerPage;
import base.FunctionalLibrary;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import stepDefinitions.AbstractTest;

import java.util.List;

import static base.FunctionalLibrary.getCurrentDate;

public class MenuManagerRuleTest extends AbstractTest {
    @When("Hit Create Rule")
    public void hit_Create_Rule() {
        super.setUp();
        homePage = functionalLibrary.gmLogIn(environment, configuration, HomePage.class);
        homePage.startAssertions(HomePageAssertion.class)
                .assertAtHomePage()
                .endAssertion()
                .openMenuManagerTab()
                .clickBasedOnName("createNewRule")
        ;
    }

    @Then("The results pulled back depend on the range entered")
    public void the_results_pulled_back_depend_on_the_range_entered() {
        menuManagerPage = new MenuManagerPage(driver);
        menuManagerPage.startAssertions(MenuManagerPageAssertion.class)
                .assertAtRuleBasicsTab()
                .endAssertion()
        ;
    }

    @When("Enter a name to identify the rule, insert a description and disclaimer along with a valid date range, hit {string}")
    public void enter_a_name_to_identify_the_rule_insert_a_description_and_disclaimer_along_with_a_valid_date_range_hit(String btn, io.cucumber.datatable.DataTable dataTable) {
        List<String> data = dataTable.asList();
        menuManagerPage = new MenuManagerPage(driver);
        menuManagerPage.startAssertions(MenuManagerPageAssertion.class)
                .assertAtRuleBasicsTab()
                .endAssertion()
                .sendKeysBasedOnName(data.get(2), data.get(0))
                .clickBasedOnName("overwriteManufacturerMenu")
                .sendKeysForTextAreaBasedOnName(data.get(3), data.get(1))
                .sendKeysForTextAreaBasedOnName(data.get(4), data.get(1))
                .sendKeysBasedOnName(data.get(5), FunctionalLibrary.getCurrentDate())
                .sendKeysBasedOnName(data.get(6), FunctionalLibrary.getFutureDay(2))
                .clickBasedOnName(btn)
                .acceptAlertIfPresent(MenuManagerPage.class)
        ;
    }

    @Then("Any input is lost, and the user is taken back to the List Rules screen")
    public void any_input_is_lost_and_the_user_is_taken_back_to_the_List_Rules_screen() {
        menuManagerPage.startAssertions(MenuManagerPageAssertion.class)
                .assertAtListRulesTab()
                .endAssertion()
                .clickBasedOnName("createNewRule")
        ;
    }

    @Then("Any input is lost, and the rule is deleted. User taken back to the list rules screen")
    public void any_input_is_lost_and_the_rule_is_deleted_User_taken_back_to_the_list_rules_screen() {
        menuManagerPage.startAssertions(MenuManagerPageAssertion.class)
                .assertAtListRulesTab()
                .endAssertion()
                .clickBasedOnName("createNewRule")
        ;
    }

    @Then("The input is kept, and the rule is copied \\(rule name would have COPY OF). The user stays on the rule basics screen")
    public void the_input_is_kept_and_the_rule_is_copied_rule_name_would_have_COPY_OF_The_user_stays_on_the_rule_basics_screen() {
        menuManagerPage.startAssertions(MenuManagerPageAssertion.class)
                .assertIfTheInputIsKeptAndTheRuleIsCopied("COPY OF")
                .endAssertion()
                .clickBasedOnName("deleteButton")
                .acceptAlertIfPresent(MenuManagerPage.class);
        menuManagerPage.startAssertions(MenuManagerPageAssertion.class)
                .assertAtListRulesTab()
                .endAssertion()
                .clickBasedOnName("createNewRule")
        ;
    }

    @Then("Any input is saved, the user can then proceed to rule structure.")
    public void any_input_is_saved_the_user_can_then_proceed_to_rule_structure() {
        menuManagerPage.startAssertions(MenuManagerPageAssertion.class)
                .assertIfRuleStructureStatusIsSaved()
                .endAssertion()
                .openRuleStructureTab()
                .startAssertions(MenuManagerPageAssertion.class)
                .assertAtRuleStructureTab()
                .endAssertion()
                .openListRulesTab()
                .clickOnBinIcon()
                .acceptAlertIfPresent(MenuManagerPage.class);
        ;
    }

    @When("Enter a date range, hit find report")
    public void enter_a_date_range_hit_find_report() {
        super.setUp();
        homePage = functionalLibrary.gmLogIn(environment, configuration, HomePage.class);
        homePage.startAssertions(HomePageAssertion.class)
                .assertAtHomePage()
                .endAssertion()
                .openMenuManagerTab();
        menuManagerPage = new MenuManagerPage(driver);
        menuManagerPage.selectDateCurrentDate()
                .setStartDateInCalender()
        ;
    }

    @Then("The results pulled back depend on the range enter {string}")
    public void the_results_pulled_back_depend_on_the_range_enter(String date) {
        menuManagerPage.clickBasedOnName("submit")
                .startAssertions(MenuManagerPageAssertion.class)
                .assertIfReportResultsPulledBackDependOnTheRangeEntered(date)
                .endAssertion()
        ;
    }

    @When("Hit Download all rules button.")
    public void hit_Download_all_rules_button() {
        menuManagerPage.clickOnDownloadAllRuleLink();
    }

    @Then("All current rules are downloaded in a XML format as {string}.")
    public void all_current_rules_are_downloaded_in_a_XML_format_as(String fileName) {
        menuManagerPage
                .openFileDownloaded("rule")
                .startAssertions(MenuManagerPageAssertion.class)
                .assertIfRulesFileDownloadedSuccessfully(fileName)
                .endAssertion()
        ;
    }

    @When("Upload a set of valid rules, append to current")
    public void upload_a_set_of_valid_rules_append_to_current() {
        menuManagerPage.clickOnChooseUploadFile(functionalLibrary.getAbsolutePath("rules.xml"))
                .clickOnUploadRulesBtn();

    }

    @Then("Upload successful. Rules appended to current")
    public void upload_successful_Rules_appended_to_current() {
        menuManagerPage.startAssertions(MenuManagerPageAssertion.class)
                .assertIfRuleAppendedToCurrent()
                .endAssertion()
        ;
    }

    @When("Upload a set of valid rules, overwrite current")
    public void upload_a_set_of_valid_rules_overwrite_current() {
        menuManagerPage.clickOnChooseUploadFile(functionalLibrary.getAbsolutePath("rules.xml"))
                .clickOnOverwriteRulesRadioBtn()
                .acceptAlertIfPresent(MenuManagerPage.class);
        menuManagerPage.clickOnUploadRulesBtn();
    }

    @Then("Upload successful. Rules overwrite current")
    public void upload_successful_Rules_overwrite_current(io.cucumber.datatable.DataTable dataTable) {
        List<String> data = dataTable.asList();
        menuManagerPage.startAssertions(MenuManagerPageAssertion.class)
                .assertIfRuleAppendedToCurrent()
                .endAssertion()
                .clickBasedOnName("createNewRule")
                .sendKeysBasedOnName(data.get(2), data.get(0))
                .sendKeysForTextAreaBasedOnName(data.get(3), data.get(1))
                .sendKeysForTextAreaBasedOnName(data.get(4), data.get(1))
                .sendKeysBasedOnName(data.get(5), getCurrentDate())
                .sendKeysBasedOnName(data.get(6), FunctionalLibrary.getFutureDay(2))
                .clickOnSaveBtn();
    }

    @When("Delete a pre existing rule by clicking Edit icon and then DELETE")
    public void delete_a_pre_existing_rule_by_clicking_Edit_icon_and_then_DELETE() {
        menuManagerPage.openListRulesTab()
                .clickOnBinIcon()
                .acceptAlertIfPresent(MenuManagerPage.class)
        ;
    }

    @Then("The rule is {string} removed from the table.")
    public void the_rule_is_removed_from_the_table(String ruleName) {
        menuManagerPage.startAssertions(MenuManagerPageAssertion.class)
                .assertIfTheRuleIsRemovedFromTheListRuleTable(ruleName)
                .endAssertion()
                .clickBasedOnName("createNewRule")
        ;
    }

    @When("Hit Deploy rules")
    public void hit_Deploy_rules() {
        menuManagerPage.openListRulesTab()
                .clickBasedOnName("deploy");
    }

    @Then("All rules currently created will be deployed to the environment.")
    public void all_rules_currently_created_will_be_deployed_to_the_environment() {
        menuManagerPage.startAssertions(MenuManagerPageAssertion.class)
                .assertIfAllRulesCurrentlyCreatedWillBeDeployedToTheEnvironment("Rules deployed : " + getCurrentDate())
                .endAssertion();
    }

    @When("Select the vehicle make \\(Chev), and set a job type, a unique campaign code and effect as {string}, then save the rule.")
    public void select_the_vehicle_make_Chev_and_set_a_job_type_a_unique_campaign_code_and_effect_as_then_save_the_rule(String effectEntryData) {
        menuManagerPage.openRuleStructureTab()
                .startAssertions(MenuManagerPageAssertion.class)
                .assertAtRuleStructureTab()
                .endAssertion()
                .clickOnChevroletMake()
                .clickOnMagnifierIcon();
        gmCreateEstimatePage = new GMCreateEstimatePage(driver);
        gmCreateEstimatePage.expandJobTreeInnerRow(2)
                .expandJobTreeSubInnerRow(7)
                .doubleClickOnRemoveAndReplace()
                .doubleClickOnRemoveAndReplace()
                .sendKeysBasedOnName("effectEntry", effectEntryData);
        menuManagerPage = new MenuManagerPage(driver);
        menuManagerPage.clickOnAddIcon(1)
                .setTotalPrice()
                .sendKeysBasedOnName("effectEntry", effectEntryData);
        menuManagerPage.inputEffectEntry("130")
                .clickOnRuleStructureSaveBtn()
        ;
    }

    @Then("Dropdown menus contain relevant data")
    public void dropdown_menus_contain_relevant_data(io.cucumber.datatable.DataTable dataTable) {
        List<String> data = dataTable.asList();
        menuManagerPage.startAssertions(MenuManagerPageAssertion.class)
                .assertIfFieldsAndDropDownContainTheRelevantData(data.get(0), data.get(1), data.get(2))
                .endAssertion()
        ;
    }

    @When("Verify the rule has worked by navigating to the job by vin {string} selected in part one.")
    public void verify_the_rule_has_worked_by_navigating_to_the_job_by_vin_selected_in_part_one(String vinNo) {
        homePage = new HomePage(driver);
        homePage.openCreateEstimateTab();
        homePage.inputVIN(vinNo)
                .searchBtn();
        gmCreateEstimatePage = new GMCreateEstimatePage(driver);
        gmCreateEstimatePage.expandJobTreeInnerRow(2)
                .expandJobTreeSubInnerRow(7)
                .clickOnRemoveAndReplace()
        ;
    }

    @Then("The rule is visible upon calling to the relevant job ID")
    public void the_rule_is_visible_upon_calling_to_the_relevant_job_ID(io.cucumber.datatable.DataTable dataTable) {
       List<String> expectedData = dataTable.asList();
        gmCreateEstimatePage.startAssertions(GMCreateEstimatePageAssertion.class)
                .assertIfQuantityDescriptionAndPriceAddedToGMQuote(expectedData, 2)
                .endAssertion();
        homePage = new HomePage(driver);
        homePage.openMenuManagerTab();
        menuManagerPage = new MenuManagerPage(driver);
        functionalLibrary.clickBasedOnName("deploy");
        menuManagerPage.clickOnEditIcon()
                .sendKeysBasedOnName("validToString", expectedData.get(3))
                .sendKeysBasedOnName("validFromString", expectedData.get(3));
        functionalLibrary.clickBasedOnName("saveButton");
        menuManagerPage.openListRulesTab()
                .clickBasedOnName("deploy")
        ;
    }

    @When("Search job and select {string} job and select {string}")
    public void search_job_and_select_job_and_select(String ParentElement, String childElement) {
        gmCreateEstimatePage = new GMCreateEstimatePage(driver);
        gmCreateEstimatePage.selectChildFromJobTree(ParentElement, childElement).
                clickAddtoEstimate();
    }

    @Then("verify {string} job is displayed")
    public void verify_job_is_displayed(String quoteName) {
            gmCreateEstimatePage.startAssertions(GMCreateEstimatePageAssertion.class)
                    .assertIfQuoteItemAdded(quoteName)
                    .endAssertion();
    }

    @When("Enter VIN {string} into the VIN field and click Search")
    public void enter_VIN_into_the_VIN_field_and_click_Search(String vinNo) {
        super.setUp();
        homePage = functionalLibrary.gmLogIn(environment, configuration, HomePage.class);
        homePage.inputVIN(vinNo)
                .clickOnSearchBtnGM();

    }

    @Then("The vehicle is found with {string} characteristics displayed")
    public void the_vehicle_is_found_with_characteristics_displayed(String vehicleName) {
        gmCreateEstimatePage = new GMCreateEstimatePage(driver);
        gmCreateEstimatePage.startAssertions(GMCreateEstimatePageAssertion.class)
                .assertIfVehicleDetailsFound(vehicleName)
                .endAssertion()
                .clickOnVehicleTab()
        ;
    }

    @When("Click on Continue")
    public void click_on_Continue() {
        homePage.continueBtnClick()
                .acceptAlertIfPresent(HomePage.class);
    }

    @When("Enter VIN {string} into VIN field and click Search")
    public void enter_VIN_into_VIN_field_and_click_Search(String vinNo) {
        homePage = new HomePage(driver);
        homePage.inputVIN(vinNo)
                .clickOnSearchBtnGM();
    }

    @Given("Login the application with {string}")
    public void login_into_application(String loginPerson) {
        super.setUp();
        homePage = functionalLibrary.logIn(environment, configuration, loginPerson, HomePage.class);
        homePage.startAssertions(HomePageAssertion.class)
                .assertAtHomePage()
                .endAssertion();
    }

    @Then("Search rule {string} and edit the rule")
    public void search_rule_and_edit_the_rule(String ruleName) {
        menuManagerPage = new MenuManagerPage(driver);
        menuManagerPage.editRule(ruleName);
    }

    @Then("Verify Effect entry as {string} and {string} in rule structure")
    public void verify_Effect_entry_as_and_in_rule_structure(String effect1, String effect2) {
        menuManagerPage.clickRuleStructure();
        menuManagerPage.startAssertions(MenuManagerPageAssertion.class)
                .assertIfExpectedRuleStructureDisplayed(effect1, effect2)
                .endAssertion();
    }

    @When("click on Create Estimate Tab")
    public void click_on_Create_Estimate_Tab() {
        gmCreateEstimatePage = new GMCreateEstimatePage(driver);
        gmCreateEstimatePage.clickCreateEstimate();
    }

    @When("click on Menu manager tab")
    public void click_on_Menu_manager_tab() {
        homePage.clickMenuManagerTab();
    }

    @Then("Verify Correct part price with Labour charge is displayed")
    public void verify_Correct_part_price_with_Labour_charge_is_displayed() {
           gmCreateEstimatePage.getPriceExTax();
           gmCreateEstimatePage.clickAddtoEstimate().clickJobDetails();
           homePage.switchToSpecificWindow("Job Drilldown - Service Workbench PRO Pricing");
           gmCreateEstimatePage.startAssertions(GMCreateEstimatePageAssertion.class)
                   .assertIfPartPriceWithLabourCostDisplayed()
                   .endAssertion();
           driver.close();
           homePage.switchToSpecificWindow("Service Workbench PRO Pricing");
    }

    @When("Search job and expand {string} job and select {string}")
    public void search_job_and_expand_job_and_select(String ParentElement, String childElement) {
        gmCreateEstimatePage = new GMCreateEstimatePage(driver);
        gmCreateEstimatePage.selectChildFromJobTree(ParentElement, childElement);
    }

    @Then("click save button")
    public void click_save_button() {
        gmCreateEstimatePage.clickOnSave();
    }

    @When("Enter {string} in Notes box and click Continue")
    public void enter_in_Notes_box_and_click_Continue(String text) {
        gmCreateEstimateNotesPage = new GMCreateEstimateNotesPage(driver);
        gmCreateEstimateNotesPage.enterNotes(text);
        gmCreateEstimatePage = new GMCreateEstimatePage(driver);
        gmCreateEstimatePage.clickOnContinueBtn();
    }

    @Then("verify the description appended with {string}")
    public void verify_the_description_appended_with(String appendedText) {
        gmCreateEstimatePage.startAssertions(GMCreateEstimatePageAssertion.class)
                        .assertIfDealerDescriptionAppendedWithGivenText(appendedText)
                                .endAssertion().clickAddtoEstimate();
    }


    @Then("Verify Correct part price with tax {string} is displayed for {string}")
    public void verify_Correct_part_price_with_tax_is_displayed_for(String tax, String job) {
        gmCreateEstimatePage.getPriceExTax();
           gmCreateEstimatePage.clickAddtoEstimate().clickJobDetails();
           homePage.switchToSpecificWindow("Job Drilldown - Service Workbench PRO Pricing");
        gmCreateEstimatePage.getPartPriceHeatedOxygen();
           gmCreateEstimatePage.startAssertions(GMCreateEstimatePageAssertion.class)
            .assertIfPartPriceWithGivenTaxDisplayed(tax, job)
                   .endAssertion();
           driver.close();
           homePage.switchToSpecificWindow("Service Workbench PRO Pricing");
    }

    @Then("Verify Correct part price {string} is displayed for {string}")
    public void verify_Correct_part_price_is_displayed_for(String tax, String job) {
        gmCreateEstimatePage.getPriceExTax();
        gmCreateEstimatePage.clickAddtoEstimate();
        gmCreateEstimatePage.startAssertions(GMCreateEstimatePageAssertion.class)
                .assertIfPriceWithTaxDisplayed(tax)
                .endAssertion();
    }

    @After
    public void close() {
        super.close();
    }
}
