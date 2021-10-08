package GM.gmObjectRepository;

import base.FunctionalLibrary;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Arrays;
import java.util.List;

public class PartLaborDrillDownPage extends FunctionalLibrary {

    private static final String LABOR_RADIO_BTN = "(//input[@type='radio'])[%d]";
    private static final String QUANTITY = "(//table[1]//tbody//tr//td[@class='value'])[%d]";
    private static final String LABOR_TIME = "//td[contains(text(),'%s')]/following-sibling::td[%d]";
    private static final String ADD_LABOR_ICON = "(//img[contains(@src,'/images/icon/add.gif')])[%d]";
    private static final String ENQUIRY_CHECKBOX = "(//input[@type='checkbox'])[%d]";

    @FindBy(xpath = "//div[@class='content']")
    private WebElement partsAndLaborDetail;
    @FindBy(xpath = "//table[1]//tbody//tr//td[@class='value'][2]")
    private List<WebElement> partDescription;
    @FindBy(xpath = "//table[2]/tbody/tr/td[@class='value'][3]")
    private List<WebElement> laborDescription;
    @FindBy(xpath = "//table[1]//tbody//tr//td[@class='value'][4]")
    private List<WebElement> partPrice;
    @FindBy(xpath = "//table[2]/tbody/tr/td[@class='value'][4]")
    private List<WebElement> laborPrice;
    @FindBy(xpath = "//input[contains(@onclick,'/PartLabourDrillDown.do?cmd=addLabour_BySearchLabour')]")
    private WebElement addLabor;
    @FindBy(xpath = "//input[@name='criteria']")
    private WebElement searchCriteria;
    @FindBy(xpath = "(//input[@type='text'])[2]")
    private WebElement laborTime;
    @FindBy(xpath = "//img[contains(@src,'/images/icon/add.gif')]")
    private WebElement addIcon;
    @FindBy(xpath = "//input[@name='submit']")
    private WebElement searchBtn;
    @FindBy(xpath = "//table[2]//tbody/tr[4]/td[@class='value']")
    private List<WebElement> newLaborCode;
    @FindBy(xpath = "//input[@value='Continue']")
    private WebElement continueBtn;
    @FindBy(xpath = "(//table[2]/tbody/tr/td[3])[2]")
    private WebElement addedJobToLabor;
    @FindBy(xpath = "(//table[2]/tbody/tr/td[2])[2]")
    private WebElement laborTimeOfAddedJob;
    @FindBy(xpath = "//table[2]/tbody/tr[3]/td[4]")
    private WebElement laborTotalPrice;
    @FindBy(xpath = "//table[1]//tbody//tr//td[@class='value'][2]")
    private WebElement addedPartDescription;
    @FindBy(xpath = "//table[1]//tbody//tr//td[@class='value'][4]")
    private WebElement addedPartPrice;
    @FindBy(xpath = "//td[@class='price-value']")
    private List<WebElement> priceValues;
    @FindBy(xpath = "(//tr[@class='headline'])[1]//following-sibling::tr//td[2]")
    private List<WebElement> partDescriptions;
    @FindBy(xpath = "(//tr[@class='headline'])[2]//following-sibling::tr//td[3]")
    private List<WebElement> laborDescriptions;
    @FindBy(xpath = "(//tr[@class='headline'])[2]//following-sibling::tr//td[4]")
    private List<WebElement> jlrLaborPrice;
    @FindBy(xpath = "//input[@value='Add Labour']")
    private WebElement addLaborBtn;
    @FindBy(xpath = "//td[contains(text(),'Replace pollen filter.')]//following-sibling::td//input")
    private WebElement specifyLaborTime;
    @FindBy(xpath = "//input[contains(@onclick,'doSupportEnquiry();')]")
    private WebElement supportBtn;
    @FindBy(xpath = "//div[contains(text(),'Support Enquiry ')]")
    private WebElement supportTitle;
    @FindBy(xpath = "(//input[@type='checkbox'])")
    private List<WebElement> enquiryCheckboxes;
    @FindBy(xpath = "//textarea[@name='relevantInfo']")
    private WebElement relevantInfoText;
    @FindBy(xpath = "//input[@value='Cancel']")
    private WebElement cancelBtn;
    @FindBy(xpath = "//input[@value='Send']")
    private WebElement sendBtn;
    @FindBy(id = "errors")
    private WebElement sendErrorMsg;

    public PartLaborDrillDownPage(WebDriver driver) {
        super(driver);
    }

    public Boolean IsPartsAndLaborDetailDisplayed() {
        waitInSec(2);
        return elementIsDisplay(partsAndLaborDetail);
    }

    public List<List<String>> getPartDescriptionAndPriceList() {
        List<List<String>> partDescriptionAndPrice = Arrays.asList(getListOfContents(partDescription), getListOfContents(partPrice));
        return partDescriptionAndPrice;
    }

    public List<List<String>> getLaborDescriptionAndPriceList() {
        List<List<String>> laborDescriptionAndPrice = Arrays.asList(getListOfContents(laborDescription), getListOfContents(laborPrice));
        return laborDescriptionAndPrice;
    }

    public List<String> getPartDescriptionAndPrice() {
        List<String> partDescriptionAndPrice = Arrays.asList(getText(addedPartDescription).trim(), getText(addedPartPrice).trim());
        return partDescriptionAndPrice;
    }

