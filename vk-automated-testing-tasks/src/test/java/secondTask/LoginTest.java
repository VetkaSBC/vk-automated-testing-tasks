package secondTask;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.example.selenide.pages.main.LoginPage;
import org.example.selenide.pages.main.FeedPage;
import org.junit.jupiter.api.Timeout;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Tag("Login тест")
public class LoginTest extends BaseTest {

    @DisplayName("Тест аутендификации")
    @Test
    @Timeout(value = 10, unit = TimeUnit.SECONDS)
    public void testLogin() {
        FeedPage feedPage = new LoginPage()
                .enterEmail(TestData.EMAIL)
                .enterPassword(TestData.PASSWORD)
                .clickSubmit();

        assertTrue(feedPage.checkProfileNameContains(TestData.NAME),
                "Неверное имя пользователя"
        );
    }
}
