package ejs;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class ej2 {
    private static final File ruta = new File("./coleccion_peliculas.xml");

    public static void main(String[] args) throws Exception {
        System.out.println("\nEjercicio 2.1");
        ej21(20);
        System.out.println("\nEjercicio 2.2");
        ej22("9", "Avengers: Endgame", "Hermanos Russo", "2019", "Accion", "250000000");
        System.out.println("\nEjercicio 2.3.1");
        ej231(1990);
        System.out.println("\nEjercicio 2.3.2");
        ej232(200000000);
    }

    public static void ej21(int por) throws Exception {
        double p = ((double) por + 100) / 100;
        Document doc = crearDocumento(ruta);

        NodeList list = pelis(doc);
        for (int i = 0; i < list.getLength(); i++) {
            Element peli = (Element) list.item(i);
            String recS = peli.getElementsByTagName("recaudacion").item(0).getTextContent();
            double rec = Double.valueOf(recS) * p;
            int x = (int) rec;
            peli.getElementsByTagName("recaudacion").item(0).setTextContent(String.valueOf(x));
        }
        pasarAXML(doc, ruta);
        System.out.println("Recaudaciones aumentadas.");
    }

    public static void ej22(String id, String titulo, String director, String anio, String genero, String recaudacion)
            throws Exception {
        Document doc = crearDocumento(ruta);
        Element peli = doc.createElement("pelicula");
        peli.setAttribute("id", id);
        Element tit = doc.createElement("titulo");
        tit.setTextContent(titulo);
        Element dir = doc.createElement("director");
        dir.setTextContent(director);
        Element ann = doc.createElement("anno_estreno");
        ann.setTextContent(anio);
        Element gen = doc.createElement("genero");
        gen.setTextContent(genero);
        Element rec = doc.createElement("recaudacion");
        rec.setTextContent(recaudacion);
        peli.appendChild(tit);
        peli.appendChild(dir);
        peli.appendChild(ann);
        peli.appendChild(gen);
        peli.appendChild(rec);
        doc.getDocumentElement().getElementsByTagName("peliculas").item(0).appendChild(peli);
        pasarAXML(doc, ruta);
        System.out.println("Pelicula añadida correctamente.");
    }

    public static void ej231(int anio) throws Exception{
        Document doc = crearDocumento(ruta);
        XPath xpath = XPathFactory.newInstance().newXPath();

        String consulta = "coleccion_peliculas/peliculas/pelicula[anno_estreno<'"+anio+"']";

        NodeList list= (NodeList) xpath.evaluate(consulta, doc, XPathConstants.NODESET);
        for (int i = 0; i < list.getLength(); i++) {
            System.out.println("Pelicula " + (i + 1) + ":");
            String titulo = xpath.evaluate("titulo", list.item(i));
            String director = xpath.evaluate("director", list.item(i));
            String anno = xpath.evaluate("anno_estreno", list.item(i));

            System.out.println("  Marca: " + titulo);
            System.out.println("  Modelo: " + director);
            System.out.println("  Matricula: " + anno);
            System.out.println();
        }
    }

    public static void ej232(int rec) throws Exception{
        Document doc = crearDocumento(ruta);
        XPath xpath = XPathFactory.newInstance().newXPath();

        String consulta = "coleccion_peliculas/peliculas/pelicula[recaudacion>'"+rec+"']";

        NodeList list= (NodeList) xpath.evaluate(consulta, doc, XPathConstants.NODESET);
        for (int i = 0; i < list.getLength(); i++) {
            System.out.println("Pelicula " + (i + 1) + ":");
            String titulo = xpath.evaluate("titulo", list.item(i));
            String recaudacion = xpath.evaluate("recaudacion", list.item(i));

            System.out.println("  Marca: " + titulo);
            System.out.println("  Modelo: " + recaudacion);
            System.out.println();
        }
    }

    // Metodos necesarios para la modificacion del XML
    public static Document crearDocumento(File f) throws Exception {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.parse(f);
        return doc;
    }

    public static void pasarAXML(Document doc, File f) throws Exception {
        Transformer tr = TransformerFactory.newInstance().newTransformer();
        tr.setOutputProperty(OutputKeys.INDENT, "no");
        tr.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
        StreamResult result = new StreamResult(f);
        DOMSource src = new DOMSource(doc);
        tr.transform(src, result);
    }

    public static NodeList pelis(Document doc) throws Exception {
        Element raiz = doc.getDocumentElement();
        NodeList l = raiz.getElementsByTagName("pelicula");
        return l;
    }
}
