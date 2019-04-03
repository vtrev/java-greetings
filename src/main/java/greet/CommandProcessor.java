package greet;

import greet.command.Command;
import greet.command.Process.ClearProcessor;
import greet.command.Process.CountProcessor;
import greet.command.Process.GreetProcessor;
import greet.command.ProcessCommand;
import greet.counter.Counter;


public class CommandProcessor {

    private Counter counter;
    private Greeter greeter;

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
                return new Result(getHelp(),true) ;
            case ("exit"):
                return new Result("Thanks for using the app,goodbye",false);

            default:
                return  new Result("Error! Invalid net.greet.command, please try again or type help for a valid  net.greet.command list.",true);
        }

    }

    public String getHelp(){
        String helpText = "Greetings Console App Help Page \n General Commands : [greet,greeted,clear,help,exit]. \n Synopses \n" +
                "1. greet [username] [option] - Returns a greet on the screen. \n " +
                "\t Username(required) : The name of user to greet. \n " +
                "\t Option : A language in which the user will be greeted in .\n" +
                "2. greeted [option] - Returns the number of times a user has been greeted. \n " +
                "\t Option : The name of the user to get count for. \n"  +
                "3. clear [option] - Removes the count from database. \n" +
                " \t Option : The name of the user to clear,clears every user if no option is given .\n"  +
                "4. help - Prints out current screen. \n" +
                "5. exit - Exits the app. \n";
        return helpText;
    }

}


