package org.example.selenide.pages.main.groupsPage;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class MyGroupPage {
    private final SelenideElement groupAvatar = $(byId("hook_Block_Avatar"));
    private final SelenideElement backGroupButton = $(byId("hook_Block_MiddleColumnTopCard_MenuAltGroup"));
    private final SelenideElement backButton = $(byId("topPanelLeftCorner"));
    private final SelenideElement backGroupsButton = $(byId("toolbar_back_id"));
    private final SelenideElement optionsButton = $(byXpath(".//button[@class='u-menu_a toggle-dropdown button-clear']"));
    private final SelenideElement deleteGroupButton = $(byText("Удалить"));
    private final SelenideElement confirmDeleteGroupButton = $(byXpath(".//input[@data-l='t,confirm']"));
    private final SelenideElement myGroups = $(byId("hook_Block_MyGroupsTopBlock"));


    public MyGroupPage() {
        checkPage();
    }

    public boolean checkPage() {
        groupAvatar.shouldBe(visible);
        backGroupButton.shouldBe(visible);
        return true;
    }

    public MyGroupPage clickBackButton() {
        backButton.shouldBe(visible).click();
        return this;
    }

    public MyGroupPage clickBackGroupButton() {
        backGroupsButton.shouldBe(visible).click();
        return this;
    }

    public MyGroupPage clickOptionsButton() {
        optionsButton.shouldBe(visible).click();
        return this;
    }

    public MyGroupPage clickDeleteOptionButton() {
        deleteGroupButton.shouldBe(visible).click();
        return this;
    }

    public MyGroupPage clickConfirmDeleteOptionButton() {
        confirmDeleteGroupButton.shouldBe(visible).click();
        return this;
    }

    public boolean isMyGroupExist() {
        myGroups.shouldBe(visible);
        return true;
    }




}
