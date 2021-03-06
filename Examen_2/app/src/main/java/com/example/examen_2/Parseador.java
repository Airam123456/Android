package com.example.examen_2;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class Parseador {

    private URL rssURL;
    public Parseador(String url) {
        try {
            this.rssURL = new URL (url);
        }
        catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    public Tiempo parse() {
        //Instanciamos la fabrica para DOM
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        Tiempo tiempo = null;
        try {
            //Creamos un nuevo parser DOM y realizamos lectura
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document dom = builder.parse(this.getInputStream());
            Element root = dom.getDocumentElement();
            NodeList listaNodos = root.getChildNodes();
            for (int i = 0; i < listaNodos.getLength(); i++) {
                //Obtenemos el dia actual
                Node dia = listaNodos.item(i);
                String etiquetaDia = dia.getNodeName();
                System.out.println(etiquetaDia);
                if(etiquetaDia.equals("day1")) {
                    NodeList datosDia = dia.getChildNodes();
                    String date = "";
                    String temperature_max = "0";
                    String temperature_min = "0";
                    String text = "";
                    for (int j = 0; j < datosDia.getLength(); j++) {
                        Node dato = datosDia.item(j);
                        String etiqueta = dato.getNodeName();
                        if (etiqueta.equals("date"))
                            date = obtenerTexto(dato);
                        else if(etiqueta.equals("temperature_max"))
                            temperature_max = obtenerTexto(dato);
                        else if(etiqueta.equals("temperature_min"))
                            temperature_min = obtenerTexto(dato);
                        else if(etiqueta.equals("text"))
                            text = obtenerTexto(dato);
                    }
                    tiempo = new Tiempo(date, Integer.parseInt(temperature_max), Integer.parseInt(temperature_min), text);
                    return tiempo;
                }
            }
        }
        catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        return tiempo;
    }

    public String obtenerTexto (Node dato) {
        StringBuilder texto = new StringBuilder();
        NodeList fragmentos = dato.getChildNodes();
        for (int k = 0; k < fragmentos.getLength(); k++)
            texto.append(fragmentos.item(k).getNodeValue());

        return texto.toString();
    }

    private InputStream getInputStream() {
        try {
            return rssURL.openConnection().getInputStream();
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
