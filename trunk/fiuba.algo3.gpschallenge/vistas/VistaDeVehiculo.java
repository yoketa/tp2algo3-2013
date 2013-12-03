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
		super(getURLImagenVehiculo(), modelo);
	}
	
	private static URL getURLImagenVehiculo() {
		try {
			return new File("GpsChallenge/images/auto.png").toURI().toURL();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}

