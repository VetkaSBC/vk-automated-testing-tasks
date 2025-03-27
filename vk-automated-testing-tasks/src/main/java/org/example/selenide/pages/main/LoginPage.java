package org.example.selenide.pages.main;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.example.selenide.BasePage;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage extends BasePage {
    private final SelenideElement emailField = $(byName("st.email"));
    private final SelenideElement passwordField = $(byName("st.password"));
    private final SelenideElement submitButton = $(byValue("Войти в Одноклассники"));
    private final SelenideElement qrButton = $(byXpath(".//a[@data-l='t,get_qr']"));
    private final SelenideElement restoreButton = $(byXpath(".//a[@data-l='t,restore']"));
    private final SelenideElement registerButton = $(byXpath(".//a[@data-l='t,register']"));

    public LoginPage() {
        checkPage();
    }

    public boolean checkPage() {
        emailField.shouldBe(exist);
        passwordField.shouldBe(exist);
        submitButton.shouldBe(exist);
        qrButton.shouldBe(exist);
        restoreButton.shouldBe(exist);
        registerButton.shouldBe(exist);
        return true;
    }

    public LoginPage enterEmail(String email) {
        emailField.shouldBe(visible).setValue(email);
        return this;
    }

    public LoginPage enterPassword(String password) {
        passwordField.shouldBe(visible).setValue(password);
        return this;
    }

    public FeedPage clickSubmit() {
        submitButton.shouldBe(visible).click();
        return new FeedPage();
    }
}
