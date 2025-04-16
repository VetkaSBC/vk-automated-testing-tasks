package groups;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import secondTask.BaseTest;

import java.util.concurrent.TimeUnit;

@Tag("Group_test")
public class GroupTest extends BaseTest {
    private static final GroupSteps groupSteps = new GroupSteps();

    @BeforeAll
    public static void setUp() {
        BaseTest.setUp();
        groupSteps.loginAndGoToGroupPage();
    }

    @Tag("Group_creation_test")
    @DisplayName("Тест создания группы")
    @ParameterizedTest
    @ValueSource(strings = {"Автомобили", "Повар"})
    @Timeout(value = 14, unit = TimeUnit.SECONDS)
    public void testGroupCreation(String groupNameAndThematic) {
        groupSteps.createGroup(groupNameAndThematic);
        groupSteps.assertGroupIsCreated();
    }
}
