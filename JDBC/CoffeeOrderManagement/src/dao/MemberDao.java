package dao;

import db.DBConnection;
import dto.MemberDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * DAO는 어디서든 접근하는 것이 유용하므로 싱글톤 클래스로 만듬
 */
public class MemberDao {
    private static MemberDao dao = null;

    private MemberDao() {
    }

    public static MemberDao getInstance() {
        if(dao == null) {
            dao = new MemberDao();
        }
        return dao;
    }

    public boolean isExist(String id) {
        Boolean returnVal = false;
        Connection connection = null;
        PreparedStatement psmt = null;
        ResultSet resultSet = null;
        String sql = " SELECT MEMBER_ID FROM CAFE_MEMBER WHERE MEMBER_ID = ? ";
        try {
            connection = DBConnection.getConnection();
            psmt = connection.prepareStatement(sql);
            psmt.setString(1, id);
            resultSet = psmt.executeQuery();

            if(resultSet.next()) {
                returnVal = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.JDBCClose(psmt, connection, resultSet);
        }
        return returnVal;
    }

    public boolean addMember(MemberDto dto) {
        Boolean returnVal = false;
        Connection connection = null;
        PreparedStatement psmt = null;
        int result = 0;
        // Authorize Value = 3
        String sql = " INSERT INTO CAFE_MEMBER (MEMBER_ID, MEMBER_PWD, MEMBER_NAME, MEMBER_AGE) VALUES(?,?,?,?) ";
        try {
            connection = DBConnection.getConnection();
            psmt = connection.prepareStatement(sql);
            psmt.setString(1, dto.getId());
            psmt.setString(2, dto.getPwd());
            psmt.setString(3, dto.getName());
            psmt.setInt(4, dto.getAge());
            result = psmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.JDBCClose(psmt, connection, null);
        }
        returnVal = result > 0;
        return returnVal;
    }

    public boolean login(String id, String pwd) {
        Boolean returnVal = false;
        Connection connection = null;
        PreparedStatement psmt = null;
        ResultSet resultSet = null;
        String sql = " SELECT MEMBER_ID FROM CAFE_MEMBER WHERE MEMBER_ID = ? AND MEMBER_PWD = ? ";
        try {
            connection = DBConnection.getConnection();
            psmt = connection.prepareStatement(sql);
            psmt.setString(1, id);
            psmt.setString(2, pwd);
            resultSet = psmt.executeQuery();
            if(resultSet.next()) {
                returnVal = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.JDBCClose(psmt, connection, resultSet);
        }
        return returnVal;
    }
}
