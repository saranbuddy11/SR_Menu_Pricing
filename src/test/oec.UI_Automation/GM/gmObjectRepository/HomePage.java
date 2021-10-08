package GM.gmObjectRepository;

import GM.gmObjectRepository.administration.SystemSettingsPage;
import base.FunctionalLibrary;
import model.ManualMatchOption;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Arrays;
import java.util.List;

public class HomePage extends FunctionalLibrary {
    private static final Log logger = LogFactory.getLog(HomePage.class);

    private static final String USERDETAILS_XPATH = "//div[@id='user-details']";
    private static final String LOGOUTBTN_XPATH = "//div[@id='application-logout']";
    private static final String CREATE_ESTIMATE_TAB_XPATH = "//span[@id='mt2']";
    private static final String VIN_Input_XPATH = "//input[@name='VIN']";
    private static final String SEARCH_BUTTON_XPATH = "//input[@name='btnSearch']";
    private static final String VEHICLE_DETAILS_XPATH = "//td[@valign='top']";
    private static final String SERVICE_ADD_ON_EXPAND_XPATH = "//img[@id='img_O4']";
    private static final String CABIN_FILTER_XPATH = "//img[@id='img_O647']";
    private static final String REMOVE_AND_REPLACE_XPATH = "//div[@id='l_J568']";
    private static final String ESTIMATE_WORK_ITEM_XPATH = "//td[contains(text(),'Cabin Filter Remove & Replace')]";
    private static final String CONTINUE_BUTTON_XPATH = "//input[@id='btnContinue']";
    private static final String NOTES_INPUT_XPATH = "//textarea[@name='notes']";
    private static final String ESTIMATE_SPAN_XPATH = "(//span[contains(text(),'Estimate')])[2]";
    private static final String CUSTOMER_NAME_STATUS_XPATH = "(//td[@class='status-content'])[1]";
    private static final String CUSTOMER_ADDRESS_STATUS_XPATH = "(//td[@class='status-address'])[1]";
    private static final String CUSTOMER_POSTCODE_STATUS_XPATH = "(//td[@class='status-address'])[2]";
    private static final String SAVE_BUTTON_XPATH = "//input[@value='Save']";
    private static final String ESTIMATE_NO_XPATH = "(//td[@class='status-content'])[4]";
    private static final String ESTIMATE_STATUS_XPATH = "(//td[@class='status-content'])[6]";
    private static final String BRAND_IMAGE_XPATH = "(//input[@type='image'])[%d]";

    @FindBy(xpath = USERDETAILS_XPATH)
    private WebElement userDetails;
    @FindBy(xpath = LOGOUTBTN_XPATH)
    private WebElement logoutbtn;
    @FindBy(xpath = CREATE_ESTIMATE_TAB_XPATH)
    private WebElement createEstimateTab;
    @FindBy(xpath = VIN_Input_XPATH)
    private WebElement vinInput;
    @FindBy(xpath = SEARCH_BUTTON_XPATH)
    private WebElement searchBtn;
    @FindBy(xpath = VEHICLE_DETAILS_XPATH)
    private WebElement vehicleDetails;
    @FindBy(xpath = SERVICE_ADD_ON_EXPAND_XPATH)
    private WebElement serviceAddOnExpand;
    @FindBy(xpath = CABIN_FILTER_XPATH)
    private WebElement cabinFilterExpand;
    @FindBy(xpath = REMOVE_AND_REPLACE_XPATH)
    private WebElement removeAndReplace;
    @FindBy(xpath = ESTIMATE_WORK_ITEM_XPATH)
    private WebElement estimateWorkItem;
    @FindBy(xpath = CONTINUE_BUTTON_XPATH)
    private WebElement continueBtn;
    @FindBy(xpath = NOTES_INPUT_XPATH)
    private WebElement notesInput;
    @FindBy(xpath = ESTIMATE_SPAN_XPATH)
    private WebElement estimateSpan;
    @FindBy(xpath = CUSTOMER_NAME_STATUS_XPATH)
    private WebElement customerStatusContent;
    @FindBy(xpath = CUSTOMER_ADDRESS_STATUS_XPATH)
    private WebElement customerAddressContent;
    @FindBy(xpath = CUSTOMER_POSTCODE_STATUS_XPATH)
    private WebElement customerPostcodeContent;
    @FindBy(xpath = SAVE_BUTTON_XPATH)
    private WebElement saveBtn;
    @FindBy(xpath = ESTIMATE_NO_XPATH)
    private WebElement estimateNo;
    @FindBy(xpath = ESTIMATE_STATUS_XPATH)
    private WebElement estimateStatus;
    @FindBy(xpath = "//div[@id='localMenuSelectionPane']")
    private WebElement localMenuSelectionPane;
    @FindBy(xpath = "//td[contains(text(),'Manufacturer Menu')]//following-sibling::td//a[contains(text(),'Add to estimate')]")
    private WebElement addTOQuote;
    @FindBy(xpath = "//div[@id='l_O661']//span//img[contains(@src,'images/plus')]")
    private WebElement removeAndReplaceExpandIcon;
    @FindBy(xpath = "//div[@id='l_O568']")
    private WebElement removeAndReplace1;
    @FindBy(xpath = "//span[contains(text(),'Administration')]")
    private WebElement adminTab;
    @FindBy(xpath = "//div[contains(@aria-describedby, 'dialog-alert')]")
    private WebElement warningDialog;
    @FindBy(xpath = "//span[contains(text(), 'OK')]")
    private WebElement warningOKButton;
    @FindBy(xpath = "//input[@value='Labour']")
    private WebElement labourButton;
    @FindBy(xpath = "//td[contains(text(), 'Cost')]//following-sibling::td")
    private WebElement priceCost;
    @FindBy(xpath = "(//td[contains(text(), 'Price')]//following-sibling::td)[1]")
    private WebElement priceexVAT;
    @FindBy(xpath = "//input[@value='New Quote']")
    private WebElement newQuote;
    @FindBy(xpath = "//td[contains(text(), 'Retailer')]//following-sibling::td")
    private WebElement quoteName;
    @FindBy(xpath = "//p[@id='dialog-alert-content']")
    private WebElement warningMessage;

