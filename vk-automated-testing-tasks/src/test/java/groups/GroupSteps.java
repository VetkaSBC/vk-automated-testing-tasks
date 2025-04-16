package groups;

import org.example.selenide.pages.main.FeedPage;
import org.example.selenide.pages.main.LoginPage;
import org.example.selenide.pages.main.groupsPage.GroupMainPage;
import org.example.selenide.pages.main.groupsPage.MyGroupPage;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static secondTask.TestData.EMAIL;
import static secondTask.TestData.PASSWORD;

public class GroupSteps {

    private GroupMainPage groupMainPage;
    private MyGroupPage myGroupPage;

    public void loginAndGoToGroupPage() {
        new LoginPage()
                .enterEmail(EMAIL)
                .enterPassword(PASSWORD)
                .clickSubmit();

        groupMainPage = new FeedPage()
                .clickGroupMenu();
    }

    public void createGroup(String groupNameAndThematic) {
        myGroupPage = groupMainPage
                .clickCreateGroupButton()
                .clickGroupTypeButton()
                .enterGroupNameButton(groupNameAndThematic)
                .enterThematicField(groupNameAndThematic)
                .selectThematic()
                .clickCreateButton()
                .clickBackGroupButton();
    }

    public void deleteGroup() {
        myGroupPage
                .clickOptionsButton()
                .clickDeleteOptionButton()
                .clickConfirmDeleteOptionButton();
    }

    public void assertGroupIsCreated() {
        assertTrue(myGroupPage.isMyGroupExist(), "Группа не создана");
    }
}