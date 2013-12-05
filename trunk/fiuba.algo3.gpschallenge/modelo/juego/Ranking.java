package modelo.juego;

import java.util.*;

import modelo.vehiculo.ComparadorVehiculosPorPuntaje;
import modelo.vehiculo.Vehiculo;
import org.jdom.Element;

import excepciones.MovimientoFueraDeMapaException;

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
	public static String rankingPath = "persistencia/Ranking.xml";
	private Comparator unComparador;
	private List<Vehiculo> mejoresPuntajes;
	private boolean vehiculoActualizado;
	
	public Ranking(){
		this.mejoresPuntajes = new ArrayList<Vehiculo>();
		this.unComparador = new ComparadorVehiculosPorPuntaje();
		vehiculoActualizado = false;
	}

	public Ranking(List<Vehiculo> mejoresPuntajes){
		this.mejoresPuntajes = mejoresPuntajes;
		this.unComparador = new ComparadorVehiculosPorPuntaje();
		vehiculoActualizado = false;
	}
	
	public List<Vehiculo> getPuntajes() {
		// TODO Auto-generated method stub
		return this.mejoresPuntajes;
	}
		
	/**
	 * agrego el puntaje del vehiculo al ranking de manera ordenada
	 * si ya existía el piloto actualizo el puntaje y la posicion del mismo 
	 * @param unVehiculo
	 * @throws MovimientoFueraDeMapaException 
	 */
	public void agregarPuntaje(Vehiculo unVehiculo) throws MovimientoFueraDeMapaException{
		if(this.mejoresPuntajes.size()==0){
			this.mejoresPuntajes.add(unVehiculo);
		}
		else {
			for (Vehiculo puntajeJugador : mejoresPuntajes){
				if((puntajeJugador.getPiloto()) == (unVehiculo.getPiloto())){
					puntajeJugador.setPuntaje(unVehiculo.getPuntaje());
					puntajeJugador.setEstado(unVehiculo.getEstado());
					puntajeJugador.setX(unVehiculo.getX());
					puntajeJugador.setY(unVehiculo.getY());
					this.vehiculoActualizado = true;
				}
			}
				
			if(vehiculoActualizado == false){
			this.mejoresPuntajes.add(unVehiculo);
			java.util.Collections.sort(mejoresPuntajes,unComparador);
			java.util.Collections.reverse(mejoresPuntajes);
			}
		}
	}

	// BEGIN Serialización
	public Element serializarXML() {
		Element element = new Element("Ranking");
		
		for (Vehiculo puntajeJugador : mejoresPuntajes) {
			element.addContent(puntajeJugador.serializarXML());
		}
		return element;
	}
	
	public static Ranking cargarDesdeXML(Element element) {
		List<Vehiculo> puntajes = new ArrayList<Vehiculo>();
		for (Object puntajeGuardado : element.getChildren()) {
			Vehiculo mejorPuntaje = Vehiculo.cargarDesdeXML(((Element)puntajeGuardado));
			puntajes.add(mejorPuntaje);			
		}
		
		Ranking ranking = new Ranking(puntajes);
		
		return ranking;
	}
	// END Serialización
}
