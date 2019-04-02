package greet;

import greet.command.CommandProcessor;
import greet.counter.MemoryCounter;
import greet.counter.DatabaseCounter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        Greeter greeter = new Greeter();
        MemoryCounter memoryCounter = new MemoryCounter();
        Connection dbConnection = DriverManager.getConnection("jdbc:h2:file:./database/greetings", "sa", "");
        DatabaseCounter databaseCounter = new DatabaseCounter(dbConnection);
        CommandProcessor cp = new CommandProcessor();
        Action action = new Action(cp, databaseCounter, greeter);
        System.out.println("Hello World! Welcome to the greet app! :)");
        menu:
        while (true) {
            System.out.println("Enter a command : ");
            cp.processCommand(scanner.nextLine());
            switch (cp.getCommand()) {
                case ("greet"):
                    displayResult(action.greet());
                    break;
                case ("greeted"):
                   displayResult(action.count());
                    break;
                case ("clear"):
                    displayResult(action.clear());
                    break;
                case ("help"):
                    displayResult(action.getHelp());
                    break;
                case ("exit"):
                    System.out.println(" Thanks for using the app.Goodbye!");
                    dbConnection.close();
                    break menu;
                default:
                    System.out.println("Error! Invalid net.greet.command, please try again or type help for a valid  net.greet.command list.");
            }
        }
    }
    public static void displayResult(String result){
        System.out.println(result);
    }

}
