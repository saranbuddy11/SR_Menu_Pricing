package GM.gmObjectRepository;


import GM.gmObjectRepository.miscellaneous.JobsPage;
import GM.gmObjectRepository.miscellaneous.LaborPage;
import GM.gmObjectRepository.miscellaneous.PartPage;
import base.FunctionalLibrary;
import model.CustomerType;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.Arrays;
import java.util.List;

public class GMCreateEstimatePage extends FunctionalLibrary {

    private static final String EXPAND_JOB_LIST_INNER_XPATH = "(//div[@class='l1']//img)[%d]";
    private static final String EXPAND_JOB_LIST_SUB_INNER_XPATH = "(//div[@class='l2']//img)[%d]"; //[%d]
    private static final String EXPAND_JOB_LIST_LEVEL_THREE_INNER_XPATH = "(//div[@class='l3']//img)[%d]";
    private static final String ADDED_DESCRIPTION = "(//td[@class='description'])[%d]";
    private static final String ADDED_PRICE_TAX = "(//td[@class='ex-price'])[%d]";
    private static final String ADDED_QUANTITY = "(//td[@class='quantity'])[%d]";
    private static final String MAGNIFYING_GLASS_ICON = "(//img[contains(@src,'/images/icon/details')])[%d]";
    private static final String LOCAL_PRICE_FLAG_ICON = "(//img[@src='/evolution/images/icon/local_price_flag.png'])[%d]";
    private static final String ALL_PRICE_LIST = "(//div[@id='quote-detail']//table/tbody/tr[@class]/td[@class][5])[%d]";
    private static final String DELETE_ICON = "(//img[contains(@src,'/images/icon/delete')])[%d]";
    private static final String LEAF_LEVEL_THREE = "(//div[@class='l3-leaf'])[%d]";
    private static final String REAR_HEATER = "(//div[contains(text(),'(+) Rear Heater')])[%d]";
    private static final String EXPANDED_JOB_XPATH = "//div[@class='l3-leaf']";
    private static final String MODEL_YEAR_JOB = "(//div[contains(text(),'From Model Year 2014')])[%d]";
    private static final String HIGH_LEVEL_EXPANDED_JOB_XPATH = "//div[@class='l" + "%d']";
    private static final String VAN_REMOVE_COIL_SPRING = "(//div[contains(text(),'Remove & Replace Coil Spring')])[%d]";
    public static final String CALENDAR_AVAILABLE_DATE_XPATH = "//td[@class = 'available']";
    private static final String ADDED_QUOTE_DETAILS = "(//tr[@class='quote-detail'])[%d]//td[contains(@style,'left')]";
    private static final String CHILD_TREE_ELEMENT_JOBTREE = "//div[contains(@code, '%s')]";
    private static final String LABOUR_PRICE = "//td[contains(text(), '%s')]//following-sibling::td[1]";
    private static final String PART_PRICE = "(//td[contains(text(), 'Oxygen Sensor')]//following-sibling::td[2])[1]";

