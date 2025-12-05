package entidades;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table (name = "Conferencia")
public class Conferencia {
    
    @Id
    @Column (length = 100)
    private String nombre;

    @Column
    private Date FechaHoraInicio;

    @Column (length = 50)
    private String Lugar;

    @Column
    private int NumeroHoras;

    @OneToMany (mappedBy = "conferencia", cascade = CascadeType.ALL)
    private List <inv_conf> inv_conf;

    public Conferencia() {
    }

    public Conferencia(String nombre, Date fechaHoraInicio, String lugar, int numeroHoras, List<entidades.inv_conf> inv_conf) {
        this.nombre = nombre;
        FechaHoraInicio = fechaHoraInicio;
        Lugar = lugar;
        NumeroHoras = numeroHoras;
        this.inv_conf = inv_conf;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaHoraInicio() {
        return FechaHoraInicio;
    }

    public void setFechaHoraInicio(Date fechaHoraInicio) {
        FechaHoraInicio = fechaHoraInicio;
    }

    public String getLugar() {
        return Lugar;
    }

    public void setLugar(String lugar) {
        Lugar = lugar;
    }

    public int getNumeroHoras() {
        return NumeroHoras;
    }

    public void setNumeroHoras(int numeroHoras) {
        NumeroHoras = numeroHoras;
    }

    public List<inv_conf> getInv_conf() {
        return inv_conf;
    }

    public void setInv_conf(List<inv_conf> inv_conf) {
        this.inv_conf = inv_conf;
    }

    @Override
    public String toString() {
        return "Conferencia [nombre=" + nombre + ", FechaHoraInicio=" + FechaHoraInicio + ", Lugar=" + Lugar
                + ", NumeroHoras=" + NumeroHoras + ", inv_conf=" + inv_conf + "]";
    }

}
