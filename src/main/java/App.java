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
        CommandProcessor cp = new CommandProcessor();
        Action action = new Action(cp,databaseCounter,greeter);
        System.out.println("Hello World! Welcome to the greeting app! :)");

        menu: while (true) {
            System.out.println("Enter a command : ");
            cp.processCommand(scanner.nextLine());
            switch (cp.getCommand()) {
                case ("greet"):
                    System.out.println(action.greet());
                    return;
                case ("greeted"):
                    System.out.println(action.count());
                    break;
                case ("clear"):
                    if (action.clear()) {
                        System.out.println("Clear successful");
                        break;
                    }
                    System.out.println("Error while clearing");
                    break;
                case ("help"):
                    System.out.println("Help");
                    break;
                case ("exit"):
                    System.out.println(" Thanks for using the app.Goodbye!");
                    dbConnection.close();
                    break menu;
                default:
                    System.out.println("Error! Invalid command, please try again or type help for a valid  command list.");
            }

        }

    }

}
