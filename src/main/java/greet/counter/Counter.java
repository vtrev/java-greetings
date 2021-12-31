package greet.counter;
public interface Counter {
    boolean countUser(String userName);
    int getUserGreetCount(String userName);
    int getTotalGreetCount();
    boolean clearUserCount(String userName);
    boolean clearAllUserCounts();
}
