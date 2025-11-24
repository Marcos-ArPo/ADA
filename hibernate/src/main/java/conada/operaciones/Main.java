package conada.operaciones;

import java.sql.Date;

import conada.entidades.Persona;
import jakarta.persistence.*;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("miBD");
        EntityManager em = emf.createEntityManager();

        Persona p = new Persona(100, "Marcos", "calle", Date.valueOf("2005-11-28"));

        EntityTransaction tx = em.getTransaction();

        tx.begin();

        em.persist(p);

        tx.commit();

        em.close();
    }
}
