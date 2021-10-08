package GM.gmObjectRepository.maintainEstimates;

import base.FunctionalLibrary;
import model.SearchStatus;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SearchEstimatePage extends FunctionalLibrary {

    private static final String REGISTRATION_RESULT = "(//tr[@class='unselectedrow']//td[@class='registration'])[%d]";
    private static final String CUSTOMERNAME_SEARCH_RESULT = "(//tr[@class='unselectedrow']//td[@class='customer-name'])[%d]";
    private static final String DATE_SEARCH_RESULT = "(//tr[@class='unselectedrow']//td[@class='date'])[%d]";
    private static final String QUOTE_NUMBER_SEARCH_RESULT = "(//tr[@class='unselectedrow']//td[@class='quoteno-dealer'])[%d]";
    private static final String PRINT_OPTIONS = "(//div[@id=\"work-main\"]/center/table/tbody/tr/td/input)[%d]";

    @FindBy(xpath = "//select[@name='quoteStatus']")
    private WebElement quoteStatus;
    @FindBy(xpath = "//img[contains(@src,'images/icon/delete')]")
    private WebElement deletedIcon;
    @FindBy(xpath = "//img[@src='images/icon/saved.png']")
    private WebElement savedIcon;
    @FindBy(id = "theSearchButton")
    private WebElement searchBtn;
    @FindBy(xpath = "//input[@name='reset']")
    private WebElement clearBtn;
    @FindBy(xpath = "//input[@name='vin']")
    private WebElement vinTextBox;
    @FindBy(xpath = "//input[@name='regNo']")
    private WebElement regNoTextBox;
    @FindBy(xpath = "//input[@name='address']")
    private WebElement addressTextBox;
    @FindBy(xpath = "//input[@name='quoteNo']")
    private WebElement quoteNoTextBox;
    @FindBy(xpath = "//input[@name='customerName']")
    private WebElement customerNameTextBox;
    @FindBy(xpath = "//input[@name='postcode']")
    private WebElement postcodeTextBox;
    @FindBy(xpath = "(//td[@class='registration'])[2]")
    private WebElement vinSearchResult;
    @FindBy(xpath = "(//tr[@class='unselectedrow']//td[@class='registration'])")
    private List<WebElement> partialVinSearchResult;
    @FindBy(xpath = "(//tr[@class='unselectedrow']//td[@class='registration'])")
    private List<WebElement> customerNameSearchResult;
    @FindBy(xpath = "//tr[contains(@class,'unselectedrow')]//td[@class='quoteno-dealer']")
    private WebElement estimateNoSearchResult;
    @FindBy(xpath = "(//img[@src='./images/icon/calendar_edit.png'])[1]")
    private WebElement effectiveFromDateCalender;
    @FindBy(xpath = "//input[@name='dateFrom']")
    private WebElement fromDate;
    @FindBy(xpath = "(//img[@src='./images/icon/calendar_edit.png'])[2]")
    WebElement effectiveToDateCalender;
    @FindBy(xpath = "//input[@name='dateTo']")
    private WebElement toDate;
    @FindBy(xpath = "//tr[@class='unselectedrow']//td[@class='date']")
    private List<WebElement> dateSearchResult;
    @FindBy(xpath = "(//div[@class='error-absolute-centered'])/ol/li")
    private WebElement errorMsg;
    @FindBy(xpath = "//p[contains(text(),'Close')]")
    private WebElement popUpCloseBtn;
    @FindBy(xpath = "(//img[contains(@src,'images/icon/ascending')])[1]")
    private WebElement ascendingOrderArrow;
    @FindBy(xpath = "(//img[contains(@src,'images/icon/descending')])[1]")
    private WebElement descendingOrderArrow;
    @FindBy(xpath = "(//tr[@class='unselectedrow']//td[@class='quoteno-dealer'])")
    private List<WebElement> quoteNo;
    @FindBy(xpath = "//div[@class='sub-tabs']//div//a|//div[@class='sub-tabs']//div//span")
    private List<WebElement> subTabs;
    @FindBy(xpath = "//span[contains(text(),'Search')]")
    private WebElement searchTab;
    @FindBy(xpath = "//input[@value='New Search']")
    private WebElement newSearchBtn;
    @FindBy(xpath = "//input[@value='Delete']")
    private WebElement deleteBtn;
    @FindBy(xpath = "//input[@value='Print']")
    private WebElement printBtn;
    @FindBy(xpath = "//div[@id=\"work-main\"]/center/table/tbody/tr/td/input")
    private List<WebElement> printOption;
    @FindBy(xpath = "//input[@value='Detailed #2']")
    private WebElement detailed2Btn;
    @FindBy(xpath = "//input[@value='Detailed']")
    private WebElement detailedBtn;
    @FindBy(xpath = "//input[@value='Summary']")
    private WebElement summaryBtn;
    @FindBy(xpath = "//input[@value='<- Back']")
    private WebElement backBtn;
    @FindBy(xpath = "//input[@value='Copy']")
    private WebElement copyBtn;
    @FindBy(xpath = "(//td[@class='quoteno-dealer'])[2]")
    private WebElement estimateNo_Dealer;
    @FindBy(xpath = "(//p[@id='dialog-alert-content'])/ol")
    private WebElement alertMsg;
    @FindBy(xpath = "//img[@src='images/icon/flag_red.png']")
    private WebElement lostIcon;
    @FindBy(xpath = "//img[@src='images/icon/stopwatch.png']")
    private WebElement deferredIcon;
    @FindBy(xpath = "//a[contains(text(),'Quote')]")
    private WebElement quoteTab;
    @FindBy(xpath = "(//p[contains(@id,'dialog-confirm-content')])")
    private WebElement deleteConfirmMsg;
    @FindBy(xpath = "(//span[contains(text(),'Cancel')])")
    private WebElement cancelBtn;
    @FindBy(xpath = "(//span[contains(text(),'OK')])[2]")
    private WebElement okBtn;
    @FindBy(xpath = "//img[contains(@src,'/images/icon/details')]")
    private WebElement jobDetailsIcon;

    public SearchEstimatePage(WebDriver driver) {
        super(driver);
    }

    public SearchEstimatePage selectSearchStatus(SearchStatus status) {
        fluentWait(quoteStatus);
        Select header = new Select(quoteStatus);
        header.selectByVisibleText(status.getName());
        return this;
    }

    public Boolean isSavedIconDisplayed() {
        scrollToTheBottom();
        return elementIsDisplay(savedIcon);
    }

    public Boolean isDeletedIconDisplayed() {
        scrollToTheBottom();
        return elementIsDisplay(deletedIcon);
    }

    public SearchEstimatePage clickOnSearchBtn() {
        click(searchBtn);
        return this;
    }

    public SearchEstimatePage clickOnClearBtn() {
        click(clearBtn);
        return this;
    }

    public SearchEstimatePage enterVinNo(String vinNo) {
        sendKeys(vinTextBox, vinNo);
        return this;
    }

    public SearchEstimatePage enterLicNo(String licNo) {
        sendKeys(regNoTextBox, licNo);
        return this;
    }

    public SearchEstimatePage enterCustomerName(String name) {
        sendKeys(customerNameTextBox, name);
        return this;
    }

    public SearchEstimatePage enterAddress(String address) {
        sendKeys(addressTextBox, address);
        return this;
    }

    public SearchEstimatePage enterZipCode(String zipCode) {
        sendKeys(postcodeTextBox, zipCode);
        return this;
    }

    public SearchEstimatePage enterEstimateNo(String estimateNo) {
        sendKeys(quoteNoTextBox, estimateNo);
        return this;
    }

    public String getVinSearchResult() {
        scrollToTheBottom();
        return getText(vinSearchResult);
    }

    public int getVinSearchSize() {
        return getSize(partialVinSearchResult);
    }

    public String getPartialVinSearchResult(int index) {
        scrollToTheBottom();
        return getTextBasedOnIndex(REGISTRATION_RESULT, index);
    }

    public String getCustomerNameSearchResult() {
        scrollToTheBottom();
        return getText(vinSearchResult);
    }

    public int getCustomerNameSearchSize() {
        return getSize(partialVinSearchResult);
    }

    public String getCustomerNameSearchResult(int index) {
        scrollToTheBottom();
        return getTextBasedOnIndex(CUSTOMERNAME_SEARCH_RESULT, index);
    }

    public String getEstimateNoSearchResult() {
        scrollToTheBottom();
        return getText(estimateNoSearchResult);
    }

    public SearchEstimatePage enterFromDate(String date) {
        sendKeys(fromDate, date);
        return this;
    }

    public SearchEstimatePage enterToDate(String date) {
        sendKeys(toDate, date);
        return this;
    }

    public int getDateSearchResultSize() {
        return getSize(dateSearchResult);
    }

    public String getDateSearchResult(int index) {
        scrollToTheBottom();
        return getTextBasedOnIndex(DATE_SEARCH_RESULT, index);
    }

    public String getInvalidDateErrorMsg() {
        return getText(errorMsg);
    }

    public SearchEstimatePage clickOnCloseBtn() {
        click(popUpCloseBtn);
        return this;
    }

    public SearchEstimatePage clickOnAscendingOrderArrow() {
        click(ascendingOrderArrow);
        return this;
    }

    public SearchEstimatePage clickOnDescendingOrderArrow() {
        click(descendingOrderArrow);
        return this;
    }

    public int getEstimateNumberSearchSize() {
        return getSize(quoteNo);
    }

    public String getEstimateNumberSearchResult(int index) {
        scrollToTheBottom();
        return getTextBasedOnIndex(QUOTE_NUMBER_SEARCH_RESULT, index);
    }

    public SearchEstimatePage doubleClickOnSearchResultVinNo() {
        doubleClick(vinSearchResult);
        return this;
    }

    public SearchEstimatePage clickOnSearchResultVinNo() {
        click(vinSearchResult);
        return this;
    }

    public List<String> getSubTabs() {
        return getListOfContents(subTabs);
    }

    public String getColor() {
        return getTextColor(searchTab);
    }


    public SearchEstimatePage clickOnDeleteBtn() {
        scrollToTheBottom();
        click(deleteBtn);
        return this;
    }

    public String getDeleteWarningMSg() {
        return getPopUpText();
    }

    public SearchEstimatePage clickOnPrintBtn() {
        click(printBtn);
        return this;
    }


    public int getPrintOptionSize() {
        return getSize(printOption);
    }

    public Boolean isPrintOptionsDisplayedBasedOnIndex(int index) {
        scrollToTheBottom();
        return isElementDisplayedBasedOnIndex(PRINT_OPTIONS, index);
    }

    public SearchEstimatePage clickOnBackBtn() {
        click(backBtn);
        return this;
    }

    public SearchEstimatePage clickOnCopyBtn() {
        click(copyBtn);
        return this;
    }

    public String getEstimateNo() {
        return getText(estimateNo_Dealer).replaceAll("[0-9]", "");
    }

    public String getInvalidDateAlertMsg() {
        return getText(alertMsg);
    }

    public Boolean isDeferredIconDisplayed() {
        scrollToTheBottom();
        return elementIsDisplay(deferredIcon);
    }

    public Boolean isLostIconDisplayed() {
        scrollToTheBottom();
        return elementIsDisplay(lostIcon);
    }

    public SearchEstimatePage clickOnQuoteTab() {
        fluentWait(quoteTab);
        quoteTab.click();
        return this;
    }

    public SearchEstimatePage clickOnNewSearchBtn() {
        fluentWait(newSearchBtn);
        newSearchBtn.click();
        return this;
    }

    public String getDeleteConfirmMsg() {
        return getText(deleteConfirmMsg);
    }

    public SearchEstimatePage clickOnCancelBtn() {
        fluentWait(cancelBtn);
        cancelBtn.click();
        return this;
    }

    public SearchEstimatePage clickOnOKBtn() {
        fluentWait(okBtn);
        click(okBtn);
        return this;
    }

    public boolean isDetailedBtnEnabled() {
        return detailedBtn.isEnabled();
    }

    public boolean isDetailed2BtnEnabled() {
        return detailed2Btn.isEnabled();
    }

    public boolean isSummaryBtnEnabled() {
        return summaryBtn.isEnabled();
    }

    public boolean isJobDetailsIconDisplayed() {
        return jobDetailsIcon.isEnabled();
    }

}
