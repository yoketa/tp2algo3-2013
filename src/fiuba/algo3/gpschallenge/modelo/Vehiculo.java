package fiuba.algo3.gpschallenge.modelo;

public class Vehiculo {

	private String piloto;
	private Vector posicion;
	
	public static Vehiculo crearConPiloto(String piloto,int x,int y) {
		Vehiculo vehiculo = new Vehiculo(x,y);
		vehiculo.setPiloto(piloto);
		return vehiculo;
	}

	public Vehiculo(int x, int y){
		this.posicion = new Vector(x,y);
	}
	
	private void setPiloto(String piloto) {
		this.piloto = piloto;		
	}

	public String getPiloto() {
		return this.piloto;
	}

	public int getPosicionVertical() {
		return this.posicion.getY();
	}

	public int getPosicionHorizontal() {
		return this.posicion.getX();
	}

}
