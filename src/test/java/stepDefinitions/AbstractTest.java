package stepDefinitions;

import GM.gmObjectRepository.*;
import GM.gmObjectRepository.administration.*;
import GM.gmObjectRepository.maintainEstimates.SearchEstimatePage;
import GM.gmObjectRepository.menuManager.MenuManagerPage;
import GM.gmObjectRepository.miscellaneous.JobsPage;
import GM.gmObjectRepository.miscellaneous.LaborPage;
import GM.gmObjectRepository.miscellaneous.PartPage;
import GM.gmObjectRepository.HelpSupportPage;
import JLR.jlrObjectRepository.JLRHomePage;
import JLR.jlrObjectRepository.JLRLoginPage;
import MOPAR.moparObjectRepository.MOPARHomePage;
import MOPAR.moparObjectRepository.MOPARLoginPage;
import OPEL.opelObjectRepository.OPELHomePage;
import OPEL.opelObjectRepository.OPELLoginPage;
import base.Excel;
import base.FunctionalLibrary;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.After;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import utilsBrowser.browserSetting.*;
import utilsBrowser.configuration.Configuration;
import utilsBrowser.configuration.ConfigurationProvider;

import java.util.HashMap;
import java.util.Map;

import static javax.security.auth.login.Configuration.getConfiguration;

public abstract class AbstractTest {
    private static final Log logger = LogFactory.getLog(FunctionalLibrary.class);

    public static final String environment = getEnvironment();
    private static final String browser = getBrowser();
    protected WebDriver driver;
    public static final Boolean jslogging = Boolean.parseBoolean(System.getProperty("jslogs"));

    protected static ConfigurationProvider configurationProvider = new ConfigurationProvider();
    protected Configuration configuration = configurationProvider.getConfiguration(environment);

    protected FunctionalLibrary functionalLibrary;
    protected OPELLoginPage opelLoginPage;
    protected JLRLoginPage jlrLoginPage;
    protected OPELHomePage opelHomePage;
    protected LoginPage loginPage;
    protected HomePage homePage;
    protected JLRHomePage jlrHomePage;
    protected HelpSupportPage helpSupportPage;
    protected MOPARLoginPage moparLoginPage;
    protected MOPARHomePage moparHomePage;
    protected GMCreateEstimatePage gmCreateEstimatePage;
    protected JobsPage jobsPage;
    protected PartLaborDrillDownPage partLaborDrillDownPage;
    protected PartPage partPage;
    protected LaborPage laborPage;
    protected DealPriceIconPage dealPriceIconPage;
    protected GMCreateEstimateNotesPage gmCreateEstimateNotesPage;
    protected CommonJobsPage commonJobsPage;
    protected CustomerTypesPage customerTypesPage;
    protected GMCreateEstimateCustomerPage gmCreateEstimateCustomerPage;
    protected BulkFluidsPage bulkFluidsPage;
    protected SearchEstimatePage searchEstimatePage;
    protected SystemSettingsPage systemSettingsPage;
    protected LaborPricingPage laborPricingPage;
    protected PartPricingPage partPricingPage;
    protected OrgDetailPage orgDetailPage;
    protected GLCAndLLCPage glcAndLLCPage;
    protected MenuManagerPage menuManagerPage;
    protected CalenderPage calenderPage;
    protected ExpPartAndLabourPage expPartAndLabourPage;
    protected UserMaintainPage userMaintainPage;
    protected BulletinBoardPage bulletinBoardPage;

    protected Excel excel = new Excel();

    public WebDriver getDriver() {
        return driver;
    }

    private static String getEnvironment() {
        return System.getProperty("environment");
    }

    private void getBrowser(Map<String, BrowserSettings> props) {
        driver = BrowserFactory.getBrowser(props);
    }

    private BrowserSettings getBrowserSettings() {
        BrowserSettings browserSettings;
        switch (browser) {
            case "chrome":
                browserSettings = new ChromeSettings();
                break;
            case "firefox":
                browserSettings = new FirefoxSettings();
                break;
            case "ie":
                browserSettings = new InternetExplorerSettings();
                break;
            case "edge":
                browserSettings = new EdgeSettings();
                break;
            default:
                browserSettings = new ChromeSettings();
        }
        return browserSettings;
    }

    public void setUp() {
        BrowserSettings browserSettings = getBrowserSettings();
        setUp(new HashMap<String, BrowserSettings>() {{
            put(browser, browserSettings);
        }});
    }

    public void setUp(Map<String, BrowserSettings> props) {
        getBrowser(props);
        getConfiguration();
        openBrowser();
        maximizeBrowser();
        initializePage();
    }

    void initializePage() {
        functionalLibrary = new FunctionalLibrary(driver);
        opelLoginPage = new OPELLoginPage(driver);
        loginPage = new LoginPage(driver);
        jlrLoginPage = new JLRLoginPage(driver);
        moparLoginPage = new MOPARLoginPage(driver);
    }

    private void openBrowser() {
        driver.get(configuration.getUrl());
    }

    private static String getBrowser() {
        return System.getProperty("browser");
    }

    private void maximizeBrowser() {
        maximize();
        logger.info("Browser resolution is: " + getSize());
    }

    private Dimension getSize() {
        return driver.manage().window().getSize();
    }

    private void maximize() {
        driver.manage().window().maximize();
        logger.info("Current window maximized");
    }

    @After
    public void close() {
        if (driver != null) {
            driver.quit();
        }
    }
}
