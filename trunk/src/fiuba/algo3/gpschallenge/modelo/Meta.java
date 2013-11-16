package fiuba.algo3.gpschallenge.modelo;

public class Meta {

	private Vector vector;

	public Meta(int x,int y){
		this.vector = new Vector(x,y);
	}

	public int getPosicionVertical() {
		return this.vector.getY();
	}

	public int getPosicionHorizontal() {
		return this.vector.getX();
	}
}
