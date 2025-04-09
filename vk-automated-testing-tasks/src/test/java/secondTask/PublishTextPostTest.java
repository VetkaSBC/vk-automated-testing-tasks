package secondTask;

import org.junit.jupiter.api.*;
import org.example.selenide.pages.main.FeedPage;
import org.example.selenide.pages.main.LoginPage;
import org.example.selenide.pages.main.MyProfilePage;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Tag("Post test")
public class PublishTextPostTest extends BaseTest {

    @BeforeAll
    public static void login() {
        new LoginPage()
                .enterEmail(TestData.EMAIL)
                .enterPassword(TestData.PASSWORD)
                .clickSubmit();
    }


    @Tag("Creation posts test")
    @DisplayName("Тест создание поста")
    @ParameterizedTest
    @ValueSource(strings = {"Hello, Ok", "Hello, Vk"})
    @Timeout(value = 20, unit = TimeUnit.SECONDS)
    public void testPublishPost(String postText) {
        MyProfilePage myProfilePage = new FeedPage()
                .clickPublish()
                .clickPublishPost()
                .enterPostText(postText)
                .clickSubmit()
                .openMyProfilePage();
        assertTrue(myProfilePage.checkLastFeedPostContains(postText),
                "Пост не был создан"
        );
        open("https://ok.ru");
    }

}
