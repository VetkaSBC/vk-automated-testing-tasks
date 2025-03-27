package org.example.selenide.pages.main;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.example.selenide.BasePage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public abstract class BaseMainPage extends BasePage {
    protected final SelenideElement myProfileButton = $(byXpath(".//a[@data-l='t,userPage']"));
    protected final SelenideElement navigationMenu = $(byXpath(".//div[@data-l='t,navigation']"));
    protected final SelenideElement paymentsMenu = $(byXpath(".//ul[@data-l='t,secondTierLeftMenu']"));
    protected final SelenideElement generalInfoButton = $(byXpath(".//a[@class='user-profile_lk-o ellip-i __redesign']"));
    protected final SelenideElement publishButton = $(byXpath(".//button[@data-testid='ddm-button']"));
    protected final SelenideElement publishPostButton = $(byXpath(".//*[@class='item-container__7e56q']"));
    protected final SelenideElement musicButton = $(byXpath(".//*[@id='music_toolbar_button']"));
    protected final SelenideElement postTextBox = $(byXpath(".//div[@data-module='postingForm/mediaText']"));
    protected final SelenideElement submitButton = $(byXpath(".//button[@data-l='t,button.submit']"));

    protected BaseMainPage() {
        checkPage();
    }

    private void checkPage() {
        $(paymentsMenu).shouldBe(visible);
        $(navigationMenu).shouldBe(visible);
        $(publishButton).shouldBe(visible);
    }

    public GeneralInfoPage clickGeneralMenu() {
        generalInfoButton.shouldBe(visible).click();
        return new GeneralInfoPage();
    }

    public MusicPage clickMusic() {
        musicButton.shouldBe(visible).click();
        sleep(2000);
        return new MusicPage();
    }

    public MyProfilePage openMyProfilePage() {
        myProfileButton.shouldBe(visible).click();
        return new MyProfilePage();
    }

    public BaseMainPage clickPublish() {
        publishButton.shouldBe(visible).click();
        return this;
    }

    public BaseMainPage clickPublishPost() {
        publishPostButton.shouldBe(visible).click();
        return this;
    }

    public BaseMainPage enterPostText(String postText) {
        postTextBox.shouldBe(visible).setValue(postText);
        return this;
    }

    public BaseMainPage clickSubmit() {
        submitButton.shouldBe(visible).click();
        return this;
    }

}