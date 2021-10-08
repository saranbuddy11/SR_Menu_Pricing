package JLR.jlrObjectRepository;

import base.FunctionalLibrary;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class JLRHomePage extends FunctionalLibrary {
    private static final Log logger = LogFactory.getLog(JLRHomePage.class);

    private static final String LOGOUTBTN_XPATH = "//input[@name='logout']";
    private static final String WARNING_OK_BUTTON_XPATH = "(//span[@class='ui-button-text'])[2]";
    private static final String CREATE_QUOTE_TAB_XPATH = "//span[@id='mt2']";
    private static final String REGISTRATION_NO_TEXT_BOX_XPATH = "//input[@name='registration']";
    private static final String SEARCH_BUTTON_XPATH = "//input[@name='btnSearch']";
    private static final String VEHICLE_DETAILS_XPATH = "//td[@valign='top']";
    private static final String QUOTE_SPAN_XPATH = "(//span[@class='act-ina'])[2]";
    private static final String EXPAND_TOGGLE_AIR_CONDITIONING_XPATH = "//img[@id='img_O793']";
    private static final String EXPAND_TOGGLE_COMPRESSOR_DRIVE_XPATH = "//img[@id='img_O1105']";
    private static final String WORK_ITEM_XPATH = "//div[@id='l_O84418']";
    private static final String QUOTE_WORK_ITEM_XPATH = "//td[contains(text(),'Compressor & Drive Remove & Replace Compressor')]";
    private static final String CONTINUE_BUTTON_XPATH = "//input[@id='btnContinue']";
    private static final String DISTANCE_TEXT_BOX_XPATH = "//input[@name='distance']";
    private static final String NOTES_TEXT_BOX_XPATH = "//textarea[@name='notes']";
    private static final String CUSTOMER_NAME_STATUS_XPATH = "(//td[@class='status-content'])[1]";
    private static final String CUSTOMER_ADDRESS_STATUS_XPATH = "(//td[@class='status-address'])[1]";
    private static final String CUSTOMER_POSTCODE_STATUS_XPATH = "(//td[@class='status-address'])[2]";
    private static final String SAVE_BUTTON_XPATH = "//input[@value='Save']";
    private static final String QUOTE_NO_XPATH = "(//td[@class='status-content'])[4]";
    private static final String QUOTE_STATUS_XPATH = "(//td[@class='status-content'])[6]";
    private static final String EXPAND_JOB_LIST_INNER_XPATH = "(//div[@class='l1']//img)[%d]";

    @FindBy(xpath = LOGOUTBTN_XPATH)
    private WebElement logoutbtn;
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
    @FindBy(xpath = EXPAND_TOGGLE_AIR_CONDITIONING_XPATH)
    private WebElement airConditioningExpandToggle;
    @FindBy(xpath = EXPAND_TOGGLE_COMPRESSOR_DRIVE_XPATH)
    private WebElement compressorDriveExpandToggle;
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
    @FindBy(xpath = "//td[contains(text(),'Manufacturer Menu ')]//parent::tr//td//a[contains(text(),'Add to quot')]")
    private WebElement localManufacture;

    public JLRHomePage(WebDriver driver) {
        super(driver);
    }

    public JLRLoginPage logoutBtn() {
        logger.info(": method start");
        logoutbtn.click();
        waitInSec(2);
        warningOkBtn.click();
        return new JLRLoginPage(getDriver());
    }

    public JLRHomePage createQuote() {
        logger.info(": method start");
        createQuoteTab.click();
        return this;
    }

    public JLRHomePage inputRegistrationNo(String registrationNo) {
        logger.info(": method start");
        regNoInput.clear();
        regNoInput.sendKeys(registrationNo);
        return this;
    }

    public JLRHomePage searchBtn(String environment) {
        logger.info(": method start");
        waitInSec(2);
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

    public JLRHomePage airConditioningToggleExpand() {
        logger.info(": method start");
        waitInSec(5);
        jsExecutor.executeAsyncScript("argument[0].click();", airConditioningExpandToggle);
        return this;
    }

    public JLRHomePage compressorDriveToggleExpand() {
        logger.info(": method start");
        action.moveToElement(compressorDriveExpandToggle).click().build().perform();
        return this;
    }

    public JLRHomePage jobWorkItemToggleExpand() {
        logger.info(": method start");
        action.moveToElement(jobWorkItem).click().build().perform();
        try {
            waitInSec(2);
            localManufacture.click();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this;
    }

    public boolean jobWorkItemInQuote() {
        logger.info(": method start");
        fluentWait(quoteWorkItem);
        waitUntil(ExpectedConditions.visibilityOf(quoteWorkItem));
        return quoteWorkItem.isDisplayed();
    }

    public JLRHomePage continueBtnClick() {
        logger.info(": method start");
        continueBtn.click();
        return this;
    }

    public JLRHomePage inputQuotationDetails(String distance, String notes) {
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

    public JLRHomePage saveBtnClick() {
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

    public JLRHomePage expandJobListInnerRow(int rowNumber) {
        clickBasedOnIndex(EXPAND_JOB_LIST_INNER_XPATH, rowNumber);
        return this;
    }
}

