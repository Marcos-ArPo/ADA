package ejs;

import java.sql.*;

public class ej4 {
    public static void main(String [] args) throws Exception {
        // ap1(10, 20);
        // ap2(210);
        // ap3();
        // ap4();
        // ap5("FONTANERO", 312);
        // ap6();
        // ap7();
        // ap8();
        // ap9();
        // ap10();
        // ap11();
        // ap12(12);
    }

    public static Connection con() throws Exception {
        String user = "root";
        String passwd = "1234";
        String url = "jdbc:mysql://localhost:3306/ej4";
        return DriverManager.getConnection(url, user, passwd);
    }

    public static void ap1(double min, double max) throws Exception {
        Connection con = con();
        CallableStatement cst = con.prepareCall("call ap1(?,?);");
        cst.setDouble(1, min);
        cst.setDouble(2, max);

        ResultSet rs = cst.executeQuery();
        while (rs.next()) {
            String nom = rs.getString(1);
            double tar = rs.getDouble(2);

            System.out.println(nom+" , "+tar);
        }
    }

    public static void ap2(int ide) throws Exception {
        Connection con = con();
        CallableStatement cst = con.prepareCall("call ap2(?);");
        cst.setInt(1, ide);

        ResultSet rs = cst.executeQuery();
        while (rs.next()) {
            String ofi = rs.getString(1);

            System.out.println(ofi);
        }
    }

    public static void ap3() throws Exception {
        Connection con = con();
        CallableStatement cst = con.prepareCall("call ap3();");

        ResultSet rs = cst.executeQuery();
        while (rs.next()) {
            String tra = rs.getString(1);
            String sup = rs.getString(2);

            System.out.println(tra+" , "+sup);
        }
    }

    public static void ap4() throws Exception {
        Connection con = con();
        CallableStatement cst = con.prepareCall("call ap4();");

        ResultSet rs = cst.executeQuery();
        while (rs.next()) {
            String nom = rs.getString(1);

            System.out.println(nom);
        }
    }

    public static void ap5(String ofic, int ide) throws Exception {
        Connection con = con();
        CallableStatement cst = con.prepareCall("call ap5(?,?);");
        cst.setString(1, ofic);
        cst.setInt(2, ide);

        ResultSet rs = cst.executeQuery();
        while (rs.next()) {
            int tot =rs.getInt(1);

            System.out.println(tot);
        }
    }

    public static void ap6() throws Exception {
        Connection con = con();
        CallableStatement cst = con.prepareCall("call ap6();");

        ResultSet rs = cst.executeQuery();
        while (rs.next()) {
            int nof = rs.getInt(1);

            System.out.println(nof);
        }
    }

    public static void ap7() throws Exception {
        Connection con = con();
        CallableStatement cst = con.prepareCall("call ap7();");

        ResultSet rs = cst.executeQuery();
        while (rs.next()) {
            String sup = rs.getString(1);
            double tma = rs.getDouble(2);

            System.out.println(sup+" , "+tma);
        }
    }

    public static void ap8() throws Exception {
        Connection con = con();
        CallableStatement cst = con.prepareCall("call ap8();");

        ResultSet rs = cst.executeQuery();
        while (rs.next()) {
            String sup = rs.getString(1);
            double tma = rs.getDouble(2);

            System.out.println(sup+" , "+tma);
        }
    }

    public static void ap9() throws Exception {
        Connection con = con();
        CallableStatement cst = con.prepareCall("call ap9();");

        ResultSet rs = cst.executeQuery();
        while (rs.next()) {
            String nom = rs.getString(1);
            double tar = rs.getDouble(2);

            System.out.println(nom+" , "+tar);
        }
    }

    public static void ap10() throws Exception {
        Connection con = con();
        CallableStatement cst = con.prepareCall("call ap10();");

        ResultSet rs = cst.executeQuery();
        while (rs.next()) {
            String nom = rs.getString(1);
            String ofi = rs.getString(2);
            double tar = rs.getDouble(3);

            System.out.println(nom+" , "+ofi+" , "+tar);
        }
    }

    public static void ap11() throws Exception {
        Connection con = con();
        CallableStatement cst = con.prepareCall("call ap11();");

        ResultSet rs = cst.executeQuery();
        while (rs.next()) {
            String nom = rs.getString(1);
            double tar = rs.getDouble(2);
            String sup = rs.getString(3);

            System.out.println(nom+" , "+tar+" , "+sup);
        }
    }

    public static void ap12(double tmi) throws Exception {
        Connection con = con();
        CallableStatement cst = con.prepareCall("call ap12(?);");
        cst.setDouble(1, tmi);

        ResultSet rs = cst.executeQuery();
        while (rs.next()) {
            String sup = rs.getString(1);
            String tra = rs.getString(2);
            double tar = rs.getDouble(3);

            System.out.println(sup+" , "+tra+" , "+tar);
        }
    }
}
