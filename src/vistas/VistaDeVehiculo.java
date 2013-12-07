package vistas;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import fiuba.algo3.titiritero.dibujables.*;
import fiuba.algo3.titiritero.modelo.ObjetoPosicionable;

import java.util.Observable;
import java.util.Observer;

import modelo.vehiculo.Vehiculo;

public class VistaDeVehiculo extends Imagen {

	public VistaDeVehiculo(Vehiculo modelo) throws IOException {		
		super(new File(getImagen(modelo)).toURI().toURL(), modelo);
	}
	
	private static String getImagen(Vehiculo modelo) {
		String clase = modelo.getEstado().getClass().toString();
		switch (clase) {
		case "class modelo.vehiculo.Auto":
			return "images/auto.png";
		case "class modelo.vehiculo.CuatroXCuatro":
			return "images/4x4.gif";
		case "class modelo.vehiculo.Moto":
			return "images/moto.png";
		}
		return "";
	}
}

