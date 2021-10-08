package GM.gmStepDefinitions.administration;

import GM.gmAssertion.HomePageAssertion;
import GM.gmAssertion.administration.GLCAndLLCPageAssertion;
import GM.gmObjectRepository.HomePage;
import GM.gmObjectRepository.administration.GLCAndLLCPage;
import io.cucumber.java.After;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import stepDefinitions.AbstractTest;

public class GLCAndLLCTest extends AbstractTest {

    @When("Ensure the list of GLCs & LLC's are populated")
    public void ensure_the_list_of_GLCs_LLC_s_are_populated() {
        super.setUp();
        homePage = functionalLibrary.gmLogIn(environment, configuration, HomePage.class);
        homePage.startAssertions(HomePageAssertion.class)
                .assertAtHomePage()
                .endAssertion()
                .openAdministrationTab();
        glcAndLLCPage = new GLCAndLLCPage(driver);
        glcAndLLCPage.openGLCAndLLCTab()
                .startAssertions(GLCAndLLCPageAssertion.class)
                .assertAtGLCAndLLCTab()
                .endAssertion()
                .startAssertions(GLCAndLLCPageAssertion.class)
                .assertIfGLCAndLLCListArePopulated()
                .endAssertion()
        ;
    }

    @Then("The table is populated with information")
    public void the_table_is_populated_with_information() {
        glcAndLLCPage.startAssertions(GLCAndLLCPageAssertion.class)
                .assertIfGLCAndLLCTablePopulatedWithInfo()
                .endAssertion()
        ;
    }

    @When("Assign a {string} LLC against a GLC and hit Save.")
    public void assign_a_LLC_against_a_GLC_and_hit_Save(String llc) {
        glcAndLLCPage.inputLLC(llc)
                .clickOnSaveBtn()
        ;
    }

    @Then("The LLC {string} is set against the relevant GLC and the information is saved")
    public void the_LLC_is_set_against_the_relevant_GLC_and_the_information_is_saved(String llc) {
        glcAndLLCPage.startAssertions(GLCAndLLCPageAssertion.class)
                .assertIfLLCIsSetAgainstTheRelevantGLC(llc)
                .endAssertion()
        ;
    }

    @When("Hit the {string} button")
    public void hit_the_button(String name) {
        glcAndLLCPage.clickOnCheckBox(name);
    }

    @Then("All unmapped GLC's are displayed")
    public void all_unmapped_GLC_s_are_displayed() {
        glcAndLLCPage.startAssertions(GLCAndLLCPageAssertion.class)
                .assertIfAllUnmappedGLCAreDisplayed()
                .endAssertion();
        glcAndLLCPage.clickOnCheckBox("unmapped")
        ;
    }

    @When("Search for a description {string}")
    public void search_for_a_description(String searchTerm) {
        glcAndLLCPage.clickOnCheckBox("new")
                .input("searchDescription", searchTerm)
                .clickBasedOnName("btnSearch");

    }

    @Then("{string} Results pulled back are based on the {string} term")
    public void results_pulled_back_are_based_on_the_term(String searchTerm, String name) {
        glcAndLLCPage.startAssertions(GLCAndLLCPageAssertion.class)
                .assertIfResultsPulledBackBasedOnTheSearchTerm(searchTerm)
                .endAssertion()
                .refreshSearchGLC(name)
                .clickBasedOnName("btnSearch");
        ;
    }

    @When("Search for a GLC {string}")
    public void search_for_a_GLC(String searchTerm) {
        glcAndLLCPage.input("searchGLC", searchTerm)
                .clickBasedOnName("btnSearch");
    }

    @When("Search for a LLC {string}")
    public void search_for_a_LLC(String searchTerm) {
        glcAndLLCPage.input("searchLLC", searchTerm)
                .clickBasedOnName("btnSearch");

    }

    @After
    public void close() {
        super.close();
    }
}