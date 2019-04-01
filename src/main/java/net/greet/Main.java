package net.greet;

import net.greet.command.CommandProcessor;
import net.greet.counter.DatabaseCounter;
import net.greet.counter.MemoryCounter;

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
        System.out.println("Hello World! Welcome to the greeting app! :)");

        menu:
        while (true) {
            System.out.println("Enter a net.greet.command : ");
            cp.processCommand(scanner.nextLine());
            switch (cp.getCommand()) {
                case ("greet"):
                    System.out.println(action.greet());
                    break;
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
                    System.out.println("Greetings Console App Help Page \n General Commands : [greet,greeted,clear,help,exit]. \n Synopses \n" +
                            "1. greet [username] [option] - Returns a greeting on the screen. \n " +
                            "\t Username(required) : The name of user to greet. \n " +
                            "\t Option : A language in which the user will be greeted in .\n" +
                            "2. greeted [option] - Returns the number of times a user has been greeted. \n " +
                            "\t Option : The name of the user to get count for. \n"  +
                            "3. clear [option] - Removes the count from database. \n" +
                            " \t Option : The name of the user to clear,clears every user if no option is given .\n"  +
                            "4. help - Prints out current screen. \n" +
                            "5. exit - Exits the app. \n");
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

}
