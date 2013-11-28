package modelo.obstaculo;

import modelo.interfaces.Evento;
import modelo.juego.Vector;
import modelo.vehiculo.Vehiculo;

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
	
	public void setPosicion(Vector posicion){
		this.posicion = posicion;
	}

	public Vector getPosicion(){
		return this.posicion;
	}
}
