import sun.jvm.hotspot.CommandProcessor;

public class App {
    public static void main(String[] args){
        boolean menu = true;
        // Greeter greeting = new Greeter();
        // Scanner scanner = new Scanner(System.in);

        CommandProcessor commandProcessor = new CommandProcessor(greeter, counter);

        while (menu){
            System.out.println("Enter a command : ");
            // Processor processor = new Processor(scanner.nextLine());
            Result result = commandProcessor.processCommand(scanner.nextLine());

            ResultPresenter.display(result);

            // Action action = new Action(processor.getCommand(), processor.getName(), processor.getOption());
            // System.out.println(action.processCommand());

        }
    }
}
