//package greet;
//
//import greet.command.Command;
//import greet.counter.DatabaseCounter;
//import greet.counter.MemoryCounter;
//import org.junit.jupiter.api.Test;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//class CommandProcessorTest {
//    Greeter greeter = new Greeter();
//    MemoryCounter memoryCounter = new MemoryCounter();
//    Connection dbConnection = DriverManager.getConnection("jdbc:h2:file:./database/greetings", "sa", "");
//    DatabaseCounter databaseCounter = new DatabaseCounter(dbConnection);
//    Command cp = new Command();
//    CommandProcessor commandProcessor = new CommandProcessor(cp, databaseCounter, greeter);
//
//    CommandProcessorTest() throws SQLException {
//    }
//
//
//    @Test
//    void greet() {
//        cp.processCommand("greet");
//
//    assertEquals(1,1);
//    }
//
//    @Test
//    void count() {
//    }
//
//    @Test
//    void clear() {
//    }
//
//    @Test
//    void getHelp() {
//    }
//}