    public HomePage(WebDriver driver) {
        super(driver);
    }

//    public LoginPage logoutBtn() {
//        logger.info(": method start");
//        logoutbtn.click();
//        return new LoginPage(getDriver());
//    }

    public HomePage createEstimateTab() {
        logger.info(": method start");
        createEstimateTab.click();
        return this;
    }

//    public HomePage inputVIN(String vin) {
//        logger.info(": method start");
//        vinInput.clear();
//        vinInput.sendKeys(vin);
//        return this;
//    }
//
//    public HomePage searchBtn() {
//        logger.info(": method start");
//        searchBtn.click();
//        return this;
//    }
//
//    public boolean isVehicleFound() {
//        logger.info(": method start");
//        fluentWait(vehicleDetails);
//        waitUntil(ExpectedConditions.visibilityOf(vehicleDetails));
//        return vehicleDetails.isDisplayed();
//    }

    public HomePage serviceAddOnExpand() {
        logger.info(": method start");
        serviceAddOnExpand.click();
        return this;
    }

    public HomePage cabinFilterExpand() {
        logger.info(": method start");
        waitInSec(5);
        cabinFilterExpand.click();
        return this;
    }

    public HomePage removeAndReplace() {
        logger.info(": method start");
        try {
            removeAndReplaceExpandIcon.click();
            removeAndReplace.click();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            removeAndReplace1.click();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            waitInSec(2);
            if (localMenuSelectionPane.isDisplayed()) {
                addTOQuote.click();
            }
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
        return this;
    }

    public boolean jobWorkItemInEstimate() {
        logger.info(": method start");
        fluentWait(estimateWorkItem);
        waitUntil(ExpectedConditions.visibilityOf(estimateWorkItem));
        return estimateWorkItem.isDisplayed();
    }

//    public HomePage continueBtnClick() {
//        logger.info(": method start");
//        continueBtn.click();
//        return this;
//    }

    public HomePage inputNotesDetails(String notes) {
        logger.info(": method start");
        fluentWait(notesInput);
        notesInput.clear();
        notesInput.sendKeys(notes);
        return this;
    }

    public boolean isEstimateSelected() {
        logger.info(": method start");
        fluentWait(estimateSpan);
        waitUntil(ExpectedConditions.visibilityOf(estimateSpan));
        return estimateSpan.isEnabled();
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

    public HomePage saveBtn() {
        logger.info(": method start");
        saveBtn.click();
        return this;
    }

//    public boolean isSaveBtnEnabled() {
//        logger.info(": method start");
//        fluentWait(saveBtn);
//        waitUntil(ExpectedConditions.visibilityOf(saveBtn));
//        return saveBtn.isEnabled();
//    }

    public boolean isEstimateNoIsDisplayed() {
        logger.info(": method start");
        fluentWait(estimateNo);
        waitUntil(ExpectedConditions.visibilityOf(estimateNo));
        return estimateNo.isDisplayed();
    }

    public String getEstimateNo() {
        logger.info(": method start");
        waitUntil(ExpectedConditions.visibilityOf(estimateNo));
        String quoteNoText = estimateNo.getText();
        return quoteNoText;
    }

    public boolean isEstimateStatusDisplayed() {
        logger.info(": method start");
        fluentWait(estimateStatus);
        waitUntil(ExpectedConditions.visibilityOf(estimateStatus));
        return estimateStatus.isDisplayed();
    }

    public String getEstimateStatus() {
        logger.info(": method start");
        waitUntil(ExpectedConditions.visibilityOf(estimateStatus));
        String estimateStatusText = estimateStatus.getText();
        return estimateStatusText;
    }

    private static final String SEARCH_VIN_RESULTS = "(//tr[contains(@onclick,'javascript:SelectRow')]//td[%d])[%d]";
    private static final String SEARCH_VIN_RESULTS_SIZE = "//tr[contains(@onclick,'javascript:SelectRow')]//td[%d]";
    private static final String CUSTOMER_SEARCH_RESULTS = "//table[@id='DataTable']//tbody//tr[2]//td[%d]";
    private static final String CUSTOMER_DETAILS_SEARCH_RESULTS = "//td[contains(text(),'%s')]";

    @FindBy(xpath = "//div[@id='tab3']")
    private WebElement maintainQuotesTab;
    //    @FindBy(xpath = "//div[@id='user-details']")
//    private WebElement userDetails;
    @FindBy(xpath = "//*[contains(@name,'logout')]")
    private WebElement logoutBtn;
    @FindBy(xpath = "//a[contains(text(),'Logout')]")
    private WebElement smokeLogoutBtn;
    @FindBy(xpath = "//span[@id='mt2']")
    private WebElement createQuoteTab;
    @FindBy(xpath = "//input[@name='registration']")
    private WebElement regNoInput;
    //    @FindBy(id = "theSearchButton")
//    private WebElement searchBtn;
    @FindBy(xpath = "//input[@name='btnSearch']")
    private WebElement searchBtnGm;
    //    @FindBy(xpath = "(//td[@vAlign='top'])[1]")
//    private WebElement vehicleDetails;
    @FindBy(xpath = "(//span[contains(text(),'Quote')])[2]")
    private WebElement quoteSpan;
    @FindBy(xpath = "//img[@id='img_O1']")
    private WebElement servicingExpandToggle;
    @FindBy(xpath = "//div[contains(text(),'Remove & Replace Compressor')]")
    private WebElement jobWorkItem;
    @FindBy(xpath = "//td[contains(text(),'Mileage Servicing 20,000 Mls / 30,000 KM')]")
    private WebElement quoteWorkItem;
    @FindBy(xpath = "//td[contains(text(),'Compressor & Drive Remove & Replace Compressor')]")
    private WebElement jlrQuoteWorkItem;
    @FindBy(xpath = "//img[@src='/evolution/images/icon/checksheet.gif']")
    private WebElement jobSheetIcon;
    //    @FindBy(xpath = "//input[@id='btnContinue']")
//    private WebElement continueBtn;
    @FindBy(xpath = "//input[@name='distance']")
    private WebElement distanceInput;
    @FindBy(xpath = "//input[@name='serviceCardNumber']")
    private WebElement serviceCardNoInput;
    //    @FindBy(xpath = "//textarea[@name='notes']")
//    private WebElement notesInput;
//    @FindBy(xpath = "//input[@value='Save']")
//    private WebElement saveBtn;
    @FindBy(xpath = "(//td[@class='status-content'])[4]")
    private WebElement quoteNo;
    @FindBy(xpath = "(//td[@class='status-content'])[6]")
    private WebElement quoteStatus;
    @FindBy(xpath = "//img[@id='img_O3']")
    private WebElement clutchExpandToggle;
    @FindBy(xpath = "//img[@id='img_O634']")
    private WebElement clutchCompleteExpandToggle;
    @FindBy(xpath = "//img[@id='img_O793']")
    private WebElement airConditioningExpandToggle;
    @FindBy(xpath = "//img[@id='img_O1105']")
    private WebElement compressorDriveExpandToggle;
    //    @FindBy(xpath = "//input[@name='VIN']")
//    private WebElement vinInput;
    @FindBy(xpath = "//div[@class='no-results']")
    private WebElement gmVinErrorMsg;
    @FindBy(xpath = "//input[@name='registration']")
    private WebElement licNo;
    @FindBy(xpath = "//input[@name='customer']")
    private WebElement gmCustomerName;
    @FindBy(xpath = "//input[@value='Clear']")
    private WebElement clearBtn;
    @FindBy(xpath = "//input[@name='engineNumber']")
    private WebElement engineNo;
    @FindBy(xpath = "//tr[contains(@id,'-1ea701a4:174e3610607:-')]//td")
    private List<WebElement> customerDetails;
    @FindBy(xpath = "//tr[@class='unselectedrow_searchVehicle']//td")
    private List<WebElement> customerVehicleDetails;
    @FindBy(xpath = "//input[@disabled='disabled']")
    private WebElement continueBtnDisable;
    @FindBy(xpath = "//td[contains(text(),'1G1ZA5ST1HF190045 ')]")
    private WebElement selectARowInSearchVehicle;
    @FindBy(xpath = "//input[@name='address']")
    private WebElement address;
    @FindBy(xpath = "//input[@name='postcode']")
    private WebElement zipCode;
    @FindBy(xpath = "//input[@type='text']")
    private List<WebElement> searchFieldText;
    @FindBy(xpath = "//input[contains(@value,'New')]")
    private WebElement newEstimateBtn;
    @FindBy(xpath = "//div[@class='manual-match']")
    private WebElement manualMatchField;
    @FindBy(xpath = "(//select[@class='select-200'])[1]")
    private WebElement salesMake;
    @FindBy(xpath = "//select[@name='item[1].column[0].selection']")
    private WebElement model;
    @FindBy(xpath = "//select[@name='item[2].column[0].selection']")
    private WebElement year;
    @FindBy(xpath = "//select[@name='item[3].column[0].selection']")
    private WebElement cc;
    @FindBy(xpath = "//select[@name='item[3].column[1].selection']")
    private WebElement badge;
    @FindBy(xpath = "//select[@name='item[4].column[0].selection']")
    private WebElement engine;
    @FindBy(xpath = "(//select[@class='select-200']//option[@selected='selected'])[1]")
    private WebElement selectedSalesMake;
    @FindBy(xpath = "(//select[@class='select-200']//option[@selected='selected'])[3]")
    private WebElement selectedModel;
    @FindBy(xpath = "(//select[@class='select-200']//option[@selected='selected'])[5]")
    private WebElement selectedYear;
    @FindBy(xpath = "(//a[@class='newQuoteInfo'])[1]")
    private WebElement unpricedCommonCustomJobsLink;
    @FindBy(xpath = "//*[contains(text(),'Administration')]")
    private WebElement administrationBtn;
    @FindBy(xpath = "//a[contains(text(),'Menu Manager')]")
    private WebElement menuManagerBtn;
    @FindBy(id = "mt2")
    private WebElement createEstimateBtn;
    @FindBy(id = "mt3")
    private WebElement maintainEstimatesBtn;
    @FindBy(xpath = "//a[contains(text(),'Bulk Fluids')]")
    private WebElement bulkFluids;
    @FindBy(xpath = "//a[contains(text(),'Org. Detail')]")
    private WebElement orgDetails;
    @FindBy(xpath = "//span[contains(text(),'Search')]")
    private WebElement searchEstimatesTab;
    @FindBy(xpath = "//a[contains(text(),'Help & Support')]")
    private WebElement helpAndSupportBtn;
    @FindBy(xpath = "//div[@class='main-tab']//a")
    private List<WebElement> headers1;
    @FindBy(xpath = "//div[@class='main-tab']//span")
    private WebElement currentHeader;
    @FindBy(xpath = "//td[contains(text(),'SeleniumTesting')]//following-sibling::td//a//img[contains(@src,'bin')]")
    private WebElement listRulesBinIcon;
    @FindBy(xpath = "//span[contains(text(),'OK')]")
    private WebElement okBtn;
    @FindBy(xpath = "//p[contains(@id,'dialog')]")
    private WebElement warnMsg;
    @FindBy(xpath = "//tr[contains(@onclick,'javascript:SelectRow')]//td[2]")
    private List<WebElement> searchVinResult;
    @FindBy(xpath = "//input[contains(@src,'/jlrmp/images/brand-logo/jaguar')]")
    private WebElement brand1;
    @FindBy(xpath = "//input[contains(@src,'/jlrmp/images/brand-logo/landrover')]")
    private WebElement brand2;
    @FindBy(xpath = "//span[contains(text(),'X760 XE')]//parent::div//input")
    private WebElement vehicleModelX70;
    @FindBy(xpath = "//span[contains(text(),'L538 RR Evoque')]//parent::div//input")
    private WebElement vehicleModelL538;
    @FindBy(xpath = "(//a[@class='newQuoteInfo'])[2]")
    private WebElement genericPartsPriceLink;
    @FindBy(xpath = "//span[contains(text(),'Cancel')]")
    private WebElement cancelBtn;
    @FindBy(xpath = "//a[contains(text(),'Support Enquiry')]")
    private WebElement supportEnquiry;
    @FindBy(xpath = "//a[contains(@onclick,'doDownload')]")
    private WebElement enquiry;
    @FindBy(xpath = "//a[contains(text(),'Exp. PartAndLabour')]")
    private WebElement expPartAndLabour;
    @FindBy(xpath = "//span[contains(text(),'Historic Quotes')]")
    private WebElement historicQuotes;
    @FindBy(xpath = "//td[contains(text(),'SALVA2AE2EH894156')]")
    private WebElement searchVehicle;
    @FindBy(xpath = "//td[contains(text(),'SALVA2AE2CH600459')]")
    private WebElement searchVehicle1;
    @FindBy(xpath = "//a[contains(text(),'Lost Sales')]")
    private WebElement lostSalesBtn;
    @FindBy(xpath = "//*[contains(text(),'User Maint.')]")
    private WebElement userManagement;
    @FindBy(xpath = "//tr[@id='vehicle']//td[contains(text(), 'VIN')]")
    private WebElement VINLabel;
    @FindBy(xpath = "//tr[@id='vehicle']//td[contains(text(), 'Reg No')]")
    private WebElement regNoLabel;
    @FindBy(xpath = "//span[contains(text(), 'Job Configurator')]")
    private WebElement jobConfiguratorTab;
    @FindBy(xpath = "//span[contains(text(), 'List Rules')]")
    private WebElement listRules;
    @FindBy(xpath = "//span[contains(text(), 'Config Admin')]")
    private WebElement configAdminTab;
    @FindBy(xpath = "//span[contains(text(), 'Custom Labours')]")
    private WebElement customerLabourBtn;

   public LoginPage logoutBtn() {
        scrollToTheBottom();
        waitInSec(5);
        jsClickElement(logoutBtn);
        return new LoginPage(getDriver());
    }

    public LoginPage smokeLogoutBtn() {
        waitInSec(5);
        smokeLogoutBtn.click();
        return new LoginPage(getDriver());
    }

    public HomePage createQuote() {
        waitInSec(5);
        click(createQuoteTab);
        return this;
    }

    public HomePage inputRegistrationNo(String registrationNo) {
        waitInSec(10);
        sendKeys(regNoInput, registrationNo);
        return this;
    }

    public HomePage searchBtn() {
        waitInSec(2);
        jsClickElement(searchBtn);
        return this;
    }

    public HomePage clickOnSearchBtnGM() {
        try {
            jsClickElement(searchBtnGm);
        } catch (Exception e) {
            jsClickElement(searchBtn);
        }
        return this;
    }

    public boolean isVehicleFound() {
        waitInSec(10);
        return elementIsDisplay(vehicleDetails);
    }

    public String getVehicleFound() {
        waitInSec(2);
        return getText(vehicleDetails);
    }

    public boolean isQuoteSelected() {
        waitInSec(10);
        return elementIsEnabled(quoteSpan);
    }

    public HomePage jobWorkItemToggleExpand() {
        moveToElementClick(jobWorkItem);
        return this;
    }

    public boolean isJobWorkItemInQuote() {
        waitInSec(5);
        return elementIsDisplay(quoteWorkItem);
    }

    public boolean isJLRJobWorkItemInQuote() {
        waitInSec(5);
        return elementIsDisplay(jlrQuoteWorkItem);
    }

    public HomePage jobSheetIconClick() {
        moveToElementClick(jobSheetIcon);
        return this;
    }

    public HomePage openJobSheet() throws AWTException {

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
            e.printStackTrace();
        }
        return this;
    }

    public HomePage closeJobSheet() throws AWTException {
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
            e.printStackTrace();
        }
        return this;
    }

