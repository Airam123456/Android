package com.example.examenfinal;

import android.sax.Element;
import android.sax.RootElement;
import android.util.Xml;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class RssParserSAXSimplificadoTiempo {

    private final URL rssUrl;
    private ElTiempo tiempoActual, timepoMañana, tiempoPasado;

    // Constructor que recibe la URL
    public RssParserSAXSimplificadoTiempo(String url) {
        try {
            this.rssUrl = new URL (url);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    // Metodo parse que devuelve un objeto ElTiempo
    public ElTiempo parse(){
        // Coge el elemento root
        RootElement root = new RootElement("data");

        // Cuando empieza el elemento root, crea el objeto ElTiempo
        root.setStartElementListener(attributes -> tiempoActual = new ElTiempo());

        // Coge los datos en referencia al dia
        Element day1 = root.getChild("day1");
        day1.getChild("date").setEndTextElementListener(body1 -> tiempoActual.setDia(body1));
        day1.getChild("temperature_max").setEndTextElementListener(body1 -> tiempoActual.setTemperatura_max(body1));
        day1.getChild("temperature_min").setEndTextElementListener(body1 -> tiempoActual.setTemperatura_min(body1));
        day1.getChild("text").setEndTextElementListener(body1 -> tiempoActual.setEstado(body1));

        // Coge los datos en referencia a la hora actual
        Element hour_hour1 = root.getChild("hour_hour");
        Element hour1 = hour_hour1.getChild("hour1");
        hour1.getChild("hour_data").setEndTextElementListener(body1 -> tiempoActual.setHora(body1));
        hour1.getChild("temperature").setEndTextElementListener(body1 -> tiempoActual.setTemperatura(body1));
        hour1.getChild("icon").setEndTextElementListener(body1 -> tiempoActual.setIcono(body1));

        try {
            Xml.parse(this.getInputStream(),
                    Xml.Encoding.ISO_8859_1,
                    root.getContentHandler());
        }catch (Exception e){
            throw new RuntimeException(e);
        }
        return tiempoActual;
    }

    public ElTiempo parse2()
    {
        // Coge el elemento root
        RootElement root = new RootElement("data");
        // Cuando empieza el elemento root, crea el objeto ElTiempo
        root.setStartElementListener(attributes -> timepoMañana = new ElTiempo());

        // Coge los datos en referencia al dia
        Element day2 = root.getChild("day2");
        day2.getChild("date").setEndTextElementListener(body2 -> timepoMañana.setDia(body2));
        day2.getChild("temperature_max").setEndTextElementListener(body2 -> timepoMañana.setTemperatura_max(body2));
        day2.getChild("temperature_min").setEndTextElementListener(body2 -> timepoMañana.setTemperatura_min(body2));
        day2.getChild("text").setEndTextElementListener(body2 -> timepoMañana.setEstado(body2));
        day2.getChild("icon").setEndTextElementListener(body2 -> timepoMañana.setIcono(body2));

        try {
            Xml.parse(this.getInputStream(),
                    Xml.Encoding.ISO_8859_1,
                    root.getContentHandler());
        }catch (Exception e){
            throw new RuntimeException(e);
        }
        return timepoMañana;
    }

    public ElTiempo parse3()
    {
        // Coge el elemento root
        RootElement root = new RootElement("data");
        // Cuando empieza el elemento root, crea el objeto ElTiempo
        root.setStartElementListener(attributes -> tiempoPasado = new ElTiempo());

        // Coge los datos en referencia al dia
        Element day3 = root.getChild("day3");
        day3.getChild("date").setEndTextElementListener(body3 -> tiempoPasado.setDia(body3));
        day3.getChild("temperature_max").setEndTextElementListener(body3 -> tiempoPasado.setTemperatura_max(body3));
        day3.getChild("temperature_min").setEndTextElementListener(body3 -> tiempoPasado.setTemperatura_min(body3));
        day3.getChild("text").setEndTextElementListener(body3 -> tiempoPasado.setEstado(body3));
        day3.getChild("icon").setEndTextElementListener(body3 -> tiempoPasado.setIcono(body3));
        try {
            Xml.parse(this.getInputStream(),
                    Xml.Encoding.ISO_8859_1,
                    root.getContentHandler());
        }catch (Exception e){
            throw new RuntimeException(e);
        }
        return tiempoPasado;
    }


    private InputStream getInputStream() {
        try {
            return rssUrl.openConnection().getInputStream();
        }catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
