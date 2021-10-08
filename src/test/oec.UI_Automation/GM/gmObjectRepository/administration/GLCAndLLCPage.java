package GM.gmObjectRepository.administration;

import base.FunctionalLibrary;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Arrays;
import java.util.List;

public class GLCAndLLCPage extends FunctionalLibrary {

    @FindBy(xpath = "//a[contains(text(),'GLC/LLC')]")
    private WebElement GLCAndLLC;
    @FindBy(xpath = "//table[@class='home-form']//tbody/tr[@class='unselectedrow']")
    private List<WebElement> glcAndLLCTable2;
    @FindBy(xpath = "//table[2]//tbody/tr[@class='unselectedrow']//td[2]//input")
    private List<WebElement> descriptions;
    @FindBy(xpath = "//table[2]//tbody/tr[@class='unselectedrow']//td[3]//input")
    private List<WebElement> glcDatas;
    @FindBy(xpath = "//input[@name='lineIndexed[0].llc']")
    private WebElement llc1;
    @FindBy(xpath = "//table[2]//tbody/tr[@class='unselectedrow']//td//input[@type='text']")
    private List<WebElement> GLCAndLLCTable2Datas;


    public GLCAndLLCPage(WebDriver driver) {
        super(driver);
    }

    public GLCAndLLCPage openGLCAndLLCTab() {
        click(GLCAndLLC);
        return this;
    }

    public List<Boolean> isElementPopulateWithDataDisplayed() {
        return isElementsDisplayed(glcAndLLCTable2);
    }

    public List<List<String>> getGLCAndLLCData() {
        List<String> glcData = getListOfContentAttribute(glcDatas);
        List<String> description = getListOfContentAttribute(descriptions);
        List<List<String>> data = Arrays.asList(glcData, description);
        return data;
    }

    public GLCAndLLCPage inputLLC(String llc) {
        sendKeys(llc1, llc);
        return this;
    }

    public String getLLC() {
        return getAttribute(llc1);
    }

    public GLCAndLLCPage clickOnCheckBox(String name) {
        clickBasedOnName(name);
        return this;
    }

    public GLCAndLLCPage input(String name, String text) {
        sendKeysBasedOnName(name, text);
        return this;
    }

    public List<String> getDescriptionGLCAndLLCData() {
        List<String> data = getListOfContentAttribute(GLCAndLLCTable2Datas);
        return data;
    }

    public GLCAndLLCPage refreshSearchGLC(String name) {
        clearTextBoxOnName(name);
        clickOnSaveBtn();
        return this;
    }
}
