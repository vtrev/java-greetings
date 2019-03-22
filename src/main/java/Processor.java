public class Processor {
    private String[]commandArray;

    public Processor(String userCommand){
        this.commandArray = userCommand.split(" ");
    }

    private String validateCommand(String commandIn){
        for(Commands command:Commands.values()){
            if(command.name().equals(commandIn.toUpperCase())){
                return commandIn;
            }
        }
        return null;
    }

    private String getArg1(String[] args) {
        if (args.length >= 2) {
            return args[1];
        }
        return null;
    }

    private String getArg2(String[] args){

        if(args[0].equals("greet") && args.length == 3){
            return (args[2]);
        }
        if(args[0].equals("greet") && args.length == 2){
            return "English";
        }

        if(args.length == 2){
            return args[1];
        }

        if (args.length == 3){
            return args[2];
        }
        return null;
    }

    //getters

    public String getCommand(){
        return  this.validateCommand(commandArray[0]);
    }

    public String getName(){
        return this.getArg1(commandArray);
    }

    public String getOption(){
        return this.getArg2(commandArray);
    }

}