    @FindBy(xpath = "(//td[@class='status-content'])[2]")
    private WebElement vehicleDetails;
    @FindBy(xpath = "(//span[contains(text(),'Estimate')])[2]")
    private WebElement estimateSpan;
    @FindBy(xpath = "//div[@class='level1']/span")
    private WebElement currentSubAdministrationTab;
    @FindBy(xpath = "(//img[contains(@src,'minus.png')])[2]")
    private WebElement minimizeRow;
    @FindBy(xpath = "(//img[contains(@src,'plus.png')])[8]") //9
    private WebElement expandedRow;
    @FindBy(xpath = "(//div[@class='l3-leaf'])[2]")
    private WebElement labour15And24K;
    @FindBy(xpath = "(//td[@class='description'])[2]")
    private WebElement addedDescription;
    @FindBy(xpath = "//*[@id=\"createQuoteForm\"]/div[1]/ol/li")
    private WebElement warningMsg;
    @FindBy(xpath = "//input[@value='Job']")
    private WebElement addJobBtn;
    @FindBy(xpath = "(//input[@name='addOnItems'])[2]")
    private WebElement laborBtn;
    @FindBy(xpath = "//input[@value='Part']")
    private WebElement partBtn;
    @FindBy(xpath = "(//div[text()[contains(.,'Remove & Replace')]]//following-sibling::div//div[contains(text(),'Remove & Replace')])[1]")
    private WebElement removeAndReplaceEstimate1;
    @FindBy(xpath = "//div[@id='O647']//div")
    private WebElement removeAndReplaceEstimate;
    @FindBy(xpath = "//select[@name='customerType']")
    private WebElement customerTypes;
    @FindBy(xpath = "(//td[@class='qt4']//span[@class='price'])[1]")
    private WebElement totalPrice;
    @FindBy(xpath = "//div[@id='l_J10565']")
    private WebElement removeAndReplaceCoilSpring;
    @FindBy(css = "#l_J9735")
    private WebElement removeAndReplaceCoilSpringFromModelYear;
    @FindBy(xpath = "//div[@class='quote-items']//td[@class='description']")
    private List<WebElement> estimateJobList;
    @FindBy(xpath = "//img[contains(@src,'/images/icon/handshake')]")
    private WebElement dealPriceIcon;
    @FindBy(xpath = "//input[@value='New Estimate']")
    private WebElement newEstimate;
    @FindBy(xpath = "//input[@id='btnContinue']")
    private WebElement continueBtn;
    @FindBy(xpath = "(//*[contains(text(),'Vehicle')])[2]")
    private WebElement vehicleTab;
    @FindBy(xpath = "//a[contains(text(),'Customer')]")
    private WebElement customerTab;
    @FindBy(xpath = "//a[contains(text(),'Notes')]")
    private WebElement notesTab;
    @FindBy(xpath = "(//td[@class='status-content'])[3]")
    private WebElement vinHeader;
    @FindBy(xpath = "(//td[@class='status-content'])[5]")
    private WebElement licHeader;
    @FindBy(xpath = "//div[@id='O654']//div")
    private WebElement brakeFluid;
    @FindBy(xpath = "//div[@class='headline']")
    private WebElement replacePopUpHeader;
    @FindBy(xpath = "//div[@id='l_J65286']")
    private WebElement dualHorn;
    @FindBy(xpath = "//div[@id='l_J87316']")
    private WebElement rearAxleFluid;
    @FindBy(xpath = "//div[contains(text(),'Up To Model Year 2017')]")
    private WebElement uptoModelYear;
    @FindBy(css = "#l_O26932")
    private WebElement engineAndOilFilterReplacement;
    @FindBy(css = "#img_O1106")
    private WebElement removeCoilSpring;
    @FindBy(css = "#l_J62481")
    private WebElement removeCoilSpringFromModelYear;
    @FindBy(css = "#l_O79388")
    private WebElement removeAndReplaceHeaterCore;
    @FindBy(css = "#l_O26984")
    private WebElement engineOilReplacement;
    @FindBy(css = "#l_O76597")
    private WebElement truckRemoveCoilSpring;
    @FindBy(css = "#l_O79369")
    private WebElement truckRemoveHeaterCore;
    @FindBy(xpath = "//div[contains(text(),'Engine Oil and Oil Filter Replacement')]")
    private WebElement engineOilAndFilterReplace;
    @FindBy(xpath = "(//div[@class='l1'])[5]")
    private WebElement bodySystems;
    @FindBy(xpath = "//div[@class='l1']")
    private List<WebElement> jobs;
    @FindBy(xpath = "//div[@id='localMenuSelectionPane']")
    private WebElement localMenuSelectionPane;
    @FindBy(xpath = "//td[contains(text(),'Manufacturer Menu')]//following-sibling::td//a[contains(text(),'Add to estimate')]")
    private WebElement addTOQuote;
    @FindBy(xpath = "//td[contains(text(),'Dealer Local Menu ')]//following-sibling::td//a[contains(text(),'Add to estimate')]")
    private WebElement addDealerTOQuote;
    @FindBy(xpath = "//td[contains(text(),'Cabin Filter Remove & Replace')]//following-sibling::td[@class='ex-price']")
    private WebElement cabinFilterPrice;
    @FindBy(xpath = "//input[@value='Lost Sale']")
    private WebElement lostSaleBtn;
    @FindBy(xpath = "//p[@id='dialog-alert-content']")
    private WebElement lostSaleDialogAlert;
    @FindBy(xpath = "//select[@name='reason']//option")
    private List<WebElement> lostSaleReasons;
    @FindBy(xpath = "//input[@name='formattedPrice']")
    private WebElement formattedPrice;
    @FindBy(xpath = "//input[@value='Add']")
    private WebElement addBtn;
    @FindBy(xpath = "//input[@value='Deferred']")
    private WebElement deferredBtn;
    @FindBy(xpath = "//td[contains(@class,'day selected today')]")
    private WebElement calendarAvailable;
    @FindBy(xpath = "//img[contains(@src,'calendar_edit')]")
    private WebElement calendarEdit;
    @FindBy(xpath = "//input[@value='New Quote']")
    private WebElement newQuote;
    @FindBy(xpath = "//p[contains(@id,'dialog-confirm-content')]")
    private WebElement dialogConfirmContent;
    @FindBy(xpath = "(//span[contains(text(),'OK')])[2]")
    private WebElement okBtn;
    @FindBy(xpath = "//img[contains(@src,'/images/icon/checksheet')]")
    private WebElement checkSheetIcon;
    @FindBy(xpath = "(//img[contains(@src,'plus.png')])[2]")
    private WebElement expandedJlrRow;
    @FindBy(xpath = "//div[@id='O639']")
    private WebElement MY15DieselParticleFilter;
    @FindBy(xpath = "//p[@id='dialog-alert-content']/ol")
    private WebElement dialogAlertContent;
    @FindBy(xpath = "(//tr[@class='quote-detail'])")
    private WebElement addedQuote;
    @FindBy(xpath = "//tr[@class='total']//td[@class='qt4']//span[@class='price']")
    private WebElement addedQuotetotalPrice;
    @FindBy(xpath = "(//div[text()[contains(.,'Cabin Filter')]]//following-sibling::div//div[text()[contains(.,'Remove & Replace')]])[1]//img")
    private WebElement removeAndReplaceEstimateExpand;
    @FindBy(xpath = "(//div[text()[contains(.,'Remove & Replace Coil Spring - Both Sides')]])[3]")
    private WebElement removeAndReplaceCoilSpringBothSides;
    @FindBy(xpath = "(//div[text()[contains(.,'Horn')]]//following-sibling::div//div[text()[contains(.,'Remove & Replace')]])[1]//img")
    private WebElement removeAndReplaceHeatCore;
    @FindBy(xpath = "(//div[@class='l4'])[1]")
    private WebElement firstLevel4Job;
    @FindBy(xpath = "(//div[@class='l3-leaf'])[1]")
    private WebElement firstLevel3Job;
    @FindBy(xpath = "//td[contains(text(),'Saved')]")
    private WebElement savedStatus;
    @FindBy(xpath = "//input[@value='Export All']")
    private WebElement exportAllBtn;
    @FindBy(xpath = "//input[@value='Save']")
    private WebElement saveButton;
    @FindBy(xpath = "//input[@value='Print']")
    private WebElement printButton;
    @FindBy(xpath = "//input[contains(@value,'Detailed')]")
    private WebElement detailedButton;
    @FindBy(xpath = "//input[@value='Summary']")
    private WebElement summaryButton;
    @FindBy(xpath = "//input[contains(@value,'Back')]")
    private WebElement backButton;
    @FindBy(xpath = "//input[contains(@value,'Email')]")
    private WebElement emailButton;
    @FindBy(xpath = "//h3[contains(text(), 'Select your print option')]")
    private WebElement printOption;
    @FindBy(xpath = "//td[contains(text(), 'Total Price Excl')]")
    private WebElement totalPriceElement;
    @FindBy(xpath = "//table[@class='quote-items']//td[1]//img")
    private WebElement jobDetails;
    @FindBy(xpath = "//td[contains(text(), 'Quote type')]")
    private WebElement quoteType;
    @FindBy(xpath = "//input[@value='Send']")
    private WebElement emailSendBtn;
    @FindBy(xpath = "//input[@value='Cancel']")
    private WebElement emailCancelButton;
    @FindBy(xpath = "//table[@class='home-form']//tr[3]//td")
    private WebElement detailedButtonDialog;
    @FindBy(xpath = "//table[@class='home-form']//tr[4]//td")
    private WebElement detailed2Button;
    @FindBy(xpath = "//table[@class='home-form']//tr[5]//td")
    private WebElement summaryButtonDialog;
    @FindBy(xpath = "//p[contains(text(), 'Emailing of current quote succeeded')]")
    private WebElement mailAlertContent;
    @FindBy(xpath = "//span[contains(text(),'OK')]")
    private WebElement mailArertOKBtn;
    @FindBy(xpath = "//a[contains(@href, 'PartLabourDrillDown')]")
    private WebElement jobDetailsIcon;
    @FindBy(xpath = "//td[contains(text(), 'Labour')]//parent::tr//following-sibling::tr[2]//td[4]")
    private WebElement labourPrice;
    @FindBy(xpath = "(//div[contains(@class, 'l3') and contains(text(), 'Change')])[2]")
    private WebElement brakeFluidChange;
    @FindBy(xpath = "//input[@id='searchBox']")
    private WebElement jobSearch;
    @FindBy(xpath = "//td[contains(text(), 'Fluid-Optional')]//following-sibling::td//input")
    private WebElement fluidoptional;
    @FindBy(xpath = "//td[contains(text(), 'Fluid-Optional')]//following-sibling::td[2]")
    private WebElement fluidOptionalPrice;
    @FindBy(xpath = "//input[@value='Continue']")
    private WebElement continueButton;
    @FindBy(xpath = "//tr[@id='quote']//td[contains(text(), 'Date From')]")
    private WebElement historicPageQuoteFromDate;
    @FindBy(xpath = "//tr[@id='quote']//td[contains(text(), 'Date To')]")
    private WebElement historicPageQuoteToDate;
    @FindBy(xpath = "//span[contains(text(), 'Historic Quotes')]")
    private WebElement historicQuoteTab;
    @FindBy(xpath = "//table[@class='quote-items']//td[@class='description']")
    private List<WebElement> jobDescription;
    @FindBy(xpath = "//td[contains(text(), 'Dealer Local')]//following-sibling::td[4]//a")
    private WebElement estimatePopup;
    @FindBy(xpath = "//a[contains(text(), 'Create')]")
    private WebElement createEstimateBtn;
    @FindBy(xpath = "//td[contains(text(), 'Dealer')]//following-sibling::td[2]")
    private WebElement priceExTax;
    @FindBy(xpath = "(//td[contains(text(), 'Spark Plug')]//following-sibling::td[2])[1]")
    private WebElement jobDetailsPrice;
    @FindBy(xpath = "//td[contains(text(), 'Replace Spark Plugs')]//preceding-sibling::td[1]")
    private WebElement labourTime;
    @FindBy(xpath = "//td[contains(text(), 'Dealer')]//following-sibling::td[1]")
    private WebElement dealerDescription;
    @FindBy(xpath = "//td[contains(text(), 'SENSOR')]//following-sibling::td[2]")
    private WebElement heatedLabourPrice;
    @FindBy(xpath = "//td[contains(text(), 'Oxygen Sensor')]//following-sibling::td[2]")
    private WebElement partPriceOxygenSensor;



