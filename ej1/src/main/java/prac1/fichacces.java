package prac1;

import java.io.*;

public class fichacces {
    public static void main(String[] args) {
        System.out.println();
        // ej1();
        System.out.println();
        ej2();
        leer();
    }

    public static void ej1() {
        try (RandomAccessFile raf = new RandomAccessFile(new File("./espacios.txt"), "rw");) {
            long pos;
            char car;

            while (raf.getFilePointer() < raf.length()) {
                pos = raf.getFilePointer();
                car = raf.readChar();

                if (car == ' ') {
                    raf.seek(pos);
                    raf.writeChar(0);
                }

                if (car == ';') {
                    break;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void ej2() {
        try (RandomAccessFile raf = new RandomAccessFile(new File("./numeros.dat"), "rw")) {
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

            int n = 1;

            System.out.println("Escribe 0 para terminar");
            while (n != 0) {
                n = Integer.parseInt(bf.readLine());
                raf.writeInt(n);
            }

            bf.close();


            raf.seek(0);
            try {
                for (;;) {
                    n = raf.readInt();
                    if (n == 5) {
                        raf.seek(raf.getFilePointer()-4);
                        raf.writeInt(0);
                    }
                }
            } catch (EOFException e) {
                System.out.println("fin de fichero");
            }

            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void leer() {
        try (RandomAccessFile raf = new RandomAccessFile(new File("./numeros.dat"), "rw")) {

            try {
                // bucle infinito
                for (;;) {
                    System.out.println(raf.readInt());
                }
            } catch (EOFException e) {
                System.out.println("pato");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
