package Exam0701;

import Exam0701.dao.GoodsDao;
import Exam0701.db.DBConnection;
import Exam0701.dto.GoodsDto;
import Exam0701.view.loginView;

/**
 * AccountBook : Main Class
 */

public class AccountBook {
    public static void main(String[] args) {
        DBConnection.JDBCDriverCheck();
        new loginView();

    }
}
