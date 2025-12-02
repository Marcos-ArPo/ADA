package entidades;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table (name = "Investigador")
public class Investigador {
    
    @Id
    @Column (length = 9)
    private String DNI;

    @ManyToOne
    @JoinColumn (name = "Nombre_pro")
    private Proyecto proyecto;

    @Column (length = 100)
    private String NombreCompleto;

    @Column (length = 50)
    private String Direccion;

    @Column
    private int Telefono;

    @Column (length = 50)
    private String Localidad;

    @OneToMany (mappedBy = "Investigador", cascade = CascadeType.ALL)
    private List <inv_conf> inv_conf;

    public Investigador() {
    }

    public Investigador(String dNI, Proyecto proyecto, String nombreCompleto, String direccion, int telefono,
            String localidad, List<entidades.inv_conf> inv_conf) {
        DNI = dNI;
        this.proyecto = proyecto;
        NombreCompleto = nombreCompleto;
        Direccion = direccion;
        Telefono = telefono;
        Localidad = localidad;
        this.inv_conf = inv_conf;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String dNI) {
        DNI = dNI;
    }

    public Proyecto getProyecto() {
        return proyecto;
    }

    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }

    public String getNombreCompleto() {
        return NombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        NombreCompleto = nombreCompleto;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String direccion) {
        Direccion = direccion;
    }

    public int getTelefono() {
        return Telefono;
    }

    public void setTelefono(int telefono) {
        Telefono = telefono;
    }

    public String getLocalidad() {
        return Localidad;
    }

    public void setLocalidad(String localidad) {
        Localidad = localidad;
    }

    public List<inv_conf> getInv_conf() {
        return inv_conf;
    }

    public void setInv_conf(List<inv_conf> inv_conf) {
        this.inv_conf = inv_conf;
    }

    @Override
    public String toString() {
        return "Investigador [DNI=" + DNI + ", proyecto=" + proyecto + ", NombreCompleto=" + NombreCompleto
                + ", Direccion=" + Direccion + ", Telefono=" + Telefono + ", Localidad=" + Localidad + ", inv_conf="
                + inv_conf + "]";
    }

}
