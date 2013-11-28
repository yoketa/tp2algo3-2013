package modelo.interfaces;

import modelo.juego.Vector;
import modelo.vehiculo.Vehiculo;

import org.jdom.Element;



public interface EstadoVehiculo {
	public void pasaPorPozo(Vehiculo vehiculo);
	public void piquete(Vehiculo vehiculo,Vector direccion);
	public void controlPolicial(Vehiculo vehiculo);
	public void penalizacionFavorable(Vehiculo vehiculo);
	public void penalizacionDesfavorable(Vehiculo vehiculo);
	public void cambiarEstado(Vehiculo vehiculo);
	public double getProbabilidadDePasarUnControlPolicial();
	public void setProbabilidadDePasarUnControlPolicial(double probabilidad);
	public abstract Element serializarXML();

}
