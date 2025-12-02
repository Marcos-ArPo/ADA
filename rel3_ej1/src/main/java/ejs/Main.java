package ejs;

import jakarta.persistence.*;
import java.sql.Date;
import entidades.*;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("bbdd");

        // Ejercicio b

        Usuario u1 = new Usuario(1, "María", "García", "López", "Madrid", 1.5, Date.valueOf("2020-03-15"));
        Usuario u2 = new Usuario(2, "Carlos", "Rodríguez", "Martínez", "Barcelona", 2.0,Date.valueOf("2019-07-22"));
        Usuario u3 = new Usuario(3, "Ana", "Fernández", "Gómez", "Valencia", 1.0, Date.valueOf("2021-01-10"));
        Usuario u4 = new Usuario(4, "Javier", "Pérez", "Sánchez", "Sevilla", 1.8, Date.valueOf("2018-11-05"));
        Usuario u5 = new Usuario(5, "Laura", "Díaz", "Romero", "Bilbao", 1.2, Date.valueOf("2022-05-30"));

        Libro l1 = new Libro(1, "Gabriel García", "Cien años de soledad", "Disponible", 432);
        Libro l2 = new Libro(2, "J.K. Rowling", "Harry Potter y la piedra", "Prestado", 320);
        Libro l3 = new Libro(3, "George Orwell", "1984", "Disponible", 328);
        Libro l4 = new Libro(4, "Jane Austen", "Orgullo y prejuicio", "En reparación", 416);
        Libro l5 = new Libro(5, "Miguel de Cervantes", "Don Quijote", "Disponible", 863);

        Prestamo p1 = new Prestamo(1, 2, Date.valueOf("2025-01-15"), Date.valueOf("2025-01-30"));
        Prestamo p2 = new Prestamo(2, 1, Date.valueOf("2025-02-01"), Date.valueOf("2025-02-15"));
        Prestamo p3 = new Prestamo(3, 3, Date.valueOf("2025-02-10"), Date.valueOf("2025-02-25"));
        Prestamo p4 = new Prestamo(4, 4, Date.valueOf("2025-03-05"), Date.valueOf("2025-03-20"));
        Prestamo p5 = new Prestamo(5, 2, Date.valueOf("2025-03-12"), Date.valueOf("2025-03-27"));
        Prestamo p6 = new Prestamo(6, 5, Date.valueOf("2025-04-01"), Date.valueOf("2025-04-16"));
        Prestamo p7 = new Prestamo(7, 1, Date.valueOf("2025-04-10"), Date.valueOf("2025-04-25"));
        Prestamo p8 = new Prestamo(8, 3, Date.valueOf("2025-05-03"), Date.valueOf("2025-05-18"));
        Prestamo p9 = new Prestamo(9, 4, Date.valueOf("2025-05-15"), Date.valueOf("2025-05-30"));
        Prestamo p10 = new Prestamo(10, 5, Date.valueOf("2025-06-01"), Date.valueOf("2025-06-16"));

        anadir(emf.createEntityManager(), u1);
        anadir(emf.createEntityManager(), u2);
        anadir(emf.createEntityManager(), u3);
        anadir(emf.createEntityManager(), u4);
        anadir(emf.createEntityManager(), u5);
        anadir(emf.createEntityManager(), l1);
        anadir(emf.createEntityManager(), l2);
        anadir(emf.createEntityManager(), l3);
        anadir(emf.createEntityManager(), l4);
        anadir(emf.createEntityManager(), l5);
        anadir(emf.createEntityManager(), p1);
        anadir(emf.createEntityManager(), p2);
        anadir(emf.createEntityManager(), p3);
        anadir(emf.createEntityManager(), p4);
        anadir(emf.createEntityManager(), p5);
        anadir(emf.createEntityManager(), p6);
        anadir(emf.createEntityManager(), p7);
        anadir(emf.createEntityManager(), p8);
        anadir(emf.createEntityManager(), p9);
        anadir(emf.createEntityManager(), p10);

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();

        tx.begin();

        // Ejercicio c

        Libro lejc = em.find(Libro.class, 3);

        lejc.setEstado("Prestado");

        // Ejercicio d

        Usuario uejd = em.find(Usuario.class, 3);

        uejd.setCategoria(uejd.getCategoria()*1.25);

        // Ejercicio e

        Prestamo peje = em.find(Prestamo.class, 3);

        peje.setFecha_fin(null);

        // Ejercicio f

        em.remove(em.find(Usuario.class, 5));
        for (int i=1; i<=10; i++) {
            Prestamo pejf = em.find(Prestamo.class, i);
            if (pejf.getId_usuario() == 5) {
                em.remove(pejf);
            }
        }

        // Ejercicio g

        for (int i=1; i<=10; i++) {
            Prestamo pejg = em.find(Prestamo.class, i);
            if (pejg == null) {
                continue;
            } else if (pejg.getId_usuario() == 2) {
                em.remove(pejg);
            }
        }

        tx.commit();

        em.close();
        emf.close();
    }

    // Metodos necesarios

    public static void anadir(EntityManager em, Object obj) {
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        em.persist(obj);

        tx.commit();

        em.close();
    }
}