package GM.gmStepDefinitions;

import GM.gmAssertion.HomePageAssertion;
import GM.gmAssertion.LoginPageAssertion;
import GM.gmAssertion.administration.*;
import GM.gmObjectRepository.HomePage;
import GM.gmObjectRepository.LoginPage;
import GM.gmObjectRepository.administration.*;
import io.cucumber.java.After;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import model.Market;
import stepDefinitions.AbstractTest;

import java.util.List;

public class LoginTest extends AbstractTest {

    @When("Check the header & tab text.")
    public void check_the_header_tab_text() {
        super.setUp();
        homePage = functionalLibrary.gmLogIn(environment, configuration, HomePage.class);
        super.close();
        super.setUp();
        loginPage = new LoginPage(driver);
        loginPage.startAssertions(LoginPageAssertion.class)
                .assertAtLoginPage()
                .endAssertion()
        ;
    }

    @Then("{string} as the header and the tab should read 'Service workbench PRO pricing'")
    public void as_the_header_and_the_tab_should_read_Service_workbench_PRO_pricing(String title, io.cucumber.datatable.DataTable data) {
        List<String> expectedHeaders = data.asList();
        loginPage.startAssertions(LoginPageAssertion.class)
                .assertIfHeaderTextAndTabPresent(title, expectedHeaders)
                .assertRequiredFieldsArePresent()
                .endAssertion()
        ;
    }

    @When("Attempt to login to MP using a Dealer and User ID that doesn’t exist.")
    public void attempt_to_login_to_MP_using_a_Dealer_and_User_ID_that_doesn_t_exist() {
        loginPage.inputDealerID(configuration.getDealerId())
                .loginBtn();
    }

    @Then("User is shown message: {string},{string}")
    public void user_is_shown_message(String expectedErrorMsg1, String expectedErrorMsg2) {
        loginPage.startAssertions(LoginPageAssertion.class)
                .assertIfLoginValidationErrorDisplayed_InvalidCredentials(expectedErrorMsg1, expectedErrorMsg2)
                .endAssertion()
        ;
    }

    @When("Attempt to login to MP using a valid Dealer ID with a User that doesn’t exist.")
    public void attempt_to_login_to_MP_using_a_valid_Dealer_ID_with_a_User_that_doesn_t_exist() {
        loginPage.inputUserID(configuration.getDealerId())
                .inputUserID(configuration.getUserId())
                .loginBtn()
        ;
    }

    @When("Attempt to login to MP using a valid Dealer & User ID but use an incorrect password.")
    public void attempt_to_login_to_MP_using_a_valid_Dealer_User_ID_but_use_an_incorrect_password() {
        loginPage.inputDealerID(configuration.getDealerId())
                .inputUserID(configuration.getUserId())
                .inputPassword(configuration.getInvalidPassword())
                .loginBtn()
        ;
    }

    @When("Try and login using the same incorrect password again until there are not more attempts allowed.")
    public void try_and_login_using_the_same_incorrect_password_again_until_there_are_not_more_attempts_allowed() {
        loginPage.inputDealerID(configuration.getDealerId())
                .inputUserID(configuration.getUserId())
                .inputPassword(configuration.getInvalidPassword())
                .loginBtn()
        ;
    }

    @When("Attempt to login by typing the password in a different case from what it was created in.")
    public void attempt_to_login_by_typing_the_password_in_a_different_case_from_what_it_was_created_in() {
        loginPage.inputDealerID(configuration.getDealerId())
                .inputUserID(configuration.getUserId())
                .inputPassword(configuration.getPassword().toUpperCase())
                .loginBtn()
        ;
    }

    @When("Login as an Admin user.")
    public void login_as_an_Admin_user() {
        loginPage.inputDealerID(configuration.getDealerId())
                .inputUserID(configuration.getUserId())
                .inputPassword(configuration.getPassword())
        ;
    }

