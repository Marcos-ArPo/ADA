package entidades;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table (name = "Proyecto")
public class Proyecto {

    @Id
    private String nombre;

    @Column
    private Date FechaInicio;

    @OneToMany (mappedBy = "DNI")
    private List <Investigador> investigadores;

    public Proyecto() {
    }

    public Proyecto(String nombre, Date fechaInicio) {
        this.nombre = nombre;
        FechaInicio = fechaInicio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaInicio() {
        return FechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        FechaInicio = fechaInicio;
    }

    public List<Investigador> getInvestigadores() {
        return investigadores;
    }

    public void setInvestigadores(List<Investigador> investigadores) {
        this.investigadores = investigadores;
    }

    @Override
    public String toString() {
        return "Proyecto [nombre=" + nombre + ", FechaInicio=" + FechaInicio + ", investigadores=" + investigadores
                + "]";
    }

}
