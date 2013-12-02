package vistas;

import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import fiuba.algo3.titiritero.dibujables.*;
import fiuba.algo3.titiritero.modelo.ObjetoPosicionable;

import java.util.Observable;
import java.util.Observer;

import modelo.juego.*;

public class VistaDeMeta extends Circulo{

	private final static int RADIO = 20;

        public VistaDeMeta(Meta modelo)  {            
                super(RADIO, modelo);
		this.setColor(Color.BLUE);
        }
}
