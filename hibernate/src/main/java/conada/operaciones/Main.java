package conada.operaciones;

import java.sql.Date;

import conada.entidades.Persona;
import jakarta.persistence.*;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("miBD");

        Persona p1 = new Persona(100, "Marcos", "Calle mentirosa", Date.valueOf("2005-11-28"));
        Persona p2 = new Persona(101, "Jose", "Calle falsa", Date.valueOf("2006-08-16"));

        
        anadir(emf.createEntityManager(), p1);
        anadir(emf.createEntityManager(), p2);
        borrar(emf.createEntityManager(), 100);
    }

    public static void borrar(EntityManager em, int id) {
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        Persona p = em.find(Persona.class, id);

        if(p == null) {
            System.out.println("No existe la persona");
        } else {
            em.remove(p);
            System.out.println("Persona eliminada");
        }

        tx.commit();

        em.close();
    }

    public static void anadir(EntityManager em, Persona p) {
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        em.persist(p);

        tx.commit();

        em.close();
    }
}
