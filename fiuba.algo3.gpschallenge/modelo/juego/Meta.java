package modelo.juego;



public class Meta {

	private Vector posicion;

	public Meta(int x,int y){
		this.posicion = new Vector(x,y);
	}

	public int getPosicionVertical() {
		return this.posicion.getY();
	}

	public int getPosicionHorizontal() {
		return this.posicion.getX();
	}
}
