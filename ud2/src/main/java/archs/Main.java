package archs;

public class Main {
    public static void main(String[] args) throws Exception {
        conexion c = new conexion();
        // c.ejecutar("update persona set nombre='Antonio Fernandez' where id=1");
        c.ejecutar("delete from es_padre where id_padre=3");
        c.cerrar();
    }
}
