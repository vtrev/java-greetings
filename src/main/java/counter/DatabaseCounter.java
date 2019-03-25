package counter;

import java.sql.*;


public class DatabaseCounter {


    public static void main(String[] args){
        try {
            Class.forName("org.h2.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        final String jdbcURL = "jdbc:h2:file:./database/greetings";
        try {
            Connection conn = DriverManager.getConnection(jdbcURL, "sa", "");
            PreparedStatement ps = conn.prepareStatement("select * from USERS");
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                System.out.println(rs.getString("column_name"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }












//
//    public void addUser(String userName) {
//        updateCount(userName);
//
//    }
//
//    public int getCount() {
//        return this.greetMap.size();
//    }
//
//    public int getCount(String userName) {
//        try {
//            return greetMap.get(userName);
//        } catch (NullPointerException e) {
//            System.out.println("Error! User " + userName + " does not exist.");
//        }
//        return 0;
//    }
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
