package modelo.vehiculo;

import static org.junit.Assert.fail;
import modelo.interfaces.EstadoVehiculo;
import modelo.juego.Vector;

import org.jdom.Attribute;
import org.jdom.Element;

public class Auto implements EstadoVehiculo {
	
	private double probabilidadDePasarUnControlPolicial;
	
	public Auto(){
		this.probabilidadDePasarUnControlPolicial = 0.5;
	}
	

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
	public void controlPolicial(Vehiculo vehiculo) {
		double puntajeActual = vehiculo.getPuntaje();
		vehiculo.setPuntaje(puntajeActual + 3);
	}
	
	@Override
	public void setProbabilidadDePasarUnControlPolicial(double probabilidad){
		this.probabilidadDePasarUnControlPolicial = probabilidad;
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
		vehiculo.setEstado(new CuatroXCuatro());
	}

	public Element serializarXML() {
		Element element = new Element("Auto");
		Attribute att1 = new Attribute("probabilidadDePasarUnControlPolicial",Double.valueOf(probabilidadDePasarUnControlPolicial).toString());
		element.getAttributes().add(att1);
		return element;
	}

	public static Auto cargarDesdeXML(Element element) {
		String probabilidad = element.getAttributeValue("probabilidadDePasarUnControlPolicial");
		Auto auto = new Auto(); 
		auto.setProbabilidadDePasarUnControlPolicial(Double.parseDouble(probabilidad));
		return auto;
	}
}
