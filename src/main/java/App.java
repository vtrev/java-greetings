import command.CommandProcessor;
import counter.MemoryCounter;

import java.util.Scanner;

public class App {
    public static void main(String[] args){
        boolean showMenu = true;
        Scanner scanner = new Scanner(System.in);
        Greeter greeter = new Greeter();
        MemoryCounter memoryCounter = new MemoryCounter();
        CommandProcessor commandProcessor = new CommandProcessor();
        // counter.Counter counter = new CounterUsingJdbc();
        InputProcessor cpu = new InputProcessor(greeter, memoryCounter,commandProcessor);


        System.out.println("Hello World! Welcome to the greeting app! :)");
        while(showMenu){
            System.out.println("Enter a command : ");
            showMenu =  cpu.processInput(scanner.nextLine());
        }
    }
}
