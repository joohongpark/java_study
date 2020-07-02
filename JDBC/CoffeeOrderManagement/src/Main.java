import dao.CoffeeDao;
import db.DBConnection;
import dto.CoffeeDto;
import view.loginView;
import view.mainview.mainView;

public class Main {

    public static void main(String[] args) {
        DBConnection.JDBCDriverCheck();
        new loginView();
    }
}
