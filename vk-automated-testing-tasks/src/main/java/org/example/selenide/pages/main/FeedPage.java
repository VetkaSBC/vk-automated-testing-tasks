package org.example.selenide.pages.main;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;

public class FeedPage extends BaseMainPage {
    private final SelenideElement profileAvatar = $(byId("hook_Block_Avatar"));
    private final SelenideElement onlineFriendsPanel = $(byId("hook_Block_FriendStream"));
    private final SelenideElement feedFilterMenu = $(byId("toolbar_search"));
    private final SelenideElement alternativeContentPanel = $(byId("hook_Block_AlternativeContent"));

    public FeedPage() {
        checkPage();
    }

    public boolean checkPage() {
        profileAvatar.shouldBe(visible);
        feedFilterMenu.shouldBe(visible);
        onlineFriendsPanel.shouldBe(visible);
        alternativeContentPanel.shouldBe(visible);
        return true;
    }

    public boolean checkProfileNameContains(String name) {
        return myProfileButton.shouldBe(visible).getText().contains(name);
    }
}
