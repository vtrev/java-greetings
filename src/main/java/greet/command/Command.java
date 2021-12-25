package greet.command;

import greet.Language;
import lombok.*;

import java.util.Arrays;

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
            this.name = "";
        }

    }

    void setCommand(String command) {
        this.command = validateCommand(command) ? command : "Invalid command";
    }

    public void setLanguage() {
        if (inputArray.length > 2 && validateLanguage(inputArray[2])) {
            this.language = Language.valueOf(inputArray[2].toUpperCase());
        } else {
            this.language = Language.UNKNOWN;
        }
        if(inputArray.length < 3){
            this.language = Language.EMPTY;
        }
    }

    private boolean validateCommand(String commandIn) {
        return Arrays.stream(Commands.values()).anyMatch((command)-> command.name().equals(commandIn.toUpperCase()));
    }

    private boolean validateLanguage(String languageIn) {
        return Arrays.stream(Language.values()).anyMatch((language)-> language.name().equals(languageIn.toUpperCase()));}
    }



