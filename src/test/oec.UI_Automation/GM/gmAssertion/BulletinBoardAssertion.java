package GM.gmAssertion;

import GM.gmObjectRepository.BulletinBoardPage;
import base.AbstractAssertion;

import java.io.IOException;

import static org.assertj.core.api.Assertions.as;
import static org.assertj.core.api.Assertions.assertThat;

public class BulletinBoardAssertion extends AbstractAssertion<BulletinBoardPage> {

    public BulletinBoardAssertion assertAtHomePage() {
        assertThat((functionalLibrary.isAt(functionalLibrary.getBaseURL()))).as("Verify that you are at 'Home' page").isTrue();
        return this;
    }

    public BulletinBoardAssertion assertAtBulletinBoardPage(){
        assertThat(functionalLibrary.checkBulletinBoardPage()).as("Verify that bulletinboard page got displayed").isTrue();
        return this;
    }

    public BulletinBoardAssertion assertIfArchiveLetterLinkDisplayed(){
        assertThat(functionalLibrary.checkArchiveletterLinkDisplayed()).as("Verify the link for Archive letter is displayed").isTrue();
        return this;
    }

    public BulletinBoardAssertion assertIfExpectedNewsLetterContentdisplayed(String expectedFile, String ActualFile) throws IOException {
        assertThat(functionalLibrary.verifyNewsLetterContent(expectedFile, ActualFile)).as("News Letter content correctly displayed").isTrue();
        return this;
    }

    public BulletinBoardAssertion assertIfLatestNewsLetterLinkDisplayed()
    {
        assertThat(functionalLibrary.checkLatestNewsLetterLink()).as("Verify latest news letter link got displayed").isTrue();
        return this;
    }
}