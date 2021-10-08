package GM.gmObjectRepository.miscellaneous;

import base.FunctionalLibrary;
import model.JobFormList;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class JobsPage extends FunctionalLibrary {

    @FindBy(xpath = "(//select[@name='taxBand']/option)[1]")
    private WebElement taxRate;
    @FindBy(xpath = "//input[@value='Add']")
    private WebElement addBtn;
    @FindBy(xpath = "//div[@id=\"errors\"]/ol/li")
    private WebElement miscAddJobErrorMsg;
    @FindBy(xpath = "//select[contains(@name,'Id')]")
    private WebElement jobFormDropDown;
    @FindBy(xpath = "//textarea[@name='description']")
    private WebElement descriptionTextArea;
    @FindBy(xpath = "//input[@name='price']")
    private WebElement price;
    @FindBy(xpath = "//input[@name='cost']")
    private WebElement cost;
    @FindBy(xpath = "//select[@name='taxBand']")
    private WebElement taxBandDropDown;
    @FindBy(xpath = "//input[@value='Cancel']")
    private WebElement cancelBtn;

    public JobsPage(WebDriver driver) {
        super(driver);
    }

    public String getTaxRate() {
        waitInSec(5);
        return getText(taxRate);
    }

    public JobsPage clickOnAddBtn() {
        waitInSec(2);
        jsClickElement(addBtn);
        return this;
    }

    public String getMiscAddJobErrorMsg() {
        return getText(miscAddJobErrorMsg);
    }

    public JobsPage selectJobFormDropDownOption(JobFormList jobForm) {
        waitInSec(5);
        Select jobFormList = new Select(jobFormDropDown);
        jobFormList.selectByVisibleText(jobForm.getName());
        return this;
    }

    public JobsPage inputDescription(String description) {
        sendKeys(descriptionTextArea, description);
        return this;
    }

    public JobsPage inputCost(String costAmount) {
        sendKeys(cost, costAmount);
        return this;
    }

    public JobsPage inputPrice(String priceAmount) {
        sendKeys(price, priceAmount);
        return this;
    }

    public JobsPage selectTaxRate(String percentage) {
        fluentWait(taxBandDropDown);
        Select taxBand = new Select(taxBandDropDown);
        taxBand.selectByVisibleText(percentage);
        return this;
    }

    public JobsPage clickOnCancelBtn() {
        waitInSec(5);
        click(cancelBtn);
        return this;
    }
}
