package GM.gmStepDefinitions.administration;

import GM.gmAssertion.GMCreateEstimatePageAssertion;
import GM.gmAssertion.HomePageAssertion;
import GM.gmAssertion.PartLaborDrillDownPageAssertion;
import GM.gmAssertion.administration.BulkFluidsPageAssertion;
import GM.gmObjectRepository.GMCreateEstimatePage;
import GM.gmObjectRepository.HomePage;
import GM.gmObjectRepository.PartLaborDrillDownPage;
import GM.gmObjectRepository.administration.BulkFluidsPage;
import io.cucumber.java.After;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import model.BulkFluidBrandAndQuality;
import model.BulkFluidLocalParts;
import stepDefinitions.AbstractTest;

import java.util.Arrays;
import java.util.List;

public class BulkFluidsTest extends AbstractTest {

    @When("For Administration and BulkFluids tab Only {string} drop down box values displayed. There is no Manufacturer Parts for Market and Local fluid types are displayed.")
    public void for_Administration_and_BulkFluids_tab_Only_drop_down_box_values_displayed_There_is_no_Manufacturer_Parts_for_Market_and_Local_fluid_types_are_displayed(String expectedLabel) {
        super.setUp();
        homePage = functionalLibrary.gmLogIn(environment, configuration, HomePage.class);
        homePage.startAssertions(HomePageAssertion.class)
                .assertAtHomePage()
                .endAssertion()
                .openAdministrationTab()
                .openBulkFluidsTab();
        bulkFluidsPage = new BulkFluidsPage(driver);
        bulkFluidsPage.startAssertions(BulkFluidsPageAssertion.class)
                .assertAtBulkFluidsTab()
                .assertIfAdministrationBulkFluidsTabOnlyMarketAndLocalFluidTypesAreDisplayed(expectedLabel)
                .endAssertion()
        ;
    }

    @When("Select part SCREENWASH_$1 from the drop down list.")
    public void select_part_SCREENWASH_$1_from_the_drop_down_list() {
        bulkFluidsPage.selectLocalPart(BulkFluidLocalParts.SCREENWASH);
    }

    @When("Add a new Local part by entering the details into the fields: Container Size, Description, Part No, Cost Excl. Tax, Retail Excl. Tax, Tax Band.")
    public void add_a_new_Local_part_by_entering_the_details_into_the_fields_Container_Size_Description_Part_No_Cost_Excl_Tax_Retail_Excl_Tax_Tax_Band(io.cucumber.datatable.DataTable details) {
        List<String> data = details.asList();
        bulkFluidsPage = new BulkFluidsPage(driver);
        bulkFluidsPage.enterInput("quantity", data.get(0))
                .enterInput("description", data.get(1))
                .enterInput("partNumber", data.get(2))
                .enterInput("cost", data.get(3))
                .enterInput("price", data.get(4))
        ;
    }

    @When("Click the Save button.")
    public void click_the_Save_button() {
        bulkFluidsPage.clickOnSaveBtn();
    }

    @Then("Local part Test part $1 is added with correct data.")
    public void local_part_Test_part_$1_is_added_with_correct_data(io.cucumber.datatable.DataTable data) {
        List<String> expectedData = data.asList();
        bulkFluidsPage.startAssertions(BulkFluidsPageAssertion.class)
                .assertIfLocalPartAddedWithCorrectData(expectedData, 6)
                .endAssertion()
        ;
    }

    @When("Click on the Edit icon of the new Local Part Test Part $1.")
    public void click_on_the_Edit_icon_of_the_new_Local_Part_Test_Part_$1() {
        bulkFluidsPage.clickOnEditIcon(2);
    }

    @Then("Local part details populated into edit boxes.")
    public void local_part_details_populated_into_edit_boxes() {
        bulkFluidsPage.startAssertions(BulkFluidsPageAssertion.class)
                .assertIfLocalPrtDetailsPopulatedIntoEditBoxes()
                .endAssertion()
        ;
    }

