package modelo.juego;

import java.util.Observable;

import modelo.juego.Vector;

import fiuba.algo3.titiritero.modelo.ObjetoPosicionable;
import fiuba.algo3.titiritero.modelo.ObjetoVivo;

public class Oscurecimiento implements ObjetoPosicionable, ObjetoVivo {

	private int x;
	private int y;
	
	private static final int tamañoX = -1880;
	private static final int tamañoY = -952;
	
	public Oscurecimiento() {
		this.x = Oscurecimiento.tamañoX/2;
		this.y = Oscurecimiento.tamañoY/2;
	}
	
	public void setX(int x) {
		this.x = x + Oscurecimiento.tamañoX/2;
	}
	
	public void setY(int y) {
		this.y = y + Oscurecimiento.tamañoY/2;
	}
	
	@Override
	public void vivir() {
		
	}

	@Override
	public int getX() {
		return this.x;
	}

	@Override
	public int getY() {
		return this.y;
	}

}
