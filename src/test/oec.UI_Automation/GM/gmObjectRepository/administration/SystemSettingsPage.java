package GM.gmObjectRepository.administration;

import base.FunctionalLibrary;
import model.LaborPriceTypes;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SystemSettingsPage extends FunctionalLibrary {

    public static final String labourCostwebelement = "(//a[contains(text(), '%s')]//parent::td//following-sibling::td//input)[1]";
    public static final String labourRetailwebelement = "(//a[contains(text(), '%s')]//parent::td//following-sibling::td//input)[2]";

    @FindBy(xpath = "//a[contains(text(),'System Settings')]")
    private WebElement systemSettingsBtn;
    @FindBy(xpath = "//select[@name='laborPricingType']")
    private WebElement laborPricingTypes;
    @FindBy(xpath = "//select[@name='laborPricingType']/option[@selected='selected']")
    private WebElement laborPricingTypeSelected;
    @FindBy(xpath = "//input[@name='quoteExpiry']")
    private WebElement estimateExpiryDate;
    @FindBy(xpath = "//input[@name='validUntil']")
    private WebElement estimateValidityDate;
    @FindBy(xpath = "//input[@name='quotePrefix']")
    private WebElement estimatePrefix;
    @FindBy(xpath = "//input[@name='quoteSuffix']")
    private WebElement estimateSuffix;
    @FindBy(xpath = "//input[@name='alwaysPromptJobLocalPart']")
    private WebElement promptJobLocalPartCheckBox;
    @FindBy(xpath = "//input[@id='chkDefaultLabourRates']")
    private WebElement chkDefaultLabourRates;
    @FindBy(xpath = "//input[contains(@name, 'labourCost')]")
    private WebElement labourCost;
    @FindBy(xpath = "//input[contains(@name,'labourRetail')]")
    private WebElement retailCost;
    @FindBy(xpath = "//a[@id='brandLabourRates']")
    private WebElement setLabourRate;
    @FindBy(xpath = labourCostwebelement)
    private WebElement setLabourCost;
    @FindBy(xpath = labourRetailwebelement)
    private WebElement setLabourRetail;
    @FindBy(xpath = "//input[@value='OK']")
    private WebElement okButton;
    @FindBy(xpath = "//a[contains(text(), 'Vehicle')]")
    private WebElement vehicleTab;
    @FindBy(xpath = "//input[contains(@value, 'Clear')]")
    private WebElement clearButton;
    @FindBy(xpath = "//input[@name='quoteExpiry']")
    private WebElement quoteExpiry;
    @FindBy(xpath = "//input[@name='validUntil']")
    private WebElement expireUntil;
    @FindBy(xpath = "//input[@name='nextQuoteNumber']")
    private WebElement nextQuoteNumber;
    @FindBy(xpath = "//input[@name='quotePrefix']")
    private WebElement quotePrefix;
    @FindBy(xpath = "//input[@name='quoteSuffix']")
    private WebElement quoteSuffix;
    @FindBy(xpath = "//input[@name='defaultCustomerName']")
    private WebElement defaultCustomerName;
    @FindBy(xpath = "//td[@class='status-label' and (contains(text(), 'Customer'))]//following-sibling::td[1]")
    private WebElement customerName;
    @FindBy(xpath = "//input[@name='printQuoteTopMargin']")
    private WebElement printQuoteMargin;
    @FindBy(xpath = "//a[contains(text(), 'Org. Detail')]")
    private WebElement orgDetail;
    @FindBy(xpath = "//textarea[@name='address']")
    private WebElement addressvalue;
    @FindBy(xpath = "//input[@name='postalCode']")
    private WebElement postcode;
    @FindBy(xpath = "//input[@name='showAddress']")
    private WebElement chkShowAddress;
    @FindBy(xpath = "//input[@name='alwaysPromptJobLocalPart']")
    private WebElement promptGenericParts;

    public SystemSettingsPage(WebDriver driver) {
        super(driver);
    }

    public SystemSettingsPage openSystemSettingsTab() {
        waitInSec(5);
        jsClickElement(systemSettingsBtn);
        return this;
    }

    public SystemSettingsPage selectLaborPricingTypes(LaborPriceTypes priceType) {
        waitInSec(2);
        Select laborPriceType = new Select(laborPricingTypes);
        laborPriceType.selectByVisibleText(priceType.getType());
        return this;
    }

    public String getLaborPricingTypeSelectedText() {
        return getText(laborPricingTypeSelected);
    }

    public SystemSettingsPage enterEstimateExpiration(String days) {
        sendKeys(estimateExpiryDate, days);
        return this;
    }

    public String getEstimateValidDate() {
        return getAttribute(estimateValidityDate);
    }

    public String getSystemSettingsSetDate() {
        return getFutureDateBasedOnDate(20);
    }

    public SystemSettingsPage enterEstimatePrefix(String prefix) {
        sendKeys(estimatePrefix, prefix);
        return this;
    }

    public SystemSettingsPage enterEstimateSuffix(String suffix) {
        sendKeys(estimateSuffix, suffix);
        return this;
    }

    public SystemSettingsPage selectAlwaysPromptJobLocalPartCheckBox() {
        click(promptJobLocalPartCheckBox);
        return this;
    }

    public SystemSettingsPage checkDefaultLabourRates() {
        fluentWait(chkDefaultLabourRates);
        if (setLabourRate.isDisplayed()) {
            jsClickElement(chkDefaultLabourRates);
        }
        return this;
    }

    public SystemSettingsPage enterLabourCostPrice(String price) {
        sendKeys(labourCost, price);
        return this;
    }

    public SystemSettingsPage enterRetailCostPrice(String price) {
        sendKeys(retailCost, price);
        return this;
    }

    public SystemSettingsPage uncheckDefaultLabourRates() {
        fluentWait(chkDefaultLabourRates);
        if (!setLabourRate.isDisplayed()) {
            jsClickElement(chkDefaultLabourRates);
        }
        return this;
    }

    public SystemSettingsPage clickSetLabourRates() {
        fluentWait(setLabourRate);
        setLabourRate.click();
        return this;
    }

    public SystemSettingsPage setLabourCostRetail(String Brand, String labourCost, String labourRetail) {
        WebElement labourCostElement = driver.findElement(By.xpath(String.format(labourCostwebelement, Brand)));
        labourCostElement.clear();
        labourCostElement.sendKeys(labourCost);
        WebElement labourRetailElement = driver.findElement(By.xpath(String.format(labourRetailwebelement, Brand)));
        labourRetailElement.clear();
        labourRetailElement.sendKeys(labourRetail);
        return this;
    }

    public SystemSettingsPage clickOK() {
        fluentWait(okButton);
        click(okButton);
        return this;
    }

    public SystemSettingsPage clickVehicle() {
        fluentWait(vehicleTab);
        vehicleTab.click();
        clearButton.click();
        waitInSec(1);
        return this;
    }

    public SystemSettingsPage enterQuoteExpiry(String days) {
        fluentWait(quoteExpiry);
        quoteExpiry.clear();
        quoteExpiry.sendKeys(days);
        return this;
    }

    public boolean validateQuoteExpiry(String days) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDateTime now = LocalDateTime.now().plusDays(Integer.parseInt(days));
        String expiryDate = dtf.format(now);
        String displayedExpiryDate = expireUntil.getAttribute("value");
        if (expiryDate.equals(displayedExpiryDate)) {
            return true;
        } else return false;
    }

    public String getNextQuoteNumber() {
        String quoteNumber = nextQuoteNumber.getAttribute("value");
        nextQuoteNumber.clear();
        nextQuotenumber = String.valueOf(Integer.valueOf(quoteNumber) + 1);
        nextQuoteNumber.sendKeys(nextQuotenumber);
        return nextQuotenumber;
    }

    public SystemSettingsPage enterPrefixSuffix(String prefix, String suffix) {
        quotePrefix.clear();
        quotePrefix.sendKeys(prefix);
        quoteprefix = prefix;
        quoteSuffix.clear();
        quoteSuffix.sendKeys(suffix);
        quotesuffix = suffix;
        return this;
    }

    public SystemSettingsPage enterDefaultCustomerName(String customerName) {
        defaultCustomerName.clear();
        defaultCustomerName.sendKeys(customerName);
        defaultcusName = customerName;
        return this;
    }

    public Boolean verifyCustomerName() {
        String cusName = customerName.getText();
        if (cusName.contains(defaultcusName)) {
            return true;
        } else return false;
    }

    public SystemSettingsPage enterPrintQuoteTopMargin(String Margin) {
        printQuoteMargin.clear();
        printQuoteMargin.sendKeys(Margin);
        return this;
    }

    public Boolean verifyQuoteNameWithPrefixSuffix(String fileName, String prefix, String suffix) throws IOException {
        functionalLibrary = new FunctionalLibrary(driver);
        functionalLibrary.readPDFFile(fileName);
        String[] pdfContentsplit = pdfcontent.split("\r\n");
        for (String content : pdfContentsplit) {
            if (content.contains("Retailer Quote")) {
                String[] quoteName = content.split(":");
                if (quoteName[1].contains(prefix) && quoteName[1].contains(suffix)) {
                    return true;
                } else return false;
            }
        }
        return false;
    }

    public Boolean verifyAddressinPDF(String fileName, String address, String postalcode) throws IOException {
        functionalLibrary = new FunctionalLibrary(driver);
        functionalLibrary.readPDFFile(fileName);
        String[] pdfContentsplit = pdfcontent.split("\r\n");
        for (int i=0; i<pdfContentsplit.length;i++) {
            if (pdfContentsplit[i].contains("Address")&& pdfContentsplit[i+1].contains("Post Code")) {
                String[] Addresssplit = pdfContentsplit[i].split(":");
                String[] postcodesplit = pdfContentsplit[i+1].split(":");
                if (Addresssplit[1].contains(address)&&postcodesplit[1].contains(postalcode)) {
                    return true;

                } else return false;
            }
        }
        return false;
    }

    public SystemSettingsPage clickOrgDetail() {
        fluentWait(orgDetail);
        click(orgDetail);
        return this;
    }

    public SystemSettingsPage getAddressPostalCode() {
        address = addressvalue.getText();
        postalcode = postcode.getAttribute("value");
        return this;
    }

    public SystemSettingsPage checkShowAddress() {
        fluentWait(chkShowAddress);
        if (chkShowAddress.getAttribute("checked")==null) {
            jsClickElement(chkShowAddress);
        }
        return this;
    }

    public SystemSettingsPage clickGenericParts()
    {
        fluentWait(promptGenericParts);
        if(promptGenericParts.getAttribute("checked")==null)
        promptGenericParts.click();
        return this;
    }

    public SystemSettingsPage uncheckGenericParts()
    {
        fluentWait(promptGenericParts);
        if(promptGenericParts.getAttribute("checked")!=null)
            promptGenericParts.click();
        return this;
    }

    public Boolean checkSystemSettingsTabPresent()
    {
        fluentWait(systemSettingsBtn);
        if(systemSettingsBtn.isDisplayed()){
            return true;
        } else return false;
    }

}
