package fiuba.algo3.gpschallenge.modelo;

public class CambioDeVehiculo extends Sorpresa {
	
	@Override
	public void afectar(Vehiculo vehiculo){
		vehiculo.cambiarEstado();
	}
}
