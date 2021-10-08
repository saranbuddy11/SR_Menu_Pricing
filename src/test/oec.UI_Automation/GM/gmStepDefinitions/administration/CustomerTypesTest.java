package GM.gmStepDefinitions.administration;

import GM.gmAssertion.HomePageAssertion;
import GM.gmAssertion.administration.CustomerTypesPageAssertion;
import GM.gmObjectRepository.HomePage;
import GM.gmObjectRepository.administration.CustomerTypesPage;
import io.cucumber.java.After;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import model.BasedOnPartPriceType;
import stepDefinitions.AbstractTest;

public class CustomerTypesTest extends AbstractTest {

    @When("Navigate to Administration - Customer Types tab")
    public void navigate_to_Administration_Customer_Types_tab() {
        super.setUp();
        homePage = functionalLibrary.gmLogIn(environment, configuration, HomePage.class);
        homePage.startAssertions(HomePageAssertion.class)
                .assertAtHomePage()
                .endAssertion()
                .openAdministrationTab();
        customerTypesPage = new CustomerTypesPage(driver);
        customerTypesPage.openCustomerTypesTab()
        ;
    }

    @Then("The Administration - Customer Types tab is accessible")
    public void the_Administration_Customer_Types_tab_is_accessible() {
        customerTypesPage.startAssertions(CustomerTypesPageAssertion.class)
                .assertIfCustomerTypesTab()
                .endAssertion()
        ;
    }

    @When("Enter a new description {string} with Parts & Retail labor Rate details.")
    public void enter_a_new_description_with_Parts_Retail_labor_Rate_details(String description) {
        customerTypesPage.enterRetailDescription(description)
                .selectPriceType(BasedOnPartPriceType.RetailMinus)
                .enterAdjustPercentParts(50)
                .enterAdjustPercentLabour(0)
        ;
    }

    @Then("Is possible to put values to fields.")
    public void is_possible_to_put_values_to_fields() {
        customerTypesPage.startAssertions(CustomerTypesPageAssertion.class)
                .assertIsPossibleToPutValuesToFields()
                .endAssertion()
        ;
    }

    @When("Click on the Save button.")
    public void click_on_the_Save_button() {
        customerTypesPage.clickOnSaveBtn();
    }

    @Then("The customer type is saved.")
    public void the_customer_type_is_saved() {
        customerTypesPage.startAssertions(CustomerTypesPageAssertion.class)
                .assertIfNewlyAddedCustomerTypeIsSaved()
                .endAssertion()
        ;
    }

    @When("Click on the Delete icon next to one of the Types.")
    public void click_on_the_Delete_icon_next_to_one_of_the_Types() {
        customerTypesPage.clickOnDeleteIcon();
    }

    @Then("The customer type is permanently deleted.")
    public void the_customer_type_is_permanently_deleted() {
        customerTypesPage.startAssertions(CustomerTypesPageAssertion.class)
                .assertIfCustomerTypeIsPermanentlyDeleted()
                .endAssertion()
        ;
    }

    @When("Enter {string} description only and click Save.")
    public void enter_a_description_only_and_click_Save(String description) {
        customerTypesPage.enterRetailDescription(description)
                .clickOnSaveBtn()
        ;
    }

    @Then("Message appears: {string}")
    public void message_appears(String msg) {
        customerTypesPage.startAssertions(CustomerTypesPageAssertion.class)
                .assertIfErrorMsgDisplayed(msg)
                .endAssertion()
        ;
    }

    @When("Create {string} new customer type Based On Retail minus and enter the Adjust values as {int}%.")
    public void create_new_customer_type_Based_On_Retail_minus_and_enter_the_Adjust_values_as(String description, Integer discount) {
        customerTypesPage.enterRetailDescription(description)
                .selectPriceType(BasedOnPartPriceType.RetailMinus)
                .enterAdjustPercentParts(discount)
                .enterAdjustPercentLabour(0)
                .clickOnSaveBtn()
        ;
    }

    @Then("Message is shown to user stating that: {string}")
    public void message_is_shown_to_user_stating_that(String msg) {
        customerTypesPage.startAssertions(CustomerTypesPageAssertion.class)
                .assertIfErrorMsgDisplayed(msg)
                .endAssertion()
        ;
    }

    @When("Create {string} new customer type Based On None and should be impossible to put Adjust % Parts it is set $0% as default")
    public void create_new_customer_type_Based_On_None_and_should_be_impossible_to_put_Adjust_Parts_it_is_set_$0_as_default(String description) {
        customerTypesPage.enterRetailDescription(description)
                .selectPriceType(BasedOnPartPriceType.None)
        ;
    }

    @Then("Adjust % Parts is inactive for Based On = None")
    public void adjust_Parts_is_inactive_for_Based_On_None() {
        customerTypesPage.startAssertions(CustomerTypesPageAssertion.class)
                .assertIfAdjustPercentPartsIsInactiveForBasedOnEqualToNone()
                .endAssertion()
        ;
    }

    @When("Create {string} new customer type Based On Cost Plus and enter the Adjust values as {int}%.")
    public void create_new_customer_type_Based_On_Cost_Plus_and_enter_the_Adjust_values_as(String description, Integer discount) {
        customerTypesPage.enterRetailDescription(description)
                .selectPriceType(BasedOnPartPriceType.CostPlus)
                .enterAdjustPercentParts(discount)
                .enterAdjustPercentLabour(0)
                .clickOnSaveBtn();
    }

    @When("Navigate to Administration - JLR Customer Types tab")
    public void navigate_to_Administration_JLR_Customer_Types_tab() {
        super.setUp();
        homePage = functionalLibrary.jlrLogIn(environment, configuration, HomePage.class);
        homePage.startAssertions(HomePageAssertion.class)
                .assertAtHomePage()
                .endAssertion()
                .openAdministrationTab();
        customerTypesPage = new CustomerTypesPage(driver);
        customerTypesPage.openCustomerTypesTab()
        ;
    }

    @After
    public void close() {
        super.close();
    }
}
