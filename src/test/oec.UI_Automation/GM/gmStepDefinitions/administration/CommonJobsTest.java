package GM.gmStepDefinitions.administration;

import GM.gmAssertion.HomePageAssertion;
import GM.gmAssertion.administration.CommonJobsPageAssertion;
import GM.gmObjectRepository.HomePage;
import GM.gmObjectRepository.administration.CommonJobsPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import stepDefinitions.AbstractTest;

import java.util.Arrays;
import java.util.List;

public class CommonJobsTest extends AbstractTest {
    @When("Open the Administration_Common Jobs tab.Add a new custom job by entering the details into the fields e.g.Description: {string}, Cost Excl. VAT {string}, Retail Excl. VAT {string}, Tax Rate {string}")
    public void open_the_Administration_Common_Jobs_tab_Add_a_new_custom_job_by_entering_the_details_into_the_fields_e_g_Description_Cost_Excl_VAT_Retail_Excl_VAT_Tax_Rate(String description, String cost, String retail, String taxRate) {
        super.setUp();
        homePage = functionalLibrary.gmLogIn(environment, configuration, HomePage.class);
        homePage.startAssertions(HomePageAssertion.class)
                .assertAtHomePage()
                .endAssertion()
                .openAdministrationTab();
        commonJobsPage = new CommonJobsPage(driver);
        commonJobsPage.openCommonJobsTab()
                .startAssertions(CommonJobsPageAssertion.class)
                .assertIfCommonJobsTab()
                .endAssertion()
                .enterDescription(description)
                .enterCostPrice(cost)
                .enterRetailPrice(retail)
                .selectTaxRatePercent(taxRate)
        ;
    }

    @When("Click Save to add the job.")
    public void click_Save_to_add_the_job() {
        commonJobsPage = new CommonJobsPage(driver);
        commonJobsPage.clickOnSaveBtn();

    }

    @Then("Common job is added {string} to the Dealer Custom Jobs list.")
    public void common_job_is_added_to_the_Dealer_Custom_Jobs_list(String addedJob) {
        commonJobsPage.startAssertions(CommonJobsPageAssertion.class)
                .assertIfCommonJobIsAddedToTheDealerCustomJobsList(addedJob)
                .endAssertion()
        ;
    }

    @When("Click on the Edit icon of Generic Job Vehicle Cleaning - Engine Wash.")
    public void click_on_the_Edit_icon_of_Generic_Job_Vehicle_Cleaning_Engine_Wash() {
        commonJobsPage.clickOnGenericJobEditIcon();
    }

    @Then("Generic job details loaded into edit fields.")
    public void generic_job_details_loaded_into_edit_fields() {
        commonJobsPage.startAssertions(CommonJobsPageAssertion.class)
                .assertIfGenericJobEditFieldInputElementsDisplayed()
                .endAssertion()
        ;
    }

    @When("Edit the Cost and Retail prices as {string} and {string}. Click Save.")
    public void edit_the_Cost_and_Retail_prices_as_and_Click_Save(String cost, String retail) {
        commonJobsPage.enterCostPrice(cost)
                .enterRetailPrice(retail)
                .clickOnSaveBtn()
        ;
    }

    @Then("Prices as {string} and {string} are updated for {string}.")
    public void prices_as_and_are_updated(String cost, String retail, String genericJob) {
        List<String> expectedPrice = Arrays.asList(cost, retail);
        commonJobsPage.startAssertions(CommonJobsPageAssertion.class)
                .assertIfVehicleCleaningEngineWashCommonJobsPriceAreUpdated(expectedPrice, genericJob)
                .endAssertion()
        ;
    }

    @When("Click on the Delete icon of Custom job Test Job $1 and when prompted to confirm choose Cancel.")
    public void click_on_the_Delete_icon_of_Custom_job_Test_Job_$1_and_when_prompted_to_confirm_choose_Cancel() {
        commonJobsPage.clickOnGenericTestJob1JobDeleteIcon()
                .startAssertions(CommonJobsPageAssertion.class)
                .assertIfDeletingWarningMessageIsShown()
                .endAssertion()
                .dismissAlertIfPresent(CommonJobsPage.class);
        ;
    }

