package counter;

import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class DatabaseCounterTest {

    @Test
    void shouldAddUserToTheDatabase() {
        DatabaseCounter databaseCounter = new DatabaseCounter();
        try {
            assertEquals(databaseCounter.addUser("Vusi"),"Added Vusi to the db successfully");
            assertEquals(databaseCounter.addUser("Joe"),"Added Joe to the db successfully");
            assertEquals(databaseCounter.addUser("Mango"),"Added Joe to the db successfully");
            //databaseCounter.addUser("John");
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e);
        }
    }

    @Test
    void shouldGetCountForAllUsers(){
        DatabaseCounter databaseCounter = new DatabaseCounter();
        try {
            assertEquals(databaseCounter.getCount(),2);
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e);
        }
    }

    @Test
    void shouldGetCountForCertainUser(){
        DatabaseCounter databaseCounter = new DatabaseCounter();
        try {
            assertEquals(databaseCounter.getCount("Mango"),1);
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e);
        }
    }



}