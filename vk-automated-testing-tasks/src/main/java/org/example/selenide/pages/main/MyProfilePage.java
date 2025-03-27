package org.example.selenide.pages.main;

import com.codeborne.selenide.SelenideElement;


import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;


public class MyProfilePage extends BaseMainPage {
    private final SelenideElement lastFeedPostText = $(byClassName("media-text_cnt"));
    private final SelenideElement friendsPanel = $(byId("hook_Block_UserFriendsColumnPortlet"));
    private final SelenideElement feedFilterMenu = $(byXpath(".//div[@data-l='t,filter']"));
    private final SelenideElement aboutMePanel = $(byId("hook_Block_AdditionalColumn"));
    private final SelenideElement profileNavigationMenu = $(byXpath(".//nav[@data-l='t,horizontalNavigation']"));


    public MyProfilePage() {
        checkPage();
    }

    public boolean checkPage() {
        feedFilterMenu.shouldBe(visible);
        aboutMePanel.shouldBe(visible);
        profileNavigationMenu.shouldBe(visible);
        friendsPanel.shouldBe(visible);
        return true;
    }

    public boolean checkLastFeedPostContains(String text) {
        return lastFeedPostText.shouldBe(visible).getText().contains(text);
    }
}
