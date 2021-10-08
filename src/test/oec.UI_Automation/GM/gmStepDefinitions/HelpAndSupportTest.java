package GM.gmStepDefinitions;

import GM.gmAssertion.ExpPartAndLabourPageAssertion;
import GM.gmAssertion.HelpSupportAssertion;
import GM.gmAssertion.HomePageAssertion;
import GM.gmAssertion.menuManager.MenuManagerPageAssertion;
import GM.gmObjectRepository.ExpPartAndLabourPage;
import GM.gmObjectRepository.HelpSupportPage;
import GM.gmObjectRepository.HomePage;
import GM.gmObjectRepository.maintainEstimates.SearchEstimatePage;
import GM.gmObjectRepository.menuManager.MenuManagerPage;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import stepDefinitions.AbstractTest;

import java.util.List;

public class HelpAndSupportTest extends AbstractTest {

    @When("H&S page should load in the a separate tab.")
    public void h_S_page_should_load_in_the_a_separate_tab() {
        super.setUp();
        homePage = functionalLibrary.gmLogIn(environment, configuration, HomePage.class);
        homePage.startAssertions(HomePageAssertion.class)
                .assertAtHomePage()
                .endAssertion()
                .openHelpAndSupportTab()
                .switchToBrowserTab(2)
        ;
    }

    @Then("The OEC H&S page loads in a separate tab, full screen with back buttons enabled.")
    public void the_OEC_H_S_page_loads_in_a_separate_tab_full_screen_with_back_buttons_enabled() {
        homePage.startAssertions(HomePageAssertion.class)
                .assertAtHelpAndSupport()
                .endAssertion()
                .goToPreviousPage(HomePage.class)
                .startAssertions(HomePageAssertion.class)
                .assertAtHelpAndSupport()
                .endAssertion();
    }

    @When("The Date Before field can be amended")
    public void the_Date_Before_field_can_be_amended(io.cucumber.datatable.DataTable dataTable) {
        List<String> data=dataTable.asList();
        super.setUp();
        homePage = functionalLibrary.jlrLogIn(environment, configuration, HomePage.class);
        homePage.startAssertions(HomePageAssertion.class)
                .assertAtHomePage()
                .endAssertion()
                .openAdministrationTab()
                .openSupportEnquiryTab();
        menuManagerPage = new MenuManagerPage(driver);
        menuManagerPage.selectDateCurrentDate()
                .setSupportEnquiryDate(data)
        ;
    }

    @Then("Field amendable {string}")
    public void field_amendable(String date) {
        menuManagerPage.startAssertions(MenuManagerPageAssertion.class)
                .assertIfDateFieldAmendable(date)
                .endAssertion()
        ;
    }

    @When("Hit Search")
    public void hit_Search() {
        searchEstimatePage = new SearchEstimatePage(driver);
        searchEstimatePage.clickOnSearchBtn();
    }

    @Then("Ensure results are correct.")
    public void ensure_results_are_correct() {
        homePage = new HomePage(driver);
        homePage.startAssertions(HomePageAssertion.class)
                .assertIfResultsAreCorrect()
                .endAssertion()
        ;
    }

    @When("Continue to Export part & labour tab.")
    public void continue_to_Export_part_labour_tab() {
        homePage.openExpPartAndLabourTab()
        ;
    }

    @Then("User is taken to the export part and labour tab.")
    public void user_is_taken_to_the_export_part_and_labour_tab() {
        expPartAndLabourPage = new ExpPartAndLabourPage(driver);
        expPartAndLabourPage.startAssertions(ExpPartAndLabourPageAssertion.class)
                .assertIfExpPartAndLabourTab()
                .endAssertion()
        ;
    }

    @Given("Login into application {string}")
    public void login_into_application(String loginPerson) {
        super.setUp();
        homePage = functionalLibrary.logIn(environment, configuration, loginPerson, HomePage.class);
        homePage.startAssertions(HomePageAssertion.class)
                .assertAtHomePage()
                .endAssertion();
    }

    @When("Check contact details for markets support centre {string}")
    public void Check_Contact_details_for_markets_support_centre(String contactDetails) {
        homePage.startAssertions(HomePageAssertion.class)
                .assertAtHomePage()
                .endAssertion()
                .brandImageClick(1);
        helpSupportPage = new HelpSupportPage(driver);
        helpSupportPage.clickHelpSupportTab()
                .startAssertions(HelpSupportAssertion.class)
                .assertContactNo(contactDetails)
                .endAssertion()
                ;
    }

    @Then("Check {string} link is present")
    public void check_link_is_present(String helpLink) {
        helpSupportPage.clickHelpSupportTab()
                .startAssertions(HelpSupportAssertion.class)
                .assertLink(helpLink)
                .endAssertion()
                ;
    }

    @Then("Click logout button")
    public void click_logout_button() {
        helpSupportPage.clickHelpSupportTab()
                .clickLogout()
                .confirmLogout()
        ;
        super.close();
    }

    @Then("Ensure able to navigate to the links visible on the Menu Pricing Help Centre {string}")
    public void ensure_able_to_navigate_to_the_links_visible_on_the_Menu_Pricing_Help_Centre(String pageTitle) {
        helpSupportPage.clickHelpLink().switchToBrowserTab(2)
                .startAssertions(HelpSupportAssertion.class)
                .assertPageTitle(pageTitle)
                .endAssertion();
        helpSupportPage.switchToBrowserTab(1)
                .startAssertions(HelpSupportAssertion.class)
                .assertAtHelpSupportPage()
                .endAssertion();
    }

    @Then("Check number of links as {string}")
    public void check_number_of_links_as(String linkCount) {
        helpSupportPage.startAssertions(HelpSupportAssertion.class)
                .assertLinkCount(linkCount)
                .endAssertion();
    }

    @Then("Download User Guide")
    public void download_User_Guide() {
        helpSupportPage.clickHelpGuide()
                  .startAssertions(HelpSupportAssertion.class)
                  .assertFileExist(environment)
                  .endAssertion()
                  ;
          helpSupportPage.deleteFile(environment);
    }

    @After
    public void close() {
        super.close();
    }
}