//import greet.Greet;
//import greet.Language;
//
//import java.util.HashMap;
//
//public  class  Action{
//    private boolean showMenu = true;
//    public String name;
//    public Language lang;
//    private String[] commandArray;
//    private String userInput;
//    int userCount;
//    HashMap<String, Integer> userMap = new HashMap<String, Integer>();
//
//
//
//    public boolean commandInit(String userInput) {
//        //get command and parameters, seperate greeting logic from commands/menu
//        this.userInput = userInput;
//        this.commandArray = userInput.split(" ");
//        if(commandArray.length > 1){
//            this.name = commandArray[1];
//            if(commandArray.length > 2){
//                this.lang = Language.valueOf(commandArray[2].toUpperCase());
//            }
//        }
//        getCommand();
//        return showMenu;
//    }
//
//    public void getCommand(){
//        if(this.commandArray.length <= 3){
//        switch (this.commandArray[0]){
//            case("greet"):
//                if(this.commandArray.length == 2){
//                    System.out.println(greet());
//                }else {
//                    System.out.println(greet());
//                }
//                break;
//            case ("counter"):
//                //goto the counter
//                System.out.println(counter()+" Users have been greeted on this app.");
////                System.out.println("Count");
//                break;
//            case("clear"):
//                //go to clear code
//                System.out.println("clear");
//            case("help"):
//                //show help
//                System.out.println("Help");
//                break;
//            case "exit":
//                this.showMenu = false;
//                System.out.println("Goodbye!");
//                break;
////                System.out.println("Exit app");
//                //quit the app
//            default:
//                System.out.println("Error : Invalid command.");
//            }
//        }else {
//            System.out.println("Error : Invalid command.");
//
//        }
//    }
//
//    void   updateCount(String name) {
//        if(userMap.containsKey(name)){
//            userMap.put(name,userMap.get(name)+1);
//        }else {
//            userMap.put(name,1);
//        }
//    }
//
//
//
//
//}