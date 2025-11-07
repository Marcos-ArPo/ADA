package ejs;

import java.sql.Connection;
import java.sql.DriverManager;

public class ej5 {
    public static void main(String [] args) throws Exception {

    }

    public static Connection con() throws Exception {
        String user = "root";
        String passwd = "1234";
        String url = "jdbc:mysql://localhost:3306/empresa";
        return DriverManager.getConnection(url, user, passwd);
    }

    public static void ap1(int nde) throws Exception {
        Connection con = con();
        con.setAutoCommit(false);
    }

    public static void ap2(int nce, String nmc, String sde) throws Exception {
        Connection con = con();
        con.setAutoCommit(false);
    }

    public static void ap3(int cem) throws Exception {
        Connection con = con();
        con.setAutoCommit(false);
    }

    public static void ap4(int nde) throws Exception {
        Connection con = con();
        con.setAutoCommit(false);
    }

    public static void ap5(int cem) throws Exception {
        Connection con = con();
        con.setAutoCommit(false);
    }
}
