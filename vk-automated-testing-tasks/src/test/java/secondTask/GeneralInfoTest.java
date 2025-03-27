package secondTask;

import org.example.selenide.pages.main.FeedPage;
import org.example.selenide.pages.main.GeneralInfoPage;
import org.example.selenide.pages.main.LoginPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class GeneralInfoTest extends BaseTest{
    private static final String MartialStatus = "Разведён";
    private static final String CityOfResident = "Санкт-Петербург";
    private static final String Hometown = "Минск";

    @BeforeAll
    public static void login() {
        new LoginPage()
                .enterEmail(EMAIL)
                .enterPassword(PASSWORD)
                .clickSubmit();
    }

    @Test
    public void testMusicPlay() {
        GeneralInfoPage generalInfoPage = new FeedPage()
                .openMyProfilePage()
                .clickGeneralMenu()
                .clickMaritalStatusButton()
                .clickSelectMartialStatusButton()
                .clickEditPersonalDataButton()
                .clickCityOfResidenceField()
                .entryCityOfResidenceField(CityOfResident)
                .slectCity()
                .clickHometownField()
                .entryHometownField(Hometown)
                .slectCity()
                .saveChanges();

        assertTrue(generalInfoPage.compareMartialStatus(MartialStatus), "Семейное положение не было изменено"
        );
        assertTrue(generalInfoPage.compareTwoCityOfResident(CityOfResident), "Город проживания не был изменен"
        );
        assertTrue(generalInfoPage.compareTwoHometown(Hometown), "Место рождения не было изменено"
        );
    }
}
