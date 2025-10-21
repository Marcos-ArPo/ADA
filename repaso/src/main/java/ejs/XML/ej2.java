package ejs.XML;

import java.util.Scanner;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class ej2 {
    public static void main(String[] args) throws Exception {
        new ej1();
        Scanner sc = new Scanner(System.in);
        Document doc = ej1.crearDocumento("concesionario.xml");
        System.out.println("Introduce la matricula del coche a modificar:");
        String mat = sc.nextLine();
        Element coche = buscarCoche(doc, mat);

        coche.getTextContent();

        System.out.println("Introduce los nuevos kms:");
        int kms = Integer.parseInt(sc.nextLine());
        coche.getElementsByTagName("kms").item(0).setTextContent(String.valueOf(kms));
        sc.close();
        ej1.pasarAXML(doc, "concesionario.xml");
    }

    public static Element buscarCoche(Document doc, String matricula) throws Exception {
        Element raiz = doc.getDocumentElement();
        NodeList list = raiz.getElementsByTagName("coche");
        for (int i=0; i<list.getLength();i++) {
            Element coche = (Element) list.item(i);
            String attr = coche.getAttribute("matricula");

            if (attr.equals(matricula)) {
                return coche;
            }
        }
        throw new Exception("Coche no encontrado");
    }
}
