package modelo.juego;

import java.util.*;

import modelo.vehiculo.ComparadorVehiculosPorPuntaje;
import modelo.vehiculo.Vehiculo;

import org.jdom.Attribute;
import org.jdom.Element;

/**
 * Clase que representa al ranking de puntajes.
 * 
 */

public class Ranking {
	/* 
	 * El archivo vehiculo.xml se encuentra en la siguiente direccion y en la carpeta save del tp.
	 * para hacer la prueba se debe crear la carpeta persistencia en el disco C por un motivo de comodidad
	 * al sincronizar con el repositorio.
	*/
	public static String rankingPath = "C:\\Persistencia\\Ranking.xml";
	private Comparator unComparador;
	private List<Vehiculo> mejoresPuntajes;

	public Ranking(){
		this.mejoresPuntajes = new ArrayList<Vehiculo>();
		this.unComparador = new ComparadorVehiculosPorPuntaje();
	}

	public Ranking(List<Vehiculo> mejoresPuntajes){
		this.mejoresPuntajes = mejoresPuntajes;
		this.unComparador = new ComparadorVehiculosPorPuntaje();
	}
	
	public List<Vehiculo> getPuntajes() {
		// TODO Auto-generated method stub
		return this.mejoresPuntajes;
	}
		
	/**
	 * agrego el puntaje del vehiculo al ranking de manera ordenada
	 *
	 * @param unVehiculo
	 */
	public void agregarPuntaje(Vehiculo unVehiculo){
		if(this.mejoresPuntajes.size()==0){
			this.mejoresPuntajes.add(unVehiculo);
		}
		else {
			this.mejoresPuntajes.add(unVehiculo);
			java.util.Collections.sort(mejoresPuntajes,unComparador);
			java.util.Collections.reverse(mejoresPuntajes);
		}
	}

	// BEGIN Serialización
	public Element serializarXML() {
		Element element = new Element("Ranking");
		
		for (Vehiculo puntajeJugador : mejoresPuntajes) {
			Element entradaPuntaje = new Element("Puntaje");
			Attribute att1 = new Attribute("puntaje",Double.valueOf(puntajeJugador.getPuntaje()).toString());
			Attribute att2 = new Attribute("piloto",String.valueOf(puntajeJugador.getPiloto()).toString());
			entradaPuntaje.getAttributes().add(att1);
			entradaPuntaje.getAttributes().add(att2);
			
			element.addContent(entradaPuntaje);
		}
		
		return element;
	}
	
	public static Ranking cargarDesdeXML(Element element) {
		List<Vehiculo> puntajes = new ArrayList<Vehiculo>();
		for (Object puntajeGuardado : element.getChildren()) {
			double puntaje = Double.parseDouble(((Element)puntajeGuardado).getAttributeValue("puntaje").toString());
			String nombreJugador = ((Element)puntajeGuardado).getAttributeValue("piloto").toString();
			Vehiculo mejorPuntaje = Vehiculo.crearConPiloto(nombreJugador, 0, 0);
			mejorPuntaje.setPuntaje(puntaje);
			
			puntajes.add(mejorPuntaje);			
		}
		
		Ranking ranking = new Ranking(puntajes);
		
		return ranking;
	}	
	// END Serialización
}
