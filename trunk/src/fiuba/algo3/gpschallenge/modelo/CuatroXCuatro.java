package fiuba.algo3.gpschallenge.modelo;

public class CuatroXCuatro implements EstadoVehiculo {

	@Override
	public void pasaPorPozo() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void piquete() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void penalizacionFavorable(Vehiculo vehiculo) {
		double puntajeActual = vehiculo.getPuntaje();
		vehiculo.setPuntaje(puntajeActual * 0.8);		
	}

	@Override
	public void penalizacionDesfavorable(Vehiculo vehiculo) {
		double puntajeActual = vehiculo.getPuntaje();
		vehiculo.setPuntaje(puntajeActual * 1.25);
	}

	@Override
	public void cambiarEstado(Vehiculo vehiculo) {
		vehiculo.setEstado(new Moto());
	}

	@Override
	public void controlPolicial() {
		// TODO Auto-generated method stub
		
	}

}