    @When("Edit the description as {string} and click Save.")
    public void edit_the_description_as_and_click_Save(String description) {
        bulkFluidsPage.enterInput("description", description)
                .clickOnSaveBtn()
        ;
    }

    @Then("Part description is changed to Test Part $11")
    public void part_description_is_changed_to_Test_Part_$11(io.cucumber.datatable.DataTable data) {
        List<String> expectedData = data.asList();
        bulkFluidsPage.startAssertions(BulkFluidsPageAssertion.class)
                .assertIfLocalPartAddedWithCorrectData(expectedData, 6)
                .endAssertion()
        ;
    }

    @When("Click on the Delete icon of the Local part Test Part $11.")
    public void click_on_the_Delete_icon_of_the_Local_part_Test_Part_$11() {
        bulkFluidsPage.clickOnDeleteIcon();
    }

    @Then("Local part {string} is deleted from the list.")
    public void local_part_is_deleted_from_the_list(String partDescription) {
        bulkFluidsPage.startAssertions(BulkFluidsPageAssertion.class)
                .assertIfLocalPartDeletedFromList(partDescription)
                .endAssertion();
        super.close();
    }

    @Then("Local part can be created without entering an Ops code.")
    public void local_part_can_be_created_without_entering_an_Ops_code() {
        bulkFluidsPage = new BulkFluidsPage(driver);
        bulkFluidsPage.startAssertions(BulkFluidsPageAssertion.class)
                .assertIfLocalPartCreatedWithoutOpsCode(4)
                .endAssertion();
    }

    @When("Edit a Market part. Setting a ‘Local Operation Code’ value is optional.")
    public void edit_a_Market_part_Setting_a_Local_Operation_Code_value_is_optional(io.cucumber.datatable.DataTable details) {
        List<String> data = details.asList();
        bulkFluidsPage.clickOnEditIcon(1)
                .enterInput("cost", data.get(0))
                .enterInput("price", data.get(1))
        ;
    }

    @Then("Market part can be edited and saved without entering an Ops code.")
    public void market_part_can_be_edited_and_saved_without_entering_an_Ops_code() {
        bulkFluidsPage.clickOnSaveBtn()
                .startAssertions(BulkFluidsPageAssertion.class)
                .assertIfLocalPartCreatedWithoutOpsCode(3)
                .endAssertion()
        ;
    }

    @When("Edit a Local part. Setting a ‘Local Operation Code’ value is optional.")
    public void edit_a_Local_part_Setting_a_Local_Operation_Code_value_is_optional(io.cucumber.datatable.DataTable details) {
        List<String> data = details.asList();
        bulkFluidsPage.clickOnEditIcon(2)
                .enterInput("quantity", data.get(0))
                .enterInput("description", data.get(1))
                .enterInput("partNumber", data.get(2))
                .enterInput("cost", data.get(3))
                .enterInput("price", data.get(4))
        ;
    }

    @Then("Local part can be edited and saved without entering an Ops code.")
    public void local_part_can_be_edited_and_saved_without_entering_an_Ops_code() {
        bulkFluidsPage.clickOnSaveBtn()
                .startAssertions(BulkFluidsPageAssertion.class)
                .assertIfLocalPartCreatedWithoutOpsCode(4)
                .endAssertion()
        ;
    }

    @When("Edit a Market part. The Local Operation Code text entered {string} by the user must not exceed $20 characters.")
    public void edit_a_Market_part_The_Local_Operation_Code_text_entered_by_the_user_must_not_exceed_$20_characters(String text) {
        bulkFluidsPage.clickOnEditIcon(1)
                .enterInput("localOperationCode", text)
                .clickOnSaveBtn()
        ;
    }

    @Then("A maximum of {int} characters can be entered into the Ops field {int}.")
    public void a_maximum_of_characters_can_be_entered_into_the_Ops_field(Integer textLimit, Integer index) {
        bulkFluidsPage.startAssertions(BulkFluidsPageAssertion.class)
                .assertIfTextBoxCharacterMaxLimit(textLimit, index)
                .endAssertion()
        ;
    }

