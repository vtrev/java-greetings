import greet.Greeter;
import greet.Language;

public class CommandProcessor {
    private String[] inputArray;
    private Greeter greeter;
    //private Counter counter;


    public CommandProcessor(Greeter greeter) {
        this.greeter = greeter;
       // this.counter = counter;
    }


    public void proccessInput(String userInput){
        this.inputArray = userInput.split(" ");
        if(validateCommand(this.inputArray[0])){
            switch (this.inputArray[0]){
                case("greet"):
                    //System.out.println(getArg1(inputArray));
                     System.out.println(greeter.greet(getArg1(inputArray),  getLangValue(getArg2(inputArray))));
                   case ("counter"):
                    //return "Now counting";
                //goto the counter
                //System.out.println(counter()+" Users have been greeted on this app.");
//                System.out.println("Count");
                case("clear"):
                    //go to clear code
                    System.out.println("clear");
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
                    System.out.println("Error : Invalid command.");
            }





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
        System.out.println(arrayIn.length);
        if(arrayIn.length >= 2){
        return  arrayIn[1];
        }
        System.out.println("Returning null");
        return null;
    }

    private  String getArg2(String[] arrayIn){
        if(arrayIn.length == 3){
            return  arrayIn[2];
        }

        return null;
    }
}
