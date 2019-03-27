package counter;

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
    void clearDatabase() {
        DatabaseCounter databaseCounter = new DatabaseCounter(dbConnection);
        try {
            databaseCounter.clearAllUserCounts();
            System.out.println("Cleaning up database before test...");
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    @Test
    void shouldCountUserIntoTheDatabase() {
        DatabaseCounter databaseCounter = new DatabaseCounter(dbConnection);
        try {
            databaseCounter.countUser("Vusi");
            databaseCounter.countUser("Vusi");
            databaseCounter.countUser("Vusi");
            assertEquals(databaseCounter.userGreetCount("Vusi"), 3);
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    @Test
    void shouldGetCountForAllUsers() {
        DatabaseCounter databaseCounter = new DatabaseCounter(dbConnection);
        try {
            databaseCounter.countUser("Yegan");
            databaseCounter.countUser("Joe");
            databaseCounter.countUser("Mikey");
            assertEquals(databaseCounter.totalGreetCount(), 3);
        } catch (SQLException e) {
            System.out.println(e);
        }
    }


    @Test
    void sholdClearAllUsersFromDatabaseAndReturnTrue() {
        DatabaseCounter databaseCounter = new DatabaseCounter(dbConnection);
        try {
            databaseCounter.countUser("Bekz");
            databaseCounter.countUser("Rangi");
            databaseCounter.countUser("Joey");
            //count = 3 before clear
            assertEquals(databaseCounter.totalGreetCount(), 3);
            assertEquals(databaseCounter.clearAllUserCounts(), true);
            //count = 0 after clear
            assertEquals(databaseCounter.totalGreetCount(), 0);
        } catch (SQLException e) {
            System.out.println(e);
        }

    }

    @Test
    void shouldClearUserForSpecificUser() {
        DatabaseCounter databaseCounter = new DatabaseCounter(dbConnection);
        try {
            databaseCounter.countUser("Bekz");
            databaseCounter.countUser("Rangi");
            databaseCounter.countUser("Joey");
        }catch (SQLException e){
            System.out.println(e);
        }

    }

}