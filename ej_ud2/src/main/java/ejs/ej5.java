package ejs;

import java.sql.*;

public class ej5 {
    public static void main(String[] args) throws Exception {
        // ap1(120);
        // ap2(10, "Sevilla", "SEV");
        // ap3(130);
        // ap4(130);
        // ap5(120);
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
        try {
            PreparedStatement pstm = con.prepareStatement("update DEPARTAMENTOS set tipo_dir = 'P' where numero = ? and tipo_dir = 'F';");
            pstm.setInt(1, nde);
            int fa = pstm.executeUpdate();

            if (fa > 0) {
                PreparedStatement pstm2 = con.prepareStatement("select director from DEPARTAMENTOS where numero = ?;");
                int dir = 0;
                pstm2.setInt(1, nde);
                ResultSet rs = pstm2.executeQuery();

                while (rs.next()) {
                    dir = rs.getInt("director");
                }

                PreparedStatement pstm3 = con.prepareStatement("update EMPLEADOS set salario  = salario*1.2 where cod = ?;");
                pstm3.setInt(1, dir);
                pstm3.executeUpdate();

                con.commit();
                System.out.println("Cambios realizados.");
            } else {
                con.rollback();
                System.out.println("Los cambios no se ha podido realizar.");
            }
        } catch (Exception e) {
            con.rollback();
            System.out.println("Los cambios no se ha podido realizar.");
        }
        con.setAutoCommit(true);
    }

    public static void ap2(int nce, String nmc, String sde) throws Exception {
        Connection con = con();
        con.setAutoCommit(false);
        try {
            PreparedStatement pstm = con.prepareStatement("update CENTROS set nombre = ? where numero = ?;");
            pstm.setString(1, nmc);
            pstm.setInt(2, nce);
            pstm.executeUpdate();

            PreparedStatement pstm2 = con.prepareStatement("update DEPARTAMENTOS set nombre = concat(nombre, ?) where centro = ?;");
            pstm2.setString(1, " - " + sde);
            pstm2.setInt(2, nce);
            pstm2.executeUpdate();

            con.commit();
            System.out.println("Cambios realizados.");
        } catch (Exception e) {
            con.rollback();
            System.out.println("Los cambios no se han podido realizar;");
        }
        con.setAutoCommit(true);
    }

    public static void ap3(int cem) throws Exception {
        Connection con = con();
        con.setAutoCommit(false);
        try {
            int did = 0;
            PreparedStatement pstm = con.prepareStatement("select departamento from EMPLEADOS where cod = ?;");
            pstm.setInt(1, cem);
            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                did = rs.getInt(1);
            }

            if (did > 0) {
                PreparedStatement pstm2 = con.prepareStatement("delete from EMPLEADOS where cod = ?;");
                pstm2.setInt(1, cem);
                pstm2.executeUpdate();

                PreparedStatement pstm3 = con.prepareStatement("update DEPARTAMENTOS set presupuesto = presupuesto*0.95 where numero = ?;");
                pstm3.setInt(1, did);
                pstm3.executeUpdate();

                con.commit();
                System.out.println("Cambios realizados");
            }
        } catch (Exception e) {
            con.rollback();
            System.out.println("Los cambios no se ha podido realizar.");
        }
        con.setAutoCommit(true);
    }

    public static void ap4(int nde) throws Exception {
        Connection con = con();
        con.setAutoCommit(false);
        try {
            PreparedStatement pstm = con.prepareStatement("update DEPARTAMENTOS set presupuesto = presupuesto*1.2 where numero = ?;");
            pstm.setInt(1, nde);
            pstm.executeUpdate();

            PreparedStatement pstm2 = con.prepareStatement("insert into EMPLEADOS (cod, departamento, nombre, f_ing, salario) values (?,?,?,curdate(),?);");
            int [] ne = {510, 520, 530, 540};
            String [] noms = {"ARBIN, MARCOS", "SANCHEZ, JOSE", "INFANTES, MANUEL", "DE LOS SANTOS, JAIME"};
            for (int i=0; i<ne.length; i++) {
                pstm2.setInt(1, ne[i]);
                pstm2.setInt(2, nde);
                pstm2.setString(3, noms[i]);
                pstm2.setDouble(4, 1500.0);
                pstm2.addBatch();
            }
            pstm2.executeBatch();

            con.commit();
            System.out.println("Cambios realizados.");
        } catch (Exception e) {
            con.rollback();
            System.out.println("Los cambios no se ha podido realizar.");
        }
        con.setAutoCommit(true);
    }

    public static void ap5(int cem) throws Exception {
        Connection con = con();
        con.setAutoCommit(false);
        try {
            PreparedStatement pstm = con.prepareStatement("select numero from DEPARTAMENTOS where director = ? and tipo_dir = 'F';");
            int did = 0;
            pstm.setInt(1, cem);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                did = rs.getInt(1);
            }

            if (did > 0) {
                PreparedStatement pstm2 = con.prepareStatement("update EMPLEADOS set num_hijos = num_hijos+1 where cod = ?;");
                pstm2.setInt(1, cem);
                pstm2.executeUpdate();

                PreparedStatement pstm3 = con.prepareStatement("update DEPARTAMENTOS set tipo_dir = 'P' where numero = ?;");
                pstm3.setInt(1, did);
                pstm3.executeUpdate();
            }

            con.commit();
            System.out.println("Cambios realizados.");
        } catch (Exception e) {
            con.rollback();
            System.out.println("Los cambios no se han podido realizar.");
        }
        con.setAutoCommit(true);
    }
}
