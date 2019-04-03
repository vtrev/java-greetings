package greet;

import greet.counter.DatabaseCounter;
import greet.counter.MemoryCounter;

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
        CommandProcessor commandProcessor = new CommandProcessor(databaseCounter, greeter);
        System.out.println("Hello World! Welcome to the greet app! :)");

        while (true) {
            System.out.println("Enter a command : ");
            Result result = commandProcessor.process(scanner.nextLine());
            System.out.println(result.getResult());
            if(!result.getMenuState()){
                dbConnection.close();
                break;
            }
        }
    }
}
