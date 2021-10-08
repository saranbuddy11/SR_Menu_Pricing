package GM.gmObjectRepository.administration;

import base.FunctionalLibrary;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class CommonJobsPage extends FunctionalLibrary {
    private static final String EDIT_ICON = "(//img[contains(@src,'/images/icon/edit')])[%d]";
    private static final String JLR_GENERIC_JOB_EditIcon = "(//td[contains(text(),'%s')]//following-sibling::td)[4]";
    private static final String ADDED_DEALER_CUSTOM_JOB = "//td[contains(text(),'%s')]//following-sibling::td";
    private static final String GENERIC_JOBS = "//td[contains(text(),'%s')]//following-sibling::td";
    private static final String DIALOG_BTN = "//span[contains(text(),'%s')]";

    @FindBy(xpath = "//a[contains(text(),'Common Jobs')]")
    private WebElement commonJobsBtn;
    @FindBy(xpath = "//span[contains(text(),'Common Jobs')]")
    private WebElement commonJobs;
    @FindBy(xpath = "//input[@name='description']")
    private WebElement description;
    @FindBy(xpath = "//input[@name='cost']")
    private WebElement cost;
    @FindBy(xpath = "//input[@name='price']")
    private WebElement retail;
    @FindBy(xpath = "//select[@name='taxBand']")
    private WebElement taxBrand;
    @FindBy(xpath = "(//td[contains(text(),'Vehicle Cleaning - Engine Wash')]//following-sibling::td)[4]")
    private WebElement genericJobEditIcon;
    @FindBy(xpath = "(//tr[@class='unselectedrow'])[1]//td//input[@type='text']")
    private List<WebElement> genericJobEditFields;
    @FindBy(xpath = "")
    private List<WebElement> vehicleCleaningEngineWashCommonJobs;
    @FindBy(xpath = "(//td[contains(text(),'Selenium Testing Job 1')]//following-sibling::td)[5]")
    private WebElement genericTestJob1JobDeleteIcon;
    @FindBy(xpath = "(//table[@id='customjobs-content'])[2]/tbody/tr/td[2]")
    private List<WebElement> dealerCustomJobsTableDescriptions;
    @FindBy(xpath = "//div[@id='errors']/ol/li")
    private WebElement errorMSg;
    @FindBy(xpath = "//a[contains(text(),'Generic Jobs')]")
    private WebElement genericJobsBtn;
    @FindBy(xpath = "//p[contains(@id,'dialog-confirm')]")
    private WebElement dialogConfirm;

    public CommonJobsPage(WebDriver driver) {
        super(driver);
    }

    public CommonJobsPage openCommonJobsTab() {
        click(commonJobsBtn);
        return this;
    }

    public CommonJobsPage openGenericJobsTab() {
        click(genericJobsBtn);
        return this;
    }

    public CommonJobsPage enterDescription(String descriptionText) {
        description.clear();
        sendKeys(description, descriptionText);
        return this;
    }

    public CommonJobsPage enterCostPrice(String price) {
        sendKeys(cost, price);
        return this;
    }

    public CommonJobsPage enterRetailPrice(String price) {
        sendKeys(retail, price);
        return this;
    }

    public CommonJobsPage selectTaxRatePercent(String taxRate) {
        Select marketDropdown = new Select(taxBrand);
        marketDropdown.selectByVisibleText(taxRate);
        return this;
    }

    public Boolean isAddedDealerCustomJobDisplayed(String addedJob) {
        return elementIsDisplay(driver.findElement(By.xpath(String.format(ADDED_DEALER_CUSTOM_JOB, addedJob))));
    }

    public CommonJobsPage clickOnGenericJobEditIcon() {
        click(genericJobEditIcon);
        return this;
    }

    public List<String> getGenericJobEditFieldsElementsDisplayed() {
        return getListOfContents(genericJobEditFields);
    }

    public List<String> getUpdatedVehicleCleaningEngineWashCommonJobsPrice(String genericJob) {
        List<WebElement> data = driver.findElements(By.xpath(String.format(GENERIC_JOBS, genericJob)));
        return getListOfContents(data);
    }

    public CommonJobsPage clickOnGenericTestJob1JobDeleteIcon() {
        click(genericTestJob1JobDeleteIcon);
        return this;
    }

    public String getWarningMSg() {
        return getPopUpText();
    }

    public List<String> getDealerCustomJobsTableDescriptions() {
        return getListOfContents(dealerCustomJobsTableDescriptions);
    }

    public String getErrorMSg() {
        return getText(errorMSg);
    }

    public CommonJobsPage cleanUP() {
        clickOnGenericJobEditIcon();
        enterRetailPrice("26.00");
        enterCostPrice("11.00");
        clickOnSaveBtn();
        return this;
    }

    public CommonJobsPage editCommonJobPrice(int index, String retail, String cost) {
        clickBasedOnIndex(EDIT_ICON, index);
        enterRetailPrice(retail);
        enterCostPrice(cost);
        clickOnSaveBtn();
        return this;
    }

    public CommonJobsPage clickOnJLRGenericJobEditIcon(String genericJob) {
        click(driver.findElement(By.xpath(String.format(JLR_GENERIC_JOB_EditIcon, genericJob))));
        return this;
    }

    public String getDialogConfirmMSg() {
        return dialogConfirm.getText();
    }

    public CommonJobsPage clickOnDialogBtn(String btn) {
        click(driver.findElement(By.xpath(String.format(DIALOG_BTN, btn))));
        return this;
    }
}
