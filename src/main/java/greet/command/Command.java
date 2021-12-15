package greet.command;

import greet.Language;
import lombok.*;

@Getter
@Setter

public class Command {
    private String[] inputArray;
    private String name;
    private String command;
    private Language language;

    public Command(String commandString) {
        setInputArray(commandString.split(" "));
        setName();
        setLanguage();
        setCommand(inputArray[0]);
    }

    private void setName() {
        try{
            String tmpName = this.inputArray[1];
            this.name = tmpName.replace(tmpName.charAt(0), Character.toUpperCase(tmpName.charAt(0)));
        }catch(ArrayIndexOutOfBoundsException e){
            this.name = "User";
        }

    }

    void setCommand(String command) {
        this.command = validateCommand(command) ? command : "Invalid command";
    }

    public void setLanguage() {
        if (inputArray.length > 2 && validateLanguage(inputArray[2])) {
            this.language = Language.valueOf(inputArray[2].toUpperCase());
        } else {
//          Default to English
            this.language = Language.UNKNOWN;
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


