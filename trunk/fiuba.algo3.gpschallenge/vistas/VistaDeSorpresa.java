package vistas;

import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import modelo.sorpresas.*;
import fiuba.algo3.titiritero.dibujables.Imagen;
import fiuba.algo3.titiritero.modelo.ObjetoPosicionable;

public class VistaDeSorpresa extends Imagen {

        public VistaDeSorpresa(Sorpresa modelo)
                        throws IOException {
                super(new File("GpsChallenge/images/sorpresa.png").toURI().toURL(), modelo);
                // TODO Auto-generated constructor stub
        }
}