package modelo.vehiculo;

import java.util.Observable;

import modelo.juego.Vector;

import org.jdom.Attribute;
import org.jdom.Element;

import fiuba.algo3.titiritero.modelo.ObjetoPosicionable;
import fiuba.algo3.titiritero.modelo.ObjetoVivo;

public class Cuadra extends Observable implements ObjetoPosicionable, ObjetoVivo {

    private Vector posicion;


        public Cuadra(int x, int y){
        	this.posicion = new Vector(x,y);
        }
        
	@Override
        public int getY() {
                return this.posicion.getY();
        }

        @Override
        public int getX() {
                return this.posicion.getX();
        }

        @Override
        public void vivir() {
                                
        }



}