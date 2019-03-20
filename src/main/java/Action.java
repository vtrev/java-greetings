import greet.Greet;
import greet.Language;

import java.util.HashMap;

public abstract class  Action implements Greet {
    private boolean showMenu = true;
    String name;
    String[] commandArray;
    String userInput;
    int userCount;
    HashMap<String, Integer> userMap = new HashMap<String, Integer>();



    public boolean commandInit(String userInput) {
        this.userInput = userInput;
        this.commandArray = userInput.split(" ");
        if(commandArray.length > 1){
            this.name = commandArray[1];
        }
        getCommand();
        return showMenu;
    }

    public void getCommand(){
        if(this.commandArray.length <= 3){
        switch (this.commandArray[0]){
            case("greet"):
                if(this.commandArray.length == 2){
                    System.out.println(greet(commandArray[1], Language.ENGLISH));
                }else {
                    System.out.println(greet(commandArray[1], Language.valueOf(commandArray[2].toUpperCase())));
                }
                break;
            case ("counter"):
                //goto the counter
                System.out.println(counter()+" Users have been greeted on this app.");
//                System.out.println("Count");
                break;
            case("clear"):
                //go to clear code
                System.out.println("clear");
            case("help"):
                //show help
                System.out.println("Help");
                break;
            case "exit":
                this.showMenu = false;
                System.out.println("Goodbye!");
                break;
//                System.out.println("Exit app");
                //quit the app
            default:
                System.out.println("Error : Invalid command.");
            }
        }else {
            System.out.println("Error : Invalid command.");

        }
    }

    void   updateCount(String name) {
        if(userMap.containsKey(name)){
            userMap.put(name,userMap.get(name)+1);
        }else {
            userMap.put(name,1);
        }
    }




}