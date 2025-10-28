package ejs;

import java.sql.*;

public class conexion {
    private String user = "root";
    private String passwd = "1234";
    private String url = "jdbc:mysql://localhost:3306/tienda";
    private Connection con;

    public conexion() throws Exception {
        con = DriverManager.getConnection(url, user, passwd);
    }

    public void actualizar(String query) throws Exception {
        Statement st = con.createStatement();
        int n = st.executeUpdate(query);
        if (n > 0) {
            System.out.println("Se ha realizado la operacion, " + n + " filas afectadas.");
        }
        st.close();
    }

    public void insertar(String query) throws Exception {
        Statement st = con.createStatement();
        int n = st.executeUpdate(query);
        if (n > 0) {
            System.out.println("Se ha realizado la operacion, " + n + " filas afectadas.");
        }
        st.close();
    }

    public void borrar(String query) throws Exception {
        Statement st = con.createStatement();
        int n = st.executeUpdate(query);
        if (n > 0) {
            System.out.println("Se ha realizado la operacion, " + n + " filas afectadas.");
        }
        st.close();
    }

    public void cerrar() throws Exception {
        con.close();
    }
}
