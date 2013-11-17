package fiuba.algo3.gpschallenge.modelo;

public interface EstadoVehiculo {
	public void pasaPorPozo();
	public void piquete();
	public void controlPolicial();
	public void penalizacionFavorable(Vehiculo vehiculo);
	public void penalizacionDesfavorable(Vehiculo vehiculo);
	public void cambiarEstado(Vehiculo vehiculo);
}
