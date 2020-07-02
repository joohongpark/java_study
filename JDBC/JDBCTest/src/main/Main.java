package main;

import jdbc.JDBCConnector;
import jdbc.JDBCCRUD;

public class Main {

    public static void main(String[] args) {
        int c;
        JDBCConnector.JDBCDriverCheck();
        //int c = JDBCCRUD.InsertData("p1uju", "park", 27);
        c = JDBCCRUD.UpdateData("p1uju", 12);
        System.out.println("c Val : " + c);

    }
}
