package fiuba.algo3.gpschallenge.modelo;

import static org.junit.Assert.fail;

public class Auto implements EstadoVehiculo {
	

	@Override
	public void pasaPorPozo(Vehiculo vehiculo) {
		double puntajeActual = vehiculo.getPuntaje();
		vehiculo.setPuntaje(puntajeActual + 3);
		
	}

	@Override
	public void piquete(Vehiculo vehiculo, Vector direccion) {
		direccion.setX(direccion.getX()*(-1));
		direccion.setY(direccion.getY()*(-1));
		try {
			vehiculo.mover(direccion);	
		}
		catch (Exception e) {
			fail();
		}
	}

	@Override
	public void controlPolicial() {
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
		vehiculo.setEstado(new CuatroXCuatro());
	}

}
