package modelo.juego;

import fiuba.algo3.titiritero.modelo.*;



public class Meta implements ObjetoPosicionable, ObjetoVivo {

	private Vector posicion;

	public Meta(int x,int y){
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
	
	//TODO: Borrar m�todos de prueba
	public void setY(int y)
	{
		this.posicion.setY(y);
	}

	public void setX(int x)
	{
		this.posicion.setX(x);
	}
	//END TODO

	@Override
	public void vivir() {
		// TODO Auto-generated method stub
		
	}
}
