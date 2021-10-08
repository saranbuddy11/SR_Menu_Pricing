package GM.gmObjectRepository.administration;

import base.FunctionalLibrary;
import model.BulkFluidBrandAndQuality;
import model.BulkFluidLocalParts;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

import static org.openqa.selenium.By.xpath;

public class BulkFluidsPage extends FunctionalLibrary {

    private static final Log logger = LogFactory.getLog(BulkFluidsPage.class);

    private static final String INPUT = "//input[@name='%s']";
    private static final String ADDED_LOCAL_PART_DETAILS = "((//tr[@class='unselectedrow'])[%d]//td)[%d]";//6
    private static final String EDIT_FIELD_LOCAL_PART_POPULATED_DATA = "(//tbody/tr[2]/td/input[@type='text'])[%d]";
    private static final String OPERATION_CODE_VALUE = "(//table/tbody/tr[@class='unselectedrow'][%d]//td)[6]";
    private static final String EDIT_ICON = "(//td[10]/a/img[@src='/evolution/images/icon/edit.gif'])[%d]";
    private static final String BULK_FLUID_PART_DETAILS = "((//tr[@class='unselectedrow'])[%d]//td)[%d]";////input[@checked='checked']
    private static final String DEFAULT_MARKET_PART = "(//input[@name='defaultPartIdTypePrefixed'])[%d]";
    private static final String ROUNDUP_CHECKBOX = "(//input[@name='box'])[%d]";
    private static final String BRAND_AND_QUALITY = "(//tr[contains(@style,'text-align')]/td[5])[%d]";
    private static final String DELETE_ICON = "(//td[contains(text(),'Test part 1')]//ancestor::tr[@class='unselectedrow']//td/a/img[@src='/evolution/images/icon/delete.gif'])[%d]";
    private static final String CALL_REMOVE_BRAND_QUALITY_ACTION = "//input[@name='callRemoveBrandQualityAction']";
    private static final String GENERIC_PART_LOCAl_JOB = "((//tr[@style='text-align: left;'])[%d]//td)[%d]";
    private static final String GENERIC_PART_EDIT_ICON = "(//img[contains(@src,'images/icon/edit')])[%d]";

    @FindBy(xpath = "(//select[contains(@name,'CategoryId')])[1]")
    private WebElement partCategory;
    @FindBy(xpath = "(//tr[@class='unselectedrow'])[6]//td")
    private List<WebElement> description;
    @FindBy(xpath = "//img[contains(@src,'delete')][1]")
    //"(((//tr[@class='unselectedrow'])[6]//td[@align='center'])//a//img[contains(@src,'delete')])[1]")
    private WebElement deleteIcon;
    @FindBy(xpath = "//tr[@class='unselectedrow']//td[4]")
    private List<WebElement> descriptionList;
    @FindBy(xpath = "(//td[@colspan='9'])[1]")
    private WebElement formLabelAndDropDown;
    @FindBy(xpath = "(//select[@name='partCategoryId']//option)[1]")
    private WebElement dropDownValue;
    @FindBy(xpath = "//img[contains(@src,'images/icon/arrow_undo')]")
    private WebElement undoArrowIcon;
    @FindBy(xpath = "(//input[@checked='checked'])")
    private WebElement checkedStatus;
    @FindBy(xpath = "(//tr[contains(@style,'text-align:')]//input[@type='checkbox'])")
    private List<WebElement> checkBoxes;
    @FindBy(xpath = "//select[@name='brandQualityName']")
    private WebElement brandQualityName;
    @FindBy(xpath = "//td[contains(text(),'Test part 1')]//ancestor::tr[@class='unselectedrow']//td/a/img[@src='/evolution/images/icon/delete.gif']")
    private List<WebElement> deleteIconOfBulkFluid;
    @FindBy(xpath = "//div[@class='bulk-fluid-collision-message']")
    private WebElement bulkFluidMessage;
    @FindBy(xpath = "//a[contains(text(),'System Settings')]//preceding::a[contains(text(),'Generic Parts')]")
    private WebElement genericPartsMenu;

    public BulkFluidsPage(WebDriver driver) {
        super(driver);
    }

    public BulkFluidsPage selectLocalPart(BulkFluidLocalParts part) {
        Select localPart = new Select(partCategory);
        localPart.selectByVisibleText(part.getPart());
        return this;
    }

    public BulkFluidsPage enterInput(String name, String text) {
        sendKeys((driver.findElement(xpath(String.format(INPUT, name)))), text);
        return this;
    }

    public List<String> getAddedLocalPart(int index) {
        String containerSize = getTextBasedOnDoubleIndex(ADDED_LOCAL_PART_DETAILS, index, 3);
        String description = getTextBasedOnDoubleIndex(ADDED_LOCAL_PART_DETAILS, index, 4);
        String partNo = getTextBasedOnDoubleIndex(ADDED_LOCAL_PART_DETAILS, index, 7);
        String cost = getTextBasedOnDoubleIndex(ADDED_LOCAL_PART_DETAILS, index, 8);
        String retailPrice = getTextBasedOnDoubleIndex(ADDED_LOCAL_PART_DETAILS, index, 9);

        List<String> actualData = Arrays.asList(containerSize, description, partNo, cost, retailPrice);

        return actualData;
    }

