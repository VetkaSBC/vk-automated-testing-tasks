package org.example.selenide.pages.main;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class MusicPage {
    private final SelenideElement shuffleButton = $(byXpath(".//button[@data-l='t,shuffleNaN']"));
    private final SelenideElement popularButton = $(byXpath(".//div[@data-l='t,showcase']"));
    private final SelenideElement myMusicButton = $(byXpath(".//div[@data-l='t,library']"));
    private final SelenideElement musicSearchField = $(byXpath(".//input[@data-tsid='inner_input']"));
    private final SelenideElement selectMusic = $(byXpath(".//wm-track[@data-tsid='track']"));
    private final SelenideElement playMusicButton = $(byXpath(".//button[@data-tsid='play_button']"));
    private final SelenideElement pauseMusicButton = $(byXpath(".//button[@data-tsid='pause_button']"));
    private final SelenideElement nextMusicPlayButton = $(byXpath(".//button[@data-tsid='forward_button']"));

    public MusicPage() {
        checkPage();
    }

    public boolean checkPage() {
        shuffleButton.shouldBe(visible);
        popularButton.shouldBe(visible);
        myMusicButton.shouldBe(visible);
        return true;
    }

    public MusicPage enterMusic(String Name) {
        musicSearchField.shouldBe(visible).setValue(Name);
        sleep(2000);
        musicSearchField.pressEnter();
        sleep(5000);
        return this;
    }

    public MusicPage playMusic() {
        selectMusic.shouldBe(visible).click();
        sleep(10000);
        return this;
    }

    public MusicPage nextMusicPlayButton() {
        nextMusicPlayButton.shouldBe(
                visible.because("Button next track should be visible on all main pages.")
        ).click();
        sleep(10000);
        return this;
    }

    public MusicPage pauseMusic() {
        pauseMusicButton.shouldBe(visible).click();
        sleep(1000);
        return this;
    }

    public MusicPage isMusicPaused() {
        playMusicButton.shouldBe(visible);
        sleep(1000);
        return this;
    }

    public MusicPage isMusicPlaying() {
        pauseMusicButton.shouldBe();
        sleep(1000);
        return this;
    }

}