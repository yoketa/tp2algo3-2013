package vistas;

import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import modelo.obstaculo.*;
import fiuba.algo3.titiritero.dibujables.Imagen;
import fiuba.algo3.titiritero.modelo.ObjetoPosicionable;

public class VistaDeObstaculo extends Imagen {

        public VistaDeObstaculo(Obstaculo modelo)
                        throws IOException {
                super(new File(getImagen(modelo)).toURI().toURL(), modelo);
                // TODO Auto-generated constructor stub
        }

	public static String getImagen(Obstaculo modelo) {
		String clase = modelo.getClass().toString();
		switch (clase) {
		case "class modelo.obstaculo.Pozo":
			return "images/pozo.png";
		case "class modelo.obstaculo.ControlPolicial":
			return "images/controlPolicial.png";
		case "class modelo.obstaculo.Piquete":
			return "images/piquete.png";

		}
		return "";
		
	}


}