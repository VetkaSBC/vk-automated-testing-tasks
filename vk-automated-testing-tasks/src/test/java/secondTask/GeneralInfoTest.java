package secondTask;

import org.example.selenide.pages.main.FeedPage;
import org.example.selenide.pages.main.GeneralInfoPage;
import org.example.selenide.pages.main.LoginPage;
import org.junit.jupiter.api.*;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Tag("Тест смены информации о себе")
public class GeneralInfoTest extends BaseTest{
    private static final String MartialStatus = "Разведён";
    private static final String CityOfResident = "Санкт-Петербург";
    private static final String Hometown = "Минск";

    @BeforeAll
    public static void login() {
        new LoginPage()
                .enterEmail(TestData.EMAIL)
                .enterPassword(TestData.PASSWORD)
                .clickSubmit();
    }

    @Tag("Test change MartialStatus, CityOfResident and Hometown")
    @DisplayName("Тест по смене города проживания и родного города в разделе 'Вся информация'")
    @Test
    @Timeout(value = 18, unit = TimeUnit.SECONDS)
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

        assertAll(
                () -> assertTrue(generalInfoPage.compareMartialStatus(MartialStatus), "Семейное положение не было изменено"),
                () -> assertTrue(generalInfoPage.compareTwoCityOfResident(CityOfResident), "Город проживания не был изменен"),
                () -> assertTrue(generalInfoPage.compareTwoHometown(Hometown), "Место рождения не было изменено")
        );
    }
}