    @Then("Users who have logged in before are taken to the Create Estimate and Vehicle page. Admin users have full access to the admin tab functionality.")
    public void users_who_have_logged_in_before_are_taken_to_the_Create_Estimate_and_Vehicle_page_Admin_users_have_full_access_to_the_admin_tab_functionality() {
        loginPage.loginBtn();
        homePage = new HomePage(driver);
        homePage.startAssertions(HomePageAssertion.class)
                .assertAtHomePage()
                .endAssertion()
                .openAdministrationTab()
                .openOrgDetailsTab();
        orgDetailPage = new OrgDetailPage(driver);
        orgDetailPage.startAssertions(OrgDetailPageAssertion.class)
                .assertAtOrgDetailTab()
                .endAssertion();
        customerTypesPage = new CustomerTypesPage(driver);
        customerTypesPage.openCustomerTypesTab()
                .startAssertions(CustomerTypesPageAssertion.class)
                .assertIfCustomerTypesTab()
                .endAssertion();
        commonJobsPage = new CommonJobsPage(driver);
        commonJobsPage.openCommonJobsTab()
                .startAssertions(CommonJobsPageAssertion.class)
                .assertIfCommonJobsTab()
                .endAssertion();
        homePage = new HomePage(driver);
        homePage.openBulkFluidsTab();
        bulkFluidsPage = new BulkFluidsPage(driver);
        bulkFluidsPage.startAssertions(BulkFluidsPageAssertion.class)
                .assertAtBulkFluidsTab()
                .endAssertion();
        homePage = new HomePage(driver);
        homePage.openOrgDetailsTab();
        systemSettingsPage = new SystemSettingsPage(driver);
        systemSettingsPage.openSystemSettingsTab()
                .startAssertions(SystemSettingsPageAssertion.class)
                .assertIfSystemSettingsTab()
                .endAssertion();
        partPricingPage = new PartPricingPage(driver);
        partPricingPage.openPartPricingTab()
                .startAssertions(PartPricingPageAssertion.class)
                .assertAtPartPricingTab()
                .endAssertion();
        glcAndLLCPage = new GLCAndLLCPage(driver);
        glcAndLLCPage.openGLCAndLLCTab()
                .startAssertions(GLCAndLLCPageAssertion.class)
                .assertAtGLCAndLLCTab()
                .endAssertion();
        super.close();
    }

    @When("Login as an Salesperson user.")
    public void login_as_an_Salesperson_user() {
        super.setUp();
        loginPage = new LoginPage(driver);
        loginPage.startAssertions(LoginPageAssertion.class)
                .assertAtLoginPage()
                .endAssertion();
        loginPage.inputDealerID(configuration.getDealerId())
                .inputUserID(configuration.getSalesUserId())
                .inputPassword(configuration.getPassword())
                .loginBtn()
        ;
    }

    @Then("Users who have logged in before are taken to the Create Estimate and Vehicle page. Salesperson user does not have {string} TAB")
    public void users_who_have_logged_in_before_are_taken_to_the_Create_Estimate_and_Vehicle_page_Salesperson_user_does_not_have_TAB(String tabName) {
        homePage = new HomePage(driver);
        homePage.startAssertions(HomePageAssertion.class)
                .assertAtHomePage()
                .endAssertion();
        homePage = new HomePage(driver);
        homePage.startAssertions(HomePageAssertion.class)
                .assertIfHomePageHeaderTabsDoesNotContainAdmin(tabName)
                .endAssertion();
        super.close();
    }

    @When("Check the jlr header & tab text.")
    public void check_the_jlr_header_tab_text() {
        super.setUp();
        homePage = functionalLibrary.jlrLogIn(environment, configuration, HomePage.class);
        super.close();
        super.setUp();
        loginPage = new LoginPage(driver);
        loginPage.startAssertions(LoginPageAssertion.class)
                .assertAtLoginPage()
                .endAssertion()
        ;
    }

