package ejs;

import java.sql.*;

public class ej2 {

    public static void main(String [] args) throws Exception{
        a();
    }

    public static Connection con() throws Exception {
        String user = "root";
        String passwd = "1234";
        String url = "jdbc:mysql://localhost:3306/empresa";
        return DriverManager.getConnection(url, user, passwd);
    }

    public static void a() throws Exception{
        Connection con = con();
        Statement stm = con.createStatement();
        ResultSet rs = stm.executeQuery("select comision, nombre, salario from EMPLEADOS where num_hijos > 3 order by comision, nombre;");

        while (rs.next()) {
            int com = rs.getInt(1);
            String nom = rs.getString(2);
            int sal = rs.getInt(3);

            System.out.println(com +" , "+ nom +" , "+sal);
        }
    }
}
