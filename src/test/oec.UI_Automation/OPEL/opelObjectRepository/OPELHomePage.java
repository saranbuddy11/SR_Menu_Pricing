package OPEL.opelObjectRepository;

import base.FunctionalLibrary;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.Point;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class OPELHomePage extends FunctionalLibrary {
    private static final Log logger = LogFactory.getLog(OPELHomePage.class);

    private static final String MAINTAIN_QUOTES_TAB_XPATH = "//div[@id='tab3']";
    private static final String USER_DETAILS_XPATH = "//div[@id='user-details']";
    private static final String LOGOUT_BTN_XPATH = "//div[@id='application-logout']";
    private static final String CREATE_QUOTE_TAB_XPATH = "//span[@id='mt2']";
    private static final String REGISTRATION_NO_TEXT_BOX_XPATH = "//input[@name='registration']";
    private static final String SEARCH_BUTTON_XPATH = "//input[@name='btnSearch']";
    private static final String VEHICLE_DETAILS_XPATH = "//td[@valign='top']";
    private static final String QUOTE_SPAN_XPATH = "(//span[contains(text(),'Quote')])[2]";
    private static final String EXPAND_TOGGLE_SERVICING_XPATH = "//img[@id='img_O1']";
    private static final String EXPAND_TOGGLE_MILEAGE_SERVICING_XPATH = "//img[@id='img_O42']";
    private static final String WORK_ITEM_XPATH = "//div[@id='l_O233129']";
    private static final String WORK_ITEM_MENU_XPATH = "(//a[contains(text(),'Add to quote')])[2]";
    private static final String QUOTE_WORK_ITEM_XPATH = "//td[contains(text(),'Mileage Servicing 20,000 Mls / 30,000 KM')]";
    private static final String JOB_SHEET_ICON_XPATH = "//img[@src='/evolution/images/icon/checksheet.gif']";
    private static final String CONTINUE_BUTTON_XPATH = "//input[@id='btnContinue']";
    private static final String DISTANCE_TEXT_BOX_XPATH = "//input[@name='distance']";
    private static final String SERVICE_CARD_NO_TEXT_BOX_XPATH = "//input[@name='serviceCardNumber']";
    private static final String NOTES_TEXT_BOX_XPATH = "//textarea[@name='notes']";
    private static final String CUSTOMER_NAME_STATUS_XPATH = "(//td[@class='status-content'])[1]";
    private static final String CUSTOMER_ADDRESS_STATUS_XPATH = "(//td[@class='status-address'])[1]";
    private static final String CUSTOMER_POSTCODE_STATUS_XPATH = "(//td[@class='status-address'])[2]";
    private static final String SAVE_BUTTON_XPATH = "//input[@value='Save']";
    private static final String QUOTE_NO_XPATH = "(//td[@class='status-content'])[4]";
    private static final String QUOTE_STATUS_XPATH = "(//td[@class='status-content'])[6]";

    @FindBy(xpath = MAINTAIN_QUOTES_TAB_XPATH)
    private WebElement maintainQuotesTab;
    @FindBy(xpath = USER_DETAILS_XPATH)
    private WebElement userDetails;
    @FindBy(xpath = LOGOUT_BTN_XPATH)
    private WebElement logoutBtn;
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
    @FindBy(xpath = EXPAND_TOGGLE_SERVICING_XPATH)
    private WebElement servicingExpandToggle;
    @FindBy(xpath = EXPAND_TOGGLE_MILEAGE_SERVICING_XPATH)
    private WebElement mileageServicingExpandToggle;
    @FindBy(xpath = WORK_ITEM_XPATH)
    private WebElement jobWorkItem;
    @FindBy(xpath = WORK_ITEM_MENU_XPATH)
    private WebElement jobMenuWorkItem;
    @FindBy(xpath = QUOTE_WORK_ITEM_XPATH)
    private WebElement quoteWorkItem;
    @FindBy(xpath = JOB_SHEET_ICON_XPATH)
    private WebElement jobSheetIcon;
    @FindBy(xpath = CONTINUE_BUTTON_XPATH)
    private WebElement continueBtn;
    @FindBy(xpath = DISTANCE_TEXT_BOX_XPATH)
    private WebElement distanceInput;
    @FindBy(xpath = SERVICE_CARD_NO_TEXT_BOX_XPATH)
    private WebElement serviceCardNoInput;
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
    @FindBy(xpath = "//td[contains(text(),'20,000 Mls / 30,000 KM')]//following::td//a[contains(text(),'Add to quote')]")
    private WebElement addTOQuote;
    @FindBy(xpath = "//div[@id='localMenuSelectionPane']")
    private WebElement localMenuSelectionPane;


    public OPELHomePage(WebDriver driver) {
        super(driver);
    }

    public OPELLoginPage logoutBtn() {
        logger.info(": method start");
        waitInSec(2);
        logoutBtn.click();
        return new OPELLoginPage(getDriver());
    }

    public OPELHomePage createQuote() {
        logger.info(": method start");
        createQuoteTab.click();
        return this;
    }

    public OPELHomePage inputRegistrationNo(String registrationNo) {
        logger.info(": method start");
        regNoInput.clear();
//        regNoInput.sendKeys(registrationNo);
        jsSendKeysText(regNoInput, registrationNo);
        return this;
    }

    public OPELHomePage searchBtn() {
        logger.info(": method start");
        waitInSec(2);
        jsClickElement(searchBtn);
        return this;
    }

    public boolean isVehicleFound() {
        logger.info(": method start");
        waitInSec(5);
        fluentWait(vehicleDetails);
        return vehicleDetails.isDisplayed();
    }

    public boolean isQuoteSelected() {
        logger.info(": method start");
        waitInSec(5);
        fluentWait(quoteSpan);
        return quoteSpan.isEnabled();
    }

    public OPELHomePage servicingToggleExpand() {
        logger.info(": method start");
        waitInSec(10);
        fluentWait(servicingExpandToggle);
        jsClickElement(servicingExpandToggle);
        return this;
    }

    public OPELHomePage mileageServicingToggleExpand() {
        logger.info(": method start");
        waitInSec(5);
//        mileageServicingExpandToggle.click();
        jsClickElement(mileageServicingExpandToggle);
        return this;
    }

    public OPELHomePage jobWorkItemToggleExpand() {
        logger.info(": method start");
        fluentWait(jobWorkItem);
        jobWorkItem.click();
        jsClickElement(jobWorkItem);
        //jobMenuWorkItem.click();
        return this;
    }

    public boolean jobWorkItemInQuote() {
        logger.info(": method start");
        waitInSec(5);
        fluentWait(quoteWorkItem);
        waitInSec(5);
        return quoteWorkItem.isDisplayed();
    }

    public OPELHomePage jobSheetIconClick() {
        logger.info(": method start");
        fluentWait(jobSheetIcon);
        waitInSec(2);
        action.moveToElement(jobSheetIcon).click().build().perform();
        return this;
    }

    public OPELHomePage openJobSheet() throws AWTException {
        logger.info(": method start");
        Robot robot = null;
        try {
            robot = new Robot();
            waitInSec(5);
            robot.keyPress(KeyEvent.VK_ALT);
            waitInSec(5);
            robot.keyPress(KeyEvent.VK_O);
            waitInSec(5);
            robot.keyRelease(KeyEvent.VK_ALT);
            waitInSec(5);
            robot.keyRelease(KeyEvent.VK_O);
            waitInSec(5);
        } catch (AWTException e) {
            logger.info("robot class error");
            e.printStackTrace();
        }
        return this;
    }

    public OPELHomePage closeJobSheet() throws AWTException {
        logger.info(": method start");
        Robot robot = null;
        try {
            robot = new Robot();
            waitInSec(5);
            robot.keyPress(KeyEvent.VK_CONTROL);
            waitInSec(5);
            robot.keyPress(KeyEvent.VK_Q);
            waitInSec(5);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            waitInSec(5);
            robot.keyRelease(KeyEvent.VK_Q);
            waitInSec(5);
        } catch (AWTException e) {
            logger.info("robot class error");
            e.printStackTrace();
        }
        return this;
    }

    public OPELHomePage continueBtnClick() {
        logger.info(": method start");
//        continueBtn.click();
        jsClickElement(continueBtn);
        return this;
    }

    public OPELHomePage inputQuotationDetails(String distance, String serviceNo, String notes) {
        logger.info(": method start");
        waitInSec(5);
        fluentWait(distanceInput);
        distanceInput.clear();
//        distanceInput.sendKeys(distance);
        jsSendKeysText(distanceInput, distance);
        fluentWait(serviceCardNoInput);
        serviceCardNoInput.clear();
//        serviceCardNoInput.sendKeys(serviceNo);
        jsSendKeysText(serviceCardNoInput, serviceNo);
        fluentWait(notesInput);
        notesInput.clear();
//        notesInput.sendKeys(notes);
        jsSendKeysText(notesInput, notes);
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

    public OPELHomePage saveBtnClick() {
        logger.info(": method start");
        waitInSec(2);
        jsClickElement(saveBtn);
        return this;
    }

    public boolean isSaveBtnEnabled() {
        logger.info(": method start");
        waitInSec(5);
        fluentWait(saveBtn);
        return saveBtn.isEnabled();
    }

    public boolean isQuoteNoIsDisplayed() {
        logger.info(": method start");
        fluentWait(quoteNo);
        return quoteNo.isDisplayed();
    }

    public String getQuoteNo() {
        logger.info(": method start");
        fluentWait(quoteNo);
        String quoteNoText = quoteNo.getText();
        return quoteNoText;
    }

    public boolean isQuoteStatusIsDisplayed() {
        logger.info(": method start");
        fluentWait(quoteStatus);
        return quoteStatus.isDisplayed();
    }

    public String getQuoteStatus() {
        logger.info(": method start");
        fluentWait(quoteStatus);
        waitInSec(2);
        String quoteStatusText = quoteStatus.getText();
        return quoteStatusText;
    }

    public OPELHomePage clickOnAddToQuote() {
        logger.info(": method start");
        waitInSec(10);
        try {
            if (localMenuSelectionPane.isDisplayed()) {
                waitInSec(5);
                jsClickElement(addTOQuote);
            }
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
        return this;
    }
}
