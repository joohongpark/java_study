package dao;

import db.DBConnection;
import dto.CoffeeDto;

import java.sql.*;

/**
 * Data Access Object For Coffee
 * DAO는 어디서든 접근하는 것이 유용하므로 싱글톤 클래스로 만듬
 */
public class CoffeeDao {
    private static CoffeeDao dao = null;

    private CoffeeDao() {

    }

    public static CoffeeDao getInstance() {
        if(dao == null) {
            dao = new CoffeeDao();
        }
        return dao;
    }

    public boolean addCoffee(CoffeeDto dto) {
        Boolean returnVal = false;
        Connection connection = null;
        PreparedStatement psmt = null;
        int result = 0;
        // Authorize Value = 3
        String sql = " INSERT INTO COFFEE_ORDER " +
                "(SEQ, ORDER_USERID, COFFEE_NAME, COFFEE_PAY, COFFEE_SYRUP, COFFEE_SIZE, COFFEE_SHOT, COFFEE_CREAM, COFFEE_AMOUNT) " +
                "VALUES(COFFEE_SEQENC.NEXTVAL,?,?,?,?,?,?,?,?) ";
        try {
            connection = DBConnection.getConnection();
            psmt = connection.prepareStatement(sql);
            //psmt.setInt(1, dto.getSeq());
            psmt.setString(1, dto.getOrderId());
            psmt.setString(2, dto.getMenuName());
            psmt.setInt(3, dto.getPay());
            psmt.setString(4, dto.getSyrup());
            psmt.setString(5, dto.getSize());
            psmt.setString(6, (dto.getAddShot() ? "T" : "F") );
            psmt.setString(7, (dto.getAddCream() ? "T" : "F") );
            psmt.setInt(8, dto.getAmount());
            result = psmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.JDBCClose(psmt, connection, null);
        }
        returnVal = result > 0;
        return returnVal;
    }

    private CoffeeDto[] getCoffeeByQuery(String sql) {
        System.out.println(sql);
        CoffeeDto[] returnVal = null;
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        int i = 0;
        try {
            connection = DBConnection.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            returnVal = new CoffeeDto[resultSet.getFetchSize()];
            while(resultSet.next()) {
                returnVal[i] = new CoffeeDto(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getInt(4),
                        resultSet.getString(5),
                        resultSet.getString(6),
                        resultSet.getString(7).equals("T"),
                        resultSet.getString(8).equals("T"),
                        resultSet.getInt(9));
                i++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.JDBCClose(statement, connection, resultSet);
        }
        return returnVal;
    }

    public CoffeeDto[] getCoffeeAll(String id) {
        String sql = " SELECT SEQ, ORDER_USERID, COFFEE_NAME, COFFEE_PAY, COFFEE_SYRUP, COFFEE_SIZE, COFFEE_SHOT, COFFEE_CREAM, COFFEE_AMOUNT " +
                "FROM COFFEE_ORDER WHERE ORDER_USERID = '" + id + "' ";
        return getCoffeeByQuery(sql);
    }
}