    public HomePage continueBtnClick() {
        scrollToTheBottom();
        waitInSec(5);
        jsClickElement(continueBtn);
        return this;
    }

    public HomePage inputQuotationDetails(String distance, String serviceNo, String notes) {
        waitInSec(5);
        sendKeys(distanceInput, distance);
        sendKeys(serviceCardNoInput, serviceNo);
        sendKeys(notesInput, notes);
        return this;
    }

    public HomePage inputQuotationDetail(String distance, String notes) {
        sendKeys(distanceInput, distance).sendKeys(notesInput, notes);
        return this;
    }

    public boolean isSaveBtnEnabled() {
        return elementIsEnabled(saveBtn);
    }

    public boolean isQuoteNoIsDisplayed() {
        return elementIsDisplay(quoteNo);
    }

    public String getQuoteNo() {
        return getText(quoteNo);
    }

    public boolean isQuoteStatusIsDisplayed() {
        return elementIsDisplay(quoteStatus);
    }

    public String getQuoteStatus() {
        return getText(quoteStatus);
    }

    public HomePage clutchToggleExpand() {
        waitInSec(5);
        click(clutchExpandToggle);
        return this;
    }

    public HomePage airConditioningToggleExpand() {
        waitInSec(5);
        moveToElementClick(airConditioningExpandToggle);
        return this;
    }

