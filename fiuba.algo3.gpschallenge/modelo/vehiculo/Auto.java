package modelo.vehiculo;

import static org.junit.Assert.fail;
import modelo.interfaces.EstadoVehiculo;
import modelo.juego.Vector;

import org.jdom.Attribute;
import org.jdom.Element;

public class Auto implements EstadoVehiculo {
	
	 final double PUNTOS_PIQUETE = 30;
	 final double PUNTOS_POZO = 40;
	 final double PUNTOS_CONTROLPOLICIAL_CON_PENALIZACION = 20;
	 final double PUNTOS_CONTROLPOLICIAL_SIN_PENALIZACION = 70;
	
	private double probabilidadDePasarUnControlPolicial;
	
	public Auto(){
		this.probabilidadDePasarUnControlPolicial = 0.5;
	}
	

	@Override
	public void pasaPorPozo(Vehiculo vehiculo) {
		
		vehiculo.sumarMovimientos(3);
		vehiculo.sumarPuntos(PUNTOS_POZO);
		vehiculo.avanzarAFinalDeCuadra();
		
	}

	@Override
	public void piquete(Vehiculo vehiculo) {
		
		vehiculo.pegarLaVuelta();
		vehiculo.sumarMovimientos(1);
		vehiculo.sumarPuntos(PUNTOS_PIQUETE);
	}


	public void controlPolicial(Vehiculo vehiculo, double probabilidad) {
	
		if ( probabilidad <= this.getProbabilidadDePasarUnControlPolicial())
		{
			vehiculo.sumarMovimientos(3);
			vehiculo.sumarPuntos(PUNTOS_CONTROLPOLICIAL_CON_PENALIZACION);
		}else{

			vehiculo.sumarPuntos(PUNTOS_CONTROLPOLICIAL_SIN_PENALIZACION);
		}
		vehiculo.avanzarAFinalDeCuadra();
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
