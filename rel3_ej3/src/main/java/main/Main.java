package main;

import jakarta.persistence.*;
import entidades.*;
import java.util.List;
import java.sql.Date;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("bbdd");
        
        // Ejercicio 3
        // Apartado a
        a(emf.createEntityManager());
        // Apartado b
        b(emf.createEntityManager());
        // Apartado c
        c(emf.createEntityManager());
        // Apartado d
        d(emf.createEntityManager());
        // Apartado e
        e(emf.createEntityManager());
        // Apartado f
        f(emf.createEntityManager());
        // Apartado g
        g(emf.createEntityManager());
        // Apartado h
        h(emf.createEntityManager(), "Conferencia 1");
        // Apartado i
        i(emf.createEntityManager(), LocalDate.of(2021, 10, 05));
        // Apartado j
        j(emf.createEntityManager(), "Soto");
    }

    public static void a(EntityManager em) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        List <String> res = em.createQuery("select c.nombre from Conferencia c where c.NumeroHoras > 2", String.class).getResultList();

        for (String nom : res) {
            System.out.println(nom);
        }
    }

    public static void b(EntityManager em) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        List <String> res = em.createQuery("select distinct i.NombreCompleto from Investigador i join i.inv_conf ic join ic.conferencia c where c.NumeroHoras = (select max(c2.NumeroHoras) from Conferencia c2)", String.class).getResultList();

        for (String nom : res) {
            System.out.println(nom);
        }
    }

    public static void c(EntityManager em) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        List <Conferencia> res = em.createQuery("select c from Conferencia c where c.NumeroHoras = (select min(c2.NumeroHoras) from Conferencia c2)", Conferencia.class).getResultList();

        for (Conferencia con : res) {
            System.out.println(con.getNombre()+" - "+con.getNumeroHoras());
        }
    }

    public static void d(EntityManager em) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        Proyecto pro = em.createQuery("select i.proyecto from Investigador i where i.DNI = '65342316R'", Proyecto.class).getSingleResult();

        System.out.println(pro.getNombre());
    }

    public static void e(EntityManager em) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        Long res = em.createQuery("select count(distinct ic.conferencia) from inv_conf ic where ic.investigador.DNI = '65342316R'", Long.class).getSingleResult();

        System.out.println(res+" conferencias");
    }

    public static void f(EntityManager em) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        List <Investigador> res = em.createQuery("select i from Investigador i where i.proyecto.nombre = 'Proyecto 4'", Investigador.class).getResultList();

        for (Investigador inv : res) {
            System.out.println(inv.getDNI()+" - "+inv.getNombreCompleto());
        }
    }

    public static void g(EntityManager em) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        String sq = "select ic.investigador.DNI from inv_conf where ic.conferencia.nombre = 'Conferencia 5'";
        List <Proyecto> res = em.createQuery("select distinct i.proyecto from Investigador i where i.DNI in (:sq)", Proyecto.class).setParameter("sq", sq).getResultList();

        for (Proyecto pro : res) {
            System.out.println(pro.getNombre());
        }
    }

    public static void h(EntityManager em, String cf) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        List <String> sq = em.createQuery("select ic.investigador.DNI from inv_conf ic where ic.conferencia.nombre = :cf", String.class).setParameter("cf", cf).getResultList();
        List <Proyecto> res = em.createQuery("select distinct i.proyecto from Investigador i where i.DNI in (:sq)", Proyecto.class).setParameter("sq", sq).getResultList();

        for (Proyecto pro : res) {
            System.out.println(pro.getNombre());
        }
    }

    public static void i(EntityManager em, LocalDate fl) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        List <String> res = em.createQuery("select i.DNI from Investigador i join i.proyecto p where p.FechaInicio < :fl", String.class).setParameter("fl", Date.valueOf(fl)).getResultList();

        for (String dni : res) {
            System.out.println(dni);
        }
    }

    public static void j(EntityManager em, String ap) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        List <Conferencia> res = em.createQuery("select distinct ic.conferencia from inv_conf ic where ic.investigador.NombreCompleto like :ap", Conferencia.class).setParameter("ap", ap).getResultList();

        for (Conferencia con: res) {
            System.out.println(con.getNombre());
        }
    }
}