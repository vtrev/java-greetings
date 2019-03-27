import command.CommandProcessor;
import counter.*;

import java.sql.SQLException;

public class Action {

    Counter counter;
    CommandProcessor commandProcessor;
    Greeter greeter;

    public Action(CommandProcessor commandProcessor,Counter counter,Greeter greeter){
        this.commandProcessor = commandProcessor;
        this.counter = counter;
        this.greeter = greeter;
    }

    public String greet()throws SQLException{
        if (commandProcessor.getName() == null) {
            return "Please add your name after the greet command.";
        }
        return greeter.greet(commandProcessor.getName(),commandProcessor.getLangauge());
    }

    public String count() throws SQLException {
        if (commandProcessor.getName() != null) {
            return "User " + commandProcessor.getName() + " has been greeted " + counter.userGreetCount(commandProcessor.getName()) + " times.";
        }
        return  "Total number of users greeted : " + counter.totalGreetCount();
    }

    public boolean clear() throws SQLException{
        if (commandProcessor.getName() != null) {
            return counter.clearUserCount(commandProcessor.getName());
        }
        return  counter.clearAllUserCounts();
    }
}
