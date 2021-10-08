package GM.gmStepDefinitions.administration;

import GM.gmAssertion.HomePageAssertion;
import GM.gmAssertion.administration.OrgDetailPageAssertion;
import GM.gmObjectRepository.HomePage;
import GM.gmObjectRepository.administration.OrgDetailPage;
import io.cucumber.java.After;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import stepDefinitions.AbstractTest;

public class OrgDetailTest extends AbstractTest {

    @When("Amend the name {string}.")
    public void amend_the_name(String name) {
        super.setUp();
        homePage = functionalLibrary.gmLogIn(environment, configuration, HomePage.class);
        homePage.startAssertions(HomePageAssertion.class)
                .assertAtHomePage()
                .endAssertion()
                .openAdministrationTab()
                .openOrgDetailsTab();
        orgDetailPage = new OrgDetailPage(driver);
        orgDetailPage.startAssertions(OrgDetailPageAssertion.class)
                .assertAtOrgDetailTab()
                .endAssertion()
                .enterOrgDetailInput("name", name)
        ;
    }

    @Then("Name is changed {string}")
    public void name_is_changed(String name) {
        orgDetailPage.startAssertions(OrgDetailPageAssertion.class)
                .assertIfInputValueUpdated("name", name)
                .endAssertion()
        ;
    }

    @When("Amend the contact name {string}")
    public void amend_the_contact_name(String contactName) {
        orgDetailPage.enterOrgDetailInput("contactName", contactName);
    }

    @Then("Contact name is changed {string}.")
    public void contact_name_is_changed(String contactName) {
        orgDetailPage.startAssertions(OrgDetailPageAssertion.class)
                .assertIfInputValueUpdated("contactName", contactName)
                .endAssertion()
        ;
    }

    @When("Amend the address {string}")
    public void amend_the_address(String address) {
        orgDetailPage.enterOrgDetailAddress("address", address);
    }

    @Then("Address is changed {string}")
    public void address_is_changed(String address) {
        orgDetailPage.startAssertions(OrgDetailPageAssertion.class)
                .assertIfAddressInputValueUpdated("address", address)
                .endAssertion()
        ;
    }

    @When("Amend the zip code {string}.")
    public void amend_the_zip_code(String zipCode) {
        orgDetailPage.enterOrgDetailInput("postalCode", zipCode);
    }

    @Then("Postal code is changed {string}")
    public void postal_code_is_changed(String zipCode) {
        orgDetailPage.startAssertions(OrgDetailPageAssertion.class)
                .assertIfInputValueUpdated("postalCode", zipCode)
                .endAssertion()
        ;
    }

    @When("Amend the telephone number {string}")
    public void amend_the_telephone_number(String telephoneNo) {
        orgDetailPage.enterOrgDetailInput("telephoneNumber", telephoneNo);
    }

    @Then("Telephone number is changed {string}")
    public void telephone_number_is_changed(String telephoneNo) {
        orgDetailPage.startAssertions(OrgDetailPageAssertion.class)
                .assertIfInputValueUpdated("telephoneNumber", telephoneNo)
                .endAssertion()
        ;
    }

    @When("Amend the fax number {string}")
    public void amend_the_fax_number(String faxNo) {
        orgDetailPage.enterOrgDetailInput("faxNumber", faxNo);
    }

    @Then("Fax number is changed {string}")
    public void fax_number_is_changed(String faxNo) {
        orgDetailPage.startAssertions(OrgDetailPageAssertion.class)
                .assertIfInputValueUpdated("faxNumber", faxNo)
                .endAssertion()
        ;
    }

    @When("Amend the email address {string}")
    public void amend_the_email_address(String email) {
        orgDetailPage.enterOrgDetailInput("emailAddress", email);

    }

    @Then("E-Mail address is changed {string}.")
    public void e_Mail_address_is_changed(String email) {
        orgDetailPage.startAssertions(OrgDetailPageAssertion.class)
                .assertIfInputValueUpdated("emailAddress", email)
                .endAssertion()
        ;
    }

    @When("Select the tick box to confirm the changes on this page.")
    public void select_the_tick_box_to_confirm_the_changes_on_this_page() {
        orgDetailPage.clickOnSignOffSettingsCheckBox();
    }

    @Then("The box is tickable and the warning appears By {string}")
    public void the_box_is_tickable_and_the_warning_appears_By(String warnMsg) {
        orgDetailPage.startAssertions(OrgDetailPageAssertion.class)
                .assertIfTheBoxIsTickableAndTheWarningAppears(warnMsg)
                .endAssertion()
        ;
    }

    @When("Click cancel.")
    public void click_cancel() {
        orgDetailPage.dismissAlertIfPresent(OrgDetailPage.class);
    }

    @Then("Tickbox is tickable Warning is now closed.")
    public void tickbox_is_tickable_Warning_is_now_closed() {
        orgDetailPage.startAssertions(OrgDetailPageAssertion.class)
                .assertAtOrgDetailTab()
                .endAssertion()
        ;
    }

    @When("Amend the jlr user name {string}.")
    public void amend_the_jlr_user_name(String name) {
        super.setUp();
        homePage = functionalLibrary.jlrLogIn(environment, configuration, HomePage.class);
        homePage.startAssertions(HomePageAssertion.class)
                .assertAtHomePage()
                .endAssertion()
                .openAdministrationTab()
                .openOrgDetailsTab();
        orgDetailPage = new OrgDetailPage(driver);
        orgDetailPage.startAssertions(OrgDetailPageAssertion.class)
                .assertAtJLROrgDetailTab()
                .endAssertion()
                .enterOrgDetailInput("name", name)
        ;
    }

    @After
    public void close() {
        super.close();
    }
}
