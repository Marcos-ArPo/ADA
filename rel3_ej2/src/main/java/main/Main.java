package main;

import jakarta.persistence.*;
import entidades.*;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("bbdd");
    }
}