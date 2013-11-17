package fiuba.algo3.gpschallenge.modelo;

public class SorpresaDesfavorable extends Sorpresa {

	@Override
	public void afectar(Vehiculo vehiculo) {
		vehiculo.penalizacionDesfavorable();
	}
	
}
