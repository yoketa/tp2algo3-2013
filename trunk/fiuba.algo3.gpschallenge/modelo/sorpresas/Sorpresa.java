package modelo.sorpresas;

import org.jdom.Element;

import modelo.interfaces.Evento;
import modelo.juego.Vector;
import modelo.vehiculo.Vehiculo;

public abstract class Sorpresa implements Evento {

	public Vector posicion;
	
	public Sorpresa () {
		this.posicion = new Vector(0,0);
	}
	
	public Sorpresa (Vector _posicion) {
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

	public abstract Element serializarXML();
}
