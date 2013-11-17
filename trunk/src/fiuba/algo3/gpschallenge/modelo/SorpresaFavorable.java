package fiuba.algo3.gpschallenge.modelo;

public class SorpresaFavorable extends Sorpresa {
	
	@Override
	public void afectar(Vehiculo vehiculo) {
		vehiculo.penalizacionFavorable();
	}
}
