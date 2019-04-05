package greet.command;
public class Command {

    private String[] inputArray;
    public Command(String commandString){
        this.inputArray = commandString.split(" ");
    }

    public String getCommand(){
        if (validateCommand(this.inputArray[0])){
            return inputArray[0];
        }
        return "Invalid command";
    }

    private boolean validateCommand(String commandIn){
        for (Commands command : Commands.values()) {
            if (command.name().equals(commandIn.toUpperCase())) {
                return true;
            }
        }
        return false;
    }

    public String getName(){
        if (this.inputArray.length >= 2) {
            String name = inputArray[1].toLowerCase();
            name = name.replace(name.charAt(0),Character.toUpperCase(name.charAt(0)));
            return name;
        }
        return null;
    }

    public String getLanguage(){
        if (this.inputArray.length == 3) {
            return this.inputArray[2];
        }
        return null;
    }

}


