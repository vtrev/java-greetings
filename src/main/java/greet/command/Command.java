package greet.command;

import lombok.*;


@Getter
@Setter
public class Command {


    private String[] inputArray;
    private String name;
    private String command;
    private String language;


    public Command(String commandString){
        this.inputArray = commandString.split(" ");
        setName();
        setCommand(inputArray[0]);
    }


    private void setName() {
        try {
                String tmpName = inputArray[1].toLowerCase();
                this.name = tmpName.replace(tmpName.charAt(0), Character.toUpperCase(tmpName.charAt(0)));
        } catch (ArrayIndexOutOfBoundsException e) {
                this.name = null;
        }
    }
    void setCommand(String command){
        this.command = validateCommand(command) ? command : "Invalid command";
    }

    private boolean validateCommand(String commandIn){
        for (Commands command : Commands.values()) {
            if (command.name().equals(commandIn.toUpperCase())) {
                return true;
            }
        }
        return false;
    }

    public void setLanguage(){
        try{
            this.language = inputArray[2];
        }catch(ArrayIndexOutOfBoundsException e){
            //default to English if on language is provided
            this.language = "English";
        }
    }

}


