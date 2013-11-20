package fiuba.algo3.gpschallenge.modelo;

public interface Evento {

	public abstract void afectar(Vehiculo vehiculo);

	public abstract void setPosicion(Vector posicion);

	public abstract Vector getPosicion();
	
}
