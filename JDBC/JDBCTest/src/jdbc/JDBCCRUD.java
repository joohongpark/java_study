package jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCCRUD {
    /*
    Connection conn = null;
    public JDBCInsertData(Connection conn) {
        this.conn = conn;
    }
     */
    static public int InsertData(String id, String name, int age) {
        Statement state = null;
        Connection conn = JDBCConnector.getConnection();
        int count = 0;
        String sql = " INSERT INTO USER_TEST(ID, NAME, AGE, JOINDATE)"
                + " VALUES('" + id + "', '" + name + "', " + age + ", SYSDATE)";

        System.out.println("[JDBC Insert] SQL Query : " + sql);
        try {
            state = conn.createStatement();
            count = state.executeUpdate(sql); // SQL Query 문 적용.
            System.out.println("[JDBC Insert] SQL Query Execute Success!");
        } catch (SQLException e) {
            count = -1;
            System.out.println("[JDBC Insert] DB Connection Fail!");
            e.printStackTrace();
        }
        JDBCConnector.JDBCClose(state, conn, null);

        return count;
    }

    static public int UpdateData(String id, int age) {
        Statement state = null;
        Connection conn = JDBCConnector.getConnection();
        int count = 0;
        String sql = " UPDATE USER_TEST " +
                " SET AGE = " + age + " " +
                " WHERE ID = '" + id + "' ";

        System.out.println("[JDBC Update] SQL Query : " + sql);
        try {
            state = conn.createStatement();
            count = state.executeUpdate(sql); // SQL Query 문 적용.
            System.out.println("[JDBC Update] SQL Query Execute Success!");
        } catch (SQLException e) {
            count = -1;
            System.out.println("[JDBC Update] DB Connection Fail!");
            e.printStackTrace();
        }
        JDBCConnector.JDBCClose(state, conn, null);

        return count;
    }

}