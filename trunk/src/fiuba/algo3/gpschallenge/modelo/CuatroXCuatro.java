package fiuba.algo3.gpschallenge.modelo;

public class CuatroXCuatro implements EstadoVehiculo {
	
private double probabilidadDePasarUnControlPolicial;
	
	public CuatroXCuatro(){
		this.probabilidadDePasarUnControlPolicial = 0.3;
	}

	@Override
	public void pasaPorPozo(Vehiculo vehiculo) {	
	}

	@Override
	public void piquete(Vehiculo vehiculo, Vector direccion) {
		// TODO Auto-generated method stub
		
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
		vehiculo.setEstado(new Moto());
	}

}
