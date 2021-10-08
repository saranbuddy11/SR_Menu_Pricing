package base;

import GM.gmObjectRepository.HomePage;
import GM.gmObjectRepository.LoginPage;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.openqa.selenium.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.*;
import utilsBrowser.browserSetting.JavaScriptLogger;
import utilsBrowser.browserSetting.Utils;
import utilsBrowser.configuration.Configuration;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.List;

import static java.time.Duration.ofSeconds;
import static stepDefinitions.AbstractTest.jslogging;

public class FunctionalLibrary implements SeleniumUtils {

    private static final Log logger = LogFactory.getLog(FunctionalLibrary.class);
    protected Excel excel = new Excel();
    private static final int WAIT_UNTIL_TIMEOUT = 25;
    private static final int ANGULAR_WAIT = (System.getProperty("environment").contains("online")) ? 40 : 30;
    private static final String BASE_URL = "";
    private static final String TEXT_COLOR_XPATH = "//span[contains(text(),'%s')]";
    public static final String ORANGE_COLOR_HEX_CODE = "#fea500";
    public static final String RED_COLOR_HEX_CODE = "#ff0000";
    public static final String BLACK_COLOR_HEX_CODE = "#ffffff";
    public static DecimalFormat df = new DecimalFormat("0.00");
    private static final String InputXpath = "//input[@name='%s']";
    private static final String InputTextAreaXpath = "//textarea[@name='%s']";
    public static String defaultcusName = "";
    public static String nextQuotenumber = "0";
    public static String quotesuffix = "0";
    public static String quoteprefix = "0";
    public static String pdfcontent = "";
    public static String address = "";
    public static String postalcode = "";
    public static String fluidoptionalprice = "";
    public static String priceextax = "";
    public static String price = "";
    public static String partprice = "";

    public WebDriver driver;
    protected Actions action;
    protected FunctionalLibrary functionalLibrary;
    protected LoginPage loginPage;
    public JavascriptExecutor jsExecutor;

    @FindBy(xpath = "//input[@value='Save']")
    private WebElement saveBtn;
    @FindBy(xpath = "//div[contains(text(),'Add')]")
    private WebElement addBtn;
    @FindBy(xpath = "//div[contains(text(),'Search')]")
    private WebElement searchBtn;
    @FindBy(xpath = "//input[@value='Upload']")
    private WebElement uploadBtn;

    public FunctionalLibrary(WebDriver driver) {
        action = new Actions(driver);
        PageFactory.initElements(getElementLocatorFactory(driver), this);
        if (jslogging) {
            JavaScriptLogger.extractJSLogs(driver);
        }
    }

    public WebDriver getDriver() {
        return driver;
    }

    private WebDriver getElementLocatorFactory(WebDriver driver) {
        this.driver = driver;
        this.jsExecutor = (JavascriptExecutor) driver;
        return driver;
    }

    @Override
    public void clickRadioBtn(String locator, boolean state) {
        logger.info("Click radio button with specified option.");
        WebElement e = driver.findElement(getByForLocator(locator));
        e.click();
        waitUntilAngularFinishHttpCalls();
    }

    @Override
    public void clickRadioBtn(WebElement e, boolean state) {
        logger.info("Click radio button with specified option.");
        e.click();
        waitUntilAngularFinishHttpCalls();
    }

    @Override
    public By getByForLocator(String locator) {
        logger.info(": Getting By based on locator provider.");
        return (locator.startsWith("//") ? By.xpath(locator) : By.cssSelector(locator));
    }

    @Override
    public boolean clickCheckbox(String locator, boolean state) {
        logger.info("Click checkbox with specified option.");
        WebElement e = driver.findElement(getByForLocator(locator));
        if (!(e.isSelected() == state)) {
            e.click();
            waitUntilAngularFinishHttpCalls();
        }
        return false;
    }

    @Override
    public void waitUntil(ExpectedCondition<?> expectedCondition, int timeoutSeconds) {
        logger.info(": waiting " + timeoutSeconds + " s until : " + expectedCondition);
        new WebDriverWait(driver, timeoutSeconds).until(expectedCondition);
    }

