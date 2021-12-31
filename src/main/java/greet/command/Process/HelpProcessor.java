package greet.command.Process;

import greet.Languages;
import greet.command.Command;
import greet.command.ProcessCommand;

import java.util.Arrays;

public class HelpProcessor implements ProcessCommand {

    @Override
    public String process(Command command) {
        String helpText = "Greetings Console App Help Page \n General Commands : [greet,greeted,clear,help,exit]. \n Synopses \n" +
                "1. greet [username] [option] - Returns a greet on the screen. \n " +
                "\t Username(required) : The name of user to greet. \n " +
                "\t Option : A language in which the user will be greeted in .\n" +
                "\t\t Available languages " + Arrays.toString(Languages.values()).replace("EMPTY, ","").replace("UNKNOWN, ","")+
                "\n 2. greeted [option] - Returns the number of times a user has been greeted. \n " +
                "\t Option : The name of the user to get count for. \n"  +
                "3. clear [option] - Removes the count from database. \n" +
                " \t Option : The name of the user to clear,clears every user if no option is given .\n"  +
                "4. help - Prints out current screen. \n" +
                "5. exit - Exits the app. \n";
        return helpText;
    }
}
