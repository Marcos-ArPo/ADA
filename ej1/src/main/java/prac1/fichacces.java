package prac1;

import java.io.*;

public class fichacces {
    public static void main(String[] args) {
        System.out.println();
        ej1();
        System.out.println();
        ej2();
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
        try (RandomAccessFile raf = new RandomAccessFile(new File("./numeros.txt"), "rw")) {
            FileWriter fw = new FileWriter("./numeros.txt");
            BufferedReader bf =new BufferedReader(new InputStreamReader(System.in));

            int n  = 1;

            System.out.println("Escribe 0 para terminar");
            while (n != 0) {
                n = Integer.parseInt(bf.readLine());
                fw.write(n);
            }

            long pos;
            int car;

            while (raf.getFilePointer() < raf.length()) {
                pos = raf.getFilePointer();
                car = raf.readInt();

                if (car == 5) {
                    raf.seek(pos);
                    raf.writeInt(0);
                }
            }

            fw.close();
            bf.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
