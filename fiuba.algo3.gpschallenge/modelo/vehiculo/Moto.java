package modelo.vehiculo;

import modelo.interfaces.EstadoVehiculo;
import modelo.juego.Vector;

import org.jdom.Attribute;
import org.jdom.Element;

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
	public void setProbabilidadDePasarUnControlPolicial(double probabilidad){
		this.probabilidadDePasarUnControlPolicial = probabilidad;
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
	
	public Element serializarXML() {
		Element element = new Element("Moto");
		Attribute att1 = new Attribute("probabilidadDePasarUnControlPolicial",Double.valueOf(probabilidadDePasarUnControlPolicial).toString());
		element.getAttributes().add(att1);
		return element;
	}

	public static Moto cargarDesdeXML(Element element) {
		String probabilidad = element.getAttributeValue("probabilidadDePasarUnControlPolicial");
		Moto moto = new Moto(); 
		moto.setProbabilidadDePasarUnControlPolicial(Double.parseDouble(probabilidad));
		return moto;
	}
}
