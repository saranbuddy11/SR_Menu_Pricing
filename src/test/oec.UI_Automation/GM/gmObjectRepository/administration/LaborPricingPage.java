package GM.gmObjectRepository.administration;

import base.FunctionalLibrary;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class LaborPricingPage extends FunctionalLibrary {

    private static final String LABOR_PRICING_TEXT_COLOR_XPATH = "//font[contains(text(),'%s')]";
    private static final String RETAIL_TAX_PRICE = "//input[@name='lineIndexed[%d].retailFormatted[%d]']";
    private static final String TEXT_LINK = "(//span[@class='text-link'])[%d]";
    private static final String VEHICLE_MODELS = "//tr[contains(@vehicletype,'%s')]//span";
    private static final String VEHICLE_MAKE_AND_MODEL_RETAIL_PRICE = "((//span[contains(text(),'%s')])[1]/parent::td//following-sibling::td//input[@type='text'])[%d]";
    private static final String VIEW_TYPE_RADIO_BTN = "(//input[@type='radio'])[%d]";
    private static final String HOURS = "(//td[@class='formLabel columnSeparator rowSeparator'])[%d]";
    private static final String ROWS = "(//td[@style='text-align: center;']//input[@name='rowIds'])[%d]";
    private static final String ROWS_AND_COLUMN_COUNT = "//input[@value='%s']/parent::td/following-sibling::td";
    private static final String CONTENT_SEARCH_JOB_HIERARCHY = "(//div[@class='l1'])[%d]";
    private static final String POPULATE_VALUES = "(//td[@class='columnSeparator rowSeparator']//input[@type='text'])[%d]";
    private static final String CHECK_BOX = "(//input[@type='checkbox'])[%d]";

    @FindBy(xpath = "//a[contains(text(),'Labor Pricing')]")
    private WebElement laborPricingBtn;
    @FindBy(xpath = "//input[@name='labourRetail']")
    private WebElement labourRetailHour;
    @FindBy(css = "div.job-difficulty-error-centered > ol > li")
    private WebElement warnMsg;
    @FindBy(css = "div.job-difficulty-error-centered > p")
    private WebElement errorCloseBtn;
    @FindBy(xpath = "//input[@name='populateEmptyCellsValue']")
    private WebElement populateEmptyCellsValue;
    @FindBy(xpath = "//td[@class='columnSeparator rowSeparator']//input[@type='text']")
    private List<WebElement> populateValues;
    @FindBy(xpath = "(//td[@class='formLabel columnSeparator rowSeparator'])")
    private List<WebElement> hours;
    @FindBy(xpath = "(//td[@style='text-align: center;'])")
    private List<WebElement> rows;
    @FindBy(xpath = "//input[@name='lineIndexed[16].laborRateFormatted[0]']")
    private WebElement lastIndexValue;
    @FindBy(xpath = "//div[@class='l1']")
    private List<WebElement> contentSearchJobHierarchy;
    @FindBy(xpath = "//input[@name='lineIndexed[0].laborRateFormatted[3]']")
    private WebElement labourRateFormatted3;
    @FindBy(xpath = "//input[@name='lineIndexed[0].laborRateFormatted[9]']")
    private WebElement labourRateFormatted9;
    @FindBy(xpath = "(//td[@class='formLabel columnSeparator rowSeparator'])[4]")
    private WebElement labourRateHourFormatted3;
    @FindBy(xpath = "//input[@type='checkbox']")
    private List<WebElement> matrixCheckboxes;
    @FindBy(xpath = "//input[@onclick='checkBeforeDelete();']")
    private WebElement matrixDeleteBtn;
    @FindBy(xpath = "//a[contains(text(), 'Labor Matrix')]")
    private WebElement labourMatrix;

    public LaborPricingPage(WebDriver driver) {
        super(driver);
    }

    public LaborPricingPage openLaborPricingTab() {
        click(laborPricingBtn);
        return this;
    }

    public LaborPricingPage enterLaborRetailHour(String laborRetailHr) {
        sendKeys(labourRetailHour, laborRetailHr);
        return this;
    }

    public String getLaborRetailValue() {
        return getAttribute(labourRetailHour);
    }

    public String getSingleLaborRateColor(String text) {
        return getTextColor(driver.findElement(By.xpath(String.format(LABOR_PRICING_TEXT_COLOR_XPATH, text))));
    }

    public String getJobDifficultyColor(String text) {
        return getTextColor(driver.findElement(By.xpath(String.format(LABOR_PRICING_TEXT_COLOR_XPATH, text))));
    }

    public LaborPricingPage clearAllRates() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                WebElement textBox = driver.findElement(By.xpath(String.format(RETAIL_TAX_PRICE, i, j)));
                textBox.clear();
            }
        }
        return this;
    }

    public LaborPricingPage enterDefaultOptionVehicleRetailPrice(List<String> rates) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                WebElement textBox = driver.findElement(By.xpath(String.format(RETAIL_TAX_PRICE, i, j)));
                textBox.clear();
                sendKeys(textBox, rates.get(j));
            }
        }
        return this;
    }

    public List<String> getDefaultOptionVehicleRetailPrice() {
        List<String> rates = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                WebElement textBox = driver.findElement(By.xpath(String.format(RETAIL_TAX_PRICE, i, j)));
                String price = textBox.getAttribute("value");
                rates.add(price);
            }
        }
        return rates;
    }

    public String getWarningMsg() {
        waitInSec(2);
        return warnMsg.getText();
    }

    public LaborPricingPage clickOnCloseBtn() {
        errorCloseBtn.click();
        return this;
    }

    public LaborPricingPage clickOnVehicleTextLink(int index) {
        clickBasedOnIndex(TEXT_LINK, index);
        return this;
    }

    public List<String> getVehicleModels(String index) {
        List<WebElement> vehicleModel = driver.findElements(By.xpath(String.format(VEHICLE_MODELS, index)));
        return getListOfContents(vehicleModel);
    }

    public LaborPricingPage enterModelVehicleRetailPrice(String makeAndModel, List<Integer> rates) {
        for (int i = 1; i <= 3; i++) {
            WebElement textBox = driver.findElement(By.xpath(String.format(VEHICLE_MAKE_AND_MODEL_RETAIL_PRICE, makeAndModel, i)));
            textBox.clear();
            sendKeys(textBox, String.valueOf(rates.get(i - 1)));
        }
        return this;
    }

    public LaborPricingPage clearModelVehicleRetailPrice(String makeAndModel) {
        for (int i = 1; i <= 3; i++) {
            WebElement textBox = driver.findElement(By.xpath(String.format(VEHICLE_MAKE_AND_MODEL_RETAIL_PRICE, makeAndModel, i)));
            textBox.clear();
        }
        return this;
    }

    public LaborPricingPage enterPopulateEmptyCellsValue(String value) {
        clearAllList(populateValues);
        sendKeys(populateEmptyCellsValue, value);
        return this;
    }

    public List<String> getPopulateEmptyCellsValue() {
        return getListOfContentAttribute(populateValues);
    }

    public LaborPricingPage selectViewTypeRadioBtn(int index) {
        WebElement element = driver.findElement(By.xpath(String.format(VIEW_TYPE_RADIO_BTN, index)));
        if (!element.isSelected()) {
            element.click();
        }
        return this;
    }

    public List<String> getPopulateEmptyCellsValue(int value) {
        List<String> actualTotalPrice = new ArrayList<>();
        int rowCount = rows.size();
        float price = 0.00f;
        String lastValue = lastIndexValue.getAttribute("value");
        for (int i = 1; i <= rowCount; i++) {
            WebElement element = driver.findElement(By.xpath(String.format(ROWS, i)));
            float rowNo = Float.parseFloat(element.getAttribute("value"));
            List<WebElement> element3 = driver.findElements(By.xpath(String.format(ROWS_AND_COLUMN_COUNT, i)));
            for (int j = 1; j <= element3.size(); j++) {
                WebElement element1 = driver.findElement(By.xpath(String.format(HOURS, j)));
                float colNo = Float.parseFloat(element1.getText().trim());
                price = (value * rowNo) + (value * colNo);
                String priceWithDecimal = df.format(price);
                if (price == 0.00) {
                    continue;
                }
                actualTotalPrice.add(priceWithDecimal);
            }
        }
        actualTotalPrice.add(lastValue);
        return actualTotalPrice;
    }

    public int getJobHierarchySize() {
        return getSize(contentSearchJobHierarchy);
    }

    public int getPopulateValuesSize() {
        return getSize(populateValues);
    }

    public Boolean isJobHierarchyDisplayed(int index) {
        return isElementDisplayedBasedOnIndex(CONTENT_SEARCH_JOB_HIERARCHY, index);
    }

    public Boolean isLaborRateEditable(int index) {
        return isElementEnabledBasedOnIndex(POPULATE_VALUES, index);
    }

    public LaborPricingPage enterLaborRateFormated3Value(String laborRate) {
        sendKeys(labourRateFormatted3, laborRate);
        return this;
    }

    public LaborPricingPage enterLaborRateFormated9Value(String laborRate) {
        sendKeys(labourRateFormatted9, laborRate);
        return this;
    }

    public String getLaborRateFormated3Value() {
        return labourRateFormatted3.getAttribute("value");
    }

    public String getLaborRateHourFormated3Value() {
        return labourRateHourFormatted3.getText();
    }

    public Boolean isRowsTickBoxesDisabled(int index) {
        return isElementEnabledBasedOnIndex(CHECK_BOX, index);
    }

    public int getMatrixCheckBoxSize() {
        return matrixCheckboxes.size();
    }

    public LaborPricingPage clickOnMatrixCheckBox(int index) {
        WebElement element = driver.findElement(By.xpath(String.format(CHECK_BOX, index)));
        moveToElementClick(element);
        return this;
    }

    public LaborPricingPage clickOnMatrixDeleteBtn() {
        click(matrixDeleteBtn);
        return this;
    }

    public Boolean isMatrixEditable() {
        return labourRateFormatted3.isEnabled();
    }

    public LaborPricingPage clickLabourMatrix()
    {
        fluentWait(labourMatrix);
        click(labourMatrix);
        return this;
    }
}
