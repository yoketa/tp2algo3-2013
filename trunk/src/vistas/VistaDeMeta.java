package vistas;

import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import modelo.juego.*;
import fiuba.algo3.titiritero.dibujables.*;
import fiuba.algo3.titiritero.modelo.ObjetoPosicionable;
import fiuba.algo3.titiritero.modelo.SuperficieDeDibujo;

public class VistaDeMeta extends Circulo {

	public VistaDeMeta(Meta meta) {
		super(20, meta);
		this.setColor(Color.BLUE);
		// TODO Auto-generated constructor stub
	}
}
