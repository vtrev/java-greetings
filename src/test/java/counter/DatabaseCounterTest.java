package counter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DatabaseCounterTest {

    @BeforeEach
    void clearDatabase(){
        DatabaseCounter databaseCounter = new DatabaseCounter();
        try{
            databaseCounter.clear();
            System.out.println("Cleaning up database before test...");
        }catch (SQLException e){
            System.out.println(e);
        }
    }

    @Test
    void shouldAddUserToTheDatabase() {
        DatabaseCounter databaseCounter = new DatabaseCounter();
        try {
            assertEquals(databaseCounter.addUser("Vusi"),"Added Vusi to the db successfully");
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    @Test
    void shouldGetCountForAllUsers(){
        DatabaseCounter databaseCounter = new DatabaseCounter();
        try {
            databaseCounter.addUser("Yegan");
            databaseCounter.addUser("Joe");
            databaseCounter.addUser("Mikey");
            assertEquals(databaseCounter.getCount(),3);
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    @Test
    void shouldGetCountForCertainUser(){
        DatabaseCounter databaseCounter = new DatabaseCounter();
        try {
            databaseCounter.addUser("John");
            assertEquals(databaseCounter.getCount("John"),1);
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    @Test
    void sholdClearAllUsersFromDatabase(){
        DatabaseCounter databaseCounter = new DatabaseCounter();
        try{
            databaseCounter.addUser("Bekz");
            databaseCounter.addUser("Rangi");
            databaseCounter.addUser("Joey");
            //count = 3 before clear
            assertEquals(databaseCounter.getCount(),3);
            assertEquals(databaseCounter.clear(),"All users have been cleared successfully");
            //count = 0 after clear
            assertEquals(databaseCounter.getCount(),0);
        }catch (SQLException e){
            System.out.println(e);
        }

    }
    @Test
    void shouldUpdateCountForExistingUsers(){
        DatabaseCounter databaseCounter = new DatabaseCounter();
        try{
            databaseCounter.addUser("Vusi");
            databaseCounter.addUser("Vusi");
            databaseCounter.addUser("Vusi");
            assertEquals(databaseCounter.getCount("Vusi"),3);
        }catch (SQLException e){
            System.out.println(e);
        }
    }
}