package vistas;

import java.io.File;
import java.io.IOException;

import modelo.sorpresas.*;
import fiuba.algo3.titiritero.dibujables.Imagen;


public class VistaDeSorpresa extends Imagen {
  private Sorpresa sorpresa;
        public VistaDeSorpresa(Sorpresa modelo)
                        throws IOException {
                super(new File("images/sorpresa.png").toURI().toURL(), modelo);
                // TODO Auto-generated constructor stub
                this.sorpresa = modelo;
        }
        
        public Sorpresa getSorpresa(){
        	return this.sorpresa;
        }
}