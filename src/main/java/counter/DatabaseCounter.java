package counter;

import java.sql.*;


public class DatabaseCounter {
    public Connection getDbConnection() throws ClassNotFoundException, SQLException {
        final String URL = "jdbc:h2:file:./database/greetings";
        Class.forName("org.h2.Driver");
        java.sql.Connection connection = DriverManager.getConnection(URL, "sa", "");
        return connection;
    }


    public String addUser(String userName)throws ClassNotFoundException, SQLException {
        String addUserSql = "INSERT INTO USERS (ID,NAME,GREET_COUNT) VALUES (?,?,?)";
        PreparedStatement addUserStmt = getDbConnection().prepareStatement(addUserSql);
        addUserStmt.setInt(1,1);
        addUserStmt.setString(2,userName);
        addUserStmt.setInt(3,14);
        int success = addUserStmt.executeUpdate();
        addUserStmt.close();
        System.out.println("Success int : "+success);
        if(success > 0){
            return "Added "+userName+" to the db successfully";
        }
        return "User "+userName+" rejected";
 }

    public int getCount()throws ClassNotFoundException, SQLException {
        Statement statement = getDbConnection().createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM USERS");
        resultSet = statement.executeQuery("SELECT COUNT(*) FROM USERS");
        resultSet.next();
        int rowCount = resultSet.getInt(1);
        resultSet.close();
        getDbConnection().close();
        return rowCount;
    }

    public int getCount(String userName)throws ClassNotFoundException, SQLException {
        String getUserCountSql = "SELECT * FROM USERS WHERE NAME = ?";
        PreparedStatement getUserCountStmt = getDbConnection().prepareStatement(getUserCountSql);
        getUserCountStmt.setString(1,userName);
        ResultSet resultSet = getUserCountStmt.executeQuery();
        int greetCount = 0;
        while (resultSet.next()) {
            return resultSet.getInt("GREET_COUNT");
        }
        return greetCount;

    }
//
//    public String clear() {
//        greetMap.clear();
//        return "All users have been cleared successfully";
//    }
//
//    public String clear(String userName) {
//        return clearUsers(userName);
//    }
//
//    private String clearUsers(String userName) {
//        if (greetMap.containsKey(userName)) {
//            greetMap.remove(userName);
//            return "User " + userName + " has been removed successfully";
//        }
//        return "Error! User " + userName + " does not exist";
//    }
//
//    private void updateCount(String userName) {
//        if (greetMap.containsKey(userName)) {
//            greetMap.put(userName, greetMap.get(userName) + 1);
//        } else {
//            greetMap.put(userName, 1);
//        }
//    }

}