    @When("Edit a Local part. The Local Operation Code text entered {string} by the user must not exceed $20 characters.")
    public void edit_a_Local_part_The_Local_Operation_Code_text_entered_by_the_user_must_not_exceed_$20_characters(String text) {
        bulkFluidsPage.clickOnEditIcon(2)
                .enterInput("localOperationCode", text)
                .clickOnSaveBtn()
        ;
    }

    @Then("remove added local part from the bulk fluids")
    public void remove_added_local_part_from_the_bulk_fluids() {
        bulkFluidsPage.clickOnDeleteIcon()
                .clickOnUndoArrowIcon()
        ;
    }

    @When("Administration Panel>Bulk Fluids for fluid ENGINE_OIL_$5 you have created Market Local Part as below: Cointainer Size: {string} Description: {string} Part No: {string} Cost Excl. Tax: {string} Retail Excl. Tax: {string} Tax brand: $0 Round Up Quantity: ENABLED. index {int} and {int}")
    public void administration_Panel_Bulk_Fluids_for_fluid_ENGINE_OIL_$5_you_have_created_Market_Local_Part_as_below_Cointainer_Size_Description_Part_No_Cost_Excl_Tax_Retail_Excl_Tax_Tax_brand_$0_Round_Up_Quantity_ENABLED_index_and(String containerSize, String description, String partNo, String costPrice, String retailPrice, int index1, int index2) {
        List<String> marketPart = Arrays.asList(containerSize, description, partNo, costPrice, retailPrice);
        super.setUp();
        homePage = functionalLibrary.gmLogIn(environment, configuration, HomePage.class);
        homePage = new HomePage(driver);
        homePage.openAdministrationTab()
                .openBulkFluidsTab();
        bulkFluidsPage = new BulkFluidsPage(driver);
        bulkFluidsPage.selectLocalPart(BulkFluidLocalParts.Oil5W30)
                .startAssertions(BulkFluidsPageAssertion.class)
                .assertIfLocalPartAddedWithCorrectData(marketPart, index1)
                .endAssertion()
                .uncheckAllPartIdTypeCheckbox()
                .clickOnDefaultPartIdTypeRadioBtn(index2)
                .clickOnDefaultPartIdTypeCheckbox(index2)
        ;
    }

    @Then("Local Market Part is defined index {int}")
    public void local_Market_Part_is_defined_index(int index) {
        bulkFluidsPage.startAssertions(BulkFluidsPageAssertion.class)
                .assertIfLocalMarketPartIsDefined(index)
                .endAssertion()
        ;
    }

    @When("Create estimate to VIN: {string}")
    public void create_estimate_to_VIN(String vinNo) {
        homePage = new HomePage(driver);
        homePage.openCreateEstimateTab()
                .inputVIN(vinNo)
                .searchBtn()
        ;
    }

    @Then("VIN is recognized {string}")
    public void vin_is_recognized(String vinNo) {
        gmCreateEstimatePage = new GMCreateEstimatePage(driver);
        gmCreateEstimatePage.startAssertions(GMCreateEstimatePageAssertion.class)
                .assertIfVINNumberIsDisplayedInYourSelectionAtTopOfPage(vinNo)
                .endAssertion()
        ;
    }

    @When("Add Job from the tree: Scheduled Maintenance > Oil Change > Engine Oil and Filter Replacement > Up To Model Year $2017")
    public void add_Job_from_the_tree_Scheduled_Maintenance_Oil_Change_Engine_Oil_and_Filter_Replacement_Up_To_Model_Year_$2017() {
        gmCreateEstimatePage = new GMCreateEstimatePage(driver);
        gmCreateEstimatePage.expandJobTreeInnerRow(1)
                .expandJobTreeSubInnerRow(5)
                .clickOnOilReplacement()
                .clickOnAddToQuote()
        ;
    }

