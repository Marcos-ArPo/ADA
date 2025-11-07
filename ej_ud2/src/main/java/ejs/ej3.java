package ejs;

import java.sql.*;

public class ej3 {

    public static void main(String [] args) throws Exception {
        // ap1();
        // ap2(1100, 1200);
        // System.out.println("--------------------------");
        // ap2(1300, 1400);
        // ap3("SE");
        // System.out.println("--------------------------");
        // ap3("OS");
        // ap4(10);
        // ap5("LUCIANO");
        // ap6();
        // ap7(1400);
        // System.out.println("--------------------------");
        // ap7(1500);
        // ap8();
        // ap9(1300);
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

    public static void ap4(int num) throws Exception{
        Connection con = con();
        PreparedStatement pstm = con.prepareStatement("select * from CENTROS where numero = ?;");
        pstm.setInt(1, num);
        ResultSet rs = pstm.executeQuery();

        while (rs.next()) {
            int n = rs.getInt(1);
            String nom = rs.getString(2);
            String dir = rs.getString(3);

            System.out.println(n+" , "+nom+" , "+dir);
        }
    }

    public static void ap5(String nombre) throws Exception{
        Connection con = con();
        String nomb = "%"+nombre+"%";
        PreparedStatement pstm = con.prepareStatement("select *from EMPLEADOS where nombre like ?;");
        pstm.setString(1, nomb);
        ResultSet rs = pstm.executeQuery();

        while (rs.next()) {
            int cod = rs.getInt(1);
            int sal = rs.getInt(6);
            String nom = rs.getString(9);

            System.out.println(cod+" , "+nom+" , "+sal);
        }
    }

    public static void ap6() throws Exception{
        Connection con = con();
        PreparedStatement pstm = con.prepareStatement("select nombre from EMPLEADOS where month(f_nac) = 01 or month(f_nac) = 11;");
        ResultSet rs = pstm.executeQuery();

        while (rs.next()) {
            String nom = rs.getString(1);

            System.out.println(nom);
        }
    }

    public static void ap7(int stot) throws Exception{
        Connection con = con();
        PreparedStatement pstm = con.prepareStatement("select cod, nombre, (salario+comision) as 'salario_total' from EMPLEADOS where (salario+comision) > ? order by cod;");
        pstm.setInt(1, stot);
        ResultSet rs = pstm.executeQuery();

        while (rs.next()) {
            String nom = rs.getString(2);
            int sal = rs.getInt(3);

            System.out.println(nom+" , "+sal);
        }
    }

    public static void ap8() throws Exception{
        Connection con = con();
        PreparedStatement pstm = con.prepareStatement("select departamento, count(*) as 'num_empleados', count(distinct telefono) as 'extensiones' from EMPLEADOS group by departamento;");
        ResultSet rs = pstm.executeQuery();

        while (rs.next()) {
            int dep = rs.getInt(1);
            int nem = rs.getInt(2);
            int nex = rs.getInt(3);

            System.out.println(dep+" , "+nem+" , "+nex);
        }
    }

    public static void ap9(int sala) throws Exception{
        Connection con = con();
        PreparedStatement pstm = con.prepareStatement("select departamento, count(*) as 'num_empleados' from EMPLEADOS where salario > ? group by departamento;");
        pstm.setInt(1, sala);
        ResultSet rs = pstm.executeQuery();

        while (rs.next()) {
            int dep = rs.getInt(1);
            int nem = rs.getInt(2);

            System.out.println(dep+" , "+nem);
        }
    }

    public static void ap10() throws Exception{
        Connection con = con();
        PreparedStatement pstm = con.prepareStatement("select nombre, salario, f_nac from EMPLEADOS where (year(f_ing)-year(f_nac)) > 20;");
        ResultSet rs = pstm.executeQuery();
        System.out.println("Mas de 20 años:");
        while (rs.next()) {
            String nom = rs.getString(1);
            int sal = rs.getInt(2);
            String fna = rs.getString(3);

            System.out.println(nom+" , "+sal+" , "+fna);
        }
        PreparedStatement pstm2 = con.prepareStatement("select nombre, salario, f_nac from EMPLEADOS where (year(f_ing)-year(f_nac)) > 30;");
        ResultSet rs2 = pstm2.executeQuery();
        System.out.println("Mas de 30 años:");
        while (rs2.next()) {
            String nom = rs2.getString(1);
            int sal = rs2.getInt(2);
            String fna = rs2.getString(3);

            System.out.println(nom+" , "+sal+" , "+fna);
        }
        PreparedStatement pstm3 = con.prepareStatement("select nombre, salario, f_nac from EMPLEADOS where (year(f_ing)-year(f_nac)) > 40;");
        ResultSet rs3 = pstm3.executeQuery();
        System.out.println("Mas de 40 años:");
        while (rs3.next()) {
            String nom = rs3.getString(1);
            int sal = rs3.getInt(2);
            String fna = rs3.getString(3);

            System.out.println(nom+" , "+sal+" , "+fna);
        }
    }

    public static void ap11() throws Exception{
        Connection con = con();
        PreparedStatement pstm = con.prepareStatement("select nombre, cod, salario, f_ing from EMPLEADOS where (year(curdate())-year(f_ing)) > 3 and salario < 1300;");
        ResultSet rs = pstm.executeQuery();
        System.out.println("Mayor de 3 años y salario menor que 1300:");
        while (rs.next()) {
            String nom = rs.getString(1);
            int cod = rs.getInt(2);
            int sal = rs.getInt(3);

            System.out.println(nom+" , "+cod+" , "+sal);
        }
        PreparedStatement pstm2 = con.prepareStatement("select nombre, cod, salario, f_ing from EMPLEADOS where (year(curdate())-year(f_ing)) > 5 and salario < 1500;");
        ResultSet rs2 = pstm2.executeQuery();
        System.out.println("Mayor de 5 años y salario menor que 1500:");
        while (rs2.next()) {
            String nom = rs2.getString(1);
            int cod = rs2.getInt(2);
            int sal = rs2.getInt(3);

            System.out.println(nom+" , "+cod+" , "+sal);
        }
    }
}
