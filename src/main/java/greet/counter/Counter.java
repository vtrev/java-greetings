package greet.counter;
public interface Counter {
    boolean countUser(String userName);
    int userGreetCount(String userName);
    int totalGreetCount();
    boolean clearUserCount(String userName);
    boolean clearAllUserCounts();
}
