package greet.command.Process;

import greet.command.Command;
import greet.command.ProcessCommand;
import greet.counter.Counter;

public class ClearProcessor implements ProcessCommand {

    private Counter counter;
    public ClearProcessor(Counter counter){
        this.counter = counter;
    }

    @Override
    public String process(Command command) {
            if (!command.getName().isEmpty()) {
                if(counter.clearUserCount(command.getName())){
                    return "User: "+ command.getName()+" cleared successfully";
                }
                    return "Error while clearing, user "+command.getName()+" does not exist";
            }
            if (counter.clearAllUserCounts()){
                return "All users cleared successfully";
            }
            return "Database error";
    }
}
