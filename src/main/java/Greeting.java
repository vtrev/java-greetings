import greet.Language;

public class Greeting extends Action {

    @Override
    public String greet(String name,Language lang) {
    //default greeting
        if(lang != Language.ENGLISH ){
            updateCount(name);
            return lang.getGreeting() +" "+this.name + "!";
        }
        updateCount(name);
        return Language.ENGLISH.getGreeting()+" "+name;
    }

    @Override
    public  int counter(){
        return userMap.size();
    }

    @Override
    public String greeted() {
        return null;
    }


    @Override
    public void clear() {

    }
}
