package greet;

import greet.command.Command;
import greet.command.Process.*;
import greet.command.ProcessCommand;
import greet.counter.Counter;

import java.util.HashMap;
import java.util.Map;


public class CommandProcessor {

    private Counter counter;
    private Greeter greeter;
    private Map<String,Command> commandMap = new HashMap<>();

    public CommandProcessor(Counter counter, Greeter greeter){
        this.counter = counter;
        this.greeter = greeter;
    }


    public Result process(String commandString){
        Command command = new Command(commandString);

        switch (command.getCommand()) {
            case ("greet"):
                ProcessCommand processGreeting = new GreetProcessor(counter, greeter);
                return new Result(processGreeting.process(command),true) ;
            case ("greeted"):
                ProcessCommand processCount = new CountProcessor(counter,greeter);
                return new Result(processCount.process(command),true) ;
            case ("clear"):
                ProcessCommand processClear = new ClearProcessor(counter,greeter);
                return  new Result(processClear.process(command),true) ;
            case ("help"):
                ProcessCommand processHelp = new HelpProcessor();
                return new Result(processHelp.process(command),true) ;
            case ("exit"):
            ProcessCommand processExit = new ExitProcessor();
            return new Result(processExit.process(command),false);
            default:
                return  new Result("Error! Invalid net.greet.command, please try again or type help for a valid  net.greet.command list.",true);
        }

    }

}


