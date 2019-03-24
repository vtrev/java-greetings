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
              menu =  cpu.processInput(scanner.nextLine());

        }
    }
}