    public GMCreateEstimatePage(WebDriver driver) {
        super(driver);
    }

    public String getVehicleName() {
        String name = getText(vehicleDetails);
        return name;
    }

    public String getColor() {
        return getTextColor(estimateSpan);
    }

    public String getCurrentSubAdministrationTab() {
        return getText(currentSubAdministrationTab);
    }

    public GMCreateEstimatePage expandJobTreeInnerRow(int rowNumber) {
        waitInSec(10);
        clickBasedOnIndex(EXPAND_JOB_LIST_INNER_XPATH, rowNumber);
        return this;
    }

    public GMCreateEstimatePage expandJobTreeInnerRowBasedOnIndex(int rowNumber) {
        waitInSec(12);
        clickBasedOnIndex(EXPAND_JOB_LIST_INNER_XPATH, rowNumber);
        return this;
    }

    public GMCreateEstimatePage expandJobTreeSubInnerRow(int rowNumber) {
        waitInSec(2);
        clickBasedOnIndex(EXPAND_JOB_LIST_SUB_INNER_XPATH, rowNumber);
        return this;
    }

    public GMCreateEstimatePage expandJobTreeLevelThreeInnerRowBasedOnEnv(String environment, int rowNo1, int rowNo2) {
        waitInSec(2);
        if (environment.contains("uat")) {
            clickBasedOnIndex(EXPAND_JOB_LIST_LEVEL_THREE_INNER_XPATH, rowNo2);

            try {
                waitInSec(2);
                if (localMenuSelectionPane.isDisplayed()) {
                    addTOQuote.click();
                }
            } catch (NoSuchElementException e) {
                e.printStackTrace();
            }
        } else if (environment.contains("qa")) {
            waitInSec(2);
            clickBasedOnIndex(EXPAND_JOB_LIST_LEVEL_THREE_INNER_XPATH, rowNo2);
            try {
                waitInSec(2);
                if (localMenuSelectionPane.isDisplayed()) {
                    addTOQuote.click();
                }
            } catch (NoSuchElementException e) {
                e.printStackTrace();
            }
        }
        return this;
    }

