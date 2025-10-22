package ejs;

import java.io.*;
import java.util.*;

public class ej1 {
    public static void main(String[] args) throws Exception {
        try (Scanner sc = new Scanner(System.in);) {

            // El directorio de prueba es ./archs
            System.out.println("Dime el nombre del directorio");
            File dir = new File(sc.nextLine());

            if (dir.exists() && dir.isDirectory()) {
                int[] nums = new int[256];
                File[] arcs = dir.listFiles();
                for (File f : arcs) {
                    if (f.isDirectory()) {
                        File[] arcs2 = f.listFiles();
                        for (File f2 : arcs2) {
                            if (f2.isFile() && f2.getName().contains(".dat")) {
                                int i = 0, x;
                                try (DataInputStream dis = new DataInputStream(new FileInputStream(f2))) {
                                    while ((x = dis.readInt()) != -1) {
                                        nums[i] = x;
                                        i++;
                                    }
                                } catch (EOFException e) {
                                    continue;
                                }
                            } else {
                                continue;
                            }
                        }
                    } else {
                        if (f.isFile() && f.getName().contains(".dat")) {
                            int i = 0, x;
                            try (DataInputStream dis = new DataInputStream(new FileInputStream(f))) {
                                while ((x = dis.readInt()) != -1) {
                                    nums[i] = x;
                                    i++;
                                }
                            } catch (EOFException e) {
                                continue;
                            }
                        } else {
                            continue;
                        }
                    }
                }

                System.out.println("Comprobacion de que recorre los archivos y los lee");
                for (int x : nums) {
                    System.out.print(x+" ");
                }
            } else {
                System.out.println("El directorio no existe.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
