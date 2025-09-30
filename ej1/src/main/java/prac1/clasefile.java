package clasefile;

import java.io.*;

public class clasefile {
    public static void main(String[] args) {
        System.out.println();
        ej1();
        System.out.println();
        ej2();
        System.out.println();
        ej3("./d/d2");
        System.out.println();
        ej4("./d/d2",".txt");
        System.out.println();
        ej5("./d/d2/d22");
    }

    public static void ej1() {
        try {
            File d = new File("./d");
            File d1 = new File("./d/d1");
            File f11 = new File("./d/d1/f11.txt");
            File f12 = new File("./d/d1/f12.txt");
            File d2 = new File("./d/d2");
            File d21 = new File("./d/d2/d21");
            File f21 = new File("./d/d2/f21.txt");
            File d22 = new File("./d/d2/d22");
            File f22 = new File("./d/d2/d22/f222.txt");
            File d3 = new File("./d/d3");
            File d31 = new File("./d/d3/d31");

            d.mkdir();
            d1.mkdir();
            f11.createNewFile();
            f12.createNewFile();
            d2.mkdir();
            d21.mkdir();
            f21.createNewFile();
            d22.mkdir();
            f22.createNewFile();
            d3.mkdir();
            d31.mkdir();

            System.out.println("Arbol de directorios creado correctamente.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void ej2() {
        System.out.println("Contenidos del directorio d");

        File d = new File("./d");
        File[] con = d.listFiles();

        for (File a : con) {
            System.out.println(a.getName());

            if (a.isDirectory()) {
                File[] c = a.listFiles();
                for (File x : c) {
                    System.out.println("\t" + x.getName());

                    if (x.isDirectory()) {
                        File[] b = x.listFiles();
                        for (File x1 : b) {
                            System.out.println("\t\t" + x1.getName());
                        }
                    }
                }
            }
        }
    }

    public static void ej3(String dir) {
        System.out.println("Contenidos del directorio "+dir);

        File d = new File(dir);
        File[] con = d.listFiles();

        for (File a : con) {
            System.out.println(a.getName());

            if (a.isDirectory()) {
                File[] c = a.listFiles();
                for (File x : c) {
                    System.out.println("\t" + x.getName());

                    if (x.isDirectory()) {
                        File[] b = x.listFiles();
                        for (File x1 : b) {
                            System.out.println("\t\t" + x1.getName());
                        }
                    }
                }
            }
        }
    }

    public static void ej4(String dir, String ext) {
         System.out.println("Contenidos del directorio "+dir);

         File d = new File(dir);
         File [] con = d.listFiles();

         for (File a : con) {
            if (a.getName().contains(ext)) {
                System.out.println(a.getName());
            }
         }
    }

    public static void ej5(String dir) {
        File d = new File(dir);
        File [] con = d.listFiles();

        for (File a : con) {
            if (a.getName().contains(".txt")) {
                a.delete();
            }
        }

        System.out.println("Archivos eliminados correctamente.");
    }
}
