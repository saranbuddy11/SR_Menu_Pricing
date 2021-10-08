package GM.gmObjectRepository;

import GM.gmObjectRepository.menuManager.MenuManagerPage;
import base.FunctionalLibrary;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CalenderPage extends FunctionalLibrary {

    private static String Days = "//tr[@class='daysrow']//td[contains(text(),'%s')]";
    private static String select18DATE = "(//td[contains(text(),'18')])[3]";

    public CalenderPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "(//div[contains(text(),'«')])")
    private WebElement previousYear;
    @FindBy(xpath = "(//div[contains(text(),'×')])")
    private WebElement closeCalender;
    @FindBy(xpath = "//div[contains(text(),'Today')]")
    private WebElement todayBtn;
    @FindBy(xpath = "//div[contains(text(),'×')]//preceding::td[@class='title']")
    private WebElement calendarTitle;
    @FindBy(xpath = "(//div[contains(text(),'«')])")
    private WebElement previousYears;
    @FindBy(xpath = "(//td[contains(text(),'18')])[3]")
    private List<WebElement> select18Date;
    @FindBy(xpath = "(//div[contains(text(),'‹')])")
    private WebElement previousMonth;

    public MenuManagerPage setStartDateInCalender() {
        waitInSec(2);
        moveToElementAndForceClick(previousYear);
        moveToElementAndForceClick(closeCalender);
        return new MenuManagerPage(getDriver());
    }

    public MenuManagerPage setCurrentDateInCalender() {
        waitInSec(2);
        clickBasedOnElementAndText(Days, getCurrentDay());
        return new MenuManagerPage(getDriver());
    }

    public MenuManagerPage setTodayDate() {
        waitInSec(2);
        moveToElementAndForceClick(todayBtn);
        try {
            moveToElementClick(todayBtn);
        } catch (Exception e) {
            e.printStackTrace();
            moveToElementClick(todayBtn);
        }
        return new MenuManagerPage(getDriver());
    }

    public MenuManagerPage setSupportEnquiryDate(List<String> date) {
        waitInSec(2);
        for (int i = 0; i < 100; i++) {
            if (calendarTitle.getText().equals(date.get(i))) {
                System.out.println(" calendar Title 0 " + calendarTitle.getText());
                moveToElementClick(driver.findElement(By.xpath(select18DATE)));
                break;
            } else {
                if (calendarTitle.getText().contains(date.get(1))) {
                    System.out.println(" calendar Title 0 " + calendarTitle.getText());
                    if (calendarTitle.getText().equals(date.get(0))) {
                        System.out.println(" calendar Title 1 " + calendarTitle.getText());
                        moveToElementClick(driver.findElement(By.xpath(select18DATE)));
                        break;
                    } else {
                        System.out.println(" calendar Title 2 " + calendarTitle.getText());
                        moveToElementClick(previousYears);
                        System.out.println(" calendar Title 0 " + calendarTitle.getText());
                    }
                } else {
                    System.out.println(" calendar Title 0 " + calendarTitle.getText());
                    moveToElementClick(previousMonth);
                    System.out.println(" calendar Title 0 " + calendarTitle.getText());
                }
            }
        }
        return new MenuManagerPage(getDriver());
    }

}
