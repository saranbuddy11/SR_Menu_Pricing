package GM.gmObjectRepository;

import base.FunctionalLibrary;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ExpPartAndLabourPage extends FunctionalLibrary {

    private static final String RADIO_BTN_EXPORT = "(//input[@type='radio'])[%d]";
    private static final String FORMAT_DROP_DOWN = "//select[@name='%s']";
    private static final String CONTENT_FIELD_BTN = "(//input[@value='%s'])[%d]";
    private static final String FILE_FORMAT = "//input[@name='fileFormat' and @value='%s']";

    @FindBy(xpath = "//td[contains(text(),'BlankText:')]")
    private WebElement blankText;
    @FindBy(xpath = "//td[contains(text(),'Separator:')]")
    private WebElement separatorLabel;
    @FindBy(id = "selectPartFields1")
    private WebElement selectPartField;
    @FindBy(id = "selectPartFields0")
    private WebElement availablePartField;
    @FindBy(xpath = "//input[@value='Save Changes']")
    private WebElement saveChangesBtn;
    @FindBy(xpath = "//div[@class='ui-dialog-buttonset']//button")
    private  WebElement saveChangesOk;

    public ExpPartAndLabourPage(WebDriver driver) {
        super(driver);
    }

    public ExpPartAndLabourPage clickOnRadioBtn() {
        for (int i = 1; i <= 8; i++) {
            waitInSec(2);
            WebElement radioBtn = driver.findElement(By.xpath(String.format(RADIO_BTN_EXPORT, i)));
            if (radioBtn.isSelected() == false) {
                waitInSec(2);
                moveToElementClick(radioBtn);
            }
        }
        return this;
    }

    public boolean isRadioOptionsSelected() {
        WebElement radioBtn = driver.findElement(By.xpath(String.format(RADIO_BTN_EXPORT, 2)));
        return radioBtn.isSelected();
    }

    public boolean isBlankTextDisplayed() {
        return blankText.isDisplayed();
    }

    public List<String> getBlackTextDropDownOptions(String name) {
        WebElement blankTextDropDownOptions = driver.findElement(By.xpath(String.format(FORMAT_DROP_DOWN, name)));
        List<String> options = new ArrayList<>();
        Select dropDown = new Select(blankTextDropDownOptions);
        for (WebElement option : dropDown.getOptions()) {
            options.add(option.getText());
        }
        return options;
    }

    public ExpPartAndLabourPage selectBlankTextOption(String name) {
        WebElement blankTextDropDownOptions = driver.findElement(By.xpath(String.format(FORMAT_DROP_DOWN, name)));
        Select option = new Select(blankTextDropDownOptions);
        option.selectByVisibleText("default");
        return this;
    }

    public String getSelectedBlankTextOption(String name) {
        WebElement blankTextDropDownOptions = driver.findElement(By.xpath(String.format(FORMAT_DROP_DOWN, name)));
        Select option = new Select(blankTextDropDownOptions);
        String selectedValue = option.getFirstSelectedOption().getText();
        return selectedValue;
    }

    public boolean isSeparatorLabelDisplayed() {
        return separatorLabel.isDisplayed();
    }

    public ExpPartAndLabourPage selectedAPartContent(String value1,String value2) {
        scrollToTheBottom();
        Select options = new Select(selectPartField);
        options.selectByValue(value1);
        options.selectByValue(value2);
        return this;
    }

    public ExpPartAndLabourPage availableAPartContent(String value1,String value2) {
        scrollToTheBottom();
        Select options = new Select(availablePartField);
        options.selectByValue(value1);
        options.selectByValue(value2);
        return this;
    }

    public ExpPartAndLabourPage selectArrowsBtn(String arrows, int index) {
        WebElement arrowsBtn = driver.findElement(By.xpath(String.format(CONTENT_FIELD_BTN, arrows, index)));
        click(arrowsBtn);
        return this;
    }

    public List<String> getAvailableColumnValues() {
        Select options = new Select(availablePartField);
        List<String> values = new ArrayList<>();
        for (int i = 0; i < options.getOptions().size(); i++) {
            values.add(options.getOptions().get(i).getText());
        }
        return values;
    }

    public List<String> getSelectedColumnValues() {
        Select options = new Select(selectPartField);
        List<String> values = new ArrayList<>();
        for (int i = 0; i < options.getOptions().size(); i++) {
            values.add(options.getOptions().get(i).getText());
        }
        return values;
    }

    public Boolean getSelectedFormat(String format){
        waitInSec(2);
        WebElement selected = driver.findElement(By.xpath(String.format(FILE_FORMAT, format)));
        String checkedvalue = selected.getAttribute("checked");
        if(checkedvalue!="true")
        {
            fluentWait(selected);
            selected.click();
            fluentWait(saveChangesBtn);
            saveChangesBtn.click();
            fluentWait(saveChangesOk);
            saveChangesOk.click();
            waitInSec(3);
            return true;
        }
        else {
            return true;
        }
    }
}