    @Then("Users who have logged in before are taken to the Create Quote and Vehicle page. Admin users have full access to the admin tab functionality.")
    public void users_who_have_logged_in_before_are_taken_to_the_Create_Quote_and_Vehicle_page_Admin_users_have_full_access_to_the_admin_tab_functionality() {
        loginPage.loginBtn();
        homePage = new HomePage(driver);
        homePage.startAssertions(HomePageAssertion.class)
                .assertAtHomePage()
                .endAssertion()
                .openAdministrationTab()
                .openOrgDetailsTab();
        orgDetailPage = new OrgDetailPage(driver);
        orgDetailPage.startAssertions(OrgDetailPageAssertion.class)
                .assertAtJLROrgDetailTab()
                .endAssertion();
        customerTypesPage = new CustomerTypesPage(driver);
        customerTypesPage.openCustomerTypesTab()
                .startAssertions(CustomerTypesPageAssertion.class)
                .assertIfCustomerTypesTab()
                .endAssertion();
        commonJobsPage = new CommonJobsPage(driver);
        commonJobsPage.openGenericJobsTab()
                .startAssertions(CommonJobsPageAssertion.class)
                .assertIfGenericJobsTab()
                .endAssertion();
        bulkFluidsPage = new BulkFluidsPage(driver);
        bulkFluidsPage.openGenericParts()
                .startAssertions(BulkFluidsPageAssertion.class)
                .assertIfGenericPartsTab()
                .endAssertion();
        systemSettingsPage = new SystemSettingsPage(driver);
        systemSettingsPage.openSystemSettingsTab()
                .startAssertions(SystemSettingsPageAssertion.class)
                .assertIfSystemSettingsTab()
                .endAssertion();
        partPricingPage = new PartPricingPage(driver);
        partPricingPage.openStockUploadTab()
                .startAssertions(PartPricingPageAssertion.class)
                .assertAtStockUploadTab()
                .endAssertion();
        homePage = new HomePage(driver);
        homePage.openSupportEnquiryTab()
                .startAssertions(HomePageAssertion.class)
                .assertAtHelpAndSupport()
                .endAssertion();
        super.close();
    }

    @When("Login as an Salesperson jlr user.")
    public void login_as_an_Salesperson_jlr_user() {
        super.setUp();
        loginPage = new LoginPage(driver);
        loginPage.startAssertions(LoginPageAssertion.class)
                .assertAtLoginPage()
                .endAssertion();
        loginPage.inputDealerID(configuration.getDealerId())
                .inputUserID(configuration.getSalesUserId())
                .inputPassword(configuration.getPassword())
                .loginBtn()
        ;
    }

    @When("Select the market dropdown, and select Spain.")
    public void select_the_market_dropdown_and_select_Spain() {
        super.setUp();
        loginPage = new LoginPage(driver);
        loginPage.startAssertions(LoginPageAssertion.class)
                .assertAtLoginPage()
                .endAssertion()
                .inputDealerID(configuration.getSpainDealerId())
                .inputUserID(configuration.getSpainUserId())
                .selectMarket(Market.ES)
                .spainMarketLoginBtn()

        ;
    }

    @Then("The dropdown presents a list of country, once selected the market will change to that country.")
    public void the_dropdown_presents_a_list_of_country_once_selected_the_market_will_change_to_that_country() {
        loginPage.startAssertions(LoginPageAssertion.class)
                .assertIfDropdownSelectedMarketWillChangeToThatCountry()
                .endAssertion()
        ;
    }

    @When("Attempt to login using a default account.")
    public void attempt_to_login_using_a_default_account() {
        loginPage.inputDealerID(configuration.getSpainDealerId())
                .inputUserID(configuration.getSpainUserId())
                .selectMarket(Market.ES)
                .spainMarketLoginBtn()
        ;
    }

    @When("Login using dealer setup for that country")
    public void login_using_dealer_setup_for_that_country() {
        loginPage.inputDealerID(configuration.getSpainDealerId())
                .inputUserID(configuration.getSpainUserId())
                .inputPassword(configuration.getSpainPassword())
                .selectMarket(Market.ES)
                .spainMarketLoginBtn()
        ;
    }

    @Then("The user is able to successfully login using a spanish dealer {string}.")
    public void the_user_is_able_to_successfully_login_using_a_spanish_dealer(String mainTabName) {
        homePage = new HomePage(driver);
        homePage.startAssertions(HomePageAssertion.class)
                .assertIfPageIsTranslatedCorrectly(mainTabName)
                .endAssertion()
        ;
    }

    @After
    public void close() {
        super.close();
    }
}