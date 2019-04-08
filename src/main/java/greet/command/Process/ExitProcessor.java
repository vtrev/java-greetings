package greet.command.Process;

import greet.command.Command;
import greet.command.ProcessCommand;

public class ExitProcessor implements ProcessCommand {
    @Override
    public String process(Command command) {
        return "Thanks for using the app,goodbye!";
    }
}
