package controladores;

import java.util.ArrayList;
import java.util.List;

import modelo.juego.Ranking;
import modelo.juego.Vector;
import modelo.obstaculo.Obstaculo;
import modelo.sorpresas.Sorpresa;
import modelo.vehiculo.ComparadorVehiculosPorPuntaje;
import modelo.vehiculo.Vehiculo;

import org.jdom.Attribute;
import org.jdom.Element;

public class Nivel {

	public static String nivelPath = "C:\\Persistencia\\Nivel.xml";
	
	private List<Sorpresa> sorpresas;
	private List<Obstaculo> obstaculos;
	public Nivel(){
		this.sorpresas = new ArrayList<Sorpresa>();
		this.obstaculos = new ArrayList<Obstaculo>();
	}

	
	
	
		
	/**
	 * agrego un obstaculo al nivel
	 *
	 * @param unObstaculo
	 */
	public void agregarObstaculo(Obstaculo unObstaculo){
		obstaculos.add(unObstaculo);
	}

	
	/**
	 * agrego una sorpresa al nivel
	 *
	 * @param unaSaorpresa
	 */
	public void agregarSorpresa(Sorpresa unaSorpresa){
		sorpresas.add(unaSorpresa);
	}
	
	public List<Sorpresa> getSorpresas(){
		return sorpresas;
	}
	
	public List<Obstaculo> getObstaculos(){
		return obstaculos;
	}
	
	// BEGIN Serialización
	public Element serializarXML() {
		Element element = new Element("Nivel");
		
		for (Sorpresa sorpresa : sorpresas) {
			Element entradaSorpresa = new Element("Sorpresa");
			entradaSorpresa.addContent(sorpresa.serializarXML());
			element.addContent(entradaSorpresa);
		}
		
		for (Obstaculo obstaculo : obstaculos) {
			Element entradaObstaculo = new Element("Obstaculo");
			entradaObstaculo.addContent(obstaculo.serializarXML());
			element.addContent(entradaObstaculo);
		}
		return element;
	}
	
	/*public static Ranking cargarDesdeXML(Element element) {
		List<Sorpresa> puntajes = new ArrayList<Sorpresa>();
		for (Object SorpresaGuardada : element.getChildren()) {
			Vector vector = Vector.cargarDesdeXML(element.getChild("Vector"));
			
			double puntaje = Double.parseDouble(((Element)puntajeGuardado).getAttributeValue("puntaje").toString());
			String nombreJugador = ((Element)puntajeGuardado).getAttributeValue("piloto").toString();
			Vehiculo mejorPuntaje = Vehiculo.crearConPiloto(nombreJugador, 0, 0);
			mejorPuntaje.setPuntaje(puntaje);
			
			puntajes.add(mejorPuntaje);			
		}
		
		Ranking ranking = new Ranking(puntajes);
		
		return ranking;
	}	
	// END Serialización*/
}
