package net.greet.command;

public class CommandProcessor {

    private String[] inputArray;

    public void processCommand(String commandString) {
        this.inputArray = commandString.split(" ");
    }

    public String getCommand() {
        if (validateCommand(this.inputArray[0])) {
            return inputArray[0];
        }
        return "Invalid net.greet.command";
    }

    private boolean validateCommand(String commandIn) {
        for (Commands command : Commands.values()) {
            if (command.name().equals(commandIn.toUpperCase())) {
                return true;
            }
        }
        return false;
    }

    public String getName() {
        if (this.inputArray.length >= 2) {
            String name = inputArray[1];
            return name;
        }
        return null;
    }

    public String getLangauge() {
        if (this.inputArray.length == 3) {
            return this.inputArray[2];
        }
        return null;
    }

}

