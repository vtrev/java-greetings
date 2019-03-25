import java.util.Map;
import java.util.HashMap;

class Counter {

    private Map<String, Integer> greetMap = new HashMap<>();

    void addUser(String userName) {
        updateCount(userName);

    }

    int getCount() {
        return this.greetMap.size();
    }

    int getCount(String userName) {
        try {
            return greetMap.get(userName);
        } catch (NullPointerException e) {
            System.out.println("Error! User " + userName + " does not exist.");
        }
        return 0;
    }

    String clear() {
        greetMap.clear();
        return "All users have been cleared successfully";
    }

    String clear(String userName) {
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
