package secondTask;

import static com.codeborne.selenide.Selenide.open;
import org.example.selenide.pages.main.LoginPage;
import org.example.selenide.pages.main.FeedPage;
import org.example.selenide.pages.main.MusicPage;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Tag("Music test")
public class MusicTest extends BaseTest{
    private static final String MUSIC_NAME = "happy nation remastered";
    private MusicPage musicPage;

    @BeforeAll
    public static void login() {
        new LoginPage()
                .enterEmail(TestData.EMAIL)
                .enterPassword(TestData.PASSWORD)
                .clickSubmit();
    }

    @BeforeEach
    public void setup() {
        musicPage = new FeedPage().clickMusic();
    }


    @Tag("Playing music test")
    @DisplayName("Тест раздела музыки")
    @ParameterizedTest
    @ValueSource(strings = {"happy nation remastered", "my ordinary life"})
    @Timeout(value = 25, unit = TimeUnit.SECONDS)
    public void testMusicPlay(String musicName) {
        musicPage.enterMusic(musicName)
                .playMusic()
                .isMusicPlaying()
                .pauseMusic()
                .isMusicPaused()
                .nextMusicPlayButton()
                .isMusicPlaying()
                .pauseMusic()
                .isMusicPaused();
        assertTrue(musicPage.checkPage()
        );
    }

    @AfterEach
    public void teardown() {
        open("https://ok.ru");
    }
}
