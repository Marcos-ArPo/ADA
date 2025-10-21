package ejs.XML;

import java.io.File;


import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class ej2 {
    public static void main(String[] args) throws Exception {
        
    }

    public static Element buscarCoche(Document doc, String matricula) {
        Element raiz = doc.getDocumentElement();
        NodeList list = raiz.getElementsByTagName("coche");
        for (int i=0; i<list.getLength();i++) {
            Element coche = (Element) list.item(i);

            if (coche.getAttribute(matricula).equals(matricula)) {
                return coche;
            }
        }
        return null;
    }
}
