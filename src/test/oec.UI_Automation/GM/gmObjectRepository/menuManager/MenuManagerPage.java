package GM.gmObjectRepository.menuManager;

import GM.gmObjectRepository.CalenderPage;
import base.FunctionalLibrary;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.NoSuchElementException;

public class MenuManagerPage extends FunctionalLibrary {

    private static final String RULE_STRUCTURE_TEXT_COLOR_XPATH = "//div[@class='level1']//span[contains(text(),'Rule Structure')]";
    private static final String EFFECT_ENTRY_XPATH = "//input[@id='effect-entry-%d']";
    private static final String TAB_ADD_ICON_XPATH = "(//div[contains(@id,'context-action-effect-add')]//img[contains(@src,'tab_add')])[%d]";
    private static final String RULE_NAME = "//td[contains(text(), '%s')]//following-sibling::td//img[contains(@alt, 'Rule Basics')]";

    @FindBy(xpath = "//span[contains(text(),'Rule Basics')]")
    private WebElement rulesBasicTab;
    @FindBy(xpath = "//a[contains(text(),'Rule Structure')]")
    private WebElement ruleStructureTab;
    @FindBy(xpath = "//a[contains(text(),'List Rules')]")
    private WebElement listRulesTab;
    @FindBy(id = "button-validFrom")
    private WebElement validFrom;
    @FindBy(id = "button-validTo")
    private WebElement validTo;
    @FindBy(xpath = "//tr[@class='daysrow']//td[contains(@class,'day')]")
    private WebElement days;
    @FindBy(xpath = "(//td[@class='button']//following-sibling::td[@class='title'])[2]")
    private WebElement headerCalender;
    @FindBy(xpath = "//input[@name='ruleName']")
    private WebElement ruleName;
    @FindBy(xpath = "//span[contains(text(),'saved')]")
    private WebElement ruleStructureStatus;
    @FindBy(xpath = "//td[contains(text(),'SeleniumTesting')]//following-sibling::td[@class='action-space']//a/img[@src='./images/icon/bin.png']")
    private WebElement binIcon;
    @FindBy(xpath = "//tr[@class='localmenus-rules']//td[@class='reportDate']")
    private WebElement reportDates;
    @FindBy(xpath = "//a[@href='LocalMenuRulesDownload.do']")
    private WebElement localMenuRulesDownload;
    @FindBy(xpath = "(//img[@src='./images/icon/calendar_edit.png'])[1]")
    private WebElement fromDate;
    @FindBy(name = "fileUpload")
    private WebElement ChooseFileUpload;
    @FindBy(xpath = "//input[@value='Upload Rules']")
    private WebElement uploadBtn;
    @FindBy(xpath = "//tr[contains(@class,'localmenus-rules changed')]//td[@class='ruleName']")
    private List<WebElement> appendRules;
    @FindBy(xpath = "//input[@value='IMPORT_APPEND_STRATEGY']")
    private WebElement appendRadioBtn;
    @FindBy(xpath = "//input[@value='IMPORT_OVERWRITE_STRATEGY']")
    private WebElement overWriteRulesRadioBtn;
    @FindBy(xpath = "//tr[@class='localmenus-rules changed-false-true']//td[@class='ruleName']")
    private List<WebElement> ruleNames;
    @FindBy(xpath = "//div[@id='deployRules-space']")
    private WebElement deployRulesDate;
    @FindBy(css = "#condition-entry-0 > option:nth-child(3)")
    private WebElement conditionValueChev;
    @FindBy(css = "#condition-entry-0")
    private WebElement conditionValue;
    @FindBy(xpath = "//img[contains(@src,'/evolution/images/icon/magnifier')]")
    private WebElement magnifierIcon;
    @FindBy(xpath = "(//img[contains(@src,'./images/icon/page_edit')])[1]")
    private WebElement editIcon;
    @FindBy(xpath = "//div[contains(@id,'context-action-effect-add')]//img[contains(@src,'tab_add')]")
    private WebElement addIcon;
    @FindBy(xpath = "//select[@name='selectRuleComponentId']")
    private WebElement ruleEditor;
    @FindBy(xpath = "(//select[@name='selectRuleComponentId'])[2]")
    private WebElement ruleEditor1;
    @FindBy(xpath = "(//select[@name='selectRuleComponentId'])[3]")
    private WebElement ruleEditor2;
    @FindBy(xpath = "//input[@id='effect-entry-1']")
    private WebElement effectEntry;
    @FindBy(xpath = "//span[@class='content status-warn']/a")
    private WebElement saveBtn;
    @FindBy(css = "#condition-entryDisplay-1")
    private WebElement conditionEntry1;
    @FindBy(xpath = "//input[@id='effect-entry-0']")
    private WebElement effectEntry0;
    @FindBy(xpath = "//input[@id='effect-entry-1']")
    private WebElement effectEntry1;
    @FindBy(css = "#EffectComponentAssignTotalPriceExclTax-1")
    private WebElement effectTotalPriceExclTax;
    @FindBy(xpath = "//td[contains(text(),'o mamo')]//following-sibling::td//a//img[contains(@src,'page_edit')]")
    private WebElement oMamoeditIcon;
    @FindBy(id = "overrideDealer-checkbox")
    private WebElement overrideDealerChekBox;
    @FindBy(xpath = "//input[@onclick='sessionCacheDeployRules();']")
    private WebElement deployRulesBtn;
    @FindBy(xpath = "//input[@name='beforeDate']")
    private WebElement beforeDate;
    @FindBy(xpath = "//input[@id='ruleSearchBox']")
    private WebElement ruleSearchBox;
    @FindBy(xpath = RULE_NAME)
    private WebElement editRuleBtn;


