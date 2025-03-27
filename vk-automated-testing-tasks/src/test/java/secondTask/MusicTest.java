package secondTask;

import org.example.selenide.pages.main.LoginPage;
import org.example.selenide.pages.main.FeedPage;
import org.example.selenide.pages.main.MusicPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MusicTest extends BaseTest{
    private static final String MUSIC_NAME = "happy nation remastered";

    @BeforeAll
    public static void login() {
        new LoginPage()
                .enterEmail(EMAIL)
                .enterPassword(PASSWORD)
                .clickSubmit();
    }

    @Test
    public void testMusicPlay() {
        MusicPage musicPage = new FeedPage()
                .clickMusic()
                .enterMusic(MUSIC_NAME)
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
}