    public PartLaborDrillDownPage clickOnAddLaborBtn() {
        click(addLabor);
        return this;
    }

    public PartLaborDrillDownPage selectRadioBtn(int rowNumber) {
        waitInSec(2);
        WebElement element = driver.findElement(By.xpath(String.format(LABOR_RADIO_BTN, rowNumber)));
        element.click();
        return this;
    }

    public PartLaborDrillDownPage enterSearchCriteria(String text) {
        sendKeys(searchCriteria, text);
        return this;
    }

    public PartLaborDrillDownPage enterLaborTime(String laborTimeInMin) {
        sendKeys(laborTime, laborTimeInMin);
        return this;
    }

    public PartLaborDrillDownPage clickOnAddIcon(int index) {
        click(driver.findElement(By.xpath(String.format(ADD_LABOR_ICON, index))));
        return this;
    }

    public PartLaborDrillDownPage clickOnSearchBtn() {
        click(searchBtn);
        return this;
    }

    public List<String> getAddedLabourCode() {
        return getListOfContents(newLaborCode);
    }

    public PartLaborDrillDownPage clickOnContinueBtn() {
        click(continueBtn);
        return this;
    }

    public String getAddedJobToLaborList() {
        waitInSec(2);
        return getText(addedJobToLabor);
    }

    public String getTotalPrice(String LabourRetailPerHour) {
        waitInSec(2);
        Float laborTimeDTU = Float.parseFloat(getText(laborTimeOfAddedJob));
        Float LaborTotalPrice = (laborTimeDTU * Float.parseFloat(LabourRetailPerHour));
        return df.format(LaborTotalPrice);
    }

    public String getLaborTotalPriceToAddedJob() {
        String totalPrice = getText(laborTotalPrice).substring(2);
        return totalPrice;
    }

    public Double getPartCostPrice() {
        double costPrice = 0.0f;
        String price = getText(addedPartPrice).trim();
        StringBuffer sb = new StringBuffer(price);
        String amount = String.valueOf(sb.delete(0, 1));
        costPrice = costPrice + Float.parseFloat(amount);
        return costPrice;
    }

    public Double getPartPriceForAQuantity(Double exceptPartPrice, int index) {
        String quantity = getTextBasedOnIndex(QUANTITY, index).trim();
        Double partQuality = Double.parseDouble(quantity);
        Double price = exceptPartPrice * partQuality;
        return price;
    }

    public List<String> getPartQuantityAndPrice(int index) {
        List<String> partQuantityAndPrice = Arrays.asList(getTextBasedOnIndex(QUANTITY, index).trim(), getText(addedPartPrice).trim());
        return partQuantityAndPrice;
    }

    public String getLaborTime(int price, String laborOperationCode, int index) {
        waitInSec(2);
        WebElement element1 = driver.findElement(By.xpath(String.format(LABOR_TIME, laborOperationCode, index)));
        float time = Float.parseFloat(getText(element1).trim());
        System.out.println("Time:" + time);
        float actualPrice = time * price;
        System.out.println("Price:" + price);
        return df.format(actualPrice);
    }

    public Float getLaborTimeWithoutPrice(String laborOperationCode, int index) {
        WebElement element1 = driver.findElement(By.xpath(String.format(LABOR_TIME, laborOperationCode, index)));
        float time = Float.parseFloat(getText(element1).trim());
        float actualLaborTime = time * 60;
        return actualLaborTime;
    }

    public List<List<String>> getPartsItemDescriptionAndPrice() {
        List<List<String>> partsDetails = Arrays.asList(getListOfContents(priceValues), getListOfContents(partDescriptions));
        return partsDetails;
    }

    public List<List<String>> getLabourItemDescriptionAndPrice() {
        List<List<String>> laborDescriptionAndPrice = Arrays.asList(getListOfContents(laborDescriptions), getListOfContents(jlrLaborPrice));
        return laborDescriptionAndPrice;
    }

    public PartLaborDrillDownPage enterJLRLaborTime(String text) {
        sendKeys(specifyLaborTime, text);
        return this;
    }

    public PartLaborDrillDownPage clickOnSupportBtn() {
        click(supportBtn);
        return this;
    }

    public boolean isSupportPageTitleDisplayed() {
        waitInSec(2);
        return supportTitle.isDisplayed();
    }

    public PartLaborDrillDownPage clickOnPartAndLaborEnquiryCheckbox(int index) {
        waitInSec(2);
        WebElement enquiryCheckBox = driver.findElement(By.xpath(String.format(ENQUIRY_CHECKBOX, index)));
        for (int i = 0; i < enquiryCheckboxes.size(); i++) {
            if (!enquiryCheckBox.isSelected()) {
                enquiryCheckBox.click();
            }
        }
        return this;
    }

    public PartLaborDrillDownPage enterRelevantInfoText(String text) {
        sendKeys(relevantInfoText, text);
        return this;
    }

    public PartLaborDrillDownPage clickOnCancelBtn() {
        click(cancelBtn);
        return this;
    }

    public PartLaborDrillDownPage clickOnSendBtn() {
        click(sendBtn);
        return this;
    }

    public String getErrorMsg() {
        return getText(sendErrorMsg);
    }
}