    public GMCreateEstimatePage expandJobTreeLevelThreeInnerRow(int rowNo) {
        waitInSec(2);
        try {
            clickBasedOnIndex(EXPAND_JOB_LIST_LEVEL_THREE_INNER_XPATH, rowNo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this;
    }

    public GMCreateEstimatePage expandJobTreeLevelThreeInner(String environment, int index1, int index2) {
        waitInSec(2);
        int index = 0;
        if (environment.contains("qa")) {
            index = index1;
        } else if (environment.contains("uat")) {
            index = index2;
        }
        clickBasedOnIndex(EXPAND_JOB_LIST_LEVEL_THREE_INNER_XPATH, index);
        return this;
    }


    public GMCreateEstimatePage clickOnOilReplacement() {
        waitInSec(2);
        try {
            click(engineAndOilFilterReplacement);
            try {
                waitInSec(2);
                if (localMenuSelectionPane.isDisplayed()) {
                    addTOQuote.click();
                }
            } catch (NoSuchElementException exception) {
                exception.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
            engineOilReplacement.click();
            try {
                waitInSec(2);
                if (localMenuSelectionPane.isDisplayed()) {
                    addTOQuote.click();
                }
            } catch (NoSuchElementException exception) {
                exception.printStackTrace();
            }
        }
        return this;
    }

    public boolean isRowMinimized() {
        return elementIsDisplay(minimizeRow);
    }

    public boolean isRowExpanded() {
        return elementIsDisplay(expandedRow);
    }

    public GMCreateEstimatePage clickOnLabour15KAnd24K() {
        click(labour15And24K);
        return this;
    }

    public String getAddedJobs() {
        return getText(addedDescription);
    }

    public String getWarningMsg() {
        return getText(warningMsg);
    }

    public JobsPage clickOnAddMiscellaneousJobButton() {
        waitInSec(2);
        click(addJobBtn);
        return new JobsPage(getDriver());
    }

    public String getCurrentQuoteEmptyDialogAlertMsg() {
        return getText(lostSaleDialogAlert);
    }

    public List<String> getQuantityAndPrice(int index) {
        waitInSec(5);
        String price = getTextBasedOnIndex(ADDED_PRICE_TAX, index);
        String quantity = getTextBasedOnIndex(ADDED_QUANTITY, index);
        List<String> actualAddedJobResult = Arrays.asList(quantity, price);
        return actualAddedJobResult;
    }

    public List<String> getDescriptionAndPrice(int index) {
        waitInSec(5);
        String addedDescription = getTextBasedOnIndex(ADDED_DESCRIPTION, index).trim();
        String price = getTextBasedOnIndex(ADDED_PRICE_TAX, index);
        String quantity = getTextBasedOnIndex(ADDED_QUANTITY, index);
        List<String> actualAddedJobResult = Arrays.asList(quantity, addedDescription, price);
        return actualAddedJobResult;
    }


    public String getDescription(int index) {
        waitInSec(5);
        return getTextBasedOnIndex(ADDED_DESCRIPTION, index);
    }

    public LaborPage clickOnLaborMiscellaneousButton() {
        click(laborBtn);
        return new LaborPage(getDriver());
    }

    public GMCreateEstimatePage clickOnFirstLevel3Job() {
        click(firstLevel3Job);
        return this;
    }

    public GMCreateEstimatePage clickOnFirstLevel4Job() {
        click(firstLevel4Job);
        return this;
    }

    public PartPage clickOnPartMiscellaneousButton() {
        waitInSec(4);
        click(partBtn);
        return new PartPage(getDriver());
    }

    public GMCreateEstimatePage minimizeRemoveAndReplace() {
        waitInSec(2);
        try {
            click(removeAndReplaceEstimateExpand);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this;
    }

    public GMCreateEstimatePage clickOnRemoveAndReplace() {
        waitInSec(5);
        try {
            click(removeAndReplaceEstimateExpand);
            click(removeAndReplaceEstimate1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            click(removeAndReplaceEstimate);
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

    public GMCreateEstimatePage clickOnMenuManagerRemoveAndReplaceJob() {
        waitInSec(5);
        try {
            click(removeAndReplaceEstimateExpand);
            click(removeAndReplaceEstimate1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            click(removeAndReplaceEstimate);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            waitInSec(2);
            if (localMenuSelectionPane.isDisplayed()) {
                addDealerTOQuote.click();
            }
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
        return this;
    }

    public GMCreateEstimatePage doubleClickOnRemoveAndReplace() {
        fluentWait(removeAndReplaceEstimate);
        waitInSec(2);
        doubleClick(removeAndReplaceEstimate);
        return this;
    }

    public GMCreateEstimatePage selectCustomerType(CustomerType option) {
        waitInSec(2);
        Select customerType = new Select(customerTypes);
        customerType.selectByVisibleText(option.getName());
        return this;
    }

    public String getTotalPrice() {
        return getText(totalPrice);
    }

    public GMCreateEstimatePage clickOnRemoveAndReplaceCoilSpringBothSides() {
        waitInSec(2);
        jsClickElement(removeAndReplaceCoilSpring);
        return this;
    }

    public PartLaborDrillDownPage clickOnMagnifyingGlassIcon(int index) {
        waitInSec(5);
        clickBasedOnIndex(MAGNIFYING_GLASS_ICON, index);
        try {
            waitInSec(2);
            if (localMenuSelectionPane.isDisplayed()) {
                addDealerTOQuote.click();
            }
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
        return new PartLaborDrillDownPage(getDriver());
    }

    public PartLaborDrillDownPage clickOnMagnifyingGlassIcon() {
        waitInSec(5);
        WebElement element = driver.findElement(By.xpath(String.format(MAGNIFYING_GLASS_ICON, 1)));
        jsClickElement(element);
        return new PartLaborDrillDownPage(getDriver());
    }

    public GMCreateEstimatePage clickOnLocalPriceFlagIcon(int index) {
        waitInSec(2);
        clickBasedOnIndex(LOCAL_PRICE_FLAG_ICON, index);
        return this;
    }

    public GMCreateEstimatePage clickOnLevelFourJob(int index) {
        waitInSec(1);
        clickBasedOnIndex(MODEL_YEAR_JOB, index);
        return this;
    }

    public Float getPrices() {
        float addedPrice = 0.0f;
        for (int i = 2; i <= 3; i++) {
            String price = getTextBasedOnIndex(ALL_PRICE_LIST, i).replace(",", "");
            StringBuffer sb = new StringBuffer(price);
            String amount = String.valueOf(sb.delete(0, 1));
            addedPrice = addedPrice + Float.parseFloat(amount);
        }
        return addedPrice;
    }

    public GMCreateEstimatePage clickOnDeleteIcon(int rowNumber) {
        clickBasedOnIndex(DELETE_ICON, rowNumber);
        return this;
    }

    public List<String> getEstimateJobList() {
        List<String> jobList = getListOfContents(estimateJobList);
        return jobList;
    }

    public DealPriceIconPage clickOnDealPriceIcon() {
        waitInSec(2);
        scrollToTheBottom();
        jsClickElement(dealPriceIcon);
        return new DealPriceIconPage(driver);
    }

    public GMCreateEstimatePage clickOnNewEstimate() {
        waitInSec(2);
        jsClickElement(newEstimate);
        return this;
    }

    public String getPopUpMsg() {
        return driver.switchTo().alert().getText();
    }

    public GMCreateEstimatePage clickOnContinueBtn() {
        waitInSec(5);
        scrollToTheBottom();
        jsClickElement(continueBtn);
        waitInSec(2);
        return this;
    }

    public GMCreateEstimatePage clickOnVehicleTab() {
        waitInSec(2);
        jsClickElement(vehicleTab);
        return this;
    }

    public GMCreateEstimatePage clickOnCustomerTab() {
        waitInSec(2);
        jsClickElement(customerTab);
        return this;
    }

    public GMCreateEstimatePage clickOnNotesTab() {
        waitInSec(2);
        jsClickElement(notesTab);
        return this;
    }

    public List<String> getHeaderVinAndLicNo() {
        String vin = getText(vinHeader);
        String lic = getText(licHeader);
        List<String> headerVinAndLicNo = Arrays.asList(lic, vin);
        return headerVinAndLicNo;
    }

    public String getHeaderVinNo() {
        return getText(vinHeader).trim();
    }

    public GMCreateEstimatePage clickOnBrakeFluid() {
        waitInSec(2);
        click(brakeFluid);
        return this;
    }

    public String getReplaceGenericPartsHeader() {
        return getText(replacePopUpHeader);
    }

    public GMCreateEstimatePage clickOnHornDual() {
        waitInSec(2);
        click(dualHorn);
        return this;
    }

    public GMCreateEstimatePage clickOnRemoveAndReplaceCoilSpring() {
        waitInSec(2);
        click(removeCoilSpring);
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


    public GMCreateEstimatePage clickOnRemoveAndReplaceSpringCoilUpToModelYear() {
        click(removeCoilSpringFromModelYear);
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

    public GMCreateEstimatePage clickOnFromModelYear2014To2018() {
        click(rearAxleFluid);
        return this;
    }

    public GMCreateEstimatePage clickOnRemoveAndReplaceHeaterCore() {
        click(removeAndReplaceHeaterCore);
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

    public GMCreateEstimatePage clickOnTruckRemoveAndReplaceHeaterCore() {
        waitInSec(2);
        click(truckRemoveHeaterCore);
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

    public GMCreateEstimatePage clickOnLeafLevelThree(int rowNo) {
        waitInSec(2);
        clickBasedOnIndex(LEAF_LEVEL_THREE, rowNo);
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

    public GMCreateEstimatePage clickOnVanRemoveAndReplaceCoilSpring(String environment, int index1, int index2) {
        waitInSec(2);
        int index = 0;
        if (environment.contains("uat")) {
            index = index1;
        } else if (environment.contains("qa")) {
            index = index2;
        }
        clickBasedOnIndex(VAN_REMOVE_COIL_SPRING, index);
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

    public GMCreateEstimatePage clickOnTruckRemoveAndReplaceCoilSpring() {
        waitInSec(2);
        click(truckRemoveCoilSpring);
//        try {
//            waitInSec(2);
//            if (localMenuSelectionPane.isDisplayed()) {
//                addTOQuote.click();
//            }
//        } catch (NoSuchElementException e) {
//            e.printStackTrace();
//        }
        return this;
    }

    public GMCreateEstimatePage clickOnEngineOilAndFilterReplace() {
        waitInSec(2);
        doubleClick(engineOilAndFilterReplace);
        return this;
    }

    public GMCreateEstimatePage clickOnBodySystems() {
        waitInSec(2);
        doubleClick(bodySystems);
        return this;
    }

    public GMCreateEstimatePage clickOnEngineOilAndFilterReplaceCreateQuote() {
        waitInSec(2);
        click(engineOilAndFilterReplace);
        return this;
    }

    public GMCreateEstimatePage clickOnRearHeater(String environment, int index1, int index2) {
        waitInSec(2);
        int index = 0;
        if (environment.contains("qa")) {
            index = index1;
        } else if (environment.contains("uat")) {
            index = index2;
        }
        clickBasedOnIndex(REAR_HEATER, index);
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

    public String getHighlightedJob(String color) {
        String str = "";
        List<WebElement> expandedCallouts = getElementsByLocator(EXPANDED_JOB_XPATH);
        for (WebElement e : expandedCallouts) {
            if (getBackgroundColor(e).equals(color)) {
                str = e.getText();
                break;
            }
        }
        return str;
    }

    public String getHighlightedLevelJobColor(String color, int index) {
        String str = "";
        List<WebElement> expandedCallouts = driver.findElements(By.xpath(String.format(HIGH_LEVEL_EXPANDED_JOB_XPATH, index)));

        for (WebElement e : expandedCallouts) {
            if (getBackgroundColor(e).equals(color)) {
                str = e.getText();
                break;
            }
        }
        return str;
    }

    public String getHighlightedLevel1JobColor(String color) {
        waitInSec(5);
        String str = "";
        for (WebElement e : jobs) {
            if (getBackgroundColor(e).equals(color)) {
                str = e.getText();
                break;
            }
        }
        return str;
    }

    public GMCreateEstimatePage clickOnAddToQuote() {
        waitInSec(2);
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

    public GMCreateEstimatePage clickOnMenuManagerRemoveAndReplace() {
        waitInSec(2);
        click(removeAndReplaceEstimate);
        try {
            waitInSec(2);
            if (localMenuSelectionPane.isDisplayed()) {
                addDealerTOQuote.click();
            }
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
        return this;
    }

    public Float getCabinFilterPrice() {
        float costPrice = 0.0f;
        String price = getText(cabinFilterPrice).trim();
        StringBuffer sb = new StringBuffer(price);
        String amount = String.valueOf(sb.delete(0, 1));
        costPrice = costPrice + Float.parseFloat(amount);
        return costPrice;
    }

    public GMCreateEstimatePage clickOnLostSaleBtn() {
        waitInSec(2);
        lostSaleBtn.click();
        return this;
    }

    public GMCreateEstimatePage clickOnDeferredBtn() {
        waitInSec(2);
        deferredBtn.click();
        return this;
    }

    public List<String> getLostSaleReason() {
        return getListOfContents(lostSaleReasons);
    }

    public GMCreateEstimatePage enterFormattedPrice(String text) {
        waitInSec(2);
        formattedPrice.clear();
        sendKeys(formattedPrice, text);
        return this;
    }

    public GMCreateEstimatePage clickOnLostSaleAddBtn() {
        waitInSec(2);
        addBtn.click();
        return this;
    }

    public GMCreateEstimatePage clickOnCalendarDateWhichIsAvailable() {
        waitInSec(2);
        calendarEdit.click();
        click(calendarAvailable);
        return this;
    }

    public GMCreateEstimatePage clickOnNewQuote() {
        waitInSec(2);
        jsClickElement(newQuote);
        return this;
    }

    public String getDialogConfirmContent() {
        return getText(dialogConfirmContent);
    }

    public GMCreateEstimatePage clickOnOKBtn() {
        waitInSec(2);
        jsClickElement(okBtn);
        return this;
    }

    public boolean isCheckSheetIconDisplayed() {
        waitInSec(2);
        return elementIsDisplay(checkSheetIcon);
    }

    public boolean isJLRRowExpanded() {
        return elementIsDisplay(expandedJlrRow);
    }

    public GMCreateEstimatePage clickOnMY15DieselParticleFilter() {
        click(MY15DieselParticleFilter);
        return this;
    }

    public String getJobDuplicateWarnMsg() {
        return getText(dialogAlertContent);
    }

    public List<String> getAddedQuoteDetails(int index) {
        waitInSec(5);
        List<String> quoteDetails = getListOfContentsByString(String.format(ADDED_QUOTE_DETAILS, index));
        System.out.println("quoteDetails:" + quoteDetails);
        quoteDetails.remove(3);
        quoteDetails.remove(4);
        return quoteDetails;
    }

    public String getAddedQuoteTotalPrice() {
        waitInSec(2);
        return addedQuotetotalPrice.getText();
    }

    public GMCreateEstimatePage clickOnRemoveAndReplaceHeatCore() {
        waitInSec(2);
        removeAndReplaceHeatCore.click();
        return this;
    }

    public boolean isQuoteStatusSaved() {
        return savedStatus.isDisplayed();
    }

    public GMCreateEstimatePage clickOnExportAll()
    {
        fluentWait(exportAllBtn);
        exportAllBtn.click();
        waitInSec(3);
        return this;
    }

    public GMCreateEstimatePage clickOnSave()
    {
        fluentWait(saveButton);
        saveButton.click();
        waitInSec(3);
        return this;
    }

    public GMCreateEstimatePage clickOnDetailed()
    {
        fluentWait(detailedButton);
        detailedButton.click();
        waitInSec(3);
        return this;
    }

    public Boolean CheckFileDownloaded() {
        long currentTime = System.currentTimeMillis();
        Long filenameStart = Long.parseLong(("" + currentTime).substring(0, 7));
        Boolean fileExist = validateFilenameWithPartialText(filenameStart.toString(), ".pdf");
        return fileExist;
    }

    public GMCreateEstimatePage clickOnPrint()
    {
        fluentWait(printButton);
        printButton.click();
        waitInSec(3);
        return this;
    }

    public GMCreateEstimatePage clickOnSummary()
    {
        fluentWait(summaryButton);
        summaryButton.click();
        waitInSec(3);
        return this;
    }

    public GMCreateEstimatePage clickOnBack()
    {
        fluentWait(backButton);
        backButton.click();
        waitInSec(3);
        return this;
    }

    public GMCreateEstimatePage clickOnEmail()
    {
        fluentWait(emailButton);
        emailButton.click();
        waitInSec(3);
        return this;
    }

    public Boolean verifyPrintOptionPresent()
    {
        fluentWait(printOption);
        Boolean printoption = printOption.isDisplayed();
        waitInSec(3);
        return printoption;
    }

    public Boolean verifyTotalPriceElementPresent()
    {
        fluentWait(totalPriceElement);
        Boolean printoption = totalPriceElement.isDisplayed();
        waitInSec(3);
        return printoption;
    }

    public GMCreateEstimatePage clickJobDetails()
    {
        fluentWait(jobDetails);
        jobDetails.click();
        return this;
    }

    public GMCreateEstimatePage getJobDetails()
    {
        fluentWait(jobDetails);
        jobDetails.click();
        return this;
    }

    public Boolean verifyEmailSendButton()
    {
        Boolean popupSendBtn = emailSendBtn.isDisplayed();
        return popupSendBtn;
    }

    public Boolean verifyEmailCancelButton()
    {
        Boolean popupCancelBtn = emailCancelButton.isDisplayed();
        return popupCancelBtn;
    }

    public Boolean getTextQuoteType(String quoteType)
    {
        String getQuoteType = null;
        if(quoteType.equalsIgnoreCase("Detailed")){
            getQuoteType = detailedButtonDialog.getAttribute("innerHTML");
            return getQuoteType.contains(quoteType);}
        else if(quoteType.equalsIgnoreCase("Detailed #2")){
            getQuoteType = detailed2Button.getAttribute("innerHTML");
            return getQuoteType.contains(quoteType); }
        else if(quoteType.equalsIgnoreCase("Summary")){
            getQuoteType = summaryButtonDialog.getAttribute("innerHTML");
            return getQuoteType.contains(quoteType); }
        else {
        return false; }
    }

    public Boolean verifyWarningDialog()
    {
        Boolean WarningMessage = mailAlertContent.isDisplayed();
        return WarningMessage;
    }

    public GMCreateEstimatePage clickOKButtoninDialog()
    {
        fluentWait(mailArertOKBtn);
        mailArertOKBtn.click();
        return this;
    }

    public GMCreateEstimatePage clickSendButtonWarning()
    {
        fluentWait(emailSendBtn);
        emailSendBtn.click();
        waitInSec(4);
        return this;
    }

    public GMCreateEstimatePage clickOnJobDetailsIcon()
    {
        fluentWait(jobDetailsIcon);
        jobDetailsIcon.click();
        return this;
    }

    public Boolean getLabourPrice(String price)
    {
        fluentWait(labourPrice);
        String labourprice = getText(labourPrice);
        if(labourprice.contains(price))
        {
            return true;
        }
        else return false;
    }

    public GMCreateEstimatePage selectBrakeFluid(String searchText)
    {
        fluentWait(jobSearch);
        jobSearch.sendKeys(searchText);
        waitInSec(4);
        brakeFluidChange.click();
        waitInSec(5);
        return this;
    }

    public GMCreateEstimatePage selectFluidOptional()
    {
        fluentWait(fluidOptionalPrice);
        fluidoptionalprice = fluidOptionalPrice.getText();
        fluentWait(fluidoptional);
        fluidoptional.click();
        continueButton.click();
        waitInSec(3);
        return this;
    }

    public Boolean verifyFluidOptionalPrice()
    {
        if(fluidoptionalprice.equals(fluidOptionalPrice.getText()))
        {  return true;  }
        else return false;
    }

    public Boolean verifyFluidOptionalpriceDisplayed()
    {
        try {
            if (fluidOptionalPrice.isDisplayed()) {
                return true;
            } else return false;
        }
        catch (Exception e)
        {
            return false;
        }
    }

    public Boolean verifyHistoricQuotePage(){
        fluentWait(historicPageQuoteFromDate);
        if(historicPageQuoteFromDate.isDisplayed()&&historicPageQuoteToDate.isDisplayed()){
            return true;
        } else return false;
    }

    public GMCreateEstimatePage clickHistoricQuoteTab(){
        fluentWait(historicQuoteTab);
        click(historicQuoteTab);
        return this;
    }

    public GMCreateEstimatePage selectChildFromJobTree(String searchText, String childElement)
    {
        fluentWait(jobSearch);
        jobSearch.sendKeys(searchText);
        waitInSec(4);
        WebElement treeElement = driver.findElement(By.xpath(String.format(CHILD_TREE_ELEMENT_JOBTREE, childElement)));
        jsClickElement(treeElement);
        waitInSec(5);
        return this;
    }

    public Boolean verifyJob(String childJobName)
    {
        Boolean flag = false;
        for(int i=0; i<jobDescription.size(); i++){
            if(jobDescription.get(i).getText().contains(childJobName)) {
                flag = true;
            }
        }
        return flag;
    }

    public GMCreateEstimatePage clickAddtoEstimate()
    {
        fluentWait(estimatePopup);
        click(estimatePopup);
        return this;
    }

    public GMCreateEstimatePage clickCreateEstimate()
    {
        fluentWait(createEstimateBtn);
        click(createEstimateBtn);
        return this;
    }

    public String getPriceExTax()
    {
        fluentWait(priceExTax);
        priceextax = priceExTax.getText();
        return priceextax;
    }

    public Boolean verifyPariceExTax() {
        Boolean priceMatch = false;
        double labourtime = Double.parseDouble(labourTime.getText());
        double labourprice = Double.parseDouble(jobDetailsPrice.getText().substring(2));
        if ((priceextax).contains(String.valueOf(Math.round((labourtime+labourprice)*100)/100))) {
            priceMatch = true;
        }
        return priceMatch;
    }

    public Boolean verifyDescription(String text)
    {
        Boolean description = false;
        fluentWait(dealerDescription);
        if(dealerDescription.getText().contains(text)){
        description= true;
        }
        return description;
    }

    public Boolean verifyPriceInclTax(String tax, String job) {
        Boolean priceMatch = false;
        WebElement labour = driver.findElement(By.xpath(String.format(LABOUR_PRICE, job)));
        double labourprice = Double.parseDouble(labour.getText().substring(2));
        if ((priceextax).contains(String.valueOf(Math.round((Double.parseDouble(tax)+labourprice)*100)/100))) {
            priceMatch = true;
        }
        return priceMatch;
    }

    public String getPrice()
    {
        fluentWait(heatedLabourPrice);
        price = heatedLabourPrice.getText();
        return price;
    }

    public String getPartPriceHeatedOxygen()
    {
        fluentWait(partPriceOxygenSensor);
        partprice = partPriceOxygenSensor.getText().substring(2);
        return partprice;
    }

    public Boolean verifyPriceTax(String tax) {
        Boolean priceMatch = false;
        if ((priceextax).contains(tax)) {
            priceMatch = true;
        }
        return priceMatch;
    }
}