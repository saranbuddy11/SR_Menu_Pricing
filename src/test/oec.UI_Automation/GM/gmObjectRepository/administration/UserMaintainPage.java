package GM.gmObjectRepository.administration;

import base.FunctionalLibrary;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserMaintainPage extends FunctionalLibrary {

    private static final String ENABLE_STATUS_BTN = "//input[@value='%s']";

    @FindBy(xpath = "//td[contains(text(),'TestAutomationUser')]")
    private WebElement testAutomationUserID;
    @FindBy(xpath = "//input[@value='Edit']")
    private WebElement editBtn;
    @FindBy(xpath = "//input[@name='passwordAssign']")
    private WebElement passwordAssign;
    @FindBy(xpath = "//input[@name='passwordConfirm']")
    private WebElement passwordConfirm;
    @FindBy(xpath = "//p[@id='dialog-alert-content']//ol")
    private WebElement errorMsg;
    @FindBy(xpath = "//input[@value='Disable']")
    private WebElement disableBtn;
    @FindBy(xpath = "//input[@name='hideDisabledUsers']")
    private WebElement hideDisableUsersCheckbox;
    @FindBy(xpath = "//td[contains(text(),'TestAutomationUser')]//following-sibling::td[5]")
    private WebElement activeStatus;

    public UserMaintainPage(WebDriver driver) {
        super(driver);
    }

    public UserMaintainPage clickOnNewUser() {
        fluentWait(testAutomationUserID);
        testAutomationUserID.click();
        editBtn.click();
        return this;
    }

    public UserMaintainPage enterPassword(String password) {
        enterAssignPassword(password);
        enterConfirmPassword(password);
        return this;
    }

    public UserMaintainPage enterAssignPassword(String password) {
        fluentWait(passwordAssign);
        sendKeys(passwordAssign, password);
        return this;
    }

    public UserMaintainPage enterConfirmPassword(String password) {
        fluentWait(passwordConfirm);
        sendKeys(passwordConfirm, password);
        return this;
    }

    public String getErrorMSg() {
        fluentWait(errorMsg);
        return errorMsg.getText();
    }

    public UserMaintainPage clickOnBtn(String status) {
        WebElement element = driver.findElement(By.xpath(String.format(ENABLE_STATUS_BTN, status)));
        element.click();
        return this;
    }

    public UserMaintainPage clickOnNewUserTestUser() {
        fluentWait(testAutomationUserID);
        testAutomationUserID.click();
        return this;
    }

    public UserMaintainPage checkOnHideDisabledUsers() {
        fluentWait(hideDisableUsersCheckbox);
        if (hideDisableUsersCheckbox.isSelected()) {
            hideDisableUsersCheckbox.click();
        }
        return this;
    }

    public String getStatusOfUser() {
        fluentWait(activeStatus);
        return activeStatus.getText();
    }
}