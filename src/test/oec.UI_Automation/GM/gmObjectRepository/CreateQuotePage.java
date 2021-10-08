package GM.gmObjectRepository;

import base.FunctionalLibrary;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.awt.*;
import java.awt.event.KeyEvent;

public class CreateQuotePage extends FunctionalLibrary {

    private static final String EXPAND_JOB_LIST_INNER_XPATH = "//div[@class='l1']//img";
    private static final String SAVE_BTN = "//input[@value='Save']";
    private static final String EXPAND_JOB_LIST_SUB_INNER_XPATH = "//div[@class='l2']//img";

    @FindBy(id = "theSearchButton")
    private WebElement searchBtn;
    @FindBy(xpath = "//img[@id='img_O1010']")
    private WebElement serviceMileExpand;
    @FindBy(id = "l_O10683")
    private WebElement twoYrsService;
    @FindBy(xpath = "(//td[@class='description'])[2]")
    private WebElement serviceDescription;
    @FindBy(xpath = "//*[@id='quote-detail']/div[1]/table/tbody/tr[1]/td[4]/a/img")
    private WebElement checkSheet;
    @FindBy(xpath = "//input[contains(@value,'Continue')]")////input[@value='Continue']
    private WebElement continueBtn;
    @FindBy(xpath = "//input[@name='distance']")
    private WebElement distanceInput;
    @FindBy(xpath = "//textarea[@name='notes']")
    private WebElement noteInput;
    @FindBy(xpath = SAVE_BTN)
    private WebElement saveBtn;
    @FindBy(xpath = "(//td[@class='status-content'])[6]")
    private WebElement quoteStatus;
    @FindBy(xpath = "(//td[@class='status-content'])[4]")
    private WebElement assignedQuoteNumber;
    @FindBy(xpath = "(//td[@class='status-content'])[6]")
    private WebElement estimateStatus;
    @FindBy(xpath = "(//span[contains(text(),'Estimate')])[2]")
    private WebElement estimateSpan;
    @FindBy(xpath = "//span[@id='mt2']")
    private WebElement createEstimateTab;
    @FindBy(xpath = "//img[@id='img_O647']")
    private WebElement cabinFilterExpand;
    @FindBy(xpath = "//img[@id='img_O1']")
    private WebElement servicingExpandToggle;
    @FindBy(xpath = "//div[@id='O647']")
    private WebElement removeAndReplace;
    @FindBy(xpath = "//img[@id='img_O42']")
    private WebElement mileageServicingExpandToggle;
    @FindBy(xpath = "//div[@id='l_O233129']")
    private WebElement jobWorkItem;
    @FindBy(xpath = "//div[@id='l_O16461']")
    private WebElement removeReplaceOriginalEquipment;
    @FindBy(xpath = "//img[@id='img_O634']")
    private WebElement clutchCompleteExpandToggle;
    @FindBy(xpath = "//td[contains(text(),'Clutch Complete Remove & Replace Original Equipment')]")
    private WebElement clutchCompleteRemoveAndReplaceOriginalEquipment;
    @FindBy(xpath = "//td[contains(text(),'Mileage Servicing 20,000 Mls / 30,000 KM')]")
    private WebElement mileageService;
    @FindBy(xpath = "//td[contains(text(),'Cabin Filter Remove & Replace')]")
    private WebElement cabinFilterRemoveAndReplace;
    //    @FindBy(xpath = "(//td[@class='status-content'])[1]")
    @FindBy(xpath = "(//td[@class='status-content'])[1]")
    private WebElement customerStatusContent;
    @FindBy(xpath = "(//td[@class='status-address'])[1]")
    private WebElement customerAddressContent;
    @FindBy(xpath = "(//td[@class='status-address'])[2]")
    private WebElement customerPostcodeContent;
    @FindBy(xpath = "(//span[contains(text(),'Quote')])[2]")
    private WebElement quoteSpan;

    public CreateQuotePage(WebDriver driver) {
        super(driver);
    }

    public CreateQuotePage clickOnSearchBtn() {
        click(searchBtn);
        return this;
    }

    public CreateQuotePage expandJobListInnerRow(int rowNumber) {
        waitInSec(10);
        expandRow(EXPAND_JOB_LIST_INNER_XPATH, rowNumber);
        return this;
    }

    public CreateQuotePage expandJobListSubInnerRow(int rowNumber) {
        waitInSec(10);
        expandRow(EXPAND_JOB_LIST_SUB_INNER_XPATH, rowNumber);
        return this;
    }

    public CreateQuotePage expandSubJobListInnerRow() {
        moveToElementClick(serviceMileExpand);
        return this;
    }

    public CreateQuotePage clickOnTwentyThousandMilesLeaf() {
        moveToElementClick(twoYrsService);
        return this;
    }


