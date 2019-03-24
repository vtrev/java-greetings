import java.util.Map;
import java.util.HashMap;

public class Counter {

    private Map<String,Integer> greetMap = new HashMap<>();


    public void addUser(String userName){
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

    public void clear(){
        clear(null);
    }

    public void clear(String name){
        clearUsers(name);
    }

    public boolean userExists(String userName){
        return greetMap.containsKey(userName);
    }

    private void clearUsers(String name){
        if(greetMap.containsKey(name)){
            greetMap.remove(name);
            return;
        }
        greetMap.clear();
    }

    private void updateCount(String name) {
        if (greetMap.containsKey(name)) {
            greetMap.put(name, greetMap.get(name) + 1);
        } else {
            greetMap.put(name, 1);
        }
    }
}
