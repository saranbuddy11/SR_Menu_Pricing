package MOPAR.moparObjectRepository;

import base.FunctionalLibrary;
import model.Market;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.lang.reflect.InvocationTargetException;

public class MOPARLoginPage extends FunctionalLibrary {
    private static final Log logger = LogFactory.getLog(MOPARLoginPage.class);

    private static final String DEALERID_XPATH = "//input[@name='dealerId']";
    private static final String DEALERID_FIELD_XPATH = "/html/body/table/tbody/tr/td/div/table[2]/tbody/tr[3]/td/div/form/table/tbody/tr[4]/td[1]";
    private static final String USERID_XPATH = "//input[@name='userId']";
    private static final String USERID_FIELD_XPATH = "/html/body/table/tbody/tr/td/div/table[2]/tbody/tr[3]/td/div/form/table/tbody/tr[5]/td[1]";
    private static final String PASSWORD_XPATH = "//input[@name='password']";
    private static final String PASSWORD_FIELD_XPATH = "/html/body/table/tbody/tr/td/div/table[2]/tbody/tr[3]/td/div/form/table/tbody/tr[6]/td[1]";
    private static final String MARKET_XPATH = "//select[@class='logon-select-180']";
    private static final String MARKET_FIELD_XPATH = "/html/body/table/tbody/tr/td/div/table[2]/tbody/tr[3]/td/div/form/table/tbody/tr[8]/td[1]";
    private static final String LOGIN_BTN_XPATH = "//input[@type='submit']";
    private static final String ADVISE_MESSAGE_XPATH = "/html/body/table/tbody/tr/td/div/table[2]/tbody/tr[3]/td/div/form/table/tbody/tr[7]/td[2]";

    @FindBy(xpath = DEALERID_XPATH)
    private WebElement dealerIDInput;
    @FindBy(xpath = DEALERID_FIELD_XPATH)
    private WebElement dealerField;
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

    public MOPARLoginPage(WebDriver driver) {
        super(driver);
    }

    public MOPARLoginPage inputDealerID(String dealerID) {
        logger.info(": method start");
        dealerIDInput.clear();
        dealerIDInput.sendKeys(dealerID);
        return this;
    }

    public MOPARLoginPage inputUserID(String userID) {
        logger.info(": method start");
        userIDInput.clear();
        userIDInput.sendKeys(userID);
        return this;
    }

    public MOPARLoginPage inputPassword(String password) {
        logger.info(": method start");
        passwordInput.clear();
        passwordInput.sendKeys(password);
        return this;
    }

    public MOPARLoginPage selectMarket(Market market) {
        logger.info(": method start");
        Select marketDropdown = new Select(marketSelector);
        marketDropdown.selectByVisibleText(market.getName());
        return this;
    }

    public MOPARLoginPage loginBtn() {
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

    public <T extends MOPARLoginPage> T moparLogin(String dealerID, String userID, String password, Market market, Class<T> clazz) {
        logger.info(": method start");
        T functionalLibrary = null;

        scrollToTheBottom();
        inputDealerID(dealerID)
                .inputUserID(userID)
                .inputPassword(password)
                .selectMarket(market)
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
        waitInSec(5);
        fluentWait(dealerField);
        return dealerField.isDisplayed();
    }

    public boolean isUserIDDisplayed() {
        logger.info(": method start");
        waitInSec(5);
        fluentWait(userField);
        return userField.isDisplayed();
    }

    public boolean isPasswordDisplayed() {
        logger.info(": method start");
        waitInSec(5);
        fluentWait(passwordField);
        return passwordField.isDisplayed();
    }

    public boolean isMarketDisplayed() {
        logger.info(": method start");
        waitInSec(5);
        fluentWait(marketField);
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
        waitInSec(5);
        fluentWait(loginBtn);
        return loginBtn.isDisplayed();
    }

}
