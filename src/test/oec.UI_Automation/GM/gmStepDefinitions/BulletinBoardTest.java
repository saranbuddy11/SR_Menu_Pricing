package GM.gmStepDefinitions;


import GM.gmAssertion.BulletinBoardAssertion;
import GM.gmAssertion.GMCreateEstimatePageAssertion;
import GM.gmAssertion.HelpSupportAssertion;
import GM.gmAssertion.HomePageAssertion;
import GM.gmAssertion.administration.SystemSettingsPageAssertion;
import GM.gmObjectRepository.BulletinBoardPage;
import GM.gmObjectRepository.GMCreateEstimatePage;
import GM.gmObjectRepository.HelpSupportPage;
import GM.gmObjectRepository.HomePage;
import GM.gmObjectRepository.administration.SystemSettingsPage;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import stepDefinitions.AbstractTest;

import java.io.IOException;


public class BulletinBoardTest extends AbstractTest {

    @Given("Login Dealer application {string}")
    public void login_dealer_application(String loginPerson) {
        super.setUp();
        homePage = functionalLibrary.logIn(environment, configuration, loginPerson, HomePage.class);
        homePage.startAssertions(HomePageAssertion.class)
                .assertAtHomePage()
                .endAssertion();
    }

    @When("clicks on Historical Newsletter and {string} window loaded with Archive letter")
    public void clicks_on_Historical_Newsletter_and_window_loaded_with_Archive_letter(String historicalLetterWindow) {
        bulletinBoardPage = new BulletinBoardPage(driver);
        bulletinBoardPage.clickBulletinBoardTab();
        bulletinBoardPage.startAssertions(BulletinBoardAssertion.class)
                .assertAtBulletinBoardPage()
                .endAssertion();
        bulletinBoardPage.clickHistoricalNewsLetter()
                .switchToSpecificWindow(historicalLetterWindow);
        bulletinBoardPage.startAssertions(BulletinBoardAssertion.class)
                .assertIfArchiveLetterLinkDisplayed()
                .endAssertion();
    }

    @Then("clicks on Cancel button and Archive letter window getting closed")
    public void clicks_on_Cancel_button_and_Archive_letter_window_getting_closed() {
          bulletinBoardPage.clickCancelHistoricalNewsLetterDialog()
                  .switchToSpecificWindow("JLR Menu Pricing");
    }

    @Then("clicks on any Archived letter and verify page updated with the news letter selected")
    public void clicks_on_any_Archived_letter_and_verify_page_updated_with_the_news_letter_selected() throws IOException {
        bulletinBoardPage = new BulletinBoardPage(driver);
        bulletinBoardPage.clickExistingArchieveLetter()
                   .switchToSpecificWindow("JLR Menu Pricing");
           bulletinBoardPage.getAchivedLetterUpdate("ArchiveNewsLetter-Actual");
           bulletinBoardPage.startAssertions(BulletinBoardAssertion.class)
                   .assertIfExpectedNewsLetterContentdisplayed("ArchiveNewsLetter-Actual.txt", "ArchiveNewsLetter-Expected.txt")
                   .endAssertion();
           driver.switchTo().defaultContent();
    }

    @When("clicks on Latest newsletter and the latest news letter will be displayed")
    public void clicks_on_Latest_newsletter_and_the_latest_news_letter_will_be_displayed() {
        bulletinBoardPage.clickLatestNewsLetter();
        bulletinBoardPage.startAssertions(BulletinBoardAssertion.class)
                .assertIfLatestNewsLetterLinkDisplayed()
                .endAssertion();
        driver.switchTo().defaultContent();
    }

    @Then("logout the application")
    public void logout_the_application() {
        helpSupportPage = new HelpSupportPage(driver);
        helpSupportPage.clickHelpSupportTab()
                .clickLogout()
                .scrollToTheBottom();
        helpSupportPage.confirmLogout()
        ;
        super.close();
    }

    @Then("Navigate to other tabs from BulletinBoard Tab")
    public void navigate_to_other_tabs_from_BulletinBoard_Tab() {
        bulletinBoardPage = new BulletinBoardPage(driver);
        bulletinBoardPage.clickBulletinBoardTab().startAssertions(BulletinBoardAssertion.class)
                .assertAtBulletinBoardPage().endAssertion();
        homePage = new HomePage(driver);
        homePage.createQuote().startAssertions(HomePageAssertion.class).
                assertIfCreateQuotePageDisplayed().endAssertion();
        bulletinBoardPage = new BulletinBoardPage(driver);
        bulletinBoardPage.clickBulletinBoardTab();
        gmCreateEstimatePage = new GMCreateEstimatePage(driver);
        gmCreateEstimatePage.clickHistoricQuoteTab().startAssertions(GMCreateEstimatePageAssertion.class)
                .assertIfHistoricQuotePageDisplayed().endAssertion();
        bulletinBoardPage = new BulletinBoardPage(driver);
        bulletinBoardPage.clickBulletinBoardTab();
        homePage = new HomePage(driver);
        homePage.openAdministrationTab();
        systemSettingsPage = new SystemSettingsPage(driver);
        systemSettingsPage.startAssertions(SystemSettingsPageAssertion.class)
                .assertIfSystemSettingstabDisplayed().endAssertion();
        bulletinBoardPage = new BulletinBoardPage(driver);
        bulletinBoardPage.clickBulletinBoardTab();
        homePage = new HomePage(driver);
        homePage.clickJobConfigurator();
        homePage.startAssertions(HomePageAssertion.class)
                .assertIfListRulesDisplayed().endAssertion();
        bulletinBoardPage = new BulletinBoardPage(driver);
        bulletinBoardPage.clickBulletinBoardTab();
        homePage = new HomePage(driver);
        homePage.clickConfigAdmin();
        homePage.startAssertions(HomePageAssertion.class).
                assertIfCustomerLabourDisplayed().endAssertion();
        bulletinBoardPage = new BulletinBoardPage(driver);
        bulletinBoardPage.clickBulletinBoardTab();
    }

    @Then("Check {string} link present")
    public void check_link_present(String helpLink) {
        homePage = new HomePage(driver);
        homePage.createQuote().brandImageClick(1);
        helpSupportPage = new HelpSupportPage(driver);
        helpSupportPage.clickHelpSupportTab()
                .startAssertions(HelpSupportAssertion.class)
                .assertLink(helpLink)
                .endAssertion();
    }
    @Then("Navigate to BulletinBoard and click on Continue button")
    public void navigate_to_BulletinBoard_and_click_on_Continue_button() {
        bulletinBoardPage = new BulletinBoardPage(driver);
        bulletinBoardPage.clickBulletinBoardTab().clickContinueBtn();
    }

    @Then("Verify Create Quote page got displayed")
    public void verify_Create_Quote_page_got_displayed() {
        homePage.createQuote().startAssertions(HomePageAssertion.class).
                assertIfCreateQuotePageDisplayed().endAssertion();
    }
    @After
    public void close() {
        super.close();
    }
}