    public MenuManagerPage(WebDriver driver) {
        super(driver);
    }

    public MenuManagerPage openRulesBasicsTab() {
        click(rulesBasicTab);
        return this;
    }

    public MenuManagerPage clickOnValidFromDateIcon() {
        click(validFrom);
        return this;
    }

    public MenuManagerPage clickOnValidToDateIcon() {
        click(validTo);
        return this;
    }

    public CalenderPage selectDateCurrentDate() {
        waitInSec(2);
        moveToElementClick(fromDate);
        return new CalenderPage(driver);
    }


    public String getNameOfIdRule() {
        return getAttribute(ruleName).trim();
    }

    public boolean isRuleStructureSaved() {
        return elementIsDisplay(ruleStructureStatus);
    }

    public MenuManagerPage openRuleStructureTab() {
        click(ruleStructureTab);
        return this;
    }

    public MenuManagerPage openListRulesTab() {
        click(listRulesTab);
        return this;
    }

    public MenuManagerPage clickOnBinIcon() {
        try {
            click(binIcon);
        }catch (Exception e){
            e.printStackTrace();
        }
        return this;
    }

    public String getColorOfRuleStructureTab() {
        waitInSec(2);
        return getTextColor(driver.findElement(By.xpath(String.format(RULE_STRUCTURE_TEXT_COLOR_XPATH))));
    }

    public String getReportResult() {
        return getText(reportDates);
    }

    public MenuManagerPage clickOnDownloadAllRuleLink() {
        click(localMenuRulesDownload);
        return this;
    }

    public MenuManagerPage clickOnChooseUploadFile(String path) {
        chooseFile(ChooseFileUpload, path);
        return this;
    }

    public MenuManagerPage clickOnUploadRulesBtn() {
        waitInSec(2);
        click(uploadBtn);
        return this;
    }

    public MenuManagerPage clickOnOverwriteRulesRadioBtn() {
        waitInSec(2);
        click(overWriteRulesRadioBtn);
        return this;
    }

    public MenuManagerPage clickOnAppendRulesRadioBtn() {
        waitInSec(2);
        click(appendRadioBtn);
        return this;
    }

    public boolean isAppendedRule() {
        boolean ind = false;
        int appendRuleSize = appendRules.size();
        if (appendRuleSize >= 2) {
            ind = true;
        } else {
            ind = false;
        }
        return ind;
    }

    public List<String> getListOfRuleNames() {
        return getListOfContents(ruleNames);
    }

    public String getDeployedDate() {
        waitInSec(4);
        return getText(deployRulesDate);
    }

