package secondTask;

import org.junit.jupiter.api.*;
import org.example.selenide.pages.main.FeedPage;
import org.example.selenide.pages.login.LoginPage;
import org.example.selenide.pages.main.MyProfilePage;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PublishTextPostTest extends BaseTest {
    private static final String POST_TEXT = "Hello, OK";

    @BeforeAll
    public static void login() {
        new LoginPage()
                .enterEmail(EMAIL)
                .enterPassword(PASSWORD)
                .clickSubmit();
    }

    @Test
    public void testPublishPost() {
        MyProfilePage myProfilePage = new FeedPage()
                .clickPublish()
                .clickPublishPost()
                .enterPostText(POST_TEXT)
                .clickSubmit()
                .openMyProfilePage();
        assertTrue(myProfilePage.checkLastFeedPostContains(POST_TEXT),
                "The post was not created."
        );
    }

}
