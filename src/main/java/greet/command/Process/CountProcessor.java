package greet.command.Process;

import greet.command.Command;
import greet.command.ProcessCommand;
import greet.counter.Counter;

public class CountProcessor implements ProcessCommand {

    private Counter counter;

    public CountProcessor(Counter counter){
        this.counter = counter;
    }

    @Override
    public String process(Command command) {
            if (command.getName() != null) {
                return "User " + command.getName() + " has been greeted " + counter.userGreetCount(command.getName()) + " times.";
            }
            return "Total number of users greeted : " + counter.totalGreetCount();
    }
}
