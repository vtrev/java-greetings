package greet.command.Process;

import greet.Greeter;
import greet.command.Command;
import greet.command.ProcessCommand;
import greet.counter.Counter;
import java.sql.SQLException;

public class GreetProcessor implements ProcessCommand {
    private Counter counter;
    private Greeter greeter;

    public GreetProcessor(Counter counter, Greeter greeter){
        this.counter = counter;
        this.greeter = greeter;
    }

    @Override
    public String process(Command command) {
        if (command.getName() == null) {
            return "Please add your name after the greet command.";
        }
        try {
            counter.countUser(command.getName());
            return greeter.greet(command.getName(), command.getLangauge());
        }catch (SQLException e){
            e.printStackTrace();
            return  "Database error";
        }
    }
}