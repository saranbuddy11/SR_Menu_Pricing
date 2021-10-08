package GM.gmObjectRepository;

import base.FunctionalLibrary;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Arrays;
import java.util.List;

public class GMCreateEstimateCustomerPage extends FunctionalLibrary {

    @FindBy(xpath = "//span[contains(text(),'Customer')]")
    private WebElement customerTab;
    @FindBy(xpath = "//input[@name='name']")
    private WebElement customerNameField;
    @FindBy(id = "theSearchButton")
    private WebElement searchBtn;
    @FindBy(xpath = "//table[@id='repairerDetail1']//tbody//tr//td[@class='formField']//parent::td//input")
    private List<WebElement> customerDetails;
    @FindBy(id = "btnContinue")
    private WebElement continueBtn;
    @FindBy(xpath = "//input[@name='btnReset']")
    private WebElement clearBtn;
    @FindBy(xpath = "(//input[@name='btnCreate'])[1]")
    private WebElement createBtn;
    @FindBy(xpath = "//table[@id='repairerDetail1']")
    private WebElement repairerDetail;
    @FindBy(xpath = "(//td[@class='status-content'])[1]")
    private WebElement customerNameHeader;
    @FindBy(xpath = "(//td[@class='status-address'])[1]")
    private WebElement customerAddressHeader;
    @FindBy(xpath = "(//td[@class='status-address'])[2]")
    private WebElement customerZipCodeHeader;
    @FindBy(xpath = "(//span[contains(text(),'OK')])")
    private WebElement okBtn;
    @FindBy(xpath = "//input[@name='address']")
    private WebElement customerAddressField;
    @FindBy(xpath = "//input[@name='postcode']")
    private WebElement customerPostcodeField;

    public GMCreateEstimateCustomerPage(WebDriver driver) {
        super(driver);
    }

    public GMCreateEstimateCustomerPage enterCustomerName(String text) {
        sendKeys(customerNameField, text);
        return this;
    }

    public GMCreateEstimateCustomerPage clickOnSearchBtn() {
        click(searchBtn);
        return this;
    }

    public List<String> getRepairerDetailInput() {
        return getListOfContents(customerDetails);
    }

    public GMCreateEstimateCustomerPage clickOnContinueBtn() {
        click(continueBtn);
        return this;
    }

    public GMCreateEstimateCustomerPage clickOnClearBtn() {
        click(clearBtn);
        return this;
    }

    public GMCreateEstimateCustomerPage clickOnCreateBtn() {
        click(createBtn);
        return this;
    }

    public Boolean isRepairerDetailFieldDisplayed() {
        return elementIsDisplay(repairerDetail);
    }

    public List<String> getHeaderCustomerDetails() {
        String name = customerNameHeader.getText().trim();
        String address = customerAddressHeader.getText().trim();
        String zipCode = customerZipCodeHeader.getText().trim();
        List<String> customerDetails = Arrays.asList(name, address, zipCode);
        return customerDetails;
    }

    public GMCreateEstimateCustomerPage clickOnOKBtn() {
        fluentWait(okBtn);
        click(okBtn);
        return this;
    }

    public GMCreateEstimateCustomerPage enterAddress(String text) {
        sendKeys(customerAddressField, text);
        return this;
    }

    public GMCreateEstimateCustomerPage enterPostCode(String text) {
        sendKeys(customerPostcodeField, text);
        return this;
    }
}
