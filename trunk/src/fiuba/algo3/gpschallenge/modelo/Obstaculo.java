package fiuba.algo3.gpschallenge.modelo;

public abstract class Obstaculo implements Evento {
	
	public Vector posicion;
	
	public Obstaculo () {
		this.posicion = new Vector(0,0);
	}
	
	public Obstaculo (Vector _posicion) {
		this.posicion = _posicion;
	}
	
	@Override
	public void afectar(Vehiculo vehiculo) {		
		
	}

}
