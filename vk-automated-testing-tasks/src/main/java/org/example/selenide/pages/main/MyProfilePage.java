package org.example.selenide.pages.main;

import org.openqa.selenium.By;


import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;


public class MyProfilePage extends BaseMainPage {
    private static final By lastFeedPostText = byClassName("media-text_cnt");
    private static final By feedFilterMenu = byXpath(".//div[@data-l='t,filter']");
    private static final By profileNavigationMenu = byXpath(".//nav[@data-l='t,horizontalNavigation']");


    public MyProfilePage() {
        checkPage();
    }

    public boolean checkPage() {
        $(feedFilterMenu).shouldBe(
                visible.because("Feed filter menu should be visible on my profile page.")
        );
        $(profileNavigationMenu).shouldBe(
                visible.because("Navigation menu of profile feed should be visible on my profile page.")
        );
        return true;
    }

    public boolean checkLastFeedPostContains(String text) {
        return $(lastFeedPostText).shouldBe(
                        visible.because("Text of last feed post should be visible on my profile page.")
                ).getText()
                .contains(text);
    }



}
