package main.java.prac1;

import java.io.*;
import java.util.Scanner;

public class flujobytes {
    public static void main(String[] args) {
        System.out.println();
        // ej1();
        System.out.println();
        ej2();
        System.out.println();
        ej3();
    }

    public static void ej1() {
        try {
            FileInputStream ori = new FileInputStream("./monster.jpeg");
            FileOutputStream cop = new FileOutputStream("./copy.jpeg");

            byte[] bff = new byte[1024];
            int byteleido;

            while ((byteleido = ori.read(bff)) != -1) {
                cop.write(bff, 0, byteleido);
            }
            ori.close();
            cop.close();

            System.out.println("Imagen copiada");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void ej2() {
        try {
            DataOutputStream dos = new DataOutputStream(new FileOutputStream("./parejas.dat"));
            Scanner sc = new Scanner(System.in);

            while (true) {
                System.out.println("Primer numero");
                String l1 = sc.nextLine();

                if (l1.isEmpty()) {
                    break;
                }

                System.out.println("Segundo numero");
                String l2 = sc.nextLine();

                if (l2.isEmpty()) {
                    break;
                }

                dos.writeInt(Integer.parseInt(l1));
                dos.writeChar(' ');
                dos.writeInt(Integer.parseInt(l2));
                dos.writeChar('\n');
            }

            dos.close();
            sc.close();
            System.out.println("Contenido escrito");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void ej3() {

        int suma = 0;
        int c = 0;
        long sumaPon = 0;
        long sumaPes = 0;

        try (DataInputStream dis = new DataInputStream(new FileInputStream("./parejas.dat"));) {
            

            while (true) {
                int c1 = dis.readInt();
                int c2 = dis.readInt();

                suma += c1;
                sumaPon += c1 * c2;
                sumaPes += c2;
                c++;
            }

            
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (c > 0) {
            double mediaA = (double) suma / c;
            double mediaP = (sumaPes > 0) ? (double) sumaPon / sumaPes : 0;

            System.out.println("Media aritmetica --> " + mediaA);
            System.out.println("Media ponderada --> " + mediaP);
        } else {
            System.out.println("No hay datos en el fichero");
        }
    }
}
