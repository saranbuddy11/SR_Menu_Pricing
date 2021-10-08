package GM.gmObjectRepository;

import base.FunctionalLibrary;
import model.Market;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

public class LoginPage extends FunctionalLibrary {
    private static final Log logger = LogFactory.getLog(LoginPage.class);

    private static final String DEALERID_XPATH = "//input[@name='dealerId']";
    private static final String DEALERID_FIELD_XPATH = "//td[contains(text(),'Dealer ID')]";
    private static final String USERID_XPATH = "//input[@name='userId']";
    private static final String USERID_FIELD_XPATH = "//td[contains(text(),'User ID')]";
    private static final String PASSWORD_XPATH = "//input[@name='password']";
    private static final String PASSWORD_FIELD_XPATH = "//td[contains(text(),'Password')]";
    private static final String MARKET_XPATH = "//select[@name='marketCode']";
    private static final String MARKET_FIELD_XPATH = "//td[contains(text(),'Market')]";
    private static final String LOGIN_BTN_XPATH = "//input[@type='submit']";

//    @FindBy(xpath = DEALERID_XPATH)
//    private WebElement dealerIDInput;
//    @FindBy(xpath = DEALERID_FIELD_XPATH)
//    private WebElement dealerField;
//    @FindBy(xpath = USERID_XPATH)
//    private WebElement userIDInput;
//    @FindBy(xpath = USERID_FIELD_XPATH)
//    private WebElement userField;
//    @FindBy(xpath = PASSWORD_XPATH)
//    private WebElement passwordInput;
//    @FindBy(xpath = PASSWORD_FIELD_XPATH)
//    private WebElement passwordField;
//    @FindBy(xpath = MARKET_XPATH)
//    private WebElement marketSelector;
//    @FindBy(xpath = MARKET_FIELD_XPATH)
//    private WebElement marketField;
//    @FindBy(xpath = LOGIN_BTN_XPATH)
//    private WebElement loginBtn;
    @FindBy(xpath = "//div[@class='login-form-message']")
    private WebElement loginErrorMsgText;

//    public LoginPage(WebDriver driver) {
//        super(driver);
//    }

//    public GMLoginPage inputDealerID(String dealerID) {
//        logger.info(": method start");
//        dealerIDInput.clear();
//        dealerIDInput.sendKeys(dealerID);
//        return this;
//    }
//
//    public GMLoginPage inputUserID(String userID) {
//        logger.info(": method start");
//        userIDInput.clear();
//        userIDInput.sendKeys(userID);
//        return this;
//    }
//
//    public GMLoginPage inputPassword(String password) {
//        logger.info(": method start");
//        passwordInput.clear();
//        passwordInput.sendKeys(password);
//        return this;
//    }
//
//    public GMLoginPage selectMarket(Market market) {
//        logger.info(": method start");
//        Select marketDropdown = new Select(marketSelector);
//        marketDropdown.selectByVisibleText(market.getName());
//        return this;
//    }
//
//    public GMLoginPage loginBtn() {
//        logger.info(": method start");
//        loginBtn.click();
//        return this;
//    }
//
//    public String getUserName() {
//        logger.info(": method start");
//        fluentWait(userIDInput);
//        return userIDInput.getAttribute("value");
//    }
//
//    public String getPassword() {
//        logger.info(": method start");
//        fluentWait(passwordInput);
//        return passwordInput.getAttribute("value");
//    }
//
//    public String getLoginErrorMessage() {
//        logger.info(": method start");
//        return loginErrorMsgText.getText();
//    }

