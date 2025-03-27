package org.example.selenide.pages.main;

import com.codeborne.selenide.SelenideElement;


import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class PersonalDataPage {

    private final SelenideElement cityOfResidenceField = $(byXpath("(//input[@class='input__wr2ed __redesign2024__wr2ed'])[1]"));
    private final SelenideElement hometownField = $(byXpath("(//input[@class='input__wr2ed __redesign2024__wr2ed'])[2]"));
    private final SelenideElement selectCity = $(byXpath(".//div[@class='option__wr2ed']"));
    private final SelenideElement saveChangesButton = $(byXpath("//span[@class='content__0ej09']"));
    private final SelenideElement cancelChangesButton = $(byText("Изменить личные данные"));



    public PersonalDataPage() {
        checkPage();
    }

    public boolean checkPage() {
        cityOfResidenceField.shouldBe(visible);
        hometownField.shouldBe(visible);
        saveChangesButton.shouldBe(visible);
        cancelChangesButton.shouldBe(visible);
        return true;
    }

    public PersonalDataPage clickCityOfResidenceField() {
        cityOfResidenceField.shouldBe(visible).click();
        sleep(2000);
        return this;
    }

    public PersonalDataPage entryCityOfResidenceField(String City) {
        cityOfResidenceField.shouldBe(visible).setValue(City);
        sleep(2000);
        return this;
    }

    public PersonalDataPage slectCity() {
        selectCity.shouldBe(visible).click();
        sleep(2000);
        return this;
    }

    public PersonalDataPage clickHometownField() {
        hometownField.shouldBe(visible).click();
        sleep(2000);
        return this;
    }

    public PersonalDataPage entryHometownField(String City) {
        hometownField.shouldBe(visible).setValue(City);
        sleep(2000);
        return this;
    }

    public GeneralInfoPage saveChanges() {
        saveChangesButton.shouldBe(visible).click();
        return new GeneralInfoPage();
    }

}