    @Override
    public void waitUntil(ExpectedCondition<?> expectedCondition) {
        logger.info(": waiting " + WAIT_UNTIL_TIMEOUT + " s until expected condition " + expectedCondition + " is met.");
        waitUntil(expectedCondition, WAIT_UNTIL_TIMEOUT);
    }

    @Override
    public void waitUntilWithAngularCalls(ExpectedCondition<?> expectedCondition) {
        logger.info(": waiting until angular calls are finished and expected condition: " + expectedCondition + " is met.");
        waitUntil(expectedCondition);
        waitUntilAngularFinishHttpCalls();
    }

    @Override
    public WebElement fluentWait(WebElement element) {
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(ofSeconds(30))
                .pollingEvery(ofSeconds(1))
                .ignoring(NoSuchElementException.class);

        return wait.until(driver1 -> {
            logger.info(": waiting for element " + element
                    + " with locator : \" + locator + \" with timeout 30s polling every 1 s.");
            return element;
        });
    }

    @Override
    public void waitInSec(Integer sec) {
        logger.info(": waiting for " + sec + " with thread sleep for 1 sec");
        long milisec = sec.longValue() * 1000;
        try {
            Thread.sleep(milisec);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void moveToElementAndForceClick(WebElement element) {
        logger.info(": move to element actions");
        action.moveToElement(element).click().build().perform();
    }

    @Override
    public void doubleClick(WebElement element) {
        logger.info(": move to element actions");
        action.doubleClick(element).build().perform();
    }

    @Override
    public void scrollIntoView(WebElement element) {
        logger.info(": scroll to element using java script executor");
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    @Override
    public void scrollToTheBottom() {
        logger.info(": scroll to the bottom of the screen using java script executor");
        jsExecutor.executeScript("window.scrollBy(0,+500)", "");
    }

    @Override
    public void scrollToTheTop() {
        logger.info(": scroll to the top of the screen using java script executor");
        jsExecutor.executeScript("window.scrollBy(0,-500)", "");
    }

    @Override
    public void waitUntilAngularFinishHttpCalls() {
        waitUntilAngularFinishHttpCalls(ANGULAR_WAIT);
    }

    @Override
    public void waitUntilAngularFinishHttpCalls(long timeout) {
        logger.info(": waiting until angular calls finishes with timeout " + timeout);
        final String javaScriptToLoadAngular =
                "var injector = window.angular.element('body').injector();" +
                        "var $http = injector.get('$http');" +
                        "return ($http.pendingRequests.length === 0)";

        ExpectedCondition<Boolean> pendingHttpCallsCondition = driver -> jsExecutor
                .executeScript(javaScriptToLoadAngular).equals(true);
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(pendingHttpCallsCondition);
    }

    @Override
    public void waitAndClick(WebElement el) {
        waitAndClickWithoutAngular(el);
        waitUntilAngularFinishHttpCalls();
    }

    @Override
    public void waitAndClickWithoutAngular(WebElement el) {
        logger.info(": waiting until non angular calls are made and element is clickable");
        try {
            WebDriverWait wait = new WebDriverWait(driver, WAIT_UNTIL_TIMEOUT, 500);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("loader")));
            wait.until(ExpectedConditions.elementToBeClickable(el)).click();
        } catch (WebDriverException wde) {
            scrollIntoView(el);
            el.click();
        }
    }

    @Override
    public <T extends FunctionalLibrary> T goToPreviousPage(Class<T> clazz) throws RuntimeException {
        logger.info(": go to previous page");
        waitInSec(2);
        driver.navigate().back();
        T page = null;
        try {
            page = clazz.getDeclaredConstructor(WebDriver.class).newInstance(driver);
        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return page;
    }

    @Override
    public FunctionalLibrary switchToBrowserTab(int windowNumber) {
        logger.info(": switch to tab number: " + windowNumber);
        waitInSec(3);
        List<String> windowHandles = new ArrayList<>(driver.getWindowHandles());
        if (windowHandles.size() > 1) {
            List<String> windowHandlesTemp;
            int i = 0;
            do {
                i++;
                windowHandlesTemp = new ArrayList<>(driver.getWindowHandles());
            } while (windowHandlesTemp.size() < windowNumber && i < 10);

            switchToWindow(windowHandlesTemp.get(windowNumber - 1));
        }
        return this;
    }

    @Override
    public void switchToWindow(String handle) {
        logger.info(": switch to window with handle: " + handle);
        try {
            driver.switchTo().window(handle);
        } catch (NoSuchWindowException e) {
            waitInSec(5);
            logger.info("Attempt to switch to window...");
            driver.switchTo().window(handle);
        }
    }

    @Override
    public void refresh() {
        logger.info("Refresh page");
        driver.navigate().refresh();
    }

    @Override
    public FunctionalLibrary switchToTab(int windowNumber) {
        waitInSec(5);
        List<String> windowHandles;
        int i = 0;
        do {
            i++;
            windowHandles = new ArrayList<>(driver.getWindowHandles());
        } while (windowHandles.size() < windowNumber && i < 10);

        switchToWindow(windowHandles.get(windowNumber - 1));

        return this;
    }


    @Override
    public boolean isAt(String pageUrl) {
        logger.info(": method start");
        String actualUrl = getPageUrl();
        logger.info("Page Class: expected base url: " + pageUrl);
        logger.info("Page Class: actual url: " + actualUrl);
        return actualUrl.contains(pageUrl);
    }

    @Override
    public String getPageUrl() {
        logger.info(": Getting current URL.");
        waitInSec(3);
        return driver.getCurrentUrl();
    }

    @Override
    public String getBaseURL() {
        logger.info(": method start");
        return BASE_URL;
    }

    public <G extends FunctionalLibrary, T extends AbstractAssertion<G>> T startAssertions(Class<T> clazz) throws RuntimeException {
        try {
            AbstractAssertion<G> assertion = clazz.newInstance();
            assertion.setPage((G) this);
            return (T) assertion;
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException("Error occurred during creating Assertions. ", e);
        }
    }

    @Override
    public <T extends FunctionalLibrary> void acceptAlertIfPresent(Class<T> clazz) throws RuntimeException {
        try {
            Alert alert = driver.switchTo().alert();
            alert.accept();
        } catch (Exception e) {
            driver.switchTo().defaultContent();
        }
        T functionalLibrary = null;
        try {
            functionalLibrary = clazz.getDeclaredConstructor(WebDriver.class).newInstance(driver);
        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @Override
    public <T extends FunctionalLibrary> void dismissAlertIfPresent(Class<T> clazz) throws RuntimeException {
        try {
            waitInSec(2);
            Alert alert = driver.switchTo().alert();
            alert.dismiss();
        } catch (Exception e) {
            driver.switchTo().defaultContent();
        }
        T functionalLibrary = null;
        try {
            functionalLibrary = clazz.getDeclaredConstructor(WebDriver.class).newInstance(driver);
        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public <T extends HomePage> T hydLogIn(String environment, Configuration configuration, Class<T> clazz) {
        LoginPage loginPage = new LoginPage(driver);
        T functionLibrary = null;
        waitInSec(2);
        if (environment.contains("online")) {
            functionLibrary = loginPage.hydLogin(configuration.getDealerId(), configuration.getUserId(), configuration.getPassword(), clazz);
        }

        try {
            functionLibrary = clazz.getDeclaredConstructor(WebDriver.class).newInstance(driver);
        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return functionLibrary;
    }

    public <T extends HomePage> T gmLogIn(String environment, Configuration configuration, Class<T> clazz) {
        System.out.print(getPageUrl());
        LoginPage loginPage = new LoginPage(driver);
        T functionLibrary = null;
        waitInSec(2);
        if (environment.contains("online")) {
            functionLibrary = loginPage.gmLogin(configuration.getDealerId(), configuration.getUserId(), configuration.getPassword(), clazz);
        }

        try {
            functionLibrary = clazz.getDeclaredConstructor(WebDriver.class).newInstance(driver);
        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return functionLibrary;
    }

    public <T extends HomePage> T jlrLogIn(String environment, Configuration configuration, Class<T> clazz) {
        System.out.print(getPageUrl());
        LoginPage loginPage = new LoginPage(driver);
        T functionLibrary = null;
        waitInSec(2);
        if (environment.contains("online")) {
            functionLibrary = loginPage.jlrLogin(configuration.getDealerId(), configuration.getUserId(), configuration.getPassword(), clazz);
        }

        try {
            functionLibrary = clazz.getDeclaredConstructor(WebDriver.class).newInstance(driver);
        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return functionLibrary;
    }

    public <T extends HomePage> T logIn(String environment, Configuration configuration, String user, Class<T> clazz) {
        System.out.print(getPageUrl());
        LoginPage loginPage = new LoginPage(driver);
        T functionLibrary = null;
        waitInSec(2);
        if (user.contains("Dealer")) {
            functionLibrary = loginPage.gmLogin(configuration.getDealerId(), configuration.getUserId(), configuration.getPassword(), clazz);
        }        else if(user.contains("Sales")) {
            functionLibrary = loginPage.gmLogin(configuration.getDealerId(), configuration.getSalesUserId(), configuration.getPassword(), clazz);
        }
        else if(user.contains("Admin")) {
            functionLibrary = loginPage.gmLogin(configuration.getDealerId(), configuration.getSalesUserId(), configuration.getPassword(), clazz);
        }
        else if(user.contains("salesPerson")&&user.contains("NonUK")) {
            functionLibrary = loginPage.Login(configuration.getNonUKRetailCode(), configuration.getNonUKSalesUSerId(), configuration.getNonUKSalesPassword(), configuration.getNonUKMarket(), clazz);
        }
        else if(user.contains("admin")&&user.contains("NonUK")) {
            functionLibrary = loginPage.Login(configuration.getNonUKRetailCode(), configuration.getNonUKAdminUSerId(), configuration.getNonUKAdminPassword(), configuration.getNonUKMarket(), clazz);
        }
        else if(user.contains("singleBranded")) {
            functionLibrary = loginPage.gmLogin(configuration.getSingleBrandedDealerID(), configuration.getSingleBrandedUserID(), configuration.getSingleBrandedDealerPassword(), clazz);
        }
        else if(user.contains("MenuManager")) {
            functionLibrary = loginPage.gmLogin(configuration.getMMDealerID(), configuration.getMMUserID(), configuration.getMMDealerPassword(), clazz);
        }

        try {
            functionLibrary = clazz.getDeclaredConstructor(WebDriver.class).newInstance(driver);
        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return functionLibrary;
    }


    @Override
    public WebElement fluentWaits(By locator) {
        WebElement foo;
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(ofSeconds(30))
                .pollingEvery(ofSeconds(1))
                .ignoring(NoSuchElementException.class);

        foo = wait.until(driver -> {
            logger.info(": waiting for element with locator : " + locator + " with timeout 30s polling every 1 s.");
            return driver.findElement(locator);
        });
        return foo;
    }

    @Override
    public WebElement fluentWait(By by) {
        logger.info(": waiting for element with locator is available.");
        return fluentWaits(by);
    }

    @Override
    public List<WebElement> getElementsByLocator(String locator) {
        logger.info(": Getting list of web elements base on locator.");
        waitInSec(2);
        By by = getByForLocator(locator);
        fluentWait(by);
        return driver.findElements(by);
    }

    public boolean isElementEnabled(final String locator) {
        By by = getByForLocator(locator);
        return driver.findElement(by).isEnabled();
    }

    @Override
    public WebElement fluentWaitByLocator(String locator) {
        logger.info(": waiting for element with locator " + locator + " is available.");
        return fluentWait(getByForLocator(locator));
    }

    public static String getCurrentDate() {
        Date date = Calendar.getInstance().getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        return sdf.format(date);
    }

    public static String getCurrentDateSystemFormat() {
        Date date = Calendar.getInstance().getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.format(date);
    }

    public static String getCurrentDay() {
        Date date = Calendar.getInstance().getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("dd");
        return sdf.format(date);
    }

    public static String getFutureDay(int futureDays) {
        int selectedDate = 0;
        int selectedMonth = 0;
        Date date = Calendar.getInstance().getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("dd");
        int days = Integer.parseInt(sdf.format(date));
        SimpleDateFormat sdfm = new SimpleDateFormat("MM");
        int month = Integer.parseInt(sdfm.format(date));
        if (days == 30 || days == 31) {
            selectedDate = futureDays;
            if (month == 12) {
                selectedMonth = 1;
            } else if (month < 12) {
                selectedMonth = month + 1;
            }
        } else if (days < 28) {
            selectedDate = futureDays + days;
            selectedMonth = month;
        } else {
           return LocalDate.now().plusDays(futureDays).format(DateTimeFormatter.ofPattern("MM/dd/YYYY"));
        }
        Date datem = Calendar.getInstance().getTime();
        Date datey = Calendar.getInstance().getTime();
        SimpleDateFormat sdfy = new SimpleDateFormat("YYYY");
        String year = sdfy.format(date);
        String futureDate = selectedMonth + "/" + selectedDate + "/" + year; //month
        logger.info("future date-------" + futureDate);
        return futureDate;
    }

    @Override
    public String getTextColor(WebElement element) {
        String rgbFormat = element.getCssValue("color");
        String hexColor = Color.fromString(rgbFormat).asHex();
        return hexColor;
    }

    public String getColor(String text) {
        waitInSec(2);
        return getTextColor(driver.findElement(By.xpath(String.format(TEXT_COLOR_XPATH, text))));
    }

    public FunctionalLibrary clickOnSaveBtn() {
        scrollToTheBottom();
        waitInSec(2);
        click(saveBtn);
        return this;
    }

    public FunctionalLibrary clickOnAddBtn() {
        scrollToTheBottom();
        click(addBtn);
        return this;
    }

    public FunctionalLibrary clickOnSearchBtn() {
        scrollToTheBottom();
        jsClickElement(searchBtn);
        return this;
    }

    @Override
    public FunctionalLibrary sendKeys(WebElement element, String text) {
        fluentWait(element);
        element.clear();
        element.sendKeys(text);
        return this;
    }


    @Override
    public FunctionalLibrary sendKeysDouble(WebElement element, Double value) {
        element.sendKeys(String.valueOf(value));
        return this;
    }

    @Override
    public FunctionalLibrary click(WebElement element) {
        fluentWait(element);
        element.click();
        return this;
    }

    public boolean elementIsDisplay(WebElement element) {
        fluentWait(element);
        waitInSec(5);
        return element.isDisplayed();
    }

    @Override
    public String getAttribute(WebElement element) {
        fluentWait(element);
        return element.getAttribute("value");
    }

    @Override
    public String getAttributeByString(String element, String xpath) {
        WebElement value1 = driver.findElement(By.xpath(String.format(xpath, element)));
        fluentWait(value1);
        return value1.getAttribute("value");
    }

    @Override
    public String getText(WebElement element) {
        fluentWait(element);
        return element.getText();
    }

    @Override
    public String getTextBasedOnIndex(String element, int index) {
        waitInSec(1);
        return getText(driver.findElement(By.xpath(String.format(element, index))));
    }

    public String getTextBasedOnDoubleIndex(String element, int index1, int index2) {
        return getText(driver.findElement(By.xpath(String.format(element, index1, index2))));
    }

    @Override
    public FunctionalLibrary expandRow(String locator, int rowNumber) {
        waitInSec(2);
        getElementsByLocator(locator).get(rowNumber - 1).click();
        return this;
    }

    @Override
    public FunctionalLibrary moveToElementClick(WebElement element) {
        waitInSec(2);
        action.moveToElement(element).click().build().perform();
        return this;
    }

    @Override
    public boolean elementIsEnabled(WebElement element) {
        fluentWait(element);
        waitUntil(ExpectedConditions.visibilityOf(element));
        return element.isEnabled();
    }

    @Override
    public FunctionalLibrary jsClickElement(WebElement element) {
        logger.info(": click element using js executor");
        jsExecutor.executeScript("arguments[0].click();", element);
        return this;
    }

    @Override
    public FunctionalLibrary jsSendKeys(WebElement element, Double value) {
        logger.info(": set the text using js executor");
        String text = String.valueOf(value);
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].value=" + text, element);
        return this;
    }

    @Override
    public FunctionalLibrary jsSendKeysText(WebElement element, String text) {
        logger.info(": sending keys for field with JavascriptExecutor " + element + " is available.");
        waitInSec(2);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].value='" + text + "';", element);
        return this;
    }

    @Override
    public List<String> getListOfContents(List<WebElement> elements) {
        List<String> contents = new ArrayList<>();
        waitInSec(2);
        for (WebElement element : elements) {
            contents.add(element.getText().trim());
        }
        return contents;
    }

    public List<String> getListOfContentsByString(String elements) {
        List<String> contents = new ArrayList<>();
        waitInSec(2);
        By by = By.xpath(elements);
        List<WebElement> webElements = driver.findElements(by);
        for (int i = 0; i < webElements.size(); i++) {
            if (webElements.get(i).getText().equals(" ")) {
                continue;
            } else {
                contents.add(webElements.get(i).getText().trim());
            }
        }
        return contents;
    }

    @Override
    public List<String> getListOfContentAttribute(List<WebElement> elements) {
        List<String> contents = new ArrayList<>();
        waitInSec(2);
        for (WebElement element : elements) {
            contents.add(element.getAttribute("value"));
        }
        return contents;
    }

    public FunctionalLibrary clearAllList(List<WebElement> elements) {
        waitInSec(2);
        for (WebElement element : elements) {
            element.clear();
        }
        return this;
    }

    @Override
    public List<Boolean> isElementsDisplayed(List<WebElement> elements) {
        List<Boolean> contents = new ArrayList<>();
        waitInSec(2);
        for (WebElement element : elements) {
            contents.add(element.isDisplayed());
        }
        return contents;
    }

    @Override
    public List<Boolean> isElementsEnabled(List<WebElement> elements) {
        List<Boolean> contents = new ArrayList<>();
        waitInSec(2);
        for (WebElement element : elements) {
            contents.add(element.isEnabled());
        }
        return contents;
    }

    public String getPopUpText() {
        waitInSec(2);
        return driver.switchTo().alert().getText();
    }

    @Override
    public FunctionalLibrary clickBasedOnIndex(String element, int index) {
        waitInSec(2);
        return jsClickElement(driver.findElement(By.xpath(String.format(element, index))));
    }

    @Override
    public FunctionalLibrary clickBasedOnName(String name) {
        waitInSec(2);
        return click(driver.findElement(By.xpath(String.format(InputXpath, name))));
    }

    public FunctionalLibrary clickBasedOnElementAndText(String element, String name) {
        waitInSec(2);
        return click(driver.findElement(By.xpath(String.format(element, name))));
    }

    @Override
    public FunctionalLibrary sendKeysBasedOnName(String name, String text) {
        waitInSec(2);
        WebElement element = driver.findElement(By.xpath(String.format(InputXpath, name)));
        element.clear();
        element.sendKeys(text);
        return this;
    }

    public FunctionalLibrary sendKeysForTextAreaBasedOnName(String name, String text) {
        waitInSec(2);
        WebElement element = driver.findElement(By.xpath(String.format(InputTextAreaXpath, name)));
        element.clear();
        element.sendKeys(text);
        return this;
    }

    public WebElement getNameAttributeWebElement(String name) {
        waitInSec(2);
        WebElement element = driver.findElement(By.xpath(String.format(InputXpath, name)));
        return element;
    }

    public FunctionalLibrary clearTextBoxOnName(String name) {
        waitInSec(2);
        WebElement element = driver.findElement(By.xpath(String.format(InputXpath, name)));
        element.clear();
        return this;
    }

    @Override
    public int getSize(List<WebElement> element) {
        waitInSec(1);
        return element.size();
    }

    @Override
    public FunctionalLibrary sendKeysNumber(WebElement element, int text) {
        element.clear();
        element.sendKeys(String.valueOf(text));
        return this;
    }

    @Override
    public Boolean isElementDisplayedBasedOnIndex(String element, int index) {
        return elementIsDisplay(driver.findElement(By.xpath(String.format(element, index))));
    }

    @Override
    public Boolean isElementEnabledBasedOnIndex(String element, int index) {
        return elementIsEnabled(driver.findElement(By.xpath(String.format(element, index))));
    }

    public String getFutureDateBasedOnDate(int futureDays) {
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");

        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, futureDays);
        Date currentDate = cal.getTime();
        return dateFormat.format(currentDate);
    }

    public FunctionalLibrary chooseFile(WebElement element, String path) {
        fluentWait(element);
        element.sendKeys(path);
        return this;
    }

    public String getAbsolutePath(String path) {
        File file = new File("src/test/resources/config/GM/TestData/CSVUploadData/" + path);
        return file.getAbsolutePath();
    }

    public FunctionalLibrary clickOnUploadBtn() {
        waitInSec(2);
        return click(uploadBtn);
    }

    @Override
    public boolean isFileDownloaded(String fileName) {
        File dir = new File(Utils.PATH_TO_DOWNLOAD);
        File[] dirContents = dir.listFiles();
        waitInSec(10);

        for (int i = 0; i < dirContents.length; i++) {
            if (dirContents[i].getName().equals(fileName)) {
                return true;
            }
        }
        return false;
    }

    public FunctionalLibrary openFileDownloaded(String fileName) {
        File dir = new File(Utils.PATH_TO_DOWNLOAD);
        File[] dirContents = dir.listFiles();

        for (int i = 0; i < dirContents.length; i++) {
            if (dirContents[i].getName().equals(fileName)) {
                dirContents[0].getAbsoluteFile();
            }
        }
        return this;
    }

    public FunctionalLibrary clickBasedOnDoubleIndex(String element, int index1, int index2) {
        waitInSec(2);
        return jsClickElement(driver.findElement(By.xpath(String.format(element, index1, index2))));
    }

    public FunctionalLibrary enterTABBtn() {
        Robot robot = null;
        try {
            robot = new Robot();
            waitInSec(2);
            robot.keyPress(KeyEvent.VK_TAB);
            waitInSec(2);
            robot.keyRelease(KeyEvent.VK_TAB);
        } catch (AWTException e) {
            e.printStackTrace();
        }
        return this;
    }

    @Override
    public String getBackgroundColor(WebElement element) {
        String color;
        switch (element.getCssValue("background-color")) {
            case "rgba(255, 0, 0, 1)":
                color = "red";
                break;
            case "rgba(128, 128, 128, 1)":
                color = "grey";
                break;
            case "rgba(0, 0, 0, 1)":
                color = "black";
                break;
            case "rgba(255, 255, 255, 1)":
                color = "white";
                break;
            case "rgba(30, 30, 30, 1)":
                color = "dark-grey";
                break;
            case "rgba(121, 255, 121, 1)":
                color = "green";
                break;
            case "rgba(255, 255, 0, 1)":
                color = "yellow";
                break;
            default:
                color = "other";
        }
        return color;
    }

    public boolean isElementPresent(String locator) {
        try {
            driver.findElement(By.xpath(locator));
        } catch (NoSuchElementException e) {
            return false;
        }
        return true;
    }

    @Override
    public void switchToFrame(WebElement frame) {
        logger.info(": switch to frame with id: " + frame);
        try {
            driver.switchTo().frame(frame);
        } catch (NoSuchFrameException e) {
            waitInSec(5);
            logger.info("Attempt to switch to frame...");
            driver.switchTo().frame(frame);
        }
    }

    @Override
    public String getAttributeValue(WebElement element, String attribute) {
        fluentWait(element);
        return element.getAttribute(attribute);
    }

    @Override
    public void switchToSpecificWindow(String title) {
        logger.info(": switch to Child Window: ");
        try {
            ArrayList<String> handleList = new ArrayList<String>(driver.getWindowHandles());
            for(String childWindow : handleList)
            {
                driver.switchTo().window(childWindow);
                if(driver.getTitle().equalsIgnoreCase(title))
                {  break;   }
                else
                    continue;
            }
        } catch (NoSuchWindowException e) {
            waitInSec(5);
            logger.info("Attempt to switch to window..." + e);
        }
    }

    public Boolean validateFilenameWithPartialText(String dateFormat, String format)
    {
        Boolean fileExists = false;
        String filename =null;
        try {
            String folderName = Utils.PATH_TO_DOWNLOAD;

            File[] listFiles = new File(folderName).listFiles();
            for (int i = 0; i < listFiles.length; i++) {
                if (listFiles[i].isFile()) {
                    filename = listFiles[i].getName();
                    if (filename.startsWith(dateFormat)
                            && filename.endsWith(format)) {
                        fileExists = true;
                        excel.writeExcel("downloadedFileName", "Sheet1", filename);
                    }
                }
            }
        }
        catch (IOException e)
        {
            waitInSec(5);
            logger.info("Attempt to get file" + e);
        }
        return fileExists;
    }

    public void deleteFile(String fileName){
        String filepath = Utils.PATH_TO_DOWNLOAD;
        File newfile = new File(filepath +"/"+ fileName);
        newfile.delete();
    }

    public void readPDFFile(String filename) throws IOException {
        File file = new File(Utils.PATH_TO_DOWNLOAD + "/" + filename);
        InputStream instm = file.toURL().openStream();
        BufferedInputStream fileParse = new BufferedInputStream(instm);
        PDDocument document = null;
        document = PDDocument.load(fileParse);
        pdfcontent = new PDFTextStripper().getText(document);
        System.out.println(pdfcontent);
        fileParse.close();
    }

    public Boolean verifySingleWindow(String title)
    {
         if(driver.getWindowHandles().stream().count()==1 && !driver.getTitle().contains(title)){
             return true;
         }
         else return false;
    }

    public FunctionalLibrary createWriteFile(String filename, String content) throws IOException {
        FileWriter file = null;
        String dir = System.getProperty("user.dir");
        String filePath = "/src/test/resources/config/GM/TestData/TextFile/";
        try {
            file = new FileWriter(dir+filePath+filename+".txt");
            file.write(content);
            }
         catch (IOException e) {
           logger.fatal(e.toString());
        }
        file.close();
        return this;
    }

    public Boolean compareTwoFiles(String fileexpected, String fileactual) throws IOException {
        String dir = System.getProperty("user.dir");
        String filePath = "/src/test/resources/config/GM/TestData/TextFile/";
        BufferedReader reader1 = new BufferedReader(new FileReader(dir+filePath+fileexpected));
        BufferedReader reader2 = new BufferedReader(new FileReader(dir+filePath+fileactual));
        String line1 = reader1.readLine();
        String line2 = reader2.readLine();
        boolean areEqual = true;
        int lineNum = 1;
       while (line1 != null || line2 != null)
        {
            if(line1 == null || line2 == null)
            {
                areEqual = false;
                break;
            }
            else if(! line1.equalsIgnoreCase(line2))
            {
                areEqual = false;
                break;
            }
            line1 = reader1.readLine();
            line2 = reader2.readLine();
            lineNum++;
        }
        if(areEqual)
        {
            logger.info("Two files are having same content.");
            reader1.close();
            reader2.close();
            return true;
        }
        else
        {
            logger.info("Two files have different content. They differ at line "+lineNum);
            logger.info("File1 has "+line1+" and File2 has "+line2+" at line "+lineNum);
            reader1.close();
            reader2.close();
            return false;
        }
    }
}
