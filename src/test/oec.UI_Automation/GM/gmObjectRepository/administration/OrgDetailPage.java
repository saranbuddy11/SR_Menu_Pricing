package GM.gmObjectRepository.administration;

import base.FunctionalLibrary;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrgDetailPage extends FunctionalLibrary {

    private static final String INPUT = "//input[@name='%s']";
    private static final String ADDRESS = "//textarea[@name='%s']";
    private static final String OUTPUT = "//input[@name='%s']";
    private static final String ADDRESS_OUTPUT = "//textarea[@name='%s']";

    @FindBy(xpath = "//input[@id='signOffSettings']")
    private WebElement signOffSettingsCheckBox;

    public OrgDetailPage(WebDriver driver) {
        super(driver);
    }

    public OrgDetailPage enterOrgDetailInput(String name, String text) {
        sendKeys((driver.findElement(By.xpath(String.format(INPUT, name)))), text);
        return this;
    }

    public OrgDetailPage enterOrgDetailAddress(String name, String text) {
        sendKeys((driver.findElement(By.xpath(String.format(ADDRESS, name)))), text);
        return this;
    }

    public String getOrgDetails(String element) {
        return getAttributeByString(element, OUTPUT);
    }

    public String getOrgAddressDetails(String element) {
        return getAttributeByString(element, ADDRESS_OUTPUT);
    }

    public OrgDetailPage clickOnSignOffSettingsCheckBox() {
        click(signOffSettingsCheckBox);
        return this;
    }

    public String getPopUpWarnMsg() {
        return driver.switchTo().alert().getText().trim();
    }
}
