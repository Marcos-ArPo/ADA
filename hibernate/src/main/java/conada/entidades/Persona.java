package conada.entidades;

import java.sql.Date;

import jakarta.persistence.*;

@Entity
@Table (name = "persona")
public class Persona {

    @Id
    private int id;

    @Column (length = 50, nullable = false)
    private String nombre;

    @Column (length = 100)
    private String direccion;

    @Column (name = "fecha_nac")
    private Date f_nac;

    public Persona() {

    }

    public Persona(int id, String nombre, String direccion, Date f_nac) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.f_nac = f_nac;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Date getF_nac() {
        return f_nac;
    }

    public void setF_nac(Date f_nac) {
        this.f_nac = f_nac;
    }

    
}
