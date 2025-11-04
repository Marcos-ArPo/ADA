package ejs;

import java.sql.*;

public class ej2 {

    public static void main(String[] args) throws Exception {
        // a();
        // b();
        // c();
        // d();
        // e();
        f();
    }

    public static Connection con() throws Exception {
        String user = "root";
        String passwd = "1234";
        String url = "jdbc:mysql://localhost:3306/empresa";
        return DriverManager.getConnection(url, user, passwd);
    }

    public static void a() throws Exception {
        Connection con = con();
        Statement stm = con.createStatement();
        ResultSet rs = stm.executeQuery("select comision, nombre, salario from EMPLEADOS where num_hijos > 3 order by comision, nombre;");

        while (rs.next()) {
            int com = rs.getInt(1);
            String nom = rs.getString(2);
            int sal = rs.getInt(3);

            System.out.println(com + " , " + nom + " , " + sal);
        }
    }

    public static void b() throws Exception {
        Connection con = con();
        Statement stm = con.createStatement();
        ResultSet rs = stm.executeQuery("select nombre from DEPARTAMENTOS where depto_jefe is null;");

        while (rs.next()) {
            String nom = rs.getString(1);

            System.out.println(nom);
        }
    }

    public static void c() throws Exception{
        Connection con = con();
        Statement stm = con.createStatement();
        ResultSet rs = stm.executeQuery("select nombre, salario from EMPLEADOS where salario > 1250 and salario < 1300 order by nombre;");

        while (rs.next()) {
            String nom = rs.getString(1);
            int sal = rs.getInt(2);

            System.out.println(nom+" , "+sal);
        }
    }

    public static void d() throws Exception {
        Connection con = con();
        Statement stm = con.createStatement();
        ResultSet rs = stm.executeQuery("select nombre, salario from EMPLEADOS where salario > 1250 and salario < 1300 or num_hijos >= 1 order by nombre;");

        while (rs.next()) {
            String nom = rs.getString(1);
            int sal = rs.getInt(2);

            System.out.println(nom+" , "+sal);
        }
    }

    public static void e() throws Exception{
        Connection con = con();
        Statement stm = con.createStatement();
        ResultSet rs = stm.executeQuery("select nombre from DEPARTAMENTOS where nombre not like 'DIRECCION%' and nombre not like 'SECTOR%' order by nombre;");

        while (rs.next()) {
            String nom = rs.getString(1);

            System.out.println(nom);
        }
    }

    public static void f() throws Exception {
        Connection con = con();
        Statement stm = con.createStatement();
        ResultSet rs = stm.executeQuery("select nombre from DEPARTAMENTOS where (tipo_dir = 'F' and presupuesto <= 5) or depto_jefe is null order by nombre;");

        while (rs.next()) {
            String nom = rs.getString(1);

            System.out.println(nom);
        }
    }
}
