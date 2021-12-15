package greet.command;

import greet.Language;
import lombok.*;

@Getter
@Setter

public class Command {
    private String[] inputArray;
    private String name;
    private String command;
    private String language;

    public Command(String commandString) {
        setInputArray(commandString.split(" "));
        setName(inputArray[1]);
        setLanguage();
        setCommand(inputArray[0]);
    }

    private void setName(String tmpName) {
        this.name = tmpName.replace(tmpName.charAt(0), Character.toUpperCase(tmpName.charAt(0)));
    }

    void setCommand(String command) {
        this.command = validateCommand(command) ? command : "Invalid command";
    }

    public void setLanguage() {
        if (inputArray.length > 2 && validateLanguage(inputArray[2])) {
            this.language = inputArray[2];
        } else {
//          Default to English
            this.language = "English";
        }
    }

    private boolean validateCommand(String commandIn) {
        for (Commands command : Commands.values()) {
            if (command.name().equals(commandIn.toUpperCase())) {
                return true;
            }
        }
        return false;
    }

    private boolean validateLanguage(String languageIn) {
        for (Language language : Language.values()) {
            if (language.name().equals(languageIn.toUpperCase())) {
                return true;
            }
        }
        return false;
    }


}