    public Boolean isServiceDescriptionDisplayed() {
        return elementIsDisplay(serviceDescription);
    }

    public CreateQuotePage clickOnCheckSheet() {
        moveToElementClick(checkSheet);
        return this;
    }

    public CreateQuotePage openPDFOfCheckSheet() {

        Robot robot = null;
        try {
            robot = new Robot();
            waitInSec(10);
            robot.keyPress(KeyEvent.VK_ALT);
            waitInSec(5);
            robot.keyPress(KeyEvent.VK_O);
            waitInSec(5);
            robot.keyRelease(KeyEvent.VK_ALT);
            waitInSec(5);
            robot.keyRelease(KeyEvent.VK_O);
            waitInSec(5);
        } catch (AWTException e) {
            e.printStackTrace();
        }
        return this;
    }

    public CreateQuotePage closePDFPopUp() {
        Robot robot = null;
        try {
            robot = new Robot();
            waitInSec(1);
            robot.keyPress(KeyEvent.VK_ALT);
            waitInSec(1);
            robot.keyPress(KeyEvent.VK_F4);
            waitInSec(1);
            robot.keyRelease(KeyEvent.VK_ALT);
            waitInSec(1);
            robot.keyRelease(KeyEvent.VK_F4);
        } catch (AWTException e) {
            e.printStackTrace();
        }
        return this;
    }

    public CreateQuotePage closePDF() {
        Robot robot = null;
        try {
            robot = new Robot();
            waitInSec(1);
            robot.keyPress(KeyEvent.VK_ALT);
            waitInSec(1);
            robot.keyPress(KeyEvent.VK_F4);
            waitInSec(1);
            robot.keyRelease(KeyEvent.VK_ALT);
            waitInSec(1);
            robot.keyRelease(KeyEvent.VK_F4);
        } catch (AWTException e) {
            e.printStackTrace();
        }
        return this;
    }

    public CreateQuotePage clickOnContinueBtn() {
        scrollToTheBottom();
        click(continueBtn);
        return this;
    }

    public CreateQuotePage inputDistance(String distance) {
        sendKeys(distanceInput, distance);
        return this;
    }

    public CreateQuotePage inputNotes(String text) {
        sendKeys(noteInput, text);
        return this;
    }

    public boolean isSaveBtnEnable() {
        return isElementEnabled(SAVE_BTN);
    }

    public String getStatus() {
        return getText(quoteStatus);
    }

    public String getAssignedQuoteNumber() {
        return getText(assignedQuoteNumber);
    }

    public Boolean isCheckSheetEnable() {
        return elementIsEnabled(checkSheet);
    }

    public boolean isEstimateSelected() {
        return elementIsEnabled(estimateSpan);
    }

    public CreateQuotePage createEstimateTab() {
        click(createEstimateTab);
        return this;
    }

    public CreateQuotePage cabinFilterExpand() {
        click(cabinFilterExpand);
        return this;
    }

    public CreateQuotePage servicingToggleExpand() {
        waitInSec(5);
        click(servicingExpandToggle);
        return this;
    }

    public CreateQuotePage removeAndReplace() {
        click(removeAndReplace);
        return this;
    }

    public CreateQuotePage mileageServicingToggleExpand() {
        click(mileageServicingExpandToggle);
        return this;
    }

    public CreateQuotePage jobWorkItemToggleExpand() {
        click(jobWorkItem);
        return this;
    }

    public CreateQuotePage clickOnRemoveAndReplaceOriginalEquipment() {
        waitInSec(2);
        moveToElementClick(removeReplaceOriginalEquipment);
        return this;
    }

    public CreateQuotePage clutchCompleteToggleExpand() {
        click(clutchCompleteExpandToggle);
        return this;
    }

    public boolean isJobWorkItemIsCreatedQuote() {
        waitInSec(5);
        return elementIsDisplay(clutchCompleteRemoveAndReplaceOriginalEquipment);
    }

    public boolean isJobWorkItemIsCreatedQuoteOPEL() {
        waitInSec(5);
        return elementIsDisplay(mileageService);
    }

    public boolean isJobWorkItemIsCreatedQuoteInGM() {
        waitInSec(1);
        return elementIsDisplay(cabinFilterRemoveAndReplace);
    }

    public Boolean isCustomerStatusContent() {
        return elementIsDisplay(customerStatusContent);
    }

    public Boolean isCustomerAddressContent() {
        return elementIsDisplay(customerAddressContent);
    }

    public Boolean isCustomerPostCodeContent() {
        return elementIsDisplay(customerPostcodeContent);
    }

    public boolean isQuoteSelected() {
        return elementIsEnabled(quoteSpan);
    }
}
