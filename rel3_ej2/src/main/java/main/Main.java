package main;

import jakarta.persistence.*;
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
    }

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
        List <Proyecto> pros = em.createQuery("select p from Proyecto p order by p.Nombre", Proyecto.class).getResultList();

        for (Proyecto pro : pros) {
            System.out.println("Proyecto "+pro.getNombre()+" tiene a:");

            for (Investigador inv : pro.getInvestigadores()) {
                System.out.println("Investigador "+inv.getDNI());
            }
        }
    }

    public static void c3(EntityManager em) {
        List <Conferencia> cons = em.createQuery("select c from Conferencia", Conferencia.class).getResultList();

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


}