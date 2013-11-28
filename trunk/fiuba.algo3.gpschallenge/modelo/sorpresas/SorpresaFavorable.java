package modelo.sorpresas;

import modelo.vehiculo.Vehiculo;

public class SorpresaFavorable extends Sorpresa {
	
	@Override
	public void afectar(Vehiculo vehiculo) {
		vehiculo.penalizacionFavorable();
	}
}
