package counter;

import java.util.Map;
import java.util.HashMap;

public class Counter {

    private Map<String,Integer> greetMap = new HashMap<>();


     public  void addUser(String userName){
        updateCount(userName);
    }

     public int getCount(){
        return this.greetMap.size();
    }

    public int getCount(String userName){
        try {
            //System.out.println(greetMap.get(userName));
            return greetMap.get(userName);
        }catch (NullPointerException e){
            System.out.println("Error! User " +userName+ " does not exist.");

        }
        return 0;
    }

    public String clear(){
       return clearUsers(null);
    }

    public String clear(String name){
       return clearUsers(name);
    }

    private String clearUsers(String name){
        if(greetMap.containsKey(name)){
            greetMap.remove(name);
            return "User "+name+" has been removed successfully";
        }
        greetMap.clear();
        return "All users have been cleared successfully";
    }

    private void updateCount(String name) {
        if (greetMap.containsKey(name)) {
            greetMap.put(name, greetMap.get(name) + 1);
        } else {
            greetMap.put(name, 1);
        }
    }
}
