package counter;

import java.util.Map;
import java.util.HashMap;

public class MemoryCounter implements Counter{

    private Map<String, Integer> greetMap = new HashMap<>();

    public boolean countUser(String userName) {
        if (greetMap.containsKey(userName)) {
            return updateCount(userName);
        }

        greetMap.put(userName, 1);
        return true;
    }

    public int totalGreetCount() {
        return this.greetMap.size();
    }

    public int userGreetCount(String userName) {
        try {
            return greetMap.get(userName);
        } catch (NullPointerException e) {
            System.out.println("Error! User " + userName + " does not exist.");
        }
        return 0;
    }

    public boolean clearAllUserCounts() {
        greetMap.clear();
        return true;
    }

    public boolean clearUserCount(String userName) {
        return clearUsers(userName);
    }

    private boolean clearUsers(String userName) {
        if (greetMap.containsKey(userName)) {
            greetMap.remove(userName);
            return true;
        }
        return false;
    }

    private boolean updateCount(String userName) {
        greetMap.put(userName, greetMap.get(userName) + 1);
        return true;
    }
}
