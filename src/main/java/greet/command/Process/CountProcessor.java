package greet.command.Process;

import greet.Greeter;
import greet.command.Command;
import greet.command.ProcessCommand;
import greet.counter.Counter;

import java.sql.SQLException;

public class CountProcessor implements ProcessCommand {

    private Counter counter;
    private Greeter greeter;

    public CountProcessor(Counter counter, Greeter greeter){
        this.counter = counter;
        this.greeter = greeter;
    }

    @Override
    public String process(Command command) {
        try {
            if (command.getName() != null) {
                return "User " + command.getName() + " has been greeted " + counter.userGreetCount(command.getName()) + " times.";
            }
            return "Total number of users greeted : " + counter.totalGreetCount();
        }catch (SQLException e){
            e.printStackTrace();
            return "Database error";
        }

    }



}
