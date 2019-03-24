import greet.Greeter;
import greet.Language;

public class CommandProcessor {
    private String[] inputArray;
    private Greeter greeter;
    private Counter counter;


    public CommandProcessor(Greeter greeter,Counter counter) {
        this.greeter = greeter;
       this.counter = counter;
    }

    public void proccessInput(String userInput){
        generateCommandArray(userInput);
        if(validateCommand(this.inputArray[0])){
            switch (this.inputArray[0]){
                case("greet"):
                     diplayResult( greeter.greet(getArg1(inputArray),  getLangValue(getArg2(inputArray))));
                     counter.addUser(getArg1(inputArray));
                     break;
                   case ("greeted" ):
                       if(inputArray.length > 1){
                    diplayResult("User "+getArg1(inputArray) + " has been greeted "+ counter.getCount(getArg1(inputArray)) +" times.");
                       return;
                       }
                       diplayResult("Total number of users greeted : "+counter.getCount());
                    break;
                case("clear"):
                    //go to clear code
                    System.out.println("clear");
                    break;
                case("help"):
                    //show help
                    System.out.println("Help");
                    break;
                case ("exit"):
                    //this.showMenu = false;
                    System.out.println("Goodbye!");
                    break;
//                System.out.println("Exit app");
                //quit the app
                default:
                    System.out.println();
            }
        }else {
            diplayResult("Error! Invalid command.");
        }
    }

    private boolean validateCommand(String commandIn){
        for(Commands command:Commands.values()){
            if(command.name().equals(commandIn.toUpperCase())){
                return true;
            }
        }
            return false;
    }

    private  void generateCommandArray(String commandString){
        this.inputArray = commandString.split(" ");
    }

    private String getLangValue(String langString){
        try {
            return Language.valueOf(langString.toUpperCase()).toString();
        }catch (IllegalArgumentException e ){
           return Language.ENGLISH.name();
        }
        catch (NullPointerException e){
            return Language.ENGLISH.name();
        }
    }

    private String getArg1(String[] arrayIn){

        if(arrayIn.length >= 2){
        return  arrayIn[1];
        }
        return null;
    }

    private  String getArg2(String[] arrayIn){
        if(arrayIn.length == 3){
            return  arrayIn[2];
        }

        return null;
    }

    private void diplayResult(String result){
        System.out.println(result);
    }

}
