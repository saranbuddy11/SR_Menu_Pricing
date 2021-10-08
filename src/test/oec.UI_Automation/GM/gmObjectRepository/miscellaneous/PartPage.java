package GM.gmObjectRepository.miscellaneous;

import base.FunctionalLibrary;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class PartPage extends FunctionalLibrary {

    private final String SEARCH_RESULT = "(//td[@class='value'])[%d]";

    @FindBy(xpath = "//input[@name='partQuantity']")
    private WebElement partQuantity;
    @FindBy(xpath = "//input[@name='partNumber']")
    private WebElement partNumber;
    @FindBy(xpath = "//input[@name='description']")
    private WebElement partDescription;
    @FindBy(xpath = "//tr[@class='search']")
    private WebElement search;
    @FindBy(xpath = "//input[@value='Back']")
    private WebElement backBtn;
    @FindBy(xpath = "//input[@name='criteria']")
    private WebElement searchCriteria;
    @FindBy(xpath = "//input[@name='submit']")
    private WebElement searchBtn;
    @FindBy(xpath = "(//img[contains(@src,'images/icon/add.gif')])[1]")
    private WebElement addIcon;
    @FindBy(xpath = "//input[@type='text']")
    private List<WebElement> partDetails;
    @FindBy(xpath = "//input[@type='radio'][2]")
    private WebElement partRadioBtn;

    public PartPage(WebDriver driver) {
        super(driver);
    }

    public PartPage enterPartQuantity(String quantity) {
        sendKeys(partQuantity, quantity);
        return this;
    }

    public PartPage enterPartNumber(String number) {
        sendKeys(partNumber, number);
        return this;
    }

    public PartPage enterPartDescription(String description) {
        sendKeys(partDescription, description);
        return this;
    }

    public boolean isSearchTitleDisplayed() {
        waitInSec(1);
        return elementIsDisplay(search);
    }

    public PartPage clickOnBackBtn() {
        click(backBtn);
        return this;
    }

    public PartPage enterSearchCriteriaID(String id) {
        sendKeys(searchCriteria, id);
        return this;
    }

    public PartPage clickOnPartSearchBtn() {
        click(searchBtn);
        return this;
    }

    public boolean isSearchResultDisplayed(int index) {
        return elementIsDisplay(driver.findElement(By.xpath(String.format(SEARCH_RESULT, index))));
    }

    public PartPage clickOnAddIcon() {
        click(addIcon);
        return this;
    }

    public List<String> getFilledInputElementsDisplayed() {
        return getListOfContents(partDetails);
    }

    public PartPage clickOnPartRadioBtn() {
        moveToElementAndForceClick(partRadioBtn);
        return this;
    }
}