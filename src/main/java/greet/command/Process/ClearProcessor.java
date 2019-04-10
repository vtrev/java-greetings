package greet.command.Process;

import greet.Greeter;
import greet.command.Command;
import greet.command.ProcessCommand;
import greet.counter.Counter;

import java.sql.SQLException;

public class ClearProcessor implements ProcessCommand {

    private Counter counter;
    private Greeter greeter;

    public ClearProcessor(Counter counter, Greeter greeter){
        this.counter = counter;
        this.greeter = greeter;
    }

    @Override
    public String process(Command command) {
        try {

            if (command.getName() != null) {
                if(counter.clearUserCount(command.getName())){
                    return "User: "+ command.getName()+" cleared successfully";
                }
                    return "Error while clearing, user "+command.getName()+" does not exist";
            }
            if (counter.clearAllUserCounts()){
                return "All users cleared successfully";
            }
            return "Database error";

        }catch (SQLException e){
            e.printStackTrace();
            return "Database error";
        }
    }
}
