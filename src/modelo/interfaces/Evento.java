package modelo.interfaces;

import modelo.juego.Vector;
import modelo.vehiculo.Vehiculo;

public interface Evento {

	public abstract void afectar(Vehiculo vehiculo);

	public abstract void setPosicion(Vector posicion);

	public abstract Vector getPosicion();

	}
