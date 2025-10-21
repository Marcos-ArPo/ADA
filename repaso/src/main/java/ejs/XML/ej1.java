package ejs.XML;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class ej1 {
    public static void main(String[] args) throws Exception {
        crearXML("concesionario.xml");
        Document doc = crearDocumento("concesionario.xml");

        agregarCoche(doc, "Toyota", "Corolla", "1234ABC", 50000, 1, 2018);
        agregarCoche(doc, "Honda", "Civic", "5678DEF", 30000, 2, 2020);

        pasarAXML(doc, "concesionario.xml");
    }

    public static void agregarCoche(Document doc, String marca, String modelo, String matricula, int kms, int estado, int fab) {
        Element coche = doc.createElement("coche");
        coche.setAttribute("matricula", matricula);
        Element marcaElem = doc.createElement("marca");
        marcaElem.setTextContent(marca);
        Element modeloElem = doc.createElement("modelo");
        modeloElem.setTextContent(modelo);
        Element kmsElem = doc.createElement("kms");
        kmsElem.setTextContent(String.valueOf(kms));
        Element estadoElem = doc.createElement("estado");
        estadoElem.setTextContent(String.valueOf(estado));
        Element fabElem = doc.createElement("fabricacion");
        fabElem.setTextContent(String.valueOf(fab));
        coche.appendChild(marcaElem);
        coche.appendChild(modeloElem);
        coche.appendChild(kmsElem);
        coche.appendChild(estadoElem);
        coche.appendChild(fabElem);
        doc.getDocumentElement().getElementsByTagName("coches").item(0).appendChild(coche);
    }

    public static Document crearDocumento(String ruta) throws Exception {
        File f = new File(ruta);
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.parse(f);
        return doc;
    }

    public static void crearXML(String ruta) throws Exception {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.newDocument();

        Element raiz = doc.createElement("concesionario");
        Element nombre = doc.createElement("nombre");
        nombre.setTextContent("Concesionario Pitillo");
        Element direccion = doc.createElement("direccion");
        direccion.setTextContent("Calle Peo 69");
        Element coches = doc.createElement("coches");
        raiz.appendChild(nombre);
        raiz.appendChild(direccion);
        raiz.appendChild(coches);
        doc.appendChild(raiz);

        pasarAXML(doc, ruta);
    }

    public static void pasarAXML(Document doc, String ruta) throws Exception{
        File f = new File(ruta);
        Transformer tr = TransformerFactory.newInstance().newTransformer();
        tr.setOutputProperty(OutputKeys.INDENT, "yes");
        tr.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
        StreamResult result = new StreamResult(f);
        DOMSource src = new DOMSource(doc);
        tr.transform(src, result);
    }
}