    @Then("Custom job {string} is not deleted.")
    public void custom_job_is_not_deleted(String deletedJob) {
        commonJobsPage.startAssertions(CommonJobsPageAssertion.class)
                .assertIfCommonJobIsAddedToTheDealerCustomJobsList(deletedJob)
                .endAssertion()
        ;
    }

    @When("Click on the Delete icon again and choose OK when prompted.")
    public void click_on_the_Delete_icon_again_and_choose_OK_when_prompted() {
        commonJobsPage.clickOnGenericTestJob1JobDeleteIcon()
                .startAssertions(CommonJobsPageAssertion.class)
                .assertIfDeletingWarningMessageIsShown()
                .endAssertion()
                .acceptAlertIfPresent(CommonJobsPage.class)
        ;
    }

    @Then("Custom job {string} is removed from the list.")
    public void custom_job_is_removed_from_the_list(String customJob) {
        commonJobsPage.startAssertions(CommonJobsPageAssertion.class)
                .assertIfTestJob1RemovedFromDealerCustomJobsTableDescriptions(customJob)
                .endAssertion()
        ;
    }

    @When("Try and add a job without one of the edit boxes filled in.")
    public void try_and_add_a_job_without_one_of_the_edit_boxes_filled_in() {
        commonJobsPage.clickOnSaveBtn();
    }

    @Then("Message informs {string}.")
    public void message_informs(String errorMsg) {
        commonJobsPage.startAssertions(CommonJobsPageAssertion.class)
                .assertIfErrorMessageDisplayed(errorMsg)
                .endAssertion()
        ;
    }

    @When("Edit some Common Jobs so that they have no price. Click on the Unpriced Common Custom Jobs hyperlink.")
    public void edit_some_Common_Jobs_so_that_they_have_no_price_Click_on_the_Unpriced_Common_Custom_Jobs_hyperlink() {
        commonJobsPage.editCommonJobPrice(1, "2", "3");
        homePage = new HomePage(driver);
        homePage.openCreateEstimateTab()
                .openAdministrationTab();
        commonJobsPage = new CommonJobsPage(driver);
        commonJobsPage.openCommonJobsTab()
                .editCommonJobPrice(1, "0", "0");
        homePage = new HomePage(driver);
        homePage.openCreateEstimateTab();
    }

    @Then("A hyperlink to the Common Jobs page is visible. User is taken to the Generic Jobs page.")
    public void a_hyperlink_to_the_Common_Jobs_page_is_visible_User_is_taken_to_the_Generic_Jobs_page() {
        homePage.startAssertions(HomePageAssertion.class)
                .assertIfAHyperlinkToTheCommonJobsPageIsVisible()
                .endAssertion()
                .clickOnUnpricedCommonCustomJobsLink();
        commonJobsPage = new CommonJobsPage(driver);
        commonJobsPage.startAssertions(CommonJobsPageAssertion.class)
                .assertIfCommonJobsTab()
                .endAssertion()
                .cleanUP();
        super.close();
    }

    @When("Open the Admin Generic Jobs tab.")
    public void open_the_Admin_Generic_Jobs_tab() {
        super.setUp();
        homePage = functionalLibrary.jlrLogIn(environment, configuration, HomePage.class);
        homePage.startAssertions(HomePageAssertion.class)
                .assertAtHomePage()
                .endAssertion()
                .openAdministrationTab();
        commonJobsPage = new CommonJobsPage(driver);
        commonJobsPage.openGenericJobsTab();
        homePage = new HomePage(driver);
        homePage.startAssertions(HomePageAssertion.class)
                .assertAtGenericJobsTab()
                .endAssertion()
        ;
    }

