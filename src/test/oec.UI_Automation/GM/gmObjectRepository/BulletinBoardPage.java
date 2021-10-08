package GM.gmObjectRepository;

import base.FunctionalLibrary;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;

public class BulletinBoardPage extends FunctionalLibrary {
    private static final Log logger = LogFactory.getLog(BulletinBoardPage.class);

    @FindBy(xpath = "//span[contains(text(), 'Bulletin Board')]")
    private WebElement bulletinBoardTab;

    @FindBy(xpath = "//a[contains(text(), 'Historical')]")
    private WebElement historicalNewsLetter;

    @FindBy(xpath = "//input[@value='Cancel']")
    private WebElement historicalDialogCancel;

    @FindBy(xpath = "//a[contains(text(), 'testy')]")
    private WebElement achieveNewsLetter;

    @FindBy(xpath = "//div[@class='WordSection1']")
    private WebElement newsLetterUpdate;

    @FindBy(xpath = "//b[contains(text(), 'System Messages')]")
    private WebElement bulletinBoardPage;

    @FindBy(xpath = "//iframe[@id='ifame']")
    private WebElement newsUpdateFrame;

    @FindBy(xpath = "//a[contains(text(), 'Latest')]")
    private WebElement latestNewsLetter;

    @FindBy(xpath = "//a[contains(@href, 'Release') and contains(text(), 'Click to view details about new software release')]")
    private WebElement latestNewLetterLink;

    @FindBy(xpath = "//input[@value='Continue']")
    private WebElement continueBtn;

    public BulletinBoardPage(WebDriver driver) {
        super(driver);
    }

    public BulletinBoardPage clickBulletinBoardTab()
    {
        fluentWait(bulletinBoardTab);
        click(bulletinBoardTab);
        return this;
    }

    public BulletinBoardPage clickHistoricalNewsLetter()
    {
        fluentWait(historicalNewsLetter);
        click(historicalNewsLetter);
        return this;
    }

    public BulletinBoardPage clickCancelHistoricalNewsLetterDialog()
    {
        fluentWait(historicalDialogCancel);
        click(historicalDialogCancel);
        return this;
    }

    public BulletinBoardPage clickExistingArchieveLetter()
    {
        fluentWait(achieveNewsLetter);
        click(achieveNewsLetter);
        waitInSec(4);
        return this;
    }

    public Boolean checkBulletinBoardPage()
    {
        fluentWait(bulletinBoardPage);
        if(bulletinBoardPage.isDisplayed())
        {  return true;  }
        else return false;
    }

    public Boolean checkArchiveletterLinkDisplayed()
    {
        fluentWait(achieveNewsLetter);
        if(achieveNewsLetter.isDisplayed())
        { return true;  }
        else return false;
    }

    public String getAchivedLetterUpdate(String filename) throws IOException {
        switchToFrame(newsUpdateFrame);
        fluentWait(newsLetterUpdate);
        String letterUpdate = newsLetterUpdate.getText();
        functionalLibrary = new FunctionalLibrary(driver);
        functionalLibrary.createWriteFile(filename ,letterUpdate);
        System.out.println(letterUpdate);
        return letterUpdate;
    }

    public Boolean verifyNewsLetterContent(String expectedfilecontent, String Actualfilecontent) throws IOException {
        return functionalLibrary.compareTwoFiles(expectedfilecontent, Actualfilecontent);
    }

    public BulletinBoardPage clickLatestNewsLetter()
    {
        fluentWait(latestNewsLetter);
        click(latestNewsLetter);
        return this;
    }

    public Boolean checkLatestNewsLetterLink()
    {
        switchToFrame(newsUpdateFrame);
        fluentWait(latestNewLetterLink);
        if(latestNewLetterLink.isDisplayed()){
        return true;}
        else return false;
    }

    public BulletinBoardPage clickContinueBtn()
    {
        fluentWait(continueBtn);
        click(continueBtn);
        return this;
    }
}