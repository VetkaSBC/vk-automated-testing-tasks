package org.example.selenide.pages.main;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class GroupMainPage{
    private final SelenideElement groupToolbar = $(byId("hook_Block_UserGroupsCatalogHeaderBlock"));
    private final SelenideElement contentBlock = $(byId("hook_Block_ContentColumnContainer"));
    private final SelenideElement createGroupButton = $(byText("Создать группу"));
    private final SelenideElement groupSubscribeButton = $(byText("Подписаться"));
    private final SelenideElement myGroupsBlock = $(byId("hook_Block_MyGroupsTopBlock"));
    private final SelenideElement groupTypeButton = $(byXpath(".//a[@data-l='t,PAGE']"));
    private final SelenideElement nameGroupField = $(byXpath(".//input[@name='st.layer.name']"));
    private final SelenideElement chooseThematicField = $(byId("category-input"));
    private final SelenideElement chooseThematic = $(byXpath(".//div[@class='multi-select-suggest_i_children']"));
    private final SelenideElement createButton = $(byXpath(".//input[@data-l='t,confirm']"));
    private final SelenideElement selectGroupButton = $(byXpath(".//a[@data-l='t,visit']"));

    public GroupMainPage() {
        checkPage();
    }

    public boolean checkPage() {
        groupToolbar.shouldBe(visible);
        contentBlock.shouldBe(visible);
        return true;
    }

    public GroupMainPage clickCreateGroupButton() {
        createGroupButton.shouldBe(visible).click();
        return this;
    }

    public GroupMainPage clickGroupSubscribeButton() {
        groupSubscribeButton.shouldBe(visible).click();
        return new GroupMainPage();
    }

    public GroupMainPage checkMyGroupsBlockExist() {
        myGroupsBlock.shouldBe(visible);
        return this;
    }

    public GroupMainPage clickGroupTypeButton() {
        groupTypeButton.shouldBe(visible).click();
        return this;
    }

    public GroupMainPage enterGroupNameButton(String Name) {
        nameGroupField.shouldBe(visible).setValue(Name);
        return this;
    }

    public GroupMainPage enterThematicField(String Name) {
        chooseThematicField.shouldBe(visible).setValue(Name);
        return this;
    }

    public GroupMainPage selectThematic() {
        chooseThematic.shouldBe(visible).click();
        return this;
    }


    public MyGroupPage clickCreateButton() {
        createButton.shouldBe(visible).click();
        return new MyGroupPage();
    }

    public MyGroupPage selectGroupButton() {
        selectGroupButton.shouldBe(visible).click();
        return new MyGroupPage();
    }

}
