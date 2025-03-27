package org.example.selenide;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public abstract class BasePage {
    protected final SelenideElement toolbarOKLogo = $(byXpath(".//a[@data-l='t,logo']"));
    protected final SelenideElement queryField = $(byName("st.query"));
    protected final SelenideElement ecosystemButton = $(byXpath(".//div[@data-module='VkEcosystem']"));

    protected BasePage() {
        checkPage();
    }

    private void checkPage() {
        toolbarOKLogo.shouldBe(visible);
        queryField.shouldBe(visible);
        ecosystemButton.shouldBe(visible);
    }
}