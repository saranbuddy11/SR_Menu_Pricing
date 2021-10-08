package base;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;

import java.util.List;
import java.util.Map;

public interface SeleniumUtils {

    String getPageUrl();

    By getByForLocator(String locator);

    void clickRadioBtn(String locator, boolean state);

    void clickRadioBtn(WebElement e, boolean state);

    boolean clickCheckbox(String locator, boolean state);

    void doubleClick(WebElement element);

    void waitUntil(ExpectedCondition<?> expectedCondition, int timeoutSeconds);

    void waitUntil(ExpectedCondition<?> expectedCondition);

    void waitUntilWithAngularCalls(ExpectedCondition<?> expectedCondition);

    WebElement fluentWait(final WebElement element);


    void waitInSec(Integer sec);

    void scrollIntoView(WebElement element);

    void scrollToTheBottom();

    void scrollToTheTop();

    void moveToElementAndForceClick(WebElement element);

    void waitUntilAngularFinishHttpCalls();

    void waitUntilAngularFinishHttpCalls(long timeout);

    void waitAndClick(WebElement el);

    void waitAndClickWithoutAngular(WebElement el);


    <T extends FunctionalLibrary> T goToPreviousPage(Class<T> clazz) throws RuntimeException;

    FunctionalLibrary switchToBrowserTab(int windowNumber);

    void switchToWindow(String handle);

    void refresh();

    FunctionalLibrary switchToTab(int windowNumber);

    boolean isAt(String pageUrl);

    <T extends FunctionalLibrary> void acceptAlertIfPresent(Class<T> clazz) throws RuntimeException;

    String getBaseURL();

    <T extends FunctionalLibrary> void dismissAlertIfPresent(Class<T> clazz) throws RuntimeException;

    WebElement fluentWaits(By locator);

    WebElement fluentWait(By by);

    List<WebElement> getElementsByLocator(String locator);

    WebElement fluentWaitByLocator(String locator);

    String getTextColor(WebElement element);

    FunctionalLibrary sendKeys(WebElement element, String text);

    FunctionalLibrary sendKeysDouble(WebElement element, Double value);

    FunctionalLibrary click(WebElement element);

    String getAttribute(WebElement element);

    String getAttributeByString(String element, String xpath);

    String getText(WebElement element);

    String getTextBasedOnIndex(String element, int index);

    FunctionalLibrary expandRow(String locator, int rowNumber);

    FunctionalLibrary moveToElementClick(WebElement element);

    boolean elementIsEnabled(WebElement element);

    FunctionalLibrary jsClickElement(WebElement element);


    FunctionalLibrary jsSendKeys(WebElement element, Double value);


    FunctionalLibrary jsSendKeysText(WebElement element, String text);

    List<String> getListOfContents(List<WebElement> elements);



    List<String> getListOfContentAttribute(List<WebElement> elements);

    List<Boolean> isElementsDisplayed(List<WebElement> elements);

    List<Boolean> isElementsEnabled(List<WebElement> elements);

    FunctionalLibrary clickBasedOnIndex(String element, int index);

    FunctionalLibrary clickBasedOnName(String name);

    FunctionalLibrary sendKeysBasedOnName(String name, String text);

    int getSize(List<WebElement> element);

    FunctionalLibrary sendKeysNumber(WebElement element, int text);

    Boolean isElementDisplayedBasedOnIndex(String element, int index);

    Boolean isElementEnabledBasedOnIndex(String element, int index);

    boolean isFileDownloaded(String fileName);

    String getBackgroundColor(WebElement element);

    void switchToFrame(WebElement frame);

    String getAttributeValue(WebElement element, String attribute);

    void switchToSpecificWindow(String title);
}
