package modelo.sorpresas;

import modelo.vehiculo.Vehiculo;

public class CambioDeVehiculo extends Sorpresa {
	
	@Override
	public void afectar(Vehiculo vehiculo){
		vehiculo.cambiarEstado();
	}
}
