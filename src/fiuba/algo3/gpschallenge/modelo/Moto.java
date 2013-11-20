package fiuba.algo3.gpschallenge.modelo;

public class Moto implements EstadoVehiculo {
	
	private double probabilidadDePasarUnControlPolicial;
	
	public Moto(){
		this.probabilidadDePasarUnControlPolicial = 0.8;
	}
	

	@Override
	public void pasaPorPozo(Vehiculo vehiculo) {
		double puntajeActual = vehiculo.getPuntaje();
		vehiculo.setPuntaje(puntajeActual + 3);
		
	}

	@Override
	public void piquete(Vehiculo vehiculo, Vector direccion) {
		double puntajeActual = vehiculo.getPuntaje();
		vehiculo.setPuntaje(puntajeActual + 2);
	}

	@Override
	public void controlPolicial(Vehiculo vehiculo) {
		double puntajeActual = vehiculo.getPuntaje();
		vehiculo.setPuntaje(puntajeActual + 3);
	}
	
	@Override
	public double getProbabilidadDePasarUnControlPolicial(){
		return this.probabilidadDePasarUnControlPolicial;
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
		vehiculo.setEstado(new Auto());		
	}

}
