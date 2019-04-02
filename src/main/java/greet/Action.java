package greet;

import greet.command.CommandProcessor;
import greet.counter.Counter;

import java.sql.SQLException;

public class Action {

    private Counter counter;
    private CommandProcessor commandProcessor;
    private Greeter greeter;

    public Action(CommandProcessor commandProcessor, Counter counter, Greeter greeter){
        this.commandProcessor = commandProcessor;
        this.counter = counter;
        this.greeter = greeter;
    }

    public String greet()throws SQLException{
        if (commandProcessor.getName() == null) {
            return "Please add your name after the greet command.";
        }
        counter.countUser(commandProcessor.getName());
        return greeter.greet(commandProcessor.getName(),commandProcessor.getLangauge());
    }

    public String count() throws SQLException {
        if (commandProcessor.getName() != null) {
            return "User " + commandProcessor.getName() + " has been greeted " + counter.userGreetCount(commandProcessor.getName()) + " times.";
        }
        return "Total number of users greeted : " + counter.totalGreetCount();
    }

    public String clear() throws SQLException{
        if (commandProcessor.getName() != null) {
            if(counter.clearUserCount(commandProcessor.getName())){
                return "User: "+ commandProcessor.getName()+" cleared successfully";
            }
        }else if (counter.clearAllUserCounts()){
                return "All users cleared successfully";
        }
           return "Error while clearing";
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
