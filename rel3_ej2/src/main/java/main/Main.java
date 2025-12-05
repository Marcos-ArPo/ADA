package main;

import jakarta.persistence.*;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import entidades.*;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("bbdd");

        // Apartado C
        // Subapartado i
        c1(emf.createEntityManager());
        // Subapartado ii
        c2(emf.createEntityManager());
        // Subapartado iii
        c3(emf.createEntityManager());
        // Subapartado iv
        c4(emf.createEntityManager());

        // Apartado D
        // Subapartado i
        d1(emf.createEntityManager());
        // Subapartado ii
        d2(emf.createEntityManager());
        // Subapartado iii
        d3(emf.createEntityManager());

        // Apartado E
        // Subapartado i
        e1(emf.createEntityManager());
        // Subapartado ii
        e2(emf.createEntityManager());
        // Subapartado iii
        e3(emf.createEntityManager());
    }

    // Apartado C
    public static void c1(EntityManager em) {
        List <Investigador> inves = em.createQuery("select i from Investigador i order by i.DNI", Investigador.class).getResultList();

        for (Investigador inv : inves) {
            System.out.println("Investigador "+inv.getDNI()+" trabaja en");

            if (inv.getProyecto() != null) {
                System.out.println("Proyecto "+inv.getProyecto().getNombre());
            } else {
                System.out.println("Notrabaja en ningun proyecto");
            }
        }
    }

    public static void c2(EntityManager em) {
        List <Proyecto> pros = em.createQuery("select p from Proyecto p order by p.nombre", Proyecto.class).getResultList();

        for (Proyecto pro : pros) {
            System.out.println("Proyecto "+pro.getNombre()+" tiene a:");

            for (Investigador inv : pro.getInvestigadores()) {
                System.out.println("Investigador "+inv.getDNI());
            }
        }
    }

    public static void c3(EntityManager em) {
        List <Conferencia> cons = em.createQuery("select c from Conferencia c", Conferencia.class).getResultList();

        for (Conferencia con : cons) {
            System.out.println("Conferencia "+con.getNombre()+" tiene las asistencias de:");

            if (con.getInv_conf().isEmpty()) {
                System.out.println("Nadie");
            } else {
                for (inv_conf inv : con.getInv_conf()) {
                    System.out.println("Investigador "+inv.getInvestigador().getDNI());
                }
            }
        }
    }

    public static void c4(EntityManager em) {
        List <Investigador> inves = em.createQuery("select i from Investigador i order by i.DNI", Investigador.class).getResultList();

        for (Investigador inv : inves) {
            System.out.println("Investigador "+inv.getDNI()+" ha estado en:");

            if (inv.getInv_conf().isEmpty()) {
                System.out.println("Ninguna conferencia");
            } else {
                for (inv_conf ic : inv.getInv_conf()) {
                    System.out.println("Conferencia "+ic.getConferencia().getNombre());
                }
            }
        }
    }

    // Apartado D

    public static void d1(EntityManager em) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Investigador inv = em.find(Investigador.class, "45768434R");
        if (inv == null) {
            System.out.println("No existe el investigador");
            tx.rollback();
        } else {
            Query q = em.createQuery("delete from inv_conf ic where ic.investigador.DNI = :dni");
            q.setParameter("dni", "45768434R");
            int fb = q.executeUpdate();
            System.out.println("Se han borrado "+fb+" filas");

            Conferencia con = em.find(Conferencia.class, "Conferencia 2");
            if (con != null) {
                inv_conf ic = new inv_conf(inv, con);
                em.persist(ic);
            } else {
                System.out.println("Conferencia no encontrada");
                tx.rollback();
            }
            tx.commit();
        }
    }

    public static void d2(EntityManager em) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Conferencia con = em.find(Conferencia.class, "Conferencia 4");
        if (con == null) {
            System.out.println("Conferencia no encontrada");
            tx.rollback();
        } else {
            con.setFechaHoraInicio(Date.valueOf(LocalDate.now()));
            em.merge(con);
            tx.commit();
        }
    }

    public static void d3(EntityManager em) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Proyecto pro = em.find(Proyecto.class, "Proyecto 3");
        if (pro == null) {
            System.out.println("Proyecto no encontrado");
            tx.rollback();
        } else {
            List <Investigador> inves = em.createQuery("select i from Investigador i", Investigador.class).getResultList();

            for (Investigador inv : inves) {
                if (inv.getProyecto() != null && inv.getProyecto().getNombre().equals("Proyecto 2")) {
                    inv.setProyecto(pro);
                    em.merge(inv);
                }
            }
            tx.commit();
        }
    }

    // Apartado E

    public static void e1(EntityManager em) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Investigador inv = em.find(Investigador.class, "45768434R");
        if (inv == null) {
            System.out.println("Investigador no encontrado");
            tx.rollback();
        } else {
            Query q = em.createQuery("delete from inv_conf ic where ic.investigador.DNI = :dni");
            q.setParameter("dni", "45768434R");
            int fb = q.executeUpdate();
            System.out.println("Se han borrado "+fb+" filas");

            em.remove(inv);
            tx.commit();
        }
    }

    public static void e2(EntityManager em) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Proyecto pro = em.find(Proyecto.class, "Proyecto 1");
        if (pro == null) {
            System.out.println("Proyecto no encontrado");
            tx.rollback();
        } else {
            List <Investigador> inves = pro.getInvestigadores();

            for (Investigador inv : inves) {
                inv.setProyecto(null);
                em.merge(inv);
            }

            tx.commit();
        }
    }

    public static void e3(EntityManager em) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Conferencia con = em.find(Conferencia.class, "Conferencia 4");
        if (con == null) {
            System.out.println("Conferencia no encontrada");
            tx.rollback();
        } else {
            Query q = em.createQuery("delete from inv_conf ic where ic.conferencia.nombre = :nombre");
            q.setParameter("nombre", con.getNombre());
            int fb = q.executeUpdate();
            System.out.println("Se han borrado "+fb+" filas");

            em.remove(con);
            tx.commit();
        }
    }
}