package MOPAR.moparObjectRepository;

import base.FunctionalLibrary;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MOPARHomePage extends FunctionalLibrary {
    private static final Log logger = LogFactory.getLog(MOPARHomePage.class);

    private static final String LOGOUT_BTN_XPATH = "//input[@onclick='doLogout();']";
    private static final String WARNING_OK_BUTTON_XPATH = "(//span[@class='ui-button-text'])[2]";
    private static final String CREATE_QUOTE_TAB_XPATH = "//span[@id='mt2']";
    private static final String REGISTRATION_NO_TEXT_BOX_XPATH = "//input[@name='registration']";
    private static final String SEARCH_BUTTON_XPATH = "//input[@name='btnSearch']";
    private static final String VEHICLE_DETAILS_XPATH = "//td[@valign='top']";
    private static final String QUOTE_SPAN_XPATH = "(//span[@class='act-ina'])[2]";
    private static final String EXPAND_TOGGLE_CLUTCH_XPATH = "//img[@id='img_O3']";
    private static final String EXPAND_TOGGLE_CLUTCH_COMPLETE_XPATH = "//img[@id='img_O634']";
    private static final String WORK_ITEM_XPATH = "//div[@id='l_O16461']";
    private static final String QUOTE_WORK_ITEM_XPATH = "//td[contains(text(),'Clutch Complete Remove & Replace Original Equipment')]";
    private static final String CONTINUE_BUTTON_XPATH = "//input[@id='btnContinue']";
    private static final String DISTANCE_TEXT_BOX_XPATH = "//input[@name='distance']";
    private static final String NOTES_TEXT_BOX_XPATH = "//textarea[@name='notes']";
    private static final String CUSTOMER_NAME_STATUS_XPATH = "(//td[@class='status-content'])[1]";
    private static final String CUSTOMER_ADDRESS_STATUS_XPATH = "(//td[@class='status-address'])[1]";
    private static final String CUSTOMER_POSTCODE_STATUS_XPATH = "(//td[@class='status-address'])[2]";
    private static final String SAVE_BUTTON_XPATH = "//input[@value='Save']";
    private static final String QUOTE_NO_XPATH = "(//td[@class='status-content'])[4]";
    private static final String QUOTE_STATUS_XPATH = "(//td[@class='status-content'])[6]";

    @FindBy(xpath = LOGOUT_BTN_XPATH)
    private WebElement logoutBtn;
    @FindBy(xpath = WARNING_OK_BUTTON_XPATH)
    private WebElement warningOkBtn;
    @FindBy(xpath = CREATE_QUOTE_TAB_XPATH)
    private WebElement createQuoteTab;
    @FindBy(xpath = REGISTRATION_NO_TEXT_BOX_XPATH)
    private WebElement regNoInput;
    @FindBy(xpath = SEARCH_BUTTON_XPATH)
    private WebElement searchBtn;
    @FindBy(xpath = VEHICLE_DETAILS_XPATH)
    private WebElement vehicleDetails;
    @FindBy(xpath = QUOTE_SPAN_XPATH)
    private WebElement quoteSpan;
    @FindBy(xpath = EXPAND_TOGGLE_CLUTCH_XPATH)
    private WebElement clutchExpandToggle;
    @FindBy(xpath = EXPAND_TOGGLE_CLUTCH_COMPLETE_XPATH)
    private WebElement clutchCompleteExpandToggle;
    @FindBy(xpath = WORK_ITEM_XPATH)
    private WebElement jobWorkItem;
    @FindBy(xpath = QUOTE_WORK_ITEM_XPATH)
    private WebElement quoteWorkItem;
    @FindBy(xpath = CONTINUE_BUTTON_XPATH)
    private WebElement continueBtn;
    @FindBy(xpath = DISTANCE_TEXT_BOX_XPATH)
    private WebElement distanceInput;
    @FindBy(xpath = NOTES_TEXT_BOX_XPATH)
    private WebElement notesInput;
    @FindBy(xpath = CUSTOMER_NAME_STATUS_XPATH)
    private WebElement customerStatusContent;
    @FindBy(xpath = CUSTOMER_ADDRESS_STATUS_XPATH)
    private WebElement customerAddressContent;
    @FindBy(xpath = CUSTOMER_POSTCODE_STATUS_XPATH)
    private WebElement customerPostcodeContent;
    @FindBy(xpath = SAVE_BUTTON_XPATH)
    private WebElement saveBtn;
    @FindBy(xpath = QUOTE_NO_XPATH)
    private WebElement quoteNo;
    @FindBy(xpath = QUOTE_STATUS_XPATH)
    private WebElement quoteStatus;

    public MOPARHomePage(WebDriver driver) {
        super(driver);
    }

    public MOPARLoginPage logoutBtn() {
        logger.info(": method start");
        logoutBtn.click();
        warningOkBtn.click();
        return new MOPARLoginPage(getDriver());
    }

    public MOPARHomePage createQuote() {
        logger.info(": method start");
        createQuoteTab.click();
        return this;
    }

    public MOPARHomePage inputRegistrationNo(String registrationNo) {
        logger.info(": method start");
        regNoInput.clear();
        regNoInput.sendKeys(registrationNo);
        return this;
    }

    public MOPARHomePage searchBtn(String environment) {
        logger.info(": method start");
        searchBtn.click();
        return this;
    }

    public boolean isVehicleFound() {
        logger.info(": method start");
        fluentWait(vehicleDetails);
        waitUntil(ExpectedConditions.visibilityOf(vehicleDetails));
        return vehicleDetails.isDisplayed();
    }

    public boolean isQuoteSelected() {
        logger.info(": method start");
        fluentWait(quoteSpan);
        waitUntil(ExpectedConditions.visibilityOf(quoteSpan));
        return quoteSpan.isEnabled();
    }

    public MOPARHomePage clutchToggleExpand() {
        logger.info(": method start");
        clutchExpandToggle.click();
        return this;
    }

    public MOPARHomePage clutchCompleteToggleExpand() {
        logger.info(": method start");
        waitInSec(2);
        clutchCompleteExpandToggle.click();
        return this;
    }

    public MOPARHomePage jobWorkItemToggleExpand() {
        logger.info(": method start");
        waitInSec(2);
        jobWorkItem.click();
        return this;
    }

    public boolean jobWorkItemInQuote() {
        logger.info(": method start");
        fluentWait(quoteWorkItem);
        waitUntil(ExpectedConditions.visibilityOf(quoteWorkItem));
        return quoteWorkItem.isDisplayed();
    }

    public MOPARHomePage continueBtnClick() {
        logger.info(": method start");
        continueBtn.click();
        return this;
    }

    public MOPARHomePage inputQuotationDetails(String distance, String notes) {
        logger.info(": method start");
        fluentWait(distanceInput);
        distanceInput.clear();
        distanceInput.sendKeys(distance);
        fluentWait(notesInput);
        notesInput.clear();
        notesInput.sendKeys(notes);
        return this;
    }

    public String getCustomerStatusContent() {
        logger.info(": method start");
        fluentWait(customerStatusContent);
        String customerName = customerStatusContent.getText();
        System.out.println(customerName);
        return customerName;
    }

    public String getCustomerAddressContent() {
        logger.info(": method start");
        fluentWait(customerAddressContent);
        String customerAddress = customerAddressContent.getText();
        return customerAddress;
    }

    public String getCustomerPostCodeContent() {
        logger.info(": method start");
        fluentWait(customerPostcodeContent);
        String customerPostCode = customerPostcodeContent.getText();
        return customerPostCode;
    }

    public MOPARHomePage saveBtnClick() {
        logger.info(": method start");
        saveBtn.click();
        return this;
    }

    public boolean isSaveBtnEnabled() {
        logger.info(": method start");
        fluentWait(saveBtn);
        waitUntil(ExpectedConditions.visibilityOf(saveBtn));
        return saveBtn.isEnabled();
    }

    public boolean isQuoteNoIsDisplayed() {
        logger.info(": method start");
        fluentWait(quoteNo);
        waitUntil(ExpectedConditions.visibilityOf(quoteNo));
        return quoteNo.isDisplayed();
    }

    public String getQuoteNo() {
        logger.info(": method start");
        waitUntil(ExpectedConditions.visibilityOf(quoteNo));
        String quoteNoText = quoteNo.getText();
        return quoteNoText;
    }

    public boolean isQuoteStatusIsDisplayed() {
        logger.info(": method start");
        fluentWait(quoteStatus);
        waitUntil(ExpectedConditions.visibilityOf(quoteStatus));
        return quoteStatus.isDisplayed();
    }

    public String getQuoteStatus() {
        logger.info(": method start");
        waitUntil(ExpectedConditions.visibilityOf(quoteStatus));
        String quoteStatusText = quoteStatus.getText();
        return quoteStatusText;
    }

}
