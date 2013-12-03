package vistas;

import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import modelo.vehiculo.*;
import fiuba.algo3.titiritero.dibujables.Imagen;
import fiuba.algo3.titiritero.modelo.ObjetoPosicionable;

public class VistaDeCuadra extends Imagen {

	public VistaDeCuadra(Cuadra modelo)
			throws IOException {
		super(new File("C:\\Users\\27176876544\\Downloads\\cuadra.png").toURI().toURL(), modelo);
		// TODO Auto-generated constructor stub
	}


}

