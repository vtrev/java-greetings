package counter;

import java.sql.*;


public class DatabaseCounter implements Counter{

    public Connection getDbConnection() throws SQLException {
        final String URL = "jdbc:h2:file:./database/greetings";
        java.sql.Connection connection = DriverManager.getConnection(URL, "sa", "");
        return connection;
    }


    public String addUser(String userName) throws SQLException {
        //check if name is in the database already
        String getUserSql = "SELECT 1 FROM USERS WHERE NAME = ?";
        PreparedStatement getUserStmt = getDbConnection().prepareStatement(getUserSql);
        getUserStmt.setString(1, userName);
        ResultSet resultSet = getUserStmt.executeQuery();
        //if in the db call update counter
        if (resultSet.next()) {
            return updateCount(userName);
        }
        //if not in db add the user with greet count one and check for success
        String addUserSql = "INSERT INTO USERS (NAME,GREET_COUNT) VALUES (?,?)";
        PreparedStatement addUserStmt = getDbConnection().prepareStatement(addUserSql);
        addUserStmt.setString(1, userName);
        addUserStmt.setInt(2, 1);
        int success = addUserStmt.executeUpdate();
        addUserStmt.close();
        if (success > 0) {
            return "Added " + userName + " to the db successfully";
        }
        return "User " + userName + " rejected";
    }


    public int getCount() throws SQLException {
        Statement statement = getDbConnection().createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT COUNT(*) FROM USERS");
        resultSet.next();
        int rowCount = resultSet.getInt(1);
        resultSet.close();
        getDbConnection().close();
        return rowCount;
    }

    public int getCount(String userName) throws SQLException {
        String getUserCountSql = "SELECT GREET_COUNT FROM USERS WHERE NAME = ?";
        PreparedStatement getUserCountStmt = getDbConnection().prepareStatement(getUserCountSql);
        getUserCountStmt.setString(1, userName);
        ResultSet resultSet = getUserCountStmt.executeQuery();
        int greetCount = 0;
        while (resultSet.next()) {
            return resultSet.getInt("GREET_COUNT");
        }
        System.out.println("Error! User " + userName + " does not exist.");
        return greetCount;

    }

    public String clear() throws SQLException {
        String removeUsersSql = "DELETE FROM USERS";
        PreparedStatement addUserStmt = getDbConnection().prepareStatement(removeUsersSql);
        int affectedRowCount = addUserStmt.executeUpdate();
        if (affectedRowCount > 0) {
            return "All users have been cleared successfully";
        }
        return "Failure";
    }

    public String clear(String userName) throws SQLException {
        String removeUserSql = "DELETE FROM USERS WHERE NAME = ?";
        PreparedStatement removeUserStmt = getDbConnection().prepareStatement(removeUserSql);
        removeUserStmt.setString(1, userName);
        int affectedRowCount = removeUserStmt.executeUpdate();
        if (affectedRowCount > 0) {
            return "User " + userName + " has been cleared successfully";
        }
        return "Error! User " + userName + " does not exist";
    }

    private String updateCount(String userName) throws SQLException {
        //prepare the update and select statements
        String updateCountSql = "UPDATE USERS SET GREET_COUNT = ? WHERE NAME = ?";
        PreparedStatement updateCountStmt = getDbConnection().prepareStatement(updateCountSql);
        String userGreetCountSql = "SELECT GREET_COUNT FROM USERS WHERE NAME = ?";
        PreparedStatement userGreetCountStmt = getDbConnection().prepareStatement(userGreetCountSql);
        userGreetCountStmt.setString(1, userName);

        //get the current greetCount
        ResultSet resultSet = userGreetCountStmt.executeQuery();
        int currentGreetCount = 0;
        while (resultSet.next()) {
            currentGreetCount = resultSet.getInt("GREET_COUNT");
        }
        //set new values to the update statements
        updateCountStmt.setInt(1, ++currentGreetCount);
        updateCountStmt.setString(2, userName);
        //execute the update and check for success
        int affectedRowCount = updateCountStmt.executeUpdate();
        if (affectedRowCount > 0) {
            return "User count for " + userName + " updated successfully";
        }
        return "User update" + userName + " rejected";
    }
}



