import greet.Language;

public class Greeting extends Action {

    @Override
    public String greet() {
        updateCount(this.name);

        //default greeting
        if(lang != Language.ENGLISH ){
            return lang.getGreeting() +" "+this.name + "!";
        }
        return Language.ENGLISH.getGreeting()+" "+name+"!";
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
