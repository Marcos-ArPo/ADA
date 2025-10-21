package ejs.XML;

import javax.xml.xpath.*;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public class ej3 {
    public static void main(String[] args) throws Exception {
        new ej1();
        Document doc = ej1.crearDocumento("concesionario.xml");
        System.out.println("\nApartado A:");
        mostrarCoches(doc);
        System.out.println("\nApartado B:");
        despues2010(doc);
        System.out.println("\nApartado C:");
        estadoBueno(doc);
        System.out.println("\nApartado D:");
        cocheMat(doc, "6969XXX");
        System.out.println("\nApartado E:");
        cocheKms(doc);
    }

    public static void mostrarCoches(Document doc) throws Exception {
        XPath xpath = XPathFactory.newInstance().newXPath();

        String consulta = "/concesionario/coches/coche";

        NodeList listaCoches = (NodeList) xpath.evaluate(consulta, doc, XPathConstants.NODESET);
        for (int i=0; i<listaCoches.getLength(); i++) {
            System.out.println("Coche " + (i+1) + ":");
            String marca = xpath.evaluate("marca", listaCoches.item(i));
            String modelo = xpath.evaluate("modelo", listaCoches.item(i));
            String matricula = xpath.evaluate("@matricula", listaCoches.item(i));
            String kms = xpath.evaluate("kms", listaCoches.item(i));
            String estado = xpath.evaluate("estado", listaCoches.item(i));
            String fab = xpath.evaluate("fabricacion", listaCoches.item(i));

            System.out.println("  Marca: " + marca);
            System.out.println("  Modelo: " + modelo);
            System.out.println("  Matricula: " + matricula);
            System.out.println("  Kms: " + kms);
            System.out.println("  Estado: " + estado);
            System.out.println("  Fabricacion: " + fab);
        }
    }

    public static void despues2010(Document doc) throws Exception{
        XPath xpath = XPathFactory.newInstance().newXPath();

        String consulta = "/concesionario/coches/coche[fabricacion>2010]";

        NodeList lista = (NodeList) xpath.evaluate(consulta, doc, XPathConstants.NODESET);

        for (int i=0; i<lista.getLength(); i++) {
            String marca = xpath.evaluate("marca", lista.item(i));
            String modelo = xpath.evaluate("modelo", lista.item(i));
            String matricula = xpath.evaluate("@matricula", lista.item(i));
            String fab = xpath.evaluate("fabricacion", lista.item(i));

            System.out.println("Coche " + (i+1) + ":");
            System.out.println("  Marca: " + marca);
            System.out.println("  Modelo: " + modelo);
            System.out.println("  Matricula: " + matricula);
            System.out.println("  Fabricacion: " + fab);
        }
    }

    public static void estadoBueno(Document doc) throws Exception{
        XPath xpath = XPathFactory.newInstance().newXPath();

        String consulta = "/concesionario/coches/coche[estado>=4]";

        NodeList lista = (NodeList) xpath.evaluate(consulta, doc, XPathConstants.NODESET);

        for (int i=0; i<lista.getLength(); i++) {
            String marca = xpath.evaluate("marca", lista.item(i));
            String modelo = xpath.evaluate("modelo", lista.item(i));
            String matricula = xpath.evaluate("@matricula", lista.item(i));
            String estado = xpath.evaluate("estado", lista.item(i));

            System.out.println("Coche " + (i+1) + ":");
            System.out.println("  Marca: " + marca);
            System.out.println("  Modelo: " + modelo);
            System.out.println("  Matricula: " + matricula);
            System.out.println("  Estado: " + estado);
        }
    }

    public static void cocheMat(Document doc, String mat) throws Exception{
        XPath xpath = XPathFactory.newInstance().newXPath();

        String consulta = "/concesionario/coches/coche[@matricula='" + mat + "']";

        NodeList lista = (NodeList) xpath.evaluate(consulta, doc, XPathConstants.NODESET);

        for (int i=0; i<lista.getLength(); i++) {
            String marca = xpath.evaluate("marca", lista.item(i));
            String modelo = xpath.evaluate("modelo", lista.item(i));
            String matricula = xpath.evaluate("@matricula", lista.item(i));
            String estado = xpath.evaluate("estado", lista.item(i));

            System.out.println("Coche " + (i+1) + ":");
            System.out.println("  Marca: " + marca);
            System.out.println("  Modelo: " + modelo);
            System.out.println("  Matricula: " + matricula);
            System.out.println("  Estado: " + estado);
        }
    }

    public static void cocheKms(Document doc) throws Exception{
        XPath xpath = XPathFactory.newInstance().newXPath();

        String consulta = "/concesionario/coches/coche[kms<10000]";

        NodeList lista = (NodeList) xpath.evaluate(consulta, doc, XPathConstants.NODESET);

        for (int i=0; i<lista.getLength(); i++) {
            String marca = xpath.evaluate("marca", lista.item(i));
            String modelo = xpath.evaluate("modelo", lista.item(i));
            String matricula = xpath.evaluate("@matricula", lista.item(i));
            String kms = xpath.evaluate("kms", lista.item(i));

            System.out.println("Coche " + (i+1) + ":");
            System.out.println("  Marca: " + marca);
            System.out.println("  Modelo: " + modelo);
            System.out.println("  Matricula: " + matricula);
            System.out.println("  Kms: " + kms);
        }
    }
}
