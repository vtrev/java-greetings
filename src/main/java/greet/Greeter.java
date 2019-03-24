package greet;

import java.util.HashMap;
import java.util.Map;

public class Greeter  {
    private Map<String,Integer> greetMap = new HashMap<>();

    public String greet(String userName){
       // updateCount(userName);
        return Language.ENGLISH.getGreeting()+" "+userName+" !";
    }
    public String greet(String userName,String langValue){


        ;
        //updateCount(userName);
        return Language.valueOf(langValue).getGreeting()+" "+userName+" !";
    }

}



