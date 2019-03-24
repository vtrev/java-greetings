import greet.Greeter;
import java.util.Scanner;

public class App {
    public static void main(String[] args){
        boolean menu = true;

         Scanner scanner = new Scanner(System.in);
        Greeter greeter = new Greeter();
        Counter counter = new Counter();

        CommandProcessor cpu = new CommandProcessor(greeter,counter);



        while (menu){
            System.out.println("Enter a command : ");
            cpu.proccessInput(scanner.nextLine());

            // CommandProcessor processor = new CommandProcessor(scanner.nextLine());
           // Result result = CommandProcessor.processCommand(scanner.nextLine());

            //ResultPresenter.display(result);

            // Action action = new Action(processor.getCommand(), processor.getName(), processor.getOption());
            // System.out.println(action.processCommand());

        }
    }
}
