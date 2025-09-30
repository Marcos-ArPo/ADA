package main.java.prac1;

import java.io.*;

public class caracteres {
    public static void main(String[] args) {
        System.out.println();
        ej1();
        System.out.println();
        ej2();
        System.out.println();
        ej3();
        System.out.println();
        ej4();
        System.out.println();
        ej5();
        System.out.println();
        ej6();
    }

    public static void ej1() {
        try {
            FileWriter fw = new FileWriter("./ej1.txt");

            fw.write("Hola mundo");

            fw.close();

            System.out.println("Contenido escrito");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void ej2() {
        try {
            FileWriter fw = new FileWriter("./ej1.txt", true);

            fw.write("\n Segunda linea");

            fw.close();

            System.out.println("Nuevo contenido escrito");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void ej3() {
        try {
            FileReader fr = new FileReader("./ej1.txt");

            int car = 0;
            while (car != -1) {
                car = fr.read();
                if (car != -1) {
                    System.out.print((char) car);
                }
            }
            System.out.println();
            fr.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void ej4() {
        try {
            FileWriter fw = new FileWriter("./ej1.txt", true);
            fw.write("\n\tContenido extra");
            fw.close();

            FileReader fr = new FileReader("./ej1.txt");
            int car = 0;
            while (car != -1) {
                car = fr.read();
                if (car != -1) {
                    System.out.print((char) car);
                }
            }
            System.out.println();
            fr.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void ej5() {
        try {
            FileReader fr = new FileReader("./ej1.txt");
            int car = 0;
            int con = 0;
            while (car != -1) {
                car = fr.read();
                if (car != -1) {
                    con++;
                }
            }
            System.out.println("Hay un total de "+con+" caracteres.");
            fr.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void ej6() {
        try {
            FileReader fr = new FileReader("./ej1.txt");
            FileWriter fw = new FileWriter("./copia.txt");

            int car = 0;
            while (car != -1) {
                car = fr.read();
                if (car != -1) {
                    fw.write((char)car);
                }
            }

            fr.close();
            fw.close();

            System.out.println("Contenido copiado a otro fichero");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
