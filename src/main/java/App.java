import java.util.Scanner;

public class App {
    public static void main(String[] args){
        boolean showMenu = true;
        Scanner scanner = new Scanner(System.in);
        Greeter greeter = new Greeter();
        Counter counter = new Counter();
        CommandProcessor commandProcessor = new CommandProcessor();
        // Counter counter = new CounterUsingJdbc();
        InputProcessor cpu = new InputProcessor(greeter, counter,commandProcessor);


        System.out.println("Hello World! Welcome to the greeting app! :)");
        while(showMenu){
            System.out.println("Enter a command : ");
            showMenu =  cpu.processInput(scanner.nextLine());
        }
    }
}
