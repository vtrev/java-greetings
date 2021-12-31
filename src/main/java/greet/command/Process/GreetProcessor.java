package greet.command.Process;

import greet.Greeter;
import greet.Languages;
import greet.command.Command;
import greet.command.ProcessCommand;
import greet.counter.Counter;

public class GreetProcessor implements ProcessCommand {
    private Counter counter;
    private Greeter greeter;

    public GreetProcessor(Counter counter) {
        this.counter = counter;
        this.greeter = new Greeter();
    }

    @Override
    public String process(Command command) {
        if (!command.getName().isEmpty()){
            if(command.getLanguages() != Languages.EMPTY & command.getLanguages() != Languages.UNKNOWN){
                String greeting = greeter.greet(command);
                counter.countUser(command.getName());
                return greeting;
            }
            return "Hi "+command.getName() +", please enter a valid language after your name, see help for available languages.";
        }
        return "Please provide your name after the greet command or see help for other options.";
    }
}