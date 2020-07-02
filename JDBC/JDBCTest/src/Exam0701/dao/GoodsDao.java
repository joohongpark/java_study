package Exam0701.dao;

import Exam0701.db.DBConnection;
import Exam0701.dto.GoodsDto;
import Exam0701.dto.MemberDto;

import java.sql.*;
import java.util.Date;

/**
 * DAO는 어디서든 접근하는 것이 유용하므로 싱글톤 클래스로 만듬
 */
public class GoodsDao {
    private static GoodsDao dao = null;

    private GoodsDao() {

    }

    public static GoodsDao getInstance() {
        if(dao == null) {
            dao = new GoodsDao();
        }
        return dao;
    }

    public boolean addGoods(GoodsDto dto) {
        Boolean returnVal = false;
        Connection connection = null;
        PreparedStatement psmt = null;
        int result = 0;
        // Authorize Value = 3
        String sql = " INSERT INTO ACCOUNTBOOK (SEQ, ID, IO_KIND, AMOUNT, CONTENT, WDATE) VALUES(SEQENC.NEXTVAL,?,?,?,?,SYSDATE) ";
        try {
            connection = DBConnection.getConnection();
            psmt = connection.prepareStatement(sql);
            psmt.setString(1, dto.getId());
            psmt.setString(2, dto.getIo_kind());
            psmt.setInt(3, dto.getAmount());
            psmt.setString(4, dto.getContent());
            result = psmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.JDBCClose(psmt, connection, null);
        }
        returnVal = result > 0;
        return returnVal;
    }

    public GoodsDto[] getGoodsById(String id) {
        String sql = " SELECT SEQ, ID, IO_KIND, AMOUNT, CONTENT, WDATE FROM ACCOUNTBOOK WHERE ID = '" + id + "' ";
        System.out.println(sql);
        GoodsDto[] returnVal = null;
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        int i = 0;
        try {
            connection = DBConnection.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            returnVal = new GoodsDto[resultSet.getFetchSize()];
            while(resultSet.next()) {
                returnVal[i] = new GoodsDto(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getInt(4),
                        resultSet.getString(5),
                        resultSet.getDate(6));
                i++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.JDBCClose(statement, connection, resultSet);
        }
        return returnVal;
    }

    public GoodsDto[] getGoodsByDataRange(String start, String end) {
        String sql = " SELECT SEQ, ID, IO_KIND, AMOUNT, CONTENT, WDATE FROM ACCOUNTBOOK " +
                " WHERE WDATE BETWEEN TO_DATE('" + start + "', 'YYMMDD') AND TO_DATE('" + end + "', 'YYMMDD')";
        System.out.println(sql);
        GoodsDto[] returnVal = null;
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        int i = 0;
        try {
            connection = DBConnection.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            returnVal = new GoodsDto[resultSet.getFetchSize()];
            while(resultSet.next()) {
                returnVal[i] = new GoodsDto(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getInt(4),
                        resultSet.getString(5),
                        resultSet.getDate(6));
                i++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.JDBCClose(statement, connection, resultSet);
        }
        return returnVal;
    }

    public GoodsDto[] getGoodsByKeyword(String keyword) {
        String sql = " SELECT SEQ, ID, IO_KIND, AMOUNT, CONTENT, WDATE FROM ACCOUNTBOOK " +
                " WHERE CONTENT LIKE '%" + keyword + "%'";
        System.out.println(sql);
        GoodsDto[] returnVal = null;
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        int i = 0;
        try {
            connection = DBConnection.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            returnVal = new GoodsDto[resultSet.getFetchSize()];
            while(resultSet.next()) {
                returnVal[i] = new GoodsDto(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getInt(4),
                        resultSet.getString(5),
                        resultSet.getDate(6));
                i++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.JDBCClose(statement, connection, resultSet);
        }
        return returnVal;
    }
}
