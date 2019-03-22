import greet.Greeter;
import greet.Language;

public  class  Action{
    private boolean showMenu = true;
    private String command;
    private String name;
    private  String option;


    public Action(String command,String name,String option){

        this.command = command;
        this.name = name;
        this.option =option;
    }

    public String processCommand(){

        switch (command){
            case("greet"):
                Greeter greeter = new Greeter();
                return greeter.greet(this.name, Language.valueOf(this.option.toUpperCase()));
            case ("counter"):
                return "Now counting";
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
                this.showMenu = false;
                System.out.println("Goodbye!");
                break;
//                System.out.println("Exit app");
                //quit the app
            default:
                System.out.println("Error : Invalid command.");
            }
            return "default return";
    }

}