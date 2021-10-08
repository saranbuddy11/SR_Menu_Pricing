package JLR.jlrObjectRepository;

import GM.gmObjectRepository.LoginPage;
import base.FunctionalLibrary;
import model.Market;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.lang.reflect.InvocationTargetException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class JLRLoginPage extends FunctionalLibrary {
    private static final Log logger = LogFactory.getLog(JLRLoginPage.class);

    private static final String RETAILERCODE_XPATH = "//input[@name='dealerId']";
    private static final String RETAILERCODE_FIELD_XPATH = "//td[contains(text(),'Retailer Code')]";
    private static final String USERID_XPATH = "//input[@name='userId']";
    private static final String USERID_FIELD_XPATH = "//td[contains(text(),'User ID')]";
    private static final String PASSWORD_XPATH = "//input[@name='password']";
    private static final String PASSWORD_FIELD_XPATH = "//td[contains(text(),'Password')]";
    private static final String MARKET_XPATH = "//select[@class='logon-select-180']";
    private static final String MARKET_FIELD_XPATH = "//td[contains(text(),'Market')]";
    private static final String LOGIN_BTN_XPATH = "//input[@type='submit']";
    private static final String ADVISE_MESSAGE_XPATH = "/html/body/table/tbody/tr/td/div/table[2]/tbody/tr[3]/td/div/form/table/tbody/tr[7]/td[2]";

    @FindBy(xpath = RETAILERCODE_XPATH)
    private WebElement retailerCodeInput;
    @FindBy(xpath = RETAILERCODE_FIELD_XPATH)
    private WebElement retailerField;
    @FindBy(xpath = USERID_XPATH)
    private WebElement userIDInput;
    @FindBy(xpath = USERID_FIELD_XPATH)
    private WebElement userField;
    @FindBy(xpath = PASSWORD_XPATH)
    private WebElement passwordInput;
    @FindBy(xpath = PASSWORD_FIELD_XPATH)
    private WebElement passwordField;
    @FindBy(xpath = MARKET_XPATH)
    private WebElement marketSelector;
    @FindBy(xpath = MARKET_FIELD_XPATH)
    private WebElement marketField;
    @FindBy(xpath = LOGIN_BTN_XPATH)
    private WebElement loginBtn;
    @FindBy(xpath = "//div[@class='login-form-message']")
    private WebElement loginErrorMsgText;
    @FindBy(xpath = ADVISE_MESSAGE_XPATH)
    private WebElement adviseMessage;
    @FindBy(xpath = "//select[@class='logon-select-180']//option")
    private List<WebElement> marketOptions;

    public JLRLoginPage(WebDriver driver) {
        super(driver);
    }

    public JLRLoginPage inputDealerID(String retailerCode) {
        logger.info(": method start");
        retailerCodeInput.clear();
        retailerCodeInput.sendKeys(retailerCode);
        return this;
    }

    public JLRLoginPage inputUserID(String userID) {
        logger.info(": method start");
        userIDInput.clear();
        userIDInput.sendKeys(userID);
        return this;
    }

    public JLRLoginPage inputPassword(String password) {
        logger.info(": method start");
        passwordInput.clear();
        passwordInput.sendKeys(password);
        return this;
    }

    public JLRLoginPage selectJLRMarket() {
        Select marketDropdown = new Select(marketSelector);
        marketDropdown.selectByValue(String.valueOf(Market.GB));
        return this;
    }

    public JLRLoginPage loginBtn() {
        logger.info(": method start");
        loginBtn.click();
        return this;
    }

    public String getUserName() {
        logger.info(": method start");
        fluentWait(userIDInput);
        return userIDInput.getAttribute("value");
    }

    public String getPassword() {
        logger.info(": method start");
        fluentWait(passwordInput);
        return passwordInput.getAttribute("value");
    }

    public String getLoginErrorMessage() {
        logger.info(": method start");
        return loginErrorMsgText.getText();
    }

    public <T extends JLRHomePage> T jlrLogin(String retailerCode, String userID, String password, Market market, Class<T> clazz) {
        logger.info(": method start");
        T functionalLibrary = null;

        scrollToTheBottom();
        inputDealerID(retailerCode)
                .inputUserID(userID)
                .inputPassword(password)
                .selectJLRMarket()
                .loginBtn();
        try {
            functionalLibrary = clazz.getDeclaredConstructor(WebDriver.class).newInstance(getDriver());
        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return functionalLibrary;
    }

    public boolean isDealerIDDisplayed() {
        logger.info(": method start");
        fluentWait(retailerField);
        waitUntil(ExpectedConditions.visibilityOf(retailerField));
        return retailerField.isDisplayed();
    }

    public boolean isUserIDDisplayed() {
        logger.info(": method start");
        fluentWait(userField);
        waitUntil(ExpectedConditions.visibilityOf(userField));
        return userField.isDisplayed();
    }

    public boolean isPasswordDisplayed() {
        logger.info(": method start");
        fluentWait(passwordField);
        waitUntil(ExpectedConditions.visibilityOf(passwordField));
        return passwordField.isDisplayed();
    }

    public boolean isMarketDisplayed() {
        logger.info(": method start");
        fluentWait(marketField);
        waitUntil(ExpectedConditions.visibilityOf(marketField));
        return marketField.isDisplayed();
    }

    public boolean isAdviseMessageDisplayed() {
        logger.info(": method start");
        waitInSec(5);
        fluentWait(adviseMessage);
        return adviseMessage.isDisplayed();
    }

    public boolean isLoginBtnDisplayed() {
        logger.info(": method start");
        fluentWait(loginBtn);
        waitUntil(ExpectedConditions.visibilityOf(loginBtn));
        return loginBtn.isDisplayed();
    }

}
