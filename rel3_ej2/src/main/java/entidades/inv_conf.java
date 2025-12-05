package entidades;

import jakarta.persistence.*;

@Entity
@Table (name = "inv_conf")
public class inv_conf {

    @EmbeddedId
    @ManyToOne
    @JoinColumn (name = "dni_inv")
    private Investigador investigador;

    @EmbeddedId
    @ManyToOne
    @JoinColumn (name = "nom_con")
    private Conferencia conferencia;

    public inv_conf() {
    }

    public inv_conf(Investigador investigador, Conferencia conferencia) {
        this.investigador = investigador;
        this.conferencia = conferencia;
    }

    public Investigador getInvestigador() {
        return investigador;
    }

    public void setInvestigador(Investigador investigador) {
        this.investigador = investigador;
    }

    public Conferencia getConferencia() {
        return conferencia;
    }

    public void setConferencia(Conferencia conferencia) {
        this.conferencia = conferencia;
    }

    @Override
    public String toString() {
        return "inv_conf [investigador=" + investigador + ", conferencia=" + conferencia + "]";
    }
}