    @Then("Job is added to the Estimate")
    public void job_is_added_to_the_Estimate(io.cucumber.datatable.DataTable dataTable) {
        List<String> data = dataTable.asList();
        gmCreateEstimatePage.startAssertions(GMCreateEstimatePageAssertion.class)
                .assertIfQuantityDescriptionAndPriceAddedToQuote(data, 2)
                .endAssertion()
        ;
    }

    @When("In Create Estimate tab open Job details of added Job and check Generic part quantity")
    public void in_Create_Estimate_tab_open_Job_details_of_added_Job_and_check_Generic_part_quantity() {
        gmCreateEstimatePage = new GMCreateEstimatePage(driver);
        gmCreateEstimatePage.clickOnMagnifyingGlassIcon(1)
                .switchToTab(2)
        ;
    }

    @Then("Expected calculated qty in application = $4.$2 quarts container size of used part [rounded up] For this example will be $4.$2 or'{double}'=$3.$82 containers and retailerPrice '{double}' with round up to $4containers and Price Ex.tax = '{double}' or '{double}'")
    public void expected_calculated_qty_in_application_$4_$2_quarts_container_size_of_used_part_rounded_up_For_this_example_will_be_$4_$2_or_$3_$82_containers_and_retailerPrice_with_round_up_to_$4containers_and_Price_Ex_tax_or(Double containerSize, Double retailerPrice, Double price1, Double price2) {
        partLaborDrillDownPage = new PartLaborDrillDownPage(driver);
        partLaborDrillDownPage.startAssertions(PartLaborDrillDownPageAssertion.class)
                .assertIfGenericPartRoundUpApplied(containerSize, price1, price2, retailerPrice)
                .endAssertion()
                .clickOnContinueBtn()
                .switchToTab(1)
        ;
    }

    @When("Administration Panel>Bulk Fluids for fluid ENGINE_OIL_$5 you have created Market Local Part as below: Cointainer Size: {string} Description: {string} Part No: {string} Cost Excl. Tax: {string} Retail Excl. Tax: {string} Tax brand: $0 Round Up Quantity: DISABLED index {int} and {int}")
    public void administration_Panel_Bulk_Fluids_for_fluid_ENGINE_OIL_$5_you_have_created_Market_Local_Part_as_below_Cointainer_Size_Description_Part_No_Cost_Excl_Tax_Retail_Excl_Tax_Tax_brand_$0_Round_Up_Quantity_DISABLED_index_and(String containerSize, String description, String partNo, String costPrice, String retailPrice, int index1, int index2) {
        List<String> marketPart = Arrays.asList(containerSize, description, partNo, costPrice, retailPrice);
        homePage = new HomePage(driver);
        homePage.openAdministrationTab()
                .openBulkFluidsTab();
        bulkFluidsPage = new BulkFluidsPage(driver);
        bulkFluidsPage.selectLocalPart(BulkFluidLocalParts.Oil5W30)
                .startAssertions(BulkFluidsPageAssertion.class)
                .assertIfLocalPartAddedWithCorrectData(marketPart, index1)
                .endAssertion()
                .uncheckAllPartIdTypeCheckbox()
                .clickOnDefaultPartIdTypeRadioBtn(index2);
        homePage = new HomePage(driver);
        homePage.openCreateEstimateTab()
                .acceptAlertIfPresent(HomePage.class);
        ;
    }

