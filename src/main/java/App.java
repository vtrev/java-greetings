import command.CommandProcessor;
import counter.DatabaseCounter;
import counter.MemoryCounter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws SQLException {

        Scanner scanner = new Scanner(System.in);
        Greeter greeter = new Greeter();
        MemoryCounter memoryCounter = new MemoryCounter();
        Connection dbConnection = DriverManager.getConnection("jdbc:h2:file:./database/greetings", "sa", "");
        DatabaseCounter databaseCounter = new DatabaseCounter(dbConnection);
        CommandProcessor commandProcessor = new CommandProcessor();
        InputProcessor cpu = new InputProcessor(greeter, databaseCounter, commandProcessor);

        System.out.println("Hello World! Welcome to the greeting app! :)");

        while (true) {
            System.out.println("Enter a command : ");
            boolean result = cpu.processInput(scanner.nextLine());
            if (result == false) {
                dbConnection.close();
                break;
            }
        }

    }
}
