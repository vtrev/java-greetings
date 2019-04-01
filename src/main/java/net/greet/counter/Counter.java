package net.greet.counter;

import java.sql.SQLException;

public interface Counter {
    boolean countUser(String userName) throws SQLException;
    int userGreetCount(String userName) throws SQLException;
    int totalGreetCount() throws SQLException;
    boolean clearUserCount(String userName) throws SQLException;
    boolean clearAllUserCounts() throws SQLException;
}
