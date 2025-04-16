package music;

import org.example.selenide.pages.main.MusicPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MusicSteps {
    private final MusicPage musicPage = new MusicPage();

    public MusicSteps openMusicPage() {
        assertTrue(musicPage.checkPage(), "Музыкальная страница не отобразилась.");
        return this;
    }

    public MusicSteps searchAndPlayMusic(String name) {
        musicPage.enterMusic(name)
                .playMusic()
                .isMusicPlaying();
        return this;
    }

    public MusicSteps pauseMusic() {
        musicPage.pauseMusic()
                .isMusicPaused();
        return this;
    }

    public MusicSteps playNextTrack() {
        musicPage.nextMusicPlayButton()
                .isMusicPlaying();
        return this;
    }

    public MusicSteps verifyMusicPageLoaded() {
        assertTrue(musicPage.checkPage(), "Музыкальная страница недоступна после выполнения действий.");
        return this;
    }
}
