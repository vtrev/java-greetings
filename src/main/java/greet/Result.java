package greet;

public class Result {
    private  String res;
    private boolean menuState;

    public Result(String res,boolean menuState){
        this.res = res;
        this.menuState = menuState;
    }

    //getters
    public String getResult(){
        return this.res;
    }

    public boolean getMenuState(){
        return this.menuState;
    }
}
