package GM.gmStepDefinitions.administration;

import GM.gmAssertion.HomePageAssertion;
import GM.gmAssertion.LoginPageAssertion;
import GM.gmAssertion.administration.BulkFluidsPageAssertion;
import GM.gmAssertion.administration.CustomerTypesPageAssertion;
import GM.gmAssertion.administration.OrgDetailPageAssertion;
import GM.gmAssertion.administration.UserMaintainPageAssertion;
import GM.gmObjectRepository.GMCreateEstimateCustomerPage;
import GM.gmObjectRepository.HomePage;
import GM.gmObjectRepository.LoginPage;
import GM.gmObjectRepository.administration.*;
import io.cucumber.java.After;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import stepDefinitions.AbstractTest;

public class UserMaintainTest extends AbstractTest {

    @When("Click through each of the tabs Cust.Types, Generic Jobs, etc to ensure each tab is accessible.")
    public void click_through_each_of_the_tabs_Cust_Types_Generic_Jobs_etc_to_ensure_each_tab_is_accessible() {
        super.setUp();
        homePage = functionalLibrary.jlrLogIn(environment, configuration, HomePage.class);
        homePage.startAssertions(HomePageAssertion.class)
                .assertAtHomePage()
                .endAssertion()
                .openAdministrationTab()
                .openUserManagementTab();
        userMaintainPage = new UserMaintainPage(driver);
        userMaintainPage.startAssertions(UserMaintainPageAssertion.class)
                .assertAtJLRUserMaintenanceTab()
                .endAssertion()
        ;
    }

    @Then("All tabs are accessible.")
    public void all_tabs_are_accessible() {
        homePage = new HomePage(driver);
        homePage.openOrgDetailsTab();
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
        commonJobsPage.openGenericJobsTab();
        homePage = new HomePage(driver);
        homePage.startAssertions(HomePageAssertion.class)
                .assertAtGenericJobsTab()
                .endAssertion();
        bulkFluidsPage = new BulkFluidsPage(driver);
        bulkFluidsPage.openGenericParts()
                .startAssertions(BulkFluidsPageAssertion.class)
                .assertIfGenericPartsTab()
                .endAssertion();
        homePage = new HomePage(driver);
        homePage.openUserManagementTab();
        userMaintainPage = new UserMaintainPage(driver);
        userMaintainPage.startAssertions(UserMaintainPageAssertion.class)
                .assertAtJLRUserMaintenanceTab()
                .endAssertion()
        ;
    }

    @When("Log in as an Admin user and open the Administration page. Create a new user")
    public void log_in_as_an_Admin_user_and_open_the_Administration_page_Create_a_new_user() {
        userMaintainPage.clickOnNewUser()
        ;
    }

    @When("Enter new password as {string} and save.")
    public void enter_new_password_as_and_save(String password) {
        userMaintainPage.enterPassword(password)
                .clickOnSaveBtn()
        ;
    }

    @Then("Error message is shown: {string}")
    public void error_message_is_shown(String errorMsg) {
        userMaintainPage.startAssertions(UserMaintainPageAssertion.class)
                .assertIfPasswordNotAcceptedFullErrorMessageShown(errorMsg)
                .endAssertion();
        gmCreateEstimateCustomerPage = new GMCreateEstimateCustomerPage(driver);
        gmCreateEstimateCustomerPage.clickOnOKBtn()
        ;
    }

    @When("Update a users password {string} but enter a different password {string} in the confirmation field.")
    public void update_a_users_password_but_enter_a_different_password_in_the_confirmation_field(String assignPassword, String confirmPassword) {
        userMaintainPage = new UserMaintainPage(driver);
        userMaintainPage.enterAssignPassword(assignPassword)
                .enterConfirmPassword(confirmPassword)
                .clickOnSaveBtn()
        ;
    }