    @When("Add a new custom job by entering the details into the fields")
    public void add_a_new_custom_job_by_entering_the_details_into_the_fields(io.cucumber.datatable.DataTable dataTable) {
        List<String> data = dataTable.asList();
        commonJobsPage = new CommonJobsPage(driver);
        commonJobsPage.enterDescription(data.get(0))
                .enterCostPrice(data.get(1))
                .enterRetailPrice(data.get(2))
                .selectTaxRatePercent(data.get(3))
        ;
    }

    @When("Click on the Edit icon of Generic Job {string}")
    public void click_on_the_Edit_icon_of_Generic_Job(String job) {
        commonJobsPage.clickOnJLRGenericJobEditIcon(job);
    }

    @When("Click on the Delete icon of Custom job Test Job $1 and when prompted to confirm {string} choose Cancel.")
    public void click_on_the_Delete_icon_of_Custom_job_Test_Job_$1_and_when_prompted_to_confirm_choose_Cancel(String warnMsg) {
        commonJobsPage.clickOnGenericTestJob1JobDeleteIcon()
                .startAssertions(CommonJobsPageAssertion.class)
                .assertIfDeletingWarningMessageIsShownInGenericJobs(warnMsg)
                .endAssertion()
                .clickOnDialogBtn("Cancel")
        ;
    }

    @When("Click on the Delete icon again {string} and choose OK when prompted.")
    public void click_on_the_Delete_icon_again_and_choose_OK_when_prompted(String warnMsg) {
        commonJobsPage.clickOnGenericTestJob1JobDeleteIcon()
                .startAssertions(CommonJobsPageAssertion.class)
                .assertIfDeletingWarningMessageIsShownInGenericJobs(warnMsg)
                .endAssertion()
                .clickOnDialogBtn("OK");
        ;
    }

    @When("Edit some Generic Jobs so that they have no price. Click on the Unpriced Common Custom Jobs hyperlink.")
    public void edit_some_Generic_Jobs_so_that_they_have_no_price_Click_on_the_Unpriced_Common_Custom_Jobs_hyperlink() {
        commonJobsPage.editCommonJobPrice(1, "2", "3");
        homePage = new HomePage(driver);
        homePage.openCreateEstimateTab()
                .openAdministrationTab();
        commonJobsPage = new CommonJobsPage(driver);
        commonJobsPage.openGenericJobsTab()
                .editCommonJobPrice(1, "0", "0");
        homePage = new HomePage(driver);
        homePage.openCreateEstimateTab();
    }

    @Then("A hyperlink to the Generic Jobs page is visible. User is taken to the Generic Jobs page.")
    public void a_hyperlink_to_the_Generic_Jobs_page_is_visible_User_is_taken_to_the_Generic_Jobs_page() {
        homePage.startAssertions(HomePageAssertion.class)
                .assertIfAHyperlinkToTheCommonJobsPageIsVisible()
                .endAssertion()
                .clickOnUnpricedCommonCustomJobsLink();
        commonJobsPage = new CommonJobsPage(driver);
        commonJobsPage.startAssertions(CommonJobsPageAssertion.class)
                .assertIfGenericJobsTab()
                .endAssertion();
        super.close();
    }

    @When("Edit the description as {string} and Cost and Retail prices as {string} and {string}. Click Save.")
    public void edit_the_description_as_and_Cost_and_Retail_prices_as_and_Click_Save(String description, String cost, String retail) {
        commonJobsPage.enterDescription(description)
                .enterCostPrice(cost)
                .enterRetailPrice(retail)
                .clickOnSaveBtn()
        ;
    }

    @Then("Description {string} and Prices as {string} and {string} are updated.")
    public void description_and_Prices_as_and_are_updated(String Description, String Cost, String Retail) {
        List<String> expectedPrice = Arrays.asList(Cost, Retail);
        commonJobsPage.startAssertions(CommonJobsPageAssertion.class)
                .assertIfVehicleCleaningEngineWashCommonJobsPriceAreUpdated(expectedPrice, Description)
                .endAssertion()
        ;
    }
}
