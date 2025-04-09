package secondTask;

import org.example.selenide.pages.main.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertTrue;


@Tag("Group test")
public class GroupTest extends BaseTest{
    private static final String GROUP_NAME = "group";
    private static final String THEMATIC = ("Автомобили");
    private MyGroupPage groupPage;
    private static GroupMainPage groupMainPage;

    @BeforeAll
    public static void login() {
        new LoginPage()
                .enterEmail(TestData.EMAIL)
                .enterPassword(TestData.PASSWORD)
                .clickSubmit();
        groupMainPage = new FeedPage()
                .clickGroupMenu();
    }


    @Tag("Group creation test")
    @DisplayName("Тест создания группы")
    @ParameterizedTest
    @ValueSource(strings = {"Автомобили", "Повар"})
    @Timeout(value = 14, unit = TimeUnit.SECONDS)
    public void testGroupCreation(String groupNameAndThematic) {
        MyGroupPage myGroupPage1 = groupMainPage
                .clickCreateGroupButton()
                .clickGroupTypeButton()
                .enterGroupNameButton(groupNameAndThematic)
                .enterThematicField(groupNameAndThematic)
                .selectThematic()
                .clickCreateButton()
                .clickBackGroupButton();

        assertTrue(myGroupPage1.isMyGroupExist(),
                "Группа не создана"
        );


    }

}
