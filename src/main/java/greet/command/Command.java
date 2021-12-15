package greet.command;
public class Command {


    private String[] inputArray;
    private String name;
    private String command;


    public Command(String commandString){
        this.inputArray = commandString.split(" ");
        setName(inputArray);
    }

    private void setName(String[] inputArray) {

        try {
            String tmpName = inputArray[1].toLowerCase();
            this.name = tmpName.replace(tmpName.charAt(0), Character.toUpperCase(tmpName.charAt(0)));
        } catch (ArrayIndexOutOfBoundsException e) {
            this.name = null;
        }
    }


    //Refactor this shit
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
            return name;
    }

    public String getLanguage(){
        try{
            return this.inputArray[2];
        }catch(NullPointerException e){
            return null;
        }
    }

}


