package secondTask;

import org.junit.jupiter.api.*;
import org.example.selenide.pages.main.FeedPage;
import org.example.selenide.pages.main.GroupPage;
import org.example.selenide.pages.login.LoginPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class GroupCreationTest extends BaseTest {
    private static final String GROUP_NAME = "testGroup";

    @BeforeAll
    public static void login() {
        new LoginPage()
                .enterEmail(EMAIL)
                .enterPassword(PASSWORD)
                .clickSubmit();
    }

    @Test
    public void testGroupCreation() {
        GroupPage groupPage = new FeedPage()
                .openGroupsPage()
                .clickCreateGroup()
                .clickGroupByInterest()
                .enterGroupName(GROUP_NAME)
                .expandThematicsList()
                .clickAutoThematic()
                .clickCreate();
        assertTrue(groupPage.checkGroupNameEquals(GROUP_NAME),
                "The group was created incorrectly."
        );
    }

    @AfterAll
    public static void deleteGroup() {
        new GroupPage()
                .clickMoreActions()
                .clickDelete()
                .confirmDeletion();
    }
}
