package greet;

import greet.command.Process.*;
import greet.command.ProcessCommand;
import greet.counter.DatabaseCounter;
import greet.counter.MemoryCounter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class  Main {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        MemoryCounter memoryCounter = new MemoryCounter();
        Connection dbConnection = DriverManager.getConnection("jdbc:h2:file:./database/greetings", "sa", "");
        DatabaseCounter databaseCounter = new DatabaseCounter(dbConnection);

        Map<String, ProcessCommand> commandMap = new HashMap<>();
        commandMap.put("greet",new GreetProcessor(databaseCounter));
        commandMap.put("greeted",new CountProcessor(databaseCounter));
        commandMap.put("clear",new ClearProcessor(databaseCounter));
        commandMap.put("help",new HelpProcessor());
        commandMap.put("exit",new ExitProcessor());
        CommandProcessor commandProcessor = new CommandProcessor(commandMap);

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
