package posts;

import org.example.selenide.pages.main.MyProfilePage;
import org.junit.jupiter.api.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import secondTask.BaseTest;

import java.util.concurrent.TimeUnit;

import static secondTask.TestData.EMAIL;
import static secondTask.TestData.PASSWORD;

@Tag("Post test")
public class PublishTextPostTest extends BaseTest {

    private static final PublishPostSteps steps = new PublishPostSteps();

    @BeforeAll
    public static void login() {
        steps.login(EMAIL, PASSWORD);
    }

    @Tag("Creation posts test")
    @DisplayName("Тест создание поста через Steps")
    @ParameterizedTest
    @ValueSource(strings = {"Hello, Ok", "Hello, Vk"})
    @Timeout(value = 20, unit = TimeUnit.SECONDS)
    public void testPublishPost(String postText) {
        MyProfilePage myProfilePage = steps.publishPost(postText);
        steps.assertPostWasCreated(myProfilePage, postText);
        steps.returnToMainPage();
    }
}
