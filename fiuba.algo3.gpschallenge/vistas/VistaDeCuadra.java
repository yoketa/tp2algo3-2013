package vistas;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import fiuba.algo3.titiritero.dibujables.*;
import fiuba.algo3.titiritero.modelo.ObjetoPosicionable;

import java.util.Observable;
import java.util.Observer;

import modelo.juego.Cuadra;
import modelo.vehiculo.*;

public class VistaDeCuadra extends Imagen {

        public VistaDeCuadra(Cuadra modelo) throws IOException {            
                super(getURLImagenCuadra(), modelo);
        }
        
        private static URL getURLImagenCuadra() {
                ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
                URL url = classLoader.getResource("auto.png");
                try {
                        return new File("Escritorio\\cuadra.png").toURI().toURL();
                } catch (MalformedURLException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                }
                return null;
        }
}