    public List<String> getEditFieldLocalPart() {
        String containerSize = getTextBasedOnIndex(EDIT_FIELD_LOCAL_PART_POPULATED_DATA, 1);
        String description = getTextBasedOnIndex(EDIT_FIELD_LOCAL_PART_POPULATED_DATA, 2);
        String partNo = getTextBasedOnIndex(EDIT_FIELD_LOCAL_PART_POPULATED_DATA, 3);
        String cost = getTextBasedOnIndex(EDIT_FIELD_LOCAL_PART_POPULATED_DATA, 5);
//        String retailPrice = getTextBasedOnIndex(EDIT_FIELD_LOCAL_PART_POPULATED_DATA, 6);

        List<String> actualData = Arrays.asList(containerSize, description, partNo, cost);

        return actualData;
    }

    public BulkFluidsPage clickOnEditIcon(int index) {
        clickBasedOnIndex(EDIT_ICON, index);
        return this;
    }

    public BulkFluidsPage clickOnDeleteIcon() {
        click(deleteIcon);
        return this;
    }

    public List<String> getDescriptionList() {
        return getListOfContents(descriptionList);
    }


    public String getFormLabel() {
        return getText(formLabelAndDropDown);
    }

    public String getDropDownValue() {
        return getText(dropDownValue);
    }

    public String getOperationCodeValue(int index) {
        return getTextBasedOnIndex(OPERATION_CODE_VALUE, index);
    }

    public int getTextBoxCharSize(int index) {
        String typedValue = getTextBasedOnIndex(OPERATION_CODE_VALUE, index);
        return typedValue.length();
    }

    public BulkFluidsPage clickOnUndoArrowIcon() {
        click(undoArrowIcon);
        return this;
    }

    public BulkFluidsPage clickOnDefaultPartIdTypeRadioBtn(int index) {
        waitInSec(2);
        clickBasedOnIndex(DEFAULT_MARKET_PART, index);
        return this;
    }

    public BulkFluidsPage clickOnDefaultPartIdTypeCheckbox(int index) {
        waitInSec(2);
        WebElement roundUpCheckBox = driver.findElement(By.xpath(String.format(ROUNDUP_CHECKBOX, index)));
        if (!roundUpCheckBox.isSelected()) {
            roundUpCheckBox.click();
        }
        return this;
    }

    public BulkFluidsPage uncheckAllPartIdTypeCheckbox() {
        waitInSec(2);
        for (int i = 1; i <= checkBoxes.size(); i++) {
            WebElement roundUpCheckBox = driver.findElement(By.xpath(String.format(ROUNDUP_CHECKBOX, i)));
            if (roundUpCheckBox.isSelected()) {
                roundUpCheckBox.click();
            }
        }
        return this;
    }

    public Boolean isMarketPartDefined(int index) {
        return elementIsDisplay(driver.findElement(xpath(String.format(DEFAULT_MARKET_PART, index))));
    }

    public BulkFluidsPage selectBrandAndQuality(BulkFluidBrandAndQuality brand) {
        Select brandAndQuality = new Select(brandQualityName);
        brandAndQuality.selectByVisibleText(brand.getBrand());
        return this;
    }

    public String getBrandAndQualityValue(int index) {
        return getTextBasedOnIndex(BRAND_AND_QUALITY, index);
    }

    public BulkFluidsPage removeAlreadyTestedLocalPart() {
        try {
            int deleteIconSize = deleteIconOfBulkFluid.size();
            for (int i = 0; i < deleteIconSize; i++) {
                click(deleteIconOfBulkFluid.get(i));
            }
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
        return this;
    }

    public boolean isBulkFluidCollisionMessageDisplayed() {
        return elementIsDisplay(bulkFluidMessage);
    }

    public BulkFluidsPage clickOnCallRemoveBrandQualityAction(int index) {
        waitInSec(2);
        clickBasedOnIndex(CALL_REMOVE_BRAND_QUALITY_ACTION, index);
        return this;
    }

    public BulkFluidsPage openGenericParts() {
        click(genericPartsMenu);
        return this;
    }

    public List<String> getJLRAddedLocalPart(int index) {
        List<String> actualData = new ArrayList<>();
        for (int i = 1; i < 9; i++) {
            WebElement part = driver.findElement(By.xpath(String.format(GENERIC_PART_LOCAl_JOB, index, i)));
            actualData.add(part.getText());
        }
        actualData.remove(0);
        actualData.remove(0);
        actualData.remove(5);
        return actualData;
    }

    public BulkFluidsPage clickOnGenericPartEditIcon(String environment, int index1, int index2) {
        int index = 0;
        if (environment.contains("qa")) {
            index = index2;
        } else if (environment.contains("uat")) {
            index = index1;
        }
        clickBasedOnIndex(GENERIC_PART_EDIT_ICON, index);
        return this;
    }
}