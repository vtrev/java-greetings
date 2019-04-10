package greet.counter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DatabaseCounterTest {
    DatabaseCounterTest() throws SQLException {
    }

    private Connection dbConnection = DriverManager.getConnection("jdbc:h2:file:./database/greetings", "sa", "");

    @BeforeEach
    void clearDatabase(){
        DatabaseCounter databaseCounter = new DatabaseCounter(dbConnection);
        databaseCounter.clearAllUserCounts();
    }

    @Test
    void shouldCountUserIntoTheDatabase(){
        DatabaseCounter databaseCounter = new DatabaseCounter(dbConnection);

            databaseCounter.countUser("Vusi");
            databaseCounter.countUser("Vusi");
            databaseCounter.countUser("Vusi");
            assertEquals(databaseCounter.userGreetCount("Vusi"), 3);
    }

    @Test
    void shouldGetCountForAllUsers() {
        DatabaseCounter databaseCounter = new DatabaseCounter(dbConnection);
        databaseCounter.countUser("Yegan");
        databaseCounter.countUser("Joe");
        databaseCounter.countUser("Mikey");
        assertEquals(databaseCounter.totalGreetCount(), 3);
    }

    @Test
    void shouldClearAllUsersFromDatabaseAndReturnTrue() {
        DatabaseCounter databaseCounter = new DatabaseCounter(dbConnection);

            databaseCounter.countUser("Bekz");
            databaseCounter.countUser("Rangi");
            databaseCounter.countUser("Joey");
            //count = 3 before clear
            assertEquals(databaseCounter.totalGreetCount(), 3);
            assertEquals(databaseCounter.clearAllUserCounts(), true);
            //count = 0 after clear
            assertEquals(databaseCounter.totalGreetCount(), 0);
    }

    @Test
    void shouldClearUserForSpecificUser(){
            DatabaseCounter databaseCounter = new DatabaseCounter(dbConnection);
            databaseCounter.countUser("Bekz");
            databaseCounter.countUser("Rangi");
            databaseCounter.countUser("Joey");

            assertEquals(databaseCounter.clearUserCount("Bekz"),true);
            //non- existing user should be false
            assertEquals(databaseCounter.clearUserCount("Vusi"),false);
    }

}