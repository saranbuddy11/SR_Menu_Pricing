package GM.gmObjectRepository.administration;

import base.FunctionalLibrary;
import model.BasedOnPartPriceType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class CustomerTypesPage extends FunctionalLibrary {

    private static final String Description = "(//input[contains(@name,'description')])[%d]";
    private static final String BasedOnPartPriceType = "(//select[contains(@name,'basedOn')])[%d]";
    private static final String AdjustPercentParts = "(//input[contains(@name,'adjustPercentParts')])[%d]";
    private static final String AdjustPercentLabour = "(//input[contains(@name,'adjustPercentLabour')])[%d]";

    @FindBy(xpath = "//a[contains(text(),'Cust. Types')]")
    private WebElement customerTypesBtn;
    @FindBy(xpath = "//input[@value='Save']")
    private WebElement saveBtn;
    @FindBy(xpath = "(//img[contains(@src,'/images/icon/delete')])[2]")
    private WebElement deleteIcon;
    @FindBy(xpath = "//img[@class='cursor-pointer']") //tr[@class='unselectedrow']//img[@class='cursor-pointer']")
    private List<WebElement> deleteIcons;
    @FindBy(xpath = "//div[@id='errors']/ol/li")
    private WebElement errorMsg;
    @FindBy(xpath = "//input[@readonly='readonly']")
    private WebElement adjustPercentPartsDisable;

    public CustomerTypesPage(WebDriver driver) {
        super(driver);
    }

    public CustomerTypesPage openCustomerTypesTab() {
        click(customerTypesBtn);
        return this;
    }

    public CustomerTypesPage enterRetailDescription(String descriptionName) {
        WebElement description1 = driver.findElement(By.xpath(String.format(Description, 2)));
        sendKeys(description1, descriptionName);
        return this;
    }

    public CustomerTypesPage selectPriceType(BasedOnPartPriceType option) {
        waitInSec(2);
        WebElement basedOnPartPriceType = driver.findElement(By.xpath(String.format(BasedOnPartPriceType, 2)));
        Select customerType = new Select(basedOnPartPriceType);
        customerType.selectByVisibleText(option.getName());
        return this;
    }

    public CustomerTypesPage enterAdjustPercentParts(int percent) {
        WebElement adjustPercentParts = driver.findElement(By.xpath(String.format(AdjustPercentParts, 2)));
        sendKeysNumber(adjustPercentParts, percent);
        return this;
    }

    public CustomerTypesPage enterAdjustPercentLabour(int percent) {
        WebElement percentLabour = driver.findElement(By.xpath(String.format(AdjustPercentLabour, 2)));
        sendKeysNumber(percentLabour, percent);
        return this;
    }

    public boolean isDescriptionDisplayed() {
        waitInSec(5);
        WebElement description1 = driver.findElement(By.xpath(String.format(Description, 2)));
        return elementIsDisplay(description1);
    }

    public boolean isAdjustPercentPartsDisplayed() {
        waitInSec(5);
        WebElement adjustPercentParts = driver.findElement(By.xpath(String.format(AdjustPercentParts, 2)));
        return elementIsDisplay(adjustPercentParts);
    }

    public Boolean isAdjustPercentLabourDisplayed() {
        WebElement percentLabour = driver.findElement(By.xpath(String.format(AdjustPercentLabour, 2)));
        return elementIsDisplay(percentLabour);
    }

    public Boolean isDeleteIconDisplayed() {
        return elementIsDisplay(deleteIcon);
    }

    public CustomerTypesPage clickOnDeleteIcon() {
        click(deleteIcon);
        return this;
    }

    public int getDeleteIconSize() {
        return getSize(deleteIcons);
    }

    public String getErrorMsg() {
        return getText(errorMsg);
    }

    public Boolean isAdjustPercentPartDisable() {
        return elementIsEnabled(adjustPercentPartsDisable);
    }
}
