package greet;

import greet.command.Command;
import greet.command.ProcessCommand;
import java.util.Map;


public class CommandProcessor {
    private Map<String, ProcessCommand> commandMap;

    public CommandProcessor(Map<String, ProcessCommand> commandMap) {
        this.commandMap = commandMap;
    }

    public Result process(String commandString) {
        Command command = new Command(commandString);
        if (commandMap.containsKey(command.getCommand())) {
            ProcessCommand currentProcess = commandMap.get(command.getCommand());
            if (!command.getCommand().equals("exit")) {
                return new Result(currentProcess.process(command), true);
            }
            return new Result(currentProcess.process(command), false);
        }
        return new Result("Error! Invalid command, please try again or type help for a valid command list.", true);
    }

}