    public HomePage compressorDriveToggleExpand() {
        moveToElementClick(compressorDriveExpandToggle);
        return this;
    }

    public Boolean isCreateQuotesTabDisplayed() {
        waitInSec(5);
        return elementIsDisplay(createQuoteTab);
    }

    public HomePage inputVIN(String vin) {
        try {
            waitInSec(2);
            fluentWait(vinInput);
            sendKeys(vinInput, vin);
        } catch (java.util.NoSuchElementException exception) {
            exception.printStackTrace();
            waitInSec(5);
            sendKeys(vinInput, vin);
        }
        return this;
    }

    public HomePage pressEnterKey() {
        Robot robot = null;
        try {
            robot = new Robot();
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);

        } catch (AWTException e) {
            e.printStackTrace();
        }
        return this;
    }

    public String getGMVinErrorMsg() {
        return getText(gmVinErrorMsg);
    }

    public HomePage inputLicNo(String licNumber) {
        sendKeys(licNo, licNumber);
        return this;
    }

    public HomePage inputEngineNo(String engineNumber) {
        sendKeys(engineNo, engineNumber);
        return this;
    }

    public HomePage inputCustomerName(String customerName) {
        waitInSec(2);
        sendKeys(gmCustomerName, customerName);
        return this;
    }

    public String getEngineNo() {
        return getText(engineNo);
    }

    public String getLicNo() {
        return getText(licNo);
    }

    public HomePage clickOnClearBtn() {
        jsClickElement(clearBtn);
        return this;
    }

    public List<String> getCustomerDetails() {
        return getListOfContents(customerDetails);
    }

    public boolean isContinueBtnEnabled() {
        scrollToTheBottom();
        scrollToTheBottom();
        waitInSec(2);
        return elementIsEnabled(continueBtn);
    }

    public HomePage clickOnARowInSearchVehicle() {
        moveToElementClick(selectARowInSearchVehicle);
        return this;
    }

    public HomePage inputAddress(String customerAddress) {
        sendKeys(address, customerAddress);
        return this;
    }

    public HomePage inputZipCode(String customerZipCode) {
        sendKeys(zipCode, customerZipCode);
        return this;
    }

    public List<String> getSearchFieldInputElementsDisplayed() {
        return getListOfContents(searchFieldText);
    }

    public String getCustomerNameSearchResult(String searchDetail) {
        return getTextBasedOnIndex(String.format(CUSTOMER_DETAILS_SEARCH_RESULTS, searchDetail), 1).trim();
    }

    public String getWarningMSg() {
        return getPopUpText();
    }

    public HomePage clickOnNewEstimateBtn() {
        scrollToTheBottom();
        jsClickElement(newEstimateBtn);
        return this;
    }

    public boolean isManualMatchDisplayed() {
        return elementIsDisplay(manualMatchField);
    }

    public HomePage selectSalesMakeFromManuallyDropDown(ManualMatchOption dropDown) {
        fluentWait(salesMake);
        Select header = new Select(salesMake);
        header.selectByVisibleText(dropDown.getName());
        return this;
    }

    public HomePage selectModelFromManuallyDropDown(ManualMatchOption dropDown) {
        fluentWait(model);
        Select header = new Select(model);
        header.selectByVisibleText(dropDown.getName());
        return this;
    }

    public HomePage selectYearFromManuallyDropDown(ManualMatchOption dropDown) {
        fluentWait(year);
        Select header = new Select(year);
        header.selectByVisibleText(dropDown.getName());
        return this;
    }

    public HomePage selectCCFromManuallyDropDown(ManualMatchOption dropDown) {
        fluentWait(cc);
        Select header = new Select(cc);
        header.selectByVisibleText(dropDown.getName());
        return this;
    }

    public HomePage selectBadgeFromManuallyDropDown(ManualMatchOption dropDown) {
        fluentWait(badge);
        Select header = new Select(badge);
        header.selectByVisibleText(dropDown.getName());
        return this;
    }

    public HomePage selectEngineFromManuallyDropDown(ManualMatchOption dropDown) {
        fluentWait(engine);
        Select header = new Select(engine);
        header.selectByVisibleText(dropDown.getName());
        return this;
    }

    public List<String> getManuallySelectedInputElementsDisplayed() {
        String make = getText(selectedSalesMake);
        waitInSec(2);
        String model = getText(selectedModel);
        waitInSec(2);
        String year = getText(selectedYear);
        return Arrays.asList(make, model, year);
    }

    public HomePage clickOnUnpricedCommonCustomJobsLink() {
        scrollToTheBottom();
        jsClickElement(unpricedCommonCustomJobsLink);
        return this;
    }

    public HomePage openAdministrationTab() {
        waitInSec(2);
        click(administrationBtn);
        return this;
    }

    public HomePage openMenuManagerTab() {
        waitInSec(2);
        click(menuManagerBtn);
        try {
            listRulesBinIcon.click();
            acceptAlertIfPresent(HomePage.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this;
    }

    public HomePage openCreateEstimateTab() {
        try {
            fluentWait(createEstimateBtn);
            click(createEstimateBtn);
        } catch (java.util.NoSuchElementException exception) {
            waitInSec(5);
            jsClickElement(createEstimateBtn);
            exception.printStackTrace();
        }
        return this;
    }

    public Boolean isUnpricedCommonCustomJobsLinkDisplayed() {
        scrollToTheBottom();
        return elementIsDisplay(unpricedCommonCustomJobsLink);
    }

    public HomePage openBulkFluidsTab() {
        click(bulkFluids);
        return this;
    }

    public HomePage openOrgDetailsTab() {
        click(orgDetails);
        return this;
    }

    public HomePage openMaintainEstimatesTab() {
        click(maintainEstimatesBtn);
        return this;
    }

    public String getSearchEstimatesTabColor() {
        return getTextColor(searchEstimatesTab);
    }

    public HomePage openHelpAndSupportTab() {
        waitInSec(2);
        click(helpAndSupportBtn);
        return this;
    }

    public HomePage clickOnWarningAcceptBtn() {
        waitInSec(2);
        click(okBtn);
        return this;
    }

    public List<String> getHomePageHeaders() {
        return getListOfContents(headers1);
    }

    public String getHomePageCurrentHeaders() {
        return getText(currentHeader);
    }

    public String getDialogAlertContent() {
        return getText(warnMsg);
    }

    public int getSearchVinResultSize(int index) {
        return getSize(driver.findElements(By.xpath(String.format(SEARCH_VIN_RESULTS_SIZE, index))));
    }

    public String getSearchVinResult(int index1, int index2) {
        return getTextBasedOnDoubleIndex(SEARCH_VIN_RESULTS, index1, index2);
    }

    public String getSearchCustomerDetailResult(int index) {
        waitInSec(5);
        return getTextBasedOnIndex(CUSTOMER_SEARCH_RESULTS, index);
    }

    public HomePage clickOnJaguarLogo() {
        fluentWait(brand1);
        click(brand1);
        return this;
    }

    public HomePage clickOnLandroverLogo() {
        fluentWait(brand2);
        click(brand2);
        return this;
    }

    public HomePage clickOnVehicleModelX70() {
        fluentWait(vehicleModelX70);
        click(vehicleModelX70);
        return this;
    }

    public HomePage clickOnVehicleModelL538() {
        fluentWait(vehicleModelL538);
        click(vehicleModelL538);
        return this;
    }

    public HomePage clickOnGenericPartsPriceLink() {
        scrollToTheBottom();
        jsClickElement(genericPartsPriceLink);
        return this;
    }

    public HomePage clickOnWarningCancelBtn() {
        waitInSec(2);
        click(cancelBtn);
        return this;
    }

    public HomePage openSupportEnquiryTab() {
        waitInSec(2);
        click(supportEnquiry);
        return this;
    }

    public boolean isResultsEnquiryDisplayed() {
        return enquiry.isDisplayed();
    }

    public HomePage openExpPartAndLabourTab() {
        waitInSec(2);
        click(expPartAndLabour);
        waitInSec(2);
        return this;
    }

    public HomePage openHistoricQuotesTab() {
        waitInSec(2);
        click(historicQuotes);
        return this;
    }

    public HomePage clickOnFirstSearchVehicle() {
        waitInSec(5);
        if (System.getProperty("environment").contains("jlrmenupricingonlineqa")) {
            doubleClick(searchVehicle);
        } else if (System.getProperty("environment").contains("jlrmenupricingonlineuat")) {
            doubleClick(searchVehicle1);
        }
        return this;
    }

    public String getCreateQuoteMenuSpainName() {
        fluentWait(lostSalesBtn);
        waitInSec(2);
        return getText(createQuoteTab);
    }

    public HomePage openLostSalesTab() {
        fluentWait(lostSalesBtn);
        waitInSec(2);
        click(lostSalesBtn);
        return this;
    }

    public HomePage openUserManagementTab() {
        waitInSec(2);
        click(userManagement);
        return this;
    }

    public HomePage brandImageClick(int index) {
        logger.info(": method start");
        WebElement brandElement=driver.findElement(By.xpath(String.format(BRAND_IMAGE_XPATH,index)));
        brandElement.click();
        return this;
    }

    public HomePage clickAdminTab(){
        logger.info(": method start");
        fluentWait(adminTab);
        jsClickElement(adminTab);
        return this;
    }

    public Boolean verifyWarningDialog()
    {
        fluentWait(warningDialog);
        Boolean warningPresent = warningDialog.isDisplayed();
        return warningPresent;
    }

    public HomePage clickWarningOKButton(){
        logger.info(": method start");
        fluentWait(warningOKButton);
        jsClickElement(warningOKButton);
        return this;
    }

    public HomePage clickLabourButton(){
        logger.info(": method start");
        fluentWait(labourButton);
        click(labourButton);
        return this;
    }

    public Boolean verifyHourPrice(String cost, String priceexclVAT)
    {
        String hourCost = priceCost.getText();
        String priceVAT = priceexVAT.getText();
        if(hourCost.contains(cost) && priceVAT.contains(priceexclVAT))
        {
            return true;
        }
        else return false;
    }

    public HomePage createNewQuote()
    {
        fluentWait(newQuote);
        click(newQuote);
        waitInSec(2);
        clickWarningOKButton();
        return this;
    }

    public Boolean verifyQuoteNumber()
    {
        String quotename = quoteName.getText();
        if(quotename.equals(nextQuotenumber))
        {  return true; }
        else return false;
    }

    public Boolean verifyWarningMessage(String message)
    {
        String warning = warningMessage.getText();
        if(warning.contains(message)){
        return true;}
        else return false;
    }

    public Boolean verifyCreateQuotePage()
    {
        fluentWait(VINLabel);
        fluentWait(regNoLabel);
        if(VINLabel.isDisplayed()&&regNoLabel.isDisplayed()){
            return true;
        } else return false;
    }

    public Boolean verifyListRules()
    {
        fluentWait(listRules);
        if(listRules.isDisplayed()){
            return true;
        } else return false;
    }

    public HomePage clickJobConfigurator() {
        fluentWait(jobConfiguratorTab);
        click(jobConfiguratorTab);
        waitInSec(4);
        return this;
    }

    public HomePage clickConfigAdmin(){
        fluentWait(configAdminTab);
        click(configAdminTab);
        waitInSec(3);
        return this;
    }

    public Boolean CheckCustomLabourOption(){
        fluentWait(customerLabourBtn);
        if(customerLabourBtn.isDisplayed()){
            return true;
        } else return false;
    }

    public HomePage clickMenuManagerTab() {
        waitInSec(2);
        click(menuManagerBtn);
        return this;
    }
}

