package vistas;

import java.io.File;
import java.io.IOException;


import modelo.vehiculo.*;
import fiuba.algo3.titiritero.dibujables.Imagen;


public class VistaDeCuadra extends Imagen {

	public VistaDeCuadra(Cuadra modelo)
			throws IOException {
		super(new File("images/cuadra.png").toURI().toURL(), modelo);
		// TODO Auto-generated constructor stub
	}


}
