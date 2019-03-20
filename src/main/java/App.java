import java.util.Scanner;

public class App {
    public static void main(String[] args){
        boolean menu = true;
        Greeting greeting = new Greeting();
        Scanner scanner = new Scanner(System.in);

        while (menu){
            System.out.println("Enter a command : ");
            String command = scanner.nextLine();
            menu = greeting.commandInit(command);
        }
    }
}