    @Then("Update not successful, warning message {string}")
    public void update_not_successful_warning_message(String errorMsg) {
        userMaintainPage.startAssertions(UserMaintainPageAssertion.class)
                .assertIfPasswordNotAcceptedFullErrorMessageShown(errorMsg)
                .endAssertion();
        gmCreateEstimateCustomerPage = new GMCreateEstimateCustomerPage(driver);
        gmCreateEstimateCustomerPage.clickOnOKBtn()
        ;
    }

    @When("Select an Enabled user and click the {string} button.")
    public void select_an_Enabled_user_and_click_the_button(String disable) {
        homePage = new HomePage(driver);
        homePage.openOrgDetailsTab()
                .openUserManagementTab();
        userMaintainPage = new UserMaintainPage(driver);
        userMaintainPage.clickOnNewUserTestUser()
                .clickOnBtn(disable)
        ;
    }

    @Then("The users status is changed from Enabled to {string}. Confirm this by attempting login {string}.")
    public void the_users_status_is_changed_from_Enabled_to_Confirm_this_by_attempting_login(String deactivated, String errorMsg) {
        userMaintainPage.checkOnHideDisabledUsers()
                .startAssertions(UserMaintainPageAssertion.class)
                .assertIfTheUsersStatusIsChangedFromEnabledToDeactivated(deactivated)
                .endAssertion();
        homePage = new HomePage(driver);
        homePage.logoutBtn();
        homePage.clickOnWarningAcceptBtn();
        loginPage = new LoginPage(driver);
        loginPage.inputDealerID(configuration.getDealerId())
                .inputUserID(configuration.getNewUser())
                .inputPassword(configuration.getNewPassword())
                .loginBtn()
                .startAssertions(LoginPageAssertion.class)
                .assertIfAccountDisabledSErrorMsgDisplayed(errorMsg)
                .endAssertion()
        ;
    }

    @When("Select a Disabled user and click the {string} button.")
    public void select_a_Disabled_user_and_click_the_button(String reactive) {
        loginPage.inputDealerID(configuration.getDealerId())
                .inputUserID(configuration.getUserId())
                .inputPassword(configuration.getPassword())
                .loginBtn();
        homePage = new HomePage(driver);
        homePage.openAdministrationTab()
                .openUserManagementTab();
        userMaintainPage = new UserMaintainPage(driver);
        userMaintainPage.checkOnHideDisabledUsers()
                .clickOnNewUserTestUser()
                .clickOnBtn(reactive)

        ;
    }

    @Then("The user status is changed from Disabled to {string}. Confirm this by attempting login.")
    public void the_user_status_is_changed_from_Disabled_to_Confirm_this_by_attempting_login(String enabled) {
        userMaintainPage.startAssertions(UserMaintainPageAssertion.class)
                .assertIfTheUsersStatusIsChangedFromEnabledToDeactivated(enabled)
                .endAssertion();
        homePage = new HomePage(driver);
        homePage.logoutBtn();
        homePage.clickOnWarningAcceptBtn();
        loginPage = new LoginPage(driver);
        loginPage.inputDealerID(configuration.getDealerId())
                .inputUserID(configuration.getNewUser())
                .inputPassword(configuration.getNewPassword())
                .loginBtn();
        homePage = new HomePage(driver);
        homePage.startAssertions(HomePageAssertion.class)
                .assertAtHomePage()
                .endAssertion()
                .openAdministrationTab()
                .openUserManagementTab()
        ;
    }

    @When("Click the Org. Detail tab.")
    public void click_the_Org_Detail_tab() {
        homePage.openOrgDetailsTab();
    }

    @Then("Taken to the org detail tab.")
    public void taken_to_the_org_detail_tab() {
        orgDetailPage = new OrgDetailPage(driver);
        orgDetailPage.startAssertions(OrgDetailPageAssertion.class)
                .assertAtJLROrgDetailTab()
                .endAssertion();
    }

    @After
    public void close() {
        super.close();
    }
}
