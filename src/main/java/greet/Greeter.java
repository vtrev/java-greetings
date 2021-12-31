package greet;

import greet.command.Command;

public class Greeter{

    public String greet(Command command){
         Languages languages = command.getLanguages();
         switch (languages){
             case ENGLISH:
                 return "Hello "+command.getName()+"!";
             case TSONGA:
                 return "Avuxeni "+command.getName()+"!";
             case AFRIKAANS:
                 return "Hallo "+command.getName()+"!";
             default:
                 return "Error!";
         }
    }
}



