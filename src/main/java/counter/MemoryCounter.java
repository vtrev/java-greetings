package counter;

import java.util.Map;
import java.util.HashMap;

public class MemoryCounter {

    private Map<String, Integer> greetMap = new HashMap<>();

    public void addUser(String userName) {
        updateCount(userName);

    }

    public int getCount() {
        return this.greetMap.size();
    }

    public int getCount(String userName) {
        try {
            return greetMap.get(userName);
        } catch (NullPointerException e) {
            System.out.println("Error! User " + userName + " does not exist.");
        }
        return 0;
    }

    public String clear() {
        greetMap.clear();
        return "All users have been cleared successfully";
    }

    public String clear(String userName) {
        return clearUsers(userName);
    }

    private String clearUsers(String userName) {
        if (greetMap.containsKey(userName)) {
            greetMap.remove(userName);
            return "User " + userName + " has been removed successfully";
        }
        return "Error! User " + userName + " does not exist";
    }

    private void updateCount(String userName) {
        if (greetMap.containsKey(userName)) {
            greetMap.put(userName, greetMap.get(userName) + 1);
        } else {
            greetMap.put(userName, 1);
        }
    }
}
