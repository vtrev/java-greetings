
 class CommandProcessor {
    private String[] inputArray;
    private Greeter greeter;
    private Counter counter;


     CommandProcessor(Greeter greeter, Counter counter) {
        this.greeter = greeter;
        this.counter = counter;
    }

     boolean processInput(String userInput){
        generateCommandArray(userInput);
            switch (this.inputArray[0]){
                case("greet"):
                    if(inputArray.length ==1){
                       return displayResult("Please add your name after the greet command.",true);
                    }
                    displayResult( greeter.greet(getArg1(inputArray),  getLang(getArg2(inputArray))),true);
                    counter.addUser(getArg1(inputArray));
                    break;
                case ("greeted" ):
                    if(inputArray.length > 1){
                        return displayResult("User "+getArg1(inputArray) + " has been greeted "+ counter.getCount(getArg1(inputArray)) +" times.",true);
                    }
                    displayResult("Total number of users greeted : "+counter.getCount(),true);
                    break;
                case("clear"):
                    if(inputArray.length > 1) {
                       return displayResult(counter.clear(getArg1(inputArray)), true);
                    }
                    displayResult(counter.clear(),true);
                    break;
                case("help"):
                    System.out.println("Help");
                    break;
                case ("exit"):
                    return displayResult ("Goodbye!",false);
                default:
                    displayResult("Error! Invalid command, please try again or type help for a valid  command list.",true);
                    break;
            }
        return true;
    }

    private  void generateCommandArray(String commandString){
        this.inputArray = commandString.split(" ");
    }

    private Language getLang(String langString){
        try {
            return Language.valueOf(langString.toUpperCase());
        }
        catch (NullPointerException e){
            //return default language
            return Language.ENGLISH;
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

    private boolean displayResult(String result,boolean menu){
        System.out.println(result +"\n");
        return menu;
    }
}
