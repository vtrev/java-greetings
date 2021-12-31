package greet.command;

import greet.Languages;
import lombok.*;
import java.util.Arrays;

@Getter
@Setter
public class Command {
    private String[] inputArray;
    private String name;
    private String command;
    private Languages languages;

    public Command(String commandString) {
        setInputArray(commandString.split(" "));
        setName();
        setLanguages();
        setCommand(inputArray[0]);
    }

    private void setName() {
        String tmpName = inputArray.length > 1 ? this.inputArray[1] : "";
        this.name = tmpName.isEmpty() ? "" : tmpName.replace(tmpName.charAt(0), Character.toUpperCase(tmpName.charAt(0)));
    }

    void setCommand(String command) {
        this.command = validateCommand(command) ? command : "Invalid command";
    }

    public void setLanguages() {
        if (inputArray.length > 2 && validateLanguage(inputArray[2])) {
            this.languages = Languages.valueOf(inputArray[2].toUpperCase());
        } else {
            this.languages = Languages.UNKNOWN;
        }
        if(inputArray.length < 3){
            this.languages = Languages.EMPTY;
        }
    }
    private boolean validateCommand(String commandIn) {
        return Arrays.stream(Commands.values()).anyMatch((command)-> command.name().equals(commandIn.toUpperCase()));
    }

    private boolean validateLanguage(String languageIn) {
        return Arrays.stream(Languages.values()).anyMatch((language)-> language.name().equals(languageIn.toUpperCase()));}
    }
