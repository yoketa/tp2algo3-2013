package modelo.vehiculo;

import fiuba.algo3.titiritero.modelo.ObjetoPosicionable;
import fiuba.algo3.titiritero.modelo.ObjetoVivo;

public class Cuadra implements ObjetoPosicionable, ObjetoVivo {

	private int x;
	private int y;

	public Cuadra(int x, int y) {
		this.x = x;
		this.y = y;
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
