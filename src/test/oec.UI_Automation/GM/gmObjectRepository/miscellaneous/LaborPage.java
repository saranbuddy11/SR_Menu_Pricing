package GM.gmObjectRepository.miscellaneous;

import base.FunctionalLibrary;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LaborPage extends FunctionalLibrary {

    @FindBy(xpath = "//input[@name='labour_units']")
    private WebElement labourUnit;

    public LaborPage(WebDriver driver) {
        super(driver);
    }

    public LaborPage enterLaborUnit(String unit) {
        sendKeys(labourUnit, unit);
        return this;
    }
}
