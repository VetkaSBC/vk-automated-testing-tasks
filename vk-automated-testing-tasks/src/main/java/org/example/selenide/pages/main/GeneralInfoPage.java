package org.example.selenide.pages.main;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class GeneralInfoPage {
    private final SelenideElement maritalStatusButton = $(byXpath(".//span[@data-type='RELATION_SIMPLE']"));
    private final SelenideElement selectMartialStatusButton = $(byText("Разведён"));
    private final SelenideElement changeMartialStatusButton = $(byId("ownProfileLSBtn"));
    private final SelenideElement deleteMartialStatusButton = $(byText("Удалить"));
    private final SelenideElement editPersonalDataButton = $(byXpath(".//button[@data-tag-name='photo-settings']"));
    private final SelenideElement cityOfResidenceStatus = $(byXpath("(.//span[@class='user-profile_i_info'])[3]"));
    private final SelenideElement hometownStatus = $(byXpath("(.//span[@class='user-profile_i_info'])[2]"));
    private final SelenideElement MartialStatus = $(byXpath("(.//span[@class='user-profile_i_info'])[4]"));

    public GeneralInfoPage() {
        checkPage();
    }

    public boolean checkPage() {
        maritalStatusButton.shouldBe(visible);
        return true;
    }

    public GeneralInfoPage clickMaritalStatusButton() {
        maritalStatusButton.shouldBe(visible).click();
        sleep(1000);
        return this;
    }

    public GeneralInfoPage clickSelectMartialStatusButton() {
        selectMartialStatusButton.shouldBe(visible).click();
        sleep(1000);
        return this;
    }

    public PersonalDataPage clickEditPersonalDataButton() {
        editPersonalDataButton.shouldBe(visible).click();
        sleep(2000);
        return new PersonalDataPage();
    }

    public boolean compareTwoCityOfResident(String city){
       return cityOfResidenceStatus.shouldBe(visible).getText().contains(city);
    }

    public boolean compareTwoHometown(String hometown){
        return hometownStatus.shouldBe(visible).getText().contains(hometown);
    }

    public boolean compareMartialStatus(String status){
        return MartialStatus.shouldBe(visible).getText().contains(status);
    }

}
