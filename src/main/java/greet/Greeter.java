package greet;


public class Greeter  {

    public String greet(String userName){
        return Language.ENGLISH.getGreeting()+" "+userName+" !";
    }
    public String greet(String userName,String langValue){

        return Language.valueOf(langValue).getGreeting()+" "+userName+" !";
    }

}