    public <T extends HomePage> T gmLogin(String dealerID, String userID, String password, Market market, Class<T> clazz) {
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

//    public boolean isDealerIDDisplayed() {
//        logger.info(": method start");
//        fluentWait(dealerField);
//        waitUntil(ExpectedConditions.visibilityOf(dealerField));
//        return dealerField.isDisplayed();
//    }
//
//    public boolean isUserIDDisplayed() {
//        logger.info(": method start");
//        fluentWait(userField);
//        waitUntil(ExpectedConditions.visibilityOf(userField));
//        return userField.isDisplayed();
//    }
//
//    public boolean isPasswordDisplayed() {
//        logger.info(": method start");
//        fluentWait(passwordField);
//        waitUntil(ExpectedConditions.visibilityOf(passwordField));
//        return passwordField.isDisplayed();
//    }
//
//    public boolean isMarketDisplayed() {
//        logger.info(": method start");
//        fluentWait(marketField);
//        waitUntil(ExpectedConditions.visibilityOf(marketField));
//        return marketField.isDisplayed();
//    }
//
//    public boolean isLoginBtnDisplayed() {
//        logger.info(": method start");
//        fluentWait(loginBtn);
//        waitUntil(ExpectedConditions.visibilityOf(loginBtn));
//        return loginBtn.isDisplayed();
//    }

    @FindBy(xpath = "//input[@name='dealerId']")
    private WebElement retailerCodeInput;
    @FindBy(xpath = "//td[contains(text(),'Retailer Code')]")
    private WebElement retailerField;
    @FindBy(xpath = "//input[@name='userId']")
    private WebElement userIDInput;
    @FindBy(xpath = "//td[contains(text(),'User ID')]")
    private WebElement userField;
    @FindBy(xpath = "//input[@name='password']")
    private WebElement passwordInput;
    @FindBy(xpath = "//td[contains(text(),'Password')]")
    private WebElement passwordField;
    @FindBy(xpath = "//select[@class='logon-select-180']")
    private WebElement marketSelector;
    @FindBy(xpath = "//td[contains(text(),'Market')]")
    private WebElement marketField;
    @FindBy(xpath = "//input[@type='submit']")
    private WebElement loginBtn;
//    @FindBy(xpath = "//div[@class='login-form-message']")
//    private WebElement loginErrorMsgText;
    @FindBy(xpath = "//input[@name='dealerId']")
    private WebElement dealerField;
    @FindBy(xpath = "//title[contains(text(),'Service Workbench PRO Pricing')]")
    private WebElement title;
    @FindBy(xpath = "//div[@class='main-tab']//span")
    private List<WebElement> headers;
    @FindBy(css = " table > tbody > tr:nth-child(6) > td.login-form-label")
    private WebElement passwordLabel;
    @FindBy(xpath = "//select[@class='logon-select-180']//option[@selected='selected']")
    private WebElement marketOptions;
    @FindBy(xpath = "//select[@name='marketCode']")
    private WebElement marketPlace;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage inputDealerID(String retailerCode) {
        waitInSec(5);
        sendKeys(retailerCodeInput, retailerCode);
        return this;
    }

    public LoginPage inputUserID(String userID) {
        sendKeys(userIDInput, userID);
        return this;
    }

    public LoginPage inputPassword(String password) {
        sendKeys(passwordInput, password);
        return this;
    }

    public LoginPage selectMarket(Market market) {
        Select marketDropdown = new Select(marketSelector);
        marketDropdown.selectByValue(market.getName());
        return this;
    }

    public LoginPage selectJLRMarket() {
        Select marketDropdown = new Select(marketSelector);
        marketDropdown.selectByValue(String.valueOf(Market.GB));
        return this;
    }

    public LoginPage loginBtn() {
        waitInSec(10);
        if (System.getProperty("environment").contains("jlrmenupricingonline")) {
            selectJLRMarket();
        }
        jsClickElement(loginBtn);
        return this;
    }

    public LoginPage spainMarketLoginBtn() {
        waitInSec(10);
        jsClickElement(loginBtn);
        return this;
    }

    public String getUserName() {
        return getAttribute(userIDInput);
    }

    public String getPassword() {
        return getAttribute(passwordInput);
    }

    public String getLoginErrorMessage() {
        return getText(loginErrorMsgText);
    }

    public String getLoginErrorMessages() {
        return getText(loginErrorMsgText);
    }

    public boolean isDealerIDDisplayed() {
        return elementIsDisplay(dealerField);
    }

    public boolean isMarketDisplayed() {
        return elementIsDisplay(marketField);
    }

    public boolean isLoginBtnDisplayed() {
        return elementIsDisplay(loginBtn);
    }

    public boolean isPasswordDisplayed() {
        return elementIsDisplay(passwordField);
    }

    public boolean isUserIDDisplayed() {
        return elementIsDisplay(userField);
    }

    public <T extends HomePage> T hydLogin(String dealerId, String userName, String password, Class<T> clazz) {
        T functionalLibrary = null;
        waitInSec(2);
        scrollToTheBottom();
        inputDealerID(dealerId)
                .inputUserID(userName)
                .inputPassword(password)
                .loginBtn();
        try {
            functionalLibrary = clazz.getDeclaredConstructor(WebDriver.class).newInstance(getDriver());
        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return functionalLibrary;
    }

    public <T extends HomePage> T gmLogin(String dealerId, String userName, String password, Class<T> clazz) {
        T functionalLibrary = null;
        waitInSec(2);
        scrollToTheBottom();
        inputDealerID(dealerId)
                .inputUserID(userName)
                .inputPassword(password)
                .loginBtn();
        try {
            functionalLibrary = clazz.getDeclaredConstructor(WebDriver.class).newInstance(getDriver());
        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return functionalLibrary;
    }

    public List<String> getLoginPageHeaders() {
        return getListOfContents(headers);
    }

    public boolean isTitleDisplayed() {
        return elementIsDisplay(title);
    }

    public boolean isCursorAt(String name) {
        return getNameAttributeWebElement(name).equals(driver.switchTo().activeElement());
    }

    public LoginPage copyATextAndPaste() {
        Actions act = new Actions(driver);
        act.moveToElement(passwordLabel).doubleClick().build().perform();
        Robot robot = null;
        try {
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_C);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyRelease(KeyEvent.VK_C);
            System.out.println("password text copy--");
            passwordInput.sendKeys(Keys.chord(Keys.CONTROL, "v"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this;
    }

    public <T extends HomePage> T jlrLogin(String dealerId, String userName, String password, Class<T> clazz) {
        T functionalLibrary = null;
        waitInSec(2);
        inputDealerID(dealerId)
                .inputUserID(userName)
                .inputPassword(password)
                .loginBtn();
        try {
            functionalLibrary = clazz.getDeclaredConstructor(WebDriver.class).newInstance(getDriver());
        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return functionalLibrary;
    }

    public String getSelectedMarket() {
        return marketOptions.getAttribute("value");
    }

    public <T extends HomePage> T Login(String dealerId, String userName, String password, Market market, Class<T> clazz) {
        T functionalLibrary = null;
        waitInSec(2);
        inputDealerID(dealerId)
                .inputUserID(userName)
                .inputPassword(password)
                .selectMarket(market)
                .spainMarketLoginBtn();
        try {
            functionalLibrary = clazz.getDeclaredConstructor(WebDriver.class).newInstance(getDriver());
        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return functionalLibrary;
    }
}
