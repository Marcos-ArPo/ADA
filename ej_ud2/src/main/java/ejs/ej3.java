package ejs;

import java.sql.*;

public class ej3 {

    public static void main(String [] args) throws Exception {
        // ap1();
        // ap2(1100, 1200);
        // System.out.println("--------------------------");
        // ap2(1300, 1400);
        ap3("SE");
        System.out.println("--------------------------");
        ap3("OS");
        // ap4();
        // ap5();
        // ap6();
        // ap7();
        // ap8();
        // ap9();
        // ap10();
        // ap11();
    }

    public static Connection con() throws Exception {
        String user = "root";
        String passwd = "1234";
        String url = "jdbc:mysql://localhost:3306/empresa";
        return DriverManager.getConnection(url, user, passwd);
    }

    public static void ap1() throws Exception{
        Connection con = con();
        PreparedStatement pstm = con.prepareStatement("select comision, nombre, salario from EMPLEADOS where num_hijos > 1 order by comision, nombre;");
        ResultSet rs = pstm.executeQuery();

        while (rs.next()) {
            int com = rs.getInt(1);
            String nom = rs.getString(2);
            int sal = rs.getInt(3);

            System.out.println(com+" , "+nom+" , "+sal);
        }
    }

    public static void ap2(int s1, int s2) throws Exception{
        Connection con = con();
        PreparedStatement pstm = con.prepareStatement("select nombre, salario from EMPLEADOS where salario between ? and ? order by nombre;");
        pstm.setInt(1, s1);
        pstm.setInt(2, s2);
        ResultSet rs = pstm.executeQuery();

        while (rs.next()) {
            String nom = rs.getString(1);
            int sal = rs.getInt(2);

            System.out.println(nom+" , "+sal);
        }
    }

    public static void ap3(String pala) throws Exception{
        Connection con = con();
        String pal = "%"+pala+"%";
        PreparedStatement pstm = con.prepareStatement("select nombre from DEPARTAMENTOS where nombre like ? order by nombre;");
        pstm.setString(1, pal);
        ResultSet rs = pstm.executeQuery();

        while (rs.next()) {
            String nom = rs.getString(1);

            System.out.println(nom);
        }
    }

    public static void ap4() throws Exception{
        Connection con = con();
        PreparedStatement pstm = con.prepareStatement("");
        ResultSet rs = pstm.executeQuery();

        while (rs.next()) {
            
        }
    }

    public static void ap5() throws Exception{
        Connection con = con();
        PreparedStatement pstm = con.prepareStatement("");
        ResultSet rs = pstm.executeQuery();

        while (rs.next()) {
            
        }
    }

    public static void ap6() throws Exception{
        Connection con = con();
        PreparedStatement pstm = con.prepareStatement("");
        ResultSet rs = pstm.executeQuery();

        while (rs.next()) {
            
        }
    }

    public static void ap7() throws Exception{
        Connection con = con();
        PreparedStatement pstm = con.prepareStatement("");
        ResultSet rs = pstm.executeQuery();

        while (rs.next()) {
            
        }
    }

    public static void ap8() throws Exception{
        Connection con = con();
        PreparedStatement pstm = con.prepareStatement("");
        ResultSet rs = pstm.executeQuery();

        while (rs.next()) {
            
        }
    }

    public static void ap9() throws Exception{
        Connection con = con();
        PreparedStatement pstm = con.prepareStatement("");
        ResultSet rs = pstm.executeQuery();

        while (rs.next()) {
            
        }
    }

    public static void ap10() throws Exception{
        Connection con = con();
        PreparedStatement pstm = con.prepareStatement("");
        ResultSet rs = pstm.executeQuery();

        while (rs.next()) {
            
        }
    }

    public static void ap11() throws Exception{
        Connection con = con();
        PreparedStatement pstm = con.prepareStatement("");
        ResultSet rs = pstm.executeQuery();

        while (rs.next()) {
            
        }
    }
}
