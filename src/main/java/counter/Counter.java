package counter;

import java.sql.SQLException;

public interface Counter {
    int getCount()throws SQLException;
    int getCount(String userName)throws SQLException;
    String clear()throws SQLException;
    String clear(String userName) throws SQLException;
    String addUser(String userName)throws SQLException;
}
