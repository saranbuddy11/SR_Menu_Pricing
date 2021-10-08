package GM.gmObjectRepository;

import base.FunctionalLibrary;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Arrays;
import java.util.List;

public class GMCreateEstimateNotesPage extends FunctionalLibrary {

    private static final String CHANGED_ESTIMATE_VALID_DATE = "//input[@value='%s']";
    private static final String VIN_BOX = "//input[@value='%s']";

    @FindBy(xpath = "//input[@name='validUntil']")
    private WebElement estimateValidDate;
    @FindBy(xpath = "//textarea[@name='notes']")
    private WebElement notesTextArea;
    @FindBy(xpath = "//input[@value='']")
    private List<WebElement> formField;
    @FindBy(xpath = "//input[@name='registration']")
    private WebElement licTextBox;
    @FindBy(xpath = "//input[@name='vin']")
    private WebElement vinTextBox;
    @FindBy(xpath = "//input[@name='distance']")
    private WebElement mileageTextBox;
    @FindBy(xpath = "//img[contains(@id,'createQuotes_validUntilButton')]")
    private WebElement createQuotes_validUntilButton;
    @FindBy(xpath = "//input[@name='validUntil']")
    private WebElement validUntil;

    public GMCreateEstimateNotesPage(WebDriver driver) {
        super(driver);
    }

    public boolean isVinDisplayedBox(String vinNo) {
        return elementIsDisplay(driver.findElement(By.xpath(String.format(VIN_BOX,vinNo))));
    }

    public GMCreateEstimateNotesPage editEstimateDate() {
        String currentDate = functionalLibrary.getCurrentDate();
        sendKeys(estimateValidDate, currentDate);
        return this;
    }

    public String getEstimateValidateChanged() {
        return validUntil.getAttribute("value");
    }

    public GMCreateEstimateNotesPage enterNotes(String text) {
        sendKeys(notesTextArea, text);
        return this;
    }

    public String getNotesText() {
        return getText(notesTextArea);
    }

    public List<String> getFormFieldValue() {
        return getListOfContentAttribute(formField);
    }

    public GMCreateEstimateNotesPage enterLicensePlate(String text) {
        sendKeys(licTextBox, text);
        return this;
    }

    public GMCreateEstimateNotesPage enterVinNo(String text) {
        sendKeys(vinTextBox, text);
        return this;
    }

    public GMCreateEstimateNotesPage enterMileage(String text) {
        sendKeys(mileageTextBox, text);
        return this;
    }

    public List<String> getVinAndRegNoValue() {
        String vin = getAttribute(vinTextBox);
        String lic = getAttribute(licTextBox);
        List<String> vinAndLICAttributes = Arrays.asList(lic, vin);
        return vinAndLICAttributes;
    }

    public String getMileageTextBoxValue() {
        return getAttribute(mileageTextBox);
    }

    public String getNoteValidUntilDate() {
        fluentWait(validUntil);
        return validUntil.getAttribute("value");
    }
}