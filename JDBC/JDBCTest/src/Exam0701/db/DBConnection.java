package Exam0701.db;

import java.sql.*;

public class DBConnection {
    public final static String URI = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
    public final static String ID = "hr";
    public final static String PW = "hr";
    public static void JDBCDriverCheck() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            System.out.println("[JDBC Connector] JDBC Driver Loading Success!");
        } catch (ClassNotFoundException e) {
            System.out.println("[JDBC Connector] JDBC Driver Loading Fail!");
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URI, ID, PW);
            System.out.println("[JDBC Connector] DB Connection Success!");
        } catch (SQLException e) {
            System.out.println("[JDBC Connector] DB Connection Fail!");
            e.printStackTrace();
        }
        return conn;
    }

    public static void JDBCClose(Statement state, Connection connection, ResultSet resultSet) {
        try {
            if(state != null) {
                state.close();
            }
            if(connection != null) {
                connection.close();
            }
            if(resultSet != null) {
                resultSet.close();
            }
        } catch (SQLException e) {
            System.out.println("[JDBC Connector] DB Close Fail!");
            e.printStackTrace();
        }
    }
}