    @When("Administration Panel>Bulk Fluids for fluid ENGINE_OIL_$5 you have created DMS Market Local Part as below: Cointainer Size: {string} Description: {string} Part No: {string} Cost Excl. Tax: {string} Retail Excl. Tax: {string} Tax brand: $0 Round Up Quantity: DISABLED index {int} and {int}")
    public void administration_Panel_Bulk_Fluids_for_fluid_ENGINE_OIL_$5_you_have_created_DMS_Market_Local_Part_as_below_Cointainer_Size_Description_Part_No_Cost_Excl_Tax_Retail_Excl_Tax_Tax_brand_$0_Round_Up_Quantity_DISABLED_index_and(String containerSize, String description, String partNo, String costPrice, String retailPrice, int index1, int index2) {
        List<String> marketPart = Arrays.asList(containerSize, description, partNo, costPrice, retailPrice);
        bulkFluidsPage = new BulkFluidsPage(driver);
        bulkFluidsPage.startAssertions(BulkFluidsPageAssertion.class)
                .assertIfLocalPartAddedWithCorrectData(marketPart, index1)
                .endAssertion()
                .uncheckAllPartIdTypeCheckbox()
                .clickOnDefaultPartIdTypeRadioBtn(index2);
        homePage = new HomePage(driver);
        homePage.openCreateEstimateTab()
                .acceptAlertIfPresent(HomePage.class)
        ;
    }

    @When("Edit a Market part. Setting a ‘Brand and Quality’ value {string} is optional.")
    public void edit_a_Market_part_Setting_a_Brand_and_Quality_value_is_optional(String value) {
        super.setUp();
        homePage = functionalLibrary.gmLogIn(environment, configuration, HomePage.class);
        homePage = new HomePage(driver);
        homePage.openAdministrationTab()
                .openBulkFluidsTab();
        bulkFluidsPage = new BulkFluidsPage(driver);
        bulkFluidsPage.selectLocalPart(BulkFluidLocalParts.Oil5W30)
                .removeAlreadyTestedLocalPart()
                .clickOnEditIcon(3)
                .enterInput("cost", value)
                .selectBrandAndQuality(BulkFluidBrandAndQuality.EmptyValue)
                .clickOnSaveBtn()
        ;
    }

    @Then("Market part can be edited and saved without entering the Brand and Quality.")
    public void market_part_can_be_edited_and_saved_without_entering_the_Brand_and_Quality() {
        bulkFluidsPage.startAssertions(BulkFluidsPageAssertion.class)
                .assertIfPartCanBeEditedOrSavedWithoutEnteringTheBrandAndQuality(4)
                .endAssertion()
        ;
    }

    @Then("Local part can be created without entering the Brand and Quality.")
    public void local_part_can_be_created_without_entering_the_Brand_and_Quality() {
        bulkFluidsPage.startAssertions(BulkFluidsPageAssertion.class)
                .assertIfPartCanBeEditedOrSavedWithoutEnteringTheBrandAndQuality(6)
                .endAssertion()
        ;
    }

    @When("Edit a Local part. Setting a ‘Brand and Quality’ value is optional.")
    public void edit_a_Local_part_Setting_a_Brand_and_Quality_value_is_optional() {
        bulkFluidsPage.clickOnEditIcon(5)
                .selectBrandAndQuality(BulkFluidBrandAndQuality.SNPlus)
                .clickOnSaveBtn()
        ;
    }

    @Then("Local part can be edited and saved without entering the Brand and Quality {string}.")
    public void local_part_can_be_edited_and_saved_without_entering_the_Brand_and_Quality(String brandName) {
        bulkFluidsPage.startAssertions(BulkFluidsPageAssertion.class)
                .assertIfPartEditedOrSavedWithEnteringTheBrandAndQuality(7, brandName)
                .endAssertion()
                .clickOnEditIcon(5)
                .selectBrandAndQuality(BulkFluidBrandAndQuality.EmptyValue)
                .clickOnSaveBtn()
        ;
    }

    @When("Edit a Market part. A ‘Brand and Quality’ value can only be used once per Generic Part Place Holder {string}.")
    public void edit_a_Market_part_A_Brand_and_Quality_value_can_only_be_used_once_per_Generic_Part_Place_Holder(String brandName) {
        bulkFluidsPage.clickOnEditIcon(2)
                .selectBrandAndQuality(BulkFluidBrandAndQuality.SNPlus)
                .clickOnSaveBtn()
                .startAssertions(BulkFluidsPageAssertion.class)
                .assertIfPartEditedOrSavedWithEnteringTheBrandAndQuality(3, brandName)
                .endAssertion()
                .clickOnEditIcon(1)
                .selectBrandAndQuality(BulkFluidBrandAndQuality.SNPlus)
        ;
    }

