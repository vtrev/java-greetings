package net.greet;

import net.greet.command.CommandProcessor;
import net.greet.counter.Counter;

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

    public void greet()throws SQLException{
        if (commandProcessor.getName() == null) {
            System.out.println("Please add your name after the greet command.");
            return;
        }
        System.out.println(greeter.greet(commandProcessor.getName(),commandProcessor.getLangauge()));
    }

    public void count() throws SQLException {
        if (commandProcessor.getName() != null) {
            System.out.println("User " + commandProcessor.getName() + " has been greeted " + counter.userGreetCount(commandProcessor.getName()) + " times.");
        }
        System.out.println("Total number of users greeted : " + counter.totalGreetCount());
    }

    public void clear() throws SQLException{
        if (commandProcessor.getName() != null) {
            if(counter.clearUserCount(commandProcessor.getName())){
                System.out.println("User: "+ commandProcessor.getName()+" cleared successful");
            }
        }else if (counter.clearAllUserCounts()){
                System.out.println("All users cleared successful");
        }else {
           System.out.println("Error while clearing");
        }
    }
    public void getHelp(){
        System.out.println("Greetings Console App Help Page \n General Commands : [greet,greeted,clear,help,exit]. \n Synopses \n" +
                "1. greet [username] [option] - Returns a greeting on the screen. \n " +
                "\t Username(required) : The name of user to greet. \n " +
                "\t Option : A language in which the user will be greeted in .\n" +
                "2. greeted [option] - Returns the number of times a user has been greeted. \n " +
                "\t Option : The name of the user to get count for. \n"  +
                "3. clear [option] - Removes the count from database. \n" +
                " \t Option : The name of the user to clear,clears every user if no option is given .\n"  +
                "4. help - Prints out current screen. \n" +
                "5. exit - Exits the app. \n");
    }
//    public String displayResult(Function <f>){
//        return
//    }
}
