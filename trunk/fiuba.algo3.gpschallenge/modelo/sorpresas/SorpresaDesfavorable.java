package modelo.sorpresas;

import modelo.vehiculo.Vehiculo;

public class SorpresaDesfavorable extends Sorpresa {

	@Override
	public void afectar(Vehiculo vehiculo) {
		vehiculo.penalizacionDesfavorable();
	}
	
}