    @Then("A Brand and Quality value can only be used for {int} part under the same Place Holder.")
    public void a_Brand_and_Quality_value_can_only_be_used_for_part_under_the_same_Place_Holder(Integer partNo) {
        bulkFluidsPage.startAssertions(BulkFluidsPageAssertion.class)
                .assertIfBulkFluidCollisionMessageDisplayed()
                .endAssertion()
                .clickOnCallRemoveBrandQualityAction(1)
                .startAssertions(BulkFluidsPageAssertion.class)
                .assertIfPartCanBeEditedOrSavedWithoutEnteringTheBrandAndQuality(partNo)
                .endAssertion()
        ;
    }

    @When("Edit a Local part. A ‘Brand and Quality’ value can only be used once per Generic Part Place Holder {string}.")
    public void edit_a_Local_part_A_Brand_and_Quality_value_can_only_be_used_once_per_Generic_Part_Place_Holder(String brandName) {
        bulkFluidsPage.clickOnEditIcon(5)
                .selectBrandAndQuality(BulkFluidBrandAndQuality.SNPlus)
                .clickOnSaveBtn()
                .startAssertions(BulkFluidsPageAssertion.class)
                .assertIfPartEditedOrSavedWithEnteringTheBrandAndQuality(7, brandName)
                .endAssertion()
                .clickOnEditIcon(4)
                .selectBrandAndQuality(BulkFluidBrandAndQuality.SNPlus)
        ;
    }

    @Then("remove added local part from the bulk fluids brand quality")
    public void remove_added_local_part_from_the_bulk_fluids_brand_quality() {
        bulkFluidsPage.removeAlreadyTestedLocalPart()
                .clickOnUndoArrowIcon()
        ;
    }

    @When("Open the ADMINISTRATION Generic Parts tab.")
    public void open_the_ADMINISTRATION_Generic_Parts_tab() {
        super.setUp();
        homePage = functionalLibrary.jlrLogIn(environment, configuration, HomePage.class);
        homePage.startAssertions(HomePageAssertion.class)
                .assertAtHomePage()
                .endAssertion()
                .openAdministrationTab();
        bulkFluidsPage = new BulkFluidsPage(driver);
        bulkFluidsPage.openGenericParts()
                .startAssertions(BulkFluidsPageAssertion.class)
                .assertIfGenericPartsTab()
                .endAssertion()
        ;
    }

    @When("Select part {string} from the 1st drop down list.")
    public void select_part_from_the_1st_drop_down_list(String LR_SCREEN_WASH_500ML) {
        bulkFluidsPage.selectLocalPart(BulkFluidLocalParts.LR_SCREEN_WASH_500ML);
    }

    @Then("Local part is added with correct data.")
    public void local_part_is_added_with_correct_data(io.cucumber.datatable.DataTable data) {
        List<String> expectedData = data.asList();
        bulkFluidsPage.startAssertions(BulkFluidsPageAssertion.class)
                .assertIfJLRLocalPartAddedWithCorrectData(expectedData, 3, 4)
                .endAssertion()
        ;
    }

    @Then("Part description is changed")
    public void part_description_is_changed(io.cucumber.datatable.DataTable data) {
        List<String> expectedData = data.asList();
        bulkFluidsPage.startAssertions(BulkFluidsPageAssertion.class)
                .assertIfJLRLocalPartAddedWithCorrectData(expectedData, 3, 4)
                .endAssertion()
        ;
    }

    @When("Click on the Edit icon of the new Local Part.")
    public void click_on_the_Edit_icon_of_the_new_Local_Part() {
        bulkFluidsPage.clickOnGenericPartEditIcon(environment, 1, 2);
    }

    @After
    public void close() {
        super.close();
    }

}