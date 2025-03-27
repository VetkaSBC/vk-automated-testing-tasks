package secondTask;

import org.junit.jupiter.api.Test;
import org.example.selenide.pages.login.LoginPage;
import org.example.selenide.pages.main.FeedPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTest extends BaseTest {
    @Test
    public void testLogin() {
        FeedPage feedPage = new LoginPage()
                .enterEmail(EMAIL)
                .enterPassword(PASSWORD)
                .clickSubmit();

        assertTrue(feedPage.checkProfileNameContains(NAME),
                "Incorrect account login name."
        );
    }
}
