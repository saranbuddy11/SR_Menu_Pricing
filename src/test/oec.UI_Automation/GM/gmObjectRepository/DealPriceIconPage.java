package GM.gmObjectRepository;

import base.FunctionalLibrary;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DealPriceIconPage extends FunctionalLibrary {

    private static final String RADIO_BTN = "(//input[@name='discountType'])[%d]";

    @FindBy(xpath = "//div[@class='headline']")
    private WebElement dealPriceTitle;
    @FindBy(xpath = "//input[@name='discountDescription']")
    private WebElement discountDescription;
    @FindBy(xpath = "//input[@name='dealPrice']")
    private WebElement dealPrice;
    @FindBy(xpath = "//input[@name='dealPriceDiscount']")
    private WebElement dealPriceDiscountPercentage;
    @FindBy(xpath = "//input[@value='Ok']")
    private WebElement okBtn;
    @FindBy(xpath = "//div[@id='errors']/ol/li")
    private WebElement warnMsg;
    @FindBy(xpath = "//div[@id='showErrors']/ol")
    private WebElement jlrWarnMsg;
    @FindBy(xpath = "//input[@name='cancel']")
    private WebElement cancelBtn;

    public DealPriceIconPage(WebDriver driver) {
        super(driver);
    }

    public Boolean isDealPriceTitleDisplayed() {
        return elementIsDisplay(dealPriceTitle);
    }

    public DealPriceIconPage renameDiscountDescription(String description) {
        sendKeys(discountDescription, description);
        return this;
    }

    public DealPriceIconPage enterDealPrice(String dealPriceDiscount) {
        sendKeys(dealPrice, dealPriceDiscount);
        return this;
    }

    public Boolean getRenameDiscountDescription() {
        return elementIsDisplay(discountDescription);
    }

    public Boolean isDealPriceEnteredDigit() {
        return elementIsDisplay(dealPrice);
    }

    public DealPriceIconPage clickOnOkBtn() {
        click(okBtn);
        return this;
    }

    public DealPriceIconPage clickOnDiscountRadioBtn(int rowNumber) {
        clickBasedOnIndex(RADIO_BTN, rowNumber);
        return this;
    }

    public DealPriceIconPage enterDealPriceDiscount(String dealPriceDiscount) {
        sendKeys(dealPriceDiscountPercentage, dealPriceDiscount);
        return this;
    }

    public String getDealPriceWarnMsg() {
        return getText(warnMsg);
    }

    public String getJLRDealPriceWarnMsg() {
        return getText(jlrWarnMsg);
    }

    public DealPriceIconPage clickOnCancelBtn() {
        click(cancelBtn);
        return this;
    }
}
