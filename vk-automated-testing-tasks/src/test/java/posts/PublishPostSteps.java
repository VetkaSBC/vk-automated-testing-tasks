package posts;

import org.example.selenide.pages.main.FeedPage;
import org.example.selenide.pages.main.LoginPage;
import org.example.selenide.pages.main.MyProfilePage;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PublishPostSteps {

    public void login(String email, String password) {
        new LoginPage()
                .enterEmail(email)
                .enterPassword(password)
                .clickSubmit();
    }

    public MyProfilePage publishPost(String postText) {
        return new FeedPage()
                .clickPublish()
                .clickPublishPost()
                .enterPostText(postText)
                .clickSubmit()
                .openMyProfilePage();
    }

    public void assertPostWasCreated(MyProfilePage myProfilePage, String postText) {
        assertTrue(myProfilePage.checkLastFeedPostContains(postText), "Пост не был создан");
    }

    public void returnToMainPage() {
        open("https://ok.ru");
    }
}