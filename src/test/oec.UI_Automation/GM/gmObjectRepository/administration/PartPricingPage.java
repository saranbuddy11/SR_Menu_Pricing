package GM.gmObjectRepository.administration;

import base.FunctionalLibrary;
import model.PartPricePricingTypes;
import model.SearchReasons;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class PartPricingPage extends FunctionalLibrary {

    private static final String PART = "(//div[@id='partCategoryList']//div)[%d]";
    private static final String ADMIN_LOST_SALES_RECORD_DETAILS_DATE = "(//input[contains(@id,'adminLostSalesRecordDetails')])[%d]";
    private static final String REASON_COLUMN_RESULT = "(//td[@class='col-name'])[%d]";

    @FindBy(xpath = "//a[contains(text(),'Part Pricing')]")
    private WebElement partPricingTab;
    @FindBy(xpath = "//a[contains(text(),'Except. by Category')]")
    private WebElement exceptByCategory;
    @FindBy(xpath = "//a[contains(text(),'Part Pricing Upload')]")
    private WebElement partPricingUpload;
    @FindBy(xpath = "//span[contains(text(),'Part Pricing Upload')]")
    private WebElement partPricingUploadSelected;
    @FindBy(xpath = "//a[contains(text(),'Except. by Part#')]")
    private WebElement exceptByPartNumber;
    @FindBy(xpath = "//div[@id='partCategoryList']//div")
    private WebElement partCategoriesList;
    @FindBy(xpath = "//input[@id='filterByCategory']")
    private WebElement filterByCategoryBar;
    @FindBy(xpath = "//div[@id='partCategoryList']//div")
    private List<WebElement> partCategories;
    @FindBy(xpath = "//select[@id='pricingOptions']")
    private WebElement pricingOptions;
    @FindBy(xpath = "//input[@id='FIXED_PRICE']")
    private WebElement fixedPrice;
    @FindBy(xpath = "//table[@id='pceTable']/tbody/tr/td[2]/span")
    private WebElement partCategoryDescription;
    @FindBy(xpath = "(//div[@class='catRow_10051_']//input)[1]")
    private WebElement part;
    @FindBy(xpath = "//input[@id='PERCENTAGE']")
    private WebElement costPrice;
    @FindBy(xpath = "//input[@name='listDTO[0].formattedPrice']")
    private WebElement sellingPriceInput;
    @FindBy(xpath = "//input[@name='listDTO[0].formattedCost']")
    private WebElement costPriceInput;
    @FindBy(xpath = "//input[@value='Delete All']")
    private WebElement deleteAllBtn;
    @FindBy(name = "stockFile")
    private WebElement ChooseFileUpload;
    @FindBy(xpath = "//div[@id='errors']/ol/li")
    private WebElement errorPopUp;
    @FindBy(xpath = "//a[@onclick='downloadExampleFile();']//b")
    private WebElement downloadLink;
    @FindBy(xpath = "//form[@id='upload-form']/table[3]/tbody/tr/td/b")
    private WebElement successfulMsg;
    @FindBy(xpath = "//input[@value='StockUploadData.csv']")
    private WebElement uploadedFile;
    @FindBy(xpath = "//*[contains(text(),'StockUploadData.csv')]")
    private WebElement jlrStockUploadedFile;
    @FindBy(xpath = "//*[contains(text(),'Stock Upload')]")
    private WebElement stockUpload;
    @FindBy(xpath = "//form[@name='uploadStockForm']//following-sibling::span//h5")
    private WebElement jlrSuccessfulMsg;
    @FindBy(xpath = "//select[@name='searchReason']//option")
    private List<WebElement> searchReason;
    @FindBy(xpath = "//select[@name='searchReason']")
    private WebElement selectSearchReasons;
    @FindBy(xpath = "//input[@name='beforeDate']")
    private WebElement beforeDate;
    @FindBy(xpath = "//td[@class='col-name']")
    private List<WebElement> reasonColumn;
    @FindBy(xpath = "//td[@class='col-name']")
    private List<WebElement> reasonsColumn;
    @FindBy(xpath = "//input[@value='Export']")
    private WebElement exportBtn;
    @FindBy(xpath = "//a[contains(text(), 'PartAndLabour')]")
    private WebElement partAndLabour;

    public PartPricingPage(WebDriver driver) {
        super(driver);
    }

    public PartPricingPage openPartPricingTab() {
        click(partPricingTab);
        return this;
    }

    public PartPricingPage openExceptByCategoryTab() {
        click(exceptByCategory);
        return this;
    }

    public PartPricingPage openExceptByPartNumberTab() {
        click(exceptByPartNumber);
        return this;
    }

    public PartPricingPage openPartPricingUploadTab() {
        click(partPricingUpload);
        return this;
    }

    public boolean isPartCategoriesListDisplayed() {
        waitInSec(5);
        return elementIsDisplay(partCategoriesList);
    }

    public PartPricingPage searchPartCategoryTextBox(String part) {
        sendKeys(filterByCategoryBar, part);
        return this;
    }

    public int getPartCategoriesSearchSize() {
        waitInSec(2);
        return getSize(partCategories);
    }

    public String getPartCategorySearchResult(int index) {
        scrollToTheBottom();
        return getTextBasedOnIndex(PART, index);
    }

    public PartPricingPage selectHornPart() {
        doubleClick(part);
        return this;
    }

    public PartPricingPage selectPricingOptions(PartPricePricingTypes priceType) {
        Select options = new Select(pricingOptions);
        options.selectByVisibleText(priceType.getPriceType());
        return this;
    }

    public PartPricingPage setFixedPrice(Double value) {
        jsSendKeys(fixedPrice, value);
        return this;
    }

    public PartPricingPage setCostPrice(Double value) {
        jsSendKeys(costPrice, value);
        return this;
    }

    public String getPartCategoriesDescription() {
        return getText(partCategoryDescription);
    }

    public boolean isCostAndSellingPriceAreEditable() {
        return (costPriceInput.isEnabled() && sellingPriceInput.isEnabled());
    }

    public PartPricingPage enterSellingPrice(String price) {
        sendKeys(sellingPriceInput, price);
        return this;
    }

    public String getSellingPrice() {
        return getAttribute(sellingPriceInput);
    }

    public PartPricingPage clickOnDeleteAllBtn() {
        waitInSec(2);
        click(deleteAllBtn);
        return this;
    }

    public PartPricingPage clickOnChooseFile(String path) {
        chooseFile(ChooseFileUpload, path);
        return this;
    }

    public PartPricingPage clickOnChooseFileBtn() {
        moveToElementClick(ChooseFileUpload);
        return this;
    }

    public String getErrorPopUp() {
        return getText(errorPopUp);
    }

    public PartPricingPage clickOnDownloadBtn() {
        click(downloadLink);
        return this;
    }

    public Boolean isUploadedSuccessfullyMsgDisplayed() {
        return elementIsDisplay(successfulMsg);
    }

    public Boolean isStockFileUploadedSuccessfullyMsgDisplayed() {
        return elementIsDisplay(jlrSuccessfulMsg);
    }

    public PartPricingPage clickOnCancelBtn() {
        waitInSec(2);
        Robot robot = null;
        try {
            robot = new Robot();
            waitInSec(1);
            robot.keyPress(KeyEvent.VK_TAB);
            waitInSec(1);
            robot.keyRelease(KeyEvent.VK_TAB);
            waitInSec(1);
            robot.keyPress(KeyEvent.VK_TAB);
            waitInSec(1);
            robot.keyRelease(KeyEvent.VK_TAB);
            waitInSec(1);
            robot.keyPress(KeyEvent.VK_TAB);
            waitInSec(1);
            robot.keyRelease(KeyEvent.VK_TAB);
            waitInSec(1);
            robot.keyPress(KeyEvent.VK_SPACE);
            waitInSec(1);
            robot.keyRelease(KeyEvent.VK_SPACE);
            waitInSec(1);
        } catch (AWTException e) {
            e.printStackTrace();
        }
        return this;
    }

    public Boolean isPartPricingTabDisplayed() {
        return elementIsDisplay(partPricingUploadSelected);
    }

    public Boolean isUploadedFileNameDisplayed() {
        return elementIsDisplay(uploadedFile);
    }

    public PartPricingPage openStockUploadTab() {
        click(stockUpload);
        return this;
    }

    public Boolean isStockUploadTabDisplayed() {
        return elementIsDisplay(stockUpload);
    }

    public Boolean isStockUploadedFileNameDisplayed() {
        return elementIsDisplay(jlrStockUploadedFile);
    }

    public String getUpdatedDate(int index) {
        waitInSec(2);
        WebElement date = driver.findElement(By.xpath(String.format(ADMIN_LOST_SALES_RECORD_DETAILS_DATE, index)));
        return date.getAttribute("value");
    }

    public List<String> getSearchReasons() {
        fluentWait(beforeDate);
        int reasonSize = searchReason.size();
        List list = new ArrayList<String>();
        for (int i = 0; i < reasonSize; i++) {
            list.add(searchReason.get(i).getText());
        }
        return list;
    }

    public PartPricingPage selectSearchReason(SearchReasons searchReason) {
        Select reason = new Select(selectSearchReasons);
        reason.selectByVisibleText(searchReason.getReason());
        return this;
    }

    public String getSelectedSearchReason() {
        Select reason = new Select(selectSearchReasons);
        String selectedReason = reason.getAllSelectedOptions().get(0).getText();
        return selectedReason;
    }

    public int getReasonResultSize() {
        waitInSec(2);
        return getSize(reasonsColumn);
    }

    public String getLostSalesSearchResult(int index) {
        waitInSec(2);
        scrollToTheBottom();
        return getTextBasedOnIndex(REASON_COLUMN_RESULT, index);
    }

    public PartPricingPage clickOnExportBtn() {
        fluentWait(exportBtn);
        exportBtn.click();
        return this;
    }

    public PartPricingPage clickExPart()
    {
        fluentWait(partAndLabour);
        partAndLabour.click();
        return this;
    }
}