    public MenuManagerPage clickOnChevroletMake() {
        Select vehicleMake = new Select(conditionValue);
        vehicleMake.selectByIndex(2);
        acceptAlertIfPresent(MenuManagerPage.class);
        return this;
    }

    public MenuManagerPage clickOnMagnifierIcon() {
        waitInSec(5);
        moveToElementAndForceClick(magnifierIcon);
        try {
            waitInSec(5);
            jsClickElement(magnifierIcon);
        } catch (Exception e) {
            e.printStackTrace();
        }
        waitInSec(10);
        return this;
    }

    public MenuManagerPage clickOnEditIcon() {
        waitInSec(2);
        click(editIcon);
        return this;
    }

    public MenuManagerPage setTotalPrice() {
        waitInSec(2);
        Select totalPriceSet = new Select(ruleEditor);
        totalPriceSet.selectByValue("24");
        return this;
    }

    public MenuManagerPage setLaborRate() {
        waitInSec(2);
        Select laborRate = new Select(ruleEditor1);
        laborRate.selectByIndex(5);
        return this;
    }

    public MenuManagerPage setLaborTime() {
        waitInSec(2);
        Select laborTime = new Select(ruleEditor2);
        laborTime.selectByIndex(4);
        return this;
    }

    public MenuManagerPage clickOnAddIcon(int index) {
        waitInSec(2);
        WebElement element = driver.findElement(By.xpath(String.format(TAB_ADD_ICON_XPATH, index)));
        moveToElementClick(element);
        return this;
    }

    public MenuManagerPage inputEffectEntry(String text) {
        sendKeys(effectEntry, text);
        return this;
    }

    public MenuManagerPage clickOnRuleStructureSaveBtn() {
        click(saveBtn);
        return this;
    }

    public String getConditionEntryValue1() {
        fluentWait(conditionEntry1);
        waitInSec(2);
        return conditionEntry1.getAttribute("value");
    }

    public String getEffectEntryValue1() {
        fluentWait(effectEntry0);
        return effectEntry0.getAttribute("value");
    }

    public boolean is240EffectComponentAutoAddMenuSelected() {
        fluentWait(effectTotalPriceExclTax);
        return effectTotalPriceExclTax.isSelected();
    }

    public String getEffectEntryValue2() {
        fluentWait(effectEntry1);
        return effectEntry1.getAttribute("value");
    }

    public MenuManagerPage clickOnOMaMoEditIcon() {
        click(oMamoeditIcon);
        waitInSec(2);
        if (overrideDealerChekBox.isSelected()) {
            click(overrideDealerChekBox);
        }
        return this;
    }

    public MenuManagerPage clickOnODeployRules() {
        try {
            fluentWait(deployRulesBtn);
            click(deployRulesBtn);
        }catch (NoSuchElementException e){
            e.printStackTrace();
            waitInSec(5);
            jsClickElement(deployRulesBtn);
        }
        return this;
    }

    public MenuManagerPage sendKeysEffectEntry(String text, int index) {
        waitInSec(2);
        WebElement element = driver.findElement(By.xpath(String.format(EFFECT_ENTRY_XPATH, index)));
        element.clear();
        element.sendKeys(text);
        return this;
    }

    public String getBeforeDate() {
        fluentWait(beforeDate);
        return beforeDate.getAttribute("value");
    }

    public MenuManagerPage editRule(String ruleName)
    {
        waitInSec(2);
        fluentWait(ruleSearchBox);
        ruleSearchBox.clear();
        ruleSearchBox.sendKeys(ruleName);
        waitInSec(2);
        WebElement element = driver.findElement(By.xpath(String.format(RULE_NAME, ruleName)));
        element.click();
        return this;
    }

    public MenuManagerPage clickRuleStructure()
    {
        fluentWait(ruleStructureTab);
        ruleStructureTab.click();
        waitInSec(2);
        return this;
    }
    public Boolean verifyEffect(String effect1, String effect2)
    {
        Boolean effectExist = false;
        String text = effectEntry0.getAttribute("value");
        String text1 = effectEntry1.getAttribute("value");
        if(text.contains(effect1) && text1.contains(effect2)){
            effectExist = true;
        }
        return effectExist;
    }
}
