package greet;

import greet.command.Command;

public class Greeter{

    public String greet(Command command){
         Language language = command.getLanguage();
         switch (language){
             case ENGLISH:
                 return "Hello "+command.getName()+"!";
             case TSONGA:
                 return "Avuxeni "+command.getName()+"!";
             case AFRIKAANS:
                 return "Hallo "+command.getName()+"!";
             case UNKNOWN:
                 return "Hi "+command.getName()+" we do not support the above language right now, please see help for available languages.";
             case EMPTY:
                     return "Hi " + command.getName() + " please enter a language you'd like to be greeted in after your name.";
             default:
                 return "Error!";
         }
    }
    private Language getLang(String langString){
        try {
            return Language.valueOf(langString.toUpperCase());
        }
        catch (NullPointerException | IllegalArgumentException e){
            //return default language
            return Language.UNKNOWN;
        }
    }

}



