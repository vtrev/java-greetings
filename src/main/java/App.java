import command.CommandProcessor;
import counter.DatabaseCounter;
import counter.MemoryCounter;

import java.sql.SQLException;
import java.util.Scanner;

public class App {
    public static void main(String[] args)throws SQLException {
        boolean showMenu = true;
        Scanner scanner = new Scanner(System.in);
        Greeter greeter = new Greeter();
        MemoryCounter memoryCounter = new MemoryCounter();
        DatabaseCounter databaseCounter = new DatabaseCounter();
        CommandProcessor commandProcessor = new CommandProcessor();
        InputProcessor cpu = new InputProcessor(greeter, databaseCounter,commandProcessor);

        System.out.println("Hello World! Welcome to the greeting app! :)");
        while(showMenu){
            System.out.println("Enter a command : ");
            showMenu =  cpu.processInput(scanner.nextLine());
        }
    }
}
