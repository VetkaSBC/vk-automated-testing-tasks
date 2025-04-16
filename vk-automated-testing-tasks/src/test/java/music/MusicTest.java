package music;

import static com.codeborne.selenide.Selenide.open;
import static secondTask.TestData.EMAIL;
import static secondTask.TestData.PASSWORD;

import org.example.selenide.pages.main.LoginPage;
import org.example.selenide.pages.main.FeedPage;


import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import secondTask.BaseTest;

import java.util.concurrent.TimeUnit;

@Tag("Music test")
public class MusicTest extends BaseTest {

    @BeforeAll
    public static void login() {
        new LoginPage()
                .enterEmail(EMAIL)
                .enterPassword(PASSWORD)
                .clickSubmit();
    }

    @Tag("Playing music test")
    @DisplayName("Тест воспроизведения музыки")
    @ParameterizedTest
    @ValueSource(strings = {"happy nation remastered", "my ordinary life"})
    @Timeout(value = 25, unit = TimeUnit.SECONDS)
    public void testMusicPlay(String musicName) {
        new FeedPage().clickMusic();

        new MusicSteps()
                .openMusicPage()
                .searchAndPlayMusic(musicName)
                .pauseMusic()
                .playNextTrack()
                .pauseMusic()
                .verifyMusicPageLoaded();
    }

    @AfterEach
    public void teardown() {
        open("https://ok.ru");
    }
}