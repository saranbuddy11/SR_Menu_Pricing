package GM.gmObjectRepository;

import base.FunctionalLibrary;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.File;
import java.util.List;

public class HelpSupportPage extends FunctionalLibrary {
    private static final Log logger = LogFactory.getLog(HelpSupportPage.class);

    private static final String HELP_SUPPORT = "//div[@class='main-tab']//span[contains(text(), 'wsparcie') or contains(text(), 'Help')]";
    @FindBy(xpath = HELP_SUPPORT)
    private WebElement helpSupportTab;

    @FindBy(xpath = "//div[@class='title']")
    private WebElement contactNo;

    @FindBy(xpath = "//div[@class='work-main']//a")
    private WebElement helplink;

    @FindBy(xpath = "//div[@class='work-main']//a")
    private List<WebElement> helplinks;

    @FindBy(xpath = "//input[@name='logout']")
    private WebElement logoutButton;

    @FindBy(xpath = "//div[contains(@class, 'ui-dialog') and (contains(@style, 'display: block;'))]//button[1]//span[contains(text(), 'OK')]")
    private WebElement logoutConfirmation;

    @FindBy(xpath = "(//a[contains(text(), 'User Guide')])[1]")
    private WebElement userGuide;


    public HelpSupportPage(WebDriver driver) {
        super(driver);
    }

    public HelpSupportPage clickHelpSupportTab() {
        logger.info(": method start");
        helpSupportTab.click();
        return this;
    }

    public String getContactNo() {
        fluentWait(contactNo);
        return getText(contactNo);
    }

    public String getLink() {
        fluentWait(helplink);
        return getAttributeValue(helplink, "href");
    }

    public HelpSupportPage clickHelpLink() {
        fluentWait(helplink);
        helplink.click();
        return this;
    }

    public HelpSupportPage clickLogout() {
        logger.info(": logout method start");
        fluentWait(logoutButton);
        jsClickElement(logoutButton);
        waitInSec(2);
        return this;
    }

    public HelpSupportPage confirmLogout() {
        fluentWait(logoutConfirmation);
        jsClickElement(logoutConfirmation);
        return this;
    }

    public String getPageTitle(){
        waitInSec(2);
        String title = driver.getTitle();
        return title;
    }

    public String getLinkCount(){
        waitInSec(2);
        String linkCount = String.valueOf(helplinks.size());
        return linkCount;
    }

    public HelpSupportPage clickHelpGuide(){
        fluentWait(userGuide);
        userGuide.click();
        waitInSec(3);
        return this;
    }

    public Boolean getFile(String environment){
        Boolean fileExist = false;
        if(environment.contains("uat")){
            fileExist   = isFileDownloaded("User Guide.pdf");
        } else if(environment.contains("qa")){
            fileExist = isFileDownloaded("MP_JLR_UserGuide_v05.pdf");
        }
        return fileExist;
    }

    public void deleteFile(String environment){
        String filepath = System.getProperty("user.home");
        File newfile = null;
        if(environment.contains("uat")){
            newfile = new File(filepath + "/Downloads/User Guide.pdf");
        } else if(environment.contains("qa")){
            newfile = new File(filepath + "/Downloads/MP_JLR_UserGuide_v05.pdf");
        }
        newfile.delete();
    }

}