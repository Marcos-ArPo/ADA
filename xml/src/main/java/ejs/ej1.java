package ejs;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class ej1 {
    public static void main(String[] args) throws Exception{

        Document doc = crearDocumento("libreria.xml");
        
        agregarLibro(doc, "Don Quijote de la Mancha", "Miguel de Cervantes", "1234567890");
        agregarLibro(doc, "Lazarillo de Tormes", "Anonimo", "2345678901");
        agregarLibro(doc, "La vida es un sueño", "Pedro Calderón de la Barca", "4567890123");

        pasarAXML(doc, "libreria.xml");

    }

    // Método para pasar un Document a un archivo XML
    public static void pasarAXML(Document doc, String ruta) throws Exception {
        File f = new File(ruta);
        Transformer tr = TransformerFactory.newInstance().newTransformer();
        tr.setOutputProperty(OutputKeys.INDENT, "yes");
        tr.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
        StreamResult result = new StreamResult(f);
        DOMSource src = new DOMSource(doc);
        tr.transform(src, result);
    }

    // Método para leer un archivo XML y devolver un Document
    public static Document crearDocumento(String ruta) throws Exception {
        File f = new File(ruta);
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.parse(f);
        return doc;
    }

    // Método para agregar un libro al documento
    public static void agregarLibro(Document doc, String titulo, String autor, String isbn) {
        Element tituloElem = doc.createElement("titulo");
        Element autorElem = doc.createElement("autor");
        tituloElem.setTextContent(titulo);
        autorElem.setTextContent(autor);
        Element libroElem = doc.createElement("libro");
        libroElem.appendChild(tituloElem);
        libroElem.appendChild(autorElem);
        libroElem.setAttribute("isbn", isbn);
        doc.getDocumentElement().appendChild(libroElem);
    }

    public static void crearXML(String ruta) throws Exception {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.newDocument();

        Element raiz = doc.createElement("libreria");
        Element nombre = doc.createElement("nombre");
        nombre.setTextContent("Libreria Pepe");
        raiz.appendChild(nombre);
        Element libros = doc.createElement("libros");
        raiz.appendChild(libros);
        doc.appendChild(raiz);

        pasarAXML(doc, ruta);
    }
}