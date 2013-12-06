package vistas;

import java.io.File;
import java.io.IOException;

import modelo.juego.*;
import fiuba.algo3.titiritero.dibujables.Imagen;

public class VistaDeOscurecimiento extends Imagen  {

	public VistaDeOscurecimiento(Oscurecimiento modelo)
			throws IOException {
		super(new File("images/oscurecimiento_transp.png").toURI().toURL(), modelo);
	}

}
