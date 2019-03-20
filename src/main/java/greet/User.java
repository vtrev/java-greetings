package greet;

public class User {

    private String name;
    private int count;


    public User(String nameIn){
        this.name = nameIn;
    }

    //getters
    public String getName() {
        return name;
    }

    public int getCount() {
        return count;
    }

}
